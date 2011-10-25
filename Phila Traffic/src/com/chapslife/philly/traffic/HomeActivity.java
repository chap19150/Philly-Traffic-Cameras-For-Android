package com.chapslife.philly.traffic;

import com.chapslife.philly.traffic.DashboardFragment.OnButtonSelectedListener;
import com.chapslife.philly.traffic.PAExpandableFragment.OnCameraSelectedListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class HomeActivity extends FragmentActivity implements OnButtonSelectedListener, OnCameraSelectedListener{

	private DashboardFragment dashboardFragment;
	private MobclixFragment mobclixFragment;
	private FragmentTransaction transaction;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        transaction = getSupportFragmentManager().beginTransaction();
        
        dashboardFragment = new DashboardFragment();
        transaction.add(R.id.fragment_container, dashboardFragment);
        
        mobclixFragment = new MobclixFragment();
        transaction.add(R.id.fragment_mobclix, mobclixFragment);
        
        transaction.commit();
	}
	
	public void switchPhilly(){
		Fragment phillyFragment = new PAExpandableFragment();
		transaction = getSupportFragmentManager().beginTransaction();
		
		transaction.replace(R.id.fragment_container, phillyFragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}

	public void viewImage(String _url){
		Fragment imageFragment = new ImageViewFragment(_url);
		transaction = getSupportFragmentManager().beginTransaction();
		
		transaction.replace(R.id.fragment_container, imageFragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}
	public void onButtonSelected(String type) {
		if (type.equalsIgnoreCase("Alert")){
			switchPhilly();
		}
		
	}

	public void onCameraSelected(String _url) {
		viewImage(_url);
	}
}
