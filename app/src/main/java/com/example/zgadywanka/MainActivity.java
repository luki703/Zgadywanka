package com.example.zgadywanka;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText editText;
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.textView);
    }
    public int getRandomNumber(int min, int max) {

        return (int) ((Math.random() * (max - min)) + min);
    }

    public void sprawdz()
    {
        int liczba = getRandomNumber(1,100);
        if (editText.getText().length() >0 && ! editText.getText().toString().matches(".*[^a-z].*"))
        {
            textView.setVisibility(View.VISIBLE);
            if (Integer.parseInt(editText.getText().toString()) == liczba)
            {
                //Toast.makeText(this, "Brawo to ta liczba", Toast.LENGTH_LONG).show();
                textView.setText("Brawo to ta liczba");
            }
            else if(Integer.parseInt(editText.getText().toString()) > liczba)
            {
                //Toast.makeText(this, "Mniej", Toast.LENGTH_LONG).show();
                textView.setText("Mniej");
            }
            else if(Integer.parseInt(editText.getText().toString()) < liczba)
            {
               // Toast.makeText(this, "Wiecej", Toast.LENGTH_LONG).show();
                textView.setText("Więcej");
            }
        }
        else
        {
            Toast.makeText(this, "wprowadz liczbę", Toast.LENGTH_LONG).show();
        }

    }

}