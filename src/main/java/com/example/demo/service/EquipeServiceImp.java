package com.example.demo.service;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.Equipe;
import com.example.demo.entities.Niveau;
import com.example.demo.repository.EquipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class EquipeServiceImp implements EquipeService{

    EquipeRepository equipeRepository;

    @Override
    public List<Equipe> getAllEquipe() {
        return equipeRepository.findAll();
    }

    @Override
    public Equipe addEquipe(Equipe eq) {
        return equipeRepository.save(eq);
    }

    @Override
    public Equipe updateEquipe(Equipe eq) {
        return equipeRepository.save(eq);
    }

    @Override
    public Equipe getEquipeById(Long idEquipe) {
        return equipeRepository.findById(idEquipe).orElse(null);
    }

    @Override
    public void deleteEquipe(Long idEquipe) {
        equipeRepository.deleteById(idEquipe);
    }


    @Override
    public List<Equipe> findEquipeByDetailEquipeThematiqueLike(String thematique) {
        return equipeRepository.findEquipeByDetailEquipeThematiqueLike(thematique);
    }

    @Override
    public List<Equipe> findEquipeByEtudiantIdEtudiant(long id) {
        return equipeRepository.findEquipeByEtudiantIdEtudiant(id);
    }

    @Override
    public List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(long idEtudiant) {
        return equipeRepository.findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(idEtudiant);
    }

    @Override
    public List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(long idEtudiant, long idDepartement) {
        return equipeRepository.findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(idEtudiant,idDepartement);
    }

    @Override
    public List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau, String thematique) {
        return equipeRepository.retriveEquipeByNiveauAndThematique(niveau,thematique);
    }

    @Override
    public void deleteEquipeByNiveau(Niveau niveau) {
        equipeRepository.deleteEquipeByNiveau(niveau);
    }



}
