package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Food3 extends AppCompatActivity {
    public EditText edtDrink;
    public Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food3);

        btnSave= findViewById(R.id.btnSave);
        edtDrink= findViewById(R.id.edtDrink);

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("drink",edtDrink.getText().toString());
                setResult(3,intent);
                finish();
            }
        });

    }
}