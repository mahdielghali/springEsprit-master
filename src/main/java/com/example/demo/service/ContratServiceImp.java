package com.example.demo.service;


import com.example.demo.entities.Contrat;
import com.example.demo.entities.Etudiant;
import com.example.demo.repository.ContratRepository;
import com.example.demo.repository.EtudiantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ContratServiceImp implements ContratService{

    @Autowired
    ContratRepository contratRepository;
    EtudiantRepository etudiantRepository;


    @Override
    public List<Contrat> getAllContrat() {
        return contratRepository.findAll();
    }

    @Override
    public Contrat addContrat(Contrat contrat){
        return contratRepository.save(contrat);
    }

    @Override
    public Contrat updateContrat(Contrat contrat){
        return contratRepository.save(contrat);
    }

    @Override
    public void deleteContrat(Integer id){
        contratRepository.deleteById(id);
    }
    @Override
    public Contrat getContratById(Integer id){
        return contratRepository.findById(id).orElse(null);
    }

    @Override
    public Contrat affectContratToEtudiant(Contrat ce, String nomE,String prenomE){
        Contrat contrat = contratRepository.findById(1).orElse(null);
        /*System.out.println(nomE+prenomE);*/
        Etudiant etudiant = etudiantRepository.findEtudiantByNomEAndPrenomE(nomE,prenomE);
        /*if (etudiant.getContrat().size()<=5) {
            contrat.setEtudiant(etudiant);
            contratRepository.save(contrat);
        }*/
        /*ce.getIdContrat()*/
        return contrat;
    }

    @Override
    public List<Contrat> getContratBetweenDates(Date startDate, Date endDate) {
        return contratRepository.getContratBetweenDates(startDate,endDate);
    }


}
