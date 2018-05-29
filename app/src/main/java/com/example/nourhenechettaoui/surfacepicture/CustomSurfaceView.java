package com.example.nourhenechettaoui.surfacepicture;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class CustomSurfaceView extends SurfaceView implements SurfaceHolder.Callback,View.OnTouchListener {

    boolean isPreview;

    Camera myCamera;
    SurfaceHolder maSurface ;
    Bitmap cross;

    public CustomSurfaceView(Context context){
        super(context);
        SurfaceHolder holder=getHolder();
        holder.addCallback(this);
        maSurface=holder;
        setOnTouchListener(this);




    }

    public CustomSurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        try {

            myCamera = Camera.open();

        } catch (RuntimeException e) {

            // check for exceptions

            System.err.println(e);

            return;

        }

        Camera.Parameters params= myCamera.getParameters();
        List<Camera.Size> sizes=params.getSupportedPictureSizes();
        Camera.Size mySize=null;

        for(Camera.Size size : sizes){
            mySize=size;
        }
        // changer l'orientation de la camera :
        if(this.getResources().getConfiguration().orientation!= Configuration.ORIENTATION_LANDSCAPE){

            params.set("orientation","portrait");
            myCamera.setDisplayOrientation(90);
            params.setRotation(90);

        }
        else{
            params.set("orientation","landscape");
            myCamera.setDisplayOrientation(0);
            params.setRotation(0);

        } try {
            myCamera.setParameters(params);
            myCamera.setPreviewDisplay(holder);
            myCamera.startPreview();
        }
        catch(IOException e){

            e.printStackTrace();

        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {

        // On arrete la camera et nous rendons la main
        myCamera.stopPreview();
        myCamera.release();

    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        float x = event.getX();
        float y = event.getY();
if (event.getAction()==MotionEvent.ACTION_DOWN) {
    Log.d("Touch", "position x : " + x + ", position y : " + y);
    (new Photo(myCamera)).start();
}       return true;
    }


    private void onDraw(float x, float y){
        //take a picture

        //save photo
    }
}

