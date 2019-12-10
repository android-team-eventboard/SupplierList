package com.example.supplierlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;


public class RegistrationActivity extends AppCompatActivity {


    TextView userName;
    TextView emailtv;
    TextView pwd;
    TextView type;
    String name;
    String email;
    String password;
    String typeofsignup;
    private static final String URL_REG = "http://10.111.16.49/MyAPI/register.php";
//    private static String URL_REG="http://192.168.0.23/MyAPI/register.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_registration);

        TextView login = (TextView)findViewById(R.id.signIn_text);
        TextView signUpButton = (TextView)findViewById(R.id.button_signup);

        login.setMovementMethod(LinkMovementMethod.getInstance());

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                boolean loginValidated=signInValidation();

                Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });

        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

registrationValidate();
            }
        });
    }

    private void registrationValidate()
    {
        userName = findViewById(R.id.tv_username_signup);
        emailtv=findViewById(R.id.tv_email_signup);
        pwd = findViewById(R.id.tv_password_signup);
        type=findViewById(R.id.tv_type_of_signup);

        name= userName.getText().toString();
        email = emailtv.getText().toString();
         password = pwd.getText().toString();
         typeofsignup=type.getText().toString();

         //              Create account here in database
        StringRequest stringRequest = new StringRequest(Request.Method.POST, URL_REG, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject=new JSONObject(response);
                    String success=jsonObject.getString("success");
                    if(success.equals("1"))
                    {
                        Toast.makeText(RegistrationActivity.this,"Reg Success",Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(RegistrationActivity.this,"Reg Error"+e.toString(),Toast.LENGTH_SHORT).show();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(RegistrationActivity.this,"Reg Error"+error.toString(),Toast.LENGTH_SHORT).show();
            }
        }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> param=new HashMap<>();
                param.put("name",name);
            param.put("email",email);
            param.put("password",password);
            param.put("type",typeofsignup);
                return param;
            }
        };
        RequestQueue rq= Volley.newRequestQueue(this);
        rq.add(stringRequest);
//                Redirect after successfull signup
        Intent intent = new Intent(RegistrationActivity.this, LoginActivity.class);
        startActivity(intent);

    }


    public boolean signInValidation()
    {
         boolean validated=false;



         return  validated;

    }



}
