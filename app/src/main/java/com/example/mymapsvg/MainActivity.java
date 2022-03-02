package com.example.mymapsvg;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button up =findViewById(R.id.up);
        Button down = findViewById(R.id.down);
        Button left = findViewById(R.id.left);
        Button right = findViewById(R.id.right);

        position = findViewById(R.id.woman);

        up.setOnClickListener(this);
        down.setOnClickListener(this);
        left.setOnClickListener(this);
        right.setOnClickListener(this);

    }


    @SuppressLint("NonConstantResourceId")
    @Override
    public void onClick(View v) {

      // maximum values to keep the position within the map
      int maxUp = 170;
      int maxDown = 570;
      int maxLeft = 50;
      int maxRight = 760;

      // when button pressed, change position
        switch (v.getId()){
            case R.id.up:
                FrameLayout.LayoutParams paramsU=(FrameLayout.LayoutParams) position.getLayoutParams();
                if(paramsU.topMargin > maxUp) {
                    paramsU.topMargin -= 20;
                    position.setLayoutParams(paramsU);
                }
                break;

            case R.id.down:
                FrameLayout.LayoutParams paramsD=(FrameLayout.LayoutParams) position.getLayoutParams();
                if(paramsD.topMargin < maxDown) {
                    paramsD.topMargin += 20;
                    position.setLayoutParams(paramsD);
                }
                break;

            case R.id.left:
                FrameLayout.LayoutParams paramsL=(FrameLayout.LayoutParams) position.getLayoutParams();
                if(paramsL.leftMargin > maxLeft) {
                    paramsL.leftMargin -= 20;
                    position.setLayoutParams(paramsL);
                }
                break;

            case R.id.right:
                FrameLayout.LayoutParams paramsR=(FrameLayout.LayoutParams) position.getLayoutParams();
                if(paramsR.leftMargin < maxRight) {
                    paramsR.leftMargin += 20;
                    position.setLayoutParams(paramsR);
                }
                break;
        }


    }

    // class Zoom for scaling the map image

    public class Zoom extends AppCompatActivity {
        FrameLayout fl;
        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(findViewById(R.id.zoom));

            ZoomLayout myZoomView = new ZoomLayout(Zoom.this);

            fl = (FrameLayout)findViewById(R.id.zoom);
            fl.addView(myZoomView);
        }
    }

}