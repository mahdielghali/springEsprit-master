package com.example.demo.service;

import com.example.demo.entities.Universite;

import java.util.List;

public interface UniversiteService {

    List<Universite> getAllUniversite();
    Universite addUniversite(Universite Universite);
    Universite updateUniversite(Universite upUniversite);
    void deleteUniversite(Long id);
    Universite getUniversiteById(Long id);
}
