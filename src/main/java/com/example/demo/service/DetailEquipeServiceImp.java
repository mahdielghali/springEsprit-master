package com.example.demo.service;

import com.example.demo.entities.Departement;
import com.example.demo.entities.DetailEquipe;
import com.example.demo.entities.Equipe;
import com.example.demo.repository.DetailEquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DetailEquipeServiceImp implements DetailEquipeService{
    @Autowired
    DetailEquipeRepository detailEquipeRepository;

    @Override
    public List<DetailEquipe> getAllDetailEquipe(){
        return detailEquipeRepository.findAll();
    }

    @Override
    public DetailEquipe addDetailEquipe(DetailEquipe detailEquipe){
        return detailEquipeRepository.save(detailEquipe);
    }

    @Override
    public DetailEquipe updateDetailEquipe(DetailEquipe detailEquipe){
        return detailEquipeRepository.save(detailEquipe);
    }
    @Override
    public void deleteDetailEquipe(Long id){
        detailEquipeRepository.deleteById(id);
    }

    @Override
    public DetailEquipe getDetailEquipeById(Long id){
        return detailEquipeRepository.findById(id).orElse(null);
    }

    /*@Override
    public List<DetailEquipe> findByThematiqueLike(String thematique){
        return detailEquipeRepository.findByThematiqueLike(thematique);
    }*/
}
