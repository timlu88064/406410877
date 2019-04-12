package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.cat);
    }
    int size = 15;
    public void response(View v){

        e1 = findViewById(R.id.editText);
        e2 = findViewById(R.id.editText2);
        e3 = findViewById(R.id.editText3);
        txv = findViewById(R.id.textView);

        float height = Float.parseFloat(e2.getText().toString());
        float weight = Float.parseFloat(e3.getText().toString());
        float BMI = cBMI(height,weight);
        String BMI0 = String.valueOf(BMI);

        //txv.setTextSize(size);
        txv.setText(e1.getText().toString() + getResources().getString(R.string.Hello) + getResources().getString(R.string.your) + BMI0);
        Toast.makeText(this,standarBMI(BMI), Toast.LENGTH_SHORT).show();
    }

    private float cBMI(float h , float w){
        float BMI = (float) (w / Math.pow((h/100),2));
        return BMI;
    }

    private String standarBMI(double st){
        String alert = "";

        if(st > 25){
            alert = String.valueOf(getResources().getString(R.string.t_fat));
            getWindow().setBackgroundDrawableResource(R.drawable.fat);
        }
        else if(st < 18.5){
            alert = String.valueOf(getResources().getString(R.string.t_slim));
            getWindow().setBackgroundDrawableResource(R.drawable.s);
        }
        else{
            alert = String.valueOf(getResources().getString(R.string.good));
            getWindow().setBackgroundDrawableResource(R.drawable.cat);
        }

        return alert;
    }
}

