package com.example.demo.entities;

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
public class Departement implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idDepart;

    private String nomDepart;

    @OneToMany(mappedBy = "departement")
    private List<Etudiant> etudiant;
}
