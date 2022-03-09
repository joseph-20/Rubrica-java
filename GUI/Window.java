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
import Model.Email;


public class Window {
    //Dichiarazioni
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
    private JTextField textFieldIndirizzoPrincipale;
    private JLabel lblNumeroFissoCreaContatto;
    private JButton btnAddNumeriFissi;
    private JButton btnAddNumeriFissiCanGrow;
    private JButton btnBackNumeriFissi;
    private JTextField textFieldNumeriFissi0;
    private JTextField textFieldNumeriFissi1;
    private JTextField textFieldNumeriFissi2;
    private JTextField textFieldNumeriFissi3;
    private JTextField textFieldNumeriFissi4;
    private JTextField textFieldNumeriFissi5;
    private JTextField textFieldNumeriFissi6;
    private JTextField textFieldNumeriFissi7;
    private JTextField textFieldNumeriFissi8;
    private JTextField textFieldNumeriFissi9;
    private JLabel lblIndirizzoPrincipaleCreaContatto;
    private JLabel lblNumeriMobiliCreaContatto;
    private JButton btnAddNumeriMobili;
    private JButton btnBackNumeriMobili;
    private JTextField textFieldNumeriMobili0;
    private JTextField textFieldNumeriMobili1;
    private JTextField textFieldNumeriMobili2;
    private JTextField textFieldNumeriMobili3;
    private JTextField textFieldNumeriMobili4;
    private JTextField textFieldNumeriMobili5;
    private JTextField textFieldNumeriMobili6;
    private JTextField textFieldNumeriMobili7;
    private JTextField textFieldNumeriMobili8;
    private JTextField textFieldNumeriMobili9;
    private JTextField textFieldIndirizziSecondari0;
    private JTextField textFieldIndirizziSecondari1;
    private JTextField textFieldIndirizziSecondari2;
    private JTextField textFieldIndirizziSecondari3;
    private JTextField textFieldIndirizziSecondari4;
    private JTextField textFieldIndirizziSecondari5;
    private JTextField textFieldIndirizziSecondari6;
    private JTextField textFieldIndirizziSecondari7;
    private JTextField textFieldIndirizziSecondari8;
    private JTextField textFieldIndirizziSecondari9;
    private JLabel lblIndirizziSecondariCreaContatto;
    private JButton btnAddIndirizziSecondari;
    private JButton btnBackIndirizziSecondari;
    private JButton btnAggiungi;
    private JCheckBox contattoPrivatoCheckBox;
    private JButton btnReindirizzamentiCreaContatto;
    private ImageIcon img;
    private DefaultListCellRenderer renderer;
    private DefaultListModel DlmServizi = new DefaultListModel();
    private JFileChooser jfc = new JFileChooser();
    private File foto;
    private int contEmail = 1;
    private int contNumeriFissi = 1;
    private int contNumeriMobili = 1;
    private int contIndirizziSecondari = 1;
    private Cursor textCursor = new Cursor (Cursor.TEXT_CURSOR);
    private Cursor defaultCursor = new Cursor (Cursor.DEFAULT_CURSOR);
    private ArrayList<String> randImage;
    private ArrayList<String> email = new ArrayList<>();
    private ArrayList<String> prefissoF = new ArrayList<>();
    private ArrayList<String> numeroF = new ArrayList<>();
    private ArrayList<String> prefissoM = new ArrayList<>();
    private ArrayList<String> numeroM = new ArrayList<>();
    private Random rand = new Random();
    private int getpk;

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

        //Settaggio finestra al centro
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        frame.setBounds(center.x - 1280 / 2, center.y - 720 / 2, 1280, 720);

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

        //SETTAGGIO LABEL INIZIALI E ICONE
        lblEmail.setText("<html>Posta Elettronica<br/><html>");
        lblNumeriFissi.setText("<html>Numeri Fissi<br/><html>");
        lblNumeriMobili.setText("<html>Numeri Mobili<br/><html>");
        lblIndirizzoPrincipale.setText("<html>Indirizzo Principale<br/><html>");
        lblIndirizziSecondari.setText("<html>Indirizzi Secondari<br/><html>");

        //ELIMINAZIONE BORDER AUTOMATICO DELLO SCROLL
        infoBottomScroll.setBorder(null);

        //Listener contatto click
        listContatti.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    //Settaggio visibilità dei lblServizi
                    if(c.getServizio("Messenger",pkContatti.get(listContatti.getSelectedIndex())) == null) lblMessenger.setVisible(false);
                    else lblMessenger.setVisible(true);
                    if(c.getServizio("Skype",pkContatti.get(listContatti.getSelectedIndex())) == null) lblSkype.setVisible(false);
                    else lblSkype.setVisible(true);
                    if(c.getServizio("Teams",pkContatti.get(listContatti.getSelectedIndex())) == null) lblTeams.setVisible(false);
                    else lblTeams.setVisible(true);
                    if(c.getServizio("Telegram",pkContatti.get(listContatti.getSelectedIndex())) == null) lblTelegram.setVisible(false);
                    else lblTelegram.setVisible(true);
                    if(c.getServizio("Viber",pkContatti.get(listContatti.getSelectedIndex())) == null) lblViber.setVisible(false);
                    else lblViber.setVisible(true);
                    if(c.getServizio("WeChat",pkContatti.get(listContatti.getSelectedIndex())) == null) lblWeChat.setVisible(false);
                    else lblWeChat.setVisible(true);
                    if(c.getServizio("Whatsapp",pkContatti.get(listContatti.getSelectedIndex())) == null) lblWhatsapp.setVisible(false);
                    else lblWhatsapp.setVisible(true);

                    panelInfoContatti.setVisible(true);
                    c.swapVisibility(panelInfoContattoSinistra,panelCreaContatto);
                    contattiSplitPane.setDividerLocation(350);
                    //SET FOTO
                    if(c.getPath(pkContatti.get(listContatti.getSelectedIndex())) == null) {
                        img = c.SetImageSize(".images/" + randImage.get(rand.nextInt(randImage.size() - 1)), 200, 200);
                        lblFoto.setIcon(img);
                    }else{
                        img = c.SetImageSize(c.getPath(pkContatti.get(listContatti.getSelectedIndex())),200,200);
                        lblFoto.setIcon(img);
                    }
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
        //mouse clicked
        lblMessenger.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    c.setImg(".images/Messenger512x512.png");
                    c.setEmail("Messenger",pkContatti.get(listContatti.getSelectedIndex()));
                    c.setUsername("Messenger",pkContatti.get(listContatti.getSelectedIndex()));
                    c.setStato("Messenger",pkContatti.get(listContatti.getSelectedIndex()));
                    new InfoServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
        //mouse clicked
        lblSkype.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    c.setImg(".images/Skype512x512.png");
                    c.setEmail("Skype",pkContatti.get(listContatti.getSelectedIndex()));
                    c.setUsername("Skype",pkContatti.get(listContatti.getSelectedIndex()));
                    c.setStato("Skype",pkContatti.get(listContatti.getSelectedIndex()));
                    new InfoServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
        //mouse clicked
        lblTeams.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    c.setImg(".images/Teams512x512.png");
                    c.setEmail("Teams",pkContatti.get(listContatti.getSelectedIndex()));
                    c.setUsername("Teams",pkContatti.get(listContatti.getSelectedIndex()));
                    c.setStato("Teams",pkContatti.get(listContatti.getSelectedIndex()));
                    new InfoServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
        //mouse clicked
        lblWeChat.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    c.setImg(".images/WeChat512x512.png");
                    c.setEmail("WeChat",pkContatti.get(listContatti.getSelectedIndex()));
                    c.setUsername("WeChat",pkContatti.get(listContatti.getSelectedIndex()));
                    c.setStato("WeChat",pkContatti.get(listContatti.getSelectedIndex()));
                    new InfoServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
        //mouse clicked
        lblWhatsapp.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    c.setImg(".images/Whatsapp512x512.png");
                    c.setEmail("Whatsapp",pkContatti.get(listContatti.getSelectedIndex()));
                    c.setUsername("Whatsapp",pkContatti.get(listContatti.getSelectedIndex()));
                    c.setStato("Whatsapp",pkContatti.get(listContatti.getSelectedIndex()));
                    new InfoServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
        //mouse clicked
        lblViber.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    c.setImg(".images/Viber512x512.png");
                    c.setEmail("Viber",pkContatti.get(listContatti.getSelectedIndex()));
                    c.setUsername("Viber",pkContatti.get(listContatti.getSelectedIndex()));
                    c.setStato("Viber",pkContatti.get(listContatti.getSelectedIndex()));
                    new InfoServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
        //mouse clicked
        lblTelegram.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    c.setImg(".images/Telegram512x512.png");
                    c.setEmail("Telegram",pkContatti.get(listContatti.getSelectedIndex()));
                    c.setUsername("Telegram",pkContatti.get(listContatti.getSelectedIndex()));
                    c.setStato("Telegram",pkContatti.get(listContatti.getSelectedIndex()));
                    new InfoServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
        //Mouse clicked
        lblMessengerCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                c.setImg(".images/Messenger512x512.png");
                c.setServizioMessaging("Messenger");
                switch(contEmail) {
                    case 1:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        break;
                    case 2:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        break;
                    case 3:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        break;
                    case 4:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        break;
                    case 5:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        break;
                    case 6:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        break;
                    case 7:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        break;
                    case 8:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        break;
                    case 9:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        c.setDlmServizi(textFieldEmail8.getText(),0);
                        break;
                    case 10:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        c.setDlmServizi(textFieldEmail8.getText(),0);
                        c.setDlmServizi(textFieldEmail9.getText(),0);
                        break;
                }
                try {
                    new CreaServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
        //Mouse clicked
        lblSkypeCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                c.setImg(".images/Skype512x512.png");
                c.setServizioMessaging("Skype");
                switch(contEmail) {
                    case 1:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        break;
                    case 2:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        break;
                    case 3:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        break;
                    case 4:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        break;
                    case 5:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        break;
                    case 6:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        break;
                    case 7:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        break;
                    case 8:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        break;
                    case 9:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        c.setDlmServizi(textFieldEmail8.getText(),0);
                        break;
                    case 10:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        c.setDlmServizi(textFieldEmail8.getText(),0);
                        c.setDlmServizi(textFieldEmail9.getText(),0);
                        break;
                }
                try {
                    new CreaServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
        //Mouse clicked
        lblTeamsCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                c.setImg(".images/Teams512x512.png");
                c.setServizioMessaging("Teams");
                switch(contEmail) {
                    case 1:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        break;
                    case 2:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        break;
                    case 3:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        break;
                    case 4:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        break;
                    case 5:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        break;
                    case 6:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        break;
                    case 7:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        break;
                    case 8:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        break;
                    case 9:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        c.setDlmServizi(textFieldEmail8.getText(),0);
                        break;
                    case 10:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        c.setDlmServizi(textFieldEmail8.getText(),0);
                        c.setDlmServizi(textFieldEmail9.getText(),0);
                        break;
                }
                try {
                    new CreaServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
        //Mouse clicked
        lblWeChatCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                c.setImg(".images/WeChat512x512.png");
                c.setServizioMessaging("WeChat");
                switch(contEmail) {
                    case 1:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        break;
                    case 2:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        break;
                    case 3:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        break;
                    case 4:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        break;
                    case 5:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        break;
                    case 6:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        break;
                    case 7:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        break;
                    case 8:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        break;
                    case 9:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        c.setDlmServizi(textFieldEmail8.getText(),0);
                        break;
                    case 10:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        c.setDlmServizi(textFieldEmail8.getText(),0);
                        c.setDlmServizi(textFieldEmail9.getText(),0);
                        break;
                }
                try {
                    new CreaServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
        //Mouse clicked
        lblWhatsappCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                c.setImg(".images/Whatsapp512x512.png");
                c.setServizioMessaging("Whatsapp");
                switch(contEmail) {
                    case 1:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        break;
                    case 2:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        break;
                    case 3:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        break;
                    case 4:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        break;
                    case 5:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        break;
                    case 6:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        break;
                    case 7:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        break;
                    case 8:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        break;
                    case 9:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        c.setDlmServizi(textFieldEmail8.getText(),0);
                        break;
                    case 10:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        c.setDlmServizi(textFieldEmail8.getText(),0);
                        c.setDlmServizi(textFieldEmail9.getText(),0);
                        break;
                }
                try {
                    new CreaServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
        //Mouse clicked
        lblViberCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                c.setImg(".images/Viber512x512.png");
                c.setServizioMessaging("Viber");
                switch(contEmail) {
                    case 1:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        break;
                    case 2:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        break;
                    case 3:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        break;
                    case 4:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        break;
                    case 5:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        break;
                    case 6:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        break;
                    case 7:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        break;
                    case 8:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        break;
                    case 9:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        c.setDlmServizi(textFieldEmail8.getText(),0);
                        break;
                    case 10:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        c.setDlmServizi(textFieldEmail8.getText(),0);
                        c.setDlmServizi(textFieldEmail9.getText(),0);
                        break;
                }
                try {
                    new CreaServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
        //Mouse clicked
        lblTelegramCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                c.setImg(".images/Telegram512x512.png");
                c.setServizioMessaging("Telegram");
                switch(contEmail) {
                    case 1:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        break;
                    case 2:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        break;
                    case 3:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        break;
                    case 4:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        break;
                    case 5:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        break;
                    case 6:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        break;
                    case 7:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        break;
                    case 8:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        break;
                    case 9:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        c.setDlmServizi(textFieldEmail8.getText(),0);
                        break;
                    case 10:
                        c.setDlmServizi(textFieldEmail0.getText(), 1);
                        c.setDlmServizi(textFieldEmail1.getText(), 0);
                        c.setDlmServizi(textFieldEmail2.getText(),0);
                        c.setDlmServizi(textFieldEmail3.getText(),0);
                        c.setDlmServizi(textFieldEmail4.getText(),0);
                        c.setDlmServizi(textFieldEmail5.getText(),0);
                        c.setDlmServizi(textFieldEmail6.getText(),0);
                        c.setDlmServizi(textFieldEmail7.getText(),0);
                        c.setDlmServizi(textFieldEmail8.getText(),0);
                        c.setDlmServizi(textFieldEmail9.getText(),0);
                        break;
                }
                try {
                    new CreaServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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
                        if(c.getPath(pkContatti.get(listContatti.getSelectedIndex()))!=null) {
                            Files.delete(Path.of(c.getPath(pkContatti.get(listContatti.getSelectedIndex()))));
                        }
                        c.cancellaContatto(pkContatti.get(listContatti.getSelectedIndex()));
                        //REFRESH LISTA CONTATTI E RESET DLM
                        panelInfoContatti.setVisible(false);
                        DLMContatti.clear();
                        DLMContatti = c.getContatti(pkContatti);
                        listContatti.setModel(DLMContatti);                                         //Aggiungiamo nel JList i nomi e cognomi dei contatti
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
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
                //swap finestra
                panelInfoContattoSinistra.setVisible(false);
                panelCreaContatto.setVisible(false);
                panelInfoContatti.setVisible(false);

                //Eliminazione presunte mail aggiunte e presunti reindirizzamenti
                try {
                    c.eliminaMessaging(c.getLastId());
                    c.eliminaReindirizzamento(c.getLastId());
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                //Settaggio di tutti i textField a default
                //email
                textFieldNome.setText(null);
                textFieldCognome.setText(null);
                textFieldEmail0.setText(null);
                textFieldEmail1.setText(null);
                textFieldEmail1.setVisible(false);
                textFieldEmail2.setText(null);
                textFieldEmail2.setVisible(false);
                textFieldEmail3.setText(null);
                textFieldEmail3.setVisible(false);
                textFieldEmail4.setText(null);
                textFieldEmail4.setVisible(false);
                textFieldEmail5.setText(null);
                textFieldEmail5.setVisible(false);
                textFieldEmail6.setText(null);
                textFieldEmail6.setVisible(false);
                textFieldEmail7.setText(null);
                textFieldEmail7.setVisible(false);
                textFieldEmail8.setText(null);
                textFieldEmail8.setVisible(false);
                textFieldEmail9.setText(null);
                textFieldEmail9.setVisible(false);
                //numeri fissi
                textFieldNumeriFissi0.setText(null);
                textFieldNumeriFissi1.setText(null);
                textFieldNumeriFissi1.setVisible(false);
                textFieldNumeriFissi2.setText(null);
                textFieldNumeriFissi2.setVisible(false);
                textFieldNumeriFissi3.setText(null);
                textFieldNumeriFissi3.setVisible(false);
                textFieldNumeriFissi4.setText(null);
                textFieldNumeriFissi4.setVisible(false);
                textFieldNumeriFissi5.setText(null);
                textFieldNumeriFissi5.setVisible(false);
                textFieldNumeriFissi6.setText(null);
                textFieldNumeriFissi6.setVisible(false);
                textFieldNumeriFissi7.setText(null);
                textFieldNumeriFissi7.setVisible(false);
                textFieldNumeriFissi8.setText(null);
                textFieldNumeriFissi8.setVisible(false);
                textFieldNumeriFissi9.setText(null);
                textFieldNumeriFissi9.setVisible(false);
                //Numeri mobili
                textFieldNumeriMobili0.setText(null);
                textFieldNumeriMobili1.setText(null);
                textFieldNumeriMobili1.setVisible(false);
                textFieldNumeriMobili2.setText(null);
                textFieldNumeriMobili2.setVisible(false);
                textFieldNumeriMobili3.setText(null);
                textFieldNumeriMobili3.setVisible(false);
                textFieldNumeriMobili4.setText(null);
                textFieldNumeriMobili4.setVisible(false);
                textFieldNumeriMobili5.setText(null);
                textFieldNumeriMobili5.setVisible(false);
                textFieldNumeriMobili6.setText(null);
                textFieldNumeriMobili6.setVisible(false);
                textFieldNumeriMobili7.setText(null);
                textFieldNumeriMobili7.setVisible(false);
                textFieldNumeriMobili8.setText(null);
                textFieldNumeriMobili8.setVisible(false);
                textFieldNumeriMobili9.setText(null);
                textFieldNumeriMobili9.setVisible(false);
                //indirizzo principale
                textFieldIndirizzoPrincipale.setText(null);
                //indirizzi secondari
                textFieldIndirizziSecondari0.setText(null);
                textFieldIndirizziSecondari1.setText(null);
                textFieldIndirizziSecondari1.setVisible(false);
                textFieldIndirizziSecondari2.setText(null);
                textFieldIndirizziSecondari2.setVisible(false);
                textFieldIndirizziSecondari3.setText(null);
                textFieldIndirizziSecondari3.setVisible(false);
                textFieldIndirizziSecondari4.setText(null);
                textFieldIndirizziSecondari4.setVisible(false);
                textFieldIndirizziSecondari5.setText(null);
                textFieldIndirizziSecondari5.setVisible(false);
                textFieldIndirizziSecondari6.setText(null);
                textFieldIndirizziSecondari6.setVisible(false);
                textFieldIndirizziSecondari7.setText(null);
                textFieldIndirizziSecondari7.setVisible(false);
                textFieldIndirizziSecondari8.setText(null);
                textFieldIndirizziSecondari8.setVisible(false);
                textFieldIndirizziSecondari9.setText(null);
                textFieldIndirizziSecondari9.setVisible(false);

                //settaggio contatori
                contEmail = 1;
                contNumeriFissi = 1;
                contNumeriMobili = 1;
                contIndirizziSecondari = 1;

                //Rimozione spunta JCheckBox
                contattoPrivatoCheckBox.setSelected(false);

                //Eliminazione foto inserita
                try {
                    if(Files.exists(Path.of(".images/" + (pkContatti.size() + pkContattiPrivati.size()+2)))) {
                        Files.delete(Path.of(".images/" + (pkContatti.size() + pkContattiPrivati.size() + 2)));
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
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
                    Files.copy(Path.of((foto.getPath())), Path.of((".images/"+(c.getLastId()+1))),StandardCopyOption.REPLACE_EXISTING);
                    img = c.SetImageSize(".images/"+(c.getLastId()+1),200,200);
                    btnAddContact.setIcon(img);
                    //TODO ELIMINA CONTATTO HA GLI STESSI ID
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //INTERAZIONI CON PULSANTE BTNADDEMAIL
        btnAddEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(contEmail){
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
                if(contEmail >9) {
                    img = c.SetImageSize(".images/warning.png",30,30);
                    JOptionPane.showMessageDialog(null,"LIMITE EMAIL MASSIME RAGGIUNTO!","ATTENZIONE!",1,img);
                    contEmail--;
                }
                panelCreaContattoScrollPane.setVisible(false);
                panelCreaContattoScrollPane.setVisible(true);
                contEmail++;
            }
        });


        //INTERAZIONI CON BTNBACKEMAIL
        btnBackEmail.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(contEmail){
                    case 1 : img = c.SetImageSize(".images/warning.png",30,30);
                        JOptionPane.showMessageDialog(null,"NON E' POSSIBILE ELIMINARE ULTERIORI TEXTBOX!","ATTENZIONE!",1,img);
                        contEmail++;
                        break;
                    case 2 : textFieldEmail1.setVisible(false);
                    textFieldEmail1.setText(null);
                        break;
                    case 3 : textFieldEmail2.setVisible(false);
                        textFieldEmail2.setText(null);
                        break;
                    case 4 : textFieldEmail3.setVisible(false);
                        textFieldEmail3.setText(null);
                        break;
                    case 5 : textFieldEmail4.setVisible(false);
                        textFieldEmail4.setText(null);
                        break;
                    case 6 : textFieldEmail5.setVisible(false);
                        textFieldEmail5.setText(null);
                        break;
                    case 7 : textFieldEmail6.setVisible(false);
                        textFieldEmail6.setText(null);
                        break;
                    case 8 : textFieldEmail7.setVisible(false);
                        textFieldEmail7.setText(null);
                        break;
                    case 9 : textFieldEmail8.setVisible(false);
                        textFieldEmail8.setText(null);
                        break;
                    case 10 : textFieldEmail9.setVisible(false);
                        textFieldEmail9.setText(null);
                        break;
                }
                panelCreaContattoScrollPane.setVisible(false);
                panelCreaContattoScrollPane.setVisible(true);
                contEmail--;
            }
        });

        //INTERAZIONI CON PULSANTE BTNADDNUMERIFISSI
        btnAddNumeriFissi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(contNumeriFissi){
                    case 1 : textFieldNumeriFissi1.setVisible(true);
                        break;
                    case 2 : textFieldNumeriFissi2.setVisible(true);
                        break;
                    case 3 : textFieldNumeriFissi3.setVisible(true);
                        break;
                    case 4 : textFieldNumeriFissi4.setVisible(true);
                        break;
                    case 5 : textFieldNumeriFissi5.setVisible(true);
                        break;
                    case 6 : textFieldNumeriFissi6.setVisible(true);
                        break;
                    case 7 : textFieldNumeriFissi7.setVisible(true);
                        break;
                    case 8 : textFieldNumeriFissi8.setVisible(true);
                        break;
                    case 9 : textFieldNumeriFissi9.setVisible(true);
                        break;
                }
                if(contNumeriFissi >9) {
                    img = c.SetImageSize(".images/warning.png",30,30);
                    JOptionPane.showMessageDialog(null,"LIMITE NUMERI FISSI MASSIMI RAGGIUNTO!","ATTENZIONE!",1,img);
                    contNumeriFissi--;
                }
                panelCreaContattoScrollPane.setVisible(false);
                panelCreaContattoScrollPane.setVisible(true);
                contNumeriFissi++;
            }
        });

        //INTERAZIONI CON BTNBACKNUMERIFISSI
        btnBackNumeriFissi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(contNumeriFissi){
                    case 1 : img = c.SetImageSize(".images/warning.png",30,30);
                        JOptionPane.showMessageDialog(null,"NON E' POSSIBILE ELIMINARE ULTERIORI TEXTBOX!","ATTENZIONE!",1,img);
                        contNumeriFissi++;
                        break;
                    case 2 : textFieldNumeriFissi1.setVisible(false);
                        textFieldNumeriFissi1.setText(null);
                        break;
                    case 3 : textFieldNumeriFissi2.setVisible(false);
                        textFieldNumeriFissi2.setText(null);
                        break;
                    case 4 : textFieldNumeriFissi3.setVisible(false);
                        textFieldNumeriFissi3.setText(null);
                        break;
                    case 5 : textFieldNumeriFissi4.setVisible(false);
                        textFieldNumeriFissi4.setText(null);
                        break;
                    case 6 : textFieldNumeriFissi5.setVisible(false);
                        textFieldNumeriFissi5.setText(null);
                        break;
                    case 7 : textFieldNumeriFissi6.setVisible(false);
                        textFieldNumeriFissi6.setText(null);
                        break;
                    case 8 : textFieldNumeriFissi7.setVisible(false);
                        textFieldNumeriFissi7.setText(null);
                        break;
                    case 9 : textFieldNumeriFissi8.setVisible(false);
                        textFieldNumeriFissi8.setText(null);
                        break;
                    case 10 : textFieldNumeriFissi9.setVisible(false);
                        textFieldNumeriFissi9.setText(null);
                        break;
                }
                panelCreaContattoScrollPane.setVisible(false);
                panelCreaContattoScrollPane.setVisible(true);
                contNumeriFissi--;
            }
        });

        //INTERAZIONI CON PULSANTE BTNADDNUMERIMOBILI
        btnAddNumeriMobili.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(contNumeriMobili){
                    case 1 : textFieldNumeriMobili1.setVisible(true);
                        break;
                    case 2 : textFieldNumeriMobili2.setVisible(true);
                        break;
                    case 3 : textFieldNumeriMobili3.setVisible(true);
                        break;
                    case 4 : textFieldNumeriMobili4.setVisible(true);
                        break;
                    case 5 : textFieldNumeriMobili5.setVisible(true);
                        break;
                    case 6 : textFieldNumeriMobili6.setVisible(true);
                        break;
                    case 7 : textFieldNumeriMobili7.setVisible(true);
                        break;
                    case 8 : textFieldNumeriMobili8.setVisible(true);
                        break;
                    case 9 : textFieldNumeriMobili9.setVisible(true);
                        break;
                }
                if(contNumeriMobili >9) {
                    img = c.SetImageSize(".images/warning.png",30,30);
                    JOptionPane.showMessageDialog(null,"LIMITE NUMERI MOBILI MASSIMI RAGGIUNTO!","ATTENZIONE!",1,img);
                    contNumeriMobili--;
                }
                panelCreaContattoScrollPane.setVisible(false);
                panelCreaContattoScrollPane.setVisible(true);
                contNumeriMobili++;
            }
        });

        //INTERAZIONI CON BTNBACKNUMERIMOBILI
        btnBackNumeriMobili.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(contNumeriMobili){
                    case 1 : img = c.SetImageSize(".images/warning.png",30,30);
                        JOptionPane.showMessageDialog(null,"NON E' POSSIBILE ELIMINARE ULTERIORI TEXTBOX!","ATTENZIONE!",1,img);
                        contNumeriMobili++;
                        break;
                    case 2 : textFieldNumeriMobili1.setVisible(false);
                        textFieldNumeriMobili1.setText(null);
                        break;
                    case 3 : textFieldNumeriMobili2.setVisible(false);
                        textFieldNumeriMobili2.setText(null);
                        break;
                    case 4 : textFieldNumeriMobili3.setVisible(false);
                        textFieldNumeriMobili3.setText(null);
                        break;
                    case 5 : textFieldNumeriMobili4.setVisible(false);
                        textFieldNumeriMobili4.setText(null);
                        break;
                    case 6 : textFieldNumeriMobili5.setVisible(false);
                        textFieldNumeriMobili5.setText(null);
                        break;
                    case 7 : textFieldNumeriMobili6.setVisible(false);
                        textFieldNumeriMobili6.setText(null);
                        break;
                    case 8 : textFieldNumeriMobili7.setVisible(false);
                        textFieldNumeriMobili7.setText(null);
                        break;
                    case 9 : textFieldNumeriMobili8.setVisible(false);
                        textFieldNumeriMobili8.setText(null);
                        break;
                    case 10 : textFieldNumeriMobili9.setVisible(false);
                        textFieldNumeriMobili9.setText(null);
                        break;
                }
                panelCreaContattoScrollPane.setVisible(false);
                panelCreaContattoScrollPane.setVisible(true);
                contNumeriMobili--;
            }
        });

        //INTERAZIONI CON BTNBACKINDIRIZZISECONDARI
        btnBackIndirizziSecondari.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(contIndirizziSecondari){
                    case 1 : img = c.SetImageSize(".images/warning.png",30,30);
                        JOptionPane.showMessageDialog(null,"NON E' POSSIBILE ELIMINARE ULTERIORI TEXTBOX!","ATTENZIONE!",1,img);
                        contIndirizziSecondari++;
                        break;
                    case 2 : textFieldIndirizziSecondari1.setVisible(false);
                        textFieldIndirizziSecondari1.setText(null);
                        break;
                    case 3 : textFieldIndirizziSecondari2.setVisible(false);
                        textFieldIndirizziSecondari2.setText(null);
                        break;
                    case 4 : textFieldIndirizziSecondari3.setVisible(false);
                        textFieldIndirizziSecondari3.setText(null);
                        break;
                    case 5 : textFieldIndirizziSecondari4.setVisible(false);
                        textFieldIndirizziSecondari4.setText(null);
                        break;
                    case 6 : textFieldIndirizziSecondari5.setVisible(false);
                        textFieldIndirizziSecondari5.setText(null);
                        break;
                    case 7 : textFieldIndirizziSecondari6.setVisible(false);
                        textFieldIndirizziSecondari6.setText(null);
                        break;
                    case 8 : textFieldIndirizziSecondari7.setVisible(false);
                        textFieldIndirizziSecondari7.setText(null);
                        break;
                    case 9 : textFieldIndirizziSecondari8.setVisible(false);
                        textFieldIndirizziSecondari8.setText(null);
                        break;
                    case 10 : textFieldIndirizziSecondari9.setVisible(false);
                        textFieldIndirizziSecondari9.setText(null);
                        break;
                }
                panelCreaContattoScrollPane.setVisible(false);
                panelCreaContattoScrollPane.setVisible(true);
                contIndirizziSecondari--;
            }
        });

        //INTERAZIONI CON PULSANTE BTNADDINDIRIZZISECONDARI
        btnAddIndirizziSecondari.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(contIndirizziSecondari){
                    case 1 : textFieldIndirizziSecondari1.setVisible(true);
                        break;
                    case 2 : textFieldIndirizziSecondari2.setVisible(true);
                        break;
                    case 3 : textFieldIndirizziSecondari3.setVisible(true);
                        break;
                    case 4 : textFieldIndirizziSecondari4.setVisible(true);
                        break;
                    case 5 : textFieldIndirizziSecondari5.setVisible(true);
                        break;
                    case 6 : textFieldIndirizziSecondari6.setVisible(true);
                        break;
                    case 7 : textFieldIndirizziSecondari7.setVisible(true);
                        break;
                    case 8 : textFieldIndirizziSecondari8.setVisible(true);
                        break;
                    case 9 : textFieldIndirizziSecondari9.setVisible(true);
                        break;
                }
                if(contIndirizziSecondari >9) {
                    img = c.SetImageSize(".images/warning.png",30,30);
                    JOptionPane.showMessageDialog(null,"LIMITE NUMERI MOBILI MASSIMI RAGGIUNTO!","ATTENZIONE!",1,img);
                    contIndirizziSecondari--;
                }
                panelCreaContattoScrollPane.setVisible(false);
                panelCreaContattoScrollPane.setVisible(true);
                contIndirizziSecondari++;
            }
        });

        //SETTAGGIO TEXT CURSOR NEL TEXTFIELD NOME
        textFieldNome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });

        //SETTAGGIO TEXT CURSOR NEI TEXTFIELD COGNOME
        textFieldCognome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldCognome.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });

        //SETTAGGIO TEXT CURSOR NEI TEXTFIELD EMAIL
        textFieldEmail0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldEmail0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldEmail1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldEmail1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldEmail2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldEmail2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldEmail3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldEmail3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldEmail4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldEmail4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldEmail5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldEmail5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldEmail6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldEmail6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldEmail7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldEmail7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldEmail8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldEmail8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldEmail9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldEmail9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });

        //SETTAGGIO TEXT CURSOR NEI TEXTFIELD NUMERI FISSI
        textFieldNumeriFissi0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriFissi0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriFissi1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriFissi1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriFissi2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriFissi2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriFissi3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriFissi3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriFissi4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriFissi4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriFissi5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriFissi5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriFissi6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriFissi6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriFissi7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriFissi7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriFissi8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriFissi8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriFissi9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriFissi9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });

        //SETTAGGIO TEXT CURSOR NEI TEXTFIELD NUMERI MOBILI
        textFieldNumeriMobili0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriMobili0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriMobili1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriMobili1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriMobili2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriMobili2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriMobili3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriMobili3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriMobili4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriMobili4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriMobili5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriMobili5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriMobili6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriMobili6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriMobili7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriMobili7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriMobili8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriMobili8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldNumeriMobili9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldNumeriMobili9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });

        //SETTAGGIO TEXT CURSOR NEI TEXTFIELD INDIRIZZO PRINCIPALE
        textFieldIndirizzoPrincipale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldIndirizzoPrincipale.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });

        //SETTAGGIO TEXT CURSOR NEI TEXTFIELD NUMERI MOBILI
        textFieldIndirizziSecondari0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldIndirizziSecondari0.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldIndirizziSecondari1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldIndirizziSecondari1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldIndirizziSecondari2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldIndirizziSecondari2.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldIndirizziSecondari3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldIndirizziSecondari3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldIndirizziSecondari4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldIndirizziSecondari4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldIndirizziSecondari5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldIndirizziSecondari5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldIndirizziSecondari6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldIndirizziSecondari6.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldIndirizziSecondari7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldIndirizziSecondari7.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldIndirizziSecondari8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldIndirizziSecondari8.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });
        textFieldIndirizziSecondari9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldIndirizziSecondari9.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });

        //INTERAZIONI BTNAGGIUNGI IN CREA CONTATTO
        btnAggiungi.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                //SE NON E' STATO INSERITO UN NOME AL CONTATTO NON CONTINUARE
                if (textFieldNome.getText().equals("")) {
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "NON E' STATO INSERITO UN NOME PER IL CONTATTO!", "ATTENZIONE!", 1, img);
                }
                //SE NON E' STATO INSERITO UN COGNOME AL CONTATTO NON CONTINUARE
                else if(textFieldCognome.getText().equals("")){
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "NON E' STATO INSERITO UN COGNOME PER IL CONTATTO!", "ATTENZIONE!", 1, img);
                }
                //SE NON E' STATO INSERITO UN INDIRIZZO PRINCIPALE AL CONTATTO NON CONTINUARE
                else if(textFieldIndirizzoPrincipale.getText().equals("")){
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "NON E' STATO INSERITO UN INDIRIZZO PRINCIPALE PER IL CONTATTO!", "ATTENZIONE!", 1, img);
                }else{
                    try {
                        //QUERY CREA CONTATTO
                        if (jfc.getSelectedFile() == null) {
                            getpk = c.creaContatto("null", textFieldNome.getText(), textFieldCognome.getText(), contattoPrivatoCheckBox.isSelected());
                        } else {
                            getpk = c.creaContatto("'C:/Users/39366/IdeaProjects/Rubrica-java/.images/" + (c.getLastId()+1)+"'", textFieldNome.getText(), textFieldCognome.getText(), contattoPrivatoCheckBox.isSelected());
                        }
                        //QUERY CREA EMAIL
                        email.clear();
                        if(contEmail==1 && !textFieldEmail0.getText().equals("")) {
                            email.add(textFieldEmail0.getText());
                            c.creaEmail(email, getpk, 1);
                        }
                            switch(contEmail){
                            case 2 :
                                email.add(textFieldEmail0.getText());
                                email.add(textFieldEmail1.getText());
                                 c.creaEmail(email,getpk,2);
                            break;
                            case 3 :
                                email.add(textFieldEmail0.getText());
                                email.add(textFieldEmail1.getText());
                                email.add(textFieldEmail2.getText());
                                 c.creaEmail(email,getpk,3);
                            break;
                            case 4 :
                                email.add(textFieldEmail0.getText());
                                email.add(textFieldEmail1.getText());
                                email.add(textFieldEmail2.getText());
                                email.add(textFieldEmail3.getText());
                            c.creaEmail(email,getpk,4);
                            break;
                            case 5:
                                email.add(textFieldEmail0.getText());
                                email.add(textFieldEmail1.getText());
                                email.add(textFieldEmail2.getText());
                                email.add(textFieldEmail3.getText());
                                email.add(textFieldEmail4.getText());
                                c.creaEmail(email,getpk,5);
                            break;
                            case 6 :
                                email.add(textFieldEmail0.getText());
                                email.add(textFieldEmail1.getText());
                                email.add(textFieldEmail2.getText());
                                email.add(textFieldEmail3.getText());
                                email.add(textFieldEmail4.getText());
                                email.add(textFieldEmail5.getText());
                                c.creaEmail(email,getpk,6);
                            break;
                             case 7 :
                                 email.add(textFieldEmail0.getText());
                                 email.add(textFieldEmail1.getText());
                                 email.add(textFieldEmail2.getText());
                                 email.add(textFieldEmail3.getText());
                                 email.add(textFieldEmail4.getText());
                                 email.add(textFieldEmail5.getText());
                                 email.add(textFieldEmail6.getText());
                            c.creaEmail(email,getpk,7);
                            break;
                            case 8 :
                                email.add(textFieldEmail0.getText());
                                email.add(textFieldEmail1.getText());
                                email.add(textFieldEmail2.getText());
                                email.add(textFieldEmail3.getText());
                                email.add(textFieldEmail4.getText());
                                email.add(textFieldEmail5.getText());
                                email.add(textFieldEmail6.getText());
                                email.add(textFieldEmail7.getText());
                                c.creaEmail(email,getpk,8);
                            break;
                            case 9 :
                                email.add(textFieldEmail0.getText());
                                email.add(textFieldEmail1.getText());
                                email.add(textFieldEmail2.getText());
                                email.add(textFieldEmail3.getText());
                                email.add(textFieldEmail4.getText());
                                email.add(textFieldEmail5.getText());
                                email.add(textFieldEmail6.getText());
                                email.add(textFieldEmail7.getText());
                                email.add(textFieldEmail8.getText());
                            c.creaEmail(email,getpk,9);
                            break;
                             case 10 :
                                 email.add(textFieldEmail0.getText());
                                 email.add(textFieldEmail1.getText());
                                 email.add(textFieldEmail2.getText());
                                 email.add(textFieldEmail3.getText());
                                 email.add(textFieldEmail4.getText());
                                 email.add(textFieldEmail5.getText());
                                 email.add(textFieldEmail6.getText());
                                 email.add(textFieldEmail7.getText());
                                 email.add(textFieldEmail8.getText());
                                 email.add(textFieldEmail9.getText());
                            c.creaEmail(email,getpk,10);
                            break;
                        }

                        //QUERY CREA NUMERI FISSI
                        prefissoF.clear();
                        numeroF.clear();
                        if(contNumeriFissi==1 && !textFieldNumeriFissi0.getText().equals("")){
                            prefissoF.add(textFieldNumeriFissi0.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi0.getText().substring(3));
                            c.creaNumeriFissi(prefissoF,numeroF,getpk,1);
                        }
                            switch(contNumeriFissi){
                             case 2 :
                            prefissoF.add(textFieldNumeriFissi0.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi0.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi1.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi1.getText().substring(3));
                            c.creaNumeriFissi(prefissoF,numeroF,getpk,2);
                            break;
                             case 3 :
                            prefissoF.add(textFieldNumeriFissi0.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi0.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi1.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi1.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi2.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi2.getText().substring(3));
                            c.creaNumeriFissi(prefissoF,numeroF,getpk,3);
                            break;
                            case 4 :
                            prefissoF.add(textFieldNumeriFissi0.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi0.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi1.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi1.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi2.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi2.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi3.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi3.getText().substring(3));
                            c.creaNumeriFissi(prefissoF,numeroF,getpk,4);
                            break;
                            case 5 :
                            prefissoF.add(textFieldNumeriFissi0.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi0.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi1.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi1.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi2.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi2.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi3.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi3.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi4.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi4.getText().substring(3));
                            c.creaNumeriFissi(prefissoF,numeroF,getpk,5);
                            break;
                            case 6 :
                            prefissoF.add(textFieldNumeriFissi0.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi0.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi1.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi1.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi2.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi2.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi3.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi3.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi4.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi4.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi5.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi5.getText().substring(3));
                            c.creaNumeriFissi(prefissoF,numeroF,getpk,6);
                            break;
                            case 7 :
                            prefissoF.add(textFieldNumeriFissi0.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi0.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi1.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi1.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi2.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi2.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi3.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi3.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi4.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi4.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi5.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi5.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi6.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi6.getText().substring(3));
                            c.creaNumeriFissi(prefissoF,numeroF,getpk,7);
                            break;
                            case 8 :
                            prefissoF.add(textFieldNumeriFissi0.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi0.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi1.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi1.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi2.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi2.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi3.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi3.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi4.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi4.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi5.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi5.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi6.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi6.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi7.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi7.getText().substring(3));
                            c.creaNumeriFissi(prefissoF,numeroF,getpk,8);
                            break;
                            case 9 :
                            prefissoF.add(textFieldNumeriFissi0.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi0.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi1.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi1.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi2.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi2.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi3.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi3.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi4.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi4.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi5.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi5.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi6.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi6.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi7.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi7.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi8.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi8.getText().substring(3));
                            c.creaNumeriFissi(prefissoF,numeroF,getpk,9);
                            break;
                            case 10 :
                            prefissoF.add(textFieldNumeriFissi0.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi0.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi1.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi1.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi2.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi2.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi3.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi3.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi4.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi4.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi5.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi5.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi6.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi6.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi7.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi7.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi8.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi8.getText().substring(3));
                            prefissoF.add(textFieldNumeriFissi9.getText().substring(0,3));
                            numeroF.add(textFieldNumeriFissi9.getText().substring(3));
                            c.creaNumeriFissi(prefissoF,numeroF,getpk,10);
                            break;
                        }

                        //QUERY CREA NUMERI MOBILI
                        prefissoM.clear();
                        numeroM.clear();
                        if(contNumeriMobili==1 && !textFieldNumeriMobili0.getText().equals("")){
                            prefissoM.add(textFieldNumeriMobili0.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili0.getText().substring(3));
                            c.creaNumeriMobili(prefissoM,numeroM,getpk,1);
                        }
                        switch(contNumeriMobili){
                            case 2 :
                            prefissoM.add(textFieldNumeriMobili0.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili0.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili1.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili1.getText().substring(3));
                            c.creaNumeriMobili(prefissoM,numeroM,getpk,2);
                            break;
                             case 3 :
                            prefissoF.add(textFieldNumeriMobili0.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili0.getText().substring(3));
                            prefissoF.add(textFieldNumeriMobili1.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili1.getText().substring(3));
                            prefissoF.add(textFieldNumeriMobili2.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili2.getText().substring(3));
                            c.creaNumeriMobili(prefissoM,numeroM,getpk,3);
                            break;
                            case 4 :
                            prefissoM.add(textFieldNumeriMobili0.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili0.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili1.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili1.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili2.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili2.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili3.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili3.getText().substring(3));
                            c.creaNumeriMobili(prefissoM,numeroM,getpk,4);
                            case 5 :
                            prefissoM.add(textFieldNumeriMobili0.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili0.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili1.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili1.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili2.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili2.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili3.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili3.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili4.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili4.getText().substring(3));
                            c.creaNumeriMobili(prefissoM,numeroM,getpk,5);
                            case 6 :
                            prefissoM.add(textFieldNumeriMobili0.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili0.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili1.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili1.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili2.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili2.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili3.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili3.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili4.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili4.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili5.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili5.getText().substring(3));
                            c.creaNumeriMobili(prefissoM,numeroM,getpk,6);
                             case 7 :
                            prefissoM.add(textFieldNumeriMobili0.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili0.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili1.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili1.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili2.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili2.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili3.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili3.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili4.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili4.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili5.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili5.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili6.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili6.getText().substring(3));
                            c.creaNumeriMobili(prefissoM,numeroM,getpk,7);
                            case 8 :
                            prefissoM.add(textFieldNumeriMobili0.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili0.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili1.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili1.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili2.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili2.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili3.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili3.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili4.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili4.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili5.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili5.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili6.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili6.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili7.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili7.getText().substring(3));
                            c.creaNumeriMobili(prefissoM,numeroM,getpk,8);
                            case 9 :
                            prefissoM.add(textFieldNumeriMobili0.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili0.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili1.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili1.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili2.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili2.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili3.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili3.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili4.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili4.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili5.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili5.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili6.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili6.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili7.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili7.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili8.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili8.getText().substring(3));
                            c.creaNumeriMobili(prefissoM,numeroM,getpk,9);
                            case 10 :
                            prefissoM.add(textFieldNumeriMobili0.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili0.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili1.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili1.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili2.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili2.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili3.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili3.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili4.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili4.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili5.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili5.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili6.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili6.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili7.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili7.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili8.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili8.getText().substring(3));
                            prefissoM.add(textFieldNumeriMobili9.getText().substring(0,3));
                            numeroM.add(textFieldNumeriMobili9.getText().substring(3));
                            c.creaNumeriMobili(prefissoM,numeroM,getpk,10);
                        }

                        //QUERY CREA INDIRIZZO PRINCIPALE
                        c.creaIndirizzoPrincipale(textFieldIndirizzoPrincipale.getText(),getpk);

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    //Refresh dlm contatti
                    DLMContatti.clear();
                    try {
                        DLMContatti = c.getContatti(pkContatti);
                        listContatti.setModel(DLMContatti);                                         //Aggiungiamo nel JList i nomi e cognomi dei contatti
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    //Chiusura pannello creazione contatto
                    panelInfoContatti.setVisible(false);

                    //MESSAGGIO DI CONFERMA CREAZIONE CONTATTO
                    img = c.SetImageSize(".images/creazionecontatto.png", 30, 30);
                    JOptionPane.showMessageDialog(null, textFieldNome.getText() + " " + textFieldCognome.getText() + " aggiunto/a con successo!", "CREAZIONE RIUSCITA!", 1, img);

                    //Settaggio di tutti i textField a default
                    //email
                    textFieldNome.setText(null);
                    textFieldCognome.setText(null);
                    textFieldEmail0.setText(null);
                    textFieldEmail1.setText(null);
                    textFieldEmail1.setVisible(false);
                    textFieldEmail2.setText(null);
                    textFieldEmail2.setVisible(false);
                    textFieldEmail3.setText(null);
                    textFieldEmail3.setVisible(false);
                    textFieldEmail4.setText(null);
                    textFieldEmail4.setVisible(false);
                    textFieldEmail5.setText(null);
                    textFieldEmail5.setVisible(false);
                    textFieldEmail6.setText(null);
                    textFieldEmail6.setVisible(false);
                    textFieldEmail7.setText(null);
                    textFieldEmail7.setVisible(false);
                    textFieldEmail8.setText(null);
                    textFieldEmail8.setVisible(false);
                    textFieldEmail9.setText(null);
                    textFieldEmail9.setVisible(false);
                    //numeri fissi
                    textFieldNumeriFissi0.setText(null);
                    textFieldNumeriFissi1.setText(null);
                    textFieldNumeriFissi1.setVisible(false);
                    textFieldNumeriFissi2.setText(null);
                    textFieldNumeriFissi2.setVisible(false);
                    textFieldNumeriFissi3.setText(null);
                    textFieldNumeriFissi3.setVisible(false);
                    textFieldNumeriFissi4.setText(null);
                    textFieldNumeriFissi4.setVisible(false);
                    textFieldNumeriFissi5.setText(null);
                    textFieldNumeriFissi5.setVisible(false);
                    textFieldNumeriFissi6.setText(null);
                    textFieldNumeriFissi6.setVisible(false);
                    textFieldNumeriFissi7.setText(null);
                    textFieldNumeriFissi7.setVisible(false);
                    textFieldNumeriFissi8.setText(null);
                    textFieldNumeriFissi8.setVisible(false);
                    textFieldNumeriFissi9.setText(null);
                    textFieldNumeriFissi9.setVisible(false);
                    //Numeri mobili
                    textFieldNumeriMobili0.setText(null);
                    textFieldNumeriMobili1.setText(null);
                    textFieldNumeriMobili1.setVisible(false);
                    textFieldNumeriMobili2.setText(null);
                    textFieldNumeriMobili2.setVisible(false);
                    textFieldNumeriMobili3.setText(null);
                    textFieldNumeriMobili3.setVisible(false);
                    textFieldNumeriMobili4.setText(null);
                    textFieldNumeriMobili4.setVisible(false);
                    textFieldNumeriMobili5.setText(null);
                    textFieldNumeriMobili5.setVisible(false);
                    textFieldNumeriMobili6.setText(null);
                    textFieldNumeriMobili6.setVisible(false);
                    textFieldNumeriMobili7.setText(null);
                    textFieldNumeriMobili7.setVisible(false);
                    textFieldNumeriMobili8.setText(null);
                    textFieldNumeriMobili8.setVisible(false);
                    textFieldNumeriMobili9.setText(null);
                    textFieldNumeriMobili9.setVisible(false);
                    //indirizzo principale
                    textFieldIndirizzoPrincipale.setText(null);
                    //indirizzi secondari
                    textFieldIndirizziSecondari0.setText(null);
                    textFieldIndirizziSecondari1.setText(null);
                    textFieldIndirizziSecondari1.setVisible(false);
                    textFieldIndirizziSecondari2.setText(null);
                    textFieldIndirizziSecondari2.setVisible(false);
                    textFieldIndirizziSecondari3.setText(null);
                    textFieldIndirizziSecondari3.setVisible(false);
                    textFieldIndirizziSecondari4.setText(null);
                    textFieldIndirizziSecondari4.setVisible(false);
                    textFieldIndirizziSecondari5.setText(null);
                    textFieldIndirizziSecondari5.setVisible(false);
                    textFieldIndirizziSecondari6.setText(null);
                    textFieldIndirizziSecondari6.setVisible(false);
                    textFieldIndirizziSecondari7.setText(null);
                    textFieldIndirizziSecondari7.setVisible(false);
                    textFieldIndirizziSecondari8.setText(null);
                    textFieldIndirizziSecondari8.setVisible(false);
                    textFieldIndirizziSecondari9.setText(null);
                    textFieldIndirizziSecondari9.setVisible(false);

                    //settaggio contatori
                    contEmail = 1;
                    contNumeriFissi = 1;
                    contNumeriMobili = 1;
                    contIndirizziSecondari = 1;

                    //Rimozione spunta JCheckBox
                    contattoPrivatoCheckBox.setSelected(false);
                }
            }
        });

        //Interazione click CreaReindirizzamenti
        btnReindirizzamentiCreaContatto.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                switch(contNumeriFissi) {
                    case 1:
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                        break;
                    case 2:
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                        break;
                    case 3:
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(),0);
                        break;
                    case 4:
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi3.getText(),0);
                        break;
                    case 5:
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi3.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi4.getText(),0);
                        break;
                    case 6:
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi3.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi4.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi5.getText(),0);
                        break;
                    case 7:
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi3.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi4.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi5.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi6.getText(),0);
                        break;
                    case 8:
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi3.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi4.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi5.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi6.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi7.getText(),0);
                        break;
                    case 9:
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi3.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi4.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi5.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi6.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi7.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi8.getText(),0);
                        break;
                    case 10:
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi3.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi4.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi5.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi6.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi7.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi8.getText(),0);
                        c.setDlmReindirizzamentiFissi(textFieldNumeriFissi9.getText(),0);
                        break;
                }
                switch(contNumeriMobili) {
                    case 1:
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                        break;
                    case 2:
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                        break;
                    case 3:
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(),0);
                        break;
                    case 4:
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili3.getText(),0);
                        break;
                    case 5:
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili3.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili4.getText(),0);
                        break;
                    case 6:
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili3.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili4.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili5.getText(),0);
                        break;
                    case 7:
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili3.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili4.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili5.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili6.getText(),0);
                        break;
                    case 8:
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili3.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili4.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili5.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili6.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili7.getText(),0);
                        break;
                    case 9:
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili3.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili4.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili5.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili6.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili7.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili8.getText(),0);
                        break;
                    case 10:
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili3.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili4.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili5.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili6.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili7.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili8.getText(),0);
                        c.setDlmReindirizzamentiMobili(textFieldNumeriMobili9.getText(),0);
                        break;
                }
                try {
                    new CreaReindirizzamento(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Set interazioni reindirizzamenti in infoContatto
        btnReindirizzamenti.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    c.setReindirizzamenti(pkContatti.get(listContatti.getSelectedIndex()));
                    if(c.getReindirizzamenti()==null){
                        img = c.SetImageSize(".images/warning.png",30,30);
                        JOptionPane.showMessageDialog(null,"NON VI SONO REINDIRIZZAMENTI PER QUESTO CONTATTO!","ATTENZIONE!",1,img);
                    }else new InfoReindirizzamento(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
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

//TODO SE METTE PIU TEXTFIELD LI DEVE PER FORZA SCRIVERE ALTRIMENTI NON DEVE FUNZIONARE

//TODO IMPEDIRE DI CREARE SERVIZI O REINDIRIZZAMENTI CON CAMPI VUOTI