package com.example.supplierlist;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import 	java.lang.Thread;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class LoginActivity extends AppCompatActivity {

    TextView user;
    TextView pwd;
    String type;
    private static final String URL_LOGIN = "http://10.111.16.49/MyAPI/login.php";
//private static String URL_LOGIN="http://192.168.0.23/MyAPI/login.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);

        user = findViewById(R.id.tv_username);
        pwd = findViewById(R.id.tv_password);

        TextView register = (TextView)findViewById(R.id.signUp_text);
        TextView signInButton = (TextView)findViewById(R.id.button_signin);

        register.setMovementMethod(LinkMovementMethod.getInstance());

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this, RegistrationActivity.class);
                startActivity(intent);
            }
        });

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email = user.getText().toString();
                 String   password = pwd.getText().toString();
                if(!email.isEmpty() || !password.isEmpty())
                {
                   Login(email,password);
                }
                else {
                    user.setError("Pleae Enter Email");
                    pwd.setError("Pleae Enter Password");
                }

            }

            private void Login(final String useremail, final String userpassword) {
                Log.d("Email", "Email: "+useremail+" Password "+userpassword);
                StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_LOGIN, new Response.Listener<String>() {

                    @Override
                    public void onResponse(String response) {
                        try {
                            Log.d("res", "reesponse  is"+response);

                            JSONObject jsonObject = new JSONObject(response);
                            String success = jsonObject.getString("success");
                            JSONArray jsonArray = jsonObject.getJSONArray("login");
                            Log.d("JSA", "onResponse: jsonArray is"+jsonArray);
                            if (success.equals("1")) {
                                for (int i = 0; i < jsonObject.length(); i++) {
                                    JSONObject object = jsonArray.getJSONObject(i);
                                    String name = object.getString("name").trim();
                                    String email = object.getString("email").trim();
                                    type = object.getString("type");
                                    Log.d("Type", "Type is "+type);
                                    Toast.makeText(LoginActivity.this, "Welcome " + name + "", Toast.LENGTH_SHORT).show();
                                    if (type.equals("owner")) {
                                        Log.d("owner", "onResponse: Inside owner");
                                        final Intent intent = new Intent(LoginActivity.this, OwnerActivity.class);
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
                                    }else if(type.equals("user"))
                                    {
                                        final Intent intent = new Intent(LoginActivity.this, MainActivity.class);
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
                                    else {
                                        Toast.makeText(LoginActivity.this, "ERROR LOGIN", Toast.LENGTH_SHORT).show();
                                    }
                                }
                                }
                            } catch (JSONException e) {
                            e.printStackTrace();
//                            Toast.makeText(LoginActivity.this, "ERROR LOGGING IN", Toast.LENGTH_SHORT).show();

                        }

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                })
                {
                    protected Map<String, String> getParams() throws AuthFailureError {
                        Map<String,String> param=new HashMap<>();
                        param.put("email",useremail);
                        param.put("password",userpassword);
                        return param;
                    }
                };
                RequestQueue requestQueue= Volley.newRequestQueue(LoginActivity.this);
                   requestQueue.add(stringRequest);


//
            }
        });
    }






}
