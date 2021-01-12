package com.integrationcontinue.Entity;

import javax.persistence.*;

@Entity
@Table(name="client")
public class Client {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nom;
    private String prenom;
    private String identifiant;

    @OneToOne
    @JoinColumn(name = "id_contrat")
    private Contrat idContrat;


    public Client(){
        super();
    }

    public Client(Integer id, String nom, String prenom, String identifiant, Contrat idContrat) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.identifiant = identifiant;
        this.idContrat = idContrat;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public Contrat getId_contrat() {
        return idContrat;
    }

    public void setId_contrat(Contrat idContrat) {
        this.idContrat = idContrat;
    }

}
