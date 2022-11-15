package com.example.demo.controller;

import com.example.demo.entities.Departement;
import com.example.demo.service.DepartementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.entities.Option;
import java.util.List;

@AllArgsConstructor
@RestController
public class DepartementController {

    DepartementService departementService;

    @GetMapping("/getDepartements")
    public List<Departement> getAllDepartement(){
        return departementService.getAllDepartement();
    }

    @PostMapping("/addDepartement")
    public Departement addDepartement(@RequestBody Departement departement){
        return departementService.addDepartement(departement);
    }

    @PutMapping("/updateDepartement")
    public Departement updateDepartement(@RequestBody Departement updDepartement){
        return departementService.updateDepartement(updDepartement);
    }

    @GetMapping("/getDepartementById/{id}")
    public Departement getDepartementById(@PathVariable Long id){
        return departementService.getDepartementById(id);
    }

    @DeleteMapping("/deleteDepartement/{id}")
    public void deleteDepartement(@PathVariable Long id){
        departementService.deleteDepartement(id);
    }

    @GetMapping("/retrieveDepartementByOptionEtudiant/{op}")
    public List<Departement> retrieveDepartementByOptionEtudiant(@PathVariable("op") Option op) {
        return departementService.retrieveDepartementByOptionEtudiant(op);
    }
}
