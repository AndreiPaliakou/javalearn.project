package com.apaliakou.homework14.model.impl.httpClient;

import com.apaliakou.homework14.Publication;
import com.apaliakou.homework14.model.WebClient;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.sun.net.httpserver.HttpHandlers;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.methods.*;
import org.apache.http.entity.EntityTemplate;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.codehaus.classworlds.uberjar.protocol.jar.Handler;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.nio.file.Path;
import java.time.Duration;

import static java.net.http.HttpResponse.BodyHandlers.ofString;
import static org.apache.http.HttpResponse.*;

public class HttpClientConnection implements WebClient {
    final CloseableHttpClient httpClient = HttpClients.createDefault(); // Creating a HttpClient object


    @Override
    public Publication getPublicationById(Long id) throws IOException {
        String urlAsString = GET_ENDPOINT.concat("/" + id);
        try {
            HttpGet getRequest = new HttpGet(urlAsString);
            System.out.println("Request Type: " + getRequest.getMethod());  // Printing the request method used
            HttpResponse httpResponse = httpClient.execute(getRequest); // Executing the HttpGet request
            return mapper.readValue(httpResponse.getEntity().getContent(), Publication.class); // The data to Publication object transformation
        } finally {
            httpClient.close();
        }
    }

    @Override
    public Publication postPublication(Publication newPublication, String jsonString) throws IOException {
        if (newPublication.getId() >= 101L) {
            try {
                HttpUriRequest httpPostRequest = RequestBuilder.post()
                        .addParameters((NameValuePair) HttpRequest.BodyPublishers.ofString(jsonString))
                        .setUri(URI.create(POST_ENDPOINT))
                        .setHeader(HttpHeaders.ACCEPT, "application/json")
                        .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
                        .build();
                System.out.println("Request Type: " + httpPostRequest.getMethod()); // Printing the request method used
                CloseableHttpResponse response = httpClient.execute(httpPostRequest);
                    System.out.println(EntityUtils.toString(response.getEntity()));
                return mapper.readValue(response.getEntity().getContent(), Publication.class);
            } finally {
                httpClient.close();
            }
        }
//            try {
//                HttpRequest httpPostRequest = HttpRequest.newBuilder() // Building a httpPostRequest object
//                        .setHeader(HttpHeaders.ACCEPT, "application/json")
//                        .setHeader(HttpHeaders.CONTENT_TYPE, "application/json")
//                        .POST(HttpRequest.BodyPublishers.ofString(jsonString))
//                        .uri(URI.create(POST_ENDPOINT))
//                        .build();
//                System.out.println("Request Type: " + httpPostRequest.method()); // Printing the request method used
//                HttpResponse httpResponse = httpClient.execute((HttpUriRequest) httpPostRequest); // Executing the HttpPost request
//                return mapper.readValue(httpResponse.getEntity().getContent(), Publication.class); // The data to Publication object transformation
//            } finally {
//                httpClient.close();
//            }
//        }
        return null;
    }
}


