package com.applicaster.demo.api.task;

import com.applicaster.demo.api.IResponseObject;
import com.applicaster.demo.api.ServiceGenerator;
import com.applicaster.demo.api.TwitterAPI;
import com.applicaster.demo.model.Tweets;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Ambruster on 3/9/2017.
 * Helper class for make the call to the API
 */

public class TwitterTask {

    private TwitterAPI api = null;
    private static int DEFAULT_COUNT = 10;
    public IResponseObject<Object> callBack;

    public TwitterTask(IResponseObject callBack) {
        this.callBack = callBack;
    }

    public void Search(String hashtag) {

        /**
        *Get the API instance
        */

        api = ServiceGenerator.createService(TwitterAPI.class);

         /**
         *Call the service, including Entities and based on most (Pupular Tweets, here we can put Recent or Mixed)
         */

        Call<Tweets> call = api.searchTweets(hashtag, String.valueOf(DEFAULT_COUNT), "true", "popular");
        call.enqueue(new Callback<Tweets>() {
            @Override
            public void onResponse(Call<Tweets> call, Response<Tweets> response) {

                try {
                    switch (response.code()) {
                        case 401:
                            /**
                             *We can do some stuff
                             */
                            callBack.onError(response.message(), response.code());
                            break;

                        case 200:
                            /**
                             *We return in callback the response of the API
                             */
                            callBack.onResponse(response.body());
                            break;

                        case 500:
                            /**
                             *We can do some stuff
                             */
                            callBack.onError(response.message(), response.code());
                            break;

                        default:
                            /**
                             *We can do some stuff
                             */
                            callBack.onError(response.message(), response.code());
                            break;
                    }
                } catch (Exception ex) {
                    callBack.onError(ex.toString(), response.code());
                }
            }

            @Override
            public void onFailure(Call<Tweets> call, Throwable t) {
                /**
                 *We can do some stuff
                 */
                callBack.onError(t.toString(), 500);
            }
        });
    }

}
