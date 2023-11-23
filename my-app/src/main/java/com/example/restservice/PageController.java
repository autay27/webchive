 
package com.example.restservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PageController {

	@GetMapping("/page")
	public Page page(@RequestParam(value = "url", defaultValue = "HelloWorld.com") String url) {
        return new Page(url, "hello world");
	}

	@GetMapping("/allpages")
	public List<Page> allpages() {
		return PageAccesser.allpages();
	}

}
