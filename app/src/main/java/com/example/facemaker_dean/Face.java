package com.example.facemaker;
import java.util.Random;
import android.util.AttributeSet;
import android.os.Build;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.view.SurfaceView;
import android.annotation.SuppressLint;
import androidx.annotation.RequiresApi;

/**
 * Creates a face
 * @author Tamsen Dean
 */
public class Face extends SurfaceView {
    public int skinColor;
    public int eyeColor;
    public int hairColor;
    public int hairStyle;

    public Paint facePaint = new Paint();
    public Paint eyePaint = new Paint();
    public Paint mouthPaint = new Paint();
    public Paint hairPaint = new Paint();

    public Face(Context context, AttributeSet attrs) {
        super(context, attrs);
        setWillNotDraw(false);
        this.setBackgroundColor(Color.WHITE);
        this.mouthPaint.setColor(Color.RED);
        randomize();
    }

    public void randomize() {
        skinColor = Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        eyeColor = Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        hairColor = Color.rgb((int) (Math.random() * 255), (int) (Math.random() * 255), (int) (Math.random() * 255));
        hairStyle = (int) (Math.random() * 3);
        this.facePaint.setColor(skinColor);
        this.eyePaint.setColor(eyeColor);
        this.hairPaint.setColor(hairColor);
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @Override
    protected void onDraw(Canvas canvas) {
        int height = getHeight() / 2;
        int width = getWidth() / 2;
        int length = height;
        if (hairStyle == 0) {
            length = length + 500;
        } else if (hairStyle == 1) {
            length = length + 600;
        } else if (hairStyle == 2) {
            length = length + 700;
        }

        @SuppressLint("DrawAllocation") RectF rectF = new RectF(width - 280, height - 250, width + 280, length);
        canvas.drawArc(rectF, 0, -180, true, hairPaint);
        canvas.drawCircle(width, height, 200.0f, facePaint);
        @SuppressLint("DrawAllocation") RectF rectF2 = new RectF(width - 100, height - 10, width + 100, height + 100);
        canvas.drawArc(rectF2, 0, 180, true, mouthPaint);
        canvas.drawCircle(width - 100, height - 50, 38.0f, eyePaint);
        canvas.drawCircle(width + 100, height - 50, 38.0f, eyePaint);
    }
}