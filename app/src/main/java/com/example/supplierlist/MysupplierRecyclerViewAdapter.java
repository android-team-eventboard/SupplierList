package com.example.supplierlist;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.supplierlist.dummy.SupplierContent;
import com.example.supplierlist.dummy.SupplierContent.Supplier;

import java.util.List;

public class MysupplierRecyclerViewAdapter extends RecyclerView.Adapter<MysupplierRecyclerViewAdapter.ViewHolder> {

    private final List<Supplier> mValues;
    private onSupplierItemClicked clickListener;
    private Context context;

    public void setClickListener(onSupplierItemClicked clickListener) {
        this.clickListener = clickListener;
    }

    public MysupplierRecyclerViewAdapter(List<Supplier> mValues, Context context) {
        this.mValues = mValues;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Log.d("sc", "Inside SupplierContent");
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_supplier, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, final int position) {
        holder.tvsupName.setText("Supplier: " + (position + 1));
        holder.tvId.setText(mValues.get(position).id);
        holder.tvEmail.setText(mValues.get(position).email);
        holder.tvContact.setText(mValues.get(position).contact);
        holder.tvName.setText(mValues.get(position).name);
        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Supplier supplier = new Supplier(mValues.get(position).supName, mValues.get(position).id, mValues.get(position).name, mValues.get(position).contact, mValues.get(position).email);
                Supplier supplier = new Supplier(mValues.get(position).id, mValues.get(position).name, mValues.get(position).contact, mValues.get(position).email);
                clickListener.onDestinationClicked(supplier);
            }
        });
    }

    public interface onSupplierItemClicked {
        void onDestinationClicked(SupplierContent.Supplier supplier);
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView tvId;
        public final TextView tvName;
        public final TextView tvContact;
        public final TextView tvEmail;
        public final TextView tvsupName;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            tvsupName = (TextView) view.findViewById(R.id.supName);
            tvId = (TextView) view.findViewById(R.id.ID);
            tvName = (TextView) view.findViewById(R.id.Name);
            tvContact = (TextView) view.findViewById(R.id.Contact);
            tvEmail = (TextView) view.findViewById(R.id.Email);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + tvName.getText() + "'";
        }
    }
}
