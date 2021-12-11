package com.logvuln.Log4jShell.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


// Vulnerable lib
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.servlet.http.HttpServletRequest;


@RestController("/api/")
public class VulnerableController {

    // logger
    private static final Logger log = LogManager.getLogger(VulnerableController.class.getName());

    private HttpServletRequest request;

    public VulnerableController(HttpServletRequest request) {
        this.request = request;
    }

    @GetMapping("/hello/{name}")
    public ResponseEntity<String> hello(@PathVariable String name) {

        log.info("User-Agent: {}", request.getHeader("User-Agent"));
        return new ResponseEntity<>( String.format("Hello, %s!", name), HttpStatus.OK );

    }


}
