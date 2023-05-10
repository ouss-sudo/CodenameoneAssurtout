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
public class AffichierVehiculeForm extends BaseForm{
Form current;
    public AffichierVehiculeForm(Resources res, Vehicule v) {
        super("Details Vehicule",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
                    Container cnt = new Container(new BorderLayout());

        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Ajout Vehicule");
        getContentPane().setScrollVisible(false);
        
        //
        Label nomagenceTxt = new Label("Agnece : " +v.getNomagence(),"NewsTopLine2");
        Label conducteurTxt = new Label("Conducteur : " +v.getNomconducteur() + " "+v.getPrenomconducteur(),"NewsTopLine2");
        Label Adresse = new Label("Adresse : "+v.getAdresse(),"NewsTopLine2");
        Label immatriculation = new Label("Immatriculation : "+v.getImmatriculation(),"NewsTopLine2");

        
       
        
        Button btnAnnuler = new Button("Retour");
        btnAnnuler.addActionListener(e -> new ListeVehiculesForm(res).show());
        
        Button btnModifier = new Button("Modifier");
        btnModifier.addActionListener(e -> new ModifierVehiculeForm(res,v).show());
       
        
        
        Container buttonContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        buttonContainer.addAll(btnAnnuler, btnModifier);

        Container mainContainer = new Container(new BorderLayout());
        mainContainer.add(BorderLayout.CENTER, buttonContainer);

        // add the mainContainer to the form
        

  
        cnt.add(BorderLayout.CENTER, 
                BoxLayout.encloseY(
                        nomagenceTxt,
                   conducteurTxt,
                   Adresse,
                   immatriculation
                   
               
                
            ));
        

            add(cnt);
            add(mainContainer);

    }


    
}    
    

