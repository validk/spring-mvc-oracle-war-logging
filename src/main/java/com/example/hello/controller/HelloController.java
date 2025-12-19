package com.example.hello.controller;

import com.example.hello.dao.HelloDao;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger log =
        LogManager.getLogger(HelloController.class);

    private final HelloDao helloDao;

    public HelloController(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

    @GetMapping("/hello")
    public String hello() {
        log.info("Handling /hello request");
        return "Hello from Spring MVC + Oracle DB. DB Time: "
            + helloDao.getDbTime();
    }
}