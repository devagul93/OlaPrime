package com.rahulaswani.olahack;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.widget.Toast;

import com.parse.ParsePush;
import com.parse.ParsePushBroadcastReceiver;

public class MyReciever extends ParsePushBroadcastReceiver{

	@Override
	protected void onPushOpen(Context arg0, Intent arg1) {
		// TODO Auto-generated method stub
		Toast.makeText(arg0, "working", Toast.LENGTH_LONG).show();
		//arg0.startActivity(new Intent(arg0,MainActivity.class));
		//InviteDialog dialog = new InviteDialog();
		//dialog.show(arg0.get, tag)
		
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
		SharedPreferences prefs = 
				context.getSharedPreferences("MyPrefs", context.MODE_PRIVATE);
				SharedPreferences.Editor editor = prefs.edit();
				editor.putBoolean("showDialog", true);
				editor.commit();
		Toast.makeText(context, "push recieved", Toast.LENGTH_SHORT).show();
		Intent i = new Intent(context, TrackRideActivity.class);
		
		i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
		context.startActivity(i);
		
		
	}
	
}