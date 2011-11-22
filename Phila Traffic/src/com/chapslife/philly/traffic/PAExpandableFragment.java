package com.chapslife.philly.traffic;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.SupportActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

import com.chapslife.philly.traffic.adapters.InfoDetailsAdapter;
import com.chapslife.philly.traffic.interfaces.OnCameraSelecterListener;
import com.chapslife.philly.traffic.R;

public class PAExpandableFragment extends Fragment{

	private ArrayList<String> paGroup;
	private ArrayList<List<String>> paChild;
	private ExpandableListView paEpView;
	private InfoDetailsAdapter paAdapter;
	private String title;
	protected String mURL;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_expandablelist, container,false);
        LinearLayout layout = (LinearLayout) root.findViewById(R.id.expandable_list);
        paEpView = new ExpandableListView(getActivity());
        initialPAData();
        setupPAView();
        layout.addView(paEpView);
        
        return root;
	}
	
	private void setupPAView() {
		paAdapter = new InfoDetailsAdapter(getActivity(),paGroup,paChild);
		paEpView.setAdapter(paAdapter);
		paEpView.setFastScrollEnabled(true);
		paEpView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

			public boolean onChildClick(ExpandableListView parent,
                    View v, int groupPosition, int childPosition,
                    long id) {
				title = paAdapter.getChild(groupPosition, childPosition).toString();
				if (groupPosition == 0) {
                	if (childPosition == 0){
                		//mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM082&framerate=1";
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam093.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam094.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam095.jpg";
        			}else if (childPosition == 3){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam096.jpg";
        			}else if (childPosition == 4){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam097.jpg";
        			}else if (childPosition == 5){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam098.jpg";
        			}else if (childPosition == 6){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam099.jpg";
        			}else if (childPosition == 7){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam100.jpg";        				
        			}else if (childPosition == 8){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam101.jpg";
        			}else if (childPosition == 9){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam074.jpg";
        			}else if (childPosition == 10){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam133.jpg";
        			}else if (childPosition == 11){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam134.jpg";
        			}else if (childPosition == 12){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam135.jpg";
        			}else if (childPosition == 13){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam136.jpg";
        			}else if (childPosition == 14){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam137.jpg";        				
        			}else if (childPosition == 15){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam138.jpg";
        			}else if (childPosition == 16){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam139.jpg";
        			}else if (childPosition == 17){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam140.jpg";
        			}else if (childPosition == 18){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam141.jpg";
        			}else if (childPosition == 19){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam142.jpg";        				
        			}else if (childPosition == 20){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam143.jpg";
        			}else if (childPosition == 21){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam144.jpg";
        			}else if (childPosition == 22){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam145.jpg";
        			}else if (childPosition == 23){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam146.jpg";
        			}else if (childPosition == 24){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam147.jpg";        				
        			}else if (childPosition == 25){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam148.jpg";
        			}else if (childPosition == 26){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam149.jpg";
        			}else if (childPosition == 27){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam150.jpg";
        			}else if (childPosition == 28){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam151.jpg";
        			}else if (childPosition == 29){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam152.jpg";        				
        			}else if (childPosition == 30){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam153.jpg";
        			}else if (childPosition == 31){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam154.jpg";
        			}else if (childPosition == 32){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam155.jpg";
        			}else if (childPosition == 33){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam156.jpg";
        			}else if (childPosition == 34){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam157.jpg";        				
        			}else if (childPosition == 35){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam158.jpg";
        			}else if (childPosition == 36){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam159.jpg";
        			}else if (childPosition == 37){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam161.jpg";
        			}else if (childPosition == 38){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam173.jpg";
        			}else if (childPosition == 39){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam174.jpg";        				
        			}else if (childPosition == 40){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam175.jpg";
        			}else if (childPosition == 41){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam176.jpg";        				
        			}
                }else if (groupPosition == 1) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam102.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam103.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam104.jpg";
        			}else if (childPosition == 3){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam105.jpg";
        			}else if (childPosition == 4){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam106.jpg";
        			}else if (childPosition == 5){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam107.jpg";
        			}else if (childPosition == 6){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam108.jpg";
        			}else if (childPosition == 7){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam109.jpg";        				
        			}else if (childPosition == 8){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam110.jpg";
        			}else if (childPosition == 9){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam111.jpg";
        			}else if (childPosition == 10){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam112.jpg";
        			}else if (childPosition == 11){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam113.jpg";
        			}else if (childPosition == 12){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam114.jpg";
        			}else if (childPosition == 13){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam115.jpg";
        			}else if (childPosition == 14){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam116.jpg";        				
        			}else if (childPosition == 15){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam117.jpg";
        			}else if (childPosition == 16){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam001.jpg";
        			}else if (childPosition == 17){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam002.jpg";
        			}else if (childPosition == 18){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam003.jpg";
        			}else if (childPosition == 19){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam004.jpg";        				
        			}else if (childPosition == 20){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam005.jpg";
        			}else if (childPosition == 21){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam006.jpg";
        			}else if (childPosition == 22){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam007.jpg";
        			}else if (childPosition == 23){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam008.jpg";
        			}else if (childPosition == 24){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam009.jpg";        				
        			}else if (childPosition == 25){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam010.jpg";
        			}else if (childPosition == 26){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam093.jpg";
        			}else if (childPosition == 27){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam026.jpg";
        			}else if (childPosition == 28){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam027.jpg";
        			}
                }else if (groupPosition == 2) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam011.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam012.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam013.jpg";
        			}else if (childPosition == 3){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam014.jpg";
        			}else if (childPosition == 4){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam015.jpg";
        			}else if (childPosition == 5){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam016.jpg";
        			}else if (childPosition == 6){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam017.jpg";
        			}else if (childPosition == 7){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam018.jpg";        				
        			}else if (childPosition == 8){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam019.jpg";
        			}else if (childPosition == 9){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam020.jpg";
        			}else if (childPosition == 10){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam021.jpg";
        			}else if (childPosition == 11){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam022.jpg";
        			}else if (childPosition == 12){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam023.jpg";
        			}else if (childPosition == 13){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam024.jpg";
        			}else if (childPosition == 14){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam122.jpg";        				
        			}else if (childPosition == 15){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam123.jpg";
        			}else if (childPosition == 16){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam124.jpg";
        			}else if (childPosition == 17){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam125.jpg";
        			}else if (childPosition == 18){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam196.jpg";
        			}else if (childPosition == 19){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam197.jpg";        				
        			}else if (childPosition == 20){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam198.jpg";
        			}else if (childPosition == 21){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam199.jpg";
        			}else if (childPosition == 22){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam200.jpg";
        			}else if (childPosition == 23){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam201.jpg";
        			}else if (childPosition == 24){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam202.jpg";        				
        			}else if (childPosition == 25){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam203.jpg";
        			}else if (childPosition == 26){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam204.jpg";
        			}else if (childPosition == 27){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam205.jpg";
        			}else if (childPosition == 28){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam206.jpg";
        			}else if (childPosition == 29){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam207.jpg";
        			}else if (childPosition == 30){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam208.jpg";
        			}else if (childPosition == 31){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam209.jpg";
        			}
                }else if (groupPosition == 3) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam028.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam029.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam030.jpg";
        			}else if (childPosition == 3){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam031.jpg";
        			}else if (childPosition == 4){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam032.jpg";
        			}else if (childPosition == 5){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam033.jpg";
        			}else if (childPosition == 6){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam034.jpg";
        			}else if (childPosition == 7){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam035.jpg";        				
        			}else if (childPosition == 8){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam036.jpg";
        			}else if (childPosition == 9){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam037.jpg";
        			}else if (childPosition == 10){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam039.jpg";
        			}
                }else if (groupPosition == 4) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam162.jpg";
        			}
                }else if (groupPosition == 5) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam118.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam120.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam121.jpg";
        			}else if (childPosition == 3){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam119.jpg";
        			}else if (childPosition == 4){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam179.jpg";
        			}else if (childPosition == 5){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam180.jpg";
        			}else if (childPosition == 6){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam181.jpg";
        			}else if (childPosition == 7){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam182.jpg";        				
        			}else if (childPosition == 8){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam183.jpg";
        			}else if (childPosition == 9){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam184.jpg";
        			}else if (childPosition == 10){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam190.jpg";
        			}else if (childPosition == 11){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam191.jpg";
        			}else if (childPosition == 12){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam192.jpg";
        			}else if (childPosition == 13){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam193.jpg";
        			}else if (childPosition == 14){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam194.jpg";        				
        			}else if (childPosition == 15){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam195.jpg";
        			}else if (childPosition == 16){
        				mURL = "http://164.156.16.43/public/Districts/District5/WebCams/Rt309&TilghmanStreet.jpg";
        			}
                }else if (groupPosition == 6) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam126.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam127.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam128.jpg";
        			}else if (childPosition == 3){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam129.jpg";
        			}else if (childPosition == 4){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam130.jpg";
        			}else if (childPosition == 5){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam131.jpg";
        			}else if (childPosition == 6){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam132.jpg";
        			}else if (childPosition == 7){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam177.jpg";        				
        			}else if (childPosition == 8){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam178.jpg";
        			}
                }else if (groupPosition == 7) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam166.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam167.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam168.jpg";
        			}else if (childPosition == 3){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam169.jpg";
        			}else if (childPosition == 4){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam170.jpg";
        			}else if (childPosition == 5){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam171.jpg";
        			}else if (childPosition == 6){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam172.jpg";
        			}
                }else if (groupPosition == 8) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam210.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam211.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam212.jpg";
        			}
                }else if (groupPosition == 9) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam075.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam076.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam077.jpg";
        			}else if (childPosition == 3){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam078.jpg";
        			}else if (childPosition == 4){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam079.jpg";
        			}else if (childPosition == 5){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam080.jpg";
        			}else if (childPosition == 6){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam081.jpg";
        			}else if (childPosition == 7){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District8/WebCams/img_CCTV_30-NS_mpu001_ch0.jpg";        				
        			}else if (childPosition == 8){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District8/WebCams/img_CCTV_30-WEST_mpu001_ch0.jpg";
        			}else if (childPosition == 9){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District8/WebCams/img_CCTV_30-283_mpu001_ch0.jpg";
        			}else if (childPosition == 10){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District8/WebCams/img_CCTV_30-501_mpu001_ch0.jpg";
        			}
                }else if (groupPosition == 10) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam092.jpg";
        			}
                }else if (groupPosition == 11) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam040.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam041.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam042.jpg";
        			}else if (childPosition == 3){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam043.jpg";
        			}else if (childPosition == 4){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam044.jpg";
        			}else if (childPosition == 5){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam045.jpg";
        			}else if (childPosition == 6){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam046.jpg";
        			}else if (childPosition == 7){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam047.jpg";        				
        			}else if (childPosition == 8){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam048.jpg";
        			}else if (childPosition == 9){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam049.jpg";
        			}else if (childPosition == 10){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam050.jpg";
        			}else if (childPosition == 11){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam051.jpg";
        			}else if (childPosition == 12){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam052.jpg";
        			}else if (childPosition == 13){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam053.jpg";
        			}else if (childPosition == 14){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam054.jpg";        				
        			}else if (childPosition == 15){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam055.jpg";
        			}else if (childPosition == 16){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam056.jpg";
        			}else if (childPosition == 17){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam057.jpg";
        			}else if (childPosition == 18){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam058.jpg";
        			}else if (childPosition == 19){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam059.jpg";        				
        			}else if (childPosition == 20){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam060.jpg";
        			}else if (childPosition == 21){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam061.jpg";
        			}else if (childPosition == 22){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam062.jpg";
        			}else if (childPosition == 23){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam063.jpg";
        			}else if (childPosition == 24){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam064.jpg";        				
        			}else if (childPosition == 25){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam065.jpg";
        			}else if (childPosition == 26){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam066.jpg";
        			}else if (childPosition == 27){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam067.jpg";
        			}else if (childPosition == 28){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam068.jpg";
        			}else if (childPosition == 29){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam069.jpg";
        			}else if (childPosition == 30){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam070.jpg";
        			}else if (childPosition == 31){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam071.jpg";
        			}else if (childPosition == 32){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam072.jpg";
        			}else if (childPosition == 33){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam073.jpg";
        			}
                }else if (groupPosition == 12) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam082.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam083.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam084.jpg";
        			}else if (childPosition == 3){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam085.jpg";
        			}else if (childPosition == 4){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam086.jpg";
        			}else if (childPosition == 5){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam087.jpg";
        			}else if (childPosition == 6){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam088.jpg";
        			}else if (childPosition == 7){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam089.jpg";        				
        			}else if (childPosition == 8){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam090.jpg";
        			}else if (childPosition == 9){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam091.jpg";
        			}
                }else if (groupPosition == 13) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam164.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam165.jpg";
        			}
                }else if (groupPosition == 14) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam160.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam163.jpg";
        			}
                }else if (groupPosition == 15) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam213.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam214.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam215.jpg";
        			}else if (childPosition == 3){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam216.jpg";
        			}else if (childPosition == 4){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam217.jpg";
        			}else if (childPosition == 5){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam218.jpg";
        			}else if (childPosition == 6){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam219.jpg";
        			}else if (childPosition == 7){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam220.jpg";        				
        			}else if (childPosition == 8){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam221.jpg";
        			}else if (childPosition == 9){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam222.jpg";
        			}else if (childPosition == 10){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam223.jpg";
        			}else if (childPosition == 11){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam224.jpg";
        			}
                }else if (groupPosition == 16) {
                	if (childPosition == 0){
                		mURL = "http://www.paturnpike.com/webmap/1_devices/cam160109.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.paturnpike.com/webmap/1_devices/cam160101.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.paturnpike.com/webmap/1_devices/cam160108.jpg";
        			}else if (childPosition == 3){
        				mURL = "http://www.paturnpike.com/webmap/1_devices/cam160102.jpg";
        			}else if (childPosition == 4){
        				mURL = "http://www.paturnpike.com/webmap/1_devices/cam160107.jpg";
        			}
                }else if (groupPosition == 17) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/I78&Rt100.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/I78&CedarCrestBlvd.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/I78&Rt145.jpg";
        			}else if (childPosition == 3){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/I78&Rt22Split.jpg";
        			}else if (childPosition == 4){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/I78&LehighStreet.jpg";
        			}else if (childPosition == 5){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/I78&Rt412.jpg";
        			}else if (childPosition == 6){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/I78&Rt222.jpg";
        			}else if (childPosition == 7){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/I78&Rt33.jpg";        				
        			}else if (childPosition == 8){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/I78&MorganHill.jpg";
        			}else if (childPosition == 9){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/D5cam029.jpg";
        			}else if (childPosition == 10){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/D5cam028.jpg";
        			}else if (childPosition == 11){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/D5cam027.jpg";
        			}else if (childPosition == 12){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/D5cam026.jpg";
        			}else if (childPosition == 13){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/D5cam025.jpg";
        			}
                }else if (groupPosition == 18) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/D5cam033.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/D5cam034.jpg";
        			}
                }else if (groupPosition == 19) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/D5cam032.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/D5cam031.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/D5cam030.jpg";
        			}
                }else if (groupPosition == 20) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/D5cam035.jpg";
        			}
                }else if (groupPosition == 21) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/Rt22&15thStreet.jpg";
        			}else if (childPosition == 1){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/Rt22&Rt309.jpg";
        			}else if (childPosition == 2){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/Rt22&CedarCrest.jpg";
        			}else if (childPosition == 3){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/Rt22&Rt145.jpg";
        			}else if (childPosition == 4){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/Rt22&AirportRoad.jpg";
        			}else if (childPosition == 5){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/Rt22&FullertonAve.jpg";
        			}else if (childPosition == 6){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/Rt22&SchoenersvilleRoad.jpg";
        			}else if (childPosition == 7){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/Rt22&Rt512.jpg";        				
        			}else if (childPosition == 8){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/Rt22&Rt191.jpg";
        			}else if (childPosition == 9){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/Rt22&Rt33.jpg";
        			}else if (childPosition == 10){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/Rt22&4th.jpg";
        			}else if (childPosition == 11){
        				mURL = "http://www.dot35.state.pa.us/public/Districts/District6/WebCams/D6Cam224.jpg";
        			}
                }else if (groupPosition == 22) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/Rt.22EBWB.jpg";
        			}
                }else if (groupPosition == 23) {
                	if (childPosition == 0){
                		mURL = "http://www.dot35.state.pa.us/public/Districts/District5/WebCams/Rt33&Rt248.jpg";
        			}
                }
				mListener.onCameraSelected(mURL,title,5000,"PA");
				return false; 
			}
			
		});
	}
	
	OnCameraSelecterListener mListener;
	
	/*// Container Activity must implement this interface
    public interface OnCameraSelectedListener {
        public void onCameraSelected(String _url, String _title);
    }*/
    
    @Override
    public void onAttach(SupportActivity activity) {
    	super.onAttach(activity);
        try {
            mListener = (OnCameraSelecterListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCameraSelectedListener");
        }
    }
    
	public void initialPAData(){  
        paGroup = new ArrayList<String>();  
          
        paChild = new ArrayList<List<String>>();  
         //0 
        addInfo("Interstate 76", new String[]{"I-76 EB W of Croton",
        		"I-76 EB Weadley Rd",
        		"I-76 WB W of Gypsy Rd",
        		"I-76 EB @ Gulph Mills",
        		"I-76 WB @ Mile Marker 330.6",
        		"I-76 EB W of Matsnfrd",
        		"I-76 WB @ Mile Marker 332",
        		"I-76 EB@Mile Marker 332.6",
        		"I-76 WB Consh Crve",
        		"I-76 EB Ramp to US 202/422",
        		"I-76 EB West of Gladwyne",
        		"I-76 WB West of Gladwyne",
        		"I-76 WB East of Gladwyne",
        		"I-76 WB West of Belmont",
        		"I-76 EB @ Belmont",
        		"I-76 WB East of Belmonte",
        		"I-76 WB @ City Ave",
        		"I-76 EB @ City Ave",
        		"I-76 EB @ US1",
        		"I-76 EB Ramp to US1 N",
        		"I-76 WB West of Montgomery Dr",
        		"I-76 EB @ Montgomery",
        		"I-76 EB East of Montgomery",
        		"I-76 EB West of Girard",
        		"I-76 EB @ Girard",
        		"I-76 WB East of Girard",
        		"I-76 EB West of Spring Garden",
        		"I-76 WB Spring Garden",
        		"I-76 EB @ I-676",
        		"I-76 WB East of I-676",
        		"I-76 WB @ 30th St",
        		"I-76 WB West of South Street",
        		"I-76 EB East of South Street",
        		"I-76 EB @ University Ave",
        		"I-76 EB East of Grays Ferry",
        		"I-76 EB @ Vare Ave",
        		"I-76 EB Ramp to Passyunk Ave",
        		"I-76 EB to 26th Street",
        		"I-76 WB @ I476 Interchange",
        		"I-76 WB @ Conshohocken Curve",
        		"I-76 EB West of Waverly",
        		"I-76 EB East of Waverly",
        		});  

        //1
        addInfo("Interstate 95",new String[]{"I-95 NB-95 Indiana St",
        		"I-95 NB-95 Castor Ave",
        		"I-95 SB-95 Betsy Ross",
        		"I-95 SB-95 Wakelng St",
        		"I-95 NB-95 Vankirk",
        		"I-95 SB-95 Disston St",
        		"I-95 NB-95 N of COTMN",
        		"I-95 SB-95 Penny Pack",
        		"I-95 NB-95 S of Amtrak",
        		"I-95 SB-95 Academy Rd",
        		"I-95 NB-95 Convent Av",
        		"I-95 SB-95 Mil Rd",
        		"I-95- 895 Tennis Ave",
        		"I-95 NB-Ramp to PA 63",
        		"I-95 SB- 95 Woodhaven",
        		"I-95 NB-95 Station Av",
        		"I-95 SB Island Airport",
        		"I-95 SB-EnterPR/Bart",
        		"I-95 SB-Broad St.",
        		"I-95 NB /WWB Packer",
        		"I-95 SB-Packer/Front",
        		"I-95 SB-Tasker/Reed",
        		"I-95 Wash/Columbus",
        		"I-95 SB-Girard Ave",
        		"I-95 SB-Aramingo/Gir",
        		"I-95 NB Ramp to I-76 North",
        		"I-95 NB 95@Vine Exp/BF Bridge",
        		"I-95 NB 95@Race St.",
        		"I-95 SB @Vine/Callowhill"});  
        //2
        addInfo("Interstate 476",new String[]{"I-476 NB-North of US 1",
        		"I-476 NB-Reed Rd",
        		"I-476 NB-Blue Rt :7.4",
        		"I-476 NB- Lawrence Rd:8.1",
        		"I-476 SB-US 30 RMP:13",
        		"I-476-US 30/Exit #13",
        		"I-476 SB CNTY Ln:13.9",
        		"I-476 SB No of Cnty LN",
        		"I-476 NB Blue Rt:15.1",
        		"I-476 NB @ I-76/Exit 16B",
        		"I-476 SB SCHKL R BRDG",
        		"I-476 NB Access Rd BRDG",
        		"I-476 SB S of Ridge PK",
        		"I-476 NB N of Ridge PK",
        		"I-476 McDade on Ramp",
        		"I-476 SB @ Mcdade Blvd/Exit 1",
        		"I-476 SB @Balt Pike",
        		"I-476 SB @ US1",
        		"I-476 NB N of Bullend Ln",
        		"I-476 SB N of PA320",
        		"I-476 SB@SEPTA Overpass",
        		"I-476 NB S of Plush Mill Rd",
        		"I-476 NB N of Beatty Rd",
        		"I-476 SB S of West Chester Pike",
        		"I-476 NB N of West Chester Pike",
        		"I-476 SB S of Marple Rd",
        		"I-476 NB S of Darby Rd",
        		"I-476 SB S of Bryn Mawr Ave",
        		"I-476 SB@Clyde Rd",
        		"I-476 SB @ Conestoge Rd",
        		"I-476 SB @ Ridge Pike",
        		"I-476 Ramp from Germantown Pike"}); 
        //3
        addInfo("PA Route 100",new String[]{"PA 100 NB @ Phoenixville",
        		"PA 100 NB BEF Kirkland",
        		"PA 100 SB AFT BOOT RD",
        		"PA 100 SB AFT Pottstown",
        		"PA 100 NB BEF MTN View",
        		"PA 100 NB @ SR3070",
        		"PA 100 NB @Sunrise BLVD",
        		"PA 100 NB BEF SHIP RD",
        		"PA 100 NB @Worthington",
        		"PA 100 SB AFT PA 113",
        		"PA 100 NB @PA Turnpike"});  
        //4
        addInfo("PA Route 291",new String[]{"PA 291 WB E of I-76"});
        //5
        addInfo("PA Route 309",new String[]{"PA 309 SB @ Easton Rd",
        		"PA 309 NB @Susquehanna",
        		"PA 309 NB @ Beth PK Mrg",
        		"Rt 309NB@PA Turnpike",
        		"RT309 NB @ Waverly Rd",
        		"RT309 NB S of Papermill Rd",
        		"RT309 SB @ Papermill Rd",
        		"RT309 SB @ Church Rd",
        		"RT309 SB S of Turnpike",
        		"RT309 NB N of Turnpike",
        		"RT309 SB @ English Village",
        		"RT309 SB N of Hartman Rd",
        		"RT309 NB @ Stump Rd",
        		"RT309 NB @ US 202",
        		"RT309 SB @ North Wales Rd",
        		"RT309 NB @ Five Points",
        		"Rt.309 & Tilghman St."});
        //6
        addInfo("PA Route 676",new String[]{"I-676WB 676@24th St",
        		"I-676EB 676@Ben Franklin Pkwy",
        		"I-676WB 676@20th St",
        		"I-676WB 676@18th St",
        		"I-676EB 676@16th St",
        		"I-676WB 676@Broad St",
        		"I-676WB 676@11th St",
        		"I-676EB 676@8th St",
        		"I-676EB 676@3rd St"});
        //7
        addInfo("US Route 1",new String[]{"US 1 NB South of Henry",
        		"US 1 SB @ Fox Street",
        		"US 1 SB @ Wissahickon",
        		"US 1 NB @ Roberts/Berkley",
        		"US 1 NB @ 17th Street",
        		"US 1 SB @ Broad Street",
        		"US 1 @ 9th Street",});  
        //8
        addInfo("US Route 23",new String[]{"RT23 EB @ Fayette St",
        		"RT23 WB @ Hollow Rd",
        		"RT23 WB @ City Line Ave",}); 
        //9
        addInfo("US Route 30",new String[]{"US 30 EB @ PA 100",
        		"US 30 EB before PA 100",
        		"US 30 WB@BUS 230 Ramp",
        		"US 30 WB before PA 113",
        		"US 30 WB before PA 282",
        		"US 30 WB @ PA 322",
        		"US 30 EB after PA 340",
        		"US 30 at Natural Springs Road",
        		"US 30 at West Street",
        		"US 30 at PA 283",
        		"US 30 at RT 501"});  
        //10
        addInfo("US Route 63",new String[]{"US 63 WB @ Millbrk Rd"});
        //11
        addInfo("US Route 202",new String[]{"US 202 @Town CTR RD",
        		"US 202 @ Allendale",
        		"US 202 NB US 202/I/76",
        		"US 202 SB US 202/PA 422",
        		"US 202 NB @ W Valley Rd",
        		"US 202 SB @ US 252",
        		"US 202 N of US 252",
        		"US 202 NB N of Chesterbrk",
        		"US 202 SB @ Howelvl Rd",
        		"US 202 NB N of N Valley",
        		"US 202 SB N of Cedar Hollow Rd",
        		"US 202 SB @ PA 29",
        		"US 202 NB N of Mill Lane",
        		"US 202 SB @ Church Rd",
        		"US 202 NB S of PA 401",
        		"US 202 SB @ US 30",
        		"US 202 SB S of King Rd",
        		"US 202 NB@Morstein Rd",
        		"US 202 NB@Boot Rd",
        		"US 202 SB@ PA 100",
        		"US 202 SB @PA 322",
        		"US 202 NB N or Paoli",
        		"US 202 NB@W Chester P",
        		"US 202 NB N of Westtn R",
        		"US 202 NB S of Bolmar S",
        		"US 202 NB@PA 322",
        		"US 202 NB N of Skiles Blvd",
        		"US 202 SB @ PA 926",
        		"US 202 SB S of Green Tr Dr",
        		"US 202 SB@Watkins",
        		"US 202 SB @ US1",
        		"US 202 Ramp L @ Ramp O",
        		"US 202 Ramp L @ Cont BL",
        		"US 202 Ramp L @ 76",});  
        //12
        addInfo("US Route 422",new String[]{"US 422 EB-422 @ PA Turnpike",
        		"US 422 WB-422@PA 23",
        		"US 422 WB-422 @ PA 363",
        		"US 422 WB-422 W of PA 363",
        		"US 422 EB- 422 PWLNGS RD",
        		"US 422 EB- 422 W of Perk",
        		"US 422 WB-422 Egypt Rd",
        		"US 422 EB-422 Indn Head",
        		"US 422 WB-422 Cider Mil",
        		"US 422 WB-422 E of PA 29",});
        //13
        addInfo("Platt Bridge",new String[]{"WB Platt Bridge Midspan",
        		"WB Platt Bridge"});
        //14
        addInfo("26th Street",new String[]{"26th Street to 76 WB",
        		"26th Street & Penrose Ave"}); 
        //15
        addInfo("Other Philadelphia Locations",new String[]{"Torresdale @ Harbison Ave",
        		"Torresdale @ Robbins Ave",
        		"Torresdale @  Levick St",
        		"Torresdale @ Princeton Ave",
        		"Torresdale @ Cottman Ave",
        		"Torresdale @ Rhawn St",
        		"Torresdale @ Ashburner St",
        		"Torresdale @ Linden St",
        		"State Rd @ Princeton Ave",
        		"State Rd @ Cottman Ave",
        		"Aramingo Ave @ Tacony St",
        		"Harbison Ave @ Sanger St"});
        //16
        addInfo("Pennsylvania Turnpike",new String[]{"Bensalem 351.4 WB",
        		"Valley Forge 326.3 WB",
        		"Willow Grove 343 WB",
        		"Plymouth Meeting 333.7 WB",
        		"Ft Washington 338.5 WB"});
      //17
        addInfo("Interstate 78",new String[]{"I-78 & Rt.100",
                "I-78 & Cedar Crest Blvd.",
                "I-78 & Rt.145",
                "I-78 & Rt.22 Split",
                "I-78 & Lehigh St.",
                "I-78 & Rt.412",
                "I-78 & Rt.222",
                "I-78 & Rt.33",
                "I-78 & Morgan Hill Rd.",
                "I-78 & Rt.737 Exit 40",
                "I-78 & Rt.143 Exit 35",
                "I-78 & Rt.61 Exit 29",
                "I-78 & Rt.183 Exit 19",
                "I-78 & Rt.645 Exit 10"});
      //18
        addInfo("Interstate 80",new String[]{"I-80 at Rt. 940 Exit 277",
                "I-80 at Rt. 209 Exit 309"});
      //19
        addInfo("Interstate 81",new String[]{"I-81 & Rt.61 Exit 124",
                "I-81 & Highridge Exit 119",
                "I-81 & Rt.209 Exit 107"});
      //20
        addInfo("Interstate 380",new String[]{"I-380 at Rt.940 Exit 3"});
        
      //21
        addInfo("State Route 22",new String[]{"Rt.22 & 15th Street",
                "Rt.22 & Rt.309",
                "Rt.22 & Cedar Crest Blvd.",
                "Rt.22 & Rt.145",
                "Rt.22 & Airport Rd.",
                "Rt.22 & Fullerton Ave.",
                "Rt.22 & Schoenersville Rd.",
                "Rt.22 & Rt.512",
                "Rt.22 & Rt.191",
                "Rt.22 & Rt.33",
                "Rt.22 & 4th St."});
      //22
        addInfo("State Route 222",new String[]{"Rt.222 & Rt.100"});
        
      //23
        addInfo("State Route 33",new String[]{"Rt.33SB & Rt. 248"});
    }  
      
    public void addInfo(String p,String[] c){  
        paGroup.add(p);  
          
        List<String> item = new ArrayList<String>();  
          
        for(int i=0;i<c.length;i++){  
            item.add(c[i]);  
        }  
          
        paChild.add(item);   
    }  
}
