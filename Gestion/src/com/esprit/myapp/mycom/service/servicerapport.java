/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.myapp.mycom.service;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.esprit.myapp.mycompan.entity.Rapport;
import com.mycompa.utilis.statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class servicerapport {
   public static servicerapport instance = null ;
   
    public static boolean resultOk = true;

    //initilisation connection request
    private ConnectionRequest req;
   
   
    public static servicerapport getInstance() {
        if(instance == null )
            instance = new servicerapport();
        return instance ;
    }
 
     public servicerapport() {
        req = new ConnectionRequest();
       
    }
   
   
    //ajout
   
                     public void ajoutrapport(Rapport r) throws IOException{
       
        String url =statics.BASE_URL+"/ajouterveh?date_rapport="+r.getDate_rapport()+
                "&num_serievoiture="+r.getNum_serievoiture()+"&modele_voiture="+r.getModele_voiture()
                +"&date_mise_en_circulation="+r.getDate_mise_en_circulation()+"&matricule="
                +r.getMatricule()+"&couleur_voiture="+r.getCouleur_voiture()+"&conclusions="+r.getConclusion()
                +"&montant_exprime="+r.getMontant_exprime()+"&etat_rapport="+r.getEtat_rapport()+"&id_expert="+r.getId_expert()
                +"&mandant="+r.getMandant();  
       
        req.setUrl(url);
        req.addResponseListener((e) -> {
           
            String str = new String(req.getResponseData());//
            System.out.println("data == "+str);
        });
       
        NetworkManager.getInstance().addToQueueAndWait(req);//
       
    }
     //Delete
    public boolean deletearb(int id ) {
        String url = statics.BASE_URL +"/delete/mobile/?id="+id;
       
        req.setUrl(url);
       
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                   
                    req.removeResponseCodeListener(this);
            }
        });
     NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
    public boolean modifierrapport(Rapport r) {
        String url =statics.BASE_URL+"/edit?id="+r.getId()+"&date_rapport="+r.getDate_rapport()+
                "&num_serievoiture="+r.getNum_serievoiture()+"&modele_voiture="+r.getModele_voiture()
                +"&date_mise_en_circulation="+r.getDate_mise_en_circulation()+"&matricule="
                +r.getMatricule()+"&couleur_voiture="+r.getCouleur_voiture()+"&conclusions="+r.getConclusion(); 
        req.setUrl(url);
       
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200 ;  // Code response Http 200 ok
                req.removeResponseListener(this);
            }
        });
       
    NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
    return resultOk;
       
    }
    //affichage
   
    public ArrayList<Rapport>affichageArb() {
        ArrayList<Rapport> result = new ArrayList<>();
       
        String url = statics.BASE_URL+"/afficherveh";
        req.setUrl(url);
       
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
               
                try {
                    Map<String,Object>mapReclamations = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                   
                    List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapReclamations.get("root");
                   
                    for(Map<String, Object> obj : listOfMaps) {
                        Rapport re = new Rapport();
                       
                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("id").toString());
                       
                        //float montant_min = Float.parseFloat(obj.get("montant_min").toString());
                        //float montant_max = Float.parseFloat(obj.get("montant_max").toString());
                        String date_rapport = obj.get("date_rapport").toString();
                        String num_serievoiture = obj.get("num_serievoiture").toString();
                        String modele_voiture = obj.get("modele_voiture").toString();
                        String date_mise_en_circulation = obj.get("date_mise_en_circulation") != null?obj.get("date_mise_en_circulation").toString():"";
                        String matricule = obj.get("matricule").toString();
                        String couleur_voiture = obj.get("couleur_voiture").toString();
                        String conclusion = obj.get("conclusions") != null ?obj.get("conclusions").toString():"";
                        String etat = obj.get("etat_rapport").toString();
                        String mandant = obj.get("mandant").toString();
                        String id_expert = obj.get("id_expert").toString();
                        Double m = Double.parseDouble(obj.get("montant_exprime").toString());

                     //   float etat = Float.parseFloat(obj.get("etat").toString());
                       
                        re.setId((int)id);
                       
                        re.setConclusion(conclusion);
                        re.setMatricule(matricule);
                        re.setDate_mise_en_circulation(date_mise_en_circulation);
                        re.setCouleur_voiture(couleur_voiture);
                        re.setDate_rapport(date_rapport);
                        re.setNum_serievoiture(num_serievoiture);
                        re.getModele_voiture();
                        re.setModele_voiture(modele_voiture);
                        re.setMandant(mandant);
                        re.setEtat_rapport(date_rapport);
                        re.setId_expert(id_expert);
                        re.setMontant_exprime(m);
                        result.add(re);
                       
                   
                    }
                   
                }catch(Exception ex) {
                   
                    ex.printStackTrace();
                }
           
            }
        });
       
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha

        return result;
       
       
    } 
}
