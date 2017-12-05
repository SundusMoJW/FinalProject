package com.twins.osama.finalproject.Adapters;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.twins.osama.finalproject.Classes.Pharm;
import com.twins.osama.finalproject.Classes.ToAccessPharmAdapter;
import com.twins.osama.finalproject.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Osama on 12/1/2017.
 */

public class PharmAdapter extends RecyclerView.Adapter<PharmAdapter.ViewHolder> {
    private List<ToAccessPharmAdapter> item = new ArrayList<>();
//    private String timeSpent;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    Activity activity;

    public PharmAdapter(Activity activity, List<ToAccessPharmAdapter> item) {
        this.activity = activity;
        this.item = item;
//        this.timeSpent = timeSpent;
    }

    @Override
    public PharmAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_pharm, parent, false);
        return new PharmAdapter.ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(PharmAdapter.ViewHolder holder, int position) {
        holder.timeSpent.setText(item.get(position).getKey());
        for (Pharm pharm : item.get(position).getPharms()) {
            holder.addView.addView(getItem(pharm));
        }
    }

    public ViewGroup getItem(Pharm pharm) {
        final RelativeLayout ll = (RelativeLayout) activity.getLayoutInflater().inflate(R.layout.add_many_text, null);
        TextView drug = (TextView) ll.findViewById(R.id.drug);
        TextView Qty = (TextView) ll.findViewById(R.id.Qty);
        TextView time = (TextView) ll.findViewById(R.id.time);
        TextView week = (TextView) ll.findViewById(R.id.week);

        drug.setText(pharm.getDrug());
        Qty.setText(pharm.getQty());
        time.setText(pharm.getTime());
        week.setText(pharm.getWeek());

        return ll;
    }

    public int getItemCount() {
        return item.size();
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

        TextView timeSpent;
        ViewGroup addView;

        // CardView cv;
        public ViewHolder(View view) {
            super(view);
            //cv = (CardView) itemView.findViewById(R.id.cardView);

            timeSpent = view.findViewById(R.id.timeSpent);
            addView = view.findViewById(R.id.addView);

        }

    }
}