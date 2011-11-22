package com.chapslife.philly.traffic.utils;

import android.content.Context;
import android.content.res.Configuration;
import android.net.ConnectivityManager;
import android.os.Build;

public class UiUtils {

	public static boolean isHoneycomb() {
        // Can use static final constants like HONEYCOMB, declared in later versions
        // of the OS since they are inlined at compile time. This is guaranteed behavior.
        return Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB;
    }

    public static boolean isTablet(Context context) {
        /*return (context.getResources().getConfiguration().screenLayout
                & Configuration.SCREENLAYOUT_SIZE_MASK)
                >= Configuration.SCREENLAYOUT_SIZE_LARGE;*/
    	return false;
    }
    
    public static boolean isHoneycombTablet(Context context) {
        return isHoneycomb() && isTablet(context);
    }
    
    public boolean isInternetConnected(Context ctx) {
	    ConnectivityManager cm = (ConnectivityManager)ctx.getSystemService(Context.CONNECTIVITY_SERVICE);
	    // test for connection
	    if (cm.getActiveNetworkInfo() != null
	            && cm.getActiveNetworkInfo().isAvailable()
	            && cm.getActiveNetworkInfo().isConnected()) {
	        return true;
	    } else {
	        return false;
	    }
	}
    
    public static boolean isProVersion(){
    	return false;
    }
}
