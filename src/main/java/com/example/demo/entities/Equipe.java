package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Equipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idEquipe;
    private String nomEquipe;
    private Niveau niveau;

    @OneToOne
    private DetailEquipe detailEquipe;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private List<Etudiant> etudiant;

    @Enumerated(EnumType.STRING)
    public Niveau getNiveau() {
        return niveau;
    }

    @Enumerated(EnumType.STRING)
    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
