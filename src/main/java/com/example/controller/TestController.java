package com.example.controller;

import com.example.service.FileService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDateTime;

@Slf4j
@Controller
@RequiredArgsConstructor
public class TestController {

    private final FileService fileService;

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody String body) {
        String response = fileService.realFromFile("login.json");
        return new ResponseEntity<>(response, createHeader(), HttpStatus.CREATED);
    }

    @GetMapping("/api/v2/document-hub/derivative")
    public ResponseEntity<String> derivative(@RequestParam(name = "dateFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime dateFrom,
                                      @RequestParam(name = "dateTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime dateTo,
                                      Pageable pageable) throws InterruptedException {

        Thread.sleep(5000L);

        String response = fileService.realFromFile("contracts-derivative.json");
        return new ResponseEntity<>(response, createHeader(), HttpStatus.OK);
    }

    @GetMapping("/api/v1/document-hub/valuation-specialist-leader/imports")
    public ResponseEntity<String> imports(@RequestParam(name = "dateFrom", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime dateFrom,
                                      @RequestParam(name = "dateTo", required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME)  LocalDateTime dateTo,
                                      Pageable pageable) throws InterruptedException {
        Thread.sleep(5000L);
        String response = fileService.realFromFile("contracts-imports.json");
        return new ResponseEntity<>(response, createHeader(), HttpStatus.OK);
    }

    @PutMapping("/api/v2/document-hub/review/document/{contractId}/content/review")
    public ResponseEntity<String> review (@PathVariable(name = "contractId") String contractId,
                                          @RequestBody String body) {
        log.info("Contact review id = {}", contractId);
        String response = fileService.realFromFile("response-ok.json");
        return new ResponseEntity<>(response, createHeader(), HttpStatus.OK);
    }

    @PutMapping("/api/v2/document-hub/review/document/{contractId}/content/approve")
    public ResponseEntity<String> approve (@PathVariable(name = "contractId") String contractId) {
        log.info("Contact approve id = {}", contractId);
        return new ResponseEntity<>(createHeader(), HttpStatus.OK);
    }

    private HttpHeaders createHeader() {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        return headers;
    }
}
