package com.example.lab3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.Console;
import java.io.File;

public class MainActivity extends AppCompatActivity {
    Button button;
    Button button2;
    Button button3;
    Button button4;
    Button button5;
    Button button6;
    TextView textView;
    TextView textView2;
    TextView textView3;
    TextView textView4;
    TextView textView5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.button);
        button2 = (Button) findViewById(R.id.button2);
        button3 = (Button) findViewById(R.id.button3);
        button4 = (Button) findViewById(R.id.button4);
        button5 = (Button) findViewById(R.id.button5);
        button6 = (Button) findViewById(R.id.button6);
        textView = (TextView) findViewById(R.id.textView);
        textView2 = (TextView) findViewById(R.id.textView2);
        textView3 = (TextView) findViewById(R.id.textView3);
        textView4 = (TextView) findViewById(R.id.textView4);
        textView5 = (TextView) findViewById(R.id.textView5);

        View.OnClickListener oclbutton = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method(getFilesDir());

            }
        };
        button.setOnClickListener(oclbutton);
        View.OnClickListener oclbutton2 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                method(getCacheDir());

            }
        };
        button2.setOnClickListener(oclbutton2);
        View.OnClickListener oclbutton3 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
                method(file);

            }
        };
        button3.setOnClickListener(oclbutton3);
        View.OnClickListener oclbutton4 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //File file = getExternalCacheDir();
                //Log.d("dd",file.toString());
                //method(file);

            }
        };
        button4.setOnClickListener(oclbutton4);
        View.OnClickListener oclbutton5 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = Environment.getExternalStorageDirectory();
                method(file);

            }
        };
        button5.setOnClickListener(oclbutton5);
        View.OnClickListener oclbutton6 = new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
                method(file);

            }
        };
        button6.setOnClickListener(oclbutton6);
    }
    private void method(File file){
        textView.setText("Absolute: " + file.getAbsolutePath());
        textView2.setText("Name: " + file.getName());
        textView3.setText("Path: " + file.getPath());
        String read;
        String write;
        if(file.canRead()){
            read = "Yes";
        } else{
            read = "No";
        }
        if(file.canWrite()){
            write = "Yes";
        }else{
            write = "No";
        }
        textView4.setText("Read/Write: " + read+"/"+write);
        textView5.setText("External: " + Environment.getExternalStorageState());
    }
}