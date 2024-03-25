package com.example.luckycoin;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

import pl.droidsonroids.gif.GifImageView;

public class ClassicActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classic);
    }

    public int x=200;
    public boolean dritto=false;

    public void flip(View view) throws InterruptedException {
        GifImageView gi = (GifImageView) findViewById(R.id.coinflip);
        ImageView iv = (ImageView) findViewById(R.id.euro);
        TextView tv = (TextView) findViewById(R.id.Domanda);
        TextView tv2 = (TextView) findViewById(R.id.Titolo);
        iv.setVisibility(View.INVISIBLE);
        gi.setVisibility(View.VISIBLE);
        x = x / 2;
        if (x == 1) x = 200;
        Random random = new Random();
        if (random.nextInt(x) == 0){
            dritto=true;
            tv.setText("Clicca sulla moneta per Fermarla");
        }else{
            tv.setText("Clicca sulla moneta per Fermarla!");
        }
        tv2.setText("Testa o Croce");
        tv2.setTextColor(Color.parseColor("#b02828"));
    }
    public void stopFlip(View view) throws InterruptedException {
        GifImageView gi = (GifImageView) findViewById(R.id.coinflip);
        ImageView iv = (ImageView) findViewById(R.id.euro);
        TextView tv = (TextView) findViewById(R.id.Domanda);
        TextView tv2 = (TextView) findViewById(R.id.Titolo);
        gi.setVisibility(View.GONE);
        //int cT=0, cC=0, cD=0;
        //for(int i=0;i<10000;i++) {
            Random random = new Random();
            int res = random.nextInt(2);
            if (dritto) {
                iv.setImageResource(R.drawable.euroinpiedi);
                tv2.setText("E' CADUTA DRITTA !1!1!");
                tv2.setTextColor(Color.parseColor("#B17926"));
                x = 200;
                dritto=false;
                //cD++;
            } else if (res == 0) {
                iv.setImageResource(R.drawable.euro);
                tv2.setText("TESTA");
                tv2.setTextColor(Color.parseColor("#B17926"));
                //cT++;
            } else {
                iv.setImageResource(R.drawable.euroback);
                tv2.setText("CROCE");
                tv2.setTextColor(Color.parseColor("#B17926"));
                //cC++;
            }
        //}
        iv.setVisibility(View.VISIBLE);
        tv.setText("Clicca sulla moneta per Lanciarla!");
        // tv.setText("T: "+cT+" C: "+cC+" D: "+cD);
    }

    public void back(View view) {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }
        /*try {
            EditText et = (EditText) findViewById(R.id.Risposta);
            String value = et.getText().toString();
            int x = Integer.parseInt(value);
            x++;
            int i=0;
            int res;
            int cT = 0, cC = 0, cST = 0, cSC = 0, maxT = 0, maxC = 0;
            Random random = new Random();
            for(i=1;i<x;i++){
                res = random.nextInt(2);
                if (res==0){
                    cT++;
                    cST++;
                    cSC = 0;
                    if(cST > maxT) maxT=cST;
                }else{
                    cC++;
                    cSC++;
                    cST = 0;
                    if(cSC > maxC) maxC=cSC;
                }
            }
            String T = String.valueOf(cT);
            String C = String.valueOf(cC);

            TextView tv = (TextView) findViewById(R.id.Risultato);
            tv.setText(T+" Teste e "+C+" Croci\n\n La serie più alta è stata di:\n"+maxT+" per la Testa e "+maxC+" per la Croce");
        }catch (Exception e){
            TextView tv = (TextView) findViewById(R.id.Risultato);
            tv.setText("");
        }
    }*/
}