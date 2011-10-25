package com.chapslife.philly.traffic;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ImageView.ScaleType;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ImageViewFragment extends Fragment {

	private Handler handler;
    private Runnable runnable;
	private Drawable image;
	private String mURL;
	private ImageView imageView;
	private int delay;
	
	public ImageViewFragment(String _mURL){
		mURL = _mURL;
	}
	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_image, container,false);
        LinearLayout layout = (LinearLayout) root.findViewById(R.id.image_linear);
        imageView = new ImageView(getActivity());
        imageView.setScaleType(ScaleType.FIT_XY);
        layout.addView(imageView);
        doPAStuff();
        setHasOptionsMenu(true);
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
    }
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	    case R.id.menu_shortcut:
	        //newGame();
	        return true;
	    case R.id.menu_favs:
	        //showHelp();
	        return true;
	    default:
	        return super.onOptionsItemSelected(item);
	    }
	}
	
	public void doPAStuff(){
		delay = 5000;
		if ( handler != null ){
			handler.removeCallbacks(runnable);
		}
		handler = null;
		image = ImageOperations(getActivity().getApplicationContext(),mURL,"image.jpg");
		imageView.setImageDrawable(image);
		Toast.makeText(getActivity().getApplicationContext(), "Camera refreshes every " + String.valueOf(delay/1000) +  " seconds", Toast.LENGTH_LONG).show();
		handler = new Handler();
		runnable = new Runnable() {
			public void run() {
				trimCache(getActivity());
				image = ImageOperations(getActivity().getApplicationContext(),mURL,"image.jpg");
	  			imageView.setImageDrawable(image);
	  	 		handler.postDelayed(this, delay);
			}
		};
		handler.postAtTime(runnable, 4500); 
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
	private Drawable ImageOperations(Context ctx, String url, String saveFilename) {
		try {
			InputStream is = (InputStream) this.fetch(url);
			Drawable d = Drawable.createFromStream(is, "src");
			return d;
		} catch (MalformedURLException e) {
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public Object fetch(String address) throws MalformedURLException,IOException {
		URL url = new URL(address);
		Object content = url.getContent();
		return content;
	}
}
