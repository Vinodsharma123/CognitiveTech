package com.example.congitivetech.connectpackage;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.example.congitivetech.R;

import java.util.List;


public class MyItemRecyclerViewAdapter extends RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder> {

    private  List<Device> mValues;
    private Context context;
    public MyItemRecyclerViewAdapter(List<Device> items, Context context) {
        mValues = items;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_item_bluetooth, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final Device device = mValues.get(position);

        holder.bluetoothDeviceName.setText(device.getDeviceName());
        holder.layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, "Clicked : " + device.getDeviceHardwareAddress(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView bluetoothDeviceName;
        public final LinearLayout layout;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            bluetoothDeviceName = view.findViewById(R.id.bluetooth_dev_name);
            layout = view.findViewById(R.id.device_layout);
        }
    }
}
