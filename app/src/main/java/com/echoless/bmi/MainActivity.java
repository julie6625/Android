package com.echoless.bmi;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;

public class

MainActivity extends AppCompatActivity {

    private EditText edweight;
    private EditText edheight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edweight = findViewById(R.id.Ed_weight);//定位ed_weight
        edheight = findViewById(R.id.Ed_height);
        //alt+shift+上下移動選取行
        //ctrl+alt+f 直接宣告field

        findView(); //ctrl+alt+m Extract method 直接選取新增方法
    }

    private void findView() {
        Button help = findViewById(R.id.help); //為help按鈕新增功能
        help.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("MainActivity", "onClick: help ");
                new  AlertDialog.Builder(MainActivity.this)
                        .setTitle(R.string.bmi_title)
                        .setMessage(R.string.bmi_info)
                        .setNegativeButton(R.string.ok,null).show();


            }
        });//匿名類別 在此寫完Onclick方法
    }

    public void bmi(View view){
        Log.d( "MainActivity" , "bmi" );    //撰寫log
        String w = edweight.getText().toString();   //取得weight資料
        String h = edheight.getText().toString();
        Log.d("MainActivity" , w+"/ ("+h+"*"+h+")");
        float weight = Float.parseFloat(w); //字串轉浮點
        float height = Float.parseFloat(h);
        float bmi = weight / (height*height);
        Log.d("MainActivity" , bmi+"");     // msg必要加一個字串 " "
/*        Toast.makeText(this, getString(R.string.your_bmi)+ bmi,
                Toast.LENGTH_LONG).show(); // 顯示給使用者觀看bmi結果(氣球提示)
        new AlertDialog.Builder(this)
                .setMessage(getString(R.string.your_bmi) + bmi)
                .setTitle(R.string.bmi)
                .setNegativeButton(R.string.ok, null) //negative為左下按鈕positive為右下按鈕 此設定按完OK不做任何行為
                .setPositiveButton(R.string.clear, new DialogInterface.OnClickListener() {        //設定跳出對話框的右下按鈕 顯示clear 並 設定一個onclick的機制 使使用者按下clear之後消除身高體重數值
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        edheight.setText("");
                        edweight.setText("");
                    }
                })
                .show();
*/
        Intent intent = new Intent(this,ResultActivity.class);
        intent.putExtra("BMI",bmi);
        startActivity(intent);

        }
}
