package com.example.zgadywanka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editTextNumber;
    TextView textView;
    TextView textView2;
    TextView textView3;
    int liczba = getRandomNumber(1,100);
    int iloscProb = 0;
    int iloscTrafien = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextNumber = findViewById(R.id.editTextNumber);
        textView = findViewById(R.id.textView);
        textView2 = findViewById(R.id.textView2);
        textView3 = findViewById(R.id.textView3);
    }
    public int getRandomNumber(int min, int max) {

        return (int) ((Math.random() * (max - min)) + min);
    }

    public void sprawdz(View view)
    {
        iloscProb++;
        if (editTextNumber.getText().length() >0 && ! editTextNumber.getText().toString().matches(".*[^a-z].*"))
        {
            textView.setVisibility(View.VISIBLE);
            if (Integer.parseInt(editTextNumber.getText().toString()) == liczba)
            {
                //Toast.makeText(this, "Brawo to ta liczba", Toast.LENGTH_LONG).show();

                iloscTrafien++;
                win(view);
            }
            else if(Integer.parseInt(editTextNumber.getText().toString()) > liczba)
            {
                //Toast.makeText(this, "Mniej", Toast.LENGTH_LONG).show();
                textView.setText("Mniej");
            }
            else if(Integer.parseInt(editTextNumber.getText().toString()) < liczba)
            {
               // Toast.makeText(this, "Wiecej", Toast.LENGTH_LONG).show();
                textView.setText("Więcej");
            }
        }
        else
        {
            Toast.makeText(this, "wprowadz liczbę", Toast.LENGTH_LONG).show();
        }
        textView2.setText("Ilość prób \n " + iloscProb);
        textView3.setText("Ilość trafień \n " + iloscTrafien);

    }
    public void win(View view)
    {
        iloscProb = 0;
        liczba = getRandomNumber(1,100);
        textView.setText("Brawo to ta liczba /n Wpisz liczbę 1-100");
    }
    public void reset(View view)
    {
        textView.setText("Wpisz liczbę 1-100");
        editTextNumber.setText(0);
        liczba = getRandomNumber(1,100);
        iloscProb = 0;
        iloscTrafien = 0;

    }

}