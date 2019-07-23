package com.ubihacks.synodic.synodic.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.scichart.charting.modifiers.ModifierGroup;
import com.scichart.charting.visuals.SciChartSurface;
import com.scichart.charting.visuals.annotations.HorizontalAnchorPoint;
import com.scichart.charting.visuals.annotations.TextAnnotation;
import com.scichart.charting.visuals.annotations.VerticalAnchorPoint;
import com.scichart.charting.visuals.axes.IAxis;
import com.scichart.drawing.utility.ColorUtil;
import com.scichart.extensions.builders.SciChartBuilder;
import com.ubihacks.synodic.synodic.ACTIVITIES.StatusChagedActivity;
import com.ubihacks.synodic.synodic.R;
import com.ubihacks.synodic.synodic.utils.actions;

import java.util.Collections;

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
    private TextView txtDriverStatus;
    public Status() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_status, container, false);

        initView(view);
        initDisplayParameters();

        sleep.setOnClickListener(this);
        onDuty.setOnClickListener(this);
        offDuty.setOnClickListener(this);
        drive.setOnClickListener(this);
        return view;
    }

    private void initDisplayParameters() {
        txtDriverStatus.setText(actions.getCurrentDriverStatus().getDriverState());
    }

    private void initView(View view) {
        textDate = (TextView) view.findViewById(R.id.txtDate);
        textConnectionStatus = (TextView) view.findViewById(R.id.txtDriverStatus);
        textTime = (TextView) view.findViewById(R.id.txtTime);
        textSleepTime = (TextView) view.findViewById(R.id.timeSleep);
        txtDriverStatus = (TextView) view.findViewById(R.id.txtDriverStatus);
        sleep = (Button) view.findViewById(R.id.btnSleep);
        driveTime = (TextView) view.findViewById(R.id.shiftTime);
        drive = (Button) view.findViewById(R.id.btnDriving);
        offDuty = (Button) view.findViewById(R.id.btnOffDuty);
        onDuty = (Button) view.findViewById(R.id.btnOnDuty);

        SciChartSurface surface = new SciChartSurface(getContext());
        LinearLayout chartLayout = (LinearLayout) view.findViewById(R.id.chartLayout);
        chartLayout.addView(surface);
        SciChartBuilder.init(getContext());

        final SciChartBuilder sciChartBuilder = SciChartBuilder.instance();

        final IAxis xAxis = sciChartBuilder.newNumericAxis()
                .withAxisTitle("X Axis Title")
                .withVisibleRange(-5, 15)
                .build();

        // Create a numeric Y axis
        final IAxis yAxis = sciChartBuilder.newCategoryDateAxis()
                .withAxisTitle("Y Axis Title").withVisibleRange(1 , 100).build();

        // Create a TextAnnotation and specify the inscription and position for it
        TextAnnotation textAnnotation = sciChartBuilder.newTextAnnotation()
                .withX1(5.0)
                .withY1(55.0)
                .withText("Hello World!")
                .withHorizontalAnchorPoint(HorizontalAnchorPoint.Center)
                .withVerticalAnchorPoint(VerticalAnchorPoint.Center)
                .withFontStyle(20, ColorUtil.White)
                .build();

        // Create interactivity modifiers
        ModifierGroup chartModifiers = sciChartBuilder.newModifierGroup()
                .withPinchZoomModifier().withReceiveHandledEvents(true).build()
                .withZoomPanModifier().withReceiveHandledEvents(true).build()
                .build();

        // Add the Y axis to the YAxes collection of the surface
        Collections.addAll(surface.getYAxes(), yAxis);

        // Add the X axis to the XAxes collection of the surface
        Collections.addAll(surface.getXAxes(), xAxis);

        // Add the annotation to the Annotations collection of the surface
        Collections.addAll(surface.getAnnotations(), textAnnotation);

        // Add the interactions to the ChartModifiers collection of the surface
        Collections.addAll(surface.getChartModifiers(), chartModifiers);


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

    @Override
    public void onStart(){
        super.onStart();
        initDisplayParameters();

    }
}
