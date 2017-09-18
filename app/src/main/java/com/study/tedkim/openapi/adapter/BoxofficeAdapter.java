package com.study.tedkim.openapi.adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.study.tedkim.openapi.R;
import com.study.tedkim.openapi.activity.DetailActivity;
import com.study.tedkim.openapi.model.BoxofficeData;

import java.text.NumberFormat;
import java.util.ArrayList;

/**
 * Created by tedkim on 2017. 9. 18..
 */

public class BoxofficeAdapter extends RecyclerView.Adapter<BoxofficeAdapter.ViewHolder> {

    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<BoxofficeData.BoxOfficeResult.DailyBoxOfficeList> mDataset;

    public BoxofficeAdapter(Context context, ArrayList<BoxofficeData.BoxOfficeResult.DailyBoxOfficeList> dataset) {

        mContext = context;
        mDataset = dataset;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout mItemLayout;
        ImageView mThumbnail;
        TextView mRank, mTitle, mCount;

        public ViewHolder(View itemView) {
            super(itemView);

            mItemLayout = (LinearLayout) itemView.findViewById(R.id.layout_item);
            mThumbnail = (ImageView) itemView.findViewById(R.id.imageView_thumbnail);
            mRank = (TextView) itemView.findViewById(R.id.textView_rank);
            mTitle = (TextView) itemView.findViewById(R.id.textView_title);
            mCount = (TextView) itemView.findViewById(R.id.textView_audiCount);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View itemView = mLayoutInflater.inflate(R.layout.movie_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        final BoxofficeData.BoxOfficeResult.DailyBoxOfficeList data = mDataset.get(position);
        NumberFormat numberFormat = NumberFormat.getNumberInstance();

        if(data.getImgUrl() != null){
            Glide.with(mContext).load(data.getImgUrl()).into(holder.mThumbnail);
        }

        holder.mRank.setText(String.format("%s위",data.getRank()));
        holder.mTitle.setText(data.getMovieNm());
        holder.mCount.setText(String.format("%s명", numberFormat.format(Long.parseLong(data.getAudiAcc()))));
        holder.mItemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(mContext, DetailActivity.class);
                intent.putExtra("TITLE", data.getMovieNm());
                intent.putExtra("CODE", data.getMovieCd());
                intent.putExtra("POSITION", position);
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
