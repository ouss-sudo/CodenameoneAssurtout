/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.myapp.mycompan.entity;

/**
 *
 * @author ASUS
 */
public class Rapport {
    private int id;
    private String num_serievoiture,modele_voiture,matricule,couleur_voiture,conclusion,etat_rapport;
    private String date_rapport,date_mise_en_circulation,mandant,id_expert;
    private Double montant_exprime;

    @Override
    public String toString() {
        return "Rapport{" + "id=" + id + ", num_serievoiture=" + num_serievoiture + ", modele_voiture=" + modele_voiture + ", matricule=" + matricule + ", couleur_voiture=" + couleur_voiture + ", conclusion=" + conclusion + ", etat_rapport=" + etat_rapport + ", date_rapport=" + date_rapport + ", date_mise_en_circulation=" + date_mise_en_circulation + ", mandant=" + mandant + ", id_expert=" + id_expert + ", montant_exprime=" + montant_exprime + '}';
    }

    public void setMandant(String mandant) {
        this.mandant = mandant;
    }

    public void setId_expert(String id_expert) {
        this.id_expert = id_expert;
    }

    public void setMontant_exprime(Double montant_exprime) {
        this.montant_exprime = montant_exprime;
    }

    public String getMandant() {
        return mandant;
    }

    public String getId_expert() {
        return id_expert;
    }

    public Double getMontant_exprime() {
        return montant_exprime;
    }
            
   

    public Rapport() {
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNum_serievoiture(String num_serievoiture) {
        this.num_serievoiture = num_serievoiture;
    }

    public void setModele_voiture(String modele_voiture) {
        this.modele_voiture = modele_voiture;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public void setCouleur_voiture(String couleur_voiture) {
        this.couleur_voiture = couleur_voiture;
    }

    public void setConclusion(String conclusion) {
        this.conclusion = conclusion;
    }

    public void setEtat_rapport(String etat_rapport) {
        this.etat_rapport = etat_rapport;
    }

    public void setDate_rapport(String date_rapport) {
        this.date_rapport = date_rapport;
    }

    public void setDate_mise_en_circulation(String date_mise_en_circulation) {
        this.date_mise_en_circulation = date_mise_en_circulation;
    }

    public int getId() {
        return id;
    }

    public String getNum_serievoiture() {
        return num_serievoiture;
    }

    public String getModele_voiture() {
        return modele_voiture;
    }

    public String getMatricule() {
        return matricule;
    }

    public String getCouleur_voiture() {
        return couleur_voiture;
    }

    public String getConclusion() {
        return conclusion;
    }

    public String getEtat_rapport() {
        return etat_rapport;
    }

    public String getDate_rapport() {
        return date_rapport;
    }

    public String getDate_mise_en_circulation() {
        return date_mise_en_circulation;
    }
    
    
}
