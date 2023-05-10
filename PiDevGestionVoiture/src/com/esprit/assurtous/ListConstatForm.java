/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.assurtous;

import com.codename1.ui.Button;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.esprit.assurtous.entities.Constat;
import com.esprit.assurtous.services.ConstatService;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ListConstatForm extends BaseForm{
    private int likeCount = 0;
    Form current;
    public ListConstatForm(Resources res){
        super("Constat",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical

        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        addSideMenu(res);
        getContentPane().setScrollVisible(false);
        //Add "Ajouter" button
        Button addButton = new Button("Ajouter");
        addButton.addActionListener(e -> new AjoutConstat(res).show());
        
        
        
        ArrayList<Constat>list = ConstatService.getInstance().affichageConstats();
        for(Constat c : list){
            addButton(c.getDateconstat(),c.getLieu(),c.getNomclient(),c.getPrenomclient(),c, res);
        }
        add(addButton);
    }

    private void addButton(String dateconstat, String lieu, String nomclient,String prenomclient, Constat v, Resources res) {
            
            
            Container cnt = new Container(new BorderLayout());
            Label dateconstatTxt = new Label("Date Accident : " +v.getDateaccident(),"NewsTopLine2");
            Label lieuTxt = new Label("Lieu : " +lieu,"NewsTopLine2");
            Label ClientTxt = new Label("Client : " +nomclient+" "+prenomclient,"NewsTopLine2");

            //Label prenomconducteurTxt = new Label("Prenom Conducteur : " +prenomconducteur,"NewsTopLine2");
            //Label datecTxt = new Label("Date Creation : " +date_creation,"NewsTopLine2");
            //Label datemTxt = new Label("Date Modification : " +date_modification,"NewsTopLine2");
            
            Button deleteBtn = new Button();
            deleteBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_DELETE, deleteBtn.getStyle()));
            deleteBtn.addPointerPressedListener(e -> {
                Dialog dig = new Dialog("Suppression");
                if(dig.show("Suppression","Vous voulez supprimer ce Constat ?","Annuler","Oui")) {
                    dig.dispose();
                } else {
                    dig.dispose();

                    if(ConstatService.getInstance().deleteConstat(v.getId())) {
                        new ListeVehiculesForm(res).show();
                    }
                }
                
            });
               
            Button editBtn = new Button();
            editBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, editBtn.getStyle()));
            editBtn.addPointerPressedListener(e -> {
                new ModifierConstatForm(res,v).show();
            });
            
            Button showBtn = new Button();
            showBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_DETAILS, editBtn.getStyle()));
            showBtn.addPointerPressedListener(e -> {
                new AffichierConstatDetails(res,v).show();
            });

        Style style = cnt.getStyle();
        style.setBgColor(0xFF0000);
        style.setFgColor(0x0000Ff);
        style.setBorder(Border.createLineBorder(5));
        cnt.setUIID("constatContainer");
        //Theme currentTheme =  UIManager.initFirstTheme("/theme");
        cnt.add(BorderLayout.CENTER, 
                BoxLayout.encloseY(
                        
                BoxLayout.encloseX(dateconstatTxt,
                        deleteBtn,
                        editBtn,
                        showBtn),
                        ClientTxt,
                   lieuTxt
               
                
            ));
        

            add(cnt);
            refreshTheme();
    }
   
}
