package com.example.supplierlist;

import android.graphics.Color;
import android.os.Bundle;
import android.text.method.KeyListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class CEvent2 extends Fragment {
    EditText venue;
    KeyListener listener;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_cevent2,container,false);

        TextView textresult = (TextView)view.findViewById(R.id.textView2);
        textresult.setTextColor(Color.BLACK);

        venue=(EditText)view.findViewById(R.id.venuebox);

        Spinner dropdown = view.findViewById(R.id.spinner2);

        String[] items = new String[]{"Venue", "Online event", "To be announced"};

        ArrayAdapter<String> adapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_spinner_dropdown_item, items);

        dropdown.setAdapter(adapter);

        listener = venue.getKeyListener();

        dropdown.setOnItemSelectedListener(
                new AdapterView.OnItemSelectedListener() {
                    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {

                        Object item = parent.getItemAtPosition(pos);
                        if(item.toString()=="Online event")
                            venue.setKeyListener(null);
                        else
                            venue.setKeyListener(listener);

                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> parent) {

                    }

                });

        Button btnFragment=(Button)view.findViewById(R.id.btnfragment2);

        Button btnFragment2=(Button)view.findViewById(R.id.btnfragment22);

        btnFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.eventframe, new CEvent3());
                fr.commit();
            }
        });

        btnFragment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction fr=getFragmentManager().beginTransaction();
                fr.replace(R.id.eventframe, new CEvent1());
                fr.commit();
            }
        });


        return view;
    }}
