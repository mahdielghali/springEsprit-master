package com.example.demo.entities;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class Contrat implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idContrat;
    @Temporal (TemporalType.DATE)
    private Date dateDebutContrat;

    @Temporal (TemporalType.DATE)
    private Date dateFinContrat;

    @Enumerated(EnumType.STRING)
    private Specialite specialite;
    private boolean archive;
    @ManyToOne
     private Etudiant etudiant;

}
