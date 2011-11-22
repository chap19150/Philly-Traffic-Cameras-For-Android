package com.chapslife.philly.traffic;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.MenuItem;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.FrameLayout;

import com.chapslife.philly.traffic.AlertsFragment;
import com.chapslife.philly.traffic.DEExpandableFragment;
import com.chapslife.philly.traffic.DashboardFragment;
import com.chapslife.philly.traffic.DashboardFragment.OnButtonSelectedListener;
import com.chapslife.philly.traffic.FavoritesFragment;
import com.chapslife.philly.traffic.GasFragment;
import com.chapslife.philly.traffic.ImageViewFragment;
import com.chapslife.philly.traffic.MobclixFragment;
import com.chapslife.philly.traffic.NJExpandableFragment;
import com.chapslife.philly.traffic.PAExpandableFragment;
import com.chapslife.philly.traffic.interfaces.OnCameraSelecterListener;
import com.chapslife.philly.traffic.utils.LocationFinder;
import com.chapslife.philly.traffic.utils.UiUtils;

public class HomeActivity extends FragmentActivity implements OnButtonSelectedListener, OnCameraSelecterListener{

	public final static String URL="com.chapslife.philly.traffic.HomeActivity._ID";
    public final static String HEADER="com.chapslife.philly.traffic.HomeActivity._HEADER";
    public final static String HACK="com.chapslife.philly.traffic.HomeActivity._HACK";
    public final static String MYDELAY="com.chapslife.philly.traffic.HomeActivity._DELAY";
    public final static String WHICHCAM="com.chapslife.philly.traffic.HomeActivity._WHICHCAM";
    private static final String LOG_TAG = HomeActivity.class.getSimpleName();
    
	private DashboardFragment dashboardFragment;
	private MobclixFragment mobclixFragment;
	private FragmentTransaction transaction;
	private String preferred;
	private LocationManager mgr;
	private Boolean isDashboardShowing = true;
	private Boolean isCameraShowing = false;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        String mURL = getIntent().getStringExtra(URL);
        
        final ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayUseLogoEnabled(true);
        actionBar.setDisplayShowTitleEnabled(false);
        actionBar.setDisplayShowHomeEnabled(true);
        
        transaction = getSupportFragmentManager().beginTransaction();
        
        dashboardFragment = new DashboardFragment();
        transaction.add(R.id.fragment_container, dashboardFragment);
        if(UiUtils.isProVersion()){
        	FrameLayout fm = (FrameLayout)findViewById(R.id.fragment_mobclix);
        	fm.setVisibility(View.GONE);
        }else{
        	mobclixFragment = new MobclixFragment();
            transaction.add(R.id.fragment_mobclix, mobclixFragment);
        }
        
        transaction.commit();
        
        transaction.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        
        isDashboardShowing = true;
        		
        LocationFinder lf = new LocationFinder(this);
        Location location = lf.getGPS();
        if(location != null){
			lat = location.getLatitude();
			lon = location.getLongitude();
		}
        
        if(mURL != null){
        	if (preferred != null) {
    			mgr.removeUpdates((LocationListener) this);
    		}
        	String title = getIntent().getStringExtra(HEADER);
            int delay = getIntent().getIntExtra(MYDELAY, 5000);
            String state = getIntent().getStringExtra(WHICHCAM);
            viewImage(mURL, title, delay, state);
        }
	}
	
	
	public void switchPhilly(String _state){
		isDashboardShowing = false;
		transaction = getSupportFragmentManager().beginTransaction();
		transaction.hide(dashboardFragment);
		if (preferred != null) {
			mgr.removeUpdates((LocationListener) this);
		}
		Log.d("LATs",String.valueOf(lat)); 
		if (_state.equalsIgnoreCase("PA")){
			Fragment phillyFragment = new PAExpandableFragment();
			
			transaction.replace(R.id.fragment_container, phillyFragment);
		}else if (_state.equalsIgnoreCase("NJ")){
			Fragment njFragment = new NJExpandableFragment();
			transaction.replace(R.id.fragment_container, njFragment);
		}else if (_state.equalsIgnoreCase("DE")){
			Fragment deFragment = new DEExpandableFragment();
			transaction.replace(R.id.fragment_container, deFragment);
		}else if (_state.equalsIgnoreCase("GAS")){
			Fragment gasFragment = new GasFragment(lat,lon);
			transaction.replace(R.id.fragment_container, gasFragment);
		}else if (_state.equalsIgnoreCase("ALERT")){
			Fragment alertsFragment = new AlertsFragment();
			transaction.replace(R.id.fragment_container, alertsFragment);
		}else if (_state.equalsIgnoreCase("FAVORITES")){
			Fragment favoritesFragment = new FavoritesFragment();
			transaction.replace(R.id.fragment_container, favoritesFragment);
		}
		
		//transaction.addToBackStack(null);
		transaction.commit();
	}

	public void viewImage(String _url, String _title, int _delay, String _state){
		if (preferred != null) {
			mgr.removeUpdates((LocationListener) this);
		}
		Fragment imageFragment = new ImageViewFragment(_url, _title, _delay, _state);
		transaction = getSupportFragmentManager().beginTransaction();
		
		transaction.replace(R.id.fragment_container, imageFragment);
		transaction.addToBackStack(null);
		transaction.commit();
		isDashboardShowing = false;
		isCameraShowing = true;
	}
	public void onButtonSelected(String state) {
		switchPhilly(state);
		
	}

	public void onCameraSelected(String _url, String _title, int _delay,
			String _state) {
		viewImage(_url, _title, _delay, _state);
		
	}

	public boolean onKeyDown(int keyCode, KeyEvent event) {
	    if (keyCode == KeyEvent.KEYCODE_BACK) {

	    	if(!isDashboardShowing){
	    		if(isCameraShowing){
	    			isCameraShowing = false;
	    			getSupportFragmentManager().popBackStack();
	    		}else{
	    			isDashboardShowing = true;
	    			dashboardFragment = new DashboardFragment();
	        		transaction = getSupportFragmentManager().beginTransaction();	 
	                transaction.replace(R.id.fragment_container, dashboardFragment);
	                transaction.commit();
	    		}
        		
        	}else{
        		finish();
        	}

	        return true;
	    }
	    return super.onKeyDown(keyCode, event);
	}
	
	protected double lat;
	protected double lon;

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    switch (item.getItemId()) {
	        case android.R.id.home:
	        	if(!isDashboardShowing){
	        		isDashboardShowing = true;
	        		dashboardFragment = new DashboardFragment();
	        		transaction = getSupportFragmentManager().beginTransaction();	                
	                transaction.replace(R.id.fragment_container, dashboardFragment);
	                transaction.commit();
	        	}
	            
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}

}
