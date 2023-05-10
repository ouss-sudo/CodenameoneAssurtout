/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.myapp.mycompany.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.esprit.myapp.mycompan.entity.Rapport;

/**
 *
 * @author ASUS
 */
public class RapportDetails extends BaseForm {
    Form current;
    public RapportDetails(Resources res, Rapport v) {
        super("Details Rapport",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
                    Container cnt = new Container(new BorderLayout());

        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Ajout Vehicule");
        getContentPane().setScrollVisible(false);
        
        //
        Label DateRapportTxt = new Label("Date Rapport : " +v.getDate_rapport(),"NewsTopLine2");
        Label num_serieTxt = new Label("Num Serie : " +v.getNum_serievoiture(),"NewsTopLine2");
        Label modele = new Label("Modele : "+v.getModele_voiture(),"NewsTopLine2");
        Label matricule = new Label("Matricule : "+v.getMatricule(),"NewsTopLine2");
        Label couleur = new Label("Couleur : "+v.getCouleur_voiture(),"NewsTopLine2");
        Label date_circulation = new Label("Date mise en circulation : "+v.getDate_mise_en_circulation(),"NewsTopLine2");
        Label mandant = new Label("Mandant : "+v.getMandant(),"NewsTopLine2");
        Label conclusions = new Label("Conclusion : "+v.getConclusion(),"NewsTopLine2");
        Label mantant = new Label("Mantant exprime : "+v.getMontant_exprime(),"NewsTopLine2");
        Label etat = new Label("Etat : "+v.getEtat_rapport(),"NewsTopLine2");
        Label expert = new Label("Id Expert : "+v.getId_expert(),"NewsTopLine2");

        
        
        
        
        
        
       
        
        Button btnAnnuler = new Button("Retour");
        btnAnnuler.addActionListener(e -> new ListeRapport(res).show());
        
        Button btnModifier = new Button("Modifier");
        btnModifier.addActionListener(e -> new ModiferRapport(res,v).show());
       
        
        
        Container buttonContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        buttonContainer.addAll(btnAnnuler, btnModifier);

        Container mainContainer = new Container(new BorderLayout());
        mainContainer.add(BorderLayout.CENTER, buttonContainer);

        // add the mainContainer to the form
        

  
        cnt.add(BorderLayout.CENTER, 
                BoxLayout.encloseY(
                        DateRapportTxt,
                   num_serieTxt,
                   modele,
                   matricule,
                   couleur,
                   date_circulation,
                   mandant,
                   conclusions,
                   mantant,
                   etat,
                   expert
                   
               
                
            ));
        

            add(cnt);
            add(mainContainer);

    }
}
