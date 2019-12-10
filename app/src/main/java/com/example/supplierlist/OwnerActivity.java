package com.example.supplierlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class OwnerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_owner);

        FloatingActionButton fab=(FloatingActionButton) findViewById(R.id.floating_action_button);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OwnerActivity.this, CEventMain.class);
                startActivity(intent);
            }
        });

        ListView listView=(ListView) findViewById(R.id.listView);

        OwnerEvent event1=new OwnerEvent("Seminar","2019-1-1","10:00","205, Humbr college blvd.");
        OwnerEvent event2=new OwnerEvent("Conference","2020-1-1","10:00","205, Humbr college blvd.");

        ArrayList<OwnerEvent> eventList=new ArrayList<OwnerEvent>();

        eventList.add(event1);
        eventList.add(event2);

        EventListAdapter adapter=new EventListAdapter(this,R.layout.listview_layout_adapter,eventList);
        listView.setAdapter(adapter);


    }}
