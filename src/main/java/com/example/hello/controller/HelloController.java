package com.example.hello.controller;

import com.example.hello.dao.HelloDao;
import com.example.hello.util.ServerInfo;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    private static final Logger log = LogManager.getLogger(HelloController.class);

    private final HelloDao helloDao;

    public HelloController(HelloDao helloDao) {
        this.helloDao = helloDao;
    }

        // New status endpoint
    @GetMapping("/status")
    public String status() {
        return "Service is running";
    }
    
    @GetMapping("/hello")
    public String hello() {
        String ms = ServerInfo.getManagedServerName();
        String pod = ServerInfo.getPodName();

        log.info("hello served by managedServer={}, pod={}", ms, pod);

        return "Hello from Spring MVC + Oracle DB. DB Time: "
                + helloDao.getDbTime()
                + " (handled by " + ms + " / " + pod + ")";
    }

    @GetMapping("/hellotime")
    public String helloTime() {
        long latencyMs = helloDao.getDbTimeLatencyMs();

        String ms = ServerInfo.getManagedServerName();
        String pod = ServerInfo.getPodName();

        log.info("hellotime served by managedServer={}, pod={}, dbLatencyMs={}",
                 ms, pod, latencyMs);

        return String.format(
            "DB timing info%nManagedServer=%s%nPod=%s%nDBLatencyMs=%d",
            ms, pod, latencyMs
        );
    }
}
