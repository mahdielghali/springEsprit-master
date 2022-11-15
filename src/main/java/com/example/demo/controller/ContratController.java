package com.example.demo.controller;

import com.example.demo.entities.Contrat;
import com.example.demo.service.ContratService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class ContratController {

    ContratService contratService;

    @GetMapping("/getContrats")
    public List<Contrat> getAllContrat(){
        return contratService.getAllContrat();
    }

    @PostMapping("/addContrat")
    public Contrat addContrat( @RequestBody Contrat contrat){
        return contratService.addContrat(contrat);
    }

    @PutMapping("/updateContrat")
    public Contrat updateContrat(@RequestBody Contrat updContrat){
        return contratService.updateContrat(updContrat);
    }

    @GetMapping("/getContratById/{id}")
    public Contrat getContratById(@PathVariable("id") Integer id){
        return contratService.getContratById(id);
    }

    @DeleteMapping("/deleteContrat/{id}")
    public void deleteContrat(@PathVariable("id") Integer id){
        contratService.deleteContrat(id);
    }

    @PutMapping("/affectContratToEtudiant/{nom}/{prenom}")
    public Contrat affectContratToEtudiant (@RequestBody Contrat ce,@PathVariable("nom") String nomE,@PathVariable("prenom") String prenomE){
        return contratService.affectContratToEtudiant(ce,nomE,prenomE);
    }
}
