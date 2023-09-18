package com.example.resistencias;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    private boolean[] buttonState = {false, false, false, false};

    private HashMap<String, Integer> colorMap = new HashMap<String, Integer>() {{
        put("Negro", 0);
        put("Marrón", 1);
        put("Rojo", 2);
        put("Naranja", 3);
        put("Amarillo", 4);
        put("Verde", 5);
        put("Azul", 6);
        put("Violeta", 7);
        put("Gris", 8);
        put("Blanco", 9);
    }};

    private static final int COLOR_PICKER_REQUEST = 1;

    // StringBuilder to hold selected colors
    private StringBuilder selectedColors = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Restart Button
        findViewById(R.id.buttonRestart).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                restartApp();
            }
        });

        // Button 1
        findViewById(R.id.button1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker(0);
            }
        });
        // Button 2
        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker(1);
            }
        });
        // Button 3
        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker(2);
            }
        });
        // Button 4
        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openColorPicker(3);
            }
        });
    }

    private void openColorPicker(int buttonIndex) {
        if (!buttonState[buttonIndex]) {
            Intent intent = new Intent(this, ColorPicker.class);
            startActivityForResult(intent, COLOR_PICKER_REQUEST);
            buttonState[buttonIndex] = true;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == COLOR_PICKER_REQUEST) {
            if (resultCode == RESULT_OK) {
                String pickedColor = data.getStringExtra("pickedColor");
                updateSelectedColors(pickedColor);
            }
        }
    }

    private void restartApp() {
        // Reset the selected colors
        selectedColors.setLength(0);

        // Reset the TextView
        TextView selectedColorsTextView = findViewById(R.id.selectedColorsTextView);
        selectedColorsTextView.setText("");

        // Reset the button states
        for (int i = 0; i < buttonState.length; i++) {
            buttonState[i] = false;
        }
    }

    private void updateSelectedColors(String newColor) {
        if (selectedColors.length() > 0) {
            selectedColors.append(", ");
        }
        selectedColors.append(newColor);

        TextView selectedColorsTextView = findViewById(R.id.selectedColorsTextView);
        selectedColorsTextView.setText(selectedColors.toString());

        // Calculate the resistance if 4 colors are picked
        String[] colors = selectedColors.toString().split(", ");
        if (colors.length == 4) {
            calculateAndDisplayResistance(colors);
        }
    }

    private void calculateAndDisplayResistance(String[] colors) {
        int firstDigit = colorMap.get(colors[0]);
        int secondDigit = colorMap.get(colors[1]);
        int multiplier = colorMap.get(colors[2]);

        int resistance = (firstDigit * 10 + secondDigit) * (int) Math.pow(10, multiplier);
        String resistanceStr = String.format("Resistencia: %d Ohms", resistance);

        TextView selectedColorsTextView = findViewById(R.id.selectedColorsTextView);
        selectedColorsTextView.append("\n" + resistanceStr);
    }
}
