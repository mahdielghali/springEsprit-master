package com.example.demo.controller;


import com.example.demo.entities.DetailEquipe;
import com.example.demo.service.DetailEquipeService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
public class DetailEquipeController {
    DetailEquipeService detailEquipeService;

    @GetMapping("/getDetailsEquipe")
    public List<DetailEquipe> getAllDetailEquipe() {
        return detailEquipeService.getAllDetailEquipe();
    }

    @PostMapping("/addDetailEquipe")
    public DetailEquipe addDetailEquipe(@RequestBody DetailEquipe detailEquipe) {
        return detailEquipeService.addDetailEquipe(detailEquipe);
    }

    @PutMapping("/updateDetailEquipe")
    public DetailEquipe updateDetailEquipe(@RequestBody DetailEquipe updDetailEquipe) {
        return detailEquipeService.updateDetailEquipe(updDetailEquipe);
    }

    @GetMapping("/getDetailEquipeById/{id}")
    public DetailEquipe getDetailEquipeById(@PathVariable Long id) {
        return detailEquipeService.getDetailEquipeById(id);
    }

    @DeleteMapping("/deleteDetailEquipe/{id}")
    public void deleteDetailEquipe(@PathVariable Long id) {
        detailEquipeService.deleteDetailEquipe(id);
    }
/*
    @GetMapping("/findbythematique/{thematique}")
    public List<DetailEquipe> findByThematiqueLike(@PathVariable String thematique) {
        return detailEquipeService.findByThematiqueLike(thematique);
    }*/
}
