package com.example.demo.service;

import com.example.demo.entities.Equipe;
import com.example.demo.entities.Niveau;

import java.util.List;

public interface EquipeService {

    List<Equipe> getAllEquipe();
    Equipe addEquipe( Equipe eq);
    Equipe updateEquipe( Equipe eq);
    Equipe getEquipeById (Long idEquipe);
    void deleteEquipe( Long idEquipe);


    List<Equipe> findEquipeByDetailEquipeThematiqueLike(String thematique);

    List<Equipe> findEquipeByEtudiantIdEtudiant(long id);

    List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(long idEtudiant);

    List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(long idEtudiant,long idDepartement);

    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau , String thematique);

    void deleteEquipeByNiveau( Niveau niveau);
}
