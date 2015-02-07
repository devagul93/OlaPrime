package com.example.olaclientapplication;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.LinearLayout;

public class TrackRideActivity extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {

		LinearLayout linearLayout_slideup;
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trackride);
		SuccessDialog dialog = new SuccessDialog();
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
