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
import com.esprit.assurtous.entities.Constat;
import com.esprit.assurtous.services.ConstatService;


/**
 *
 * @author ASUS
 */
public class AjoutConstat extends BaseForm{
    Form current;
    public AjoutConstat(Resources res) {
        super("Ajouter Constat",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Ajout Vehicule");
        getContentPane().setScrollVisible(false);
        
        //

        TextField lieu = new TextField("", "lieu");
        lieu.setUIID("TextFieldBlack");
        addStringValue("Lieu :",lieu);
        
        TextField nomclient = new TextField("", "nom client");
        nomclient.setUIID("TextFieldBlack");
        addStringValue("Nom Client :",nomclient);

        TextField prenomclient = new TextField("", "prenom client");
        prenomclient.setUIID("TextFieldBlack");
        addStringValue("Prenom Client :",prenomclient);
        
        
        TextField  num= new TextField("", "numero telephone");
        num.setUIID("TextFieldBlack");
        addStringValue("Numero :",num);
        
        
        
       
        
        Button btnAnnuler = new Button("Annuler");
        btnAnnuler.addActionListener(e -> new ListConstatForm(res).show());
        
        Button btnAjouter = new Button("Ajouter");
        
        //onclick button event 
        btnAjouter.addActionListener((e) -> {
            try {
                
                if(lieu.getText().equals("") || nomclient.getText().equals("") || prenomclient.getText().equals("") 
                        || num.getText().isEmpty() ) {
                    Dialog.show("Veuillez vérifier les données","","Annuler", "OK");
                }else{
                    System.out.println("Je commence !");
                    InfiniteProgress ip = new InfiniteProgress(); //Loading  after insert data
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    
                    //njibo iduser men session (current user)
                    Constat v = new Constat();
                    v.setLieu(String.valueOf(lieu.getText().toString()));
                    v.setNomclient(nomclient.getText().toString());
                    v.setPrenomclient(prenomclient.getText().toString());
                    v.setNumerodetelephone(num.getText().toString());
                    
                                  /*String.valueOf(titre.getText()).toString(),
                                  String.valueOf(contenu.getText()).toString(),
                                  format.format(new Date()),
                                  format.format(new Date()),
                                  String.valueOf(imageBlog.getText()).toString(),
                                  0);*/
                    System.out.println("Adding a new Constat !! ");
                    System.out.println("data  Constat == "+v);

                    //appelle methode ajouter mt3 service bch nzido données ta3na fi base 
                    ConstatService.getInstance().ajoutConstat(v);
                    
                    iDialog.dispose(); //na7io loading ba3d ma3mlna ajout
                    //ba3d l ajout nemchiw lel affichage
                    new ListConstatForm(res).show();
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
