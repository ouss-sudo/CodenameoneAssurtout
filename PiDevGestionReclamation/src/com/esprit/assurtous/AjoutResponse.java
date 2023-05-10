/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.assurtous;

import com.codename1.components.InfiniteProgress;
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
import com.esprit.entities.Reponse;
import com.esprit.services.ReponseService;

/**
 *
 * @author ASUS
 */
public class AjoutResponse extends BaseForm{
    Form current;
    public AjoutResponse(Resources res) {
        super("Ajouter Response",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Ajout Vehicule");
        getContentPane().setScrollVisible(false);
        
        //

        TextField objet = new TextField("", "objet");
        objet.setUIID("TextFieldBlack");
        addStringValue("Objet :",objet);
        
        TextField desc = new TextField("", "descrption");
        desc.setUIID("TextFieldBlack");
        addStringValue("Description :",desc);

        
        
        
        
       
        
        Button btnAnnuler = new Button("Annuler");
        btnAnnuler.addActionListener(e -> new ListReponses(res).show());
        
        Button btnAjouter = new Button("Ajouter");
        
        //onclick button event 
        btnAjouter.addActionListener((e) -> {
            try {
                
                if(objet.getText().isEmpty() == false || desc.getText().isEmpty() == false ) {
                    Dialog.show("Veuillez vérifier les données","","Annuler", "OK");
                }else{
                    System.out.println("Je commence !");
                    InfiniteProgress ip = new InfiniteProgress(); //Loading  after insert data
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    
                    //njibo iduser men session (current user)
                    Reponse c = new Reponse();
                    c.setObjet(objet.getText());
                    c.setDescription(desc.getText());
                    
                                  /*String.valueOf(titre.getText()).toString(),
                                  String.valueOf(contenu.getText()).toString(),
                                  format.format(new Date()),
                                  format.format(new Date()),
                                  String.valueOf(imageBlog.getText()).toString(),
                                  0);*/
                    System.out.println("Adding a new Constat !! ");
                    System.out.println("data  Constat == "+c);

                    //appelle methode ajouter mt3 service bch nzido données ta3na fi base 
                    ReponseService.getInstance().ajoutReponse(c);
                    
                    iDialog.dispose(); //na7io loading ba3d ma3mlna ajout
                    //ba3d l ajout nemchiw lel affichage
                    new ListReponses(res).show();
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
