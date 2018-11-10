package com.example.avatarmind.robotmotion;

import android.app.Activity;
import android.content.Intent;
import android.nfc.Tag;
import android.os.Bundle;
import android.robot.motion.RobotMotion;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.avatarmind.robotmotion.http.ReservationAPI;

import org.xguzm.pathfinding.grid.GridCell;
import org.xguzm.pathfinding.grid.NavigationGrid;
import org.xguzm.pathfinding.grid.finders.AStarGridFinder;
import org.xguzm.pathfinding.grid.finders.GridFinderOptions;

import java.util.List;
import java.util.Random;

public class HasBooking extends Activity {



    final String TAG = "HasBooking";



    ReservationAPI reservationAPI = new ReservationAPI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_has_booking);


        Intent intent = getIntent();
        String str = intent.getStringExtra("location");


    }


    public void submitWithInfo(View v) {
        Toast.makeText(this, "Submitting with info", Toast.LENGTH_SHORT).show();
        //get the customer info from the view
        EditText phoneET = (EditText) findViewById(R.id.editText_phone);
        String phone = phoneET.getText().toString();
        Toast.makeText(this, "number: " + phone, Toast.LENGTH_LONG).show();
        //submit to the server
        reservationAPI.getReservationsByNumber(phone, (successful, reservations) -> {
            if (successful) {
                if (reservations.length > 0) {
                    //Toast.makeText(this, "Reservation Found", Toast.LENGTH_SHORT).show();
                    Log.d(TAG, "Reservation Found");
                    Log.d(TAG, TextUtils.join("\n", reservations));
                    Intent intent = new Intent(this, HasValidBooking.class);
                    intent.putExtra("reservation_id", reservations[0].id);
                    startActivity(intent);
                }
            }
            else {
                //Toast.makeText(this, "Failed to get Reservation", Toast.LENGTH_LONG).show();
                Log.e(TAG, "Failed to contact server");
            }
        });
    }

    public void cancel(View v) {
        finish();
    }





}
