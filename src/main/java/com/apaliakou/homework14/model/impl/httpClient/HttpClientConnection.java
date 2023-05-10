package com.apaliakou.homework14.model.impl.httpClient;

import com.apaliakou.homework14.Publication;
import com.apaliakou.homework14.model.WebClient;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.*;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;


import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

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
    public Publication postPublication(Publication newPublication, String jsonString) throws IOException {
        if (newPublication.getId() >= 101L) {
            try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
                HttpPost httpPostRequest = new HttpPost(POST_ENDPOINT);
                httpPostRequest.setEntity(new StringEntity(jsonString));
                System.out.println("Request Type: " + httpPostRequest.getMethod());
                HttpResponse httpResponse = httpClient.execute(httpPostRequest);
                System.out.println("HttpPostRequest to URL: " + httpPostRequest.getURI() +
                        "\nResponse code: " + httpResponse.getStatusLine().getStatusCode());
                System.out.println("Response Body: ");
                try (InputStream inputStream = httpResponse.getEntity().getContent()) {
                    return mapper.readValue(inputStream, Publication.class);
                }
            }
        }
        return null;
    }
}


