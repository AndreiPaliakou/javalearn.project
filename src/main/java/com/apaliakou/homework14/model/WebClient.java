package com.apaliakou.homework14.model;

import com.apaliakou.homework14.Publication;

import java.io.IOException;

public interface WebClient {
    String GET_ENDPOINT = "http://jsonplaceholder.typicode.com/posts/";
    String POST_ENDPOINT = "http://jsonplaceholder.typicode.com/posts";

    public void getPublicationById(Long id);

    public void postPublication(Publication newPublication, String jsonString) throws IOException;
}
