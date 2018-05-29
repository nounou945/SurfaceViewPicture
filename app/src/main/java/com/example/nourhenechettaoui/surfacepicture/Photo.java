package com.example.nourhenechettaoui.surfacepicture;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.Camera;
import android.os.Environment;
import android.util.Log;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

class Photo extends Thread implements
        Runnable,Camera.PictureCallback {

    Camera tutu;

    public Photo(Camera tt){tutu=tt;}

    public void run()

    {

        Log.d("Prend","Photo");

        tutu.takePicture(null,null,this);


    }

    @Override

    public void onPictureTaken(byte[] arg0, Camera arg1) {
System.out.println("coucou");
        Bitmap bmp=BitmapFactory.decodeByteArray(arg0,0,arg0.length);
        File sdCard = Environment.getExternalStorageDirectory();
        File file = new File("/storage/folder", "photo.jpg");
        try {
            FileOutputStream fop = new FileOutputStream(file);
            bmp.compress(Bitmap.CompressFormat.JPEG, 100, fop);
            fop.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


// TODO Auto-generated method stub

    }

}
