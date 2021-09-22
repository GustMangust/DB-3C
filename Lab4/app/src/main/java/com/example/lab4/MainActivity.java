package com.example.lab4;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
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
import java.nio.file.Files;
import java.nio.file.Paths;

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
        readTxtFile(f);
        try{
            fw = new FileWriter(f,true);
            bw = new BufferedWriter(fw);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void click(View view){
        try{
            FileWriter writer = new FileWriter(f, true);
            writer.append(editText1.getText().toString()+";"+editText2.getText().toString()+";"+"\n");
            writer.flush();
            writer.close();
            readTxtFile(f);
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    public void readTxtFile(File fileName) {
        try{
            FileReader inputFile = new FileReader(fileName);
            BufferedReader bufferReader = new BufferedReader(inputFile);
            String line = "", allLines = "";
            while ((line = bufferReader.readLine()) != null)   {
                allLines += line + "\n";
            }
            textView.setText(allLines);
            bufferReader.close();
        }catch(Exception e){
            System.out.println("Error while reading file line by line:" + e.getMessage());
        }

    }


}