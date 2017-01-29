package com.example.lihi.gettweetslibrary.utils;


import com.example.lihi.gettweetslibrary.data.Tweet;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Query;

/**
 * Created by lihi sharkanski
 */

public interface TwitterApiService {
    @GET(ApiConstants.TWITTER_HASHTAG_SEARCH_CODE )
    Call<Tweet.TweetList> getTweetList(
            @Header("Authorization") String authorization,
            @Query("q") String hashtag
    );

    @FormUrlEncoded
    @POST("/oauth2/token")
    Call<Tweet.TwitterTokenType> getToken(
            @Header("Authorization") String authorization,
            @Field("grant_type") String grantType
    );


}
