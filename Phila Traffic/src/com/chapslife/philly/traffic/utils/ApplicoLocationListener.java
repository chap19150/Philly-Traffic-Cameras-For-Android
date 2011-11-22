package com.chapslife.philly.traffic.utils;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationProvider;
import android.os.Bundle;
import android.util.Log;

/**
 * @version 1.0
 */
@SuppressWarnings("unused")
public class ApplicoLocationListener implements LocationListener {
	private final static String TAG = "ApplicoLocationListener";
	private final static long UPDATE_INTERVAL = 5 * 60 * 1000;
	private boolean enabled = true;
	private double longitude;
	private double latitude;
	private long lastUpdateTime = 0;
	private long previousUpdateTime = 0;
	private float accuracy = 0.0f;
	
		public void onStatusChanged(String provider, int status, Bundle extras) {
			switch(status) {
				case LocationProvider.OUT_OF_SERVICE:
					Log.i(TAG, "Location OUT OF SERVICE: " + provider);
				case LocationProvider.TEMPORARILY_UNAVAILABLE:
					Log.i(TAG, "Location NOT available from: " + provider);
					this.enabled = false;
					break;
				case LocationProvider.AVAILABLE:
					this.enabled = true;
					Log.i(TAG, "Location available from: " + provider);
					break;
			}
			
		}
		
		public void onProviderEnabled(String provider) {
			this.enabled = true;
		}
		
		public void onProviderDisabled(String provider) {
			this.enabled = false;
		}
		
		public void onLocationChanged(Location location) {
			this.longitude = location.getLongitude();
			this.latitude = location.getLatitude();
			this.previousUpdateTime = this.lastUpdateTime;
			this.lastUpdateTime = location.getTime();
			this.accuracy = location.getAccuracy();
			Log.d(TAG, "Location changed: Long: " + this.longitude + " Lat: " + this.latitude + " Accuracy: " + this.accuracy);
		}

		public final boolean isEnabled() {
			final long diff = System.currentTimeMillis() - this.lastUpdateTime;
			Log.i(TAG, "Difference between update times: " + diff);
			Log.i(TAG, "Last update time value: " + this.lastUpdateTime);
			Log.i(TAG, "Difference greater than zero: " + (diff > 0));
			Log.i(TAG, "Difference less than " + UPDATE_INTERVAL + ": " + (diff <= UPDATE_INTERVAL));
			if (this.lastUpdateTime != 0 
					&& diff > 0
					&& diff <= UPDATE_INTERVAL) this.enabled=true;
			
			Log.i(TAG,"ENABLED: "+new Boolean(this.enabled).toString());
			
			return this.enabled;
		}

		public final double getLongitude() {
			return this.longitude;
		}

		public final double getLatitude() {
			return this.latitude;
		}
		
		public final long getLastUpdate() {
			return this.lastUpdateTime;
		}
		
		public final boolean hasUpdate() {
			if (this.lastUpdateTime > this.previousUpdateTime) return true;
			return false;
		}
		
		public final float getAccuracy() {
			return this.accuracy;
		}
		
		public final boolean hasData() {
			if (this.longitude != 0 && this.latitude != 0 && this.lastUpdateTime > 0) return true;
			return false;
		}
	
	
}

