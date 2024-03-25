package com.example.crypt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import java.nio.charset.StandardCharsets;

public class CryptActivity extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crypt);

        //evento per copiare negli appunti
       /* Button btn = (Button) findViewById(R.id.copia);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }

    public void Crypta(View view) {
        EditText et = (EditText) findViewById(R.id.Chiave);
        String Chiave = et.getText().toString();
        et = (EditText) findViewById(R.id.frase);
        String Frase = et.getText().toString();
        String text = cifra(Frase, Chiave);
        et.setText(text);
    }

    static String cifra(String testo, String chiave)
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
                    cifraCarattere(
                            testo.charAt(i), chiave.charAt( i % chiave.length() )
                    )
            );
        }
        return str.toString();
    }

    private static final int N_Alf = 26;

    private static char cifraCarattere(final int carattere, final int chiave)
    {
        //Riconduco i caratteri ad un numero compreso fra 1 e 26 in modo da cifrare utilizzando solo le lettere comuni
        int cifrato = ( Character.toUpperCase( carattere ) + Character.toUpperCase( chiave ) ) % N_Alf;

        if( Character.isLowerCase(carattere) )
        {
            return (char) ('a'+cifrato);
        } else {
            return (char) ('A'+cifrato);
        }
    }

    public void back(View view) {
        Intent in = new Intent(this, MainActivity.class);
        startActivity(in);
    }
}
