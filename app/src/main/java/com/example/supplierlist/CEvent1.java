package com.example.supplierlist;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class CEvent1 extends Fragment {

    EditText et;
    String title="";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_cevent1,container,false);


        TextView textresult = (TextView)view.findViewById(R.id.textView1);
        textresult.setTextColor(Color.BLACK);

        Spinner dropdown = view.findViewById(R.id.spinner1);

        String[] items = new String[]{"Festival", "Convention", "Conference","Seminar"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);

        Button btnFragment=(Button)view.findViewById(R.id.btnfragment1);

        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.eventframe, new CEvent2());
                fr.commit();
            }
        });
        return view;
    }

}
