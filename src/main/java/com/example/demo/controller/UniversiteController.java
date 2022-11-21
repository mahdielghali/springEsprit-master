package com.example.demo.controller;


import com.example.demo.entities.Universite;
import com.example.demo.service.UniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@AllArgsConstructor
@RestController
public class UniversiteController {
    UniversiteService universiteService;

    @GetMapping("/getUniversites")
    public List<Universite> getAllUniversite(){
        return universiteService.getAllUniversite();
    }

    @PostMapping("/addUniversite")
    public Universite addUniversite(@RequestBody Universite universite){
        return universiteService.addUniversite(universite);
    }

    @PutMapping("/updateUniversite")
    public Universite updateUniversite(@RequestBody Universite updUniversite){
        return universiteService.updateUniversite(updUniversite);
    }

    @GetMapping("/getUniversiteById/{id}")
    public Universite getUniversiteById(@PathVariable long id){
        return universiteService.getUniversiteById(id);
    }

    @DeleteMapping("/deleteUniversite/{id}")
    public void deleteUniversite(@PathVariable long id){
        universiteService.deleteUniversite(id);
    }

    @GetMapping("/getChiffreAffaireEntreDeuxDate/{startDate}/{endDate}")
    public float getChiffreAffaireEntreDeuxDate(@PathVariable("startDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date startDate, @PathVariable("endDate") @DateTimeFormat(pattern = "yyyy-MM-dd") Date endDate){
        return universiteService.getChiffreAffaireEntreDeuxDate(startDate,endDate);
    }

}
