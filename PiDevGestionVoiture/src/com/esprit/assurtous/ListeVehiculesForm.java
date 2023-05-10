/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.assurtous;

import com.codename1.ui.Button;
import com.codename1.ui.Component;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.FlowLayout;
import com.codename1.ui.plaf.Border;
import com.codename1.ui.plaf.Style;
import com.codename1.ui.plaf.UIManager;
import com.codename1.ui.util.Resources;
import com.esprit.assurtous.entities.Vehicule;
import com.esprit.assurtous.services.VehiculeService;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ListeVehiculesForm extends BaseForm{
    private int likeCount = 0;
    Form current;
    public ListeVehiculesForm(Resources res){
        super("Vehicules",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical

        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        addSideMenu(res);
        getContentPane().setScrollVisible(false);
        //Add "Ajouter" button
        Button addButton = new Button("Ajouter");
        addButton.addActionListener(e -> new AjoutVehiculeForm(res).show());
        
        
        
        ArrayList<Vehicule>list = VehiculeService.getInstance().affichageVehicules();
        for(Vehicule v : list){
            addButton(v.getNomagence(),v.getNomconducteur(),v.getPrenomconducteur(),v , res);
        }
        add(addButton);
    }

    private void addButton(String nomagence, String nomconducteur, String prenomconducteur, Vehicule v, Resources res) {
            
            
            Container cnt = new Container(new BorderLayout());
            Label nomagenceTxt = new Label("Agence : " +nomagence,"NewsTopLine2");
            Label conducteurTxt = new Label("Conducteur : " +nomconducteur+" "+prenomconducteur,"NewsTopLine2");
            //Label prenomconducteurTxt = new Label("Prenom Conducteur : " +prenomconducteur,"NewsTopLine2");
            //Label datecTxt = new Label("Date Creation : " +date_creation,"NewsTopLine2");
            //Label datemTxt = new Label("Date Modification : " +date_modification,"NewsTopLine2");
            
            Button deleteBtn = new Button();
            deleteBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_DELETE, deleteBtn.getStyle()));
            deleteBtn.addPointerPressedListener(e -> {
                Dialog dig = new Dialog("Suppression");
                if(dig.show("Suppression","Vous voulez supprimer ce blog ?","Annuler","Oui")) {
                    dig.dispose();
                } else {
                    dig.dispose();

                    if(VehiculeService.getInstance().deleteVehicule(v.getId())) {
                        new ListeVehiculesForm(res).show();
                    }
                }
                
            });
               
            Button editBtn = new Button();
            editBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, editBtn.getStyle()));
            editBtn.addPointerPressedListener(e -> {
                new ModifierVehiculeForm(res,v).show();
            });
            
            Button showBtn = new Button();
            showBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_DETAILS, editBtn.getStyle()));
            showBtn.addPointerPressedListener(e -> {
                new AffichierVehiculeForm(res,v).show();
            });
/*

            Button commentairesBtn = new Button();
            commentairesBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_COMMENT, commentairesBtn.getStyle()));
            commentairesBtn.addPointerPressedListener(e -> {
                new ListeCommentaireForm(res,id).show();
            });


            Button likeBtn = new Button();
            likeBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_THUMB_UP, likeBtn.getStyle()));
            likeBtn.addActionListener(e -> {
                
            });
            
            ArrayList<likeblog>list = ServicesLikeBlog.getInstance().affichageLikes(id);
            Label likeTxt = new Label("likes : " +list);

            Container buttonsContainer = new Container(new BoxLayout(BoxLayout.X_AXIS));
            buttonsContainer.addAll(editBtn, deleteBtn,commentairesBtn,likeBtn);
            
        //if(etat == 2){
            cnt.add(BorderLayout.CENTER, BoxLayout.encloseY(
                BoxLayout.encloseX(titreTxt),
                BoxLayout.encloseX(contenuTxt),
                //BoxLayout.encloseX(datecTxt),
                //BoxLayout.encloseX(datemTxt),
                buttonsContainer,
BoxLayout.encloseX(likeTxt)
            ));
            
            */
        //}
        Style style = cnt.getStyle();
        style.setBgColor(0xFF0000);
        style.setFgColor(0x0000Ff);
        style.setBorder(Border.createLineBorder(5));
        cnt.setUIID("vehiculeContainer");
        //Theme currentTheme =  UIManager.initFirstTheme("/theme");
        cnt.add(BorderLayout.CENTER, 
                BoxLayout.encloseY(
                BoxLayout.encloseX(nomagenceTxt,
                        deleteBtn,
                        editBtn,
                        showBtn),
                   BoxLayout.encloseX(conducteurTxt)
               
                
            ));
        

            add(cnt);
            refreshTheme();
    }
}
