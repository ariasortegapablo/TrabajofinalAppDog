package arias.pablo.empezando.lay;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.Spinner;

public class lostActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lost);


        //Spinner
        Spinner spinner = (Spinner) findViewById(R.id.spinnerUbication);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.ubication_array, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);


        //dayPicker

        DatePicker simpleDatePicker = (DatePicker)findViewById(R.id.datePickerPerdido); // initiate a date picker

        simpleDatePicker.setSpinnersShown(false); // set false value for the spinner shown function
    }
}
