package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fDk1 extends AppCompatActivity {
    public EditText edtName,edtPass,edtCoPass;
    public Button btnNext,btnDn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdk1);

        edtPass = findViewById(R.id.edtPass);
        edtName = findViewById(R.id.edtName);
        edtCoPass = findViewById(R.id.edtCoPass);
        btnNext = findViewById(R.id.btnNext);
        btnDn = findViewById(R.id.btnDn);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtPass.getText().toString().isEmpty() ||edtCoPass.getText().toString().isEmpty()
                        ||edtName.getText().toString().isEmpty()||!edtPass.getText().toString().equals(edtCoPass.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();

                }
                else{
                    Intent intent = new Intent(fDk1.this,fDk2.class);
                    intent.putExtra("name", edtName.getText().toString());
                    intent.putExtra("pass",edtPass.getText().toString());

                    startActivity(intent);

                }
            }
        });
        btnDn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(fDk1.this,fDn.class));
            }
        });
    }
}