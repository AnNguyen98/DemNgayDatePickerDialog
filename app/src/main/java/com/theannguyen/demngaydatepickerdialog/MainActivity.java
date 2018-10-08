package com.theannguyen.demngaydatepickerdialog;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView txtResult;
    EditText editTextOne,editTextTwo;
    Button   buttonResult;
    SimpleDateFormat simpleDateFormat;
    Calendar calendarTwo,calendarOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AnhXa();
        simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy");
        editTextOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialogOne();
            }
        });
        editTextTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                datePickerDialogTwo();
            }
        });
        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resultDate();
            }
        });
    }
    private void resultDate(){
        int result;
        result = (int)(calendarTwo.getTimeInMillis() - calendarOne.getTimeInMillis())/(1000*60*60*24);
        txtResult.setText(result + "");
    }
    private void datePickerDialogTwo(){
        calendarTwo = Calendar.getInstance();
        final int y = calendarTwo.get(Calendar.YEAR);
        int m = calendarTwo.get(Calendar.MONTH);
        int d = calendarTwo.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarTwo.set(year,month,dayOfMonth);
                editTextTwo.setText(simpleDateFormat.format(calendarTwo.getTime()));
            }
        },y,m,d);
        datePickerDialog.show();
    }
    private void datePickerDialogOne(){
        calendarOne = Calendar.getInstance();
        final int y = calendarOne.get(Calendar.YEAR);
        int m = calendarOne.get(Calendar.MONTH);
        int d = calendarOne.get(Calendar.DAY_OF_MONTH);
        DatePickerDialog datePickerDialog = new DatePickerDialog(this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendarOne.set(year,month,dayOfMonth);
                editTextOne.setText(simpleDateFormat.format(calendarOne.getTime()));
            }
        },y,m,d);
        datePickerDialog.show();
    }

    private void AnhXa() {
        editTextOne = (EditText) findViewById(R.id.editText);
        editTextTwo = (EditText) findViewById(R.id.editText2);
        txtResult = (TextView) findViewById(R.id.txtResult);
        buttonResult = (Button) findViewById(R.id.button);
    }
}
