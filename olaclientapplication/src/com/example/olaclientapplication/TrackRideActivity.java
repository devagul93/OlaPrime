package com.example.olaclientapplication;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSInput;

import com.example.olaclientapplication.ListDialogSent.DialogActionListenerSent;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TrackRideActivity extends ActionBarActivity implements
		DialogActionListenerSent {

	List<Contact> friend = new ArrayList<Contact>();
	LinearLayout linearlayout_fixed;
	RelativeLayout linearlayout_f1, linearlayout_f2, linearlayout_f3;
	List<Contact> contactlisttrackactivity = new ArrayList<Contact>();
	List<String> numberlist = new ArrayList<String>();
	String[] numarray = { "8754402809", "9880002967", "8867400745" };
	String[] olafriendnames = { "parth", "rahul", "bharath" };
	RelativeLayout[] linlayoutarray = { linearlayout_f1, linearlayout_f2,
			linearlayout_f3 };
	TextView textviewp1, textviewp2, textviewp3;
	TextView[] textviewarray = { textviewp1, textviewp2, textviewp3 };
	int[] olafriendimages = { R.drawable.ic_parth, R.drawable.ic_rahul,
			R.drawable.ic_bharath };

	public void fillnumberlist() {
		contactlisttrackactivity.clear();
		for (int i = 0; i < 3; i++) {

			contactlisttrackactivity.add(i, new Contact(olafriendnames[i],
					numarray[i], olafriendimages[i]));
			// numberlist.add(numarray[i]);
		}
	}

	public void initialiseFriendsOverlay(List<Contact> olafriends) {
		linearlayout_fixed = (LinearLayout) findViewById(R.id.fixedll);
		linearlayout_f1 = (RelativeLayout) findViewById(R.id.llperson1);
		linearlayout_f2 = (RelativeLayout) findViewById(R.id.llperson2);
		linearlayout_f3 = (RelativeLayout) findViewById(R.id.llperson3);
		linearlayout_f1.setVisibility(View.GONE);
		linearlayout_f2.setVisibility(View.GONE);
		linearlayout_f3.setVisibility(View.GONE);
		linearlayout_fixed.setVisibility(View.VISIBLE);
		int i = 0;
		List<Contact> friend = olafriends;
		switch (olafriends.size()) {
		
		case 1:setOneName(friend);

			break;
		case 2:setTwoName(friend);

			break;
		case 3:setThreeName(friend);

			break;

		default:
			break;
		}
		/*for (Contact c : olafriends) {

			this.linlayoutarray[i].setVisibility(View.VISIBLE);
			this.textviewarray[i].setVisibility(View.VISIBLE);
			this.textviewarray[i].setText(c.CONTACT_NAME);
			i++;
		}
*/	}

	public void setOneName(List<Contact> friends) {
		linearlayout_f1.setVisibility(View.VISIBLE);
		textviewp1.setText(friends.get(0).CONTACT_NAME);
		
	}

	public void setTwoName(List<Contact> friends) {

		linearlayout_f1.setVisibility(View.VISIBLE);
		textviewp1.setText(friends.get(0).CONTACT_NAME);
		linearlayout_f2.setVisibility(View.VISIBLE);
		textviewp2.setText(friends.get(1).CONTACT_NAME);
	}

	public void setThreeName(List<Contact> friends) {

		linearlayout_f1.setVisibility(View.VISIBLE);
		textviewp1.setText(friends.get(0).CONTACT_NAME);
		linearlayout_f2.setVisibility(View.VISIBLE);
		textviewp2.setText(friends.get(1).CONTACT_NAME);
		linearlayout_f3.setVisibility(View.VISIBLE);
		textviewp3.setText(friends.get(2).CONTACT_NAME);
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		numberlist.clear();
		fillnumberlist();

		LinearLayout linearLayout_slideup;

		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_trackride);
		linearlayout_f1 = (RelativeLayout) findViewById(R.id.llperson1);
		linearlayout_f2 = (RelativeLayout) findViewById(R.id.llperson2);
		linearlayout_f3 = (RelativeLayout) findViewById(R.id.llperson3);
		textviewp1 = (TextView) findViewById(R.id.textViewp1);
		textviewp2 = (TextView) findViewById(R.id.textViewp2);
		textviewp3 = (TextView) findViewById(R.id.textViewp3);

		/*
		 * for(RelativeLayout l: linlayoutarray){ l.setVisibility(View.GONE); }
		 */
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
				transaction.add(R.id.relativeLayout_parent_trackeractivity,
						fragment, "ContactlistFragment");
				transaction.setCustomAnimations(R.anim.slide_in_up,
						R.anim.slide_out_up);
				transaction.addToBackStack(null);
				transaction.commit();
			}
		});
	}

	@Override
	public void onSendClickListener(List<Contact> selected_contacts) {
		// TODO Auto-generated method stub
		initialiseFriendsOverlay(selected_contacts);
	}

}
