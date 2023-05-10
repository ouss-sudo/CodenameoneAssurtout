/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.myapp.mycompany.gui;

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
import com.esprit.myapp.mycom.service.servicerapport;
import com.esprit.myapp.mycompan.entity.Rapport;

/**
 *
 * @author ASUS
 */
public class AjoutRapportForm extends BaseForm{
    Form current;
    public AjoutRapportForm(Resources res) {
        super("Ajouter Rapport",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
    
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        //setTitle("Ajout Vehicule");
        getContentPane().setScrollVisible(false);
        
        //

        TextField num_serie = new TextField("", "num_serie");
        num_serie.setUIID("TextFieldBlack");
        addStringValue("Num Serie :",num_serie);
        
        TextField modele = new TextField("", " modele");
        modele.setUIID("TextFieldBlack");
        addStringValue("Modele : :",modele);

        TextField matricule = new TextField("", " matricule");
        matricule.setUIID("TextFieldBlack");
        addStringValue("Matricule  :",matricule);
        
        
        TextField  couleur= new TextField("", " Couleur ");
        couleur.setUIID("TextFieldBlack");
        addStringValue("Couleur :",couleur);
        
        TextField  conclusions= new TextField("", " conclusion ");
        conclusions.setUIID("TextFieldBlack");
        addStringValue("Conclusion :",conclusions);
        
        TextField  date_rapport= new TextField("", " date ");
        date_rapport.setUIID("TextFieldBlack");
        addStringValue("Date Rapport :",date_rapport);
        
        TextField  date_mise= new TextField("", " date mise enroute ");
        date_mise.setUIID("TextFieldBlack");
        addStringValue("Date de mise en circulation :",date_mise);
       
        TextField  montant_exprime= new TextField("", " montant_exprime ");
        montant_exprime.setUIID("TextFieldBlack");
        addStringValue("Montant exprimer (*):",montant_exprime);
        
        TextField  id_expert= new TextField("", " id expert ");
        id_expert.setUIID("TextFieldBlack");
        addStringValue("Id expert :",id_expert);
        
        TextField  etat_rapport= new TextField("", " etat rapport ");
        etat_rapport.setUIID("TextFieldBlack");
        addStringValue("Etat du rapport :",etat_rapport);
        
        TextField  mandant= new TextField("", " mandant ");
        mandant.setUIID("TextFieldBlack");
        addStringValue("Mandant :",mandant);
        
        
        Button btnAnnuler = new Button("Annuler");
        btnAnnuler.addActionListener(e -> new ListeRapport(res).show());
        
        Button btnAjouter = new Button("Ajouter");
        
        //onclick button event 
        btnAjouter.addActionListener((e) -> {
            try {
                
                if(num_serie.getText().equals("") || couleur.getText().equals("") || modele.getText().equals("") 
                        || conclusions.getText().isEmpty() || matricule.getText().isEmpty() ) {
                    Dialog.show("Veuillez vérifier les données","","Annuler", "OK");
                }else{
                    System.out.println("Je commence !");
                    InfiniteProgress ip = new InfiniteProgress(); //Loading  after insert data
                    final Dialog iDialog = ip.showInfiniteBlocking();
                    //SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                    
                    //njibo iduser men session (current user)
                    Rapport v = new Rapport();
                    v.setConclusion(conclusions.getText().toString());
                    v.setCouleur_voiture(couleur.getText().toString());
                    v.setMatricule(matricule.getText().toString());
                    v.setModele_voiture(modele.getText().toString());
                    v.setNum_serievoiture(num_serie.getText().toString());
                    v.setDate_rapport(date_rapport.getText().toString());
                    v.setDate_mise_en_circulation(date_mise.getText().toString());
                    v.setMandant(mandant.getText().toString());
                    v.setEtat_rapport(etat_rapport.getText().toString());
                    v.setId_expert(id_expert.getText().toString());
                    Double m = Double.valueOf(montant_exprime.getText().toString());
                    v.setMontant_exprime(m);
                                  /*String.valueOf(titre.getText()).toString(),
                                  String.valueOf(contenu.getText()).toString(),
                                  format.format(new Date()),
                                  format.format(new Date()),
                                  String.valueOf(imageBlog.getText()).toString(),
                                  0);*/
                    System.out.println("Adding a new Constat !! ");
                    System.out.println("data  Constat == "+v);

                    //appelle methode ajouter mt3 service bch nzido données ta3na fi base 
                    servicerapport.getInstance().ajoutrapport(v);
                    
                    iDialog.dispose(); //na7io loading ba3d ma3mlna ajout
                    //ba3d l ajout nemchiw lel affichage
                    new ListeRapport(res).show();
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
