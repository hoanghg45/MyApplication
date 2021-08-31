package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fDn extends AppCompatActivity {
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

        if(getIntent().getStringExtra("name") != null||getIntent().getStringExtra("pass")!= null) {
            edtName.setText(getIntent().getStringExtra("name"));
            edtPass.setText(getIntent().getStringExtra("pass"));

        }




        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(fDn.this,fDk1.class));
            }
        });

        btnDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(checkDn(edtName.getText().toString(),edtPass.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(fDn.this,fTc.class));
               }
                else{
                    Toast.makeText(getApplicationContext(), "Đăng nhập thất bại!", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    public boolean checkDn(String id, String pass){
        SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
        return id.equals(preferences.getString("user", "")) && pass.equals(preferences.getString("pass", ""));
    }
}