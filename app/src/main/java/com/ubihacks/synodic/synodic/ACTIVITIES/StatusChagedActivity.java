package com.ubihacks.synodic.synodic.ACTIVITIES;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.ubihacks.synodic.synodic.API.Api;
import com.ubihacks.synodic.synodic.MyApp;
import com.ubihacks.synodic.synodic.utils.Alerts;
import com.ubihacks.synodic.synodic.utils.actions;
import com.ubihacks.synodic.synodic.R;

import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_DRIVING;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_OFF_DUTY;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_ON_DUTY;
import static com.ubihacks.synodic.synodic.utils.CONSTANTS.STATUS_SLEEP;
import static com.ubihacks.synodic.synodic.utils.actions.fetchGPSLocation;

public class StatusChagedActivity extends BaseActivity implements View.OnClickListener {

    Api api;

    Button onDuty;
    Button offDuty;
    Button driving;
    Button sleeper;
    Button locationFetch;
    Button submit;
    Button cancel;

    EditText driverLocation;
    EditText driverComment;

    TextView txtDriverStatus;
    TextView txtDate;
    TextView txtTime;
    TextView txtConnectionStatus;

    private String selectedStatus = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_status_chaged);
        init();

        api = MyApp.getApi();

        onDuty.setOnClickListener(this);
        offDuty.setOnClickListener(this);
        driving.setOnClickListener(this);
        sleeper.setOnClickListener(this);
        locationFetch.setOnClickListener(this);
        submit.setOnClickListener(this);
        cancel.setOnClickListener(this);


        txtDriverStatus = (TextView) findViewById(R.id.txtDriverStatus);
        txtConnectionStatus = (TextView) findViewById(R.id.txtConnectionStatus);
        txtDate = (TextView) findViewById(R.id.txtDate);
        txtTime = (TextView) findViewById(R.id.txtTime);

        initDisplayParameters();
    }

    private void initDisplayParameters() {
        txtDriverStatus.setText(actions.getCurrentDriverStatus().getDriverState());
        txtConnectionStatus.setText(actions.getCurrentConntectionStatus());
    }


    private void init() {
        onDuty = (Button) findViewById(R.id.btnOnDuty);
        offDuty = (Button) findViewById(R.id.btnOffDuty);
        driving = (Button) findViewById(R.id.btnDriving);
        sleeper = (Button) findViewById(R.id.btnSleep);
        locationFetch = (Button) findViewById(R.id.btnLocation);

        submit = (Button) findViewById(R.id.btnSubmit);
        cancel = (Button) findViewById(R.id.btnCancel);

        driverLocation = (EditText) findViewById(R.id.txtLocation);
        driverComment = (EditText) findViewById(R.id.txtComment);

    }

    private void resetButtons()
    {
        onDuty.setBackground(getResources().getDrawable(R.drawable.button));
        offDuty.setBackground(getResources().getDrawable(R.drawable.button));
        driving.setBackground(getResources().getDrawable(R.drawable.button));
        sleeper.setBackground(getResources().getDrawable(R.drawable.button));
    }

    @Override
    public void onClick(View v) {
        this.UIUpdateContext = this;
        switch (v.getId()) {
            case R.id.btnDriving:
                selectedStatus = STATUS_DRIVING;
                resetButtons();
                driving.setBackgroundColor(Color.BLUE);
                break;
            case R.id.btnOffDuty:
                selectedStatus = STATUS_OFF_DUTY;
                resetButtons();
                offDuty.setBackgroundColor(Color.BLUE);
                break;
            case R.id.btnOnDuty:
                selectedStatus = STATUS_ON_DUTY;
                resetButtons();
                onDuty.setBackgroundColor(Color.BLUE);
                break;
            case R.id.btnSleep:
                selectedStatus = STATUS_SLEEP;
                resetButtons();
                sleeper.setBackgroundColor(Color.BLUE);
                break;
            case R.id.btnLocation:
                fetchGPSLocation();
                break;
            case R.id.btnCancel:
                cancelForm();
                break;
            case R.id.btnSubmit:
                submitForm();
                break;
        }
    }



    private void submitForm() {
        int deviceId = MyApp.dataProvider.selectedDevice.getId();
        if(actions.updateDriverStatus(deviceId, selectedStatus, driverComment.getText().toString()) != null)
        {
            Alerts.statusUpdatedSuccess();
        }
        else
        {
            Alerts.statusUpdatedFailed();
        }
    }

    private void cancelForm() {
        this.finish();
    }


}
