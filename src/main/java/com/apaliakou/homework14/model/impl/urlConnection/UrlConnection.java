package com.apaliakou.homework14.model.impl.urlConnection;

import com.apaliakou.homework14.model.WebClient;
import com.apaliakou.homework14.Publication;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.apache.http.HttpHeaders;

public class UrlConnection implements WebClient {

    private static HttpURLConnection connection;

    public static Long idScan() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the publication id: ");
        Long id;
        if (sc.hasNextLong()) {
            return id = sc.nextLong();
        } else {
            System.out.println("Long type error!!!");
            return idScan();
        }
    }

    @Override
    public void getPublicationById(Long id) throws IOException {
        String urlAdressWithId = GET_ENDPOINT.concat("/" + id);
        URL url = new URL(urlAdressWithId);
        try {
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty(HttpHeaders.ACCEPT, "application/json");
            connection.setRequestProperty(HttpHeaders.CONTENT_TYPE, "application/json");
            StringBuilder content;
//            try (BufferedReader bfR = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
//                String line;
//                content = new StringBuilder();
//                while ((line = bfR.readLine()) != null) {
//                    content.append(line);
//                    content.append(System.lineSeparator());
//                    System.out.println(line);
//                }
//                System.out.println(mapper.readValue("{ \"userId\" : \"1\", \"id\" : \"7\", \"title\" : \"dfasdf\", \"body\" : \"sdfdf\"  }", Publication.class));
//            }
            try (InputStream inputStream = connection.getInputStream()) {
                System.out.println(mapper.readValue(inputStream, Publication.class));
            }
        } finally {
            connection.disconnect();
        }
    }


    @Override
    public void postPublication(Publication newPublication, String jsonString) throws IOException {
        if (newPublication.getId() >= 101L) {
            URL url = new URL(POST_ENDPOINT);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setDoOutput(true);
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Accept", "application/json");
            try (DataOutputStream dataOutputStream = new DataOutputStream(connection.getOutputStream())) {
                dataOutputStream.writeBytes(jsonString);
            }
            try (BufferedReader bR = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
                String line;
                while ((line = bR.readLine()) != null) {
                    System.out.println(mapper.readValue(line, Publication.class));
                }

            }
        }
    }
}
