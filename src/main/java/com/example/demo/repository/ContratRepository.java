package com.example.demo.repository;

import com.example.demo.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer> {

    @Query("SELECT ct FROM Contrat ct where (?1 between ct.dateDebutContrat and ct.dateFinContrat) and (?2 between ct.dateDebutContrat and ct.dateFinContrat)")
    List<Contrat> getContratBetweenDates(Date startDate, Date endDate);


}
