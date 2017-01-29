package com.example.lihi.gettweetslibrary.utils;

import android.util.Base64;

import com.example.lihi.gettweetslibrary.data.Tweet;
import com.example.lihi.gettweetslibrary.events.SearchTweetEvent;
import com.example.lihi.gettweetslibrary.events.SearchTweetsEventOk;
import com.squareup.otto.Bus;

import java.io.UnsupportedEncodingException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by lihi sharkanski
 */

public class Network {


    public static void getTweets(final SearchTweetEvent event, final Bus mBus){

        Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiConstants.TWITTER_SEARCH_URL).addConverterFactory(GsonConverterFactory.create()).build();
        TwitterApiService twitterApiService = retrofit.create(TwitterApiService.class);
        Call<Tweet.TweetList> call = twitterApiService.getTweetList("Bearer " + event.getTwitterToken(), event.getHashtag());
        call.enqueue(new Callback<Tweet.TweetList>() {
            @Override
            public void onResponse(Call<Tweet.TweetList> call, Response<Tweet.TweetList> response) {
                mBus.post(new SearchTweetsEventOk(response.body()));
            }

            @Override
            public void onFailure(Call<Tweet.TweetList> call, Throwable t) {
            }

        });
    }

    public static String getBase64String(String value) throws UnsupportedEncodingException {
        return Base64.encodeToString(value.getBytes("UTF-8"), Base64.NO_WRAP);
    }

    public static void onGetToken(final SearchTweetEvent event , final Bus mBus) {
        try {
            Retrofit retrofit = new Retrofit.Builder().baseUrl(ApiConstants.TWITTER_SEARCH_URL).addConverterFactory(GsonConverterFactory.create()).build();

            TwitterApiService twitterApiService = retrofit.create(TwitterApiService.class);
            Call<Tweet.TwitterTokenType> call = twitterApiService.getToken("Basic " + getBase64String(ApiConstants.BEARER_TOKEN_CREDENTIALS), "client_credentials");
            call.enqueue(new Callback<Tweet.TwitterTokenType>() {
                @Override
                public void onResponse(Call<Tweet.TwitterTokenType> call, Response<Tweet.TwitterTokenType> response) {
                    event.setTwitterToken(response.body().getAccessToken());
                    getTweets(event ,mBus);
                }

                @Override
                public void onFailure(Call<Tweet.TwitterTokenType> call, Throwable t) {
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
