package com.example.demo.controller;


import com.example.demo.entities.Universite;
import com.example.demo.service.UniversiteService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
    public Universite getUniversiteById(@PathVariable Long id){
        return universiteService.getUniversiteById(id);
    }

    @DeleteMapping("/deleteUniversite/{id}")
    public void deleteUniversite(@PathVariable Long id){
        universiteService.deleteUniversite(id);
    }
}
