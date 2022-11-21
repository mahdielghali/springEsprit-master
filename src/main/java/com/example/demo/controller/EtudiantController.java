package com.example.demo.controller;

import com.example.demo.entities.Equipe;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Option;
import com.example.demo.service.EtudiantService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class EtudiantController {
    EtudiantService etudiantService;

    @GetMapping("/getEtudiants")
    public List<Etudiant> getAllEtudiant(){
        return etudiantService.getAllEtudiant();
    }

    @PostMapping("/addEtudiant")
    public Etudiant addEtudiant(@RequestBody Etudiant etudiant){
        return etudiantService.addEtudiant(etudiant);
    }

    @PutMapping("/updateEtudiant")
    public Etudiant updateEtudiant(@RequestBody Etudiant updEtudiant){
        return etudiantService.updateEtudiant(updEtudiant);
    }

    @GetMapping("/getEtudiantById/{id}")
    public Etudiant getEtudiantById(@PathVariable("id") Long id){
        return etudiantService.getEtudiantById(id);
    }

    @DeleteMapping("/deleteEtudiant/{id}")
    public void deleteEtudiant(@PathVariable("id") Long id){
        etudiantService.deleteEtudiant(id);
    }

    @GetMapping("/findEtudiantByPrenomE/{prenomE}")
    public Etudiant findEtudiantByPrenomE(@PathVariable("prenomE") String prenomE){
        return etudiantService.findEtudiantByPrenomE(prenomE);
    }

    @GetMapping("/retrieveEtudiantByEquipeThematique/{thematique}")
    public List<Etudiant> retrieveEtudiantByEquipeThematique(@PathVariable("thematique") String thematique) {
        return etudiantService.retrieveEtudiantByEquipeThematique(thematique);
    }

    @PutMapping("/updateEtudiantByOption")
    public void updateEtudiantByOption(@RequestParam("op") Option op,@RequestParam("idEtudiant") long idEtudiant) {
        etudiantService.updateEtudiantByOption(op,idEtudiant);
    }

    @PutMapping("/assignEtudiantToDepartment/{idEtudiant}/{idDepartment}")
    public void assignEtudiantToDepartment(@PathVariable("idEtudiant") long idEtudiant,@PathVariable("idDepartment") long idDepartment){
        etudiantService.assignEtudiantToDepartment(idEtudiant,idDepartment);
    }

    @PutMapping("/addAndAssignEtudiantToEquipeAndContract/{idContrat}/{idEquipe}")
    Etudiant addAndAssignEtudiantToEquipeAndContract(@RequestBody Etudiant e,@PathVariable("idContrat") Integer idContrat,@PathVariable("idEquipe") long idEquipe){
        return etudiantService.addAndAssignEtudiantToEquipeAndContract(e,idContrat,idEquipe);
    }

    @GetMapping("/findEtudiantByNomEAndPrenomE/{nom}/{prenom}")
    public Etudiant findEtudiantByNomEAndPrenomE(@PathVariable("nom") String nomE,@PathVariable("prenom") String prenomE){
        return etudiantService.findEtudiantByNomEAndPrenomE(nomE,prenomE);
    }

    @GetMapping("/getEtudiantsByDepartement/{idDepartement}")
    public List<Etudiant> getEtudiantsByDepartement(@PathVariable("idDepartement") long idDepartement){
        return etudiantService.getEtudiantsByDepartement(idDepartement);
    }
}
