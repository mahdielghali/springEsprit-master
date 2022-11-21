package com.example.demo.entities;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
//@Table( name = "Etudiant")
public class Etudiant implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    //@Column(name="idEtudiant")
    private long idEtudiant; // Clé primaire
    private String prenomE;
    private String nomE;
    private Option opt;

    @OneToMany(mappedBy = "etudiant")
    @JsonIgnore
    private List<Contrat> contrat;

    @ManyToOne
    @JsonIgnore
    private Departement departement;

    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "etudiant")
    private List<Equipe> equipes;

}