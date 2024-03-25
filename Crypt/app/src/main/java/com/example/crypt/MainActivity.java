package com.example.crypt;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void OpenCrypt(View view) {
        Intent in = new Intent(this, CryptActivity.class);
        startActivity(in);
    }

    public void OpenDecrypt(View view) {
        Intent in = new Intent(this, DecryptActivity.class);
        startActivity(in);
    }

    public void OpenInfo(View view) {
        Intent in = new Intent(this, InfoActivity.class);
        startActivity(in);
    }
}