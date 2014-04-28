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
import org.apache.http.util.EntityUtils;

import android.content.Entity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TimeTableFragment extends Fragment {

	public static final String ARG_SECTION_NUMBER = "placeholder_text";

	public TimeTableFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View TimeTableView = inflater.inflate(
				R.layout.attendance_timetable_view, container, false);
		return TimeTableView;
	}
	
	private class ttGetter extends AsyncTask<Void, Void, Void>
	{
		String resp;

		@Override
		protected Void doInBackground(Void... params) {
			// Create a new HttpClient and Post Header
		    HttpClient httpclient = new DefaultHttpClient();
		    HttpPost httppost = new HttpPost("http://www.yoursite.com/script.php");

		    try {
		        // Add your data
		        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
		        nameValuePairs.add(new BasicNameValuePair("id", "1"));
		        nameValuePairs.add(new BasicNameValuePair("stringdata", "AndDev is Cool!"));
		        httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

		        HttpResponse response = httpclient.execute(httppost);
		        resp = EntityUtils.toString(response.getEntity());
		    }
		    catch(Exception e)
		    {
		    	
		    }
			return null;
		}
		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			
			
		}
		
	}

}
