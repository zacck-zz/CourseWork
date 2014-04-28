package com.guru.coursework;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AttendanceFragment extends Fragment {

	public static final String ARG_SECTION_NUMBER = "placeholder_text";

	public AttendanceFragment() {

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View attendanceView = inflater.inflate(
				R.layout.attendance_timetable_view, container, false);

		return attendanceView;
	}

}
