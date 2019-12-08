package com.example.supplierlist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.supplierlist.dummy.EventListData;
import com.example.supplierlist.dummy.EventListData.EventData;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyEventRecyclerViewAdapter extends RecyclerView.Adapter<MyEventRecyclerViewAdapter.ViewHolder>  {

    private final List<EventData> eventList;
    private onBookButtonClicked clickListener;
    private Context context;
    String internetURL="https://www.google.com/imgres?imgurl=https%3A%2F%2Fwww.acuityads.com%2Fwp-content%2Fuploads%2F2017%2F11%2Fevents_banner.jpg&imgrefurl=https%3A%2F%2Fwww.acuityads.com%2Fevents%2F&docid=YOscv1E0sNicuM&tbnid=VEoqx0zcDHE_IM%3A&vet=10ahUKEwi698HygafmAhVCgK0KHaMIBSUQMwiDASgKMAo..i&w=1365&h=574&bih=718&biw=1539&q=events&ved=0ahUKEwi698HygafmAhVCgK0KHaMIBSUQMwiDASgKMAo&iact=mrc&uact=8";
    String[] urls={"https://picsum.photos/id/0/5616/3744","https://picsum.photos/id/1/5616/3744","https://picsum.photos/id/10/2500/1667","https://picsum.photos/id/100/2500/1656","https://picsum.photos/id/1000/5626/3635","https://picsum.photos/id/1001/5616/3744","https://picsum.photos/id/1002/4312/2868","https://picsum.photos/id/1003/1181/1772","https://picsum.photos/id/1008/5616/3744","https://picsum.photos/id/101/2621/1747"};

    public void setClickListener(onBookButtonClicked clickListener) {
        this.clickListener = clickListener;
    }

    public MyEventRecyclerViewAdapter(List<EventData> eventList, Context context) {
        this.eventList = eventList;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("sc", "Inside Event Recycler View Adapter");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_event, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
//        Picasso.get().load(eventList.get(position).imageView).into(holder.);
        holder.tvName.setText(eventList.get(position).name);
        holder.tvDate.setText(eventList.get(position).date);
        holder.tvDescription.setText(eventList.get(position).description);
        holder.tvTime.setText(eventList.get(position).time);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
             EventData eventData=new EventData(eventList.get(position).name,eventList.get(position).description,eventList.get(position).time,eventList.get(position).date);
                clickListener.onDestinationDataClicked(eventData);
            }
        });

    }
//
    public interface onBookButtonClicked {
        void onDestinationDataClicked(EventListData.EventData eventData);
    }

    @Override
    public int getItemCount() {
        return eventList.size();
   }

    public class ViewHolder extends RecyclerView.ViewHolder {
       public  TextView tvName;
       public ImageView imageView;
        public  TextView tvDescription;
        public  TextView tvDate;
        public  TextView tvTime;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            imageView=(ImageView) view.findViewById(R.id.eventImage);
            tvTime = (TextView) view.findViewById(R.id.eventDateData);
            tvName = (TextView) view.findViewById(R.id.eventNameData);
            tvDescription = (TextView) view.findViewById(R.id.eventDescData);
            tvDate = (TextView) view.findViewById(R.id.eventTimeData);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvName.getText() + "'";
        }
    }
}
