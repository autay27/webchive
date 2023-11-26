package com.example.restservice;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
class Page {

    private @Id @GeneratedValue Long id;
    private String url;
    private String metadata;

    Page() {}

    Page(String url, String metadata) {

        this.url = url;
        this.metadata = metadata;
    }
}
