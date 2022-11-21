package com.example.demo.service;

import com.example.demo.entities.Contrat;

import java.util.Date;
import java.util.List;

public interface ContratService {

    List<Contrat> getAllContrat();

    Contrat addContrat(Contrat contrat);

    Contrat updateContrat(Contrat contrat);

    void deleteContrat(Integer id);

    Contrat getContratById(Integer id);

    Contrat affectContratToEtudiant (Contrat ce, String nomE,String prenomE);

    List<Contrat> getContratBetweenDates(Date startDate, Date endDate);
}
