package com.example.demo.service;

import com.example.demo.entities.Universite;
import com.example.demo.repository.UniversiteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UniversiteServiceImp implements UniversiteService{

    @Autowired
    UniversiteRepository universiteRepository;


    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite upUniversite) {
        return universiteRepository.save(upUniversite);
    }

    @Override
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public Universite getUniversiteById(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }
}
