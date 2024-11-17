package com.example.demo.service;

import com.example.demo.model.MyDocument;
import com.example.demo.repository.MyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MyService {

    @Autowired
    private MyRepository myRepository;

    public MyService(MyRepository myRepository) {
        this.myRepository = myRepository;
    }

    public List<MyDocument> getAllDocuments() {
        return myRepository.findAll();
    }

    public MyDocument getDocumentById(String id) {
        Optional<MyDocument> document = myRepository.findById(id);
        return document.orElse(null);
    }

    public MyDocument createDocument(MyDocument document) {
        return myRepository.save(document);
    }

    public MyDocument updateDocument(String id, MyDocument documentDetails) {
        Optional<MyDocument> optionalDocument = myRepository.findById(id);
        if (optionalDocument.isPresent()) {
            MyDocument document = optionalDocument.get();
            document.setName(documentDetails.getName());
            document.setValue(documentDetails.getValue());
            return myRepository.save(document);
        } else {
            return null;
        }
    }

    public void deleteDocument(String id) {
        myRepository.deleteById(id);
    }
}
