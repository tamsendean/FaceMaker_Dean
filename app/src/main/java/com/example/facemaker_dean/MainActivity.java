package com.example.facemaker_dean;

import androidx.appcompat.app.AppCompatActivity;
import android.widget.ArrayAdapter;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.TextView;

/**
 * Main Activity
 * @author Tamsen Dean
 */
public class MainActivity extends AppCompatActivity {
    // user may choose 3 hairstyles
    private String[] hairstyles = {"Short", "Medium", "Long"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // add hairstyles to spinner
        ArrayAdapter<String> hairstyleAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_dropdown_item, hairstyles);
        Spinner spinner = findViewById(R.id.hairstyleSpinner);
        spinner.setAdapter(hairstyleAdapter);

        com.example.facemaker.Face face = findViewById(R.id.face);
        // make object
        Facemaker facemaker = new Facemaker(face);

        spinner.setOnItemSelectedListener(facemaker);

        RadioGroup radioGroup = findViewById(R.id.radioGroup);
        radioGroup.setOnCheckedChangeListener(facemaker);

        // set on click listener to random face button
        Button randomFaceButton = findViewById(R.id.randomFaceButton);
        randomFaceButton.setOnClickListener(facemaker);

        // set on seek bar change listener to seek bars
        SeekBar redSeekBar = findViewById(R.id.redSeekBar);
        redSeekBar.setOnSeekBarChangeListener(facemaker);

        SeekBar greenSeekBar = findViewById(R.id.greenSeekBar);
        greenSeekBar.setOnSeekBarChangeListener(facemaker);

        SeekBar blueSeekBar = findViewById(R.id.blueSeekBar);
        blueSeekBar.setOnSeekBarChangeListener(facemaker);

        // set seek bars to show progress
        redSeekBar.setProgress(facemaker.red);

        greenSeekBar.setProgress(facemaker.green);

        blueSeekBar.setProgress(facemaker.blue);

        // set text views to show progress
        TextView redNum = findViewById(R.id.redNum);
        redNum.setText("" + redSeekBar.getProgress());

        TextView greenNum = findViewById(R.id.greenNum);
        greenNum.setText("" + greenSeekBar.getProgress());

        TextView blueNum = findViewById(R.id.blueNum);
        blueNum.setText("" + blueSeekBar.getProgress());
    }
}