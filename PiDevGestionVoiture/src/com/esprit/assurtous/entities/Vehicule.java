/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.assurtous.entities;

/**
 *
 * @author ASUS
 */
public class Vehicule {
    private int id,num_contrat;
    private String nomagence,nomconducteur,prenomconducteur,adresse;
    private String immatriculation;
    private Constat constat;

    @Override
    public String toString() {
        return "Vehicule{" + "id=" + id + ", num_contrat=" + num_contrat + ", nomagence=" + nomagence + ", nomconducteur=" + nomconducteur + ", prenomconducteur=" + prenomconducteur + ", adresse=" + adresse + ", immatriculation=" + immatriculation + ", constat=" + constat + '}';
    }

    public Vehicule() {
    }

    public Vehicule(int num_contrat, String nomagence, String nomconducteur, String prenomconducteur, String adresse, String immatriculation, Constat constat) {
        this.num_contrat = num_contrat;
        this.nomagence = nomagence;
        this.nomconducteur = nomconducteur;
        this.prenomconducteur = prenomconducteur;
        this.adresse = adresse;
        this.immatriculation = immatriculation;
        this.constat = constat;
    }

    public Vehicule(int id, int num_contrat, String nomagence, String nomconducteur, String prenomconducteur, String adresse, String immatriculation, Constat constat) {
        this.id = id;
        this.num_contrat = num_contrat;
        this.nomagence = nomagence;
        this.nomconducteur = nomconducteur;
        this.prenomconducteur = prenomconducteur;
        this.adresse = adresse;
        this.immatriculation = immatriculation;
        this.constat = constat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum_contrat(int num_contrat) {
        this.num_contrat = num_contrat;
    }

    public void setNomagence(String nomagence) {
        this.nomagence = nomagence;
    }

    public void setNomconducteur(String nomconducteur) {
        this.nomconducteur = nomconducteur;
    }

    public void setPrenomconducteur(String prenomconducteur) {
        this.prenomconducteur = prenomconducteur;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public void setConstat(Constat constat) {
        this.constat = constat;
    }

    public int getId() {
        return id;
    }

    public int getNum_contrat() {
        return num_contrat;
    }

    public String getNomagence() {
        return nomagence;
    }

    public String getNomconducteur() {
        return nomconducteur;
    }

    public String getPrenomconducteur() {
        return prenomconducteur;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public Constat getConstat() {
        return constat;
    }
    
    
}
