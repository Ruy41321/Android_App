package com.example.luckycoin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void OpenClassic(View view) {
        Intent in = new Intent(this, ClassicActivity.class);
        startActivity(in);
    }
    public void OpenPlus(View view) {
        Intent in = new Intent(this, PlusActivity.class);
        startActivity(in);
    }
}