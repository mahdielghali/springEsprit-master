package com.example.demo.repository;

import com.example.demo.entities.Contrat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ContratRepository extends JpaRepository<Contrat, Integer> {

    @Query("SELECT ct FROM Contrat ct where (?1 <= ct.dateDebutContrat ) and (?2 >= ct.dateFinContrat)")
    List<Contrat> getContratBetweenDates(Date startDate, Date endDate);

    @Query("SELECT count(ct) FROM Contrat ct where (?1 <= ct.dateDebutContrat ) and (?2 >= ct.dateFinContrat) and ct.archive=false")
    Integer findNbContratByDatesAndArchives(@Param("dateDebut") Date dateDebut, @Param("dateFin") Date dateFin);
    @Query(nativeQuery = true, value= "SELECT DATEDIFF( ct.date_fin_contrat,CAST( NOW() AS Date )) AS DateDiff from Contrat as ct  where ct.id_contrat = ?1 ")
    Integer GetDaysById(Integer id);
    @Query(nativeQuery = true, value= "SELECT DATEDIFF( CAST( NOW() AS Date ),ct.date_debut_contrat) AS DateDiff from Contrat as ct  where ct.id_contrat = ?1 ")
    Integer GetDaysByIdFromStart(Integer id);
}
