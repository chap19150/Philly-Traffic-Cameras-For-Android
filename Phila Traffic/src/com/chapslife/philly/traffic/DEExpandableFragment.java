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

public class DEExpandableFragment extends Fragment{

	private ExpandableListView deEpView;
	protected String mURL;
	protected int delay;
	protected String title;
	private OnCameraSelecterListener mListener;
	private ArrayList<String> deGroup;
	private ArrayList<List<String>> deChild;
	private InfoDetailsAdapter deAdapter;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_expandablelist, container,false);
        LinearLayout layout = (LinearLayout) root.findViewById(R.id.expandable_list);
        deEpView = new ExpandableListView(getActivity());
        initialDEData();
        setupDEView();
        layout.addView(deEpView);
        return root;
	}
	@Override
    public void onAttach(SupportActivity activity) {
		super.onAttach(activity);
        try {
            mListener = (OnCameraSelecterListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement OnCameraSelectedListener");
        }
    }
	
	private void setupDEView() {
		deAdapter = new InfoDetailsAdapter(getActivity(),deGroup,deChild);
		deEpView.setAdapter(deAdapter);
		deEpView.setFastScrollEnabled(true);
		deEpView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {

			public boolean onChildClick(ExpandableListView parent, View v,
					int groupPosition, int childPosition, long id) {
				title = deAdapter.getChild(groupPosition, childPosition).toString();
            	delay = 5000;
            	if (groupPosition == 0) {
                	if (childPosition == 0){
                		//mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM082&framerate=1";
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM016&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM014&framerate=0";
        			}else if (childPosition == 2){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM009&framerate=0";
        			}else if (childPosition == 3){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM010&framerate=0";
        			}else if (childPosition == 4){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM012&framerate=0";
        			}else if (childPosition == 5){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM011&framerate=0";
        			}else if (childPosition == 6){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM002&framerate=0";
        			}else if (childPosition == 7){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM013&framerate=0";        				
        			}else if (childPosition == 8){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM001&framerate=0";
        			}else if (childPosition == 9){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM025&framerate=0";
        			}else if (childPosition == 10){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM003&framerate=0";
        			}else if (childPosition == 11){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM034&framerate=0";
        			}else if (childPosition == 12){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM089&framerate=0";
        			}else if (childPosition == 13){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM090&framerate=0";
        			}else if (childPosition == 14){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM092&framerate=0";        				
        			}else if (childPosition == 15){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM097&framerate=0";
        			}else if (childPosition == 16){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM098&framerate=0";
        			}else if (childPosition == 17){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM109&framerate=0";
        			}else if (childPosition == 18){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM108&framerate=0";
        			}else if (childPosition == 19){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM111&framerate=0";        				
        			}else if (childPosition == 20){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM106&framerate=0";
        			}else if (childPosition == 21){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM099&framerate=0";
        			}else if (childPosition == 22){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM135&framerate=0";
        			}else if (childPosition == 23){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM124&framerate=0";
        			}else if (childPosition == 24){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM046&framerate=0";        				
        			}else if (childPosition == 25){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM126&framerate=0";
        			}
                }else if (groupPosition == 1) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM058&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM008&framerate=0";
        			}else if (childPosition == 2){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM005&framerate=0";
        			}else if (childPosition == 3){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM006&framerate=0";
        			}else if (childPosition == 4){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM114&framerate=0";
        			}else if (childPosition == 5){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM118&framerate=0";
        			}else if (childPosition == 6){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM115&framerate=0";
        			}else if (childPosition == 7){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM116&framerate=0";        				
        			}
                }else if (groupPosition == 2) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM057&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM056&framerate=0";
        			}else if (childPosition == 2){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM054&framerate=0";
        			}else if (childPosition == 3){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM055&framerate=0";
        			}else if (childPosition == 4){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM075&framerate=0";
        			}else if (childPosition == 5){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM068&framerate=0";
        			}else if (childPosition == 6){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM067&framerate=0";
        			}
                }else if (groupPosition == 3) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM060&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM053&framerate=0";
        			}else if (childPosition == 2){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM076&framerate=0";
        			}else if (childPosition == 3){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM077&framerate=0";
        			}else if (childPosition == 4){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM088&framerate=0";
        			}else if (childPosition == 5){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM062&framerate=0";
        			}else if (childPosition == 6){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM113&framerate=0";
        			}else if (childPosition == 7){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM117&framerate=0";        				
        			}else if (childPosition == 8){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM137&framerate=0";
        			}
                }else if (groupPosition == 4) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM051&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM052&framerate=0";
        			}
                }else if (groupPosition == 5) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM048&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM049&framerate=0";
        			}else if (childPosition == 2){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM050&framerate=0";
        			}
                }else if (groupPosition == 6) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM023&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM017&framerate=0";
        			}
                }else if (groupPosition == 7) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM084&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM085&framerate=0";
        			}else if (childPosition == 2){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM094&framerate=0";
        			}else if (childPosition == 3){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM110&framerate=0";
        			}else if (childPosition == 4){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM113&framerate=0";
        			}else if (childPosition == 5){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM082&framerate=0";
        			}
                }else if (groupPosition == 8) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM071&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM042&framerate=0";
        			}else if (childPosition == 2){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM043&framerate=0";
        			}
                }else if (groupPosition == 9) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM069&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM035&framerate=0";
        			}else if (childPosition == 2){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM036&framerate=0";
        			}else if (childPosition == 3){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM037&framerate=0";
        			}else if (childPosition == 4){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM070&framerate=0";
        			}
                }else if (groupPosition == 10) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM072&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM139&framerate=0";
        			}
                }else if (groupPosition == 11) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM030&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM027&framerate=0";
        			}else if (childPosition == 2){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM029&framerate=0";
        			}else if (childPosition == 3){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM004&framerate=0";
        			}else if (childPosition == 4){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM086&framerate=0";
        			}else if (childPosition == 5){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM028&framerate=0";
        			}else if (childPosition == 6){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM032&framerate=0";
        			}else if (childPosition == 7){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM022&framerate=0";        				
        			}else if (childPosition == 8){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM019&framerate=0";
        			}else if (childPosition == 9){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM074&framerate=0";
        			}else if (childPosition == 10){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM020&framerate=0";
        			}else if (childPosition == 11){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM091&framerate=0";
        			}else if (childPosition == 12){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM095&framerate=0";
        			}else if (childPosition == 13){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM096&framerate=0";
        			}else if (childPosition == 14){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM102&framerate=0";        				
        			}else if (childPosition == 15){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM103&framerate=0";
        			}else if (childPosition == 16){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM112&framerate=0";
        			}else if (childPosition == 17){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM073&framerate=0";
        			}else if (childPosition == 18){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM107&framerate=0";
        			}else if (childPosition == 19){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM021&framerate=0";        				
        			}else if (childPosition == 20){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM142&framerate=0";
        			}else if (childPosition == 21){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM125&framerate=0";
        			}else if (childPosition == 22){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM018&framerate=0";
        			}
                }else if (groupPosition == 12) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM064&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM066&framerate=0";
        			}else if (childPosition == 2){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM063&framerate=0";
        			}else if (childPosition == 3){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM065&framerate=0";
        			}
                }else if (groupPosition == 13) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM039&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM015&framerate=0";
        			}else if (childPosition == 2){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM041&framerate=0";
        			}else if (childPosition == 3){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM040&framerate=0";
        			}else if (childPosition == 4){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM149&framerate=0";
        			}
                }else if (groupPosition == 14) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM100&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM105&framerate=0";
        			}else if (childPosition == 2){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM104&framerate=0";
        			}else if (childPosition == 3){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM122&framerate=0";
        			}else if (childPosition == 4){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM121&framerate=0";
        			}
                }else if (groupPosition == 15) {
                	if (childPosition == 0){
                		mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM083&framerate=0";
        			}else if (childPosition == 1){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM138&framerate=0";
        			}else if (childPosition == 2){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM127&framerate=0";
        			}else if (childPosition == 3){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM093&framerate=0";
        			}else if (childPosition == 4){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM101&framerate=0";
        			}else if (childPosition == 5){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM132&framerate=0";
        			}else if (childPosition == 6){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM140&framerate=0";
        			}else if (childPosition == 7){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM031&framerate=0";        				
        			}else if (childPosition == 8){
        				mURL = "http://webvideoserv.deldot.gov/video.jpg?source=CAM024&framerate=0";
        			}
                }
            	mListener.onCameraSelected(mURL,title,delay,"DE");
				return false;
			}
			
		});
	}

	private void initialDEData() {
		deGroup = new ArrayList<String>();  
        
        deChild = new ArrayList<List<String>>();  
         //0 
        addInfo("DE 1 & 1A", new String[]{"DE 1 (Exit 160) & U.S. 40",
        		"DE 1 & Airport Road (Entrance to Camelot)",
        		"DE 1 & DE 1A, Dewey Beach",
        		"DE 1 & DE 1A, Rehoboth Beach",
        		"DE 1 & Dartmouth Dr (Sussex 268A)",
        		"DE 1 & DE 24, Lewes",
        		"DE 1 & DE 26 (Garfield Pkwy)",
        		"DE 1 South of Collins Street",
        		"DE 1 & DE 54 (Lighthouse Rd)",
        		"DE 1 @ Dover Toll Plaza",
        		"DE 1 & U.S. 9 at Five Points",
        		"DE 1 (Exit 162) & DE 273",
        		"DE 1 & U.S. 13 (North of DE 71)",
        		"DE 1 & Exit 114 South Smyrna",
        		"DE 1 & Thompsonville Road",
        		"DE 1 (Scott s Run) & South St.",
        		"DE 1 & Inlet Road",
        		"DE 1 & Exit 104 (Scarborough Rd)",
        		"DE 1 (Exit 136) & DE 299",
        		"DE 1 & Bowers Beach Rd",
        		"DE 1 (Exit 152) & DE 72",
        		"DE 1 & Bathhouse Road",
        		"DE 1A (Rehoboth Ave) & Church St.",
        		"DE 1 Puncheon Run Connector & S. State St.",
        		"DE 1 & Christiana Mall Rd",
        		"DE 1 & DE 10"
        		});  

        //1
        addInfo("Interstate 95",new String[]{"I-95 /  I-495 & DE 92 (Naamans Road)",
        		"I-95 & Airport Road (I-95 Saltbox)",
        		"I-95 (Exit 4) & DE 1/ DE 7 (Stanton-Christiana Rd)",
        		"I-95 (Exit 3) & DE 273 (Christana Rd)",
        		"I-95 @ Newark Toll Plaza",
        		"I-95 & I-495",
        		"I-95 & DE 896",
        		"I-95 & Rest Area/Service Plaza"});  
        //2
        addInfo("Interstate 495",new String[]{"I-495 & Philadelphia Pike",
        		"I-495 & Edgemoor Rd",
        		"I-495  & 12th Street",
        		"I-495  & Terminal Avenue",
        		"I-495 & U.S. 13 Southern Interchange",
        		"I-495 & Bellevue Road",
        		"I-495 & Yale Avenue"}); 
        //3
        addInfo("DE 141",new String[]{"DE 141 (Barley Mill Rd) at the DuPont Experimental Station",
        		"DE 141 & DE   4 (W. Justis St.)",
        		"DE 141 (Centre Rd) & DE 48 (Lancaster Pike)",
        		"DE 141 & DE 62 (Boxwood Rd)",
        		"DE 141 (Barley Mill Rd)) & DE 100",
        		"DE 141 & DE 52 (Kennet Pike)",
        		"DE 141 & DE  34 (Faukland Rd)",
        		"DE 141 & I95, South of InterChange",
        		"DE 141 & I95, North of InterChange"});  
        //4
        addInfo("DE 261",new String[]{"DE 261 (Foulk Rd) & DE 92 (Naamans Rd)",
        		"DE 261 (Foulk Rd)  & Silverside Rd"});
        //5
        addInfo("U.S. 202",new String[]{"U.S. 202 & DE 92 (Naamans Road)",
        		"U.S. 202 & Silverside Rd",
        		"U.S. 202 (Concord Pike) & DE 141 (Murphy Rd)"});
        //6
        addInfo("U.S. 40",new String[]{"U.S. 40 & DE 72",
        		"U.S. 40 & DE 896"});
        //7
        addInfo("U.S. 113",new String[]{"U.S. 113 & DE 24 (S. Washington St)",
        		"U.S. 113 & DE 20/Sussex 334",
        		"U.S. 113 & DE 404",
        		"U.S. 113 & Puncheon Run Connector (DE 1 Exit 97)",
        		"U.S. 113 & Towncenter Dr, Peninsula Crossing",
        		"U.S. 113 & U.S. 9"});  
        //8
        addInfo("DE  4",new String[]{"DE  4 & DE 896 (S College Ave)",
        		"DE  4 & Harmony Road",
        		"DE  4 (Ogletown-Stanton Rd) & DE  58 (Churchmans Road)",}); 
        //9
        addInfo("DE 273",new String[]{"DE 273 (Main St) & DE 72 (Library Ave)",
        		"DE 273 & Chapman Road",
        		"DE 273 & Harmony Road",
        		"DE 273 & DE 4 (Ogletown-Stanton Rd.)",
        		"DE 273 (Main St) & S. College Ave."});  
        //10
        addInfo("DE  2",new String[]{"DE  2 (Elkton Rd) & DE  4 (Christiana Pkwy)",
        		"DE  2 (Elkton Rd) & Otts Chapel Rd"});
        //11
        addInfo("U.S. 13",new String[]{"U.S. 13 & DE 8 (Division Street)",
        		"U.S. 13 & Scarborough Rd (Exit 104 from DE 1)",
        		"U.S. 13 & White Oak Rd",
        		"U.S. 13 & State Street & Leipsic Rd",
        		"U.S. 13 & Dover Downs Entrance",
        		"U.S. 13 & Townsend Blvd.",
        		"U.S. 13 & U.S. 113 (Court Street)",
        		"U.S. 13 & Pine Tree Rd",
        		"U.S. 13 & U.S.  40",
        		"U.S. 13 & Boulden Blvd.",
        		"U.S. 13 & State Fair Main Ent.",
        		"U.S. 13 & DE 300 (E. Glenwood Ave)",
        		"U.S. 13 & DE 404",
        		"U.S. 13 & Tybouts Corner/Hamburg Rd",
        		"U.S. 13-SB & DE 14 (Milford Harrington Hwy)",
        		"U.S. 13-NB & DE 14 (Milford Harrington Hwy)",
        		"U.S. 13 & Herring Run Rd",
        		"U.S. 13 & DE 273",
        		"U.S. 13/DE 1 & Old State Road",
        		"U.S. 13 & Kent 315",
        		"U.S. 13 & Duck Creek Road",
        		"U.S. 13 & DE 10",
        		"U.S. 13 & DE 896 Boyd's Corner"});  
        //12
        addInfo("U.S. 13BUS",new String[]{"U.S. 13BUS (Philadelphia Pike) & Washington St.",
        		"U.S. 13BUS (Philadelphia Pike) & Gov. Printz Blvd",
        		"U.S. 13BUS (Northeast Blvd) & E. 12th St",
        		"U.S. 13BUS (Philadelphia Pike) & Holly Oak Rd"});
        //13
        addInfo("DE 7",new String[]{"DE 7 (Limestone Rd) & DE 4 (Mitch Rd)",
        		"DE 7 (Limestone Rd) & DE 72 (Paper Mill Rd)",
        		"DE 7 (Stanton-Christiana) & DE 58 (Churchmans Rd)",
        		"DE 7 (Stanton-Christiana Rd) & DE 4 (Ogletown-Stanton Rd)",
        		"DE 7 & Valley Rd"});
        //14
        addInfo("U.S. 301",new String[]{"U.S. 301 & DE 896",
        		"U.S. 301/DE 71 & Bethel Church Road",
        		"U.S. 301/DE 896 (Summit Bridge Rd) & DE 71 (Red Lion rd)",
        		"U.S. 301 & Strawberry Ln",
        		"U.S. 301 & SR 299"}); 
        //15
        addInfo("Other Delaware Locations",new String[]{"High Street & S. Front Street",
        		"N. Adams St & W. 9th St",
        		"SR1 & SR9",
        		"DE 26 (Atlantic Ave) & Central Ave",
        		"DE 54 & DE 20",
        		"DE 72 (Wrangle Hill Rd)  & DE71 (Red Lion Rd)",
        		"DE 896 & Old Baltimore Pike",
        		"DE 8 (Forest Ave) & DE 15 (Saulsbury Rd)",
        		"Dover Downs Traffic Control"});
		
	}
	
	public void addInfo(String p,String[] c){  
        deGroup.add(p);  
          
        List<String> item = new ArrayList<String>();  
          
        for(int i=0;i<c.length;i++){  
            item.add(c[i]);  
        }  
          
        deChild.add(item);   
    }
}
