/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.assurtous.entities;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Constat {
    private int id;
    private String dateaccident,dateconstat;
    private String lieu,imageaccident,etat,nomclient,prenomclient,email,numerodetelephone;
    private float latitude,longitude;

    @Override
    public String toString() {
        return "Constat{" + "id=" + id + ", dateaccident=" + dateaccident + ", dateconstat=" + dateconstat + ", lieu=" + lieu + ", imageaccident=" + imageaccident + ", etat=" + etat + ", nomclient=" + nomclient + ", prenomclient=" + prenomclient + ", email=" + email + ", numerodetelephone=" + numerodetelephone + ", latitude=" + latitude + ", longitude=" + longitude + '}';
    }

    public Constat() {
    }

    public Constat(int id, String dateaccident, String dateconstat, String lieu, String imageaccident, String etat, String nomclient, String prenomclient, String email, String numerodetelephone, float latitude, float longitude) {
        this.id = id;
        this.dateaccident = dateaccident;
        this.dateconstat = dateconstat;
        this.lieu = lieu;
        this.imageaccident = imageaccident;
        this.etat = etat;
        this.nomclient = nomclient;
        this.prenomclient = prenomclient;
        this.email = email;
        this.numerodetelephone = numerodetelephone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public Constat(String dateaccident, String dateconstat, String lieu, String imageaccident, String etat, String nomclient, String prenomclient, String email, String numerodetelephone, float latitude, float longitude) {
        this.dateaccident = dateaccident;
        this.dateconstat = dateconstat;
        this.lieu = lieu;
        this.imageaccident = imageaccident;
        this.etat = etat;
        this.nomclient = nomclient;
        this.prenomclient = prenomclient;
        this.email = email;
        this.numerodetelephone = numerodetelephone;
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDateaccident(String dateaccident) {
        this.dateaccident = dateaccident;
    }

    public void setDateconstat(String dateconstat) {
        this.dateconstat = dateconstat;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public void setImageaccident(String imageaccident) {
        this.imageaccident = imageaccident;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public void setNomclient(String nomclient) {
        this.nomclient = nomclient;
    }

    public void setPrenomclient(String prenomclient) {
        this.prenomclient = prenomclient;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setNumerodetelephone(String numerodetelephone) {
        this.numerodetelephone = numerodetelephone;
    }

    public void setLatitude(float latitude) {
        this.latitude = latitude;
    }

    public void setLongitude(float longitude) {
        this.longitude = longitude;
    }

    public int getId() {
        return id;
    }

    public String getDateaccident() {
        return dateaccident;
    }

    public String getDateconstat() {
        return dateconstat;
    }

    public String getLieu() {
        return lieu;
    }

    public String getImageaccident() {
        return imageaccident;
    }

    public String getEtat() {
        return etat;
    }

    public String getNomclient() {
        return nomclient;
    }

    public String getPrenomclient() {
        return prenomclient;
    }

    public String getEmail() {
        return email;
    }

    public String getNumerodetelephone() {
        return numerodetelephone;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }
    

}   
