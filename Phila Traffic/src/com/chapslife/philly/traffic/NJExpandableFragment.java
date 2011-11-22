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

public class NJExpandableFragment extends Fragment {

	private ExpandableListView njEpView;
	private ArrayList<String> njGroup;
	private ArrayList<List<String>> njChild;
	private InfoDetailsAdapter njAdapter;
	protected String mURL;
	protected int delay;
	protected String title;
	private OnCameraSelecterListener mListener;
	
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_expandablelist, container,false);
        LinearLayout layout = (LinearLayout) root.findViewById(R.id.expandable_list);
        njEpView = new ExpandableListView(getActivity());
        initialNJData();
        setupNJView();
        layout.addView(njEpView);
        return root;
	}
	private void setupNJView() {
		njAdapter = new InfoDetailsAdapter(getActivity(),njGroup,njChild);
		njEpView.setAdapter(njAdapter);
		njEpView.setFastScrollEnabled(true);
		njEpView.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
			
            public boolean onChildClick(ExpandableListView parent,
                    View v, int groupPosition, int childPosition,
                    long id) {
            	mURL = null;
            	delay = 5000;
        		title = njAdapter.getChild(groupPosition, childPosition).toString();

                if (groupPosition == 0) {
                	if (childPosition == 0){
                		//mURL = "2256";

                		mURL = "13024";
                	}else if (childPosition == 1){
        				mURL = "13025";
        			}else if (childPosition == 2){
        				mURL = "13026";
        			}else if (childPosition == 3){
        				mURL = "13027";
        			}else if (childPosition == 4){
        				mURL = "13023";
        			}else if (childPosition == 5){
        				mURL = "6461";
        			}else if (childPosition == 6){
        				mURL = "6496";
        			}else if (childPosition == 7){
        				mURL = "13030";
        			}else if (childPosition == 8){
        				mURL = "13031";
        			}else if (childPosition == 9){
        				mURL = "13032";
        			}else if (childPosition == 10){
        				mURL = "6457";
        			}else if (childPosition == 11){
        				mURL = "12997";
        			}else if (childPosition == 12){
        				mURL = "6458";
        			}else if (childPosition == 13){
        				mURL = "6463";
        			}else if (childPosition == 14){
        				mURL = "6459";
        			}else if (childPosition == 15){
        				mURL = "13033";
        			}else if (childPosition == 16){
        				mURL = "13034";
        			}else if (childPosition == 17){
        				mURL = "13035";
        			}else if (childPosition == 18){
        				mURL = "13036";
        			}else if (childPosition == 19){
        				mURL = "6460";
        			}else if (childPosition == 20){
        				mURL = "13037";
        			}else if (childPosition == 21){
        				mURL = "6369";
        			}
                }else if (groupPosition == 1) {
                	if (childPosition == 0){
                		mURL = "6432";
                	}else if (childPosition == 1){
        				mURL = "13023";
        			}else if (childPosition == 2){
        				mURL = "12975";
        			}else if (childPosition == 3){
        				mURL = "6502";
        			}else if (childPosition == 4){
        				mURL = "12976";
        			}
                }else if (groupPosition == 2) {
                	if (childPosition == 0){
                		mURL = "6498";
                	}else if (childPosition == 1){
        				mURL = "12973";
        			}else if (childPosition == 2){
        				mURL = "6499";
        			}else if (childPosition == 3){
        				mURL = "6500";
        			}else if (childPosition == 4){
        				mURL = "12974";
        			}else if (childPosition == 5){
        				mURL = "6421";
        			}else if (childPosition == 6){
        				mURL = "6501";
        			}
                }else if (groupPosition == 3) {
                	if (childPosition == 0){
                		mURL = "12973";
                	}else if (childPosition == 1){
        				mURL = "6504";
        			}else if (childPosition == 2){
        				mURL = "6505";
        			}else if (childPosition == 3){
        				mURL = "6506";
        			}else if (childPosition == 4){
        				mURL = "13032";
        			}else if (childPosition == 5){
        				mURL = "12987";
        			}else if (childPosition == 6){
        				mURL = "12996";
        			}else if (childPosition == 7){
        				mURL = "6409";
        			}else if (childPosition == 8){
        				mURL = "12988";
        			}else if (childPosition == 9){
        				mURL = "12989";
        			}
                }else if (groupPosition == 4) {
                	if (childPosition == 0){
                		mURL = "12990";
                	}else if (childPosition == 1){
        				mURL = "12991";
        			}else if (childPosition == 2){
        				mURL = "12992";
        			}else if (childPosition == 3){
        				mURL = "12993";
        			}else if (childPosition == 4){
        				mURL = "12994";
        			}else if (childPosition == 5){
        				mURL = "6410";
        			}else if (childPosition == 6){
        				mURL = "6412";
        			}else if (childPosition == 7){
        				mURL = "12995";
        			}else if (childPosition == 8){
        				mURL = "6413";
        			}else if (childPosition == 9){
        				mURL = "12996";
        			}else if (childPosition == 10){
        				mURL = "6415";
        			}else if (childPosition == 11){
        				mURL = "6411";
        			}else if (childPosition == 12){
        				mURL = "6419";
        			}else if (childPosition == 13){
        				mURL = "12997";
        			}else if (childPosition == 14){
        				mURL = "6421";
        			}else if (childPosition == 15){
        				mURL = "6414";
        			}else if (childPosition == 16){
        				mURL = "6420";
        			}else if (childPosition == 17){
        				mURL = "6417";
        			}else if (childPosition == 18){
        				mURL = "6423";
        			}
                }else if (groupPosition == 5) {
                	if (childPosition == 0){
                		mURL = "6494";
                	}else if (childPosition == 1){
        				mURL = "6495";
        			}else if (childPosition == 2){
        				mURL = "6496";
        			}else if (childPosition == 3){
        				mURL = "6497";
        			}else if (childPosition == 4){
        				mURL = "12970";
        			}else if (childPosition == 5){
        				mURL = "12992";
        			}
                }else if (groupPosition == 6) {
                	if (childPosition == 0){
                		mURL = "12986";
                	}else if (childPosition == 1){
        				mURL = "12985";
        			}
                }else if (groupPosition == 7) {
                	if (childPosition == 0){
                		mURL = "12980";
                	}else if (childPosition == 1){
        				mURL = "12981";
        			}else if (childPosition == 2){
        				mURL = "12982";
        			}else if (childPosition == 3){
        				mURL = "6466&";
        			}else if (childPosition == 4){
        				mURL = "12983";
        			}else if (childPosition == 5){
        				mURL = "13073";
        			}
                }else if (groupPosition == 8) {
                	if (childPosition == 0){
                		mURL = "12813";
                	}else if (childPosition == 1){
        				mURL = "12814";
        			}else if (childPosition == 2){
        				mURL = "12815";
        			}else if (childPosition == 3){
        				mURL = "12816";
        			}else if (childPosition == 4){
        				mURL = "12817";
        			}else if (childPosition == 5){
        				mURL = "12818";
        			}else if (childPosition == 6){
        				mURL = "12819";
        			}else if (childPosition == 7){
        				mURL = "12820";
        			}else if (childPosition == 8){
        				mURL = "12821";
        			}else if (childPosition == 9){
        				mURL = "12822";
        			}else if (childPosition == 10){
        				mURL = "12823";
        			}else if (childPosition == 11){
        				mURL = "12824";
        			}else if (childPosition == 12){
        				mURL = "12825";
        			}else if (childPosition == 13){
        				mURL = "12826";
        			}
                }else if (groupPosition == 9) {
                	if (childPosition == 0){
                		mURL = "12702";
                	}else if (childPosition == 1){
        				mURL = "12703";
        			}else if (childPosition == 2){
        				mURL = "12705";
        			}else if (childPosition == 3){
        				mURL = "12704";
        			}else if (childPosition == 4){
        				mURL = "12706";
        			}else if (childPosition == 5){
        				mURL = "12708";
        			}else if (childPosition == 6){
        				mURL = "12707";
        			}else if (childPosition == 7){
        				mURL = "12709";
        			}else if (childPosition == 8){
        				mURL = "12710";
        			}else if (childPosition == 9){
        				mURL = "12711";
        			}else if (childPosition == 10){
        				mURL = "12712";
        			}else if (childPosition == 11){
        				mURL = "12713";
        			}else if (childPosition == 12){
        				mURL = "12714";
        			}else if (childPosition == 13){
        				mURL = "12715";
        			}else if (childPosition == 14){
        				mURL = "12716";
        			}else if (childPosition == 15){
        				mURL = "12717";
        			}else if (childPosition == 16){
        				mURL = "12718";
        			}else if (childPosition == 17){
        				mURL = "12719";
        			}else if (childPosition == 18){
        				mURL = "12720";
        			}else if (childPosition == 19){
        				mURL = "12721";
        			}
                }
                mListener.onCameraSelected(mURL,title,delay,"NJ");
            	return false;
            }
        });
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
	
	private void initialNJData() {
    	njGroup = new ArrayList<String>();  
        
        njChild = new ArrayList<List<String>>();  
         //0 
        addNJInfo("Interstate 295", new String[]{"New Station Rd., Greenwich",
        		"County Route 678, Greenwich",
        		"County Route 644, West Deptford",
        		"US 130, West Deptford",
        		"NJ 42/US76, Bellmawr",
        		"North of NJ 168 near Devon Ave., Bellmawr",
        		"US 30 at I-295, Haddon Heights",
        		"North of Exit 30/Tillman St., Lawnside",
        		"CR 561, Cherry Hill",
        		"NJ 70, Cherry Hill",
        		"CR 616 (Church Rd.), Mount Laurel",
        		"NJ 73 at I-295, Mt. Laurel",
        		"Fellowship Rd., Mt. Laurel",
        		"Church St. and Mt. Laurel Rd., Mt. Laurel",
        		"NJ 38, Mt. Laurel",
        		"Marne Hwy",
        		"Hartford Rd",
        		"Exit 43, Mount Laurel",
        		"I-195/NJ29, Hamilton",
        		"NJ 33, Hamilton",
        		"Sloan Ave., Hamilton",
        		"US 1 at I-295, Lawrence"
        		});  

        //1
        addNJInfo("Route 76/42",new String[]{"I-76 at Market St.",
        		"NJ 42/US76, Bellmawr",
        		"NJ 42 at Atlantic City Expressway, Washington Twp",
        		"NJ 42 at NJ Turnpike, Runnemede",
        		"NJ 42 at NJ 41, Deptford"
        		});  
        //2
        addNJInfo("Route 38",new String[]{"Airport Circle, Camden",
        		"Route 70, Camden",
        		"Cuthbert Blvd, Cherry Hill",
        		"Haddonfield Rd, Cherry Hill",
        		"Church Road, Cherry Hill",
        		"NJ 73 at NJ 38, Maple Shade",
        		"Nixon Drive, Moorestown"
        		}); 
        //3
        addNJInfo("Route 70",new String[]{"NJ 38 at NJ 70, Camden",
        		"Cornell Ave., Cherry Hill",
        		"Haddonfield Rd., Cherry Hill",
        		"Kings Highway, Cherry Hill",
        		"I-295 at NJ 70, Cherry Hill",
        		"Old Orchard Rd., Cherry Hill",
        		"NJ 70/NJ 73 Circle",
        		"Radnor Blvd., Evesham",
        		"CR 539, Manchester",
        		"Mansquan River, Brick"
        		});  
        //4
        addNJInfo("Route 73",new String[]{"Atlantic City Expressway, Winslow",
        		"CR 561, Winslow",
        		"Route 30, Waterford",
        		"Jackson Rd., Berlin",
        		"Taunton Ave, Berlin",
        		"Berlin Circle, Berlin",
        		"Cooper Rd., Voorhees",
        		"Cedar Hill Rd., Evesham",
        		"Evesham Rd., Evesham",
        		"NJ 70/NJ 73 Circle",
        		"Green Tree Rd., Evesham",
        		"Church Rd., Mt Laurel",
        		"New Jersey Turnpike, Mt. Laurel",
        		"I-295, Mt. Laurel",
        		"NJ 38, Maple Shade",
        		"Fox Meadow Drive, Maple Shade",
        		"US 130, Pennsauken",
        		"Hylton Rd., Pennsauken",
        		"Tacony-Palmyra Bridge - Palmyra"});
        //5
        addNJInfo("US 30",new String[]{"10th St/I-676, Camden",
        		"Collingswood Circle, Pennsauken",
        		"Interstate 295, Haddon Heights Boro",
        		"White Horse Rd, Lindenwold",
        		"Berlin Cross Keys Road, Berlin",
        		"Route 30, Waterford"
        		});
        //6
        addNJInfo("Route 55",new String[]{"Deptford Center Road, Deptford Township",
        		"Route 49, Millville City"
        		});  
        //7
        addNJInfo("Route 47",new String[]{"US 9, Middle Twp.",
        		"Petersburg Rd., Dennis Twp.",
        		"Tyler Rd., Dennis Twp.",
        		"NJ 347 Northbound, Dennis Twp.",
        		"NJ 347 Southbound, Dennis Twp.",
        		"NJ-47 @ US-40"}); 
        //8
        addNJInfo("NJ Turnpike",new String[]{"North of Del Memorial Br",
        		"South of Interchange 1 - Del Memorial Br.",
        		"Interchange 1 - Delaware Memorial Bridge",
        		"Interchange 2 - US 322",
        		"North of Interchange 2 - US 322",
        		"Interchange 3 - NJ 168",
        		"South of Interchange 4 - NJ 73",
        		"Interchange 4 - NJ 73",
        		"North of Interchange 4 - NJ 73",
        		"Interchange 5 - CR 541",
        		"Interchange 7 - US 206",
        		"North of Interchange 7 - US 206",
        		"North of Interchange 7A - I-195",
        		"Interchange 7A - I-195"});
      //10
        addNJInfo("Garden State Parkway",new String[]{"South of Exit 4A - NJ 47 North",
        		"North of Exit 10 - CR 657/Stone Harbor Rd",
        		"North of Cape May Toll Plaza",
        		"Cape May Toll Plaza",
        		"South of Exit 25 - CR 623/Roosevelt Blvd",
        		"Great Egg Toll Plaza",
        		"South of Great Egg Toll Plaza",
        		"Exit 30 exiting - NJ 52/Laurel Drive",
        		"Exit 30 entering - NJ 52/Laurel Drive",
        		"North of Exit 30 - NJ 52/Laurel Drive",
        		"South of Exit 40 - US 30/White Horse Pike",
        		"New Gretna Toll Plaza",
        		"North of New Gretna Toll Plaza",
        		"Barnegat Tolls",
        		"North of Barnegat Tolls",
        		"North of Exit 82 - NJ 37 East",
        		"South of Exit 83 - US 9 North",
        		"Toms River Toll Plaza",
        		"North of Toms River Toll Plaza",
        		"South of Exit 88 - NJ 70 East"});
		
	}
    public void addNJInfo(String p,String[] c){  
        njGroup.add(p);  
          
        List<String> item = new ArrayList<String>();  
          
        for(int i=0;i<c.length;i++){  
            item.add(c[i]);  
        }  
          
        njChild.add(item);   
    } 
}
