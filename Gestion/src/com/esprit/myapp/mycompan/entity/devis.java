/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.myapp.mycompan.entity;

/**
 *
 * @author Oussema
 */
public class devis {
    private int id ; 
    private float montant_min ; 
    private float montant_max ; 
    private int rapport  ; 

    public devis() {
    }

    public devis(int id, float montant_min, float montant_max, int rapport) {
        this.id = id;
        this.montant_min = montant_min;
        this.montant_max = montant_max;
        this.rapport = rapport;
    }
      public devis(float montant_min, float montant_max, int rapport) {
        this.montant_min = montant_min;
        this.montant_max = montant_max;
        this.rapport = rapport;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getMontant_min() {
        return montant_min;
    }

    public void setMontant_min(float montant_min) {
        this.montant_min = montant_min;
    }

    public float getMontant_max() {
        return montant_max;
    }

    public void setMontant_max(float montant_max) {
        this.montant_max = montant_max;
    }

    public int getRapport() {
        return rapport;
    }

    public void setRapport(int rapport) {
        this.rapport = rapport;
    }

    public devis(float montant_min, float montant_max) {
        this.montant_min = montant_min;
        this.montant_max = montant_max;
    }

    @Override
    public String toString() {
        return "devis{" + "id=" + id + ", montant_min=" + montant_min + ", montant_max=" + montant_max + ", rapport=" + rapport + '}';
    }

}
