package com.example.api_gateway.service;
import org.springframework.stereotype.Service;
import java.util.*;
import java.net.*;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;


@Service 
public class ProxyService {

    public final HttpClient httpClient;

    public ProxyService() {
        this.httpClient = HttpClient.newHttpClient();
    }

    public String forwardRequest(String path) throws Exception{

        String targetURL = "http://localhost:8081"+path;
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(targetURL))
                .GET()
                .build();

           HttpResponse<String> response =
                httpClient.send(
                        request,
                        HttpResponse.BodyHandlers.ofString()
                );

        return response.body();
    }

}
