package com.example.olaclientapplication;


import com.parse.Parse;
import com.parse.ParseInstallation;
import com.parse.ParseObject;

import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.internal.widget.AdapterViewCompat;
import android.support.v7.internal.widget.AdapterViewCompat.OnItemClickListener;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity implements  android.widget.AdapterView.OnItemClickListener {

	Button button_ridenow, button_ridelater, button_confirm, button_cancel;
	ImageButton imagebutton_categories, imagebutton_rideestimatedummy;
	LinearLayout linlay_categories;
	private DrawerLayout drawerLayout;
	ListView listView;
	private String[] titles;
	MyAdapterAppDrawer appdraweradapter;

	ActionBarDrawerToggle drawerListener;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		Parse.initialize(this, "luzR0xGWsehSOv0ScGcxnmbVmFe2Enir91ktQgfJ",
				"4aWdo1kuq8Q45DdbH7TftPVCoLZChuzRJk9HqljT");
		ParseInstallation installation = ParseInstallation
				.getCurrentInstallation();
		//change the object for different users here;
		installation.put("userclass",
				ParseObject.createWithoutData("userclass", "ZDYAPVwEC5"));
		installation.saveInBackground();
		
		titles = getResources().getStringArray(R.array.navlist);
		linlay_categories = (LinearLayout) findViewById(R.id.linlayout_activity_main_rides);
		imagebutton_rideestimatedummy = (ImageButton) findViewById(R.id.imageButton_activity_main_rideestimate);
		imagebutton_rideestimatedummy.setVisibility(View.GONE);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawerLayout);
		button_ridenow = (Button) findViewById(R.id.button_activity_main_ride_now);
		button_confirm = (Button) findViewById(R.id.button_activity_main_confirm);
		button_ridelater = (Button) findViewById(R.id.button_activity_main_ride_later);
		button_cancel = (Button) findViewById(R.id.button_activity_main_cancel);
		button_cancel.setVisibility(View.GONE);
		button_confirm.setVisibility(View.GONE);
		listView = (ListView) findViewById(R.id.drawerListView);
		appdraweradapter = new MyAdapterAppDrawer(this);
		listView.setAdapter(appdraweradapter);
		listView.setOnItemClickListener(this);
		drawerListener = new ActionBarDrawerToggle(MainActivity.this, drawerLayout, R.drawable.ic_menu_dark, R.string.drawer_open, R.string.drawer_close);
		drawerLayout.setDrawerListener(drawerListener);
		button_ridenow.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				button_cancel.setVisibility(View.VISIBLE);
				button_confirm.setVisibility(View.VISIBLE);
				button_ridelater.setVisibility(View.GONE);
				linlay_categories.setVisibility(View.GONE);
				button_ridenow.setVisibility(View.GONE);
	//			imagebutton_categories.setVisibility(View.GONE);
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
		getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onPostCreate(savedInstanceState);
		drawerListener.syncState();
	}
	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		// TODO Auto-generated method stub
		super.onConfigurationChanged(newConfig);
		drawerListener.onConfigurationChanged(newConfig);
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
		if(drawerListener.onOptionsItemSelected(item)){
			return true;
		}
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		if (arg2 == 0) {
			
			/*FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
			trans.replace(R.id.relativelayout_activity_help, new ContactListFragment());
			trans.commit();*/
//			startActivity(new Intent(this, ContactListActivity.class));
	//		drawerLayout.closeDrawers();
			
		} else if (arg2 == 1) {
			//preset locations
			/*FragmentTransaction trans = getSupportFragmentManager().beginTransaction();
			trans.replace(R.id.relativelayout_activity_help, new PresetLocationsFragment());
			trans.commit();
			drawerLayout.closeDrawers();*/
			
		} else if (arg2 == 2) {
			//startActivity(new Intent(this,SearchViewActivity.class));
		} else if (arg2 == 3) {
			//lalunchsettings();
		} else if (arg2 == 4) {

		}
	}
	
	/***************************************** adapter for nav drawer ******************************************************/

	class MyAdapterAppDrawer extends BaseAdapter {

		String[] items;

		public MyAdapterAppDrawer(Context context) {
			items = context.getResources().getStringArray(R.array.navlist);

		}

		@Override
		public int getCount() {
			// TODO Auto-generated method stub
			return items.length;
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return titles[position];
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			View v = getLayoutInflater().inflate(R.layout.custom_row, parent,
					false);
			TextView textview_title = (TextView) v.findViewById(R.id.textview_customrow);
			textview_title.setText(titles[position]);
			return v;
		}

	}


	
	
	
}
