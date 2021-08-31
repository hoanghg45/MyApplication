package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Healthy extends AppCompatActivity {
    public EditText edtHei,edtWei;
    public TextView txtResult;
    public Button btnCheck;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_healthy);

        edtHei = findViewById(R.id.edtHei);
        edtWei = findViewById(R.id.edtWei);
        txtResult = findViewById(R.id.txtResult);
        btnCheck = findViewById(R.id.btnCheck);


        btnCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double hei = Double.parseDouble(edtHei.getText().toString());
                double wei = Double.parseDouble(edtWei.getText().toString());
                double BMI = wei/((hei/100)*(hei/100));
                double wei1 = (hei%100)*0.9;
                double a = Math.round(BMI*100.0)/100.0;
                String rs = checkBMI(BMI);
                if(wei == wei1){
                    txtResult.setText("Chỉ số BMI của bạn là:"+a+"\n"+rs+"\n Cân nặng của bạn đang lý tưỏng, cố gắng duy trì nhé");
                }else if(wei > wei1){
                    txtResult.setText("Chỉ số BMI của bạn là:"+a+"\n"+rs+"\n Cân nặng của bạn đang nhiều hơn "+Math.round((wei-wei1)*100.0)/100.0+"kg so với cân nặng lý tưởng, hãy cố tập thể dục nhé");
                }else if(wei < wei1) {
                    txtResult.setText("Chỉ số BMI của bạn là:"+a+"\n"+rs+"\n Cân nặng của bạn đang ít hơn " + Math.round((wei1-wei)*100.0)/100.0 + "kg so với cân nặng lý tưởng, hãy cố ăn uống đầy đủ nhé");
                }
            }
            public String checkBMI(double BMI){
                String rs ="";
                if(BMI <18.5 ){
                    return rs ="Bạn đang gầy";
                }else if(BMI<25){
                    return rs ="Bạn đang bình thường";
                }else if(BMI<30) {
                    return rs = "Bạn đang tăng cân";
                }else if(BMI<35) {
                    return rs = "Bạn đang bị béo phì độ 1";
                }else if(BMI<40) {
                    return rs = "Bạn đang bị béo phì độ 2";
                }else {
                    return rs = "Bạn đang bị béo phì độ 3";
                }
            }
        });


    }
}