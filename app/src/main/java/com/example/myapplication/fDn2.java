package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class fDn2 extends AppCompatActivity {
    public EditText edtName,edtPass;
    public Button btnDn,btnDk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdn);
        edtPass = findViewById(R.id.edtPass);
        edtName = findViewById(R.id.edtName);
        btnDn = findViewById(R.id.btnDn);
        btnDk = findViewById(R.id.btnDk);



        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(fDn2.this,fDk1.class));
            }
        });

        btnDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!edtName.getText().toString().isEmpty() || !edtPass.getText().toString().isEmpty() ){

                }
                else{
                    Toast.makeText(getApplicationContext(), "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}