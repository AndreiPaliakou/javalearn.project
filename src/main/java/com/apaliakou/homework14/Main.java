package com.apaliakou.homework14;

import com.apaliakou.homework14.model.impl.urlConnection.UrlConnection;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;

import static com.apaliakou.homework14.model.impl.urlConnection.UrlConnection.idScan;

public class Main {
    public static void main(String[] args) {
        UrlConnection object = new UrlConnection();
        object.getPublicationById(idScan());

        Publication newPublication = new Publication(11L, 101L, "GOOD LUCK", "YOU ARE FOOL");
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("publication.json"), newPublication);
            String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(newPublication);
            System.out.println(jsonString);
            object.postPublication(newPublication, jsonString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
