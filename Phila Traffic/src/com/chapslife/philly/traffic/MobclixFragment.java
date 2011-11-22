package com.chapslife.philly.traffic;

import com.chapslife.philly.traffic.adapters.MobclixListener;
import com.chapslife.philly.traffic.R;
import com.mobclix.android.sdk.MobclixAdView;
import com.mobclix.android.sdk.MobclixMMABannerXLAdView;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;


public class MobclixFragment extends Fragment {

	private MobclixAdView adview;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_adview, container, false);
        
        LinearLayout layout = (LinearLayout)root.findViewById(R.id.adview_linear);
        adview  = new MobclixMMABannerXLAdView(getActivity());
        layout.addView(adview);
        layout.setVisibility(View.GONE);
        adview.addMobclixAdViewListener(new MobclixListener());
        adview.setBackgroundColor(Color.WHITE);
        adview.setInAnimation(adview.getContext(), android.R.anim.slide_in_left);
        adview.setOutAnimation(adview.getContext(), android.R.anim.slide_out_right);
        return root;
	}
	
	@Override
	public void onPause(){
		super.onPause();
		adview.pause();
	}
	
	@Override
	public void onResume(){
		super.onResume();
		adview.resume();
	}
}
