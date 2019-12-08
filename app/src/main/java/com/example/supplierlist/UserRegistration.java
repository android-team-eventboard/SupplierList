package com.example.supplierlist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class UserRegistration extends AppCompatActivity {

    private static final String supplier_data_url="http://192.168.0.20/MyAPI/connection.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_registration);
        Log.d("Data","i'm here");
        loadData();
    }

    private void loadData() {
        Log.d("Data","i'm there");
        StringRequest sr=new StringRequest(Request.Method.GET, supplier_data_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    Log.d("Data",response);
                    JSONArray data=new JSONArray(response);
//                LOOP through response
for(int i=0;i<data.length();i++)
{
    JSONObject dataObject = data.getJSONObject(i);
    int id=dataObject.getInt("id");
    String name=dataObject.getString("name") ;
String description=dataObject.getString("desc");
String date=dataObject.getString("data");
String time=dataObject.getString("time");
int rsvp=dataObject.getInt("rsvp");
}
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(UserRegistration.this,error.getMessage(),Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(this).add(sr);
    }
}
