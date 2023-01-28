package com.example.systemy_mobilne_projekt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    Button btn1;
    Button btn2;
    TextView txt;
    TimePicker timePicker;
    Button setAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txt= findViewById(R.id.txt);
        btn1=findViewById(R.id.btn);
        btn2=findViewById(R.id.btn2);
        Button btn3 = findViewById(R.id.buttonMusic);
        Button btn4 = findViewById(R.id.buttonVideo);



        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Explicit Intent
                Intent i = new Intent(getApplicationContext(), ConverterActivity.class);


                //sending data between activities
                i.putExtra("id","1000");
                startActivity(i);
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Implicit Intent
                Intent i2 = new Intent(Intent.ACTION_VIEW);
                i2.setData(Uri.parse("https://www.google.com"));
                startActivity(i2);

            }
        });


        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Explicit Intent
                Intent i3 = new Intent(getApplicationContext(), MusicPlayer.class);


                //sending data between activities
                i3.putExtra("id","1000");
                startActivity(i3);
            }
        });

        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Explicit Intent
                Intent i4 = new Intent(getApplicationContext(), VideoPlayer.class);


                //sending data between activities
                i4.putExtra("id","1000");
                startActivity(i4);
            }
        });


        setAlarm=findViewById(R.id.alarmbtn);

        setAlarm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Display time picker
                DialogFragment timePickerFrag = new TimePickerFragment();

                timePickerFrag.show(getSupportFragmentManager(),
                        "Choose alarm time: ");
            }
        });

        Button b3 = findViewById(R.id.btnDate);
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment dialogFragment = new DatePickerFragment();
                dialogFragment.show(getSupportFragmentManager(),"Wybierz Dzień");
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        return true;
    }






}