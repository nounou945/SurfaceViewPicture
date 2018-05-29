package com.example.nourhenechettaoui.surfacepicture;

import android.content.ContentValues;
import android.content.Context;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    FrameLayout myFrame;
    CustomSurfaceView mySurface;
//    Button btn_camera = (Button)findViewById(R.id.btn_camera);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myFrame=(FrameLayout)findViewById(R.id.myFrame);
        mySurface=new CustomSurfaceView(this);
        myFrame.addView(mySurface);


    }
    }

