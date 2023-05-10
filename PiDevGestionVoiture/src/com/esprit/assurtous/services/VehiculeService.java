/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.assurtous.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.esprit.assurtous.entities.Vehicule;
import com.esprit.assurtous.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class VehiculeService {
    public static VehiculeService instance = null ;

    public static boolean resultOk;

    //initilisation connection request 
    private ConnectionRequest req;

    public static VehiculeService getInstance() {
        if(instance == null )
            instance = new VehiculeService();
        return instance ;
    }

    public VehiculeService() {
        req = new ConnectionRequest();
    }
    
    
    
    //ajout 
    public void ajoutVehicule(Vehicule vehicule) {
        
        /*String url =Statics.BASE_URL+"/vehicule/add/vehicule?num_contrat=" +vehicule.getNum_contrat()+ "&nomagence="+vehicule.getNomagence()+
                "&nomconducteur="+vehicule.getNomconducteur()+"&prenomconducteur="+vehicule.getPrenomconducteur()+"&adresse="+vehicule.getAdresse()
                +"&immatriculation="+vehicule.getImmatriculation()+"&constat="+vehicule.getConstat();
        */
       String url =Statics.BASE_URL+"/vehicule/add/vehicule?"+"nomagence="+vehicule.getNomagence()+
                "&nomconducteur="+vehicule.getNomconducteur()+"&prenomconducteur="+"&immatriculation="+vehicule.getImmatriculation()+"&adresse="+vehicule.getAdresse();
       System.out.println(url);
        req.setUrl(url);
        req.addResponseListener((e) -> {
            
            String str = new String(req.getResponseData()); // Reponse json hethi lyrinaha fi navigateur 9bila
            System.out.println("data == "+str);
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req); // execution ta3 request sinon yet3ada chy dima nal9awha
    }
    
     //affichage
    public ArrayList<Vehicule>affichageVehicules() {
        ArrayList<Vehicule> result = new ArrayList<>();
        
        String url = Statics.BASE_URL+"/vehicule/all";
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                JSONParser jsonp ;
                jsonp = new JSONParser();
                
                try {
                    Map<String,Object> mapVehicule = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray()));
                    if (mapVehicule.containsKey("root")) {
                        List<Map<String,Object>> listOfMaps =  (List<Map<String,Object>>) mapVehicule.get("root");
                        for(Map<String, Object> obj : listOfMaps) {
                            Vehicule v = new Vehicule();
                        
                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("id").toString());
                        //float constat_id = Float.parseFloat(obj.get("constat_id").toString());

                        String nomagence = obj.get("nomagence").toString();
                        String nomconducteur = obj.get("nomconducteur").toString();
                        String prenomconducteur = obj.get("prenomconducteur").toString();
                        String a = obj.get("adresse") != null ? obj.get("adresse").toString() : "";
                        String b = obj.get("immatriculation") != null ? obj.get("immatriculation").toString() : "";


                        //String adresse = obj.get("adresse").toString();
                        //String immatriculation = obj.get("immatriculation").toString();
                        
                        
                        v.setId((int)id);
                        v.setNomagence(nomagence);
                        v.setNomconducteur(nomconducteur);
                        v.setPrenomconducteur(prenomconducteur);
                        v.setAdresse(a);
                        v.setImmatriculation(b);
                        System.out.println(v.toString());
                        result.add(v);
                        }
                    } else {
                        System.out.println("Error: 'root' key not found in JSON response");
                    }

                    
                    
                }catch(Exception ex) {
                    
                    ex.printStackTrace();
                }
            
            }
        });
        
      NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
      return result;
    }
    
    
    //Delete 
    public boolean deleteVehicule(int id ) {
        String url = Statics.BASE_URL +"/vehicule/delete/mobile/"+id;
        
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
    //Update 
    public boolean ModifierVehicule(Vehicule v) {
        String url = Statics.BASE_URL +"/vehicule/edit/vehicule/"+v.getId()+"?nomagence="+v.getNomagence()+
                "&nomconducteur="+v.getNomconducteur()+"&prenomconducteur="+v.getPrenomconducteur()+"&immatriculation="+v.getImmatriculation()+"&adresse="+v.getAdresse();
        
        //String url= Statics.BASE_URL+"/vehicule/edit/"+v.getId();
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
    
     //Detail blog bensba l detail n5alihoa lel5r ba3d delete+update
    public Vehicule DetailBlog( int id , Vehicule v) {
        String url = Statics.BASE_URL+"/vehicule/one/"+id;
        req.setUrl(url);
        
        String str  = new String(req.getResponseData());

        req.addResponseListener(((evt) -> {
        
            JSONParser jsonp = new JSONParser();
            try {
                Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String(str).toCharArray()));
                

                String nomagence = obj.get("nomagence").toString();
                String nomconducteur = obj.get("nomconducteur").toString();
                String prenomconducteur = obj.get("prenomconducteur").toString();
                String adresse = obj.get("adresse").toString();
                String immatriculation = obj.get("immatriculation").toString();


                v.setNomagence(nomagence);
                v.setNomagence(nomconducteur);
                v.setPrenomconducteur(prenomconducteur);
                v.setAdresse(adresse);
                v.setImmatriculation(immatriculation);
                
                


            }catch(IOException ex) {
                System.out.println("error related to sql :( "+ex.getMessage());
            }

            System.out.println("data === "+str);
        }));
        
        NetworkManager.getInstance().addToQueueAndWait(req);//execution ta3 request sinon yet3ada chy dima nal9awha
        return v;
    }
    
}
