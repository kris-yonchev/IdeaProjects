package com.example.demo.services;

import com.example.demo.entities.Part;

import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.List;


public interface PartService {

    void seedData() throws IOException, JAXBException;

    List<Part> getRandomParts();
}
