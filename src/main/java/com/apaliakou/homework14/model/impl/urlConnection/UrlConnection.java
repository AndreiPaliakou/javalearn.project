package com.apaliakou.homework14.model.impl.urlConnection;

import com.apaliakou.homework14.model.WebClient;
import com.apaliakou.homework14.Publication;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.apache.http.HttpHeaders;

public class UrlConnection implements WebClient {

    private static HttpURLConnection httpUrlConnection;

    public static Long idScan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the publication id: ");
        if (sc.hasNextLong()) {
            return sc.nextLong();
        } else {
            System.out.println("Long type error!!!");
            return idScan();
        }
    }

    @Override
    public Publication getPublicationById(Long id) throws IOException {
        String urlAsString = GET_ENDPOINT.concat("/" + id);
        URL url = new URL(urlAsString);
        try {
            httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setRequestMethod("GET");
            httpUrlConnection.setDoOutput(true);
            httpUrlConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
            httpUrlConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            int responseCode = httpUrlConnection.getResponseCode();
            System.out.println("Request Type: " + httpUrlConnection.getRequestMethod());
            System.out.println("HttpGetRequest to URL: " + url + "\nResponse code: " + responseCode);
            System.out.println("Response Body: ");
            InputStream inputStream = httpUrlConnection.getInputStream();
            return mapper.readValue(inputStream, Publication.class);
        } finally {
            httpUrlConnection.disconnect();
        }
    }


    @Override
    public Publication postPublication(Publication newPublication, String jsonString) throws IOException {
        if (newPublication.getId() >= 101L) {
            URL url = new URL(POST_ENDPOINT);
            httpUrlConnection = (HttpURLConnection) url.openConnection();
            httpUrlConnection.setRequestMethod("POST");
            httpUrlConnection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
            httpUrlConnection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            httpUrlConnection.setDoOutput(true);
            System.out.println("Request Type: " + httpUrlConnection.getRequestMethod());
            try (DataOutputStream dataOutputStream = new DataOutputStream(httpUrlConnection.getOutputStream())) {
                dataOutputStream.writeBytes(jsonString);
                dataOutputStream.flush();
                dataOutputStream.close();
                int responseCode = httpUrlConnection.getResponseCode();
                System.out.println("HttpPostRequest to URL : " + url + "\nResponse code : " + responseCode);
                System.out.println("Response Body : ");
                try (InputStream inputStream = httpUrlConnection.getInputStream()) {
                    return mapper.readValue(inputStream, Publication.class);
                }
            } finally {
                httpUrlConnection.disconnect();
            }
        }
        return null;
    }
}
