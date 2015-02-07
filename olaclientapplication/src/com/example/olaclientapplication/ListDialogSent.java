package com.example.olaclientapplication;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

import com.example.olaclientapplication.ListDialogSent.MyArrayAdapter;

public class ListDialogSent extends DialogFragment implements
		OnItemClickListener {

	MyArrayAdapter adapter;
	Button button_invite, button_cancel;
	ListView listview_contactlist;
	List<Contact> lsit_contact = new ArrayList<Contact>();

	public interface DialogActionListenerSent {
		public void onSendClickListener(DialogFragment dialog);

	}

	public void fill_contacts() {
		for (int i = 0; i < 3; i++) {
			lsit_contact.add(new Contact("contact person" + i));
		}
	}

	// DialogActionListener mlistener;
	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);
		fill_contacts();
		/*
		 * try{ mlistener = (DialogActionListener)activity; }
		 * catch(ClassCastException e) { // The activity doesn't implement the
		 * interface, throw exception throw new
		 * ClassCastException(activity.toString() +
		 * " must implement NoticeDialogListener"); }
		 */
	}

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.dialog_contactlist, null, false);
		listview_contactlist = (ListView) view
				.findViewById(R.id.listView_dialog_contactlist);
		button_cancel = (Button) view
				.findViewById(R.id.button_listdialog_cancel);
		button_invite = (Button) view
				.findViewById(R.id.button_listdialog_invite);
		button_cancel.setText("DONE");
		button_invite.setText("ADD MORE");
		button_invite.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub

			}
		});
		button_cancel.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				// mlistener.onSendClickListener(PanicDialog.this);
				// fire a listview dialog
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

		adapter = new MyArrayAdapter(getActivity(), R.layout.item_contactlist,
				lsit_contact);
		listview_contactlist.setAdapter(adapter);
		listview_contactlist.setOnItemClickListener(this);
	}

	public class MyArrayAdapter extends ArrayAdapter {

		public MyArrayAdapter(Context context, int resource, List objects) {
			super(context, resource, objects);
			// TODO Auto-generated constructor stub

		}

		@Override
		public View getView(int position, View convertView, ViewGroup parent) {
			// TODO Auto-generated method stub

			LayoutInflater inflater = getActivity().getLayoutInflater();
			View v = inflater.inflate(R.layout.item_contactlist, parent, false);
			ImageView imageview_item_cross = (ImageView) v
					.findViewById(R.id.imageView_itemcontactlist_cross);
			ImageView imageview_item_add = (ImageView) v
					.findViewById(R.id.imageView_itemcontactlist_add);
			TextView textview_item_contactname = (TextView) v
					.findViewById(R.id.textView_itemcontactlist);
			textview_item_contactname
					.setText(lsit_contact.get(position).CONTACT_NAME.toString());
			if (lsit_contact.get(position).isSelected) {
				imageview_item_cross.setVisibility(View.VISIBLE);
				imageview_item_add.setVisibility(View.GONE);
			} else {
				imageview_item_cross.setVisibility(View.GONE);
				imageview_item_add.setVisibility(View.VISIBLE);
			}

			return v;
		}
	}

	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}

}
