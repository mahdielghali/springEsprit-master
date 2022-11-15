package com.example.demo.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class DetailEquipe implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idDetailEquipe;
    private int salle;
    private String thematique;

    @OneToOne(mappedBy = "detailEquipe")
    @JsonIgnore
    private Equipe equipe;


}
