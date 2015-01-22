package edu.hawaii.android.samplehourminutepickerapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.Calendar;

import edu.hawaii.android.hourminutepicker.date.DatePickerDialog;
import edu.hawaii.android.hourminutepicker.time.RadialPickerLayout;
import edu.hawaii.android.hourminutepicker.time.TimePickerDialog;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends android.app.Fragment implements DatePickerDialog.OnDateSetListener, TimePickerDialog.OnTimeSetListener {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            View datePickerBtn = rootView.findViewById(R.id.showDatePicker);
            datePickerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final Calendar c = Calendar.getInstance();
                    int year = c.get(Calendar.YEAR);
                    int month = c.get(Calendar.MONTH);
                    int day = c.get(Calendar.DAY_OF_MONTH);

                    DatePickerDialog dialog = DatePickerDialog.newInstance(PlaceholderFragment.this, year, month, day);
                    dialog.show(getFragmentManager(), "datePicker");
                }
            });

            View timePickerBtn = rootView.findViewById(R.id.showTimePicker);
            timePickerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    final Calendar c = Calendar.getInstance();
                    int hourOfDay = c.get(Calendar.HOUR_OF_DAY);
                    int minute = c.get(Calendar.MINUTE);

                    TimePickerDialog dialog = TimePickerDialog.newInstance(PlaceholderFragment.this, hourOfDay, minute, false);
                    dialog.show(getFragmentManager(), "timePicker");
                }
            });


            return rootView;
        }

        @Override
        public void onDateSet(DatePickerDialog dialog, int year, int monthOfYear, int dayOfMonth) {
            CharSequence text = "Date!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this.getActivity(), text, duration);
            toast.show();
        }

        @Override
        public void onTimeSet(RadialPickerLayout view, int hourOfDay, int minute) {
            CharSequence text = "Time!";
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(this.getActivity(), text, duration);
            toast.show();
        }
    }
}
