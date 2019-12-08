package com.example.supplierlist;

import android.content.Context;
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

//public class fragmentEventList extends Fragment implements MysupplierRecyclerViewAdapter.onSupplierItemClicked {
    public class fragmentEventList extends Fragment implements MyEventRecyclerViewAdapter.onBookButtonClicked{

    private static final String eventlist_data_url = "http://192.168.0.23/MyAPI/connection.php";

    ArrayList<EventData> ITEMS;
    public Context context;
    public View view;

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
        Log.d("HELLLL", "poii : " + ITEMS.size());
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(viewAdapter);
    viewAdapter.setClickListener(this);
    }

    public void loadData() {
        StringRequest sr = new StringRequest(Request.Method.GET, eventlist_data_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("newdataoutput", response);
                try {
                    JSONArray data = new JSONArray(response);
//                    LOOP through response
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject dataObject = data.getJSONObject(i);
                        String name = dataObject.getString("name");
                        String description = dataObject.getString("desc");
                        String date = dataObject.getString("date");
                        String time = dataObject.getString("time");
//                        Supplier supplier = new Supplier(id + "", name, contact, email);
                        Log.d("newdataoutput", response);
//EventListData eventList=new EventListData(name,description,date,time);
EventData eventData=new EventData(name,description,date,time);
                        ITEMS.add(eventData);
                        Log.d("HELL", "LOL : " + ITEMS.size());
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
        Toast.makeText(getContext(), eventData.toString(), Toast.LENGTH_LONG).show();
        //getIntent here and pass the supplier object
        // on bhoomis fragment  page
    }
}
