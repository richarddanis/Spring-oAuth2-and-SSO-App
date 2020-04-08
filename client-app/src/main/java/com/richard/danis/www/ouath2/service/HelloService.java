package com.richard.danis.www.ouath2.service;

import com.richard.danis.www.ouath2.client.ServerSideClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import retrofit2.Response;

import java.io.IOException;
import java.util.Optional;

@Service
public class HelloService {

    private static final Logger LOGGER = LoggerFactory.getLogger(HelloService.class);
    private ServerSideClient client;

    public HelloService(ServerSideClient client) {
        this.client = client;
    }

    public Optional<String> getMessage() {
        Optional<String> optionalResult = Optional.empty();
        try {
            Response<String> execute = client.hello().execute();
            if (execute.isSuccessful()) {
                optionalResult = Optional.ofNullable(execute.body());
            } else {
                LOGGER.error("Result is not expected: {}", execute);
            }
        } catch (IOException e) {
            e.printStackTrace();
            LOGGER.error("Something went wrong: {}", e);
        }

        return optionalResult;
    }
}
