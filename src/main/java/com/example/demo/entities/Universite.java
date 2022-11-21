package com.example.demo.entities;

import com.example.demo.entities.Departement;
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
public class Universite  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long idUniversity  ;
    private String nomUniv;

    @OneToMany
    List<Departement> departements;


}
