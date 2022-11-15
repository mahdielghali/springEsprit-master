package com.example.demo.service;

import com.example.demo.entities.Departement;
import com.example.demo.repository.DepartementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entities.Option;
import java.util.List;

@Service
public class DepartementServiceImp implements DepartementService{

    @Autowired
    DepartementRepository departementRepository;

    @Override
    public List<Departement> getAllDepartement(){
        return departementRepository.findAll();
    }

    @Override
    public Departement addDepartement(Departement departement){
        return departementRepository.save(departement);
    }

    @Override
    public Departement updateDepartement(Departement departement){
        return departementRepository.save(departement);
    }

    @Override
    public void deleteDepartement(Long id){
        departementRepository.deleteById(id);
    }

    @Override
    public Departement getDepartementById(Long id){
        return departementRepository.findById(id).orElse(null);
    }

    @Override
    public List<Departement> retrieveDepartementByOptionEtudiant(Option op) {
        return departementRepository.retrieveDepartementByOptionEtudiant(op);
    }


}
