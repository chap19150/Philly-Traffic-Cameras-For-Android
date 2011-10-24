package com.chapslife.philly.traffic;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chapslife.philly.traffic.utils.UiUtils;

public class DashboardFragment extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container,false);
        
        
        // Attach event handlers
        root.findViewById(R.id.home_btn_alert).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //fireTrackerEvent("Schedule");
                if (UiUtils.isHoneycombTablet(getActivity())) {
                    //startActivity(new Intent(getActivity(), ScheduleMultiPaneActivity.class));
                } else {
                	mListener.onButtonSelected("Alert");
                }
            }
        });
        return root;
	}
	
	OnButtonSelectedListener mListener;
	
	// Container Activity must implement this interface
    public interface OnButtonSelectedListener {
        public void onButtonSelected(String type);
    }
    
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnButtonSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnButtonSelectedListener");
        }
    }
}
