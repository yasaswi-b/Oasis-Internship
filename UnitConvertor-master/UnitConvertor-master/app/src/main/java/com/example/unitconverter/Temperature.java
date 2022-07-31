package com.example.unitconverter;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Temperature extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText input;
    TextView result;
    Button convert;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temperature);

        sp1 = findViewById(R.id.from_temperature);
        sp2 = findViewById(R.id.to_temperature);
        input = findViewById(R.id.input);
        result = findViewById(R.id.result);


        String[] from = {"Celsius(C)", "Fahrenheit(F)","Kelvin(K)"};
        ArrayAdapter arr1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(arr1);


        String[] to = {"Celsius(C)", "Fahrenheit(F)","Kelvin(K)"};
        ArrayAdapter arr2 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(arr2);


        convert = findViewById(R.id.convert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double ans = null;

                Double in = Double.parseDouble(input.getText().toString());

                if(sp1.getSelectedItem().toString() == "Celsius(C)" && sp2.getSelectedItem().toString() == "Fahrenheit(F)")
                {
                    ans = (in * 9)/5 + 32;
                }
                else if(sp1.getSelectedItem().toString() == "Celsius(C)" && sp2.getSelectedItem().toString() == "Kelvin(K)")
                {
                    ans = in + 273.15;
                }
                else if(sp1.getSelectedItem().toString() == "Fahrenheit(F)" && sp2.getSelectedItem().toString() == "Celsius(C)")
                {
                    ans = ((in - 32) * 5)/9 ;
                }
                else if(sp1.getSelectedItem().toString() == "Fahrenheit(F)" && sp2.getSelectedItem().toString() == "Kelvin(K)")
                {
                    ans = ((in - 32) * 5)/9 + 273.15;
                }
                else if(sp1.getSelectedItem().toString() == "Kelvin(K)" && sp2.getSelectedItem().toString() == "Celsius(C)")
                {
                    ans = in - 273.15;
                }
                else if(sp1.getSelectedItem().toString() == "Kelvin(K)" && sp2.getSelectedItem().toString() == "Fahrenheit(F)")
                {
                    ans = ((in - 273.15)*9)/5 + 32;
                }
                else{
                    ans = in;
                }
                result.setText(ans.toString());
            }
        });
    }
}
