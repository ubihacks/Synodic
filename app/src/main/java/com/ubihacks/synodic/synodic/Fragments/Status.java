package com.ubihacks.synodic.synodic.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.ubihacks.synodic.synodic.R;
import com.ubihacks.synodic.synodic.StatusChagedActivity;

public class Status extends BaseFragment {


    private TextView textView9;
    private TextView textView8;
    private TextView textView7;
    private TextView timeSleep;
    private Button sleep;
    private TextView driveTime;
    private BarChart chart1;
    private Button drive;

    public Status() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_status, container, false);

        initView(view);

        sleep.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), StatusChagedActivity.class));

            }
        });

        drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });


        return view;

    }


    private void initView(View view) {
        textView9 = (TextView) view.findViewById(R.id.txtDate);
        textView8 = (TextView) view.findViewById(R.id.txtConnectionStatus);
        textView7 = (TextView) view.findViewById(R.id.txtTime);
        timeSleep = (TextView) view.findViewById(R.id.timeSleep);
        sleep = (Button) view.findViewById(R.id.btnSleep);
        driveTime = (TextView) view.findViewById(R.id.shiftTime);
        chart1 = (BarChart) view.findViewById(R.id.activityChart);
        drive = (Button) view.findViewById(R.id.btnDrive);
    }
}
