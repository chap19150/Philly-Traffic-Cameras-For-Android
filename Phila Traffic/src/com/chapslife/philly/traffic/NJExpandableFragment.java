package com.chapslife.philly.traffic;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;

public class NJExpandableFragment extends Fragment {

	private ExpandableListView njEpView;

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_expandablelist, container,false);
        LinearLayout layout = (LinearLayout) root.findViewById(R.id.expandable_list);
        njEpView = new ExpandableListView(getActivity());
        //initialPAData();
        //setupPAView();
        layout.addView(njEpView);
        return root;
	}
}
