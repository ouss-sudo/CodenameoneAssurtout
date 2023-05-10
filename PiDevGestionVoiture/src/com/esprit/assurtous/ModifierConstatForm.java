/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.assurtous;

import com.codename1.components.InfiniteProgress;
import com.codename1.l10n.ParseException;
import com.codename1.l10n.SimpleDateFormat;
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
import com.codename1.ui.spinner.Picker;
import com.codename1.ui.util.Resources;
import com.esprit.assurtous.entities.Constat;
import com.esprit.assurtous.services.ConstatService;
import java.util.Date;


/**
 *
 * @author ASUS
 */
public class ModifierConstatForm extends BaseForm{
    
Form current;
    public ModifierConstatForm(Resources res, Constat c) {
        super("Modifier Constat",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Modifier Constat");
        getContentPane().setScrollVisible(false);
        
        //

        TextField lieu = new TextField("", c.getLieu());
        lieu.setUIID("TextFieldBlack");
        addStringValue("Lieu :",lieu);
        
        TextField nomclient = new TextField("", c.getNomclient());
        nomclient.setUIID("TextFieldBlack");
        addStringValue("Nom Client :",nomclient);

        TextField prenomclient = new TextField("", c.getPrenomclient());
        prenomclient.setUIID("TextFieldBlack");
        addStringValue("Prenom Client :",prenomclient);
        
        
        TextField  num= new TextField("", c.getNumerodetelephone());
        num.setUIID("TextFieldBlack");
        addStringValue("Numero :",num);
        
        
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
        btnAnnuler.addActionListener(e -> new ListConstatForm(res).show());
        
        Button btnModifier = new Button("Modifier");
        
        //onclick button event 
        btnModifier.addActionListener((e) -> {
            
                
                if(lieu.getText().equals("") || nomclient.getText().equals("") || prenomclient.getText().equals("") 
                        || num.getText().isEmpty() ) {
                    Dialog.show("Veuillez vérifier les données","","Annuler", "OK");
                }else{
                    System.out.println("Je commence !");
                    InfiniteProgress ip = new InfiniteProgress(); //Loading  after insert data
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    
                    //njibo iduser men session (current user)
                    
                    //c.setDateaccident(acc);
                    //c.setDateconstat(con);
                    c.setLieu(lieu.getText().toString());
                    c.setNomclient(nomclient.getText().toString());
                    c.setNumerodetelephone(num.getText().toString());
                    c.setPrenomclient(prenomclient.getText().toString());
                    

                    
                                  /*String.valueOf(titre.getText()).toString(),
                                  String.valueOf(contenu.getText()).toString(),
                                  format.format(new Date()),
                                  format.format(new Date()),
                                  String.valueOf(imageBlog.getText()).toString(),
                                  0);*/
                    System.out.println("Modifying a Constat !! ");
                    System.out.println("data  Constat == "+c);

                    //appelle methode ajouter mt3 service bch nzido données ta3na fi base 
                    ConstatService.getInstance().ModifierConstat(c);
                    
                    iDialog.dispose(); //na7io loading ba3d ma3mlna ajout
                    //ba3d l ajout nemchiw lel affichage
                    new ListeVehiculesForm(res).show();
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
