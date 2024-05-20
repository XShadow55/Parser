package com.example.Parser.controller;

import com.example.Parser.model.LessonsUn;
import com.example.Parser.servise.Parser;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/get")
public class ControllerParser {
    private final Parser service;

    public ControllerParser(Parser service) {
        this.service = service;
    }

    @GetMapping
    public List<LessonsUn> findAll() {
        return service.lessons();
    }
}
