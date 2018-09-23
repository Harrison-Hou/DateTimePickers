package com.mrhou.datetimepickers;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click(View view) {
        DialogFragment dialogFragment;
        switch(view.getId()) {
            case R.id.button_date:
                dialogFragment= new DatePickerFragment();
                dialogFragment.show(getFragmentManager(),getString(R.string.date_picker));
                break;

            case R.id.button_time:
                dialogFragment = new TimePickerFragment();
                dialogFragment.show(getFragmentManager(),getString(R.string.time_picker));

                break;

                default:
                    Log.d(TAG, "Nothing picked");
        }

    }


    public void processDatePickerResult(int year, int month, int day) {

        String month_string = Integer.toString(month);

        String year_string = Integer.toString(year);

        String day_string = Integer.toString(day);

        String dateMessage = (month_string + "/" + day_string + "/" + year_string);

        Toast.makeText(this, "Date:" + dateMessage, Toast.LENGTH_SHORT).show();

    }

    public void processTimePickerResult(int hourofDay, int minute) {
        String hour_string = Integer.toString(hourofDay);
        String minute_string = Integer.toString(minute);

        String timeMessage = (hour_string + ":"+ minute_string);

        Toast.makeText(this,timeMessage,Toast.LENGTH_SHORT).show();
    }
}
