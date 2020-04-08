package com.richard.danis.www.ouath2.client;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ServerSideClient {
    @GET("/hello")
    Call<String> hello();
}
