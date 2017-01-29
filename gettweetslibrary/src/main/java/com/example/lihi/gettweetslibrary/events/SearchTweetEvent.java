package com.example.lihi.gettweetslibrary.events;

/**
 * Created by lihi sharkanski
 */

public class SearchTweetEvent {
    private   String hashtag;
    private  String twitterToken;

    public SearchTweetEvent(String twitterToken, String hashtag) {
        this.hashtag = hashtag;
        this.twitterToken = twitterToken;
    }

    public String getHashtag() {
        return hashtag;
    }

    public String getTwitterToken() {
        return twitterToken;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public void setTwitterToken(String twitterToken) {
        this.twitterToken = twitterToken;
    }
}
