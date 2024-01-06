package com.learnpainless.timer;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class MainActivity extends AppCompatActivity {

    TimerAdpter recyclerViewAdapter;
    Button button1, button2;
    ArrayList<Long> al = new ArrayList<>();


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        MyView myView = findViewById(R.id.clock);
        RecyclerView recyclerView = findViewById(R.id.recycler_view);
        button1=findViewById(R.id.min);
        button2=findViewById(R.id.min2);

        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
        try {
            Date mDate = simpleDateFormat.parse("00:05:00");
            long timeInMilliseconds = mDate.getTime();
            Log.e("TAG", "onCreate: "+timeInMilliseconds );
        } catch (ParseException e) {
            e.printStackTrace();
        }

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                al.add(10000L);
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                al.add(50000L);
                recyclerViewAdapter.notifyDataSetChanged();
            }
        });


        al.add(20000L);
        al.add(30000L);
        al.add(50000L);
        Log.e("TAG", "onCreate: " );
        recyclerViewAdapter=new TimerAdpter(this,al);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

//        recyclerViewAdapter = new RecyclerViewAdapter(null); //pass item click listener of you want to handle recyclerview item clicks.
        recyclerView.setAdapter(recyclerViewAdapter);
    }

    @Override
    protected void onPause() {
        super.onPause();

        //remove all timer before pausing app.
//        recyclerViewAdapter.clearAll();
    }
    }
