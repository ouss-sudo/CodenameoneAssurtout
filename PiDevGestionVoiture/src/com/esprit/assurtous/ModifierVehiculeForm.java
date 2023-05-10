/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.assurtous;

import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
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
public class ModifierVehiculeForm extends BaseForm{
     Form current;
    public ModifierVehiculeForm(Resources res, Vehicule v) {
        super("Modifier Vehicule",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Ajout Vehicule");
        getContentPane().setScrollVisible(false);
        
        //

        TextField agence = new TextField("", v.getNomagence());
        agence.setUIID("TextFieldBlack");
        addStringValue("Nom agence",agence);
        
        TextField nom = new TextField("", v.getNomconducteur());
        nom.setUIID("TextFieldBlack");
        addStringValue("Nom Conducteur",nom);

        TextField prenom = new TextField("", v.getPrenomconducteur());
        prenom.setUIID("TextFieldBlack");
        addStringValue("Prenom Conducteur",prenom);
        
        
        TextField adresse = new TextField("", v.getAdresse());
        adresse.setUIID("TextFieldBlack");
        addStringValue("Adresse",adresse);
        
        TextField immatriculation = new TextField("", v.getImmatriculation());
        immatriculation.setUIID("TextFieldBlack");
        addStringValue("immatriculation",immatriculation);
        
        Button btnAnnuler = new Button("Annuler");
        btnAnnuler.addActionListener(e -> new ListeVehiculesForm(res).show());
        
        Button btnModifier = new Button("Modifier");
        
        //onclick button event 
        btnModifier.addActionListener((e) -> {
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
                    //Vehicule v = new Vehicule();
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
                    System.out.println("Modifying a Vehicule !! ");
                    System.out.println("data  Vehicule == "+v);

                    //appelle methode ajouter mt3 service bch nzido données ta3na fi base 
                    VehiculeService.getInstance().ModifierVehicule(v);
                    
                    iDialog.dispose(); //na7io loading ba3d ma3mlna ajout
                    //ba3d l ajout nemchiw lel affichage
                    new ListeVehiculesForm(res).show();
                    refreshTheme();//Actualisation
                }
            }catch(Exception ex ) {
                ex.printStackTrace();
            }
        });
        
        Container buttonContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        buttonContainer.addAll(btnAnnuler, btnModifier);

        Container mainContainer = new Container(new BorderLayout());
        mainContainer.add(BorderLayout.CENTER, buttonContainer);

        // add the mainContainer to the form
        add(mainContainer);

        /*add(BorderLayout.CENTER,
                BoxLayout.encloseX(
                btnAnnuler,
                btnModifier
        ));*/

    }


    private void addStringValue(String s, Component v) {
        add(BorderLayout.west(new Label(s,"PaddedLabel"))
        .add(BorderLayout.CENTER,v));
        add(createLineSeparator(0xeeeeee));
    }
}
