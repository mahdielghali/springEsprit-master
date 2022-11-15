package com.example.demo.repository;

import com.example.demo.entities.DetailEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DetailEquipeRepository extends JpaRepository<DetailEquipe,Long> {


    @Query("SELECT dt FROM DetailEquipe dt WHERE dt.thematique = :thematique")
    List<DetailEquipe> findDetailEquipeByThematique(String thematique);

}
