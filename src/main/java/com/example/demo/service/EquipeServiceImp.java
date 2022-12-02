package com.example.demo.service;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.Equipe;
import com.example.demo.entities.Niveau;
import com.example.demo.repository.ContratRepository;
import com.example.demo.repository.EquipeRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@AllArgsConstructor
@Service
public class EquipeServiceImp implements EquipeService{

    EquipeRepository equipeRepository;
    ContratRepository contratRepository;

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

    @Scheduled(cron = "0 * 13 * * *")
    @Override
    @Transactional
    public void faireEvoluerEquipes() {
        List<Equipe> equipes = equipeRepository.findAll();
        Integer nb_pro_etudiant;
        for (int equipe =0; equipe<equipes.size();equipe++){
            nb_pro_etudiant = 0;
            if (equipes.get(equipe).getNiveau() == Niveau.SENIOR || equipes.get(equipe).getNiveau() == Niveau.JUNIOR ) {
                for (int etudiant = 0; etudiant < equipes.get(equipe).getEtudiant().size(); etudiant++) {
                    for (int contrat = 0; contrat < equipes.get(equipe).getEtudiant().get(etudiant).getContrat().size(); contrat++) {
                        if (contratRepository.GetDaysByIdFromStart(equipes.get(equipe).getEtudiant().get(etudiant).getContrat().get(contrat).getIdContrat()) >= 365) {
                            nb_pro_etudiant++;
                            break;
                        }
                    }
                }
            }
            if (nb_pro_etudiant>=3){
                if (equipes.get(equipe).getNiveau() == Niveau.SENIOR){
                    equipes.get(equipe).setNiveau(Niveau.EXPERT);
                    System.out.println("L'equipe de l'id "+equipes.get(equipe).getIdEquipe()+"\na passer du niveau SENIOR a EXPERT");
                }else{
                    equipes.get(equipe).setNiveau(Niveau.SENIOR);
                    System.out.println("L'equipe de l'id "+equipes.get(equipe).getIdEquipe()+"\na passer du niveau JUNIOR a SENIOR");
                }
            }
        }

    }


}
