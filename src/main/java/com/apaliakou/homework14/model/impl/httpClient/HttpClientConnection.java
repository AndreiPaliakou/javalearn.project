package com.apaliakou.homework14.model.impl.httpClient;

import com.apaliakou.homework14.Publication;
import com.apaliakou.homework14.model.WebClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class HttpClientConnection implements WebClient {
    final CloseableHttpClient httpclient = HttpClients.createDefault();

    @Override
    public void getPublicationById(Long id) throws IOException {
        String urlAdressWithId = GET_ENDPOINT.concat("/" + id);
        HttpUriRequest httpGet = new HttpGet(urlAdressWithId);
        try (CloseableHttpResponse response = httpclient.execute(httpGet)) {
            String entity = response.getEntity().toString();
            System.out.println(entity);
        }
    }

    @Override
    public void postPublication(Publication newPublication, String jsonString) throws IOException {
        if (newPublication.getId() >= 101L) {
            HttpPost httpPost = new HttpPost(POST_ENDPOINT);
            CloseableHttpResponse response = httpclient.execute(httpPost);
            httpPost.setHeader("Accept", "application/json");
            httpPost.setHeader("Content-type", "application/json");
            StringEntity stringEntity = new StringEntity(jsonString);
            httpPost.setEntity(stringEntity);
            System.out.println("Executing request " + httpPost.getRequestLine());
            try (httpclient; response) {
                String entity = response.getEntity().toString();
                System.out.println(entity);
            }
        }
    }
}


