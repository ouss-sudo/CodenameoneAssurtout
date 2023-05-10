/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.assurtous;

import com.codename1.components.InfiniteProgress;
import com.codename1.l10n.SimpleDateFormat;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.esprit.assurtous.entities.Vehicule;
import com.esprit.assurtous.services.VehiculeService;

/**
 *
 * @author ASUS
 */
public class AjoutVehiculeForm extends BaseForm{
    Form current;
    public AjoutVehiculeForm(Resources res) {
        super("Ajouter Vehicule",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout Vehicule");
        getContentPane().setScrollVisible(false);
        
        //

        TextField agence = new TextField("", "nom agence!!");
        agence.setUIID("TextFieldBlack");
        addStringValue("Nom agence",agence);
        
        TextField nom = new TextField("", "nom conducteur!!");
        nom.setUIID("TextFieldBlack");
        addStringValue("Nom Conducteur",nom);

        TextField prenom = new TextField("", "prenom conducteur!!");
        prenom.setUIID("TextFieldBlack");
        addStringValue("Prenom Conducteur",prenom);
        
        
        TextField adresse = new TextField("", "Adresse !!");
        adresse.setUIID("TextFieldBlack");
        addStringValue("Prenom Conducteur",adresse);
        
        TextField immatriculation = new TextField("", "Immatriculation!!");
        immatriculation.setUIID("TextFieldBlack");
        addStringValue("immatriculation",immatriculation);
        
        Button btnAnnuler = new Button("Annuler");
        btnAnnuler.addActionListener(e -> new ListeVehiculesForm(res).show());
        
        Button btnAjouter = new Button("Ajouter");
        
        //onclick button event 
        btnAjouter.addActionListener((e) -> {
            try {
                
                if(agence.getText().equals("") || nom.getText().equals("") || prenom.getText().equals("") 
                        || adresse.getText().isEmpty() || immatriculation.getText().isEmpty()) {
                    Dialog.show("Veuillez vérifier les données","","Annuler", "OK");
                }else{
                    System.out.println("Je commence !");
                    InfiniteProgress ip = new InfiniteProgress(); //Loading  after insert data
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    
                    //njibo iduser men session (current user)
                    Vehicule v = new Vehicule();
                    v.setNomagence(String.valueOf(agence.getText().toString()));
                    v.setNomconducteur(nom.getText().toString());
                    v.setPrenomconducteur(prenom.getText().toString());
                    v.setAdresse(adresse.getText().toString());
                    v.setImmatriculation(immatriculation.getText().toString());
                    
                                  /*String.valueOf(titre.getText()).toString(),
                                  String.valueOf(contenu.getText()).toString(),
                                  format.format(new Date()),
                                  format.format(new Date()),
                                  String.valueOf(imageBlog.getText()).toString(),
                                  0);*/
                    System.out.println("Adding a new Vehicule !! ");
                    System.out.println("data  Vehicule == "+v);

                    //appelle methode ajouter mt3 service bch nzido données ta3na fi base 
                    VehiculeService.getInstance().ajoutVehicule(v);
                    
                    iDialog.dispose(); //na7io loading ba3d ma3mlna ajout
                    //ba3d l ajout nemchiw lel affichage
                    new ListeVehiculesForm(res).show();
                    refreshTheme();//Actualisation
                }
            }catch(Exception ex ) {
                ex.printStackTrace();
            }
        });
        
       add(BoxLayout.encloseY(
        btnAnnuler,
        btnAjouter
));


    }


    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s,"PaddedLabel"))
        .add(BorderLayout.CENTER,v));
        add(createLineSeparator(0xeeeeee));
    }
}
