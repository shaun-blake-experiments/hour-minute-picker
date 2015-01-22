package edu.hawaii.android.samplehourminutepickerapp;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            View datePickerBtn = rootView.findViewById(R.id.showHourMinutePicker);
            datePickerBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    CharSequence text = "This is where I would use the time measure picker...";
                    int duration = Toast.LENGTH_SHORT;

                    Toast toast = Toast.makeText(PlaceholderFragment.this.getActivity(), text, duration);
                    toast.show();
                }
            });

            return rootView;
        }
    }
}
