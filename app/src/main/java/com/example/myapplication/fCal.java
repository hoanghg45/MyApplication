package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class fCal extends AppCompatActivity {
    public EditText edtNum1,edtNum2;
    public Spinner spnMath;
    public Button btnCal;
    public TextView txtResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fcal);
        edtNum1 = findViewById(R.id.edtNum1);
        edtNum2 = findViewById(R.id.edtNum2);
        spnMath = findViewById(R.id.spnMath);
        btnCal = findViewById(R.id.btnCal);
        txtResult = findViewById(R.id.txtResult);


        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double num1 = Double.parseDouble(edtNum1.getText().toString());
                double num2 = Double.parseDouble(edtNum2.getText().toString());
                switch (spnMath.getSelectedItem().toString()){
                    case "Cộng": txtResult.setText("Kết quả là :"+(num1+num2));
                        break;
                    case "Trừ": txtResult.setText("Kết quả là :"+(num1-num2));
                        break;
                    case "Nhân": txtResult.setText("Kết quả là :"+(num1*num2));
                        break;
                    case "Chia": txtResult.setText("Kết quả là :"+(num1/num2));
                        break;
                    default:
                        break;

                }

            }
        });
    }
}