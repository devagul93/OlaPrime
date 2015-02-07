package com.example.olaclientapplication;

import com.example.olahack.BaseActivity.MyAdapterAppDrawer;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.internal.widget.AdapterViewCompat.OnItemClickListener;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity implements OnItemClickListener {

	Button button_ridenow, button_ridelater, button_confirm, button_cancel;
	ImageButton imagebutton_categories, imagebutton_rideestimatedummy;
	private DrawerLayout drawerLayout;
	ListView listView;
	private String[] titles;
	MyAdapterAppDrawer appdraweradapter;

	ActionBarDrawerToggle drawerListener;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		titles = getResources().getStringArray(R.array.navlist);
		listView = (ListView) findViewById(R.id.drawerListView);
		
		imagebutton_categories = (ImageButton) findViewById(R.id.imageButton_activity_main_categories);
		imagebutton_rideestimatedummy = (ImageButton) findViewById(R.id.imageButton_activity_main_rideestimate);
		imagebutton_rideestimatedummy.setVisibility(View.GONE);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		button_ridenow = (Button) findViewById(R.id.button_activity_main_ride_now);
		button_confirm = (Button) findViewById(R.id.button_activity_main_confirm);
		button_ridelater = (Button) findViewById(R.id.button_activity_main_ride_later);
		button_cancel = (Button) findViewById(R.id.button_activity_main_cancel);
		button_cancel.setVisibility(View.GONE);
		button_confirm.setVisibility(View.GONE);
		button_ridenow.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				button_cancel.setVisibility(View.VISIBLE);
				button_confirm.setVisibility(View.VISIBLE);
				button_ridelater.setVisibility(View.GONE);
				button_ridenow.setVisibility(View.GONE);
				imagebutton_categories.setVisibility(View.GONE);
				imagebutton_rideestimatedummy.setVisibility(View.VISIBLE);
			}
		});
		button_confirm.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Intent i = new Intent(getBaseContext(),TrackRideActivity.class);
				startActivity(i);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterViewCompat<?> arg0, View arg1, int arg2,
			long arg3) {
		// TODO Auto-generated method stub
		
	}
}
