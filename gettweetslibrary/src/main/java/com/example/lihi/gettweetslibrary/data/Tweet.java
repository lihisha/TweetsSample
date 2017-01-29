package com.example.lihi.gettweetslibrary.data;


import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by lihi sharkanski
 */

public class Tweet {

    @SerializedName("created_at")
    private String dateCreated;

    @SerializedName("id")
    public String id;

    @SerializedName("text")
    public String text;

    @SerializedName("in_reply_to_status_id")
    private String inReplyToStatusId;

    @SerializedName("in_reply_to_user_id")
    private String inReplyToUserId;

    @SerializedName("in_reply_to_screen_name")
    private String inReplyToScreenName;

    @SerializedName("user")
    private TwitterUser user;

    @Override
    public String toString() {
        return text;
    }

    public class TweetList  {

        @SerializedName("statuses")
        private ArrayList<Tweet> tweets;

        public ArrayList<Tweet> getTweets() {
            return tweets;
        }
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public TwitterUser getUser() {
        return user;
    }

    public String getInReplyToScreenName() {
        return inReplyToScreenName;
    }

    public String getInReplyToUserId() {
        return inReplyToUserId;
    }

    public String getInReplyToStatusId() {
        return inReplyToStatusId;
    }

    public String getText() {
        return text;
    }

    public String getId() {
        return id;
    }

    public class TwitterUser {

        @SerializedName("screen_name")
        private String screenName;

        @SerializedName("name")
        private String name;

        @SerializedName("profile_image_url")
        private String profileImageUrl;

        public String getScreenName() {
            return screenName;
        }

        public String getName() {
            return name;
        }

        public String getProfileImageUrl() {
            return profileImageUrl;
        }
    }

    public class TwitterTokenType {

        @SerializedName("token_type")
        private String tokenType;

        @SerializedName("access_token")
        private String accessToken;

        public String getTokenType() {
            return tokenType;
        }

        public String getAccessToken() {
            return accessToken;
        }
    }


}