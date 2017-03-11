package com.applicaster.demo.view.adapters;

import android.app.Activity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.applicaster.demo.R;
import com.applicaster.demo.model.TweetResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ambruster on 3/10/2017.
 * Adapter class for searched elements
 */

public class SearchItemAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static OnItemClickListener mListener;
    private Activity ctx;
    private List<TweetResponse> original_items = new ArrayList<>();

    public SearchItemAdapter(Activity activity, OnItemClickListener onItemClickListener) {
        ctx = activity;
        original_items = new ArrayList<>();
        mListener = onItemClickListener;
    }

    public void Add(TweetResponse item) {
        original_items.add(item);
        notifyDataSetChanged();
    }

    public void Add(List<TweetResponse> items) {
        original_items.clear();
        original_items.addAll(items);
        notifyDataSetChanged();
    }

    public void Clear() {
        original_items.clear();
        notifyDataSetChanged();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(ctx).inflate(R.layout.row_search, parent, false);
        return new TwitterViewHolder(view, mListener);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TwitterViewHolder) {
            TwitterViewHolder viewHolder = (TwitterViewHolder) holder;
            viewHolder.bind(original_items.get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        return (null != original_items ? original_items.size() : 0);
    }

    public class TwitterViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private TextView tv_search_text;
        private CardView cv_container;
        private OnItemClickListener mListener;


        public TwitterViewHolder(View itemView, OnItemClickListener listener) {
            super(itemView);
            mListener = listener;
            tv_search_text = (TextView) itemView.findViewById(R.id.tv_search_text);
            cv_container = (CardView) itemView.findViewById(R.id.cv_container);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            mListener.onItemClick(getAdapterPosition(), v);
        }

        public void bind(final TweetResponse c, final int position) {
            tv_search_text.setText(c.getQuery());
            cv_container.setOnClickListener(v -> mListener.onItemClick(position, v));
        }
    }

    public boolean Validate(String chain) {
        return chain.trim().length() == 0;
    }

    public interface OnItemClickListener {
        void onItemClick(int position, View v);
    }

}