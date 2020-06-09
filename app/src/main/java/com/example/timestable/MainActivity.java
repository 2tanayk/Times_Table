package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity
{
    ListView  timesTableListView;
    public void generateTimesTable(int timesTableNumber)
    {
        ArrayList<String> timeTableContent=new ArrayList<>();
        for(int j=1;j<=100;j++)
        {
            timeTableContent.add(timesTableNumber+" x "+j+" ="+(timesTableNumber*j)+"");
        }
        ArrayAdapter<String> arrayAdapter=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,timeTableContent);
        timesTableListView.setAdapter(arrayAdapter);
    }



    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final SeekBar timesTableSeekBar=findViewById(R.id.timesTableSeekBar);
        timesTableListView =findViewById(R.id.timesTableListView);

        int max=20;
        int startingPosition=10;

        timesTableSeekBar.setMax(max);
        timesTableSeekBar.setProgress(startingPosition);

        generateTimesTable(startingPosition);

        timesTableSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                int min=1;
                int timesTableNumber;
                if(progress<min)
                {
                    timesTableNumber=min;
                    timesTableSeekBar.setProgress(min);
                }
                else
                {
                    timesTableNumber=progress;
                }
                Log.i("Seekbar value",progress+"");
                generateTimesTable(timesTableNumber);
            }


            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }
}
