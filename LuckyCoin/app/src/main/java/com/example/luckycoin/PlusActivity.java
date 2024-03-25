package com.example.luckycoin;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class PlusActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_plus);
    }

    public void back(View view) {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }

    public void send(View view) {
        try {
            EditText et = (EditText) findViewById(R.id.form);
            String value = et.getText().toString();
            int x = Integer.parseInt(value);
            int i=0;
            int res;
            int cT = 0, cC = 0;
            Random random = new Random();
            for(i=0;i<x;i++){
                res = random.nextInt(2);
                if (res==0){
                    cT++;
                }else{
                    cC++;
                }
            }
            float Percent = cT*100/x;
            String PT = String.valueOf(Percent);
            Percent = cC*100/x;
            String PC = String.valueOf(Percent);
            String T = String.valueOf(cT);
            String C = String.valueOf(cC);

            TextView tv = (TextView) findViewById(R.id.Result);
            tv.setVisibility(View.VISIBLE);
            tv.setText("Resoconto:\n\nTeste: "+T+" ( "+PT+"% )\nCroci\t: "+C+" ( "+PC+"% )");
            //tv.setText(T+" Teste e "+C+" Croci\n\n La serie più alta è stata di:\n"+maxT+" per la Testa e "+maxC+" per la Croce");
            et.setText("");
        }catch (Exception e){
            TextView tv = (TextView) findViewById(R.id.Result);
            tv.setText("");
        }
    }
}