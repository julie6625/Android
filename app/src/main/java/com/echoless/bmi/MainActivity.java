package com.echoless.bmi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void bmi(View view){
        Log.d( "MainActivity" , "bmi" );    //撰寫log
        EditText edweight = findViewById(R.id.Ed_weight);   //定位ed_weight
        EditText edheight = findViewById(R.id.Ed_height);
        String w = edweight.getText().toString();   //取得weight資料
        String h = edheight.getText().toString();
        Log.d("MainActivity" , w+"/ ("+h+"*"+h+")");
        float weight = Float.parseFloat(w); //字串轉浮點
        float height = Float.parseFloat(h);
        float bmi = weight / (height*height);
        Log.d("MainActivity" , bmi+"");     // msg必要加一個字串 " "

        }
}
