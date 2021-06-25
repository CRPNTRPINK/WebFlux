package com.example.request.requests;


import com.example.request.DTO.PersonDTO;
import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import lombok.Data;
import org.springframework.stereotype.Component;

import java.lang.reflect.Type;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ExecutionException;

@Component
@Data
public class Requests {
    public String get(String uri) throws ExecutionException, InterruptedException {
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        return client.sendAsync(request, HttpResponse.BodyHandlers.ofString())
                .thenApply(HttpResponse::body).get();
    }

    private List<PersonDTO> getRequestGson(String getResponse){
        try {
            Type listType = new TypeToken<List<PersonDTO>>() {}.getType();
            return new Gson().fromJson(getResponse, listType);
        } catch (JsonSyntaxException e) {
            return Collections.singletonList(new Gson().fromJson(getResponse, PersonDTO.class));
        }
    }

    public List<PersonDTO> getRequest(String way) throws ExecutionException, InterruptedException {
        return getRequestGson(get("http://localhost:8080" + way));
    }

}
