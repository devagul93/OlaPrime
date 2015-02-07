package com.example.olaclientapplication;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class SuccessDialog extends DialogFragment{
	
	Button button_ridealone, button_addfriends;
	
	public interface DialogActionListener{
		public void onSendClickListener(DialogFragment dialog);
			
		}
		
		
		//DialogActionListener mlistener;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		
		/*try{
		mlistener = (DialogActionListener)activity;
		}
			catch(ClassCastException e) {
	            // The activity doesn't implement the interface, throw exception
	            throw new ClassCastException(activity.toString()
	                    + " must implement NoticeDialogListener");
	        }
*/
		}
	
	@Override
	@NonNull
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		View v= getActivity().getLayoutInflater().inflate(R.layout.dialog_success, null);
		 button_addfriends = (Button) v.findViewById(R.id.button_successdialog_main_addfriends);
		 button_ridealone = (Button) v.findViewById(R.id.button_successdialog_main_ride_alone);

		builder.setView(v);
				button_addfriends.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//mlistener.onSendClickListener(PanicDialog.this);
				//fire a listview dialog
				ListDialog dialog = new ListDialog();
				dialog.show(getActivity().getSupportFragmentManager(), "");
				getActivity().getSupportFragmentManager().beginTransaction().remove(SuccessDialog.this).commit();
			dismiss();
			}
		});
		
		
		Dialog dialog = builder.create();
		
		return dialog;
	}

}
