package com.rahulaswani.olahack;

import java.util.ArrayList;
import java.util.List;


import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;

import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.rahulaswani.olahack.ListDialogSent.DialogActionListenerSent;

import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class TrackRideActivity extends ActionBarActivity implements
		DialogActionListenerSent, OnMapClickListener,OnMapLongClickListener, OnCameraChangeListener,
		OnMapReadyCallback {

	Button buttonendride;
	List<Contact> friend = new ArrayList<Contact>();
	LinearLayout linearlayout_fixed, linearlayout_driver;
	LinearLayout linearLayout_slideup;
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
	/***************************maps api********************************************/
	EditText latitude;
	EditText longitude;
	TextView showdist;
	ImageButton ShowDist;
	double lat = 000.000;
	double longi= 000.000;
	float distance,distfrmmid;
	LatLng location;
	double Alat = 12.949900;
	double Alang = 77.642929;
	double Blat = 12.957005;
	double Blang = 77.701196;
	double midlat = 12.9534525;
	double midlong = 77.6720625;
    double radius = 4185.466;
    CircleOptions circleOptions;
    Circle myCircle;
    
    private GoogleMap myMap;
    /******************************************************************************/

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
		buttonendride = (Button) findViewById(R.id.button_endride);
		buttonendride.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				FragmentFragment fragment = new FragmentFragment();
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
		/************maps api*******************************************************/
//MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        

        
        FragmentManager myFragmentManager = getSupportFragmentManager();
        SupportMapFragment  myMapFragment  = (SupportMapFragment)myFragmentManager.findFragmentById(R.id.map);
			
		myMap = myMapFragment.getMap();

		//myMap.setMapType(GoogleMap.MAP_TYPE_HYBRID);
		
		//myMap.setOnMapClickListener(this);
       
        /*latitude = (EditText)findViewById(R.id.latitude);
        String templat = latitude.getText().toString();
        Toast.makeText(this, "value of templat : "+templat, Toast.LENGTH_SHORT).show();
        lat = Double.parseDouble(templat);        
        
        longitude = (EditText)findViewById(R.id.longitude);
        String templongi = longitude.getText().toString();
        Toast.makeText(this, "value of templong : "+templongi, Toast.LENGTH_SHORT).show();
        longi = Double.parseDouble(templongi); */
        
		LatLng A = new LatLng(12.949900, 77.642929);
        LatLng B = new LatLng(12.957005, 77.701196);
        
        myMap.setMyLocationEnabled(true);
        
        myMap.setOnMapLongClickListener(this); 
        
        myMap.addMarker(new MarkerOptions().title("You").position(A));
        myMap.addMarker(new MarkerOptions().title("Destination").position(B));
        
        ShowDist = (ImageButton)findViewById(R.id.show_path);
        ShowDist.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				float[] resultArray = new float[99];
		        Location.distanceBetween(Alat, Alang, Blat, Blang, resultArray);
		        distance = resultArray[0];
		       // showdist = (TextView)findViewById(R.id.distance);
		        //showdist.setText("Distance is "+distance);
		        location=new LatLng(midlat,midlong);
		        
		        
		        
		        CircleOptions circleOptions = new CircleOptions()
				.center(location)		//set center
				.radius(radius)			//set radius in meters
				.fillColor(Color.TRANSPARENT) 	//default
				.strokeColor(Color.BLUE)
				.strokeWidth(5);
		        
		        myMap.moveCamera(CameraUpdateFactory.newLatLngZoom(location, 11));

		        /* myMap.addMarker(new MarkerOptions()
		                .title("Sydney")
		                .snippet("The most populous city in Australia.")
		                .position(sydney)); */
				
				myCircle = myMap.addCircle(circleOptions);
			}
		}); 
	}
	
	/***************************maps funcs********************************/
	@Override    
    public void onMapLongClick(LatLng point) {
    	
    	myMap.clear();
    	
    	/*CircleOptions circleOptions = new CircleOptions()
		.center(location)		//set center
		.radius(radius)			//set radius in meters
		.fillColor(Color.TRANSPARENT) 	//default
		.strokeColor(Color.BLUE)
		.strokeWidth(5);*/
    	
        myMap.addMarker(new MarkerOptions()
            .position(point)
            .title("You are here")           
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED))); 
        
        
        float[] resultArray = new float[99];
        Location.distanceBetween( point.latitude,point.longitude,midlat,midlong, resultArray);
        distfrmmid = resultArray[0];
        System.out.println(" value of distance from radius : "+distfrmmid);
        
        if(distfrmmid < radius)
        {
        	circleOptions = new CircleOptions()
			.center(location)		//set center
			.radius(radius)			//set radius in meters
			.fillColor(Color.GREEN) 	//default
			.strokeColor(Color.GREEN)
			.strokeWidth(5);
        	
        	myCircle = myMap.addCircle(circleOptions);
        	

        }else
        {
        	circleOptions = new CircleOptions()
			.center(location)		//set center
			.radius(radius)			//set radius in meters
			.fillColor(Color.RED) 	//default
			.strokeColor(Color.RED)
			.strokeWidth(5);
        	
        	myCircle = myMap.addCircle(circleOptions);
        }
    }
    
    public void onMapReady(GoogleMap map) {
        LatLng A = new LatLng(12.949900, 77.642929);
        LatLng B = new LatLng(12.957005, 77.701196);
        
        map.setMyLocationEnabled(true);
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(A, 13));
        map.moveCamera(CameraUpdateFactory.newLatLngZoom(B, 13));
        map.addMarker(new MarkerOptions().title("You").position(A));
        map.addMarker(new MarkerOptions().title("Destination").position(B));
    }
    
    public void onMapClick(LatLng point) {
		
	}



	@Override
	public void onCameraChange(CameraPosition arg0) {
		// TODO Auto-generated method stub
		
	}
	/***************************************************************************************/

	@Override
	public void onSendClickListener(List<Contact> selected_contacts) {
		// TODO Auto-generated method stub
		initialiseFriendsOverlay(selected_contacts);
	}

}
