package com.example.demo.entities;

import com.example.demo.entities.Departement;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
public class Universite  implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idDepart;
    private String nomUniv;

    @OneToMany
    List<Departement> departements;
    @Override
    public String toString() {
        return "Universite{" +
                "idDepart=" + idDepart +
                ", nomUniv='" + nomUniv + '\'' +
                '}';
    }

    public int getIdDepart() {
        return idDepart;
    }

    public void setIdDepart(int idDepart) {
        this.idDepart = idDepart;
    }

    public String getNomUniv() {
        return nomUniv;
    }

    public void setNomUniv(String nomUniv) {
        this.nomUniv = nomUniv;
    }
}
