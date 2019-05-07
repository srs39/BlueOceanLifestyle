package com.bol.cbdstatstracker;

import android.content.Context;
import android.support.annotation.NonNull;
import 	android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.TextView;


import com.bol.cbdstatstracker.R;
import com.bol.cbdstatstracker.ui.BP;

import java.util.ArrayList;
import java.util.List;


public class BPListAdapter extends ArrayAdapter<BP> {
    private Context mContext;
    private int mResource;
    private int lastPosition = -1;

    public BPListAdapter(Context context, int resource, ArrayList<BP> objects){
        super(context, resource, objects);
        mContext = context;
        mResource = resource;
    }

    private static class ViewHolder {
        TextView date;
        TextView diastolic;
        TextView systolic;

    }

    @NonNull
    @Override
    public View getView(@NonNull int position, @NonNull View convertView,  @NonNull ViewGroup parent) {
        String date = getItem(position).getDate();
        String diastolic = getItem(position).getDiastolic();
        String systolic = getItem(position).getSystolic();

        final View result;
        ViewHolder holder;

        if(convertView == null){
            LayoutInflater inflater = LayoutInflater.from(mContext);
            convertView = inflater.inflate(mResource, parent, false);
            holder= new ViewHolder();
            holder.date = (TextView) convertView.findViewById(R.id.textView1);
            holder.systolic = (TextView) convertView.findViewById(R.id.textView2);
            holder.diastolic = (TextView) convertView.findViewById(R.id.textView3);

            result = convertView;

            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        lastPosition = position;

        holder.date.setText(date);
        holder.diastolic.setText(diastolic);
        holder.systolic.setText(systolic);

        return result;
    }
}
