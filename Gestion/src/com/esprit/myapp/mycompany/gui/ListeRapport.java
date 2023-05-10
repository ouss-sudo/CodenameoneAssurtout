/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.myapp.mycompany.gui;

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
import com.esprit.myapp.mycom.service.servicerapport;
import com.esprit.myapp.mycompan.entity.Rapport;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ListeRapport extends BaseForm{
    private int likeCount = 0;
    Form current;
    public ListeRapport(Resources res){
        super("Rapport",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical

        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        addSideMenu(res);
        getContentPane().setScrollVisible(false);
        //Add "Ajouter" button
        Button addButton = new Button("Ajouter");
        addButton.addActionListener(e -> new AjoutRapportForm(res).show());
        
        
        
        ArrayList<Rapport>list = servicerapport.getInstance().affichageArb();
        for(Rapport c : list){
            addButton(c, res);
        }
        add(addButton);
    }

    private void addButton( Rapport v, Resources res) {
            
            
            Container cnt = new Container(new BorderLayout());
            Label dateTxt = new Label("Date Rapport : " +v.getDate_rapport(),"NewsTopLine2");
            Label imm = new Label("Immatricule : " +v.getMatricule(),"NewsTopLine2");
            
            
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

                    if(servicerapport.getInstance().deletearb(v.getId())) {
                        new ListeRapport(res).show();
                    }
                }
                
            });
               
            Button editBtn = new Button();
            editBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, editBtn.getStyle()));
            editBtn.addPointerPressedListener(e -> {
                new ModiferRapport(res,v).show();
            });
            
            Button showBtn = new Button();
            showBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_DETAILS, editBtn.getStyle()));
            showBtn.addPointerPressedListener(e -> {
                new RapportDetails(res,v).show();
            });

        Style style = cnt.getStyle();
        style.setBgColor(0xFF0000);
        style.setFgColor(0x0000Ff);
        style.setBorder(Border.createLineBorder(5));
        cnt.setUIID("constatContainer");
        //Theme currentTheme =  UIManager.initFirstTheme("/theme");
        //Color color = new Color(255,0,0);
        cnt.add(BorderLayout.CENTER, 
                BoxLayout.encloseY(
                        
                BoxLayout.encloseX(dateTxt,
                        deleteBtn,
                        editBtn,
                        showBtn),
                        imm,
                        createLineSeparator(0xFF0000)
                  
               
                
            ));
        

            add(cnt);
            refreshTheme();
    }
}
