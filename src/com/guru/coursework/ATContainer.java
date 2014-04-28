package com.guru.coursework;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBar.Tab;
import android.support.v7.app.ActionBar.TabListener;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

public class ATContainer extends ActionBarActivity implements TabListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tabs_container);

		// init them tabs bro
		// set mode of action bar to tabs
		final ActionBar actionBar = getSupportActionBar();
		actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

		// add two tabs
		actionBar.addTab(actionBar.newTab().setText("TimeTable")
				.setTabListener(this));
		actionBar.addTab(actionBar.newTab().setText("Attendance")
				.setTabListener(this));
	}

	@Override
	public void onTabReselected(Tab arg0, FragmentTransaction arg1) {

	}

	@Override
	public void onTabSelected(Tab t, FragmentTransaction ft) {

		switch (t.getPosition()) {
		case 0:
			Fragment frag = new TimeTableFragment();
			Bundle tBundle = new Bundle();
			tBundle.putInt(TimeTableFragment.ARG_SECTION_NUMBER,
					t.getPosition() + 1);
			frag.setArguments(tBundle);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.tabsContainer, frag).commit();
			break;
		case 1:
			Fragment fragAt = new AttendanceFragment();
			Bundle ABundle = new Bundle();
			ABundle.putInt(AttendanceFragment.ARG_SECTION_NUMBER,
					t.getPosition() + 1);
			fragAt.setArguments(ABundle);
			getSupportFragmentManager().beginTransaction()
					.replace(R.id.tabsContainer, fragAt).commit();
			break;
		}

	}

	@Override
	public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater minf = getMenuInflater();
		minf.inflate(R.menu.atcontainer_menu, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.action_contact:
			startActivity(new Intent(ATContainer.this, ContactDetails.class));
			return true;
		case R.id.action_personal_details:
			startActivity(new Intent(ATContainer.this, DetailsActivity.class));

			return true;
		case R.id.action_course_Progress:
			startActivity(new Intent(ATContainer.this, CourseProgress.class));
			return true;
		case R.id.action_send_message:
			startActivity(new Intent(ATContainer.this, Messages.class));
			return true;


		default:
			return super.onOptionsItemSelected(item);

		}

	}

}
