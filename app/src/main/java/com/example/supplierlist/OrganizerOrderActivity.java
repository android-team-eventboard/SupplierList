package com.example.supplierlist;

import android.os.Bundle;
import android.widget.TextView;
import  android.content.Intent;

import androidx.appcompat.app.AppCompatActivity;

public class OrganizerOrderActivity extends AppCompatActivity {

private TextView name,email,contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_organizer_order);


        Intent intent = getIntent();
        String sid=intent.getStringExtra("supplierID");
        String sname=intent.getStringExtra("supplierName");
        String scontact=intent.getStringExtra("supplierContact");
        String semail=intent.getStringExtra("supplierEmail");

        name=(TextView) findViewById(R.id.supName);
        email=(TextView) findViewById(R.id.supEmail);
        contact=(TextView) findViewById(R.id.supContact);

        name.setText(sname);
        email.setText(semail);
        contact.setText(scontact);


    }

}
