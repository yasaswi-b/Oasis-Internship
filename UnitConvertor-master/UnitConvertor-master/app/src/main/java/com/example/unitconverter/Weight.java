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

public class Weight extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText input;
    TextView result;
    Button convert;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weight);

        sp1 = findViewById(R.id.from_weight);
        sp2 = findViewById(R.id.to_weight);
        input = findViewById(R.id.input);
        result = findViewById(R.id.result);


        String[] from = {"Milligram(mg)","Gram(g)","Kilogram(kg)"};
        ArrayAdapter arr1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(arr1);


        String[] to = {"Milligram(mg)","Gram(g)","Kilogram(kg)"};
        ArrayAdapter arr2 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(arr2);


        convert = findViewById(R.id.convert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double ans = null;

                Double in = Double.parseDouble(input.getText().toString());

                if(sp1.getSelectedItem().toString() == "Milligram(mg)" && sp2.getSelectedItem().toString() == "Gram(g)")
                {
                    ans = in * (0.001);
                }
                else if(sp1.getSelectedItem().toString() == "Milligram(mg)" && sp2.getSelectedItem().toString() == "Kilogram(kg)")
                {
                    ans = in * (0.000001);
                }
                else if(sp1.getSelectedItem().toString() == "Gram(g)" && sp2.getSelectedItem().toString() == "Milligram(mg)")
                {
                    ans = in * (1000);
                }
                else if(sp1.getSelectedItem().toString() == "Gram(g)" && sp2.getSelectedItem().toString() == "Kilogram(kg)")
                {
                    ans = in * (0.001);
                }
                else if(sp1.getSelectedItem().toString() == "Kilogram(kg)" && sp2.getSelectedItem().toString() == "Milligram(mg)")
                {
                    ans = in * (1000000);
                }
                else if(sp1.getSelectedItem().toString() == "Kilogram(kg)" && sp2.getSelectedItem().toString() == "Gram(g)")
                {
                    ans = in * (1000);
                }
                else{
                    ans = in;
                }
                result.setText(ans.toString());
            }
        });
    }
}
