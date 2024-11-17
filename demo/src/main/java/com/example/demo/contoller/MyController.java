package com.example.demo.controller;

import com.example.demo.model.MyDocument;
import com.example.demo.service.MyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/api/mycollection")
public class MyController {

    @Autowired
    private MyService MyService;

    @GetMapping
    public List<MyDocument> getAllDocuments() {
        return MyService.getAllDocuments();
    }

    @GetMapping("/{id}")
    public MyDocument getDocumentById(@PathVariable String id) {
        return MyService.getDocumentById(id);
    }

    @PostMapping
    public MyDocument createDocument(@RequestBody MyDocument document) {
        return MyService.createDocument(document);
    }

    @PutMapping("/{id}")
    public MyDocument updateDocument(@PathVariable String id, @RequestBody MyDocument documentDetails) {
        return MyService.updateDocument(id, documentDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDocument(@PathVariable String id) {
        MyService.deleteDocument(id);
    }
}
