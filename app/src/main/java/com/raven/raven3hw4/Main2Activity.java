package com.raven.raven3hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class Main2Activity extends AppCompatActivity {
    static final String RESULT_KEY = "res_key";
    final Calendar calendar = Calendar.getInstance();
    EditText title2;
    EditText description2;
    EditText startDate2;
    EditText endDate2;
    Date startDateDate;
    Date endDateDate;


    CheckBox isDone2;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);





        setContentView(R.layout.activity_main2);
        title2 = findViewById(R.id.details_title2);
        description2 = findViewById(R.id.details_description2);
        startDate2 = findViewById(R.id.details_startDate2);
        endDate2 = findViewById(R.id.details_endDat2e);
        isDone2 = findViewById(R.id.details_isDone2);

        final DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR, i);
                calendar.set(Calendar.MONTH, i1);
                calendar.set(Calendar.DAY_OF_MONTH, i2);
                updateLabel();

            }
        };
        startDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Main2Activity.this, date, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });

        final DatePickerDialog.OnDateSetListener dateEnd = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int i, int i1, int i2) {
                calendar.set(Calendar.YEAR, i);
                calendar.set(Calendar.MONTH, i1);
                calendar.set(Calendar.DAY_OF_MONTH, i2);
                updateLabe2();
            }
        };

        endDate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new DatePickerDialog(Main2Activity.this, dateEnd, calendar.get(Calendar.YEAR),
                        calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });





    }
    private void updateLabel() {
        DateFormat format = new SimpleDateFormat();
        String string = format.format(calendar.getTime());
        startDateDate = calendar.getTime();
        startDate2.setText(string);


    }
    private void updateLabe2() {
        DateFormat format = new SimpleDateFormat();
        String string = format.format(calendar.getTime());
        endDateDate = calendar.getTime();
        endDate2.setText(string);
    }


    public void save (View v){

        Task task = new Task(title2.getText().toString(), description2.getText().toString(),
                startDateDate, endDateDate, false);

        Intent intent = new Intent();
        intent.putExtra(RESULT_KEY, task);
        setResult(RESULT_OK, intent);
        finish();
    }

}
