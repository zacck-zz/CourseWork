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

import android.support.v7.app.ActionBarActivity;
import android.content.ContentValues;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends ActionBarActivity implements OnClickListener  {
	Button btnReg,btnLogIn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		btnReg = (Button)findViewById(R.id.btnSignUp);
		btnLogIn = (Button)findViewById(R.id.btnLogIn);

	}
	@Override
	protected void onResume() {
		super.onResume();
		btnReg.setOnClickListener(this);
		btnLogIn.setOnClickListener(this);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
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
	public void onClick(View v) {
		
		switch(v.getId())
		{
		case R.id.btnLogIn:
			startActivity(new Intent(MainActivity.this, ATContainer.class));
			break;
		case R.id.btnSignUp:
			startActivity(new Intent(MainActivity.this, registerActivity.class));
			break;
		}
		
	}
	
	public class logUser extends AsyncTask<ContentValues, Void, Integer>
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
