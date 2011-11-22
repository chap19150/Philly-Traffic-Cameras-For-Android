package com.chapslife.philly.traffic.utils;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;

public class LocationFinder {
	
	private Context context;
	
	public LocationFinder(Context _context){
		context = _context;
	}
	
	public Location  getGPS() {
		LocationManager lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
		List<String> providers = lm.getProviders(true);
		
		Location location = null;
		for(int i = providers.size() - 1; i >= 0; i--){
			location = lm.getLastKnownLocation(providers.get(i));
			if(location != null) break;
		}
		
				
		return location;
	}
}
