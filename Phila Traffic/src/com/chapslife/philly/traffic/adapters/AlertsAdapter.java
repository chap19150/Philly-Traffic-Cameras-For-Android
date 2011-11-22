package com.chapslife.philly.traffic.adapters;

import java.util.ArrayList;

import com.chapslife.philly.traffic.R;
import com.chapslife.philly.traffic.utils.Message;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class AlertsAdapter extends ArrayAdapter<Message>{

	private ArrayList<Message> items;
	private Context context;
	
    public AlertsAdapter(Context _context, int textViewResourceId, ArrayList<Message> _items) {
            super(_context, textViewResourceId, _items);
            this.items = _items;
            this.context = _context;
    }
    
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    	View v = convertView;
    	if (v == null) {
    		LayoutInflater vi = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    		v = vi.inflate(R.layout.alert_list, parent,false);
    	}
            
    	Message message = items.get(position);
            
    	if (message != null) {
    		TextView topText = (TextView) v.findViewById(R.id.topText);
    		TextView bottomText = (TextView) v.findViewById(R.id.bottomText);
    		if (topText != null) {
    			topText.setTextColor(Color.BLACK);
    			topText.setText(message.getTitle());
    		}
    		if(bottomText != null){
    			bottomText.setTextColor(Color.GREEN);
    			bottomText.setText(message.getDate());	
    		}
    	}
            
    	return v;
    }
}
