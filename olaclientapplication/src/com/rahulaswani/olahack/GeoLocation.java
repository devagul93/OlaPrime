package com.rahulaswani.olahack;

import android.app.Activity;
import android.app.FragmentManager;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.GoogleMap.OnCameraChangeListener;
import com.google.android.gms.maps.GoogleMap.OnMapClickListener;
import com.google.android.gms.maps.GoogleMap.OnMapLongClickListener;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.CameraPosition;
import com.google.android.gms.maps.model.Circle;
import com.google.android.gms.maps.model.CircleOptions;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GeoLocation extends Activity implements OnMapClickListener,OnMapLongClickListener, OnCameraChangeListener,
OnMapReadyCallback {

	EditText latitude;
	EditText longitude;
	TextView showdist;
	Button ShowDist;
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
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.geo_location);

        //MapFragment mapFragment = (MapFragment) getFragmentManager().findFragmentById(R.id.map);
        

        
        FragmentManager myFragmentManager = getFragmentManager();
		MapFragment myMapFragment 
			= (MapFragment)myFragmentManager.findFragmentById(R.id.map);
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
        
        ShowDist = (Button)findViewById(R.id.show_path);
        ShowDist.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) 
			{
				float[] resultArray = new float[99];
		        Location.distanceBetween(Alat, Alang, Blat, Blang, resultArray);
		        distance = resultArray[0];
		        showdist = (TextView)findViewById(R.id.distance);
		        showdist.setText("Distance is "+distance);
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
}