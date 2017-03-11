package com.applicaster.demo.api;

import com.applicaster.demo.BuildConfig;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.Credentials;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Ambruster on 3/9/2017.
 */

public class ServiceGenerator {

    private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                    .baseUrl(BuildConfig.END_POINT)
                    .addConverterFactory(GsonConverterFactory.create());

    public static <S> S createService(Class<S> serviceClass) {

        httpClient.addInterceptor(new Interceptor() {
            String token = null;
            @Override
            public Response intercept(Interceptor.Chain chain) throws IOException {
                Request original = chain.request();

                if (token == null) {
                    ResponseBody body = chain.proceed(getToken()).body();
                    try {
                        JSONObject jsonObject = new JSONObject(body.string());
                        token = "Bearer " + jsonObject.optString("access_token");
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }

                Request.Builder requestBuilder = original.newBuilder()
                        .header("Authorization", token)
                        .header("Accept", "application/json")
                        .method(original.method(), original.body());
                Request request = requestBuilder.build();
                Response response = chain.proceed(request);
                return response;
            }
        });

        httpClient.retryOnConnectionFailure(false);
        httpClient.connectTimeout(120, TimeUnit.SECONDS);
        httpClient.readTimeout(120, TimeUnit.SECONDS);

        OkHttpClient client = httpClient.build();
        Retrofit retrofit = builder.client(client).build();

        return retrofit.create(serviceClass);
    }

    private static Request getToken() {
        final String credential = Credentials.basic(BuildConfig.CONSUMER_KEY, BuildConfig.CONSUMER_SECRET);
        RequestBody requestBody = RequestBody.create(MediaType.parse("application/x-www-form-urlencoded; charset=UTF-8"), "grant_type=client_credentials");
        return new Request.Builder()
                .url(BuildConfig.AUTH_END_POINT)
                .post(requestBody)
                .header("Authorization", credential)
                .header("Content-Encoding", "gzip")
                .header("Content-type", "application/x-www-form-urlencoded;charset=UTF-8")
                .build();
    }

}
