package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class fDk3 extends AppCompatActivity {
    public TextView txtFn, txtAdd, txtPhone, txtMail, txtUser, txtPass;
    public Button btnDk, btnBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fdk3);

        txtAdd = findViewById(R.id.txtAdd);
        txtFn = findViewById(R.id.txtFn);
        txtPhone = findViewById(R.id.txtPhone);
        txtMail = findViewById(R.id.txtMail);
        txtUser = findViewById(R.id.txtUser);
        txtPass = findViewById(R.id.txtPass);
        btnDk = findViewById(R.id.btnDk);
        btnBack = findViewById(R.id.btnBack);

        String fn = getIntent().getStringExtra("fullname");
        String add = getIntent().getStringExtra("add");
        String phone = getIntent().getStringExtra("phone");
        String mail = getIntent().getStringExtra("mail");
        String user = getIntent().getStringExtra("name");
        String pass = getIntent().getStringExtra("pass");

        txtFn.setText(fn);
        txtAdd.setText(add);
        txtPhone.setText(phone);
        txtMail.setText(mail);
        txtUser.setText(user);
        txtPass.setText(pass);



        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(fDk3.this, fDn.class);
                intent.putExtra("name", user);
                intent.putExtra("pass", pass);
                savePrefs(fn, add, phone, mail, user, pass);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Đăng ký thành công", Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void savePrefs(String fn, String add, String phone, String mail, String user, String pass) {
        SharedPreferences preferences = getSharedPreferences("data", MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString("fullname", fn);
        editor.putString("address", add);
        editor.putString("phone", phone);
        editor.putString("mail", mail);
        editor.putString("user", user);
        editor.putString("pass", pass);
        editor.commit();
    }
}