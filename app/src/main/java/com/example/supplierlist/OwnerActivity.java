package com.example.supplierlist;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SearchView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class OwnerActivity extends AppCompatActivity {
    FragmentManager fm ;
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

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_navigation_owner);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.logout:
                        Intent intent = new Intent(OwnerActivity.this,LoginActivity.class);
                        break;
                    case R.id.EventList:
                        fragmentEventList ef=new fragmentEventList();
                        fm.beginTransaction().add(R.id.main_frame,ef).commit();
                        break;
                    case R.id.supplierlist:
                        supplierFragment s = new supplierFragment();
                        fm.beginTransaction().add(R.id.main_frame,s).commit();
                        break;
//                    case R.id.AddEvent:
//                        CEventMain ce1=new CEventMain();
//                        fm.beginTransaction().add(R.id.main_frame,ce1).commit();
//                        break;
                }
                return true;
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


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu_owner,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        if(item.getItemId() == R.id.AddEvent )
        {
            CEvent1 ce1=new CEvent1();
            fm.beginTransaction().add(R.id.main_frame,ce1).commit();
        }
        else if(item.getItemId() == R.id.Supplier_List)
        {
            supplierFragment s = new supplierFragment();
            fm.beginTransaction().add(R.id.main_frame,s).commit();
        }
//        else if(item.getItemId() == R.id.ownerEventList)
//        {
//OwnerActivity oa=new OwnerActivity();
//fm.beginTransaction().add(R.id.main_frame,oa).commit();
//        }
//        else if(item.getItemId() == R.id.logout)
//        {
//
////            LoginActivity loginActivity=new LoginActivity();
////            fm.beginTransaction().add(R.id.main_frame,loginActivity).commit();
//        }
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
