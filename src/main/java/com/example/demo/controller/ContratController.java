package com.example.demo.controller;

import com.example.demo.entities.Contrat;
import com.example.demo.service.ContratService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
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

    @GetMapping("/getContratBetweenDates/{startDate}/{endDate}")
    public List<Contrat> getContratBetweenDates(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate,@PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return contratService.getContratBetweenDates(startDate,endDate);
    }

    @GetMapping("/findNbContratByDatesAndArchives/{startDate}/{endDate}")
    public Integer findNbContratByDatesAndArchives(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date dateDebut,@PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd")  Date dateFin){
        return contratService.findNbContratByDatesAndArchives(dateDebut,dateFin);
    }


}
