package com.richard.danis.www.ouath2.init;

import com.richard.danis.www.ouath2.client.ServerSideClient;
import okhttp3.OkHttpClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;

import java.util.concurrent.TimeUnit;

@Configuration
public class RetrofitConfiguration {

    @Bean
    public ServerSideClient client(@Value("${client.host}") String url,
                                   @Value("${client.timeout}") Integer timeout) {
        return new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(url)
                .client(httpClientBuilder(timeout).build())
                .build()
                .create(ServerSideClient.class);
    }

    private OkHttpClient.Builder httpClientBuilder(final Integer timeout) {
        return new OkHttpClient.Builder()
                .connectTimeout(timeout, TimeUnit.MILLISECONDS)
                .readTimeout(timeout, TimeUnit.MILLISECONDS);
    }
}
