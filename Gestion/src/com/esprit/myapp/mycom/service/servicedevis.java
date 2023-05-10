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



import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkManager;
import com.esprit.myapp.mycompan.entity.devis;
import com.mycompa.utilis.statics;
import java.io.IOException;

/**
 *
 * @author Oussema
 */
public class servicedevis {
    public static servicedevis instance = null ;
   
    public static boolean resultOk = true;

    //initilisation connection request
    private ConnectionRequest req;
   
   
    public static servicedevis getInstance() {
        if(instance == null )
            instance = new servicedevis();
        return instance ;
    }
 
     public servicedevis() {
        req = new ConnectionRequest();
       
    }
   
   
    //ajout
   
                     public void ajoutdevis(devis arb) throws IOException{
       
        String url =statics.BASE_URL+"/ajouterjson?montant_min="+arb.getMontant_min()  +"&montant_max="+arb.getMontant_max();  
       
        req.setUrl(url);
        req.addResponseListener((e) -> {
           
            String str = new String(req.getResponseData());//
            System.out.println("data == "+str);
        });
       
        NetworkManager.getInstance().addToQueueAndWait(req);//
       
    }
     //Delete
    public boolean deletearb(int id ) {
        String url = statics.BASE_URL +"/deletejson?id="+id;
       
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
    public boolean modifierdevis(devis dv) {
        String url =statics.BASE_URL+"/modifierjson?montant_min="+dv.getMontant_min()  +"&montant_max="+dv.getMontant_max();  
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
   
    public ArrayList<devis>affichageArb() {
        ArrayList<devis> result = new ArrayList<>();
       
        String url = statics.BASE_URL+"/afficherjson";
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
                        devis re = new devis();
                       
                        //dima id fi codename one float 5outhouha
                        float id = Float.parseFloat(obj.get("id").toString());
                       
                                              float montant_min = Float.parseFloat(obj.get("montant_min").toString());
                        float montant_max = Float.parseFloat(obj.get("montant_max").toString());

                                               

                     //   float etat = Float.parseFloat(obj.get("etat").toString());
                       
                        re.setId((int)id);
                       
                        re.setMontant_min((int)montant_min);
                        re.setMontant_max((int)montant_max);

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
