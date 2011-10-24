package com.chapslife.philly.traffic;

import com.chapslife.philly.traffic.DashboardFragment.OnButtonSelectedListener;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;

public class HomeActivity extends FragmentActivity implements OnButtonSelectedListener{

	private DashboardFragment dashboardFragment;
	private MobclixFragment mobclixFragment;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        
        dashboardFragment = new DashboardFragment();
        fragmentTransaction.add(R.id.fragment_container, dashboardFragment);
        
        mobclixFragment = new MobclixFragment();
        fragmentTransaction.add(R.id.fragment_mobclix, mobclixFragment);
        
        fragmentTransaction.commit();
	}
	
	public void switchPhilly(){
		Fragment phillyFragment = new PAExpandableFragment();
		FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
		
		transaction.replace(R.id.fragment_container, phillyFragment);
		transaction.addToBackStack(null);
		transaction.commit();
	}

	public void onButtonSelected(String type) {
		if (type.equalsIgnoreCase("Alert")){
			switchPhilly();
		}
		
	}
}
