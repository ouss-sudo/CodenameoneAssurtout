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
import com.esprit.entities.Reponse;
import com.esprit.services.ReponseService;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ListReponses extends BaseForm{
  private int likeCount = 0;
    Form current;
    public ListReponses(Resources res){
        super("Response",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical

        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        addSideMenu(res);
        getContentPane().setScrollVisible(false);
        //Add "Ajouter" button
        Button addButton = new Button("Ajouter");
        addButton.addActionListener(e -> new AjoutResponse(res).show());
        
        
        
        ArrayList<Reponse>list = ReponseService.getInstance().affichageReponses();
        for(Reponse c : list){
            addButton(c, res);
        }
        add(addButton);
    }

    private void addButton( Reponse v, Resources res) {
            
            
            Container cnt = new Container(new BorderLayout());
            Label dateTxt = new Label("Date Reponse : " +v.getDatereponse(),"NewsTopLine2");
            Label Objet = new Label("Objet : " +v.getObjet(),"NewsTopLine2");
            Label desc = new Label("Description : " +v.getDescription(),"NewsTopLine2");

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

                    if(ReponseService.getInstance().deleteReponse(v.getId())) {
                        new ListReponses(res).show();
                    }
                }
                
            });
               
            Button editBtn = new Button();
            editBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_MODE_EDIT, editBtn.getStyle()));
            editBtn.addPointerPressedListener(e -> {
                new ModifierReponse(res,v).show();
            });
            
            Button showBtn = new Button();
            showBtn.setIcon(FontImage.createMaterial(FontImage.MATERIAL_DETAILS, editBtn.getStyle()));
            showBtn.addPointerPressedListener(e -> {
                new ReponseDetails(res,v).show();
            });

        Style style = cnt.getStyle();
        style.setBgColor(0xFF0000);
        style.setFgColor(0x0000Ff);
        style.setBorder(Border.createLineBorder(5));
        cnt.setUIID("constatContainer");
        //Theme currentTheme =  UIManager.initFirstTheme("/theme");
        cnt.add(BorderLayout.CENTER, 
                BoxLayout.encloseY(
                        
                BoxLayout.encloseX(dateTxt,
                        deleteBtn,
                        editBtn,
                        showBtn),
                        Objet,
                   desc
               
                
            ));
        

            add(cnt);
            refreshTheme();
    }
     
}
