package com.example.demo.service;

import com.example.demo.entities.*;
import com.example.demo.repository.ContratRepository;
import com.example.demo.repository.DepartementRepository;
import com.example.demo.repository.EquipeRepository;
import com.example.demo.repository.EtudiantRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@AllArgsConstructor
@Service
public class EtudiantServiceImp implements EtudiantService{
    EtudiantRepository etudiantRepository;
    DepartementRepository departementRepository;

    ContratRepository contratRepository;
    EquipeRepository equipeRepository;

    @Override
    public List<Etudiant> getAllEtudiant() {
        return etudiantRepository.findAll();
    }

    @Override
    public Etudiant addEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant updateEtudiant(Etudiant e) {
        return etudiantRepository.save(e);
    }

    @Override
    public Etudiant getEtudiantById(Long idEtudiant) {
        return etudiantRepository.findById(idEtudiant).orElse(null);
    }

    @Override
    public void deleteEtudiant(Long idEtudiant) {
        etudiantRepository.deleteById(idEtudiant);
    }

    @Override
    public Etudiant findEtudiantByPrenomE(String prenomE) {
        return  etudiantRepository.findByPrenomE(prenomE);
    }

    @Override
    public List<Etudiant> retrieveEtudiantByEquipeThematique(String thematique) {
        return etudiantRepository.retrieveEtudiantByEquipeThematique(thematique);
    }

    @Override
    public void updateEtudiantByOption(Option op, long idEtudiant) {
        etudiantRepository.updateEtudiantByOption(op,idEtudiant);
    }

    @Override
    public void assignEtudiantToDepartment(long idEtudiant, long idDepartment) {
        Etudiant etudiant = this.etudiantRepository.findById(idEtudiant).orElse(null);
        Departement departement = this.departementRepository.findById(idDepartment).orElse(null);
        etudiant.setDepartement(departement);
        etudiantRepository.save(etudiant);
    }

    @Override
    @Transactional
    public Etudiant addAndAssignEtudiantToEquipeAndContract(Etudiant e, Integer idContrat, long idEquipe) {
        Contrat contrat = contratRepository.findById(idContrat).orElse(null);
        Equipe equipe = equipeRepository.findById(idEquipe).orElse(null);
        contrat.setEtudiant(e);
        equipe.getEtudiant().add(e); return etudiantRepository.save(e);
    }

    @Override
    public Etudiant findEtudiantByNomEAndPrenomE(String nomE, String prenomE) {
        return etudiantRepository.findEtudiantByNomEAndPrenomE(nomE,prenomE);
    }

    @Override
    public List<Etudiant> getEtudiantsByDepartement(long idDepartement) {
        Departement departement = departementRepository.findById(idDepartement).orElse(null);
        List<Etudiant> etudiants = departement.getEtudiant();
        return etudiants;

    }

}
