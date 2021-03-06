package com.example.administrator.materialtest;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.util.List;

/**
 * Created by Administrator on 2019/3/15.
 */

public class StarCraftAdapter extends RecyclerView.Adapter<StarCraftAdapter.ViewHolder> {

    private Context mContext;

    private List<StarCraft> mScList;

    static class ViewHolder extends RecyclerView.ViewHolder{
        CardView cardView;
        ImageView scImg;
        TextView scName;

        public ViewHolder(View view){
            super(view);
            cardView = (CardView)view;
            scImg = (ImageView)view.findViewById(R.id.starcraft_img);
            scName = (TextView)view.findViewById(R.id.starcraft_name);
        }
    }

    public StarCraftAdapter(List<StarCraft> scList) {
        mScList = scList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (mContext == null) {
            mContext = parent.getContext();
        }
        View view = LayoutInflater.from(mContext).inflate(R.layout.starcraft_item,
                parent, false);
        final ViewHolder holder = new ViewHolder(view);
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = holder.getAdapterPosition();
                StarCraft sc = mScList.get(position);
                Intent intent = new Intent(mContext, ScActivity.class);
                intent.putExtra(ScActivity.SC_NAME, sc.getName());
                intent.putExtra(ScActivity.SC_IMAGE_ID, sc.getImageId());
                mContext.startActivity(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        StarCraft sc = mScList.get(position);
        holder.scName.setText(sc.getName());
        Glide.with(mContext).load(sc.getImageId()).into(holder.scImg);
    }

    @Override
    public int getItemCount() {
        return mScList.size();
    }
}
