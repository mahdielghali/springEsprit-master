package com.example.demo.service;

import com.example.demo.entities.DetailEquipe;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetailEquipeService {

    List<DetailEquipe> getAllDetailEquipe();

    DetailEquipe addDetailEquipe(DetailEquipe detailEquipe);

    DetailEquipe updateDetailEquipe(DetailEquipe detailEquipe);

    void deleteDetailEquipe(Long id);

    DetailEquipe getDetailEquipeById(Long id);

    /*List<DetailEquipe> findByThematiqueLike(String thematique);*/
}
