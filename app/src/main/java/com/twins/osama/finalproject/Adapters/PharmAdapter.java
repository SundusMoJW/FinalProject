package com.twins.osama.finalproject.Adapters;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.twins.osama.finalproject.Classes.Pharm;
import com.twins.osama.finalproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osama on 12/1/2017.
 */

public class PharmAdapter extends RecyclerView.Adapter<PharmAdapter.ViewHolder> {
    List<Pharm> item = new ArrayList<>();
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    Activity activity;

    public PharmAdapter(Activity activity, List item) {
        this.activity = activity;
        this.item = item;
    }

    @Override
    public PharmAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_pharm, parent, false);
        return new PharmAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PharmAdapter.ViewHolder holder, int position) {
        holder.name.setText(item.get(position).getMonth());
        List<String> drug = item.get(position).getDrug();
        for (String str : drug) {
            if (!(str.equals("false"))) {
                holder.addView.addView(getItem(str));
            }
        }

//        holder.addView;

    }

    public ViewGroup getItem(String str) {
        final LinearLayout ll = (LinearLayout) activity.getLayoutInflater().inflate(R.layout.add_many_text, null);
        TextView txt = (TextView) ll.findViewById(R.id.txt);
        txt.setText(str);
        return ll;
    }

    public int getItemCount() {
        return item.size();
    }

    public void addItem(Pharm pharm) {
        item.add(pharm);
        notifyItemInserted(item.size());
    }

    public void removeItem(int position) {
        item.remove(position);
        notifyItemRemoved(position);
        notifyItemRangeChanged(position, item.size());
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView name;
        ViewGroup addView;

        // CardView cv;
        public ViewHolder(View view) {
            super(view);
            //cv = (CardView) itemView.findViewById(R.id.cardView);

            name = view.findViewById(R.id.name);
            addView = view.findViewById(R.id.addView);

        }

    }
}