package org.apache.dubbo.springboot.demo.consumer;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.springboot.demo.DemoService;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class TestController {
    @Reference
    private DemoService demoService;

    @RequestMapping(value = "/test/sayHello", method = RequestMethod.GET)
    String sayHello(@RequestParam("name") String name){
        MultiValueMap headers = new HttpHeaders();
        headers.add("header1", RandomStringUtils.randomAlphabetic(10));
        //HttpEntity<Object> request = new HttpEntity<>(RandomStringUtils.randomAlphabetic(10), headers);
        HttpEntity<Object> request = new HttpEntity<>(name, headers);
        String response = demoService.sayHello(name);
        return response;
    }
}
