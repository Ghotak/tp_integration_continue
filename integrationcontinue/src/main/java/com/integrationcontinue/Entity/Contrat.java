package com.integrationcontinue.Entity;

import javax.persistence.*;

@Entity
@Table(name="contrat")
public class Contrat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String libelle;
    private Double reduction;

    public Contrat(){
        super();
    }

    public Contrat(Integer id, String libelle, Double reduction) {
        this.id = id;
        this.libelle = libelle;
        this.reduction = reduction;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public Double getReduction() {
        return reduction;
    }

    public void setReduction(Double reduction) {
        this.reduction = reduction;
    }
}
