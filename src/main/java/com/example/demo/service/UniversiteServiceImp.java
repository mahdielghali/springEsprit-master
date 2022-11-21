package com.example.demo.service;

import com.example.demo.entities.Contrat;
import com.example.demo.entities.Specialite;
import com.example.demo.entities.Universite;
import com.example.demo.repository.ContratRepository;
import com.example.demo.repository.UniversiteRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;

@AllArgsConstructor
@Service
public class UniversiteServiceImp implements UniversiteService{

    UniversiteRepository universiteRepository;
    ContratRepository contratRepository;


    @Override
    public List<Universite> getAllUniversite() {
        return universiteRepository.findAll();
    }

    @Override
    public Universite addUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public Universite updateUniversite(Universite upUniversite) {
        return universiteRepository.save(upUniversite);
    }

    @Override
    public void deleteUniversite(long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public Universite getUniversiteById(long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public float getChiffreAffaireEntreDeuxDate(Date startDate, Date endDate) {
        List<Contrat> contrats = contratRepository.getContratBetweenDates(startDate,endDate);
        LocalDate date1 = startDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
        LocalDate date2 = endDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        long monthsBetween = ChronoUnit.MONTHS.between(date1, date2);
        if (date1.isBefore(date2)
                && date2.getDayOfMonth() == date2.lengthOfMonth()
                && date1.getDayOfMonth() > date2.getDayOfMonth()) {
            monthsBetween += 1;
        }
        Contrat ct;
        long CA = 0;
        for (int i = 0; i <contrats.size();i++){
            ct  = contrats.get(i);
            if (ct.getSpecialite() == Specialite.IA){
                CA += monthsBetween*300;
            }
            if (ct.getSpecialite() == Specialite.CLOUD){
                CA += monthsBetween*400;
            }
            if (ct.getSpecialite() == Specialite.SECURITE){
                CA += monthsBetween*450;
            }
            if (ct.getSpecialite() == Specialite.RESEAUX){
                CA += monthsBetween*350;
            }
        }
        return CA;
    }
}
