package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fPass extends AppCompatActivity {
    public EditText edtOPass,edtNPass,edtCoPass;
    public Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fpass);

        edtCoPass = findViewById(R.id.edtCoPass);
        edtNPass = findViewById(R.id.edtNPass);
        edtOPass = findViewById(R.id.edtOPass);
        btnSave = findViewById(R.id.btnSave);
        SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
        String opass = preferences.getString("pass","");

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(edtOPass.getText().toString().isEmpty()||edtCoPass.getText().toString().isEmpty()
                        ||edtNPass.getText().toString().isEmpty()){
                    Toast.makeText(getApplicationContext(), "Hãy nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    if(edtOPass.getText().toString().equals(opass)){
                        if (edtCoPass.getText().toString().equals(edtNPass.getText().toString())){
                            SharedPreferences.Editor editor = preferences.edit();
                            editor.putString("pass", edtNPass.getText().toString());
                            editor.commit();
                            Toast.makeText(getApplicationContext(), "Đổi mật khẩu thành công", Toast.LENGTH_SHORT).show();

                        }
                        else{
                            Toast.makeText(getApplicationContext(), "Mật khẩu xác nhận không trùng", Toast.LENGTH_SHORT).show();
                        }
                    }else
                        Toast.makeText(getApplicationContext(), "Sai mật khẩu", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}