package io.github.harsh8398.cryptocalc;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class CardViewDataAdapter extends RecyclerView.Adapter<CardViewDataAdapter.ViewHolder> implements View.OnClickListener {
    public String[] mDataset;
    public Integer[] mIcons;
    private Context context;

    // Provide a suitable constructor (depends on the kind of dataset)
    public CardViewDataAdapter(Context context, String[] myDataset, Integer[] myIcons) {
        this.context = context;
        mDataset = myDataset;
        mIcons = myIcons;
    }

    // Create new views (invoked by the layout manager)
    @Override
    public CardViewDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        // create a new view
        View itemLayoutView = LayoutInflater.from(parent.getContext()).inflate(
                R.layout.cardview_row, null);

        // create ViewHolder

        ViewHolder viewHolder = new ViewHolder(itemLayoutView);
        return viewHolder;
    }

    // Replace the contents of a view (invoked by the layout manager)
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {

        // - get data from your itemsData at this position
        // - replace the contents of the view with that itemsData

        viewHolder.tvtinfo_text.setText(mDataset[position]);
        viewHolder.tvtinfo_text.setTag(position);
        viewHolder.tvtinfo_text.setCompoundDrawablesWithIntrinsicBounds(mIcons[position], 0, 0, 0);
        viewHolder.tvtinfo_text.setOnClickListener(this);

    }

    // Return the size of your dataset (invoked by the layout manager)
    @Override
    public int getItemCount() {
        return mDataset.length;
    }

    @Override
    public void onClick(View view) {
        int position = (int) view.getTag();
        Intent i;
        switch (mDataset[position]) {
            case "Hashing":
                i = new Intent(context, HashingActivity.class);
                context.startActivity(i);
                break;
            case "Cipher":
                i = new Intent(context, CipherActivity.class);
                context.startActivity(i);
                break;
            case "Digital Signature":
                i = new Intent(context, DigsigActivity.class);
                context.startActivity(i);
                break;
        }
    }

    // inner class to hold a reference to each item of RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {

        public TextView tvtinfo_text;

        public ViewHolder(View itemLayoutView) {
            super(itemLayoutView);
            tvtinfo_text = (TextView) itemLayoutView
                    .findViewById(R.id.info_text);

        }
    }

}