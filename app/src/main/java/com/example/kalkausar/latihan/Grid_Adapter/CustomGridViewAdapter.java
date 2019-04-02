package com.example.kalkausar.latihan.Grid_Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.kalkausar.latihan.DetailActivity;
import com.example.kalkausar.latihan.R;
import com.example.kalkausar.latihan.model.grid_menu;

import java.util.List;


public class CustomGridViewAdapter extends RecyclerView.Adapter<GridViewHolder> {
    private Context context;
    private List<grid_menu> gridList;

    //deklarasi Context


    public CustomGridViewAdapter(Context context, List<grid_menu> gridList) {
        this.context = context;
        this.gridList = gridList;
    }

    @Override
    public void onBindViewHolder(final GridViewHolder holder, final int position) {
        holder.mImage.setImageResource(gridList.get(position).getMenuImage());
        holder.mTitle.setText(gridList.get(position).getMenuName());

        holder.mparentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("Title", gridList.get(position).getMenuName());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public GridViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View mView = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_item_grid_menu, parent, false);
        return new GridViewHolder(mView);
    }

    @Override
    public int getItemCount() {
        return gridList.size();
    }
}

class GridViewHolder extends RecyclerView.ViewHolder {

    ImageView mImage;
    TextView mTitle;
    LinearLayout mparentLayout;

    GridViewHolder(View itemView) {
        super(itemView);

        mImage = itemView.findViewById(R.id.imageView);
        mTitle = itemView.findViewById(R.id.text_view_name_menu);
        mparentLayout = itemView.findViewById(R.id.parentLayout);
    }
}