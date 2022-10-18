package com.example.birthdaydates;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.Period;
import android.os.Build;
import android.os.Bundle;
import android.text.style.TabStopSpan;
import android.view.View;
import android.widget.EditText;
import android .widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button calcBtn;
    EditText input1, input2;
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calcBtn = findViewById(R.id.calcBtn);
        input1 = findViewById(R.id.dateInput);
        input2 = findViewById(R.id.dateInput2);
    }

    public void handleClick(View view){
        String _date1 = input1.getText().toString();
        String _date2 = input2.getText().toString();

        try{
            LocalDate date1 = LocalDate.parse(_date1, dateTimeFormatter);
            LocalDate date2 = LocalDate.parse(_date2, dateTimeFormatter);

            Toast.makeText(getBaseContext(), "Diferença de datas (anos): "+ Period.between(date1, date2).toString(), Toast.LENGTH_SHORT).show();

        } catch(Exception e){
            Toast.makeText(getBaseContext(), "Tente novamente!", Toast.LENGTH_SHORT).show();
        }

    }
}