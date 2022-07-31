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


public class Speed extends AppCompatActivity {

    Spinner sp1,sp2;
    EditText input;
    TextView result;
    Button convert;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_speed);

        sp1 = findViewById(R.id.from_speed);
        sp2 = findViewById(R.id.to_speed);
        input = findViewById(R.id.input);
        result = findViewById(R.id.result);


        String[] from = {"Meter/second(m/s)","Kilometer/hour(km/h)"};
        ArrayAdapter ad = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,from);
        sp1.setAdapter(ad);


        String[] to = {"Meter/second(m/s)","Kilometer/hour(km/h)"};
        ArrayAdapter ad1 = new ArrayAdapter<String>(this, androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,to);
        sp2.setAdapter(ad1);


        convert = findViewById(R.id.convert);

        convert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Double ans = null;

                Double in = Double.parseDouble(input.getText().toString());

                if(sp1.getSelectedItem().toString() == "Meter/second(m/s)" && sp2.getSelectedItem().toString() == "Kilometer/hour(km/h)")
                {
                    ans = in * 3.6;
                }
                else if(sp1.getSelectedItem().toString() == "Kilometer/hour(km/h)" && sp2.getSelectedItem().toString() == "Meter/second(m/s)")
                {
                    ans = (in * 10)/36;
                }
                else{
                    ans = in;
                }
                result.setText(ans.toString());
            }
        });
    }
}
