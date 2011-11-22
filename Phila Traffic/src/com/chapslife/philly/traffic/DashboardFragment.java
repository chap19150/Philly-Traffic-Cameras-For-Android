package com.chapslife.philly.traffic;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.SupportActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chapslife.philly.traffic.utils.UiUtils;
import com.chapslife.philly.traffic.R;

public class DashboardFragment extends Fragment {

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_dashboard, container,false);
        
        
        // Attach event handlers
        root.findViewById(R.id.home_btn_pa).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //fireTrackerEvent("Schedule");
                if (UiUtils.isHoneycombTablet(getActivity())) {
                    //startActivity(new Intent(getActivity(), ScheduleMultiPaneActivity.class));
                } else {
                	mListener.onButtonSelected("PA");
                }
            }
        });
        
        root.findViewById(R.id.home_btn_nj).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //fireTrackerEvent("Schedule");
                if (UiUtils.isHoneycombTablet(getActivity())) {
                    //startActivity(new Intent(getActivity(), ScheduleMultiPaneActivity.class));
                } else {
                	mListener.onButtonSelected("NJ");
                }
            }
        });
        
        root.findViewById(R.id.home_btn_de).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //fireTrackerEvent("Schedule");
                if (UiUtils.isHoneycombTablet(getActivity())) {
                    //startActivity(new Intent(getActivity(), ScheduleMultiPaneActivity.class));
                } else {
                	mListener.onButtonSelected("DE");
                }
            }
        });
        
        root.findViewById(R.id.home_btn_gas).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //fireTrackerEvent("Schedule");
                if (UiUtils.isHoneycombTablet(getActivity())) {
                    //startActivity(new Intent(getActivity(), ScheduleMultiPaneActivity.class));
                } else {
                	mListener.onButtonSelected("GAS");
                }
            }
        });
        
        root.findViewById(R.id.home_btn_alert).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                //fireTrackerEvent("Schedule");
                if (UiUtils.isHoneycombTablet(getActivity())) {
                    //startActivity(new Intent(getActivity(), ScheduleMultiPaneActivity.class));
                } else {
                	mListener.onButtonSelected("ALERT");
                }
            }
        });
        
        root.findViewById(R.id.home_btn_favorites).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            	if(UiUtils.isProVersion()){
            		//fireTrackerEvent("Schedule");
                    if (UiUtils.isHoneycombTablet(getActivity())) {
                        //startActivity(new Intent(getActivity(), ScheduleMultiPaneActivity.class));
                    } else {
                    	mListener.onButtonSelected("FAVORITES");
                    }
            	}else{
            		final AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
            		alertDialog.setTitle("Pro Version");
		    		alertDialog.setMessage("Must buy Pro Version to use this feature!");
		    		alertDialog.setButton("Cancel", new DialogInterface.OnClickListener() {
		    		      public void onClick(DialogInterface dialog, int which) {
		    		    	  alertDialog.dismiss();
		    		    	  return;
		    		 
		    		      } 
		    		});
		    		alertDialog.show();  
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
    public void onAttach(SupportActivity activity) {
    	super.onAttach(activity);
        try {
            mListener = (OnButtonSelectedListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnButtonSelectedListener");
        }
    }
}
