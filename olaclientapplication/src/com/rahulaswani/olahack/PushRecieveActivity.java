package com.rahulaswani.olahack;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;

public class PushRecieveActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.push_receive_activity);
		InviteDialog dialog = new InviteDialog();

	}
}
