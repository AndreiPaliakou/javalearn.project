package com.apaliakou.homework14.model.impl.urlConnection;

import com.apaliakou.homework14.model.WebClient;
import com.apaliakou.homework14.exceptions.PublicationIdException;
import com.apaliakou.homework14.Publication;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class UrlConnection implements WebClient {

    String PUBLICATION_ID_EXCEPTION = "This publication id already exists!!! Try again!!!";

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
    public void getPublicationById(Long id) {
        String urlAdressWithId = GET_ENDPOINT.concat("/" + id);
        URLConnection urlConnection = null;
        URL url = null;
        InputStreamReader isR = null;
        BufferedReader bfR = null;
        try {
            url = new URL(urlAdressWithId);
            urlConnection = url.openConnection();
            isR = new InputStreamReader(urlConnection.getInputStream());
            bfR = new BufferedReader(isR);
            String line;
            while ((line = bfR.readLine()) != null)
                System.out.println(line);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                assert isR != null;
                isR.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                assert bfR != null;
                bfR.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void postPublication(Publication newPublication, String jsonString) throws IOException {
        if (newPublication.getId() >= 101L) {
            URL url = new URL(POST_ENDPOINT);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setRequestProperty("Content-Type", "application/json");
            con.setRequestProperty("Accept", "application/json");
            con.setDoOutput(true);
            try (OutputStream os = con.getOutputStream()) {
                byte[] input = jsonString.getBytes(StandardCharsets.UTF_8);
                os.write(input, 0, input.length);
            }
            try (BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(), StandardCharsets.UTF_8))) {
                StringBuilder response = new StringBuilder();
                String responseLine = null;
                while ((responseLine = br.readLine()) != null) {
                    response.append(responseLine.trim());
                }
                System.out.println(response);
            }
        } else {
            throw new PublicationIdException(PUBLICATION_ID_EXCEPTION);
        }
    }
}
