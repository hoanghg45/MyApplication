package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    public EditText edtName,edtMail,edtPass,edtPass1;
    public Button btnDk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtName = findViewById(R.id.edtName);
        edtMail = findViewById(R.id.edtMail);
        edtPass = findViewById(R.id.edtPass);
        edtPass1 = findViewById(R.id.edtPass1);
        btnDk = findViewById(R.id.btnDk);

        btnDk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtName.getText().toString().isEmpty()||edtPass1.getText().toString().isEmpty()
                        ||edtMail.getText().toString().isEmpty()||edtPass.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else if(!edtPass.getText().toString().equals(edtPass1.getText().toString())){
                    Toast.makeText(getApplicationContext(), "Mật khẩu không khớp", Toast.LENGTH_SHORT).show();
                }else{
                    Intent intent = new Intent(MainActivity.this,MainActivity2.class);
                    Bundle bundle = new Bundle();
                    bundle.putString("hotengui",edtName.getText().toString());
                    bundle.putString("mailgui",edtMail.getText().toString());
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            }
        });

    }
}