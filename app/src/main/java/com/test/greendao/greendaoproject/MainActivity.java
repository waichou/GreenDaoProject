package com.test.greendao.greendaoproject;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        System.out.println("这个是源文件");
 
        System.out.println("这个是网上download下来的！");

    }
}
