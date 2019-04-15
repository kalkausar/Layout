package com.example.kalkausar.latihan;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.kalkausar.latihan.model.Flight;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class FlightActivity extends AppCompatActivity {

    private TextInputEditText name_flight;
    private TextInputEditText departure_flight;
    private TextInputEditText arrival_flight;
    private TextInputEditText date_flight;
    private TextInputEditText passenger_flight;
    private TextInputEditText price_flight;
    private Button buttonSave;

    DatabaseReference databaseFlight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flight);
        setTitle("Input Tiket Pesawat");

        //declare
        name_flight=(TextInputEditText) findViewById(R.id.edit_Text_Name_Passengger);
        departure_flight = (TextInputEditText) findViewById(R.id.edit_Text_Departure);
        arrival_flight = (TextInputEditText) findViewById(R.id.edit_Text_Arrival);
        date_flight = (TextInputEditText) findViewById(R.id.edit_Text_Date);
        passenger_flight = (TextInputEditText) findViewById(R.id.edit_Text_Penumpang);
        price_flight = (TextInputEditText) findViewById(R.id.edit_Text_Price);
        buttonSave = (Button) findViewById(R.id.button_save_flight);

        databaseFlight=FirebaseDatabase.getInstance().getReference("Flight");

        date_flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showDateDialog();
            }
        });

        buttonSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addflight();
            }
        });
    }

    private void showDateDialog() {
        Calendar newCalendar = Calendar.getInstance();
        DatePickerDialog datePickerDialog = new DatePickerDialog(FlightActivity.this, new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                Calendar newDate = Calendar.getInstance();
                newDate.set(year, monthOfYear, dayOfMonth);
                SimpleDateFormat dateFormatter = new SimpleDateFormat("dd-MM-yyyy", Locale.US);
                date_flight.setText(dateFormatter.format(newDate.getTime()));
            }
        }, newCalendar.get(Calendar.YEAR), newCalendar.get(Calendar.MONTH), newCalendar.get(Calendar.DAY_OF_MONTH));
        datePickerDialog.show();
    }

    private void addflight(){
        String name = name_flight.getText().toString().trim();
        String departure = departure_flight.getText().toString().trim();
        String arrival = arrival_flight.getText().toString().trim();
        String date = date_flight.getText().toString().trim();
        String passenger = passenger_flight.getText().toString().trim();
        String price = price_flight.getText().toString().trim();

        if(departure.isEmpty()||arrival.isEmpty()||date.isEmpty()||passenger.isEmpty()||price.isEmpty()){
            Toast.makeText(this, "Mohon isi data secara lengkap!!", Toast.LENGTH_LONG).show();
        }else{
            String id= databaseFlight.push().getKey();
            Flight flight = new Flight(id, name, departure, arrival, date, passenger, price);
            databaseFlight.child(id).setValue(flight);
            Toast.makeText(this, "Berhasil ditambahkan", Toast.LENGTH_LONG).show();
        }
    }
}
