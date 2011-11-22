package com.chapslife.philly.traffic.adapters;

import java.util.ArrayList;

import com.chapslife.philly.traffic.R;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class GasAdapter extends ArrayAdapter<Gas>{

	private ArrayList<Gas> items;
	private Context context;
	
    public GasAdapter(Context context, int textViewResourceId, ArrayList<Gas> items) {
            super(context, textViewResourceId, items);
            this.items = items;
            this.context = context;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	View v = convertView;
    	//v.setBackgroundColor(getResources().getColor(R.color.red));
    	//v.setBackgroundColor(R.color.red);
    	if (v == null) {
    		LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    		v = vi.inflate(R.layout.gas_list, parent,false);
    	}
          
    	Gas o = items.get(position);
            
    	if (o != null) {
    		//LinearLayout backGround = (LinearLayout) v.findViewById(R.id.background4);
    		TextView price = (TextView) v.findViewById(R.id.price);
    		TextView station = (TextView) v.findViewById(R.id.station);
    		TextView address = (TextView) v.findViewById(R.id.address);
    		TextView city = (TextView) v.findViewById(R.id.city);
    		TextView distance = (TextView) v.findViewById(R.id.distance);
    		
    		if (price != null) {
    			price.setTextColor(Color.GREEN);
    			price.setText(o.getGas_price());
                        	
    		}
    		if(station != null){
    			station.setTextColor(Color.BLACK);
    			station.setText(o.getGas_station());	
    		}
    		if(address != null){
    			address.setTextColor(Color.BLACK);
    			address.setText(o.getAddress());	
    		}
    		if(city != null){
    			city.setTextColor(Color.BLACK);
    			city.setText(o.getCity());	
    		}
    		if(distance != null){
    			distance.setTextColor(Color.BLACK);
    			distance.setText(o.getDistance());	
    		}
    	}
    	return v;
    }
}
