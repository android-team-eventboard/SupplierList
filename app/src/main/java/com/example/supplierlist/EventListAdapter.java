package com.example.supplierlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

public class EventListAdapter extends ArrayAdapter<OwnerEvent> {

    private Context mContext;
    int mResource;

    public EventListAdapter(Context context, int resource, ArrayList<OwnerEvent> objects) {
        super(context, resource, objects);
        mContext=context;
        mResource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        String title=getItem(position).getTitle();
        String location=getItem(position).getLocation();
        String date=getItem(position).getDate();
        String time=getItem(position).getTime();

        OwnerEvent event = new OwnerEvent(title,date,time,location);

        LayoutInflater inflater=LayoutInflater.from(mContext);
        convertView=inflater.inflate(mResource,parent,false);

        TextView tvtitle=(TextView)convertView.findViewById(R.id.tvtitle);
        TextView tvlocation=(TextView)convertView.findViewById(R.id.tvlocation);
        TextView tvdate=(TextView)convertView.findViewById(R.id.tvdate);
        TextView tvtime=(TextView)convertView.findViewById(R.id.tvtime);

        tvtitle.setText(title);
        tvlocation.setText(location);
        tvdate.setText(date);
        tvtime.setText(time);

        return convertView;

    }
}
