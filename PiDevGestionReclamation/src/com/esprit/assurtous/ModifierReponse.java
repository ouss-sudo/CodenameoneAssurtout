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
import com.esprit.entities.Reponse;
import com.esprit.services.ReponseService;

/**
 *
 * @author ASUS
 */
public class ModifierReponse extends BaseForm{
    Form current;
    public ModifierReponse(Resources res, Reponse c) {
        super("Modifier Reponse",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Modifier Constat");
        getContentPane().setScrollVisible(false);
        
        //

        TextField objet = new TextField("", c.getObjet());
        objet.setUIID("TextFieldBlack");
        addStringValue("Objet :",objet);
        
        TextField desc = new TextField("", c.getDescription());
        desc.setUIID("TextFieldBlack");
        addStringValue("Description :",desc);

        
        
        
        /// parsing the dates 
        //String dateString = "2022-03-08";
        //SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        /*Picker dateaccident = new Picker();
        Picker dateconstat = new Picker();
        addStringValue("Date Accident : ",dateaccident);
        addStringValue("Date Constat : ",dateconstat);
        //Date date = datePicker.getDate();

        // Create a SimpleDateFormat object to format the date
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String acc = dateFormat.format(dateaccident);
        String con = dateFormat.format(dateconstat);
*/
        
        

        
        
        
        Button btnAnnuler = new Button("Annuler");
        btnAnnuler.addActionListener(e -> new ListReponses(res).show());
        
        Button btnModifier = new Button("Modifier");
        
        //onclick button event 
        btnModifier.addActionListener((e) -> {
            
                
                if(objet.getText().equals("") || desc.getText().equals("") ) {
                    Dialog.show("Veuillez vérifier les données","","Annuler", "OK");
                }else{
                    System.out.println("Je commence !");
                    InfiniteProgress ip = new InfiniteProgress(); //Loading  after insert data
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    
                    //njibo iduser men session (current user)
                    
                    //c.setDateaccident(acc);
                    //c.setDateconstat(con);
                    c.setObjet(objet.getText());
                    c.setDescription(desc.getText());
                    

                    
                                  /*String.valueOf(titre.getText()).toString(),
                                  String.valueOf(contenu.getText()).toString(),
                                  format.format(new Date()),
                                  format.format(new Date()),
                                  String.valueOf(imageBlog.getText()).toString(),
                                  0);*/
                    System.out.println("Modifying a Reponse !! ");
                    System.out.println("data  Reponse == "+c);

                    //appelle methode ajouter mt3 service bch nzido données ta3na fi base 
                    ReponseService.getInstance().ModifierReponse(c);
                    
                    iDialog.dispose(); //na7io loading ba3d ma3mlna ajout
                    //ba3d l ajout nemchiw lel affichage
                    new ListReponses(res).show();
                    refreshTheme();//Actualisation
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
