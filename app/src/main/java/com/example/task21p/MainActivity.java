package com.example.task21p;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private static final String PREF_SELECTED_ITEM = "selected_item";
    private SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getPreferences(MODE_PRIVATE);

        Spinner spinners_type =findViewById(R.id.spinner_type);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.conversion_type,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinners_type.setAdapter(adapter);
        spinners_type.setOnItemSelectedListener(this);

        Button Convert = findViewById(R.id.button);
        Convert.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                calculateResult();
            }
        });
    }

    public void calculateResult(){
        EditText input_text = findViewById(R.id.input);
        double value_input = Double.valueOf(input_text.getText().toString());

        Spinner spinners_source = findViewById(R.id.spinner_source);
        String selectedSource = (String) spinners_source.getSelectedItem();

        Spinner spinners_target = findViewById(R.id.spinner_target);
        String selectedTarget = (String) spinners_target.getSelectedItem();

        double converted_value = 0.0;

        if (selectedSource.equals("Inch") && selectedTarget.equals("Centimeters")) {
            converted_value = value_input * 2.54;
        }
        else if (selectedSource.equals("Foot") && selectedTarget.equals("Centimeters")) {
            converted_value = value_input * 30.48;
        }
        else if (selectedSource.equals("Yard") && selectedTarget.equals("Centimeters")) {
            converted_value = value_input * 91.44;
        }
        else if (selectedSource.equals("Mile") && selectedTarget.equals("Kilometers")) {
            converted_value = value_input * 1.60934;
        }
        else if (selectedSource.equals("Pound") && selectedTarget.equals("Kilograms")) {
            converted_value = value_input * 0.453592;
        }
        else if (selectedSource.equals("Ounce") && selectedTarget.equals("Grams")) {
            converted_value = value_input * 28.3495;
        }
        else if (selectedSource.equals("Ton") && selectedTarget.equals("Kilograms")) {
            converted_value = value_input * 907.185;
        }
        else if (selectedSource.equals("Celsius") && selectedTarget.equals("Fahrenheit")) {
            converted_value = (value_input * 1.8) + 32;
        }
        else if (selectedSource.equals("Fahrenheit") && selectedTarget.equals("Celsius")) {
            converted_value = (value_input - 32) / 1.8;
        }
        else if (selectedSource.equals("Celsius") && selectedTarget.equals("Kelvin")) {
            converted_value = value_input + 273.15;
        }
        else if (selectedSource.equals("Kelvin") && selectedTarget.equals("Celsius")) {
            converted_value = value_input - 273.15;
        }
        else if (selectedSource.equals("Fahrenheit") && selectedTarget.equals("Kelvin")) {
            converted_value = ((value_input - 32) / 1.8) + 273.15;
        }
        else if (selectedSource.equals("Kelvin") && selectedTarget.equals("Fahrenheit")) {
            converted_value = ((value_input - 273.15) * 1.8 + 32);
        }

        final TextView result = findViewById(R.id.target_value);
        result.setText(String.valueOf(converted_value + " " + selectedTarget));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinners_source = findViewById(R.id.spinner_source);
        Spinner spinners_target = findViewById(R.id.spinner_target);
        switch(position){
            case 0:
                ArrayAdapter<CharSequence> adapter1 = ArrayAdapter.createFromResource(this, R.array.length_source,
                        android.R.layout.simple_spinner_item);
                adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinners_source.setAdapter(adapter1);

                ArrayAdapter<CharSequence> adapter2 = ArrayAdapter.createFromResource(this, R.array.length_target,
                        android.R.layout.simple_spinner_item);
                adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinners_target.setAdapter(adapter2);
                break;
            case 1:
                ArrayAdapter<CharSequence> adapter3 = ArrayAdapter.createFromResource(this, R.array.weight_source,
                        android.R.layout.simple_spinner_item);
                adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinners_source.setAdapter(adapter3);

                ArrayAdapter<CharSequence> adapter4 = ArrayAdapter.createFromResource(this, R.array.weight_target,
                        android.R.layout.simple_spinner_item);
                adapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinners_target.setAdapter(adapter4);
                break;
            case 2:
                ArrayAdapter<CharSequence> adapter5 = ArrayAdapter.createFromResource(this, R.array.temperature_types,
                        android.R.layout.simple_spinner_item);
                adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinners_source.setAdapter(adapter5);

                ArrayAdapter<CharSequence> adapter6 = ArrayAdapter.createFromResource(this, R.array.temperature_types,
                        android.R.layout.simple_spinner_item);
                adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                spinners_target.setAdapter(adapter6);
                break;
        }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}


