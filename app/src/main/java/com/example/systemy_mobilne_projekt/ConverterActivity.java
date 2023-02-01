package com.example.systemy_mobilne_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class ConverterActivity extends AppCompatActivity {


    Spinner spinner1;

    Spinner spinner2;

    private SensorManager sensorManager;
    private Sensor sensorShake;

    private Sensor sensorBlow;
    int id1=0;
    int id2=0;
    boolean firstTime1=true;
    boolean firstTime2=true;
    boolean firstTime3=true;
    TextView wynik;
    EditText wprowadzDane;
    Button btnconvert;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);



        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensorShake = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
        sensorBlow = sensorManager.getDefaultSensor(Sensor.TYPE_PROXIMITY);
        SensorEventListener sensorEventListener1 = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(event!=null){

                    float x_acc=event.values[0];
                    float y_acc=event.values[1];
                    float z_acc=event.values[2];

                    if(x_acc>20){
                        firstTime1=true;
                        firstTime2=true;
                        spinner1.setSelection(randomnr());
                         spinner2.setSelection(randomnr());
                    }

                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };


        sensorManager.registerListener(sensorEventListener1, sensorShake, SensorManager.SENSOR_DELAY_NORMAL);


        SensorEventListener sensorEventListener2 = new SensorEventListener() {
            @Override
            public void onSensorChanged(SensorEvent event) {
                if(firstTime3==true){firstTime3=false;}else {

                    firstTime1=true;
                    firstTime2=true;
                    spinner1.setSelection(0);
                    spinner2.setSelection(0);
                    wprowadzDane.setText("0");
                    wynik.setText("Dziękuje za przytulasa :)");
                }
            }

            @Override
            public void onAccuracyChanged(Sensor sensor, int accuracy) {

            }
        };

        sensorManager.registerListener(sensorEventListener2, sensorBlow, SensorManager.SENSOR_DELAY_NORMAL);
        //Spinner
        spinner1=findViewById(R.id.spinner1);
        spinner2=findViewById(R.id.spinner2);

        wynik=findViewById(R.id.wynikTextView);
        wprowadzDane=findViewById(R.id.convertedAmountEditText);
        btnconvert=findViewById(R.id.finishConvertingBtn);




        String[] waluty={"Złoty polski","Frank szwajcarski","Euro","Funt brytyjski", "Dolar Amerykański", "Juan Chiński", "Jen Japoński", "Lira Turecka", "Peso Meksykańskie", "Rubel rosyjski"};

        String[] znaki={"PLN","CHF", "EUR", "GBP", "USD", "CNY", "JPY", "TRY", "MXN", "RUB" };

        Double[] wartoscNaPln={ 1.0,4.70, 4.71, 5.36, 4.33, 0.64,0.033, 0.23, 0.23, 0.061};

        ArrayAdapter ad1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, znaki);
        ArrayAdapter ad2 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, znaki);


        ad1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        ad2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner1.setAdapter(ad1);
        spinner2.setAdapter(ad2);

        btnconvert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wynik.setText(wprowadzDane.getText().toString()+znaki[id1] +" = "+ Double.parseDouble(wprowadzDane.getText().toString())*(wartoscNaPln[id1]/wartoscNaPln[id2]) + znaki[id2]);
            }
        });

        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(firstTime1==true){firstTime1=false;}else{
                Toast.makeText(ConverterActivity.this, "Wybrano: "+waluty[position],Toast.LENGTH_SHORT).show();}
                id1=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if(firstTime2==true){firstTime2=false;}else{
                Toast.makeText(ConverterActivity.this, "Wybrano: "+waluty[position],Toast.LENGTH_SHORT).show();}
                id2=position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });



    }

    int randomnr(){

        int random = new Random().nextInt(10-0)+0;
        return random;
    }


}