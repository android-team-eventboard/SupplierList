package com.example.supplierlist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.supplierlist.dummy.EventListData;
import com.example.supplierlist.dummy.EventListData.EventData;

import java.util.List;

public class MyEventRecyclerViewAdapter extends RecyclerView.Adapter<MyEventRecyclerViewAdapter.ViewHolder> {

    private final List<EventData> eventList;
    private onBookButtonClicked clickListener;
    private Context context;

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
        holder.tvName.setText(eventList.get(position).name);
        holder.tvDate.setText(eventList.get(position).description);
        holder.tvDescription.setText(eventList.get(position).time);
        holder.tvTime.setText(eventList.get(position).date);
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
        public  TextView tvDescription;
        public  TextView tvDate;
        public  TextView tvTime;
        public final View mView;

        public ViewHolder(View view) {
            super(view);
            mView = view;
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
