/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.esprit.myapp.mycompany.gui;

import com.codename1.components.InfiniteProgress;
import com.codename1.components.ScaleImageLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Component;
import static com.codename1.ui.Component.BOTTOM;
import static com.codename1.ui.Component.CENTER;
import static com.codename1.ui.Component.LEFT;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.Display;
import com.codename1.ui.EncodedImage;
import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Graphics;
import com.codename1.ui.Image;
import com.codename1.ui.Label;
import com.codename1.ui.RadioButton;
import com.codename1.ui.Tabs;
import com.codename1.ui.TextArea;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;

import com.codename1.ui.layouts.LayeredLayout;
import com.codename1.ui.plaf.Style;

import com.codename1.ui.Toolbar;
import com.esprit.myapp.mycom.service.servicedevis;
import com.codename1.ui.util.Resources;
import com.esprit.myapp.mycompan.entity.devis;

/**
 *
 * @author Oussema
 */
public class AjouterdevisForm extends BaseForm  {
    Form current;
    public AjouterdevisForm(Resources res ) {
        super("Newsfeed",BoxLayout.y()); //herigate men Newsfeed w l formulaire vertical
   
        Toolbar tb = new Toolbar(true);
        current = this ;
        setToolbar(tb);
        getTitleArea().setUIID("Container");
        setTitle("Ajout devis");
        getContentPane().setScrollVisible(false);
       
       
      /*  tb.addSearchCommand(e ->  {
           
        });
       
        Tabs swipe = new Tabs();
       
        Label s1 = new Label();
        Label s2 = new Label();
       
//addTab(swipe,s1, res.getImage("back-logo.jpeg"),"","",res);       
        //
       
         swipe.setUIID("Container");
        swipe.getContentPane().setUIID("Container");
        swipe.hideTabs();

        ButtonGroup bg = new ButtonGroup();
        int size = Display.getInstance().convertToPixels(1);
        Image unselectedWalkthru = Image.createImage(size, size, 0);
        Graphics g = unselectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAlpha(100);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        Image selectedWalkthru = Image.createImage(size, size, 0);
        g = selectedWalkthru.getGraphics();
        g.setColor(0xffffff);
        g.setAntiAliased(true);
        g.fillArc(0, 0, size, size, 0, 360);
        RadioButton[] rbs = new RadioButton[swipe.getTabCount()];
        FlowLayout flow = new FlowLayout(CENTER);
        flow.setValign(BOTTOM);
        Container radioContainer = new Container(flow);
        for (int iter = 0; iter < rbs.length; iter++) {
            rbs[iter] = RadioButton.createToggle(unselectedWalkthru, bg);
            rbs[iter].setPressedIcon(selectedWalkthru);
            rbs[iter].setUIID("Label");
            radioContainer.add(rbs[iter]);
        }

        rbs[0].setSelected(true);
        swipe.addSelectionListener((i, ii) -> {
            if (!rbs[ii].isSelected()) {
                rbs[ii].setSelected(true);
            }
        });
         Component.setSameSize(radioContainer, s1, s2);
        add(LayeredLayout.encloseIn(swipe, radioContainer));

        ButtonGroup barGroup = new ButtonGroup();
        RadioButton mesListes = RadioButton.createToggle("Mes devis", barGroup);
        mesListes.setUIID("SelectBar");
        RadioButton liste = RadioButton.createToggle("stat", barGroup);
        liste.setUIID("SelectBar");
        RadioButton partage = RadioButton.createToggle("Ajout devis", barGroup);
        partage.setUIID("SelectBar");
       Label arrow = new Label(res.getImage("news-tab-down-arrow.png"), "Container");

       
       
       

        mesListes.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
       
         // ListArabForm a = new ListArbForm(res);
           // a.show();
            refreshTheme();
        });

       
       
       
         liste.addActionListener((e) -> {
               InfiniteProgress ip = new InfiniteProgress();
        final Dialog ipDlg = ip.showInifiniteBlocking();
       
         // StastiquesForm b = new StastiquesForm(res);
            //b.show();
            refreshTheme();
        });
         add(LayeredLayout.encloseIn(
                GridLayout.encloseIn(3, mesListes, liste, partage),
                FlowLayout.encloseBottom(arrow)
        ));

        partage.setSelected(true);
        arrow.setVisible(false);
        addShowListener(e -> {
            arrow.setVisible(true);
            updateArrowPosition(partage, arrow);
        });
        bindButtonSelection(mesListes, arrow);
        bindButtonSelection(liste, arrow);
        bindButtonSelection(partage, arrow);
        // special case for rotation
        addOrientationListener(e -> {
            updateArrowPosition(barGroup.getRadioButton(barGroup.getSelectedIndex()), arrow);
        });*/
      
      TextField montant_min = new TextField("", "entrer montant_min!!");
        montant_min.setUIID("TextFieldBlack");
        addStringValue("montant_min",montant_min);
       
        TextField montant_max = new TextField("", "entrer montant_max!!");
        montant_max.setUIID("TextFieldBlack");
        addStringValue("montant_max",montant_max);
       
     Button btnAjouter = new Button("Ajouter");
        addStringValue("", btnAjouter);
        
   //onclick button event

        btnAjouter.addActionListener((e) -> {
           
           
            try {
               
                if( montant_min.getText().equals("")) {
                    Dialog.show("Veuillez vérifier les données","","Annuler", "OK");
                }
               
                else {
                    InfiniteProgress ip = new InfiniteProgress();; //Loading  after insert data
               
                    final Dialog iDialog = ip.showInfiniteBlocking();
                   
                   
                   
                    //njibo iduser men session (current user)

                    devis r=new devis(Integer.parseInt(montant_min.getText().toString()),Integer.parseInt(montant_max.getText().toString() ));
                    System.out.println("data reclamation =="+r);
                   
                   
                    servicedevis.getInstance().ajoutdevis(r);
                   
                   
                    iDialog.dispose(); //na7io loading ba3d ma3mlna ajout
//                      sendMail(res);
                     
                     // SmsWhatsapp.msg();
                     
                     
            Dialog.show("Reclamation envoyee","Veuillez vérifier votre boite de réception",new Command("OK"));
                   
                    //ba3d ajout net3adaw lel ListREclamationForm
                 //   new ListeReclamationForm(res).show();
                   
                   
                    refreshTheme();//Actualisation
                           
                }
               
            }catch(Exception ex ) {
               
            }
           
           
           
           
           
        });
       
       
      
}
       private void addStringValue(String s, Component v) {
       
        add(BorderLayout.west(new Label(s,"PaddedLabel"))
        .add(BorderLayout.CENTER,v));
        add(createLineSeparator(0xeeeeee));
    }
         private void addTab(Tabs swipe, Label spacer , Image image, String string, String text, Resources res) {
        int size = Math.min(Display.getInstance().getDisplayWidth(), Display.getInstance().getDisplayHeight());
       
        if(image.getHeight() < size) {
            image = image.scaledHeight(size);
        }
       
       
       
        if(image.getHeight() > Display.getInstance().getDisplayHeight() / 3 ) {
            image = image.scaledHeight(Display.getInstance().getDisplayHeight() / 3);
        }
       
        ScaleImageLabel imageScale = new ScaleImageLabel(image);
        imageScale.setUIID("Container");
        imageScale.setBackgroundType(Style.BACKGROUND_IMAGE_SCALED_FILL);
       
        Label overLay = new Label("","ImageOverlay");
       
       
        Container page1 =
                LayeredLayout.encloseIn(
                imageScale,
                        overLay,
                        BorderLayout.south(
                        BoxLayout.encloseY(
                        new SpanLabel(text, "LargeWhiteText"),
                                        spacer
                        )
                    )
                );
       
        swipe.addTab("",res.getImage("back-logo.jpeg"), page1);
       
       
       
       
    }
   
   
   
    public void bindButtonSelection(Button btn , Label l ) {
       
        btn.addActionListener(e-> {
        if(btn.isSelected()) {
            updateArrowPosition(btn,l);
        }
    });
    }

    private void updateArrowPosition(Button btn, Label l) {
       
        l.getUnselectedStyle().setMargin(LEFT, btn.getX() + btn.getWidth()  / 2  - l.getWidth() / 2 );
        l.getParent().repaint();
    }
}
