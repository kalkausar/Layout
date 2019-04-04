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

import com.example.kalkausar.latihan.CarActivity;
import com.example.kalkausar.latihan.EventActivity;
import com.example.kalkausar.latihan.FerryActivity;
import com.example.kalkausar.latihan.FlightActivity;
import com.example.kalkausar.latihan.HotelActivity;
import com.example.kalkausar.latihan.R;
import com.example.kalkausar.latihan.WisataActivity;
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
                Intent intent = new Intent();
                switch (position) {
                    case 0:
                        intent = new Intent(context, FlightActivity.class);
                        break;
                    case 1:
                        intent = new Intent(context, HotelActivity.class);
                        break;
                    case 2:
                        intent = new Intent(context, WisataActivity.class);
                        break;
                    case 3:
                        intent = new Intent(context, CarActivity.class);
                        break;
                    case 4:
                        intent = new Intent(context, FerryActivity.class);
                        break;
                    case 5:
                        intent = new Intent(context, EventActivity.class);
                        break;
                }
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