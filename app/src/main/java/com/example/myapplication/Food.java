package com.example.myapplication;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class Food extends AppCompatActivity {
    public Button btnFood,btnDrink,btnExit;
    public TextView txtResult;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_food);

        btnFood = findViewById(R.id.btnFood);
        btnDrink = findViewById(R.id.btnDrink);
        btnExit = findViewById(R.id.btnExit);
        txtResult = findViewById(R.id.txtResult);

        btnFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Food.this,Food2.class);
                startActivityForResult(intent,1);
            }
        });
        btnDrink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Food.this,Food3.class);
                startActivityForResult(intent,1);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), Food.class);
                startActivity(intent);

                // Tao su kien ket thuc app
                Intent startMain = new Intent(Intent.ACTION_MAIN);
                startMain.addCategory(Intent.CATEGORY_HOME);
                startActivity(startMain);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==1&& resultCode==2){
            String rs = data.getStringExtra("food");
            txtResult.setText(txtResult.getText().toString()+" "+rs);
        }
        if(requestCode==1&& resultCode==3){
            String rs = data.getStringExtra("drink");
            txtResult.setText(txtResult.getText().toString()+" "+rs);
        }
    }

}