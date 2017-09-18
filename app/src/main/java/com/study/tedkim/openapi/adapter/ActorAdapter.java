package com.study.tedkim.openapi.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.study.tedkim.openapi.R;
import com.study.tedkim.openapi.model.MovieDetail;

import java.util.ArrayList;

/**
 * Created by tedkim on 2017. 9. 18..
 */

public class ActorAdapter extends RecyclerView.Adapter<ActorAdapter.ViewHolder> {

    Context mContext;
    LayoutInflater mLayoutInflater;
    ArrayList<MovieDetail.MovieInfoResult.MovieInfo.Actors> mDataset = new ArrayList<>();

    public ActorAdapter(Context context, ArrayList<MovieDetail.MovieInfoResult.MovieInfo.Actors> dataset) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mDataset = dataset;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView mName, mAct;

        public ViewHolder(View itemView) {
            super(itemView);

            mName = (TextView) itemView.findViewById(R.id.textView_name);
            mAct = (TextView) itemView.findViewById(R.id.textView_act);
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = mLayoutInflater.inflate(R.layout.actor_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.mName.setText(mDataset.get(position).getPeopleNm());
        holder.mAct.setText(mDataset.get(position).getCast());
    }

    @Override
    public int getItemCount() {
        return mDataset.size();
    }
}
