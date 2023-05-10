/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.myapp.mycompany.gui;

import com.codename1.components.FloatingHint;
import com.codename1.ui.Button;
import com.codename1.ui.ComboBox;
import com.codename1.ui.Container;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.esprit.myapp.mycom.service.servicedevis;
import com.esprit.myapp.mycompan.entity.devis;

/**
 *
 * @author Oussema
 */
public class ModifierForm extends BaseForm{
      Form current;
    public ModifierForm(Resources res , devis r) {
         super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
   
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout delivery");
        getContentPane().setScrollVisible(false);
       
       
        super.addSideMenu(res);
       
       
        TextField montant_min = new TextField(String.valueOf(r.getMontant_min()), "montant_min" , 20 , TextField.ANY);
        TextField montant_max = new TextField(String.valueOf(r.getMontant_max()), "montant_max" , 20 , TextField.ANY);
     
 
        //etat bch na3mlo comobbox bon lazm admin ya3mlleha approuver mais just chnwarikom ComboBox
       
       // ComboBox etatCombo = new ComboBox();
       
     //   etatCombo.addItem("Non Traiter");
       
       // etatCombo.addItem("Traiter");
       
     
       
       
       
       
        montant_min.setUIID("NewsTopLine");
        montant_max.setUIID("NewsTopLine");
       
       
        montant_min.setSingleLineTextArea(true);
            montant_max.setSingleLineTextArea(true);
       
        Button btnModifier = new Button("Modifier");
       btnModifier.setUIID("Button");
       
       //Event onclick btnModifer
       
       btnModifier.addPointerPressedListener(l ->   {
           
         
           r.setMontant_min(Integer.parseInt(montant_min.getText()));
           r.setMontant_max(Integer.parseInt(montant_max.getText()));
         
           
     
       
       //appel fonction modfier reclamation men service
       
       if(servicedevis.getInstance().modifierdevis(r)) { // if true
           //new ListeReclamationForm(res).show();
       }
        });
       Button btnAnnuler = new Button("Annuler");
       btnAnnuler.addActionListener(e -> {
           //new ListeReclamationForm(res).show();
       });
       
       
       Label l2 = new Label("");
       
       Label l3 = new Label("");
       
       Label l4 = new Label("");
       
       Label l5 = new Label("");
       
        Label l1 = new Label();
       
        Container content = BoxLayout.encloseY(
                l1, l2,
             
                new FloatingHint(montant_min),
                createLineSeparator(),
                //etatCombo,
                new FloatingHint(montant_max),
                createLineSeparator(),//ligne de séparation
                createLineSeparator(),
                btnModifier,
                btnAnnuler
               
               
        );
       
        add(content);
        show();
       
       
    }
}
