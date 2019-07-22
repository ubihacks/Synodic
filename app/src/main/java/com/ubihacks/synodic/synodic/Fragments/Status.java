package com.ubihacks.synodic.synodic.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ubihacks.synodic.synodic.R;
import com.ubihacks.synodic.synodic.ACTIVITIES.StatusChagedActivity;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class Status extends BaseFragment implements View.OnClickListener {


    private TextView driveTime;

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
        return view;

    }


    private void initView(View view) {
        textDate = (TextView) view.findViewById(R.id.txtDate);
        textConnectionStatus = (TextView) view.findViewById(R.id.txtDriverStatus);
        textTime = (TextView) view.findViewById(R.id.txtTime);
        textSleepTime = (TextView) view.findViewById(R.id.timeSleep);
        sleep = (Button) view.findViewById(R.id.btnSleep);
        driveTime = (TextView) view.findViewById(R.id.shiftTime);
        drive = (Button) view.findViewById(R.id.btnDriving);
        offDuty = (Button) view.findViewById(R.id.btnOffDuty);
        onDuty = (Button) view.findViewById(R.id.btnOnDuty);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btnOnDuty:
                startActivity(new Intent(getContext(), StatusChagedActivity.class));
                break;
            case R.id.btnOffDuty:
                startActivity(new Intent(getContext(), StatusChagedActivity.class));
                break;
            case R.id.btnSleep:
                startActivity(new Intent(getContext(), StatusChagedActivity.class));
                break;
            case R.id.btnDriving:
                startActivity(new Intent(getContext(), StatusChagedActivity.class));
                break;
        }
    }
}
