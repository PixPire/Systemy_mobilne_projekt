package com.example.systemy_mobilne_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class ConverterActivity extends AppCompatActivity {


    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_converter);

        Intent i = getIntent();
        String id = i.getStringExtra("id");

        //pokazuje się 1000
        Toast.makeText(this,"We passed: "+id, Toast.LENGTH_LONG).show();


        //Spinner
        spinner=findViewById(R.id.spinner1);

        String[] waluty={"PLN", "EUR", "DOL", "JENGI"};
        ArrayAdapter ad = new ArrayAdapter(this, android.R.layout.simple_spinner_item, waluty);


        ad.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        spinner.setAdapter(ad);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ConverterActivity.this, "You Selected: "+waluty[position],Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }
}