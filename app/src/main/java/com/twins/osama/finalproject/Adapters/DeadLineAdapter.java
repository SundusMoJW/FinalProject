package com.twins.osama.finalproject.Adapters;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.twins.osama.finalproject.Classes.RVDeadline;
import com.twins.osama.finalproject.R;

import java.util.ArrayList;

/**
 * Created by osama on 19/9/2017.
 */

public class DeadLineAdapter extends RecyclerView.Adapter<DeadLineAdapter.ViewHolder>{
    ArrayList<RVDeadline> item = new ArrayList<>();
    Context context;
    private FragmentManager mFragmentManager;
    private FragmentTransaction mFragmentTransaction;

    public DeadLineAdapter(Context context, ArrayList item) {
        this.context = context;
        this.item = item;
    }
    @Override
    public DeadLineAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.rv_deadline, parent, false);
//      TypefaceUtil.applyFont(context, view.findViewById(R.id.cardView));
        return new ViewHolder(view);
    }


    @Override
    public void onBindViewHolder(DeadLineAdapter.ViewHolder holder, int position) {
        holder.text_Reson.setText(item.get(position).Resone);
        holder.text_Date.setText(item.get(position).Date);
        holder.text_houer.setText(item.get(position).houer);

    }

    public int getItemCount() {
        return item.size();
    }

    public void addItem(RVDeadline rvDeadline) {
        item.add(rvDeadline);
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

        TextView text_Reson;
        TextView text_Date;
        TextView text_houer;

        // CardView cv;
        public ViewHolder(View view) {
            super(view);
            //cv = (CardView) itemView.findViewById(R.id.cardView);

            text_Reson = (TextView) view.findViewById(R.id.tvResonVisite);
            text_Date = (TextView) view.findViewById(R.id.tvDeadLine);
            text_houer = (TextView) view.findViewById(R.id.tvhour);

        }

    }
}