/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.entities;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Reponse {
    private int id;
    private String objet,description;
    private String datereponse;
    private Reclamation reclamation;

    @Override
    public String toString() {
        return "Reponse{" + "id=" + id + ", objet=" + objet + ", description=" + description + ", datereponse=" + datereponse + ", reclamation=" + reclamation + '}';
    }

    public Reponse() {
    }

    public Reponse(String objet, String description, String datereponse, Reclamation reclamation) {
        this.objet = objet;
        this.description = description;
        this.datereponse = datereponse;
        this.reclamation = reclamation;
    }

    public Reponse(int id, String objet, String description, String datereponse, Reclamation reclamation) {
        this.id = id;
        this.objet = objet;
        this.description = description;
        this.datereponse = datereponse;
        this.reclamation = reclamation;
    }

    public int getId() {
        return id;
    }

    public String getObjet() {
        return objet;
    }

    public String getDescription() {
        return description;
    }

    public String getDatereponse() {
        return datereponse;
    }

    public Reclamation getReclamation() {
        return reclamation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setObjet(String objet) {
        this.objet = objet;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setDatereponse(String datereponse) {
        this.datereponse = datereponse;
    }

    public void setReclamation(Reclamation reclamation) {
        this.reclamation = reclamation;
    }
    
    
}
