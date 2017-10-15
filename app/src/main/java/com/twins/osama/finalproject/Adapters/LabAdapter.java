package com.twins.osama.finalproject.Adapters;

import android.app.FragmentManager;
import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twins.osama.finalproject.Classes.RvLabs;
import com.twins.osama.finalproject.R;

import java.util.ArrayList;

/**
 * Created by osama on 19/9/2017.
 */

public class LabAdapter extends RecyclerView.Adapter<LabAdapter.ViewHolder>  {

    ArrayList<RvLabs> item = new ArrayList<>();
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;
    Context context;
    public LabAdapter( Context context, ArrayList item) {
        this.context = context;
        this.item = item;
    }
    @Override
    public LabAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_labs, parent, false);
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(LabAdapter.ViewHolder holder, int position) {
        holder.text_nameLab.setText(item.get(position).nameLabe);
        holder.text_DateLab.setText(item.get(position).DateLab);
        holder.text_result.setText(item.get(position).resultLab);

    }

    public int getItemCount() {
        return item.size();
    }

    public void addItem(RvLabs rvLabs) {
        item.add(rvLabs);
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

        TextView text_nameLab;
        TextView text_DateLab;
        TextView text_result;

        // CardView cv;
        public ViewHolder(View view) {
            super(view);
            //cv = (CardView) itemView.findViewById(R.id.cardView);

            text_nameLab = (TextView) view.findViewById(R.id.tvNameLab);
            text_DateLab = (TextView) view.findViewById(R.id.tvDateLab);
            text_result = (TextView) view.findViewById(R.id.tvResult);

        }

    }
}
