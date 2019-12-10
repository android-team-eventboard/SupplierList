package com.example.supplierlist;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserRegistration extends AppCompatActivity {


    public TextView name,desc,date,time;
    public ImageView imgview;
    public Button bookingbtn;
    FragmentManager fm ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);

        Intent intent = getIntent();
        String eventImg=intent.getStringExtra("eventImage");
        String eventName=intent.getStringExtra("eventName");
        String eventDesc=intent.getStringExtra("eventDesc");
        String eventDate=intent.getStringExtra("eventDate");
        String eventTime=intent.getStringExtra("eventTime");


        imgview=(ImageView)findViewById(R.id.eventImage);
        name=(TextView)findViewById(R.id.eventNameData);
        desc=(TextView) findViewById(R.id.eventDescData);
        date=(TextView) findViewById(R.id.eventDateData);
        time=(TextView)findViewById(R.id.eventTimeData);
        bookingbtn=(Button)findViewById(R.id.bookingbtn);

//        int id = getResources().getIdentifier("com.example.supplierlist.:drawable/images.jpg", null, null);
//        imgview.setImageResource(id);
//        Picasso.get().load(eventImg).into(imgview);
//       Resources resources=getResources();
//        Drawable drawable=resources.getDrawable()
//        imgview.setImageDrawable(R.drawable.images);
//        Drawable myDrawable = getResources().getDrawable(R.drawable.images);
//        imgview.setImageDrawable(myDrawable);

        name.setText(eventName);
        desc.setText(eventDesc);
        date.setText(eventDate);
        time.setText(eventTime);

        bookingbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(UserRegistration.this, "Booked Sucessfully", Toast.LENGTH_SHORT).show();
                final Intent intent = new Intent(UserRegistration.this, MainActivity.class);
                Thread thread = new Thread() {
                    @Override
                    public void run() {
                        try {
                            Thread.sleep(10);
                            startActivity(intent);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                };
                thread.start();

            }
        });

    }
}
