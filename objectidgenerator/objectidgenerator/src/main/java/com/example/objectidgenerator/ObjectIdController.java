package com.example.objectidgenerator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ObjectIdController {

    @GetMapping("/generate-objectid")
    public String generateObjectId() {
        return ObjectIdGenerator.generate();
    }
}
