package com.apaliakou.homework14;

import com.apaliakou.homework14.model.impl.httpClient.HttpClientConnection;
import com.apaliakou.homework14.model.impl.urlConnection.UrlConnection;

import java.io.File;
import java.io.IOException;

import static com.apaliakou.homework14.model.WebClient.mapper;
import static com.apaliakou.homework14.model.impl.urlConnection.UrlConnection.idScan;

public class Main {
    public static void main(String[] args) throws IOException {

        UrlConnection urlConnection = new UrlConnection();
        urlConnection.getPublicationById(idScan());
        Publication newPublication = new Publication(11L, 101L, "GOOD LUCK", "YOU ARE FOOL");

        mapper.writeValue(new File("publication.json"), newPublication);

        String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newPublication);
        System.out.println(jsonString);

        HttpClientConnection httpClientConnection = new HttpClientConnection();
        httpClientConnection.getPublicationById(idScan());
        httpClientConnection.postPublication(newPublication, jsonString);
    }
}
