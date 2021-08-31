package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class fTc extends AppCompatActivity {
    public Button btnCall,btnWeb,btnCal,btnNote,btnInfo;
    public TextView txtWel;

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu1,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){
            case R.id.mnInf:

                Button btnSave,btnCancel;
                EditText edtOPass,edtNPass,edtCoPass;
                AlertDialog.Builder builder = new AlertDialog.Builder(fTc.this);
                LayoutInflater inflater = fTc.this.getLayoutInflater();
                View dialogView = inflater.inflate(R.layout.activity_dl_pass,null);
                builder.setView(dialogView);
                builder.setTitle("Đổi mật khẩu");
                AlertDialog b = builder.create();

                btnSave = dialogView.findViewById(R.id.btnSave);
                btnCancel = dialogView.findViewById(R.id.btnCancel);
                edtOPass = dialogView.findViewById(R.id.edtOPass);
                edtNPass = dialogView.findViewById(R.id.edtNPass);
                edtCoPass = dialogView.findViewById(R.id.edtCoPass);
                SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);
                String opass = preferences.getString("pass","");
                b.show();
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
                btnCancel.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                    b.cancel();
                    }
                });


                break;
            case R.id.mnExit:
                AlertDialog.Builder bu = new AlertDialog.Builder(fTc.this);
                bu.setTitle("Thông báo");
                bu.setMessage("Bạn có muốn thoát chương trình?");
                bu.setPositiveButton("Coá", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
                bu.setNegativeButton("Khum", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog al = bu.create();
                al.show();
                break;

            default:break;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ftc);

        btnCall = findViewById(R.id.btnCall);
        btnCal = findViewById(R.id.btnCal);
        btnNote = findViewById(R.id.btnNote);
        btnInfo = findViewById(R.id.btnInfo);
        btnWeb = findViewById(R.id.btnWeb);
        txtWel = findViewById(R.id.txtWel);
        SharedPreferences preferences = getSharedPreferences("data",MODE_PRIVATE);

        txtWel.setText("Xin chào, "+preferences.getString("fullname",""));


        btnCall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse("tel:1900561252"));
                startActivity(intent);
            }
        });
        btnWeb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("http://google.com/"));
                startActivity(intent);
            }
        });
        btnNote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(fTc.this, fNote.class));
            }
        });
        btnCal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(fTc.this,fCal.class));

            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String [] items = {"Đổi thông tin","Đổi mật khẩu"};
                AlertDialog.Builder builder = new AlertDialog.Builder(fTc.this);

                builder.setItems(items, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(i ==0){
                            startActivity(new Intent(fTc.this,fInfo.class));
                        }
                        else
                            startActivity(new Intent(fTc.this,fPass.class));

                    }
                });
                builder.show();
            }
        });

    }
}