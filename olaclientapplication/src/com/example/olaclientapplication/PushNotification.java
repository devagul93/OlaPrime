package com.example.olaclientapplication;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;
import com.parse.ParsePush;
import com.parse.ParseQuery;

public class PushNotification extends Activity {
	Button b;
	EditText et;
	List<String> numberlist = new ArrayList<String>();
	String[] numarray = {"8867400745","8754402809","9880002967"};
	public void fillnumberlist(){
		for(int i = 0;i<3;i++){
			numberlist.add(numarray[i]);
		}
	}
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Find users near a given location

		
		et = (EditText) findViewById(R.id.editText1);
		b = (Button) findViewById(R.id.button1);
		b.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				for(String s: numberlist){
					String number = s;
					Toast.makeText(getBaseContext(), "dhakka de diya",
							Toast.LENGTH_SHORT).show();
					ParseQuery userQuery = new ParseQuery<ParseObject>("userClass");
					// userQuery.whereWithinMiles("location", stadiumLocation, 1.0)
					userQuery.whereEqualTo("phoneNumber", Integer.valueOf(number));
					// Find devices associated with these users
					ParseQuery pushQuery = ParseInstallation.getQuery();
					pushQuery.whereMatchesQuery("userclass", userQuery);
					
					// Send push notification to query
					ParsePush push = new ParsePush();
					push.setQuery(pushQuery); // Set our Installation query
					push.setMessage("AAaaaaa Aaaa AAaaaah aa aa");
					push.sendInBackground();	
				}
				
			}
		});
	}

}
