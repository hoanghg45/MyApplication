package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    public TextView txtName,txtMail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtName = findViewById(R.id.txtName);
        txtMail = findViewById(R.id.txtMail);

        Intent intent = getIntent();
        Bundle bundle =intent.getExtras();
        String name = bundle.getString("hotengui","");
        String mail = bundle.getString("mailgui","");
        txtName.setText("Họ tên:"+name);
        txtMail.setText("Mail:"+mail);

    }
}