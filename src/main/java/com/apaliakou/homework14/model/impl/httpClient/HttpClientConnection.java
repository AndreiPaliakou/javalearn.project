package com.apaliakou.homework14.model.impl.httpClient;

import com.apaliakou.homework14.Publication;
import com.apaliakou.homework14.model.WebClient;
import com.sun.net.httpserver.HttpHandlers;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.codehaus.classworlds.uberjar.protocol.jar.Handler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.time.Duration;

import static java.net.http.HttpResponse.BodyHandlers.ofString;
import static org.apache.http.HttpResponse.*;

public class HttpClientConnection implements WebClient {
    final CloseableHttpClient httpClient = HttpClients.createDefault(); // Creating a HttpClient object


    @Override
    public Publication getPublicationById(Long id) throws IOException {
        String urlAsString = GET_ENDPOINT.concat("/" + id);
        try {
            HttpRequest httpGetRequest = HttpRequest.newBuilder() // Creating a httpGetRequest object (where to get the data)
                    .GET()
                    .header(HttpHeaders.ACCEPT, "application/json")
                    .header(HttpHeaders.CONTENT_TYPE, "application/json")
                    .uri(URI.create(urlAsString))
                    .build();
            System.out.println("Request Type: " + httpGetRequest.method());  // Printing the request method used
            HttpClient client = HttpClient.newHttpClient();
            HttpResponse httpResponse = (HttpResponse) client.send(httpGetRequest, java.net.http.HttpResponse.BodyHandlers.ofString());
            // Executing the HttpGet request
            InputStream inputStream = httpResponse.getEntity().getContent(); // Response-stream transformation
            return mapper.readValue(inputStream, Publication.class); // Stream-PublicationObject transformation
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            httpClient.close();
        }
    }

    @Override
    public Publication postPublication(Publication newPublication, String jsonString) throws IOException {
        if (newPublication.getId() >= 101L) {
            try {
                HttpRequest httpPostRequest = HttpRequest.newBuilder() // Building a httpPostRequest object
                        .header(HttpHeaders.ACCEPT, "application/json")
                        .header(HttpHeaders.CONTENT_TYPE, "application/json")
                        .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                        .uri(URI.create(POST_ENDPOINT))
                        .build();
                System.out.println("Request Type: " + httpPostRequest.method()); // Printing the request method used
                HttpResponse httpResponse = httpClient.execute((HttpUriRequest) httpPostRequest);
                InputStream inputStream = (InputStream) httpResponse;
                return mapper.readValue(inputStream, Publication.class); // Stream-PublicationObject transformation
            } finally {
                httpClient.close();
            }
        }
        return null;
    }
}


