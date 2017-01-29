package com.example.lihi.tweetssample;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.lihi.gettweetslibrary.events.BusProvider;
import com.example.lihi.gettweetslibrary.utils.Network;
import com.example.lihi.gettweetslibrary.events.SearchTweetEvent;
import com.example.lihi.gettweetslibrary.events.SearchTweetsEventOk;
import com.example.lihi.gettweetslibrary.data.Tweet;
import com.squareup.otto.Bus;
import com.squareup.otto.Subscribe;

import java.util.ArrayList;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText termEditText;
    private Bus mBus;
    private TweetsAdapter tweetsAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        termEditText = (EditText)findViewById(R.id.search_term);
        Button searchButton = (Button) findViewById(R.id.search_button);
        searchButton.setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);

        tweetsAdapter = new TweetsAdapter(new ArrayList<Tweet>() , this);
        recyclerView.setAdapter(tweetsAdapter);
    }

    @Override
    protected void onStart() {
        super.onStart();
        getBus().register(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_button:
                Network.onGetToken(new SearchTweetEvent("",termEditText.getText().toString()) ,getBus());
                break;
        }
    }

    @Subscribe
    public void onSearchTweetsEventOk(SearchTweetsEventOk event) {
        tweetsAdapter.setItemList(event.tweetsList.getTweets());
    }

    @Override
    public void onStop() {
        super.onStop();
        getBus().unregister(this);
    }

    private Bus getBus() {
        if (mBus == null) {
            mBus = BusProvider.getInstance();
        }
        return mBus;
    }

}
