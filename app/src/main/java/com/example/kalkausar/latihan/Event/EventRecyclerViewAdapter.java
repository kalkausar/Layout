package com.example.kalkausar.latihan.Event;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kalkausar.latihan.R;

import java.util.List;

public class EventRecyclerViewAdapter extends RecyclerView.Adapter<EventRecyclerViewAdapter.MyViewHolderEvent> {

    Context mContext;
    List<cardMenu> mData;

    public EventRecyclerViewAdapter(Context mContext, List<cardMenu> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolderEvent onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v = LayoutInflater.from(mContext).inflate(R.layout.item_event, parent, false);
        MyViewHolderEvent vholderEvent = new MyViewHolderEvent(v);
        return vholderEvent;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderEvent holder, int position) {

        holder.tv_event_title.setText(mData.get(position).getTile());
        holder.tv_event_desc.setText(mData.get(position).getDescription());
        holder.img_event.setImageResource(mData.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolderEvent extends RecyclerView.ViewHolder {

        private TextView tv_event_title;
        private TextView tv_event_desc;
        private ImageView img_event;

        public MyViewHolderEvent(View itemView) {
            super(itemView);

            tv_event_title = (TextView) itemView.findViewById(R.id.title_event);
            tv_event_desc = (TextView) itemView.findViewById(R.id.title_event_desc);
            img_event = (ImageView) itemView.findViewById(R.id.thumbnail);
        }
    }
}
