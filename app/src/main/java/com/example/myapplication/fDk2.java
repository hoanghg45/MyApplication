package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fDk2 extends AppCompatActivity {
    public EditText edtFn,edtAdd,edtPhone,edtMail;
    public Button btnBack,btnNext;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdk2);

        edtFn = findViewById(R.id.edtFn);
        edtAdd = findViewById(R.id.edtAdd);
        edtPhone = findViewById(R.id.edtPhone);
        btnBack = findViewById(R.id.btnBack);
        btnNext = findViewById(R.id.btnNext);
        edtMail = findViewById(R.id.edtMail);

        String name = getIntent().getStringExtra("name");
        String pass = getIntent().getStringExtra("pass");

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                    Intent intent = new Intent(fDk2.this,fDk3.class);
                    if(edtFn.getText().toString().isEmpty() || edtAdd.getText().toString().isEmpty() ||
                            edtPhone.getText().toString().isEmpty() ||edtMail.getText().toString().isEmpty()){

                        Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();

                    }else{
                        intent.putExtra("name",name);
                        intent.putExtra("pass",pass);
                        intent.putExtra("fullname",edtFn.getText().toString());
                        intent.putExtra("phone",edtPhone.getText().toString());
                        intent.putExtra("add",edtAdd.getText().toString());
                        intent.putExtra("mail",edtMail.getText().toString());
                        startActivity(intent);
                    }
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}