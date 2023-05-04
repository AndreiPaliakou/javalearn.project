package com.apaliakou.homework14.model.impl.httpClient;

import com.apaliakou.homework14.Publication;
import com.apaliakou.homework14.model.WebClient;
import org.apache.http.HttpHeaders;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.http.HttpRequest;

public class HttpClientConnection implements WebClient {
    final CloseableHttpClient httpClient = HttpClients.createDefault(); // Creating a HttpClient object

    @Override
    public Publication getPublicationById(Long id) throws IOException {
        String uriAsString = GET_ENDPOINT.concat("/" + id);
        HttpGet httpGetRequest = new HttpGet(uriAsString); // Creating a httpGetRequest object (where to get the data)
        System.out.println("Request Type: " + httpGetRequest.getMethod());  // Printing the request method used
        try (CloseableHttpResponse httpResponse = httpClient.execute(httpGetRequest)) { // Executing the HttpGet request
            InputStream inputStream = httpResponse.getEntity().getContent(); // Response-stream transformation
            return mapper.readValue(inputStream, Publication.class); // Stream-PublicationObject transformation
        } finally {
            httpClient.close();
        }
    }

    @Override
    public Publication postPublication(Publication newPublication, String jsonString) throws IOException {
        if (newPublication.getId() >= 101L) {
            HttpRequest httpPostRequest = HttpRequest.newBuilder() // Building a httpPostRequest object
                    .header(HttpHeaders.ACCEPT, "application/json")
                    .header(HttpHeaders.CONTENT_TYPE, "application/json")
                    .uri(URI.create(POST_ENDPOINT))
                    .POST(HttpRequest.BodyPublishers.ofString(jsonString))
                    .build();
            System.out.println("Request Type: " + httpPostRequest.method()); // Printing the request method used
            try (CloseableHttpResponse httpResponse = httpClient.execute((HttpUriRequest) httpPostRequest)) { // Executing the HttpPost request
                InputStream inputStream = (InputStream) httpResponse; // Response-stream transformation
                return mapper.readValue(inputStream, Publication.class); // Stream-PublicationObject transformation
            } finally {
                httpClient.close();
            }
        }
        return null;
    }
}


