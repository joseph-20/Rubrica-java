package GUI;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.sql.*;
import java.util.ArrayList;
import java.nio.file.Path;
import java.awt.Image;
import java.util.Random;

import Controller.Controller;


public class Window {
    //Dichiarazioni
    private ResultSet rs;
    private Statement s;
    private ArrayList<Integer> pkContatti;
    private ArrayList<Integer> pkContattiPrivati;
    private JPanel panel;
    private JTabbedPane Tabs;
    private JSplitPane SplitPaneAreaPrivata;
    private JSplitPane contattiSplitPane;
    private JPanel panelListaContatti;
    private JPanel panelInfoContatti;
    private JPanel ListaContattiPrivata;
    private JPanel InfoContattiPrivata;
    private JButton aggiungiContattoButton;
    private JButton creaGruppoButton;
    private JPanel PanelBottoni;
    private JPanel PanelBottoniPrivati;
    private JButton aggiungiContattoPrivatoButton;
    private JList listContatti;
    private JScrollPane scrollPaneContatti;
    DefaultListModel DLMContatti = new DefaultListModel();
    DefaultListModel DLMContattiPrivati = new DefaultListModel();
    private JList listAreaPrivata;
    private JScrollPane scrollPaneAreaPrivata;
    private JLabel lblFoto;
    private JLabel lblNome;
    private JLabel lblCognome;
    private JPanel panelInfoTop;
    private JPanel panelInfoBottom;
    private JList indirizzoPrincipaleList;
    private JPanel panelServizi;
    private JLabel lblMessenger;
    private JLabel lblWhatsapp;
    private JLabel lblViber;
    private JLabel lblTelegram;
    private JLabel lblSkype;
    private JLabel lblWeChat;
    private JLabel lblTeams;
    private JPanel panelM;
    private JPanel panelBottoniInfo;
    private JButton btnModifica;
    private JButton btnElimina;
    private JScrollPane infoBottomScroll;
    private JPanel panelScroll;
    private JLabel lblEmail;
    private JLabel lblGetEmail;
    private JLabel lblNumeriFissi;
    private JLabel lblGetNumeriFissi;
    private JLabel lblNumeriMobili;
    private JLabel lblGetNumeriMobili;
    private JLabel lblIndirizzoPrincipale;
    private JLabel lblGetIndirizzoPrincipale;
    private JLabel lblIndirizziSecondari;
    private JLabel lblGetIndirizziSecondari;
    private JPanel panelInfoContattoSinistra;
    private JPanel panelCreaContatto;
    private JSplitPane InfoCreaSplitPane;
    private JButton btnAnnulla;
    private JButton btnReindirizzamenti;
    private JPanel panelCreaContattoTop;
    private JButton btnAddContact;
    private JLabel nomeLabel;
    private JLabel cognomeLabel;
    private JTextField textFieldNome;
    private JTextField textFieldCognome;
    private JPanel panelMidCreaContatto;
    private JPanel panelServices;
    private JPanel panelGridBagServices;
    private JLabel lblMessengerCreaContatto;
    private JLabel lblSkypeCreaContatto;
    private JLabel lblTeamsCreaContatto;
    private JLabel lblTelegramCreaContatto;
    private JLabel lblViberCreaContatto;
    private JLabel lblWeChatCreaContatto;
    private JLabel lblWhatsappCreaContatto;
    private JPanel panelBottomCreaContatto;
    private JScrollPane creaContattoScrollPane;
    private JPanel panelCreaContattoScrollPane;
    private JLabel lblEmailCreaContatto;
    private JTextField textFieldEmail0;
    private JButton btnAddEmail;
    private JButton btnBackEmail;
    private JTextField textFieldEmail1;
    private JTextField textFieldEmail2;
    private JTextField textFieldEmail3;
    private JTextField textFieldEmail4;
    private JTextField textFieldEmail5;
    private JTextField textFieldEmail6;
    private JTextField textFieldEmail7;
    private JTextField textFieldEmail8;
    private JTextField textFieldEmail9;
    private JButton btnAddEmailCanGrow;
    private ImageIcon img;
    private DefaultListCellRenderer renderer;
    private JFileChooser jfc = new JFileChooser();
    private File foto;
    private Image image;
    private int cont=0;
    private ArrayList<String> randImage;
    private Random rand = new Random();

    public Window() throws SQLException{
        Controller c = new Controller();
        run(c);
    }

    private void run(Controller c) throws SQLException {
        //Creazione finestra principale
        JFrame frame = new JFrame("Rubrica");
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setMinimumSize (new Dimension (1280, 720));

        //Inizializzazione ArrayList randImage con foto default
        randImage = new ArrayList<String>();
        randImage.add("icon_blue.png");
        randImage.add("icon_green.png");
        randImage.add("icon_grey.png");
        randImage.add("icon_lightblue.png");
        randImage.add("icon_lightbrown.png");
        randImage.add("icon_lightgreen.png");
        randImage.add("icon_lightorange.png");
        randImage.add("icon_lightpink.png");
        randImage.add("icon_lightpurple.png");
        randImage.add("icon_lightred.png");
        randImage.add("icon_lightyellow.png");
        randImage.add("icon_magenta.png");
        randImage.add("icon_orange.png");
        randImage.add("icon_purple.png");
        randImage.add("icon_white.png");

        //Blocco scorrimento ScrollBar e settaggio visibilità panel
        scrollPaneContatti.setViewportView(listContatti);    //Aggiungiamo una VerticalScrollBar alla JList
        scrollPaneContatti.setVisible(true);
        scrollPaneAreaPrivata.setViewportView(listAreaPrivata);
        scrollPaneAreaPrivata.setVisible(true);
        panelCreaContatto.setVisible(false);
        contattiSplitPane.setEnabled(false);
        SplitPaneAreaPrivata.setEnabled(false);
        InfoCreaSplitPane.setEnabled(false);
        panelInfoContatti.setVisible(false);
        InfoCreaSplitPane.setDividerSize(0);
        contattiSplitPane.setDividerSize(0);
        panelInfoContattoSinistra.setVisible(false);
        panelCreaContatto.setVisible(false);
        creaContattoScrollPane.setBorder(null);

        //Gestione zona contatti
        pkContatti = new ArrayList<Integer>();
        DLMContatti = c.getContatti(pkContatti);
        listContatti.setModel(DLMContatti);                                         //Aggiungiamo nel JList i nomi e cognomi dei contatti

        //Gestione zona contatti privati
        pkContattiPrivati = new ArrayList<Integer>();
        DLMContattiPrivati = c.getContattiPrivati(pkContattiPrivati);
        listAreaPrivata.setModel(DLMContattiPrivati);                               //Aggiungiamo nel JList i nomi e cognomi dei contatti

        //SETTAGGIO LABEL INIZIALI
        lblEmail.setText("<html>Email<br/><html>");
        lblNumeriFissi.setText("<html>Numeri Fissi<br/><html>");
        lblNumeriMobili.setText("<html>Numeri Mobili<br/><html>");
        lblIndirizzoPrincipale.setText("<html>Indirizzo Principale<br/><html>");
        lblIndirizziSecondari.setText("<html>Indirizzi Secondari<br/><html>");

        lblEmailCreaContatto.setText("<html>Email<br/><html>");
        /*lblNumeriFissiCreaContatto.setText("<html>Numeri Fissi<br/><html>");
        lblNumeriMobiliCreaContatto.setText("<html>Numeri Mobili<br/><html>");
        lblIndirizzoPrincipaleCreaContatto.setText("<html>Indirizzo Principale<br/><html>");
        lblIndirizziSecondariCreaContatto.setText("<html>Indirizzi Secondari<br/><html>");*/

        //ELIMINAZIONE BORDER AUTOMATICO DELLO SCROLL
        infoBottomScroll.setBorder(null);

        //Listener contatto click
        listContatti.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    panelInfoContatti.setVisible(true);
                    c.swapVisibility(panelInfoContattoSinistra,panelCreaContatto);
                    contattiSplitPane.setDividerLocation(350);
                    //SET FOTO
                    img = c.SetImageSize(".images/"+randImage.get(rand.nextInt(randImage.size()-1)),200,200);
                    lblFoto.setIcon(img);
                    //SET NOME
                    lblNome.setText(c.getNome(pkContatti.get(listContatti.getSelectedIndex())));
                    //SET COGNOME
                    lblCognome.setText(c.getCognome(pkContatti.get(listContatti.getSelectedIndex())));
                    //SET EMAIL
                    if(c.getEmail((pkContatti.get(listContatti.getSelectedIndex()))).equals("NOT FOUND")){
                        lblEmail.setVisible(false);
                        lblGetEmail.setVisible(false);
                    }else {
                        lblGetEmail.setText(c.getEmail((pkContatti.get(listContatti.getSelectedIndex()))));
                        lblEmail.setVisible(true);
                        lblGetEmail.setVisible(true);
                    }
                    //SET NUMERI FISSI
                    if(c.getNumeriFissi(pkContatti.get(listContatti.getSelectedIndex())).equals("NOT FOUND")){
                        lblNumeriFissi.setVisible(false);
                        lblGetNumeriFissi.setVisible(false);
                    }else{
                        lblGetNumeriFissi.setText(c.getNumeriFissi(pkContatti.get(listContatti.getSelectedIndex())));
                        lblNumeriFissi.setVisible(true);
                        lblGetNumeriFissi.setVisible(true);
                    }
                    //SET NUMERI MOBILI
                    if(c.getNumeriMobili(pkContatti.get(listContatti.getSelectedIndex())).equals("NOT FOUND")){
                        lblNumeriMobili.setVisible(false);
                        lblGetNumeriMobili.setVisible(false);
                    }else{
                        lblGetNumeriMobili.setText(c.getNumeriMobili(pkContatti.get(listContatti.getSelectedIndex())));
                        lblNumeriMobili.setVisible(true);
                        lblGetNumeriMobili.setVisible(true);
                    }
                    //SET INDIRIZZO PRINCIPALE
                    if(c.getIndirizzoPrincipale(pkContatti.get(listContatti.getSelectedIndex())).equals("NOT FOUND")){
                        lblIndirizzoPrincipale.setVisible(false);
                        lblGetIndirizzoPrincipale.setVisible(false);
                    }else{
                        lblGetIndirizzoPrincipale.setText(c.getIndirizzoPrincipale(pkContatti.get(listContatti.getSelectedIndex())));
                        lblIndirizzoPrincipale.setVisible(true);
                        lblGetIndirizzoPrincipale.setVisible(true);
                    }
                    //SET INDIRIZZI SECONDARI
                    if(c.getIndirizziSecondari(pkContatti.get(listContatti.getSelectedIndex())).equals("NOT FOUND")){
                        lblIndirizziSecondari.setVisible(false);
                        lblGetIndirizziSecondari.setVisible(false);
                    }else{
                        lblGetIndirizziSecondari.setText(c.getIndirizziSecondari(pkContatti.get(listContatti.getSelectedIndex())));
                        lblIndirizziSecondari.setVisible(true);
                        lblGetIndirizziSecondari.setVisible(true);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Set foto del contatto
        img = c.SetImageSize(".images/icon_blue.png",200,200);
        lblFoto.setIcon(img);
        lblFoto.setVisible(true);

        //Set interazioni lblMessenger
        img = new ImageIcon(".images/Messenger25x25.png");
        lblMessenger.setIcon(img);

        //Mouse entered
        lblMessenger.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Messenger30x30.png");
                lblMessenger.setIcon(img);
            }
        });
        //Mouse exited
        lblMessenger.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Messenger25x25.png");
                lblMessenger.setIcon(img);
            }
        });

        //Set Interazioni lblSkype
        img = new ImageIcon(".images/Skype25x25.png");
        lblSkype.setIcon(img);
        //Mouse entered
        lblSkype.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Skype30x30.png");
                lblSkype.setIcon(img);
            }
        });
        //Mouse exited
        lblSkype.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Skype25x25.png");
                lblSkype.setIcon(img);
            }
        });

        //Set Interazioni lblTeams
        img  = new ImageIcon(".images/Teams25x25.png");
        lblTeams.setIcon(img );
        //Mouse entered
        lblTeams.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Teams30x30.png");
                lblTeams.setIcon(img);
            }
        });
        //Mouse exited
        lblTeams.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Teams25x25.png");
                lblTeams.setIcon(img);
            }
        });

        //Set Interazioni lblWeChat
        img  = new ImageIcon(".images/WeChat25x25.png");
        lblWeChat.setIcon(img);
        //Mouse entered
        lblWeChat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/WeChat30x30.png");
                lblWeChat.setIcon(img);
            }
        });
        //Mouse exited
        lblWeChat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/WeChat25x25.png");
                lblWeChat.setIcon(img);
            }
        });

        //Set Interazioni lblWhatsapp
        img  = new ImageIcon(".images/WhatsApp25x25.png");
        lblWhatsapp.setIcon(img);
        //Mouse entered
        lblWhatsapp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Whatsapp30x30.png");
                lblWhatsapp.setIcon(img);
            }
        });
        //Mouse exited
        lblWhatsapp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Whatsapp25x25.png");
                lblWhatsapp.setIcon(img);
            }
        });

        //Set Interazioni lblViber
        img = new ImageIcon(".images/Viber25x25.png");
        lblViber.setIcon(img);
        //Mouse entered
        lblViber.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Viber30x30.png");
                lblViber.setIcon(img);
            }
        });
        //Mouse exited
        lblViber.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Viber25x25.png");
                lblViber.setIcon(img);
            }
        });

        //Set Interazioni lblTelegram
        img = new ImageIcon(".images/Telegram25x25.png");
        lblTelegram.setIcon(img);
        //Mouse entered
        lblTelegram.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Telegram30x30.png");
                lblTelegram.setIcon(img);
            }
        });
        //Mouse exited
        lblTelegram.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Telegram25x25.png");
                lblTelegram.setIcon(img);
            }
        });

        //Set interazioni lblMessengerCreaContatto
        img = new ImageIcon(".images/Messenger25x25.png");
        lblMessengerCreaContatto.setIcon(img);

        //Mouse entered
        lblMessengerCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Messenger30x30.png");
                lblMessengerCreaContatto.setIcon(img);
            }
        });
        //Mouse exited
        lblMessengerCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Messenger25x25.png");
                lblMessengerCreaContatto.setIcon(img);
            }
        });

        //Set Interazioni lblSkypeCreaContatto
        img = new ImageIcon(".images/Skype25x25.png");
        lblSkypeCreaContatto.setIcon(img);
        //Mouse entered
        lblSkypeCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Skype30x30.png");
                lblSkypeCreaContatto.setIcon(img);
            }
        });
        //Mouse exited
        lblSkypeCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Skype25x25.png");
                lblSkypeCreaContatto.setIcon(img);
            }
        });

        //Set Interazioni lblTeamsCreaContatto
        img  = new ImageIcon(".images/Teams25x25.png");
        lblTeamsCreaContatto.setIcon(img );
        //Mouse entered
        lblTeamsCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Teams30x30.png");
                lblTeamsCreaContatto.setIcon(img);
            }
        });
        //Mouse exited
        lblTeamsCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Teams25x25.png");
                lblTeamsCreaContatto.setIcon(img);
            }
        });

        //Set Interazioni lblWeChatCreaContatto
        img  = new ImageIcon(".images/WeChat25x25.png");
        lblWeChatCreaContatto.setIcon(img);
        //Mouse entered
        lblWeChatCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/WeChat30x30.png");
                lblWeChatCreaContatto.setIcon(img);
            }
        });
        //Mouse exited
        lblWeChatCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/WeChat25x25.png");
                lblWeChatCreaContatto.setIcon(img);
            }
        });

        //Set Interazioni lblWhatsappCreaContatto
        img  = new ImageIcon(".images/WhatsApp25x25.png");
        lblWhatsappCreaContatto.setIcon(img);
        //Mouse entered
        lblWhatsappCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Whatsapp30x30.png");
                lblWhatsappCreaContatto.setIcon(img);
            }
        });
        //Mouse exited
        lblWhatsappCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Whatsapp25x25.png");
                lblWhatsappCreaContatto.setIcon(img);
            }
        });

        //Set Interazioni lblViberCreaContatto
        img = new ImageIcon(".images/Viber25x25.png");
        lblViberCreaContatto.setIcon(img);
        //Mouse entered
        lblViberCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Viber30x30.png");
                lblViberCreaContatto.setIcon(img);
            }
        });
        //Mouse exited
        lblViberCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Viber25x25.png");
                lblViberCreaContatto.setIcon(img);
            }
        });

        //Set Interazioni lblTelegramCreaContatto
        img = new ImageIcon(".images/Telegram25x25.png");
        lblTelegramCreaContatto.setIcon(img);
        //Mouse entered
        lblTelegramCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Telegram30x30.png");
                lblTelegramCreaContatto.setIcon(img);
            }
        });
        //Mouse exited
        lblTelegramCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Telegram25x25.png");
                lblTelegramCreaContatto.setIcon(img);
            }
        });
        //GESTIONE CLICK ELIMINA IN INFO CONTATTI
        btnElimina.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                img = c.SetImageSize(".images/warning.png",30,30);
                if(JOptionPane.showConfirmDialog(null,"SEI SICURO DI VOLER ELIMINARE QUESTO CONTATTO?","ATTENZIONE!",0,1,img)==0){
                    try {
                        c.cancellaContatto(pkContatti.get(listContatti.getSelectedIndex()));
                        //REFRESH LISTA CONTATTI E RESET DLM
                        panelInfoContatti.setVisible(false);
                        DLMContatti.clear();
                        DLMContatti = c.getContatti(pkContatti);
                        listContatti.setModel(DLMContatti);                                         //Aggiungiamo nel JList i nomi e cognomi dei contatti
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        //GESTIONE CLICK CREA CONTATTO IN LISTA CONTATTI
        aggiungiContattoButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                panelInfoContatti.setVisible(true);
                c.swapVisibility(panelCreaContatto,panelInfoContattoSinistra);
                contattiSplitPane.setDividerLocation(350);
                img = c.SetImageSize(".images/"+randImage.get(rand.nextInt(randImage.size()-1)),200,200);
                btnAddContact.setIcon(img);
            }
        });
        //GESTIONE CLICK ANNULLA IN CREA CONTATTO
        btnAnnulla.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                panelInfoContattoSinistra.setVisible(false);
                panelCreaContatto.setVisible(false);
                panelInfoContatti.setVisible(false);
                textFieldNome.setText(null);
                textFieldCognome.setText(null);
            }
        });

        //INTERAZIONI AGGIUNTA FOTO CONTATTO IN CREA CONTATTO
        btnAddContact.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                jfc.showDialog(null,"Seleziona la foto del contatto");
                jfc.setVisible(true);
                foto = jfc.getSelectedFile();
                try {
                    Files.copy(Path.of((foto.getPath())), Path.of((".images/"+(pkContatti.size()+pkContattiPrivati.size()+2))),StandardCopyOption.REPLACE_EXISTING);
                    img = c.SetImageSize(".images/"+(pkContatti.size()+pkContattiPrivati.size()+2),200,200);
                    btnAddContact.setIcon(img);
                    //TODO ELIMINA CONTATTO HA GLI STESSI ID
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //INTERAZIONI CON PULSANTE BTNADDEMAIL
        btnAddEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                    textFieldEmail0.setVisible(true);
                    btnBackEmail.setVisible(true);
                    btnAddEmailCanGrow.setVisible(true);
                    btnAddEmail.setVisible(false);
                    cont++;
            }
        });

        //INTERAZIONI COPIA DI BTNADDEMAIL
        btnAddEmailCanGrow.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(cont){
                    case 1 : textFieldEmail1.setVisible(true);
                        break;
                    case 2 : textFieldEmail2.setVisible(true);
                        break;
                    case 3 : textFieldEmail3.setVisible(true);
                        break;
                    case 4 : textFieldEmail4.setVisible(true);
                        break;
                    case 5 : textFieldEmail5.setVisible(true);
                        break;
                    case 6 : textFieldEmail6.setVisible(true);
                        break;
                    case 7 : textFieldEmail7.setVisible(true);
                        break;
                    case 8 : textFieldEmail8.setVisible(true);
                        break;
                    case 9 : textFieldEmail9.setVisible(true);
                        break;
                }
                if(cont>9) {
                    img = c.SetImageSize(".images/warning.png",30,30);
                    JOptionPane.showMessageDialog(null,"LIMITE EMAIL MASSIME RAGGIUNTO!","ATTENZIONE!",1,img);
                    cont--;
                }
                panelCreaContattoScrollPane.setVisible(false);
                panelCreaContattoScrollPane.setVisible(true);
                cont++;
            }
        });

        //INTERAZIONI CON BTNBACKEMAIL
        btnBackEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(cont){
                    case 1 : textFieldEmail0.setVisible(false);
                    textFieldEmail0.setText("");
                        btnBackEmail.setVisible(false);
                        btnAddEmailCanGrow.setVisible(false);
                        btnAddEmail.setVisible(true);
                        break;
                    case 2 : textFieldEmail1.setVisible(false);
                        textFieldEmail1.setText("");
                        break;
                    case 3 : textFieldEmail2.setVisible(false);
                        textFieldEmail2.setText("");
                        break;
                    case 4 : textFieldEmail3.setVisible(false);
                        textFieldEmail3.setText("");
                        break;
                    case 5 : textFieldEmail4.setVisible(false);
                        textFieldEmail4.setText("");
                        break;
                    case 6 : textFieldEmail5.setVisible(false);
                        textFieldEmail5.setText("");
                        break;
                    case 7 : textFieldEmail6.setVisible(false);
                        textFieldEmail6.setText("");
                        break;
                    case 8 : textFieldEmail7.setVisible(false);
                        textFieldEmail7.setText("");
                        break;
                    case 9 : textFieldEmail8.setVisible(false);
                        textFieldEmail8.setText("");
                        break;
                    case 10 : textFieldEmail9.setVisible(false);
                        textFieldEmail9.setText("");
                        break;
                }
                panelCreaContattoScrollPane.setVisible(false);
                panelCreaContattoScrollPane.setVisible(true);
                cont--;
            }
        });
    }


    public static void main(String[] args) throws SQLException{
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //System Look And Feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new Window();
    }
}
