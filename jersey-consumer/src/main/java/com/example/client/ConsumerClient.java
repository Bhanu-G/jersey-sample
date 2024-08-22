package com.example.client;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.JerseyClientBuilder;

import jakarta.ws.rs.client.Client;
import jakarta.ws.rs.client.WebTarget;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

public class ConsumerClient {

    private static final String BASE_URL = "http://localhost:8080/jersey-producer/rest/api";

    public static void main(String[] args) {

        ClientConfig clientConfig = new ClientConfig();
        Client client = JerseyClientBuilder.createClient(clientConfig);

        WebTarget target = client.target(BASE_URL);

        Response response = target.request(MediaType.TEXT_PLAIN).get();

        if (response.getStatus() == Response.Status.OK.getStatusCode()) {
            String responseBody = response.readEntity(String.class);
            System.out.println("Response: " + responseBody);
        } else {
            System.out.println("Request failed with HTTP error code: " + response.getStatus());
        }

        response.close();
        client.close();
    }
}
