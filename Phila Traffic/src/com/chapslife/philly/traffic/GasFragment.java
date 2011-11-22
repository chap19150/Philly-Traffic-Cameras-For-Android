package com.chapslife.philly.traffic;



import java.util.ArrayList;

import org.htmlparser.Parser;
import org.htmlparser.filters.AndFilter;
import org.htmlparser.filters.HasAttributeFilter;
import org.htmlparser.filters.OrFilter;
import org.htmlparser.filters.TagNameFilter;
import org.htmlparser.util.NodeIterator;
import org.htmlparser.util.ParserException;

import com.chapslife.philly.traffic.adapters.Gas;
import com.chapslife.philly.traffic.adapters.GasAdapter;
import com.chapslife.philly.traffic.R;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.util.Log;

public class GasFragment extends ListFragment{

	
	public int originalRequestedOrientation;
	public double lat;
	public ArrayList<Gas> gas;
	public double lon;

	public GasFragment(double _lat, double _lon){
		lat = _lat;
		lon = _lon;
	}
	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        new LoadGas().execute();
	}
	private class LoadGas extends AsyncTask<Void, Void, Cursor>{
		private final ProgressDialog dialog = new ProgressDialog(getActivity());
		private final AlertDialog alertDialog = new AlertDialog.Builder(getActivity()).create();
		private Boolean innerGas = true;
		@Override
		protected void onPreExecute() {
			originalRequestedOrientation = getActivity().getRequestedOrientation();
            getActivity().setRequestedOrientation(getResources().getConfiguration().orientation);
		    dialog.setMessage("Finding cheapest gas stations...");
		    dialog.show();
		    if (lat == 0.0){
		    	final LocationManager manager = (LocationManager) getActivity().getSystemService( Context.LOCATION_SERVICE );
		    	 if ( !manager.isProviderEnabled( LocationManager.GPS_PROVIDER ) ) {
		    		 if ( !manager.isProviderEnabled( LocationManager.NETWORK_PROVIDER ) ) {
		    			 if (dialog.isShowing()) {
				       		 dialog.dismiss();
						}
		    			alertDialog.setTitle("GPS");
			    		alertDialog.setMessage("Can't get location, is GPS on?");
			    		alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
			    		      public void onClick(DialogInterface dialog, int which) {
			    		    	  innerGas = false;
			    		    	  return;
			    		 
			    		    } });
			    		alertDialog.show();   
		    		 }
		    		  
		    	 }
		    }
		}
		@Override
		protected Cursor doInBackground(Void... arg0) {
			try{
	    		
	    		Log.d("LAT",String.valueOf(lat)); 
	    		Parser parser = null;
	    		gas = new ArrayList<Gas>();
	    		Gas thisGas = new Gas();
	    		try{
	    			String url = "http://m.gasbuddy.com/GasPriceSearch.aspx?&n=1&plat=" + String.valueOf(lat) + "&plng=" + String.valueOf(lon);
	    			parser = new Parser (url);
	    			try{
	                	TagNameFilter filter0 = new TagNameFilter ("th");//th
	                	HasAttributeFilter filter1 = new HasAttributeFilter ("class","g");//scope,col
	                	TagNameFilter filter2 = new TagNameFilter ("td");
	                	HasAttributeFilter filter3 = new HasAttributeFilter ("class","a");
	                	HasAttributeFilter filter4 = new HasAttributeFilter ("class","c");
	                	
	                	AndFilter filter5 = new AndFilter (filter0,filter1);
	                	AndFilter filter6 = new AndFilter (filter2,filter3);
	                	AndFilter filter7 = new AndFilter (filter2,filter4);
	                	OrFilter filter8 = new OrFilter(filter5,filter6);
	                	OrFilter filter9 = new OrFilter(filter8,filter7);
	        	        NodeIterator iterator3 = parser.extractAllNodesThatMatch(filter9).elements();
	        	        Integer x = 1;
	        	        //LinkedHashMap hm = new LinkedHashMap();
	        	        while(iterator3.hasMoreNodes()){
	        	        	if (x == 5){
	        	        		gas.add(thisGas);
	        	        		thisGas = new Gas();
	        	        		x = 1;
	        	        	}
	        	        	if ( x == 1 ){
	        	        		String gas_price = iterator3.nextNode().toPlainTextString();
	        	        		//gas_price = gas_price.replaceAll("[\r\n]+", " "); 
	        	        		gas_price = ltrim(gas_price);
	        	        		gas_price = rtrim(gas_price);
	        	        		gas_price = gas_price.substring(0, gas_price.indexOf("u"));
	            	        	thisGas.setGas_price(gas_price);
	        	        	}else if (x == 2){
	        	        		String type2 = iterator3.nextNode().toHtml();
	        	        		String station = type2.substring(type2.indexOf("<b>") + 3, type2.indexOf("</b>"));
	        	        		String address = type2.substring(type2.indexOf("<br />") + 6, type2.indexOf("</a>"));
	        	        		
	        	        		String city = address.substring(address.indexOf(">")+1);
	        	        		address = address.substring(0,address.indexOf("<"));
	        	        		address = address.replace("&amp;", "&");
	        	        		thisGas.setGas_station(station);
	        	        		thisGas.setAddress(address);
	        	        		thisGas.setCity(city);
	            	        	
	        	        	}else if (x == 3){
	        	        		String type2 = iterator3.nextNode().toHtml();
	        	        		String distance = type2.substring(type2.indexOf("<span>") + 6, type2.indexOf("</span>"));
	        	        		thisGas.setDistance(distance);
	        	        	}
	        	        	x++;
	        	        }
	    			}catch (ParserException e) {
	                	System.out.println(e.toString());
	                }
	    		}catch (ParserException el) {
	    			System.out.println(el.toString());
	    		}
	    	} catch (Throwable t){
	    		//Log.e("AndroidNews",t.getMessage(),t);
	    	}
			return null;
		}
		
		@Override		
        protected void onPostExecute(Cursor result) {
			GasAdapter m_adapter;
			m_adapter = new GasAdapter(getActivity(), R.layout.gas_list, gas);
			setListAdapter(m_adapter);
			if (dialog.isShowing()) {
	       		 dialog.dismiss();
			}
			getActivity().setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_SENSOR);
		}
	}
	/* remove leading whitespace */
    public static  String ltrim(String source) {
        return source.replaceAll("^\\s+", "");
    }

    /* remove trailing whitespace */
    public static  String rtrim(String source) {
        return source.replaceAll("\\s+$", "");
    }
}
