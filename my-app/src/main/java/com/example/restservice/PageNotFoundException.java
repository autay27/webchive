 package com.example.restservice;

class PageNotFoundException extends RuntimeException {

  PageNotFoundException(String url) {
    super("Could not find your entry for " + url);
  }
}
