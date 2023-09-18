package com.example.resistencias;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ColorPicker extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_picker);

        // Botón para Negro
        findViewById(R.id.buttonBlack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResult("Negro");
            }
        });

        // Botón para Marrón
        findViewById(R.id.buttonBrown).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResult("Marrón");
            }
        });

        // Botón para Rojo
        findViewById(R.id.buttonRed).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResult("Rojo");
            }
        });

        // Botón para Naranja
        findViewById(R.id.buttonOrange).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResult("Naranja");
            }
        });

        // Botón para Amarillo
        findViewById(R.id.buttonYellow).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResult("Amarillo");
            }
        });

        // Botón para Verde
        findViewById(R.id.buttonGreen).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResult("Verde");
            }
        });

        // Botón para Azul
        findViewById(R.id.buttonBlue).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResult("Azul");
            }
        });

        // Botón para Violeta
        findViewById(R.id.buttonViolet).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResult("Violeta");
            }
        });

        // Botón para Gris
        findViewById(R.id.buttonGray).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResult("Gris");
            }
        });

        // Botón para Blanco
        findViewById(R.id.buttonWhite).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                returnResult("Blanco");
            }
        });

    }

    private void returnResult(String color) {
        Intent intent = new Intent();
        intent.putExtra("pickedColor", color);
        setResult(RESULT_OK, intent);
        finish();
    }
}
