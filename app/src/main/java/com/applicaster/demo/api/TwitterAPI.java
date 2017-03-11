package com.applicaster.demo.api;

import com.applicaster.demo.model.Tweets;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Ambruster on 3/9/2017.
 */

/*Implementation patter facade. Retrofit*/
public interface TwitterAPI {

    /*Call int the API to the operation search passing the query string, 10 of amount, include entities and the popular as result_type*/
    @GET("search/tweets.json")
    Call<Tweets> searchTweets(@Query("q") String query,
                              @Query("count") String count,
                              @Query("include_entities") String include_entities,
                              @Query("result_type") String result_type);
}
