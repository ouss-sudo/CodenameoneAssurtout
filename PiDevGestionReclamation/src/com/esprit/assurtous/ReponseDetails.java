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
import com.esprit.entities.Reponse;

/**
 *
 * @author ASUS
 */
public class ReponseDetails extends BaseForm{
    Form current;
    public ReponseDetails(Resources res, Reponse c) {
        super("Details Reponse",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
                    Container cnt = new Container(new BorderLayout());

        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Ajout Vehicule");
        getContentPane().setScrollVisible(false);
        
        //
        Label DateTxt = new Label("Date Reponse: " +c.getDatereponse(),"NewsTopLine2");
        Label objet = new Label("Objet : " +c.getObjet(),"NewsTopLine2");
        Label desc = new Label("Description : "+c.getDescription(),"NewsTopLine2");
        

        
       
        
        Button btnAnnuler = new Button("Retour");
        btnAnnuler.addActionListener(e -> new ListReponses(res).show());
        
        Button btnModifier = new Button("Modifier");
        //btnModifier.addActionListener(e -> new ModifierConstatForm(res,c).show());
       
        
        
        Container buttonContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
        buttonContainer.addAll(btnAnnuler, btnModifier);

        Container mainContainer = new Container(new BorderLayout());
        mainContainer.add(BorderLayout.CENTER, buttonContainer);

        // add the mainContainer to the form
        

  
        cnt.add(BorderLayout.CENTER, 
                BoxLayout.encloseY(
                        DateTxt,
                        objet,
                        desc
                       
                   
               
                
            ));
        

            add(cnt);
            add(mainContainer);
    }
}
