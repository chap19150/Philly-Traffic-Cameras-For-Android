package com.chapslife.philly.traffic;

import java.util.ArrayList;
import java.util.HashMap;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.support.v4.app.SupportActivity;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.chapslife.philly.traffic.interfaces.OnCameraSelecterListener;
import com.chapslife.philly.traffic.utils.AABDatabaseManager;

public class FavoritesFragment extends ListFragment{

	private AABDatabaseManager db;
	private ArrayAdapter adapter;
	private String title;
	private String mURL;
	private Integer delay;
	private String state;
	private OnCameraSelecterListener mListener;
	private String[] from;

	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadFavorites();
	}

	private void loadFavorites() {
		retrieveRows();
        adapter = new ArrayAdapter<String>(getActivity(),android.R.layout.simple_list_item_1, from);
        setListAdapter(adapter);
        registerForContextMenu(getListView());
	}
	
	private void retrieveRows() {
		// create the database manager object 
    	//fillMaps  = new ArrayList<HashMap<String, String>>();
        db = new AABDatabaseManager(getActivity());
        ArrayList<ArrayList<Object>> data = db.getAllRowsAsArrays();
     // iterate the ArrayList, create new rows each time and add them
    	// to the table widget.
        from = new String[data.size()];
    	for (int position=0; position < data.size(); position++){
    		ArrayList<Object> row = data.get(position);
    		from[position] = row.get(2).toString();
    		//HashMap<String, String> map = new HashMap<String, String>();
    	    //map.put("headerName", hName);
    	    //fillMaps.add(map);
    	}
    	db.close();
	}
	
	private void getData(String headerName){
		// create the database manager object 
        db = new AABDatabaseManager(getActivity());
        ArrayList<ArrayList<Object>> data = db.getAllRowsAsArrays();
        Boolean found = false;
        for (int position=0; position < data.size(); position++){
        	ArrayList<Object> row = data.get(position);
        	title = row.get(2).toString();
    		Log.i("DB",  String.valueOf(row.size()));
    		if (title.equals(headerName)){
    			found = true;
    			mURL = (String) row.get(1);
    			delay = Integer.parseInt((String) row.get(3));;
    			state = (String) row.get(4);
    			db.close();
    			break;
    		}
        }
        db.close();
	}
	
	@Override
	public void onListItemClick(ListView l, View v, int position, long id){
		String hName = (String) l.getItemAtPosition(position);
        getData(hName);
        mListener.onCameraSelected(mURL,title,delay,state);
	}
	
	private void removeFromDB(String header, int p){
		db = new AABDatabaseManager(getActivity());
        ArrayList<ArrayList<Object>> data = db.getAllRowsAsArrays();
        Boolean found = false;
     // iterate the ArrayList, create new rows each time and add them
    	// to the table widget.
    	for (int position=0; position < data.size(); position++)
    	{
    		ArrayList<Object> row = data.get(position);
    		int rowID = ((Number)row.get(0)).intValue();
    		String nHeaderName = row.get(2).toString();
    		Log.i("DB",  String.valueOf(row.size()));
    		if (nHeaderName.equals(header))
    		{
    			found = true;
    			Log.i("DBPOSITION",  String.valueOf(position));
    			Log.i("DBPOSITIONROWID",  String.valueOf(row.get(0)));
    			db.deleteRow(rowID);
    			db.close();
    			adapter.remove(adapter.getItem(p));
    			adapter.notifyDataSetChanged();
    			break;
    		}
    		
    	}
    	db.close();
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
}
