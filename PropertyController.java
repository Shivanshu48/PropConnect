package com.propconnect.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.*;

@RestController
@RequestMapping("/properties")
public class PropertyController {

    private final List<Map<String, String>> properties = new ArrayList<>();

    @PostMapping("/uploadProperty")
    public String uploadProperty(
            @RequestParam("ownerName") String ownerName,
            @RequestParam("propertyAddress") String propertyAddress,
            @RequestParam("leasePaper") MultipartFile leasePaper,
            @RequestParam("propertyImages") MultipartFile[] propertyImages) {

        Map<String, String> property = new HashMap<>();
        property.put("ownerName", ownerName);
        property.put("propertyAddress", propertyAddress);
        property.put("leasePaper", leasePaper.getOriginalFilename());
        property.put("imagesCount", String.valueOf(propertyImages.length));

        properties.add(property);
        return "Property uploaded successfully!";
    }

    @GetMapping("/list")
    public List<Map<String, String>> listProperties() {
        return properties;
    }
}
