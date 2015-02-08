package com.rahulaswani.olahack;

import java.util.ArrayList;
import java.util.List;


import com.paresh.RoundImage;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class ListDialog extends DialogFragment implements OnItemClickListener{
	
	String[] numarray = {"8754402809","9880002967","8867400745"};
	String[] olafriendnames = { "parth", "rahul, bharath"};
	int[] olafriendimages = {R.drawable.ic_parth, R.drawable.ic_rahul, R.drawable.ic_bharath};
	List<String> contactnames = new ArrayList<String>();
	MyArrayAdapter adapter;
	Button button_invite, button_cancel;
	ListView listview_contactlist;
	List<Contact> lsit_contact = new ArrayList<Contact>();
	public interface DialogActionListener{
		public void onSendClickListener(DialogFragment dialog);
			
		}
	public ListDialog(List<Contact> contacts){
		this.lsit_contact = contacts;
	}
	public void fill_contacts(){
		lsit_contact.clear();
		for(int i= 0;i<3;i++){
			lsit_contact.add(i,new Contact(olafriendnames[i], numarray[i], olafriendimages[i]));
		}
	}
	public ListDialog(){
		
	}
		
		
		//DialogActionListener mlistener;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		TrackRideActivity trackactivity = (TrackRideActivity) activity;
		//trackactivity.numberlist
		//fill_contacts();
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
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.dialog_contactlist, null, false);
		listview_contactlist = (ListView) view.findViewById(R.id.listView_dialog_contactlist);
		 button_cancel = (Button) view.findViewById(R.id.button_listdialog_cancel);
		 button_invite = (Button) view.findViewById(R.id.button_listdialog_invite);
		button_invite.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				ListDialogSent dialogsent = new ListDialogSent(lsit_contact);
				dialogsent.show(getActivity().getSupportFragmentManager(), "");
				getActivity().getSupportFragmentManager().beginTransaction().remove(ListDialog.this).commit();
			}
		});
				button_cancel.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				//mlistener.onSendClickListener(PanicDialog.this);
				//fire a listview dialog
			dismiss();
			}
		});
		
		getDialog().getWindow().requestFeature(Window.FEATURE_NO_TITLE);
		return view;
	}
	
	@Override
	public void onActivityCreated(Bundle arg0) {
		// TODO Auto-generated method stub
		super.onActivityCreated(arg0);
		
		adapter = new MyArrayAdapter(getActivity(), R.layout.item_contactlist, lsit_contact);
		listview_contactlist.setAdapter(adapter);
		listview_contactlist.setOnItemClickListener(this);
	}
	
	
	
	public class MyArrayAdapter extends ArrayAdapter{

		public MyArrayAdapter(Context context, int resource, List objects) {
			super(context, resource, objects);
			// TODO Auto-generated constructor stub
			
		}
		
		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub
			
				LayoutInflater inflater  = getActivity().getLayoutInflater();
				View v= inflater.inflate(R.layout.item_contactlist, parent, false);
				ImageView imageview_contactimage = (ImageView) v.findViewById(R.id.imageView_itemcontactlist);
				ImageView imageview_item_cross  = (ImageView) v.findViewById(R.id.imageView_itemcontactlist_cross);
				ImageView imageview_item_add = (ImageView) v.findViewById(R.id.imageView_itemcontactlist_add);
				TextView textview_item_contactname = (TextView) v.findViewById(R.id.textView_itemcontactlist);
				textview_item_contactname.setText(lsit_contact.get(position).CONTACT_NAME.toString());
				Drawable drawable = getResources().getDrawable(lsit_contact.get(position).Imageres);
				imageview_contactimage.setImageDrawable(RoundImage.getRoundDrawable(drawable));
				if(lsit_contact.get(position).isSelected){
					imageview_item_cross.setVisibility(View.VISIBLE);
					imageview_item_add.setVisibility(View.GONE);
				}else{
					imageview_item_cross.setVisibility(View.GONE);
					imageview_item_add.setVisibility(View.VISIBLE);
				}
				
			
			return v;
		}
	}


	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub
		if(lsit_contact.get(arg2).isSelected){
			lsit_contact.get(arg2).isSelected = false;
		}else
			lsit_contact.get(arg2).isSelected = true;
		adapter.notifyDataSetChanged();
	}
	

}
