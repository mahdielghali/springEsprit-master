package com.example.demo.repository;

import com.example.demo.entities.Equipe;
import com.example.demo.entities.Niveau;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe,Long> {
    List<Equipe> findEquipeByDetailEquipeThematiqueLike(String thematique);

    List<Equipe> findEquipeByEtudiantIdEtudiant(long id);

    List<Equipe> findByEtudiantIdEtudiantAndDetailEquipeThematiqueNotNull(long idEtudiant);

    List<Equipe> findByEtudiantIdEtudiantAndEtudiantDepartementIdDepart(long idEtudiant,long idDepartement);

    @Query("SELECT eq FROM Equipe eq, DetailEquipe de  WHERE de.equipe.idEquipe = eq.idEquipe and eq.niveau = :niveau and de.thematique = :thematique")
    List<Equipe> retriveEquipeByNiveauAndThematique(Niveau niveau , String thematique);


    @Modifying
    @Transactional
    @Query("DELETE FROM Equipe eq where eq.niveau = :niveau")
    void deleteEquipeByNiveau(@Param("niveau") Niveau niveau);
}
