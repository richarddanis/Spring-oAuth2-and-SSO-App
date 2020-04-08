package com.richard.danis.www.ouath2.init;

import okhttp3.OkHttpClient;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.jackson.JacksonConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
public class RetrofitConfiguration {

    private Retrofit buildRetrofit(String url, Integer timeout) {
        return new Retrofit.Builder()
                .addConverterFactory(JacksonConverterFactory.create())
                .baseUrl(url)
                .client(httpClientBuilder(timeout).build())
                .build();
    }

    private OkHttpClient.Builder httpClientBuilder(final Integer timeout) {
        return new OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.MILLISECONDS)
                .readTimeout(timeout, TimeUnit.MILLISECONDS);
    }
}
