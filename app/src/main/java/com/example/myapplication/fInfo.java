package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class fInfo extends AppCompatActivity {
    public EditText edtFn,edtMail,edtPhone,edtAdd;
    public Button btnSave;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finfo);

        edtFn = findViewById(R.id.edtFn);
        edtMail = findViewById(R.id.edtMail);
        edtPhone = findViewById(R.id.edtPhone);
        edtAdd = findViewById(R.id.edtAdd);
        btnSave = findViewById(R.id.btnSave);
        SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
        edtFn.setText(preferences.getString("fullname",""));
        edtMail.setText(preferences.getString("mail",""));
        edtPhone.setText(preferences.getString("phone",""));
        edtAdd.setText(preferences.getString("address",""));
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(edtAdd.getText().toString().isEmpty()||edtFn.getText().toString().isEmpty()||
                        edtPhone.getText().toString().isEmpty()||edtMail.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "Vui lòng nhập đầy đủ thông tin", Toast.LENGTH_SHORT).show();
                }else{
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("address", edtAdd.getText().toString());
                    editor.putString("fullname", edtFn.getText().toString());
                    editor.putString("phone", edtPhone.getText().toString());
                    editor.putString("mail", edtMail.getText().toString());
                    editor.commit();
                    Toast.makeText(getApplicationContext(), "Lưu thành công", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}