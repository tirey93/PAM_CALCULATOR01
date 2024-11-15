package com.example.mycalculator01;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Authors  extends AppCompatActivity {
    private Button bBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.authors);
        bBack = findViewById(R.id.authors_back);

        bBack.setOnClickListener(v -> {
            finish();
        });
    }

}
