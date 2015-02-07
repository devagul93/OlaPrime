package com.example.olaclientapplication;

import java.util.ArrayList;
import java.util.List;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.LinearLayout;

public class TrackRideActivity extends ActionBarActivity {

	LinearLayout linearlayout_fixed;
	List<Contact> contactlisttrackactivity = new ArrayList<Contact>();
	List<String> numberlist = new ArrayList<String>();
	String[] numarray = {"8754402809","9880002967","8867400745"};
	String[] olafriendnames = { "parth", "rahul","bharath"};
	
	int[] olafriendimages = {R.drawable.ic_parth, R.drawable.ic_rahul, R.drawable.ic_bharath};
	public void fillnumberlist(){
		contactlisttrackactivity.clear();
		for(int i = 0;i<3;i++){
			
			contactlisttrackactivity.add(i,new Contact(olafriendnames[i], numarray[i], olafriendimages[i]));
		//	numberlist.add(numarray[i]);
		}
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		numberlist.clear();
		fillnumberlist();
		
		LinearLayout linearLayout_slideup;
		
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trackride);
		linearlayout_fixed = (LinearLayout) findViewById(R.id.fixedll);
		linearlayout_fixed.setVisibility(View.GONE);
		SuccessDialog dialog = new SuccessDialog(contactlisttrackactivity);
		dialog.show(getSupportFragmentManager(), "");
		linearLayout_slideup = (LinearLayout) findViewById(R.id.linearLayout1);
		linearLayout_slideup.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				DriverDetailsFragment fragment = new DriverDetailsFragment();
				FragmentManager manager = getSupportFragmentManager();
				FragmentTransaction transaction = manager.beginTransaction();
				transaction.add(R.id.relativeLayout_parent_trackeractivity, fragment, "ContactlistFragment");
				transaction.setCustomAnimations(R.anim.slide_in_up, R.anim.slide_out_up);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
	}

}
