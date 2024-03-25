package com.example.crypt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class DecryptActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_decrypt);
    }

    public void back(View view) {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }

    public void Decrypta(View view) {
        EditText et = (EditText) findViewById(R.id.Chiave);
        String Chiave = et.getText().toString();
        et = (EditText) findViewById(R.id.frase);
        String Frase = et.getText().toString();
        String text = decifra(Frase, Chiave);
        et.setText(text);
    }

    static String decifra(String testo, String chiave)
    {
        StringBuilder str = new StringBuilder( testo.length() );

        for(int i=0; i<testo.length(); i++)
        {
            if(! Character.isLetter( testo.charAt(i) ) )
            {
                str.append(testo.charAt(i) );
                continue;
            }

            str.append(
                    decifraCarattere(
                            testo.charAt(i), chiave.charAt( i % chiave.length() )
                    )
            );
        }
        return str.toString();
    }

    private static char decifraCarattere(final int carattere, final int chiave)
    {
        //decifrato deve essere compreso fra -26 e 26
        int decifrato = Character.toUpperCase( carattere ) - Character.toUpperCase( chiave );
        //riconduco decifrato ad un range 0 26
        if(decifrato<0) decifrato+=26;

        if( Character.isLowerCase(carattere) )
        {
            return (char) ('a'+decifrato);
        } else {
            return (char) ('A'+decifrato);
        }
    }
}
