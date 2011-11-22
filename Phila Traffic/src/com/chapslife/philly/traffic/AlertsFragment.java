package com.chapslife.philly.traffic;

import java.util.ArrayList;

import com.chapslife.philly.traffic.adapters.AlertsAdapter;
import com.chapslife.philly.traffic.utils.AndroidSaxFeedParser;
import com.chapslife.philly.traffic.utils.FeedParser;
import com.chapslife.philly.traffic.utils.Message;
import com.chapslife.philly.traffic.utils.ParserType;
import com.chapslife.philly.traffic.R;

import android.os.Bundle;
import android.support.v4.app.ListFragment;

public class AlertsFragment extends ListFragment {

	
	private ArrayList<Message> messages;

	@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        loadFeed(ParserType.ANDROID_SAX, "http://twitter.com/statuses/user_timeline/TotalTrafficPHL.rss");
	}
	
	private void loadFeed(ParserType type, String url){
		try{
			AlertsAdapter mAdapter;
			FeedParser parser = new AndroidSaxFeedParser(url);
			messages = (ArrayList<Message>) parser.parse();
			mAdapter = new AlertsAdapter(getActivity(), R.layout.alert_list, messages);
			setListAdapter(mAdapter);
		}catch(Throwable t){
			
		}
	}
}
