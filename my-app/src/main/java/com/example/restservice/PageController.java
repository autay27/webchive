 
package com.example.restservice;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PageController {

	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/page")
	public Page page(@RequestParam(value = "url", defaultValue = "HelloWorld.com") String url) {
        return new Page(counter.incrementAndGet(), url);
	}
}
