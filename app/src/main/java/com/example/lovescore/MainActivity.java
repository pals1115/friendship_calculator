package com.example.lovescore;

import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    EditText etMyName, etPartnerName;
    Button btnCalculate;
    TextView tvResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        etMyName = findViewById(R.id.etMyName);
        etPartnerName = findViewById(R.id.etPartnerName);
        btnCalculate = findViewById(R.id.btnCalculate);
        tvResult = findViewById(R.id.tvResult);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String myName = etMyName.getText().toString();
                String partnerName = etPartnerName.getText().toString();
                String sum = myName + partnerName;
                sum = sum.toLowerCase(Locale.ROOT);

                int value = sum.hashCode();

                Random random = new Random(value);

                String result = (random.nextInt(100) + 1) + "%";

                if (myName.equals("") || partnerName.equals("")) {
                    Toast.makeText(getApplicationContext(), "Enter empty fields", Toast.LENGTH_SHORT).show();
                } else {
                    tvResult.setText(result);
                }
            }
        });
    }
}
