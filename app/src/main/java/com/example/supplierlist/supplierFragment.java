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
import com.example.supplierlist.dummy.SupplierContent;
import com.example.supplierlist.dummy.SupplierContent.Supplier;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class supplierFragment extends Fragment implements MysupplierRecyclerViewAdapter.onSupplierItemClicked {
    private static final String supplier_data_url = "http://192.168.0.23/MyAPI/supplier_list_connection.php";

    ArrayList<Supplier> ITEMS;
    public Context context;
    public View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_supplier_list, container, false);
        // Set the adapter
        context = view.getContext();
        ITEMS = new ArrayList<>();
        SupplierContent content = new SupplierContent(context);
        loadData();
        return view;
    }

    public void updateIU() {
        RecyclerView.LayoutManager manager = new GridLayoutManager(context, 2);
        RecyclerView recyclerView = (RecyclerView) view;
        MysupplierRecyclerViewAdapter viewAdapter = new MysupplierRecyclerViewAdapter(ITEMS, context);
        recyclerView.setLayoutManager(manager);
        recyclerView.setAdapter(viewAdapter);
        viewAdapter.setClickListener(this);
    }

    public void loadData() {
        StringRequest sr = new StringRequest(Request.Method.GET, supplier_data_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray data = new JSONArray(response);
//                    LOOP through response
                    for (int i = 0; i < data.length(); i++) {
                        JSONObject dataObject = data.getJSONObject(i);
                        int id = dataObject.getInt("id");
                        String name = dataObject.getString("name");
                        String contact = dataObject.getString("contact");
                        String email = dataObject.getString("email");
                        Supplier supplier = new Supplier(id + "", name, contact, email);
                        ITEMS.add(supplier);
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
    public void onDestinationClicked(Supplier supplier) {

        Intent intent = new Intent(supplierFragment.this.getActivity(), OrganizerOrderActivity.class);
        intent.putExtra("supplierName",supplier.getName());
        intent.putExtra("supplierID",supplier.getId());
        intent.putExtra("supplierContact",supplier.getContact());
        intent.putExtra("supplierEmail",supplier.getEmail());

    }
}
