package com.example.demo.controller;


import com.example.demo.entities.Equipe;
import com.example.demo.entities.Niveau;
import com.example.demo.service.EquipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class EquipeController {

    EquipeService equipeService;

    @GetMapping("/getEquipes")
    public List<Equipe> getAllEquipe(){
        return equipeService.getAllEquipe();
    }

    @PostMapping("/addEquipe")
    public Equipe addEquipe(@RequestBody Equipe equipe){
        return equipeService.addEquipe(equipe);
    }

    @PutMapping("/updateEquipe")
    public Equipe updateEquipe(@RequestBody Equipe updEquipe){
        return equipeService.updateEquipe(updEquipe);
    }

    @GetMapping("/getEquipeById/{id}")
    public Equipe getEquipeById(@PathVariable Long id){
        return equipeService.getEquipeById(id);
    }

    @DeleteMapping("/deleteEquipe/{id}")
    public void deleteEquipe(@PathVariable Long id){
        equipeService.deleteEquipe(id);
    }

    @GetMapping("/findEquipeByThematique/{thematique}")
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(@PathVariable("thematique") String thematique){
        return equipeService.findEquipeByDetailEquipeThematiqueLike(thematique);
    }

    @GetMapping("/findEquipeByEtudiant/{id}")
    public List<Equipe> findEquipeByEtudiantIdEtudiant(@PathVariable("id") long id){
        return equipeService.findEquipeByEtudiantIdEtudiant(id);
    }

    @GetMapping("/findEquipeIdEtudiantAndDetailEquipeThematiqueNotNull/{id}")
    public List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(@PathVariable("id") long idEtudiant){
        return equipeService.findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }


    @GetMapping("/findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart/{idEtudiant}/{idDepartement}")
    public List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(@PathVariable("idEtudiant") long idEtudiant,@PathVariable("idDepartement") long idDepartement){
        return equipeService.findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(idEtudiant,idDepartement);
    }

    @GetMapping("/retriveEquipeByNiveauAndThematique/{niveau}/{thematique}")
    public List<Equipe> retriveEquipeByNiveauAndThematique(@PathVariable("niveau") Niveau niveau,@PathVariable("thematique") String thematique) {
        return equipeService.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }

    @DeleteMapping("/deleteEquipeByNiveau")
    public void deleteEquipeByNiveau(@RequestParam("niveau") Niveau niveau) {
        equipeService.deleteEquipeByNiveau(niveau);
    }
}
