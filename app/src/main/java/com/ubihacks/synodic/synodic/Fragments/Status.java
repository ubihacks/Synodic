package com.ubihacks.synodic.synodic.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.SeekBar;
import android.widget.TextView;

import com.github.mikephil.charting.charts.BarChart;
import com.ubihacks.synodic.synodic.R;

public class Status extends BaseFragment {


    private TextView timeSleep;
    private Button sleep;
    private TextView timeDrive;
    private Button drive;
    private TextView timeOffline;
    private Button offline;
    private TextView timeOnline;
    private Button online;
    private TextView driving;
    private TextView shift;
    private TextView cycle;
    private BarChart chart1;
    private SeekBar seekBar2;
    private SeekBar seekBar1;
    private TextView tvXMax;
    private TextView tvYMax;

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
        timeSleep = (TextView) view.findViewById(R.id.timeSleep);
        sleep = (Button) view.findViewById(R.id.sleep);
        timeDrive = (TextView) view.findViewById(R.id.timeDrive);
        drive = (Button) view.findViewById(R.id.drive);
        timeOffline = (TextView) view.findViewById(R.id.timeOffline);
        offline = (Button) view.findViewById(R.id.offline);
        timeOnline = (TextView) view.findViewById(R.id.timeOnline);
        online = (Button) view.findViewById(R.id.online);
        driving = (TextView) view.findViewById(R.id.driving);
        shift = (TextView) view.findViewById(R.id.shift);
        cycle = (TextView) view.findViewById(R.id.cycle);
        chart1 = (BarChart) view.findViewById(R.id.chart1);
        seekBar2 = (SeekBar) view.findViewById(R.id.seekBar2);
        seekBar1 = (SeekBar) view.findViewById(R.id.seekBar1);
        tvXMax = (TextView) view.findViewById(R.id.tvXMax);
        tvYMax = (TextView) view.findViewById(R.id.tvYMax);
    }
}
