package com.chapslife.philly.traffic;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.StringWriter;
import java.io.Writer;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.SocketTimeoutException;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.ActionBar;
import android.support.v4.app.Fragment;
import android.support.v4.view.Menu;
import android.support.v4.view.MenuItem;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.Toast;

import com.chapslife.philly.traffic.utils.AABDatabaseManager;
import com.chapslife.philly.traffic.utils.UiUtils;
import com.chapslife.philly.traffic.HomeActivity;
import com.chapslife.philly.traffic.R;

public class ImageViewFragment extends Fragment {

	private Handler handler;
    private Runnable runnable;
	private Drawable image;
	private String mURL;
	private String title;
	private ImageView imageView;
	private int delay;
	private String state;
	private String thisURL;
	//private ProgressDialog dialog;
	private AABDatabaseManager db;
	
	public ImageViewFragment(String _mURL, String _title, int _delay, String _state){
		mURL = _mURL;
		title = _title;
		delay = _delay;
		state = _state;
	}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		Log.i("HERE","HERE");
		setHasOptionsMenu(true);
        View root = inflater.inflate(R.layout.fragment_image, container,false);
        imageView = (ImageView) root.findViewById(R.id.image_linear);
        imageView.setScaleType(ScaleType.FIT_XY);
        Log.i("IMAGEVIEWFRAGMENT","URL: " + mURL);
        UiUtils utils = new UiUtils();
        Log.i("HERE2","HERE2");
        if(state.equalsIgnoreCase("PA") || state.equalsIgnoreCase("DE")){
    		Log.i("HERE4","HERE4");
    		doPAStuff();
    	}else if (state.equalsIgnoreCase("NJ")){
    		doNJStuff();
    	}
        //setHasOptionsMenu(true);
        return root;   
	}
	
	@Override
	public void onPause(){
		super.onPause();
		if ( handler != null ){
			handler.removeCallbacks(runnable);
		}
	}
	
	@Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
	    inflater.inflate(R.menu.options_menu, menu);
	    ActionBar bar = getSupportActivity().getSupportActionBar();
	    bar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
	    
    }
	
	private void shortcutAlert(){
	   	 
    	AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

    	//alert.setTitle("Title");
    	alert.setMessage("Shortcut Name:");

    	// Set an EditText view to get user input 
    	final EditText input = new EditText(getActivity());
    	input.setText(title);
    	alert.setView(input);

    	alert.setPositiveButton("Add Shortcut", new DialogInterface.OnClickListener() {
    	public void onClick(DialogInterface dialog, int whichButton) {
    	  String value = String.valueOf(input.getText());
        	setShortCut(value);
    	  }
    	});

    	alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
    	  public void onClick(DialogInterface dialog, int whichButton) {
    	    // Canceled.
    	  }
    	});

    	alert.show();
    }
	
	public void setShortCut(String camera){
		Toast.makeText(getActivity().getApplicationContext(), "Shortcut on Home Screen", Toast.LENGTH_LONG).show();
    	
    	Intent shortcutIntent = new Intent(Intent.ACTION_VIEW);
    	shortcutIntent.setClassName(getActivity().getPackageName(), ".HomeActivity");
    	
    	shortcutIntent.putExtra(HomeActivity.URL, mURL);
    	shortcutIntent.putExtra(HomeActivity.HEADER, title);
    	shortcutIntent.putExtra(HomeActivity.MYDELAY, delay);
    	shortcutIntent.putExtra(HomeActivity.WHICHCAM, state);
    	
    	shortcutIntent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
    	Intent intent = new Intent();
    	intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, shortcutIntent);
    	intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, camera);
    	intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, Intent.ShortcutIconResource.fromContext(getActivity().getApplicationContext(), R.drawable.icon));
   	  	intent.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
   	  	getActivity().getApplicationContext().sendBroadcast(intent);
   	  	getActivity().setResult(getActivity().RESULT_OK, intent);
	}
	
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case R.id.menu_shortcut:
	        shortcutAlert();
	        return true;
	    case R.id.menu_favs:
	    	if(UiUtils.isProVersion()){
	    		addFavorite();
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
	    	return true;
	    default:
	        return true;
	    }
	}
	private static  String njt(String webidnum) throws IOException{
    	InputStream is = OpenHttpConnection("http://embed.trafficland.com/njtp/trafficland_singlecam.php?webid=" + webidnum + "&key=fc52c07a082a850bc43416536b5e8e14");
    	String meme = convertStreamToString(is);
    	Integer myIndex = meme.indexOf("&pubtoken=");
    	Integer myIndex2 = meme.indexOf("&r=");
    	String g1 = meme.substring(myIndex+10, myIndex2);
    	return(g1);
    }
	public void doNJStuff(){
		if ( handler != null ){
	    	handler.removeCallbacks(runnable);
	    }
		handler = null;
		try {
			String webid = mURL;
    		String pubToken;
			pubToken = njt(webid);
			thisURL = "http://pub2.camera.trafficland.com/image/live.jpg?system=njtp&webid="+webid+"&pubtoken="+pubToken+"&r="+Math.random();
    		Log.d("THISURL", thisURL);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		image = ImageOperations(getActivity().getApplicationContext(),thisURL,"image.jpg");
		if(image != null){
			imageView.setImageDrawable(image);
	  		
			Toast.makeText(getActivity().getApplicationContext(), "Camera refreshes every " + String.valueOf(delay/1000) +  " seconds", Toast.LENGTH_LONG).show();
			handler = new Handler();
			runnable = new Runnable() {
				public void run() {
					trimCache(getActivity());
					image = ImageOperations(getActivity().getApplicationContext(),thisURL,"image.jpg");
					imageView.setImageDrawable(image);
					handler.postDelayed(this, delay);
				}
			};
			handler.postAtTime(runnable, 4500);
		}else{
			final AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
    		alertDialog.setTitle("Bad Camera");
    		alertDialog.setMessage("This camera is disabled, please select another one");
    		alertDialog.setButton("Cancel", new DialogInterface.OnClickListener() {
    		      public void onClick(DialogInterface dialog, int which) {
    		    	  getSupportActivity().getSupportFragmentManager().popBackStack();
    		    	  return;
    		 
    		      } 
    		});
    		alertDialog.show();
		}
		
	}
	public void doPAStuff(){
		if ( handler != null ){
			handler.removeCallbacks(runnable);
		}
		handler = null;
		image = ImageOperations(getActivity().getApplicationContext(),mURL,"image.jpg");
		if(image != null){
			imageView.setImageDrawable(image);
			Toast.makeText(getActivity().getApplicationContext(), "Camera refreshes every " + String.valueOf(delay/1000) +  " seconds", Toast.LENGTH_LONG).show();
			Log.i("HERE5","HERE5");
			handler = new Handler();
			runnable = new Runnable() {
				public void run() {
					Log.i("HERE6","HERE6");
					trimCache(getActivity());
					Log.i("HERE7","HERE7");
					image = ImageOperations(getActivity().getApplicationContext(),mURL,"image.jpg");
		  			imageView.setImageDrawable(image);
		  	 		handler.postDelayed(this, delay);
				}
			};
			handler.postAtTime(runnable, 4500);
		}else{
			final AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
    		alertDialog.setTitle("Bad Camera");
    		alertDialog.setMessage("This camera is disabled, please select another one");
    		alertDialog.setButton("Cancel", new DialogInterface.OnClickListener() {
    		      public void onClick(DialogInterface dialog, int which) {
    		    	  getSupportActivity().getSupportFragmentManager().popBackStack();
    		    	  return;
    		 
    		      } 
    		});
    		alertDialog.show();
		}
		 
	}
	public static void trimCache(Context context) { 
        try {
        	
            File dir = context.getCacheDir(); 
            if (dir != null && dir.isDirectory()) { 
                deleteDir(dir); 
            } 
        } catch (Exception e) { 
            // TODO: handle exception 
        } 
    }
	public static boolean deleteDir(File dir) { 
        if (dir!=null && dir.isDirectory()) { 
            String[] children = dir.list(); 
            for (int i = 0; i < children.length; i++) { 
                boolean success = deleteDir(new File(dir, children[i])); 
                if (!success) { 
                    return false; 
                } 
            } 
        } 
        // The directory is now empty so delete it 
        return dir.delete(); 
    }
	private Drawable ImageOperations(Context ctx, String _url, String saveFilename) {
		try {
			Log.i("FETCH","BEFORE");
			URL url = new URL(_url);
			URLConnection ucon = url.openConnection();
			ucon.setReadTimeout(3000);
			ucon.connect();
			InputStream is = ucon.getInputStream();
			Log.i("FETCH","AFTER");
			Drawable d = Drawable.createFromStream(is, "src");
			return d;
		} catch (MalformedURLException e) {
			Log.i("FETCH","BAD URL");
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			Log.i("FETCH","IOE");
			e.printStackTrace();
			return null;
		}catch(Exception e){
			Log.i("FETCH","E");
			e.printStackTrace();
			return null;
		}
	}
	
	public Object fetch(String address) throws MalformedURLException,IOException {
		URL url = new URL(address);
		
		Object content = url.getContent();
		return content;
	}
	
	public static String convertStreamToString(InputStream is) throws IOException {
		/*
		 * To convert the InputStream to String we use the
		 * Reader.read(char[] buffer) method. We iterate until the
		 * Reader return -1 which means there's no more data to
		 * read. We use the StringWriter class to produce the string.
		 */
		if (is != null) {
			Writer writer = new StringWriter();
			
			char[] buffer = new char[1024];
			try {
				Reader reader = new BufferedReader(new InputStreamReader(is, "UTF-8"));
				int n;
				while ((n = reader.read(buffer)) != -1) {
					writer.write(buffer, 0, n);
				}
			} finally {
				is.close();
			}
			return writer.toString();
		} else {        
			return "";
		}
	}
	private static InputStream OpenHttpConnection(String urlString) throws IOException{
		InputStream in = null;
		int response = -1;
		
		URL url = new URL(urlString); 
		URLConnection conn = url.openConnection();
		                 
		if (!(conn instanceof HttpURLConnection))                     
			throw new IOException("Not an HTTP connection");
		        
		try{
			HttpURLConnection httpConn = (HttpURLConnection) conn;
			httpConn.setAllowUserInteraction(false);
			httpConn.setInstanceFollowRedirects(true);
			httpConn.setRequestMethod("GET");
			httpConn.connect(); 

			response = httpConn.getResponseCode();                 
			if (response == HttpURLConnection.HTTP_OK) {
				in = httpConn.getInputStream();                                 
			}                     
		}
		catch (Exception ex){
			throw new IOException("Error connecting");            
		}
		return in;     
	}
	private void addFavorite() {
		//mURL = _mURL;title = _title;delay = _delay;state = _state;
		// create the database manager object 
		db = new AABDatabaseManager(getActivity());
		ArrayList<ArrayList<Object>> data = db.getAllRowsAsArrays();
    	Boolean found = false;
    	// iterate the ArrayList, create new rows each time and add them
    	// to the table widget.
    	if (data.size() > 999){
    		AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());

    	   	alert.setMessage("Please delete a favorite from the favorites menu before adding more.");


    	   	alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
    	   		public void onClick(DialogInterface dialog, int whichButton) {
    	   		}
    	   	});
    	   	alert.show();
    	}else{
    		for (int position=0; position < data.size(); position++){
    			ArrayList<Object> row = data.get(position);
        		
        		String mCameraName = row.get(1).toString();
        		if (mCameraName.equals(mURL)){
        			found = true;
        			AlertDialog.Builder alert = new AlertDialog.Builder(getActivity());
            	   	alert.setMessage("Camera already exists in favorites");
            	   	alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            	   		public void onClick(DialogInterface dialog, int whichButton) {
            	   		}
            	   	});
            	   	alert.show();
         			db.close();
        			break;
        		}
    		}
    		if(!found){
    			try{
    				db.addRow(mURL,title,delay,state);
    				Toast.makeText(getActivity().getApplicationContext(), title + " added to favorites", Toast.LENGTH_LONG).show();
            				
    			}catch(Exception e){
    				e.printStackTrace();
    			}
    		}
    		db.close();
    	}	
	}
}
