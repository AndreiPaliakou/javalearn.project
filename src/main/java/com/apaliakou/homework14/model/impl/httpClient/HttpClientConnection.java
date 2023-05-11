package com.apaliakou.homework14.model.impl.httpClient;

import com.apaliakou.homework14.Publication;
import com.apaliakou.homework14.model.WebClient;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


import java.io.IOException;

public class HttpClientConnection implements WebClient {


    @Override
    public Publication getPublicationById(Long id) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            String urlAsString = GET_ENDPOINT.concat("/" + id);
            HttpGet httpGetRequest = new HttpGet(urlAsString);
            System.out.println("Request Type: " + httpGetRequest.getMethod());
            HttpResponse httpResponse = httpClient.execute(httpGetRequest);
            System.out.println("HttpGetRequest to URL: " + httpGetRequest.getURI() +
                    "\nResponse code: " + httpResponse.getStatusLine().getStatusCode());
            System.out.println("Response Body: ");
            return mapper.readValue(httpResponse.getEntity().getContent(), Publication.class);
        }
    }

    @Override
    public Publication postPublication(String jsonString) throws IOException {
        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPostRequest = new HttpPost(POST_ENDPOINT);
            httpPostRequest.setEntity(new StringEntity(jsonString));
            httpPostRequest.setHeader(HttpHeaders.CONTENT_TYPE, "application/json");
            System.out.println("Request Type: " + httpPostRequest.getMethod());
            try (CloseableHttpResponse httpResponse = httpClient.execute(httpPostRequest)) {
                System.out.println("HttpPostRequest to URL: " + httpPostRequest.getURI() +
                        "\nResponse code: " + httpResponse.getStatusLine().getStatusCode());
                System.out.println("Response Body: ");
                return mapper.readValue(httpResponse.getEntity().getContent(), Publication.class);
            }
        }
    }
}


