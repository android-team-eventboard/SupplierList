package com.example.supplierlist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;


import com.example.supplierlist.dummy.BookedHistory;

import java.util.List;

public class userBookingRecyclerView extends RecyclerView.Adapter<userBookingRecyclerView.ViewHolder> {

    private final List<BookedHistory.BookedData> bookedData;
    private onBookButtonClicked clickListener;
    private Context context;

    public void setClickListener(onBookButtonClicked clickListener) {
        this.clickListener = clickListener;
    }

    public userBookingRecyclerView(List<BookedHistory.BookedData> bookedData, Context context) {
        this.bookedData = bookedData;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_booking_history, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvName.setText(bookedData.get(position).name);
        holder.tvDate.setText(bookedData.get(position).date);
        holder.tvDescription.setText(bookedData.get(position).description);
        holder.tvTime.setText(bookedData.get(position).time);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BookedHistory.BookedData bookingdata=new BookedHistory.BookedData(bookedData.get(position).name,bookedData.get(position).description,bookedData.get(position).time,bookedData.get(position).date);
                clickListener.onDestinationDataClicked(bookingdata);
            }
        });

    }
    //
    public interface onBookButtonClicked {
        void onDestinationDataClicked(BookedHistory.BookedData bookdata);
    }

    @Override
    public int getItemCount() {
        return bookedData.size();
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
            tvTime = (TextView) view.findViewById(R.id.Booked_Event_Time);
            tvName = (TextView) view.findViewById(R.id.Booked_Event_Name);
            tvDescription = (TextView) view.findViewById(R.id.Booked_Event_Description);
            tvDate = (TextView) view.findViewById(R.id.Booked_Event_Date);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvName.getText() + "'";
        }
    }
}
