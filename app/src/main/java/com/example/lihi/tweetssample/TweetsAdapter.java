package com.example.lihi.tweetssample;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lihi.gettweetslibrary.data.Tweet;

import java.util.List;

public class TweetsAdapter extends RecyclerView.Adapter<TweetsAdapter.MyViewHolder> {

    private final Context context;
    private List<Tweet> tweetList;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView screenName, content;
        public ImageView profileImage;

        public MyViewHolder(View view) {
            super(view);
            screenName = (TextView) view.findViewById(R.id.screen_name);
            content = (TextView) view.findViewById(R.id.content);
            profileImage = (ImageView)view.findViewById(R.id.profile_image);
        }
    }


    public TweetsAdapter(List<Tweet> tweetList , Context context) {
        this.tweetList = tweetList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_tweet, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        Tweet tweet = tweetList.get(position);
        holder.screenName.setText(tweet.getUser().getScreenName());
        holder.content.setText(tweet.getText());
        Glide.with(context)
                .load(tweet.getUser().getProfileImageUrl())
                .into(holder.profileImage);
    }

    @Override
    public int getItemCount() {
        return (tweetList == null) ? 0 : tweetList.size();
    }

    public void setItemList(List<Tweet> itemList){
        this.tweetList.clear();
        this.tweetList.addAll(itemList);
        notifyDataSetChanged();
    }
}
