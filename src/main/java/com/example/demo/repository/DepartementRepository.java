package com.example.demo.repository;

import com.example.demo.entities.Departement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import com.example.demo.entities.Option;

/*
enum Option {
    GAMIX,SE,SIM,NIDS}*/
@Repository
public interface DepartementRepository extends JpaRepository<Departement,Long> {


    @Query("SELECT dp FROM Departement dp , Etudiant et WHERE et.departement.idDepart = dp.idDepart AND et.opt = :op ")
    List<Departement> retrieveDepartementByOptionEtudiant(Option op);
}
