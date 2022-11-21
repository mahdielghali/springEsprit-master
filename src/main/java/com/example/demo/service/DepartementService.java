package com.example.demo.service;

import com.example.demo.entities.Departement;

import com.example.demo.entities.Option;
import java.util.List;

public interface DepartementService {

    List<Departement> getAllDepartement();

    Departement addDepartement(Departement departement);

    Departement updateDepartement(Departement departement);

    void    deleteDepartement(Long id);

    Departement getDepartementById(Long id);

    List<Departement> retrieveDepartementByOptionEtudiant(Option op);

    List<Departement> retrieveDepartementsByUniversite(long idUniversite);
}
