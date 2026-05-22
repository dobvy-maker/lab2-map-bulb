package com.example.lab2;

import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        TextView result = findViewById(R.id.textResult);

        Lamp lamp = new Lamp();

        String report = "";

        lamp.turnOn();
        report += "Test 1 Lamp ON: " + lamp.isOn() + "\n\n";

        lamp.turnOff();
        report += "Test 2 Lamp OFF: " + !lamp.isOn() + "\n\n";

        lamp.turnOn();

        for(int i = 0; i < 10; i++){
            lamp.brighten();
        }

        report += "Test 3 Intensity: " + lamp.getIntensity() + "\n\n";

        lamp.brighten();

        report += "Test 4 Bulb burned: "
                + lamp.isBulbBurned()
                + "\n\n";

        boolean replaced = lamp.replaceBulb();

        report += "Test 5 Replace bulb: "
                + replaced
                + "\n\n";
        // Test 6: Dim to 0
        lamp.turnOn();

        for(int i = 0; i < 5; i++){
            lamp.brighten();
        }

        while(lamp.getIntensity() > 0){
            lamp.dim();
        }

        report += "Test 6 Dim to 0, Lamp OFF: "
                + !lamp.isOn()
                + "\n\n";


// Test 7: Replace bulb while ON
        lamp.turnOn();

        boolean replaceWhileOn = lamp.replaceBulb();

        report += "Test 7 Replace while ON: "
                + replaceWhileOn
                + "\n\n";

        lamp.turnOff();


// Test 8: Turn on with burned bulb
        lamp.turnOn();

        for(int i = 0; i < 11; i++){
            lamp.brighten();
        }

        lamp.turnOn();

        report += "Test 8 Turn on burned bulb, shining: "
                + lamp.isShining()
                + "\n\n";

        result.setText(report);
    }
}