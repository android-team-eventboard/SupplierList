package com.example.supplierlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;
import android.widget.Toast;

import com.example.supplierlist.dummy.SupplierContent;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = this.getSupportFragmentManager();
        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.logout:
                        Intent intent = new Intent(MainActivity.this,LoginActivity.class);
                        break;
                    case R.id.EventList:
                        fragmentEventList ef=new fragmentEventList();
                        fm.beginTransaction().add(R.id.main_frame,ef).commit();
                        break;
                    case R.id.user_booking:
                        userBookingFragment ub=new userBookingFragment();
                        fm.beginTransaction().add(R.id.main_frame,ub).commit();
                        break;
                }
                return true;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
//        if(item.getItemId() == R.id.supplierList )
//        {
//            supplierFragment s = new supplierFragment();
//            fm.beginTransaction().add(R.id.main_frame,s).commit();
//        }
//        else
       if(item.getItemId() == R.id.ownerEventList )
        {
            fragmentEventList ef=new fragmentEventList();
            fm.beginTransaction().add(R.id.main_frame,ef).commit();

        }
        else if(item.getItemId() == R.id.userBookingList)
        {

            userBookingFragment ub=new userBookingFragment();
            fm.beginTransaction().add(R.id.main_frame,ub).commit();
        }
        else if(item.getItemId() == R.id.logout)
        {

//            LoginActivity loginActivity=new LoginActivity();
//            fm.beginTransaction().add(R.id.main_frame,loginActivity).commit();
        }
        else if(item.getItemId() == R.id.search){

            // MenuItem searchitem = item.getIte;
            SearchView searchView = (SearchView) item.getActionView();

            searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
                @Override
                public boolean onQueryTextSubmit(String query) {
                    return false;
                }

                @Override
                public boolean onQueryTextChange(String s) {
                    return false;
                }
            });
        }
        return true;
        }
}
