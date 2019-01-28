package com.example.kalkausar.latihan.booking;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kalkausar.latihan.R;

import org.w3c.dom.Text;

import java.util.List;

public class BookRecyclerViewAdapter extends RecyclerView.Adapter<BookRecyclerViewAdapter.MyViewHolderBook> {

    Context mContext;
    List<dataset_book> mData;

    public BookRecyclerViewAdapter(Context mContext, List<dataset_book> mData) {
        this.mContext = mContext;
        this.mData = mData;
    }

    @NonNull
    @Override
    public MyViewHolderBook onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v;
        v=LayoutInflater.from(mContext).inflate(R.layout.item_book,parent,false);
        MyViewHolderBook vholderbook = new MyViewHolderBook(v);
        return vholderbook;
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolderBook holder, int position) {

        holder.tv_dest.setText(mData.get(position).getDestination());
        holder.tv_date.setText(mData.get(position).getDate());
        holder.img_book.setImageResource(mData.get(position).getImg());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolderBook extends RecyclerView.ViewHolder{

        private TextView tv_dest;
        private TextView tv_date;
        private ImageView img_book;

        public MyViewHolderBook(View itemView) {
            super(itemView);

            tv_dest = (TextView) itemView.findViewById(R.id.destination);
            tv_date=(TextView) itemView.findViewById(R.id.book_date);
            img_book=(ImageView)itemView.findViewById(R.id.list_avatar);
        }
    }
}
