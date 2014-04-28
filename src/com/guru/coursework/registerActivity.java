package com.guru.coursework;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;

import android.content.ContentValues;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class registerActivity extends ActionBarActivity implements OnClickListener, OnItemSelectedListener {
	
	EditText etRegName, etPass, etPass2,etStud;
	Spinner AcType;
	Button btRegister;
	ContentValues details;
	String accountT;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_register);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		
		etRegName  = (EditText)findViewById(R.id.etRegUserName);
		etPass = (EditText)findViewById(R.id.etRegPassword);
		etPass2 = (EditText)findViewById(R.id.etRegPassword2);
		etStud = (EditText)findViewById(R.id.etRegStudId);
		AcType = (Spinner)findViewById(R.id.regSpinnerAcc);
		btRegister = (Button)findViewById(R.id.btRegister);
		
		
		btRegister.setOnClickListener(this);
		AcType.setOnItemSelectedListener(this);
	}

	@Override
	public void onClick(View v) {
		switch(v.getId())
		{
		case R.id.btRegister: 
		/*
		 * this is where the registration of the user takes place 
		 * we collect the vars and send them to a server 
		 * 
		 */
			if(etPass.getText().toString().equals(etPass2.getText().toString()))
			{
			details.put("name", etRegName.getText().toString());
			details.put("pass", etPass.getText().toString());
			
			}
			else
			{
			
			}
			
			
			break;
		}
		
	}

	@Override
	public void onItemSelected(AdapterView<?> parent, View v, int pos,
			long arg3) {
		switch(pos)
		{
		case 0:
			accountT = "1";
			break;
		case 1:
			accountT = "2";
			break;
		}
		
	}

	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		accountT = "2";
	}
	
	public class regUser extends AsyncTask<ContentValues, Void, Integer>
	{

		@Override
		protected Integer doInBackground(ContentValues... cv) {
			ContentValues cvs = cv[0];
			HttpClient regClient = new DefaultHttpClient();
			HttpPost regPost = new HttpPost("http://");
			
			try
			{
				List<NameValuePair> nvps = new ArrayList<NameValuePair>(4);
				nvps.add(new BasicNameValuePair("uname",cvs.getAsString("name")));
				nvps.add(new BasicNameValuePair("atype",cvs.getAsString("atype")));
				nvps.add(new BasicNameValuePair("scode",cvs.getAsString("scode")));
				nvps.add(new BasicNameValuePair("pphrase",cvs.getAsString("pphrase")));
		        regPost.setEntity(new UrlEncodedFormEntity(nvps));

				
				//post 
				HttpResponse rspy = regClient.execute(regPost);
			}
			catch(Exception e)
			{
				Log.d("THis is the reg CODE", e.toString());
			}	
			return null;
		}
		
	}
	
	
	

}
