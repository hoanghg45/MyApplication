package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class fNote extends AppCompatActivity {
    public Button btnSave;
    public EditText edtNote;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fnote);

        btnSave = findViewById(R.id.btnSave);
        edtNote = findViewById(R.id.edtNote);
        readCache();
        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                btnSave.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if(!edtNote.getText().toString().isEmpty()) {
                            createCache(edtNote.getText().toString());
                            Toast.makeText(getApplicationContext(), "Lưu note thành công", Toast.LENGTH_SHORT).show();
                        }else
                            Toast.makeText(getApplicationContext(), "Vui lòng nhập nội dung note", Toast.LENGTH_SHORT).show();
                    }
                });
            }
        });


    }
    private void createCache(String content){
        try {
            File patchCacheDir = getCacheDir();
            String nameCache = "myCache.cache";
            File file = new File(patchCacheDir,nameCache);
            file.createNewFile();
            FileOutputStream outputStream = new FileOutputStream(file.getAbsolutePath());
            outputStream.write(content.getBytes());
            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    private void readCache(){
        try {
            File patchCacheDir = getCacheDir();
            String nameCache = "myCache.cache";
            File file = new File(patchCacheDir,nameCache);
            Scanner scanner = new Scanner(file);
            String data ="";
            while (scanner.hasNext()){
                data += scanner.nextLine() +"\n";

            }
            edtNote.setText(data);
            scanner.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}