package com.example.facemaker_dean;

import android.widget.AdapterView;
import android.graphics.Color;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.view.View;

import com.example.facemaker.Face;

/**
 * Facemaker
 * @author Tamsen Dean
 */
public class Facemaker implements AdapterView.OnItemSelectedListener, RadioGroup.OnCheckedChangeListener, View.OnClickListener, SeekBar.OnSeekBarChangeListener {

    private Face face;

    public int red;
    public int green;
    public int blue;
    public int color;

    public Facemaker(com.example.facemaker.Face face) {
        this.face = face;
        red = (int) (Math.random() * 255);
        green = (int) (Math.random() * 255);
        blue = (int) (Math.random() * 255);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String itemSelected = adapterView.getItemAtPosition(i).toString();
        if (itemSelected.equals("Short")) {
            face.hairStyle = 0;
        }
        if (itemSelected.equals("Medium")) {
            face.hairStyle = 1;
        }
        if (itemSelected.equals("Long")) {
            face.hairStyle = 2;
        }
        face.invalidate();
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        face.hairStyle = (int) (Math.random() * 3);
        face.invalidate();
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        color = Color.rgb(red, green, blue);
        if (i == R.id.hairButton) {
            // rgb corresponds to hair color
            face.hairPaint.setColor(color);
        }
        else if (i == R.id.eyesButton) {
            // rgb corresponds to eye color
            face.eyePaint.setColor(color);
        }
        else if (i == R.id.skinButton) {
            // rgb corresponds to skin color
            face.facePaint.setColor(color);
        }
        face.invalidate();
    }

    @Override
    public void onClick(View view) {
        // randomize hair, eyes, and skin
        face.randomize();
        face.invalidate();
    }

    @Override
    public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
        if (!fromUser) return;
        switch (seekBar.getId()) {
            case R.id.redSeekBar:
                // colored progress
                red = progress;
                break;

            case R.id.greenSeekBar:
                green = progress;
                break;

            case R.id.blueSeekBar:
                blue = progress;
                break;
        }
        face.invalidate();
    }

    @Override
    public void onStartTrackingTouch(SeekBar seekBar) {
        //null
    }

    @Override
    public void onStopTrackingTouch(SeekBar seekBar) {
        //null
    }
}