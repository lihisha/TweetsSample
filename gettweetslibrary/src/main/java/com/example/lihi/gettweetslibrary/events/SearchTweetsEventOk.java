package com.example.lihi.gettweetslibrary.events;

import com.example.lihi.gettweetslibrary.data.Tweet;

/**
 * Created by lihi sharkanski
 */

public class SearchTweetsEventOk {

    public Tweet.TweetList tweetsList;

    public SearchTweetsEventOk(Tweet.TweetList tweets) {
        this.tweetsList = tweets;
    }

}
