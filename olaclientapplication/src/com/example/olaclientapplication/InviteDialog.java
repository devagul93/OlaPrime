package com.example.olaclientapplication;

import java.util.ArrayList;
import java.util.List;

import org.w3c.dom.ls.LSInput;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class InviteDialog extends DialogFragment {
	TextView t;
	Button button_ridealone, button_addfriends;
	List<Contact> contactlist = new ArrayList<Contact>();

	public interface DialogActionListener {
		public void onSendClickListener(DialogFragment dialog);

	}

	public InviteDialog(List<Contact> contacts) {
		contactlist = contacts;
	}

	public InviteDialog() {

	}
	

	// DialogActionListener mlistener;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		//TrackRideActivity trackacitivity = (TrackRideActivity) activity;
		// this.contactlist = trackacitivity.contactlisttrackactivity;
		/*
		 * try{ mlistener = (DialogActionListener)activity; }
		 * catch(ClassCastException e) { // The activity doesn't implement the
		 * interface, throw exception throw new
		 * ClassCastException(activity.toString() +
		 * " must implement NoticeDialogListener"); }
		 */
	}

	@Override
	@NonNull
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		View v = getActivity().getLayoutInflater().inflate(
				R.layout.dialog_success, null);
		t = (TextView) v.findViewById(R.id.textView_succ_message);
		button_addfriends = (Button) v
				.findViewById(R.id.button_successdialog_main_addfriends);
		button_ridealone = (Button) v
				.findViewById(R.id.button_successdialog_main_ride_alone);
		button_ridealone.setText("CANCEL");
		button_addfriends.setText("ACCEPT");

		builder.setView(v);
		t.setText("Respond to the Request");
		button_addfriends.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// mlistener.onSendClickListener(PanicDialog.this);
				// fire a listview dialog
				Toast.makeText(getActivity(), "Ride Shared", Toast.LENGTH_SHORT)
						.show();

				/*
				 * ListDialog dialog = new ListDialog(contactlist);
				 * dialog.show(getActivity().getSupportFragmentManager(), "");
				 * getActivity
				 * ().getSupportFragmentManager().beginTransaction().remove
				 * (InviteDialog.this).commit();
				 */
				dismiss();
			}
		});

		Dialog dialog = builder.create();

		return dialog;
	}

}
