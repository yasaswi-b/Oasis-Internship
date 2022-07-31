

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


public class Length extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText input;
    TextView result;
    Button convert;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_length);

        sp1 = findViewById(R.id.from_length);
        sp2 = findViewById(R.id.to_length);
        input = findViewById(R.id.input);
        result = findViewById(R.id.result);


        String[] from = {"Millimeter(mm)","Centimeter(cm)","Meter(m)","Kilometer(km)"};
        ArrayAdapter arr1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(arr1);


        String[] to ={"Millimeter(mm)","Centimeter(cm)","Meter(m)","Kilometer(km)"};
        ArrayAdapter arr2 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(arr2);


        convert = findViewById(R.id.convert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double ans = null;

                Double in = Double.parseDouble(input.getText().toString());

                if(sp1.getSelectedItem().toString() == "Millimeter(mm)" && sp2.getSelectedItem().toString() == "Centimeter(cm)")
                {
                    ans = in * (0.1);
                }
                else if(sp1.getSelectedItem().toString() == "Millimeter(mm)" && sp2.getSelectedItem().toString() == "Meter(m)")
                {
                    ans = in * (0.001);
                }
                else if(sp1.getSelectedItem().toString() == "Millimeter(mm)" && sp2.getSelectedItem().toString() == "Kilometer(km)")
                {
                    ans = in * (0.000001);
                }
                else if(sp1.getSelectedItem().toString() == "Centimeter(cm)" && sp2.getSelectedItem().toString() == "Millimeter(mm)")
                {
                    ans = in * 10;
                }
                else if(sp1.getSelectedItem().toString() == "Centimeter(cm)" && sp2.getSelectedItem().toString() == "Meter(m)")
                {
                    ans = in * (0.01);
                }
                else if(sp1.getSelectedItem().toString() == "Centimeter(cm)" && sp2.getSelectedItem().toString() == "Kilometer(km)")
                {
                    ans = in * (0.00001);
                }
                else if(sp1.getSelectedItem().toString() == "Meter(m)" && sp2.getSelectedItem().toString() == "Millimeter(mm)")
                {
                    ans = in * 1000;
                }
                else if(sp1.getSelectedItem().toString() == "Meter(m)" && sp2.getSelectedItem().toString() == "Centimeter(cm)")
                {
                    ans = in * 100;
                }
                else if(sp1.getSelectedItem().toString() == "Meter(m)" && sp2.getSelectedItem().toString() == "Kilometer(km)")
                {
                    ans = in * (0.001);
                }
                else if(sp1.getSelectedItem().toString() == "Kilometer(km)" && sp2.getSelectedItem().toString() == "Millimeter(mm)")
                {
                    ans = in * 1000000;
                }
                else if(sp1.getSelectedItem().toString() == "Kilometer(km)" && sp2.getSelectedItem().toString() == "Centimeter(cm)")
                {
                    ans = in * 100000;
                }
                else if(sp1.getSelectedItem().toString() == "Kilometer(km)" && sp2.getSelectedItem().toString() == "Meter(m)")
                {
                    ans = in * 1000;
                }
                else{
                    ans = in;
                }

                result.setText(ans.toString());
            }
        });
    }
}
