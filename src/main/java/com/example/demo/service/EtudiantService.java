package com.example.demo.service;

import com.example.demo.entities.Equipe;
import com.example.demo.entities.Etudiant;
import com.example.demo.entities.Option;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EtudiantService {
    List<Etudiant> getAllEtudiant();
    Etudiant addEtudiant( Etudiant e);
    Etudiant updateEtudiant( Etudiant e);
    Etudiant getEtudiantById (Long idEtudiant);
    void deleteEtudiant( Long idEtudiant);
    Etudiant findEtudiantByPrenomE(String prenomE);

    List<Etudiant> retrieveEtudiantByEquipeThematique ( String thematique);

    void updateEtudiantByOption(Option op , long idEtudiant);

    public void assignEtudiantToDepartment( long idEtudiant, long idDepartment);

    Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, long idEquipe);

    Etudiant findEtudiantByNomEAndPrenomE(String nomE,String prenomE);

    List<Etudiant> getEtudiantsByDepartement (long idDepartement);
}
