package com.example.restservice;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

interface PageRepository extends JpaRepository<Page, Long> {

      List<Page> findByUrl(String url);

}
