 
package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.ArrayList;

@RestController
public class PageController {

  private static final Logger log = 	LoggerFactory.getLogger(LoadDatabase.class);


    private final PageRepository repository;

	PageController(PageRepository repository) {
		this.repository = repository;
	}

	@GetMapping("/page/{url}")
	public List<Page> page(@PathVariable String url) {

		private List<Page> found = repository.findByUrl(url)
		if ( found.isEmpty() ) {
			throw new PageNotFoundException(url);
		}
		return found;

	}

	@GetMapping("/allpages")
	public List<Page> allpages() {
		return repository.findAll();
    }

}
