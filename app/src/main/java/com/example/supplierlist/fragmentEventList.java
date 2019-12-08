package com.example.supplierlist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.supplierlist.dummy.EventListData;
import com.example.supplierlist.dummy.EventListData.EventData;



import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

    public class fragmentEventList extends Fragment implements MyEventRecyclerViewAdapter.onBookButtonClicked{

    private static final String eventlist_data_url = "http://192.168.0.23/MyAPI/connection.php";

    ArrayList<EventData> ITEMS;
    public Context context;
    public View view;
//String[] urls={"https://picsum.photos/id/0/5616/3744","https://picsum.photos/id/1/5616/3744","https://picsum.photos/id/10/2500/1667","https://picsum.photos/id/100/2500/1656","https://picsum.photos/id/1000/5626/3635","https://picsum.photos/id/1001/5616/3744","https://picsum.photos/id/1002/4312/2868","https://picsum.photos/id/1003/1181/1772","https://picsum.photos/id/1008/5616/3744","https://picsum.photos/id/101/2621/1747"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_event_list, container, false);

        // Set the adapter
        context = view.getContext();
        ITEMS = new ArrayList<>();
        EventListData eventListData=new EventListData(context);
        loadData();

        return view;
    }

    public void updateIU() {
        RecyclerView.LayoutManager manager = new GridLayoutManager(context, 1);
        RecyclerView recyclerView = (RecyclerView) view;
        MyEventRecyclerViewAdapter viewAdapter = new MyEventRecyclerViewAdapter(ITEMS, context);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(viewAdapter);
        viewAdapter.setClickListener(this);
    }

    public void loadData() {
        StringRequest sr = new StringRequest(Request.Method.GET, eventlist_data_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray data = new JSONArray(response);
//                    LOOP through response
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject dataObject = data.getJSONObject(i);
                        String name = dataObject.getString("name");
                        String description = dataObject.getString("desc");
                        String date = dataObject.getString("date");
                        String time = dataObject.getString("time");
//                        String image=urls[i];
                        EventData eventData=new EventData(name,description,date,time);
                        ITEMS.add(eventData);
                    }
                    updateIU();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(context, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        Volley.newRequestQueue(context).add(sr);

    }

    @Override
    public void onDestinationDataClicked(EventData eventData) {

        Intent intent = new Intent(view.getContext(), UserRegistration.class);
//        intent.putExtra("eventImage",eventData.getImageView());
        intent.putExtra("eventName",eventData.getName());
        intent.putExtra("eventDesc",eventData.getDescription());
        intent.putExtra("eventDate",eventData.getDate());
        intent.putExtra("eventTime",eventData.getTime());
        startActivity(intent);
    }
}
