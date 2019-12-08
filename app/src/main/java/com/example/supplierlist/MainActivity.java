package com.example.supplierlist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.supplierlist.dummy.SupplierContent;

public class MainActivity extends AppCompatActivity {
    FragmentManager fm ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fm = this.getSupportFragmentManager();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu,menu);
        return true;
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.supplierList )
        {
            supplierFragment s = new supplierFragment();
            fm.beginTransaction().add(R.id.main_frame,s).commit();
        }
        else  if(item.getItemId() == R.id.ownerEventList )
        {
            fragmentEventList ef=new fragmentEventList();
            fm.beginTransaction().add(R.id.main_frame,ef).commit();

        }
        return true;
        }
}
