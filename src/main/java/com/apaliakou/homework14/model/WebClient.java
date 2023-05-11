package com.apaliakou.homework14.model;

import com.apaliakou.homework14.Publication;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;


public interface WebClient {
    String GET_ENDPOINT = "http://jsonplaceholder.typicode.com/posts/";
    String POST_ENDPOINT = "http://jsonplaceholder.typicode.com/posts";

    ObjectMapper mapper = new ObjectMapper();

    Publication getPublicationById(Long id) throws IOException;

    Publication postPublication(String jsonString) throws IOException;
}
