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
import com.example.supplierlist.dummy.BookedHistory;
import com.example.supplierlist.dummy.BookedHistory.BookedData;



import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

//public class fragmentEventList extends Fragment implements MysupplierRecyclerViewAdapter.onSupplierItemClicked {
public class userBookingFragment extends Fragment implements userBookingRecyclerView.onBookButtonClicked{

    private static final String bookeddata_data_url = "http://10.111.16.49/MyAPI/list_booking_history.php";
//    private static final String eventlist_data_url = "http://192.168.0.23/MyAPI/connection.php";

    ArrayList<BookedData> ITEMS;
    public Context context;
    public View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_event_list, container, false);

        // Set the adapter
        context = view.getContext();
        ITEMS = new ArrayList<>();
         BookedHistory bh=new BookedHistory(context);
        loadData();

        return view;
    }

    public void updateIU() {
        RecyclerView.LayoutManager manager = new GridLayoutManager(context, 1);
        RecyclerView recyclerView = (RecyclerView) view;
        userBookingRecyclerView viewAdapter = new userBookingRecyclerView(ITEMS, context);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(viewAdapter);
        viewAdapter.setClickListener(this);
    }

    public void loadData() {
        StringRequest sr = new StringRequest(Request.Method.GET, bookeddata_data_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Log.d("newdataoutput", response);
                try {
                    JSONArray data = new JSONArray(response);
//                    LOOP through response
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject dataObject = data.getJSONObject(i);
                        String name = dataObject.getString("name");
                        String description = dataObject.getString("description");
                        String date = dataObject.getString("date");
                        String time = dataObject.getString("time");
                        BookedData bd=new BookedData(name,description,date,time);
                        ITEMS.add(bd);
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
    public void onDestinationDataClicked(BookedData bookedData) {
        Toast.makeText(context, bookedData.getName(), Toast.LENGTH_SHORT).show();
        //        Intent intent = new Intent(userBookingFragment.this.getActivity(), UserRegistration.class);
//        intent.putExtra("eventName",bookedData.getName());
//        intent.putExtra("eventDesc",bookedData.getDescription());
//        intent.putExtra("eventTime",bookedData.getTime());
//        intent.putExtra("eventDate",bookedData.getDate());
//        startActivity(intent);
    }


}
