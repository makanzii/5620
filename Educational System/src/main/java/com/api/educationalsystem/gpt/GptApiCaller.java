package com.api.educationalsystem.gpt;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.HashMap;

public class GptApiCaller {
    public static void main(String[] args){
        GptApiCaller caller = new GptApiCaller();
        caller.invokePost();
    }
    public void invokePost() {
        String apiKey = "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";
        try {
            String requestBody = prepareRequest();
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest
                    .newBuilder()
                    .header("Authorization", "Bearer " + apiKey)
                    .uri(URI.create("https://api.openai.com/v1/chat/completions"))
                    .POST(HttpRequest.BodyPublishers.ofString(requestBody))
                    .header("Accept", "application/json")
                    .header("Content-Type", "application/json")
                    .build();

            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            System.out.println(response.body());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private String prepareRequest() throws JsonProcessingException {
        var values = new HashMap<String, Object>() {
            {
                put("model", "gpt-3.5-turbo");
            }
        };
        ArrayList<HashMap<String,String>> messages = new ArrayList<>();
        HashMap<String,String> message = new HashMap<>();
        message.put("role","user");
        message.put("content","What is AWS?");
        messages.add(message);
        values.put("messages",messages);
        var objectMapper = new ObjectMapper();
        String requestBody = objectMapper.writeValueAsString(values);
        return requestBody;
    }
}
