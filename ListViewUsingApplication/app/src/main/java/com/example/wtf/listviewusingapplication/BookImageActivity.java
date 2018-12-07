package com.example.wtf.listviewusingapplication;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.ImageView;

public class BookImageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_image);

        Intent intent = getIntent();
        int index = intent.getIntExtra("com.example.wtf.BOOK_INDEX",-1);

        if(index > -1) {
            int image = getImage(index);
            ImageView imgView = (ImageView) findViewById(R.id.imageView);
            scaleImage(imgView, image);
        }
    }

    private int getImage(int index) {
        switch (index){
            case 0: return R.drawable.the_alchemist;
            case 1: return R.drawable.da_vanci_code;
            case 2: return R.drawable.harry_potter;
            default: return -1;
        }
    }

    private void scaleImage(ImageView imgView, int img) {
        Display screen = getWindowManager().getDefaultDisplay();
        BitmapFactory.Options options = new BitmapFactory.Options();

        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(getResources(), img, options);

        int imgWidth = options.outWidth;
        int screenWidth = screen.getWidth();

        if(imgWidth > screenWidth) {
            int ratio = Math.round((float) imgWidth / (float) screenWidth);
            options.inSampleSize = ratio;

        }
        options.inJustDecodeBounds = false;
        Bitmap scaledImg = BitmapFactory.decodeResource(getResources(), img, options);
        imgView.setImageBitmap(scaledImg);

    }
}
