package com.propconnect.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/urbanclap")
public class UrbanClapController {

    @PostMapping("/requestCleaning")
    public String requestCleaning(@RequestBody Map<String, String> request) {
        return "Cleaning package requested: " + request.get("packageType") + " for " + request.get("ledgerName");
    }
}
