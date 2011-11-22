package com.chapslife.philly.traffic.adapters;

import android.R.anim;
import android.util.Log;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.mobclix.android.sdk.MobclixAdView;
import com.mobclix.android.sdk.MobclixAdViewListener;

public class MobclixListener implements MobclixAdViewListener {

	private static final String LOG_TAG = MobclixListener.class.getSimpleName();
	
	public String keywords() {
		return "travel,philadelphia,pennsylvania,delaware,new jersey,traffic,car,philly,insurance,vehicle,truck,road,driving";
	}

	public void onAdClick(MobclixAdView arg0) {
		// TODO Auto-generated method stub
		
	}

	public void onCustomAdTouchThrough(MobclixAdView arg0, String arg1) {
		// TODO Auto-generated method stub
		
	}

	public void onFailedLoad(MobclixAdView mView, int arg1) {
		LinearLayout layout = (LinearLayout) mView.getParent();
		if (layout.getVisibility() == View.VISIBLE){
			layout.setVisibility(View.GONE);
			Log.i(LOG_TAG, "ADVIEW GONE");
		}
	}

	public boolean onOpenAllocationLoad(MobclixAdView arg0, int arg1) {
		// TODO Auto-generated method stub
		return false;
	}

	public void onSuccessfulLoad(MobclixAdView mView) {
		LinearLayout layout = (LinearLayout) mView.getParent();
		if (layout.getVisibility() == View.GONE){
			Log.i(LOG_TAG, "ADVIEW VISIBLE");
			layout.setVisibility(View.VISIBLE);
		}
	}

	public String query() {
		// TODO Auto-generated method stub
		return null;
	}

}
