package com.example.lab4;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    private boolean exists;
    private EditText editText1;
    private EditText editText2;
    private Button button;
    private TextView textView;
    private FileWriter fw;
    private BufferedWriter bw;
    private FileReader fr;
    private BufferedReader br;
    private File f;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText1 = findViewById(R.id.editTextTextPersonName2);
        editText2 = findViewById(R.id.editTextTextPersonName);
        button = findViewById(R.id.button);
        textView = findViewById(R.id.textView3);
        f = new File(super.getFilesDir(), "Base_Lab.txt");
        exists = f.exists();
        Log.d("MainActivity", exists + "");
        if(!exists){
            AlertDialog.Builder b = new AlertDialog.Builder(this);
            b.setTitle("Создаётся файл");
            AlertDialog ad = b.create();
            ad.show();
            try {
                f.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        output(f);

        try{
            fw = new FileWriter(f,true);
            bw = new BufferedWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void click(View view){
        try{
            Log.d("LOG",editText1.getText().toString());
            bw.append(editText1.getText().toString()+";"+editText2.getText().toString()+";"+"\r\n");
            Log.d("LOG","Данные записаны");
            output(f);
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    private void output(File f){
        try {
            fr = new FileReader(f);
            br = new BufferedReader(fr);
            String allLines = "";
            String line = null;
            while ((line=br.readLine())!=null){
                allLines+=line;
            }
            Log.d("LOG11",allLines);
            textView.setText(allLines);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}