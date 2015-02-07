package com.example.olaclientapplication;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import com.parse.ParsePushBroadcastReceiver;

public class MyReciever extends ParsePushBroadcastReceiver{

	@Override
	protected void onPushOpen(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		Toast.makeText(arg0, "working", Toast.LENGTH_LONG).show();
		arg0.startActivity(new Intent(arg0,MainActivity.class));
	}

	@Override
	protected void onPushReceive(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		super.onPushReceive(arg0, arg1);
	}

	@Override
	public void onReceive(Context context, Intent intent) {
		// TODO Auto-generated method stub
		super.onReceive(context, intent);
	}
	
}