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

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Status extends BaseFragment {


    private TextView driveTime;
    private BarChart activityChart;

    private Button sleep;
    private Button drive;
    private Button onDuty;
    private Button offDuty;
    private TextView textSleepTime;
    private TextView textTime;
    private TextView textConnectionStatus;
    private TextView textDate;

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
        onDuty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), StatusChagedActivity.class));
            }
        });
        offDuty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), StatusChagedActivity.class));
            }
        });
        drive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new SweetAlertDialog(getContext(), SweetAlertDialog.WARNING_TYPE)
                        .setTitleText("Vehicle motion is detected")
                        .setContentText("Do you want to change driver status to DRIVING?")
                        .setConfirmText("Yes")
                        .setCancelText("No")
                        .show();
            }
        });
        return view;

    }


    private void initView(View view) {
        textDate = (TextView) view.findViewById(R.id.txtDate);
        textConnectionStatus = (TextView) view.findViewById(R.id.txtConnectionStatus);
        textTime = (TextView) view.findViewById(R.id.txtTime);
        textSleepTime = (TextView) view.findViewById(R.id.timeSleep);
        sleep = (Button) view.findViewById(R.id.btnSleep);
        driveTime = (TextView) view.findViewById(R.id.shiftTime);
        activityChart = (BarChart) view.findViewById(R.id.activityChart);
        drive = (Button) view.findViewById(R.id.btnDrive);
        offDuty = (Button) view.findViewById(R.id.btnOffDuty);
        onDuty = (Button) view.findViewById(R.id.btnOnDuty);
    }
}
