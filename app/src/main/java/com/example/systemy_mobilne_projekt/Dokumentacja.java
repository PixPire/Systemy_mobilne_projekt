package com.example.systemy_mobilne_projekt;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.github.barteksc.pdfviewer.PDFView;

public class Dokumentacja extends AppCompatActivity {


    PDFView pdfView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dokumentacja);
        pdfView=findViewById(R.id.pdfView);
        pdfView.fromAsset("kryteria_zaliczenia.pdf").load();

    }


}