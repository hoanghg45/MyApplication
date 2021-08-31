package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Food2 extends AppCompatActivity {
    public Button btnBm,btnCl,btnMq,btnPho,btnHt,btnBb;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food2);
        btnBb = findViewById(R.id.btnBb);
        btnHt = findViewById(R.id.btnHt);
        btnPho = findViewById(R.id.btnPho);
        btnMq = findViewById(R.id.btnBm);
        btnCl = findViewById(R.id.btnCl);
        btnBm = findViewById(R.id.btnBm);

        btnBb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("food",btnBb.getText().toString());
                setResult(2,intent);
                finish();
            }
        });
        btnHt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("food",btnHt.getText().toString());
                setResult(2,intent);
                finish();
            }
        }); btnPho.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("food",btnPho.getText().toString());
                setResult(2,intent);
                finish();
            }
        }); btnMq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("food",btnMq.getText().toString());
                setResult(2,intent);
                finish();
            }
        }); btnCl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("food",btnCl.getText().toString());
                setResult(2,intent);
                finish();
            }
        }); btnBm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("food",btnBm.getText().toString());
                setResult(2,intent);
                finish();
            }
        });

    }
}