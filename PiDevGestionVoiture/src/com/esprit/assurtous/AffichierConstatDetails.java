/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.assurtous;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.esprit.assurtous.entities.Constat;

/**
 *
 * @author ASUS
 */
public class AffichierConstatDetails extends BaseForm{
    Form current;
    public AffichierConstatDetails(Resources res, Constat c) {
        super("Details Constst",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
                    Container cnt = new Container(new BorderLayout());

        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Ajout Vehicule");
        getContentPane().setScrollVisible(false);
        
        //
        Label DateAccidentTxt = new Label("Date Accident : " +c.getDateaccident(),"NewsTopLine2");
        Label DateConstatTxt = new Label("Conducteur : " +c.getDateconstat(),"NewsTopLine2");
        Label Lieu = new Label("Adresse : "+c.getLieu(),"NewsTopLine2");
        Label num = new Label("Immatriculation : "+c.getNumerodetelephone(),"NewsTopLine2");
        Label client = new Label("Immatriculation : "+c.getNomclient() + " "+c.getPrenomclient(),"NewsTopLine2");

        
       
        
        Button btnAnnuler = new Button("Retour");
        btnAnnuler.addActionListener(e -> new ListConstatForm(res).show());
        
        Button btnModifier = new Button("Modifier");
        btnModifier.addActionListener(e -> new ModifierConstatForm(res,c).show());
       
        
        
        Container buttonContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        buttonContainer.addAll(btnAnnuler, btnModifier);

        Container mainContainer = new Container(new BorderLayout());
        mainContainer.add(BorderLayout.CENTER, buttonContainer);

        // add the mainContainer to the form
        

  
        cnt.add(BorderLayout.CENTER, 
                BoxLayout.encloseY(
                        DateAccidentTxt,
                   DateConstatTxt,
                   Lieu,
                   client,
                   num
                   
               
                
            ));
        

            add(cnt);
            add(mainContainer);

    }
}
