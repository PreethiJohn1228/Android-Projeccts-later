package com.example.bouncingball;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.os.Bundle;
import android.text.format.Time;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new BallBounce(this));
    }
}


class BallBounce extends View {
    int screenW;
    int screenH;
    float X;
    int Y;
    int initialY;
    int initialX;
    int ballW;
    int ballH;
    int angle;
    float dY;
    float acc;
    Bitmap ball, bgr;
    int count;

    public BallBounce(Context context) {
        super(context);
        ball = BitmapFactory.decodeResource(getResources(), R.drawable.image); //load a ball image
        bgr = BitmapFactory.decodeResource(getResources(),R.drawable.sky_bgr); //load a background
        ballW = ball.getWidth();
        ballH = ball.getHeight();
        acc = 0.2f; //acceleration
        dY = 0; //vertical speed
        initialY = 400; //Initial vertical position.
        initialX = 0;
        angle = 0; //Start value for rotation angle.
        count=0;
    }

    @Override
    public void onSizeChanged (int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        screenW = w;
        screenH = h;
        bgr = Bitmap.createScaledBitmap(bgr, w, h, true); //Resize background to fit the screen.
        //X = (int) (screenW /2) - (ballW / 2) ; //Centre ball into the centre of the screen.
        X = initialX;
        Y = initialY;
    }

    @Override
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //Draw background.
        canvas.drawBitmap(bgr, 0, 0, null);

        //Compute roughly ball speed and location.
        X =(screenW /2) - (ballW / 2) ;

        if(count==1){
            X =(screenW /2) - (ballW / 2) ;
        }

        if(count>4){

        }
        if(count>=4){
            X+=1;
        }
        Y+= (int) dY; //Increase or decrease vertical position.
        if (Y > (screenH - ballH)) {
            dY=(-1)*dY; //Reverse speed when bottom hit.
            count++;
        }
        dY+= acc; //Increase or decrease speed.

        //Increase rotating angle.
        if (angle++ >360)
            angle =0;
        canvas.save();
        canvas.rotate(angle*8, X + (ballW / 2), Y + (ballH / 2));
        canvas.drawBitmap(ball, X, Y, null);
        canvas.restore();

        invalidate();
    }
}