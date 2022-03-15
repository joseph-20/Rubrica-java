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
import java.util.Random;

import Controller.Controller;


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
    private JPanel panelinfoContattiPrivati;
    private JPanel paneInfoContattiPrivatiBottom;
    private JPanel panelInfoConattiPrivatiMid;
    private JPanel panelServiziPrivati;
    private JPanel panelInfoContattiPrivatiTop;
    private JButton btnReindirizzamentiPrivati;
    private JButton btnEliminaPrivati;
    private JLabel lblEmailPrivati;
    private JLabel lblInfoEmailPrivati;
    private JLabel lblInfoNumeriFissiPrivati;
    private JLabel lblNumeriFissiPrivati;
    private JLabel lblNumeriMobiliPrivati;
    private JLabel lblInfoNumeriMobiliPrivati;
    private JLabel lblIndirizzoPrincipalePrivati;
    private JLabel lblInfoIndirizzoPrincipalePrivati;
    private JLabel lblIndirizziSecondariPrivati;
    private JLabel lblInfoIndirizziSecondariPrivati;
    private JScrollPane infoContattiPrivatiScroll;
    private JPanel panelInfoContattiPrivatiScroll;
    private JPanel panelServiziPrivatiMid;
    private JPanel panelServiziPrivatiCenter;
    private JLabel lblMessengerPrivati;
    private JLabel lblSkypePrivati;
    private JLabel lblTeamsPrivati;
    private JLabel lblTelegramPrivati;
    private JLabel lblViberPrivati;
    private JLabel lblWeChatPrivati;
    private JLabel lblWhatsappPrivati;
    private JLabel lblNomePrivati;
    private JLabel lblCognomePrivati;
    private JLabel lblFotoPrivati;
    private JButton btnModifica;
    private JButton btnReindirizzamentiModifica;
    private JButton btnAggiornaModifica;
    private JTextField textFieldSearch;
    private JPanel panelSearch;
    private JButton btnSearch;
    private JTextField textFieldSearchPrivati;
    private JButton btnSearchPrivati;
    private JPanel panelSearchPrivati;
    private JButton btnBackPrivati;
    private JButton btnBack;
    private String password = "";
    private JComboBox comboBoxRicerca;
    private JComboBox comboBoxRicercaPrivati;
    private JButton btnModificaPrivati;
    private ImageIcon img;
    private DefaultListCellRenderer renderer;
    private DefaultListModel DlmServizi = new DefaultListModel();
    private JFileChooser jfc = new JFileChooser();
    private File foto;
    private File file;
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
    private ArrayList<String> getStrings = new ArrayList<>();
    private Random rand = new Random();
    private JPasswordField pwd = new JPasswordField(30);
    private int action;
    private int getpk;
    private int lastSelect=0;

    public Window() throws SQLException{
        Controller c = new Controller();
        run(c);
        btnReindirizzamentiPrivati.addMouseListener(new MouseAdapter() {
        });
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
        img = c.SetImageSize(".images/rubrica.png",512,512);
        frame.setIconImage(img.getImage());


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
        infoContattiPrivatiScroll.setBorder(null);
        InfoContattiPrivata.setVisible(false);


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
        lblEmailPrivati.setText("<html>Posta Elettronica<br/><html>");
        lblNumeriFissiPrivati.setText("<html>Numeri Fissi<br/><html>");
        lblNumeriMobiliPrivati.setText("<html>Numeri Mobili<br/><html>");
        lblIndirizzoPrincipalePrivati.setText("<html>Indirizzo Principale<br/><html>");
        lblIndirizziSecondariPrivati.setText("<html>Indirizzi Secondari<br/><html>");
        img = c.SetImageSize(".images/search.png",30,30);
        btnSearch.setIcon(img);
        btnSearchPrivati.setIcon(img);
        img = c.SetImageSize(".images/close.png",30,30);
        btnBack.setIcon(img);
        btnBackPrivati.setIcon(img);
        img = c.SetImageSize(".images/key.png", 30, 30);
        Tabs.setIconAt(3,img);
        c.setJTabs(Tabs);

        //ELIMINAZIONE BORDER AUTOMATICO DELLO SCROLL
        infoBottomScroll.setBorder(null);

        //INTERAZIONI BTNBACK
        btnBack.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                panelInfoContatti.setVisible(false);
            }
        });

        //INTERAZIONI BTNBACKPRIVATI
        btnBackPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                InfoContattiPrivata.setVisible(false);
            }
        });

        //Interazione click area privata
        Tabs.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    if(Tabs.getSelectedIndex()==0){
                        InfoContattiPrivata.setVisible(false);
                        lastSelect=0;
                        c.setLastInt(lastSelect);
                    }
                    else if(Tabs.getSelectedIndex()==1){
                        panelInfoContatti.setVisible(false);
                        InfoContattiPrivata.setVisible(false);
                        lastSelect=1;
                        c.setLastInt(lastSelect);
                    }
                    else if(Tabs.getSelectedIndex()==2 && c.getPassword() == null){
                        try {
                            panelInfoContatti.setVisible(false);
                            new CreaPassword(c);
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                        }
                    }else if (Tabs.getSelectedIndex()==2){
                        panelInfoContatti.setVisible(false);
                        c.setPanel(InfoContattiPrivata);
                        new InserisciPassword(c);
                    }
                    else if (Tabs.getSelectedIndex()==3){
                        if(c.getPassword()==null){
                            Tabs.setSelectedIndex(lastSelect);
                            new CreaPassword(c);
                        }else{
                            Tabs.setSelectedIndex(lastSelect);
                            new AggiornaPassword(c);
                        }
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Listener contatto click
        listContatti.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);

                panelInfoContatti.setVisible(true);
                c.swapVisibility(panelInfoContattoSinistra,panelCreaContatto);
                contattiSplitPane.setDividerLocation(350);
                frame.validate();
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

        //Interazioni btnSearch
        btnSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                panelInfoContatti.setVisible(false);
                DLMContatti.clear();
                try {
                    if(comboBoxRicerca.getSelectedItem().toString().equals("NOME")) {
                        DLMContatti.removeAllElements();
                        DLMContatti = c.getContattiSearch(textFieldSearch.getText(), pkContatti);
                    }
                    else if(comboBoxRicerca.getSelectedItem().toString().equals("EMAIL")){
                        DLMContatti.removeAllElements();
                        DLMContatti = c.getContattiSearchEmail(textFieldSearch.getText(), pkContatti);
                    }
                    else if(comboBoxRicerca.getSelectedItem().toString().equals("ACCOUNT")){
                        DLMContatti.removeAllElements();
                        DLMContatti = c.getContattiSearchUsername(textFieldSearch.getText(),pkContatti);
                    }
                    else if(comboBoxRicerca.getSelectedItem().toString().equals("NUMERO FISSO")){
                        DLMContatti.removeAllElements();
                        DLMContatti = c.getContattiSearchNumeriFissi(textFieldSearch.getText(),pkContatti);
                    }
                    else if(comboBoxRicerca.getSelectedItem().toString().equals("NUMERO MOBILE")){
                        DLMContatti.removeAllElements();
                        DLMContatti = c.getContattiSearchNumeriMobili(textFieldSearch.getText(),pkContatti);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                listContatti.setModel(DLMContatti);
            }
        });


        //Interazioni btnSearchPrivati
        btnSearchPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                InfoContattiPrivata.setVisible(false);
                DLMContattiPrivati.clear();
                try {
                    if(comboBoxRicerca.getSelectedItem().toString().equals("NOME")) {
                        DLMContattiPrivati.removeAllElements();
                        DLMContattiPrivati = c.getContattiSearchPrivati(textFieldSearchPrivati.getText(), pkContattiPrivati);
                    }
                    else if(comboBoxRicerca.getSelectedItem().toString().equals("EMAIL")){
                        DLMContattiPrivati.removeAllElements();
                        DLMContattiPrivati = c.getContattiSearchEmailPrivati(textFieldSearchPrivati.getText(), pkContattiPrivati);
                    }
                    else if(comboBoxRicerca.getSelectedItem().toString().equals("ACCOUNT")){
                        DLMContattiPrivati.removeAllElements();
                        DLMContattiPrivati = c.getContattiSearchUsernamePrivati(textFieldSearchPrivati.getText(),pkContattiPrivati);
                    }
                    else if(comboBoxRicerca.getSelectedItem().toString().equals("NUMERO FISSO")){
                        DLMContattiPrivati.removeAllElements();
                        DLMContattiPrivati = c.getContattiSearchNumeriFissiPrivati(textFieldSearchPrivati.getText(),pkContattiPrivati);
                    }
                    else if(comboBoxRicerca.getSelectedItem().toString().equals("NUMERO MOBILE")){
                        DLMContattiPrivati.removeAllElements();
                        DLMContattiPrivati = c.getContattiSearchNumeriMobiliPrivati(textFieldSearchPrivati.getText(),pkContattiPrivati);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
                listAreaPrivata.setModel(DLMContattiPrivati);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (textFieldEmail0.getText().equals("")) {
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "Bisogna inserire almeno una mail per registrare un sistema di messaging!", "ATTENZIONE!", 2, img);
                } else {
                    c.setImg(".images/Messenger512x512.png");
                    c.setServizioMessaging("Messenger");
                    switch (contEmail) {
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
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            break;
                        case 4:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            break;
                        case 5:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            break;
                        case 6:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            break;
                        case 7:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            break;
                        case 8:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            break;
                        case 9:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            c.setDlmServizi(textFieldEmail8.getText(), 0);
                            break;
                        case 10:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            c.setDlmServizi(textFieldEmail8.getText(), 0);
                            c.setDlmServizi(textFieldEmail9.getText(), 0);
                            break;
                    }
                    try {
                        new CreaServizio(c);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (textFieldEmail0.getText().equals("")) {
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "Bisogna inserire almeno una mail per registrare un sistema di messaging!", "ATTENZIONE!", 2, img);
                } else {
                    c.setImg(".images/Skype512x512.png");
                    c.setServizioMessaging("Skype");
                    switch (contEmail) {
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
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            break;
                        case 4:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            break;
                        case 5:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            break;
                        case 6:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            break;
                        case 7:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            break;
                        case 8:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            break;
                        case 9:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            c.setDlmServizi(textFieldEmail8.getText(), 0);
                            break;
                        case 10:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            c.setDlmServizi(textFieldEmail8.getText(), 0);
                            c.setDlmServizi(textFieldEmail9.getText(), 0);
                            break;
                    }
                    try {
                        new CreaServizio(c);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (textFieldEmail0.getText().equals("")) {
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "Bisogna inserire almeno una mail per registrare un sistema di messaging!", "ATTENZIONE!", 2, img);
                } else {
                    c.setImg(".images/Teams512x512.png");
                    c.setServizioMessaging("Teams");
                    switch (contEmail) {
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
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            break;
                        case 4:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            break;
                        case 5:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            break;
                        case 6:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            break;
                        case 7:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            break;
                        case 8:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            break;
                        case 9:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            c.setDlmServizi(textFieldEmail8.getText(), 0);
                            break;
                        case 10:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            c.setDlmServizi(textFieldEmail8.getText(), 0);
                            c.setDlmServizi(textFieldEmail9.getText(), 0);
                            break;
                    }
                    try {
                        new CreaServizio(c);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (textFieldEmail0.getText().equals("")) {
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "Bisogna inserire almeno una mail per registrare un sistema di messaging!", "ATTENZIONE!", 2, img);
                } else {
                    c.setImg(".images/WeChat512x512.png");
                    c.setServizioMessaging("WeChat");
                    switch (contEmail) {
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
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            break;
                        case 4:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            break;
                        case 5:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            break;
                        case 6:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            break;
                        case 7:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            break;
                        case 8:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            break;
                        case 9:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            c.setDlmServizi(textFieldEmail8.getText(), 0);
                            break;
                        case 10:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            c.setDlmServizi(textFieldEmail8.getText(), 0);
                            c.setDlmServizi(textFieldEmail9.getText(), 0);
                            break;
                    }
                    try {
                        new CreaServizio(c);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (textFieldEmail0.getText().equals("")) {
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "Bisogna inserire almeno una mail per registrare un sistema di messaging!", "ATTENZIONE!", 2, img);
                } else {
                    c.setImg(".images/Whatsapp512x512.png");
                    c.setServizioMessaging("Whatsapp");
                    switch (contEmail) {
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
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            break;
                        case 4:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            break;
                        case 5:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            break;
                        case 6:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            break;
                        case 7:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            break;
                        case 8:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            break;
                        case 9:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            c.setDlmServizi(textFieldEmail8.getText(), 0);
                            break;
                        case 10:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            c.setDlmServizi(textFieldEmail8.getText(), 0);
                            c.setDlmServizi(textFieldEmail9.getText(), 0);
                            break;
                    }
                    try {
                        new CreaServizio(c);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (textFieldEmail0.getText().equals("")) {
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "Bisogna inserire almeno una mail per registrare un sistema di messaging!", "ATTENZIONE!", 2, img);
                } else {
                    c.setImg(".images/Viber512x512.png");
                    c.setServizioMessaging("Viber");
                    switch (contEmail) {
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
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            break;
                        case 4:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            break;
                        case 5:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            break;
                        case 6:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            break;
                        case 7:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            break;
                        case 8:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            break;
                        case 9:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            c.setDlmServizi(textFieldEmail8.getText(), 0);
                            break;
                        case 10:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            c.setDlmServizi(textFieldEmail8.getText(), 0);
                            c.setDlmServizi(textFieldEmail9.getText(), 0);
                            break;
                    }
                    try {
                        new CreaServizio(c);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (textFieldEmail0.getText().equals("")) {
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "Bisogna inserire almeno una mail per registrare un sistema di messaging!", "ATTENZIONE!", 2, img);
                } else {
                    c.setImg(".images/Telegram512x512.png");
                    c.setServizioMessaging("Telegram");
                    switch (contEmail) {
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
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            break;
                        case 4:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            break;
                        case 5:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            break;
                        case 6:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            break;
                        case 7:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            break;
                        case 8:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            break;
                        case 9:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            c.setDlmServizi(textFieldEmail8.getText(), 0);
                            break;
                        case 10:
                            c.setDlmServizi(textFieldEmail0.getText(), 1);
                            c.setDlmServizi(textFieldEmail1.getText(), 0);
                            c.setDlmServizi(textFieldEmail2.getText(), 0);
                            c.setDlmServizi(textFieldEmail3.getText(), 0);
                            c.setDlmServizi(textFieldEmail4.getText(), 0);
                            c.setDlmServizi(textFieldEmail5.getText(), 0);
                            c.setDlmServizi(textFieldEmail6.getText(), 0);
                            c.setDlmServizi(textFieldEmail7.getText(), 0);
                            c.setDlmServizi(textFieldEmail8.getText(), 0);
                            c.setDlmServizi(textFieldEmail9.getText(), 0);
                            break;
                    }
                    try {
                        new CreaServizio(c);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        //GESTIONE CLICK ELIMINA IN INFO CONTATTI
        btnElimina.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                img = c.SetImageSize(".images/warning.png",30,30);
                if(JOptionPane.showConfirmDialog(null,"SEI SICURO DI VOLER ELIMINARE QUESTO CONTATTO?","ATTENZIONE!",0,1,img)==0){
                    try {
                        if(c.getPath(pkContatti.get(listContatti.getSelectedIndex()))!=null) {
                            Files.delete(Path.of(c.getPath(pkContatti.get(listContatti.getSelectedIndex()))));
                        }
                        c.cancellaContatto(pkContatti.get(listContatti.getSelectedIndex()));
                        //REFRESH LISTA CONTATTI E RESET DLM
                        panelInfoContatti.setVisible(false);
                        listContatti.setModel(DLMContatti);                                         //Aggiungiamo nel JList i nomi e cognomi dei contatti
                        img = c.SetImageSize(".images/creazionecontatto.png", 30, 30);
                        JOptionPane.showMessageDialog(null, c.getNome(getpk)+ " " + c.getCognome(getpk) + " eliminato/a con successo!", "ELIMINAZIONE RIUSCITA!", 1, img);
                        DLMContatti.clear();
                        DLMContatti = c.getContatti(pkContatti);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                jfc = new JFileChooser();
                panelInfoContatti.setVisible(true);
                c.swapVisibility(panelCreaContatto,panelInfoContattoSinistra);
                contattiSplitPane.setDividerLocation(350);
                img = c.SetImageSize(".images/"+randImage.get(rand.nextInt(randImage.size()-1)),200,200);
                btnAddContact.setIcon(img);
                panelInfoContatti.validate();
            }
        });

        //GESTIONE CLICK ANNULLA IN CREA CONTATTO
        btnAnnulla.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
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

                //Reset tasti
                btnAggiornaModifica.setVisible(false);
                btnAggiungi.setVisible(true);

                //Eliminazione foto inserita
                try {
                    if(Files.exists(Path.of(".images/" + c.getLastId()))) {
                        Files.delete(Path.of(".images/" + c.getLastId()));
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //INTERAZIONI AGGIUNTA FOTO CONTATTO IN CREA CONTATTO
        btnAddContact.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                jfc.showDialog(null,"Seleziona la foto del contatto");
                jfc.setVisible(true);
                try {
                    img=null;
                    foto = jfc.getSelectedFile();
                    Files.copy(Path.of((foto.getPath())), Path.of(".images/"+c.getLastId()),StandardCopyOption.REPLACE_EXISTING);
                    img = c.SetImageSize(".images/"+c.getLastId(),200,200);
                    btnAddContact.setIcon(img);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                switch(contEmail){
                    case 1 : img = c.SetImageSize(".images/warning.png",30,30);
                        JOptionPane.showMessageDialog(null,"Non è possibile eliminare ulteriori textbox!","ATTENZIONE!",1,img);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                switch(contNumeriFissi){
                    case 1 : img = c.SetImageSize(".images/warning.png",30,30);
                        JOptionPane.showMessageDialog(null,"Non è possibile eliminare ulteriori TextBox!","ATTENZIONE!",1,img);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                switch(contNumeriMobili){
                    case 1 : img = c.SetImageSize(".images/warning.png",30,30);
                        JOptionPane.showMessageDialog(null,"Non è possibile eliminare ulteriori TextBox!","ATTENZIONE!",1,img);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                switch(contIndirizziSecondari){
                    case 1 : img = c.SetImageSize(".images/warning.png",30,30);
                        JOptionPane.showMessageDialog(null,"Non è possibile eliminare ulteriori TextBox!","ATTENZIONE!",1,img);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
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

        //SETTAGGIO TEXT CURSOR NEI TEXTFIELD RICERCA
        textFieldSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldSearch.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
            }
        });

        //SETTAGGIO TEXT CURSOR NEI TEXTFIELD RICERCA
        textFieldSearchPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(textCursor);
            }
        });
        textFieldSearchPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseEntered(e);
                frame.setCursor(defaultCursor);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                //SE NON E' STATO INSERITO UN NOME AL CONTATTO NON CONTINUARE
                if (textFieldNome.getText().equals("")) {
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "Non è stato inserito il nome del contatto!", "ATTENZIONE!", 1, img);
                }
                //SE NON E' STATO INSERITO UN COGNOME AL CONTATTO NON CONTINUARE
                else if(textFieldCognome.getText().equals("")){
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "Non è stato inserito il cognome del contatto", "ATTENZIONE!", 1, img);
                }
                //SE NON E' STATO INSERITO UN INDIRIZZO PRINCIPALE AL CONTATTO NON CONTINUARE
                else if(textFieldIndirizzoPrincipale.getText().equals("")){
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "Non è stato inserito l'indirizzo principale del contatto!", "ATTENZIONE!", 1, img);
                }else{
                    try {
                        //QUERY CREA CONTATTO
                        if (jfc.getSelectedFile() == null) {
                            getpk = c.creaContatto("null", textFieldNome.getText(), textFieldCognome.getText(), contattoPrivatoCheckBox.isSelected());
                        } else {
                            getpk = c.creaContatto("'C:/Users/39366/IdeaProjects/Rubrica-java/.images/" + c.getLastId()+"'", textFieldNome.getText(), textFieldCognome.getText(), contattoPrivatoCheckBox.isSelected());
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

                        //QUERY CREA INDIRIZZO SECONDARIO
                        if(contIndirizziSecondari==1 && !textFieldIndirizziSecondari0.equals("")){
                            c.creaIndirizzoSecondario(textFieldIndirizziSecondari0.getText(),getpk);
                        }
                        switch (contIndirizziSecondari){
                            case 2 : c.creaIndirizzoSecondario(textFieldIndirizziSecondari0.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari1.getText(),getpk);
                                break;
                            case 3 : c.creaIndirizzoSecondario(textFieldIndirizziSecondari0.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari1.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari2.getText(),getpk);
                                break;
                            case 4 : c.creaIndirizzoSecondario(textFieldIndirizziSecondari0.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari1.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari2.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari3.getText(),getpk);
                                break;
                            case 5 : c.creaIndirizzoSecondario(textFieldIndirizziSecondari0.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari1.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari2.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari3.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari4.getText(),getpk);
                                break;
                            case 6 : c.creaIndirizzoSecondario(textFieldIndirizziSecondari0.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari1.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari2.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari3.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari4.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari5.getText(),getpk);
                                break;
                            case 7 : c.creaIndirizzoSecondario(textFieldIndirizziSecondari0.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari1.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari2.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari3.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari4.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari5.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari6.getText(),getpk);
                                break;
                            case 8 : c.creaIndirizzoSecondario(textFieldIndirizziSecondari0.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari1.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari2.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari3.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari4.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari5.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari6.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari7.getText(),getpk);
                                break;
                            case 9 : c.creaIndirizzoSecondario(textFieldIndirizziSecondari0.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari1.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari2.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari3.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari4.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari5.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari6.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari7.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari8.getText(),getpk);
                                break;
                            case 10 : c.creaIndirizzoSecondario(textFieldIndirizziSecondari0.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari1.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari2.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari3.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari4.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari5.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari6.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari7.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari8.getText(),getpk);
                                c.creaIndirizzoSecondario(textFieldIndirizziSecondari9.getText(),getpk);

                        }

                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    //Refresh dlm contatti e dlm contattiprivati
                    DLMContatti.clear();
                    DLMContattiPrivati.clear();
                    try {
                        DLMContatti = c.getContatti(pkContatti);
                        listContatti.setModel(DLMContatti);                                         //Aggiungiamo nel JList i nomi e cognomi dei contatti
                        DLMContattiPrivati = c.getContattiPrivati(pkContattiPrivati);
                        listAreaPrivata.setModel(DLMContattiPrivati);
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
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (textFieldNumeriFissi0.getText().equals("") || textFieldNumeriMobili0.getText().equals("")) {
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "Inserire almeno un numero mobile e un numero fisso per creare un reindirizzamento!", "ATTENZIONE!", 1, img);
                } else {
                    switch (contNumeriFissi) {
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
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(), 0);
                            break;
                        case 4:
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi3.getText(), 0);
                            break;
                        case 5:
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi3.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi4.getText(), 0);
                            break;
                        case 6:
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi3.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi4.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi5.getText(), 0);
                            break;
                        case 7:
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi3.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi4.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi5.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi6.getText(), 0);
                            break;
                        case 8:
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi3.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi4.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi5.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi6.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi7.getText(), 0);
                            break;
                        case 9:
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi3.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi4.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi5.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi6.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi7.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi8.getText(), 0);
                            break;
                        case 10:
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi0.getText(), 1);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi1.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi2.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi3.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi4.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi5.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi6.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi7.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi8.getText(), 0);
                            c.setDlmReindirizzamentiFissi(textFieldNumeriFissi9.getText(), 0);
                            break;
                    }
                    switch (contNumeriMobili) {
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
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(), 0);
                            break;
                        case 4:
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili3.getText(), 0);
                            break;
                        case 5:
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili3.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili4.getText(), 0);
                            break;
                        case 6:
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili3.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili4.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili5.getText(), 0);
                            break;
                        case 7:
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili3.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili4.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili5.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili6.getText(), 0);
                            break;
                        case 8:
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili3.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili4.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili5.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili6.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili7.getText(), 0);
                            break;
                        case 9:
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili3.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili4.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili5.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili6.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili7.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili8.getText(), 0);
                            break;
                        case 10:
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili0.getText(), 1);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili1.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili2.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili3.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili4.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili5.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili6.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili7.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili8.getText(), 0);
                            c.setDlmReindirizzamentiMobili(textFieldNumeriMobili9.getText(), 0);
                            break;

                    }
                    try {
                        new CreaReindirizzamento(c);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        //Set interazioni reindirizzamenti in infoContatto
        btnReindirizzamenti.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    c.setReindirizzamenti(pkContatti.get(listContatti.getSelectedIndex()));
                    if(c.getReindirizzamenti()==null){
                        img = c.SetImageSize(".images/warning.png",30,30);
                        JOptionPane.showMessageDialog(null,"Il contatto selezionato non ha reindirizzamenti!","ATTENZIONE!",1,img);
                    }else new InfoReindirizzamento(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //INTERAZIONI BTNMODIFICA
        btnModifica.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                //swap finestra
                panelInfoContatti.setVisible(true);
                c.swapVisibility(panelCreaContatto, panelInfoContattoSinistra);
                contattiSplitPane.setDividerLocation(350);
                img = c.SetImageSize(".images/" + randImage.get(rand.nextInt(randImage.size() - 1)), 200, 200);
                btnAddContact.setIcon(img);

                //Settaggio bottoni
                btnAggiornaModifica.setVisible(true);
                btnAggiungi.setVisible(false);

                try {
                    if (c.getPath(pkContatti.get(listContatti.getSelectedIndex())) != null) {
                        img = c.SetImageSize(c.getPath(pkContatti.get(listContatti.getSelectedIndex())), 200, 200);
                        btnAddContact.setIcon(img);
                    } else {
                        img = c.SetImageSize(".images/" + randImage.get(rand.nextInt(randImage.size() - 1)), 200, 200);
                        btnAddContact.setIcon(img);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                try {
                    //Settaggio cont
                    contEmail = (c.getcontNumEmail(pkContatti.get(listContatti.getSelectedIndex())));
                    contNumeriFissi = (c.getcontNumNumeriFissi(pkContatti.get(listContatti.getSelectedIndex())));
                    contNumeriMobili = (c.getcontNumNumeriMobili(pkContatti.get(listContatti.getSelectedIndex())));
                    contIndirizziSecondari = (c.getcontNumIndirizziSecondari(pkContatti.get(listContatti.getSelectedIndex())));
                    //Settaggio Nome
                    textFieldNome.setText(c.getNome(pkContatti.get(listContatti.getSelectedIndex())));
                    //Settaggio Cognome
                    textFieldCognome.setText(c.getCognome(pkContatti.get(listContatti.getSelectedIndex())));
                    //Settaggio Email
                    if(contEmail==1 && !textFieldEmail0.getText().equals("")){
                        c.getArrayEmail(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                        textFieldEmail0.setText(getStrings.get(0));
                    }
                    switch (contEmail) {
                        case 2:
                            c.getArrayEmail(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            break;
                        case 3:
                            c.getArrayEmail(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            break;
                        case 4:
                            c.getArrayEmail(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            textFieldEmail3.setText(getStrings.get(3));
                            textFieldEmail3.setVisible(true);
                            break;
                        case 5:
                            c.getArrayEmail(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            textFieldEmail3.setText(getStrings.get(3));
                            textFieldEmail3.setVisible(true);
                            textFieldEmail4.setText(getStrings.get(4));
                            textFieldEmail4.setVisible(true);
                            break;
                        case 6:
                            c.getArrayEmail(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            textFieldEmail3.setText(getStrings.get(3));
                            textFieldEmail3.setVisible(true);
                            textFieldEmail4.setText(getStrings.get(4));
                            textFieldEmail4.setVisible(true);
                            textFieldEmail5.setText(getStrings.get(5));
                            textFieldEmail5.setVisible(true);
                            break;
                        case 7:
                            c.getArrayEmail(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            textFieldEmail3.setText(getStrings.get(3));
                            textFieldEmail3.setVisible(true);
                            textFieldEmail4.setText(getStrings.get(4));
                            textFieldEmail4.setVisible(true);
                            textFieldEmail5.setText(getStrings.get(5));
                            textFieldEmail5.setVisible(true);
                            textFieldEmail6.setText(getStrings.get(6));
                            textFieldEmail6.setVisible(true);
                            break;
                        case 8:
                            c.getArrayEmail(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            textFieldEmail3.setText(getStrings.get(3));
                            textFieldEmail3.setVisible(true);
                            textFieldEmail4.setText(getStrings.get(4));
                            textFieldEmail4.setVisible(true);
                            textFieldEmail5.setText(getStrings.get(5));
                            textFieldEmail5.setVisible(true);
                            textFieldEmail6.setText(getStrings.get(6));
                            textFieldEmail6.setVisible(true);
                            textFieldEmail7.setText(getStrings.get(7));
                            textFieldEmail7.setVisible(true);
                            break;
                        case 9:
                            c.getArrayEmail(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            textFieldEmail3.setText(getStrings.get(3));
                            textFieldEmail3.setVisible(true);
                            textFieldEmail4.setText(getStrings.get(4));
                            textFieldEmail4.setVisible(true);
                            textFieldEmail5.setText(getStrings.get(5));
                            textFieldEmail5.setVisible(true);
                            textFieldEmail6.setText(getStrings.get(6));
                            textFieldEmail6.setVisible(true);
                            textFieldEmail7.setText(getStrings.get(7));
                            textFieldEmail7.setVisible(true);
                            textFieldEmail8.setText(getStrings.get(8));
                            textFieldEmail8.setVisible(true);
                            break;
                        case 10:
                            c.getArrayEmail(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            textFieldEmail3.setText(getStrings.get(3));
                            textFieldEmail3.setVisible(true);
                            textFieldEmail4.setText(getStrings.get(4));
                            textFieldEmail4.setVisible(true);
                            textFieldEmail5.setText(getStrings.get(5));
                            textFieldEmail5.setVisible(true);
                            textFieldEmail6.setText(getStrings.get(6));
                            textFieldEmail6.setVisible(true);
                            textFieldEmail7.setText(getStrings.get(7));
                            textFieldEmail7.setVisible(true);
                            textFieldEmail8.setText(getStrings.get(8));
                            textFieldEmail8.setVisible(true);
                            textFieldEmail9.setText(getStrings.get(9));
                            textFieldEmail9.setVisible(true);
                            break;
                    }

                    //Settaggio NumeriFissi
                    if(contNumeriFissi==1 && !textFieldNumeriFissi0.getText().equals("")){
                        c.getArrayNumeriFissi(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                        textFieldNumeriFissi0.setText(getStrings.get(0));
                    }
                    switch (contNumeriFissi) {
                        case 2:
                            c.getArrayNumeriFissi(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            break;
                        case 3:
                            c.getArrayNumeriFissi(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            break;
                        case 4:
                            c.getArrayNumeriFissi(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            textFieldNumeriFissi3.setText(getStrings.get(3));
                            textFieldNumeriFissi3.setVisible(true);
                            break;
                        case 5:
                            c.getArrayNumeriFissi(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            textFieldNumeriFissi3.setText(getStrings.get(3));
                            textFieldNumeriFissi3.setVisible(true);
                            textFieldNumeriFissi4.setText(getStrings.get(4));
                            textFieldNumeriFissi4.setVisible(true);
                            break;
                        case 6:
                            c.getArrayNumeriFissi(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            textFieldNumeriFissi3.setText(getStrings.get(3));
                            textFieldNumeriFissi3.setVisible(true);
                            textFieldNumeriFissi4.setText(getStrings.get(4));
                            textFieldNumeriFissi4.setVisible(true);
                            textFieldNumeriFissi5.setText(getStrings.get(5));
                            textFieldNumeriFissi5.setVisible(true);

                            break;
                        case 7:
                            c.getArrayNumeriFissi(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            textFieldNumeriFissi3.setText(getStrings.get(3));
                            textFieldNumeriFissi3.setVisible(true);
                            textFieldNumeriFissi4.setText(getStrings.get(4));
                            textFieldNumeriFissi4.setVisible(true);
                            textFieldNumeriFissi5.setText(getStrings.get(5));
                            textFieldNumeriFissi5.setVisible(true);
                            textFieldNumeriFissi6.setText(getStrings.get(6));
                            textFieldNumeriFissi6.setVisible(true);
                            break;
                        case 8:
                            c.getArrayNumeriFissi(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            textFieldNumeriFissi3.setText(getStrings.get(3));
                            textFieldNumeriFissi3.setVisible(true);
                            textFieldNumeriFissi4.setText(getStrings.get(4));
                            textFieldNumeriFissi4.setVisible(true);
                            textFieldNumeriFissi5.setText(getStrings.get(5));
                            textFieldNumeriFissi5.setVisible(true);
                            textFieldNumeriFissi6.setText(getStrings.get(6));
                            textFieldNumeriFissi6.setVisible(true);
                            textFieldNumeriFissi7.setText(getStrings.get(7));
                            textFieldNumeriFissi7.setVisible(true);
                            break;
                        case 9:
                            c.getArrayNumeriFissi(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            textFieldNumeriFissi3.setText(getStrings.get(3));
                            textFieldNumeriFissi3.setVisible(true);
                            textFieldNumeriFissi4.setText(getStrings.get(4));
                            textFieldNumeriFissi4.setVisible(true);
                            textFieldNumeriFissi5.setText(getStrings.get(5));
                            textFieldNumeriFissi5.setVisible(true);
                            textFieldNumeriFissi6.setText(getStrings.get(6));
                            textFieldNumeriFissi6.setVisible(true);
                            textFieldNumeriFissi7.setText(getStrings.get(7));
                            textFieldNumeriFissi7.setVisible(true);
                            textFieldNumeriFissi8.setText(getStrings.get(8));
                            textFieldNumeriFissi8.setVisible(true);
                            break;
                        case 10:
                            c.getArrayNumeriFissi(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            textFieldNumeriFissi3.setText(getStrings.get(3));
                            textFieldNumeriFissi3.setVisible(true);
                            textFieldNumeriFissi4.setText(getStrings.get(4));
                            textFieldNumeriFissi4.setVisible(true);
                            textFieldNumeriFissi5.setText(getStrings.get(5));
                            textFieldNumeriFissi5.setVisible(true);
                            textFieldNumeriFissi6.setText(getStrings.get(6));
                            textFieldNumeriFissi6.setVisible(true);
                            textFieldNumeriFissi7.setText(getStrings.get(7));
                            textFieldNumeriFissi7.setVisible(true);
                            textFieldNumeriFissi8.setText(getStrings.get(8));
                            textFieldNumeriFissi8.setVisible(true);
                            textFieldNumeriFissi9.setText(getStrings.get(9));
                            textFieldNumeriFissi9.setVisible(true);
                            break;
                    }

                    //Settaggio NumeriMobili
                    if(contNumeriMobili==1 && !textFieldNumeriMobili0.getText().equals("")){
                        c.getArrayNumeriMobili(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                        textFieldNumeriMobili0.setText(getStrings.get(0));
                    }
                    switch (contNumeriMobili) {
                        case 2:
                            c.getArrayNumeriMobili(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            break;
                        case 3:
                            c.getArrayNumeriMobili(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            break;
                        case 4:
                            c.getArrayNumeriMobili(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            textFieldNumeriMobili3.setText(getStrings.get(3));
                            textFieldNumeriMobili3.setVisible(true);
                            break;
                        case 5:
                            c.getArrayNumeriMobili(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            textFieldNumeriMobili3.setText(getStrings.get(3));
                            textFieldNumeriMobili3.setVisible(true);
                            textFieldNumeriMobili4.setText(getStrings.get(4));
                            textFieldNumeriMobili4.setVisible(true);
                            break;
                        case 6:
                            c.getArrayNumeriMobili(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            textFieldNumeriMobili3.setText(getStrings.get(3));
                            textFieldNumeriMobili3.setVisible(true);
                            textFieldNumeriMobili4.setText(getStrings.get(4));
                            textFieldNumeriMobili4.setVisible(true);
                            textFieldNumeriMobili5.setText(getStrings.get(5));
                            textFieldNumeriMobili5.setVisible(true);
                            break;
                        case 7:
                            c.getArrayNumeriMobili(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            textFieldNumeriMobili3.setText(getStrings.get(3));
                            textFieldNumeriMobili3.setVisible(true);
                            textFieldNumeriMobili4.setText(getStrings.get(4));
                            textFieldNumeriMobili4.setVisible(true);
                            textFieldNumeriMobili5.setText(getStrings.get(5));
                            textFieldNumeriMobili5.setVisible(true);
                            textFieldNumeriMobili6.setText(getStrings.get(6));
                            textFieldNumeriMobili6.setVisible(true);
                            break;
                        case 8:
                            c.getArrayNumeriMobili(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            textFieldNumeriMobili3.setText(getStrings.get(3));
                            textFieldNumeriMobili3.setVisible(true);
                            textFieldNumeriMobili4.setText(getStrings.get(4));
                            textFieldNumeriMobili4.setVisible(true);
                            textFieldNumeriMobili5.setText(getStrings.get(5));
                            textFieldNumeriMobili5.setVisible(true);
                            textFieldNumeriMobili6.setText(getStrings.get(6));
                            textFieldNumeriMobili6.setVisible(true);
                            textFieldNumeriMobili7.setText(getStrings.get(7));
                            textFieldNumeriMobili7.setVisible(true);
                            break;
                        case 9:
                            c.getArrayNumeriMobili(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            textFieldNumeriMobili3.setText(getStrings.get(3));
                            textFieldNumeriMobili3.setVisible(true);
                            textFieldNumeriMobili4.setText(getStrings.get(4));
                            textFieldNumeriMobili4.setVisible(true);
                            textFieldNumeriMobili5.setText(getStrings.get(5));
                            textFieldNumeriMobili5.setVisible(true);
                            textFieldNumeriMobili6.setText(getStrings.get(6));
                            textFieldNumeriMobili6.setVisible(true);
                            textFieldNumeriMobili7.setText(getStrings.get(7));
                            textFieldNumeriMobili7.setVisible(true);
                            textFieldNumeriMobili8.setText(getStrings.get(8));
                            textFieldNumeriMobili8.setVisible(true);
                            break;
                        case 10:
                            c.getArrayNumeriMobili(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            textFieldNumeriMobili3.setText(getStrings.get(3));
                            textFieldNumeriMobili3.setVisible(true);
                            textFieldNumeriMobili4.setText(getStrings.get(4));
                            textFieldNumeriMobili4.setVisible(true);
                            textFieldNumeriMobili5.setText(getStrings.get(5));
                            textFieldNumeriMobili5.setVisible(true);
                            textFieldNumeriMobili6.setText(getStrings.get(6));
                            textFieldNumeriMobili6.setVisible(true);
                            textFieldNumeriMobili7.setText(getStrings.get(7));
                            textFieldNumeriMobili7.setVisible(true);
                            textFieldNumeriMobili8.setText(getStrings.get(8));
                            textFieldNumeriMobili8.setVisible(true);
                            textFieldNumeriMobili9.setText(getStrings.get(9));
                            textFieldNumeriMobili9.setVisible(true);
                            break;
                    }

                    //Settaggio Indirizzo principale
                    if (!c.getIndirizzoPrincipaleNoHTML(pkContatti.get(listContatti.getSelectedIndex())).equals("NOT FOUND")) {
                        textFieldIndirizzoPrincipale.setText(c.getIndirizzoPrincipaleNoHTML(pkContatti.get(listContatti.getSelectedIndex())));
                    }

                    //Settaggio IndirizziSecondari
                    if(contIndirizziSecondari==1 && !textFieldIndirizziSecondari0.getText().equals("")){
                        c.getArrayIndirizziSecondari(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                        textFieldIndirizziSecondari0.setText(getStrings.get(0));
                    }
                    switch (contIndirizziSecondari) {
                        case 2:
                            c.getArrayIndirizziSecondari(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            break;
                        case 3:
                            c.getArrayIndirizziSecondari(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            break;
                        case 4:
                            c.getArrayIndirizziSecondari(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            textFieldIndirizziSecondari3.setText(getStrings.get(3));
                            textFieldIndirizziSecondari3.setVisible(true);
                            break;
                        case 5:
                            c.getArrayIndirizziSecondari(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            textFieldIndirizziSecondari3.setText(getStrings.get(3));
                            textFieldIndirizziSecondari3.setVisible(true);
                            textFieldIndirizziSecondari4.setText(getStrings.get(4));
                            textFieldIndirizziSecondari4.setVisible(true);
                            break;
                        case 6:
                            c.getArrayIndirizziSecondari(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            textFieldIndirizziSecondari3.setText(getStrings.get(3));
                            textFieldIndirizziSecondari3.setVisible(true);
                            textFieldIndirizziSecondari4.setText(getStrings.get(4));
                            textFieldIndirizziSecondari4.setVisible(true);
                            textFieldIndirizziSecondari5.setText(getStrings.get(5));
                            textFieldIndirizziSecondari5.setVisible(true);
                            break;
                        case 7:
                            c.getArrayIndirizziSecondari(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            textFieldIndirizziSecondari3.setText(getStrings.get(3));
                            textFieldIndirizziSecondari3.setVisible(true);
                            textFieldIndirizziSecondari4.setText(getStrings.get(4));
                            textFieldIndirizziSecondari4.setVisible(true);
                            textFieldIndirizziSecondari5.setText(getStrings.get(5));
                            textFieldIndirizziSecondari5.setVisible(true);
                            textFieldIndirizziSecondari6.setText(getStrings.get(6));
                            textFieldIndirizziSecondari6.setVisible(true);
                            break;
                        case 8:
                            c.getArrayIndirizziSecondari(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            textFieldIndirizziSecondari3.setText(getStrings.get(3));
                            textFieldIndirizziSecondari3.setVisible(true);
                            textFieldIndirizziSecondari4.setText(getStrings.get(4));
                            textFieldIndirizziSecondari4.setVisible(true);
                            textFieldIndirizziSecondari5.setText(getStrings.get(5));
                            textFieldIndirizziSecondari5.setVisible(true);
                            textFieldIndirizziSecondari6.setText(getStrings.get(6));
                            textFieldIndirizziSecondari6.setVisible(true);
                            textFieldIndirizziSecondari7.setText(getStrings.get(7));
                            textFieldIndirizziSecondari7.setVisible(true);
                            break;
                        case 9:
                            c.getArrayIndirizziSecondari(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            textFieldIndirizziSecondari3.setText(getStrings.get(3));
                            textFieldIndirizziSecondari3.setVisible(true);
                            textFieldIndirizziSecondari4.setText(getStrings.get(4));
                            textFieldIndirizziSecondari4.setVisible(true);
                            textFieldIndirizziSecondari5.setText(getStrings.get(5));
                            textFieldIndirizziSecondari5.setVisible(true);
                            textFieldIndirizziSecondari6.setText(getStrings.get(6));
                            textFieldIndirizziSecondari6.setVisible(true);
                            textFieldIndirizziSecondari7.setText(getStrings.get(7));
                            textFieldIndirizziSecondari7.setVisible(true);
                            textFieldIndirizziSecondari8.setText(getStrings.get(8));
                            textFieldIndirizziSecondari8.setVisible(true);
                            break;
                        case 10:
                            c.getArrayIndirizziSecondari(getStrings, pkContatti.get(listContatti.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            textFieldIndirizziSecondari3.setText(getStrings.get(3));
                            textFieldIndirizziSecondari3.setVisible(true);
                            textFieldIndirizziSecondari4.setText(getStrings.get(4));
                            textFieldIndirizziSecondari4.setVisible(true);
                            textFieldIndirizziSecondari5.setText(getStrings.get(5));
                            textFieldIndirizziSecondari5.setVisible(true);
                            textFieldIndirizziSecondari6.setText(getStrings.get(6));
                            textFieldIndirizziSecondari6.setVisible(true);
                            textFieldIndirizziSecondari7.setText(getStrings.get(7));
                            textFieldIndirizziSecondari7.setVisible(true);
                            textFieldIndirizziSecondari8.setText(getStrings.get(8));
                            textFieldIndirizziSecondari8.setVisible(true);
                            textFieldIndirizziSecondari9.setText(getStrings.get(9));
                            textFieldIndirizziSecondari9.setVisible(true);
                            break;
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //SETTAGGIO ZONA PRIVATA
        //Listener contattoprivato click
        listAreaPrivata.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                InfoContattiPrivata.setVisible(true);
                try {
                    //Settaggio visibilità dei lblServizi
                    if(c.getServizio("Messenger",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())) == null) lblMessengerPrivati.setVisible(false);
                    else lblMessengerPrivati.setVisible(true);
                    if(c.getServizio("Skype",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())) == null) lblSkypePrivati.setVisible(false);
                    else lblSkypePrivati.setVisible(true);
                    if(c.getServizio("Teams",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())) == null) lblTeamsPrivati.setVisible(false);
                    else lblTeamsPrivati.setVisible(true);
                    if(c.getServizio("Telegram",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())) == null) lblTelegramPrivati.setVisible(false);
                    else lblTelegramPrivati.setVisible(true);
                    if(c.getServizio("Viber",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())) == null) lblViberPrivati.setVisible(false);
                    else lblViberPrivati.setVisible(true);
                    if(c.getServizio("WeChat",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())) == null) lblWeChatPrivati.setVisible(false);
                    else lblWeChatPrivati.setVisible(true);
                    if(c.getServizio("Whatsapp",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())) == null) lblWhatsappPrivati.setVisible(false);
                    else lblWhatsappPrivati.setVisible(true);

                    panelinfoContattiPrivati.setVisible(true);
                    SplitPaneAreaPrivata.setDividerLocation(350);
                    //SET FOTO
                    if(c.getPath(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())) == null) {
                        img = c.SetImageSize(".images/" + randImage.get(rand.nextInt(randImage.size() - 1)), 200, 200);
                        lblFotoPrivati.setIcon(img);
                    }else{
                        img = c.SetImageSize(c.getPath(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())),200,200);
                        lblFotoPrivati.setIcon(img);
                    }
                    //SET NOME
                    lblNomePrivati.setText(c.getNome(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())));
                    //SET COGNOME
                    lblCognomePrivati.setText(c.getCognome(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())));
                    //SET EMAIL
                    if(c.getEmail((pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()))).equals("NOT FOUND")){
                        lblEmailPrivati.setVisible(false);
                        lblInfoEmailPrivati.setVisible(false);
                    }else {
                        lblInfoEmailPrivati.setText(c.getEmail((pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()))));
                        lblEmailPrivati.setVisible(true);
                        lblInfoEmailPrivati.setVisible(true);
                    }
                    //SET NUMERI FISSI
                    if(c.getNumeriFissi(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())).equals("NOT FOUND")){
                        lblNumeriFissiPrivati.setVisible(false);
                        lblInfoNumeriFissiPrivati.setVisible(false);
                    }else{
                        lblInfoNumeriFissiPrivati.setText(c.getNumeriFissi(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())));
                        lblNumeriFissiPrivati.setVisible(true);
                        lblInfoNumeriFissiPrivati.setVisible(true);
                    }
                    //SET NUMERI MOBILI
                    if(c.getNumeriMobili(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())).equals("NOT FOUND")){
                        lblNumeriMobiliPrivati.setVisible(false);
                        lblInfoNumeriMobiliPrivati.setVisible(false);
                    }else{
                        lblInfoNumeriMobiliPrivati.setText(c.getNumeriMobili(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())));
                        lblNumeriMobiliPrivati.setVisible(true);
                        lblInfoNumeriMobiliPrivati.setVisible(true);
                    }
                    //SET INDIRIZZO PRINCIPALE
                    if(c.getIndirizzoPrincipale(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())).equals("NOT FOUND")){
                        lblIndirizzoPrincipalePrivati.setVisible(false);
                        lblInfoIndirizzoPrincipalePrivati.setVisible(false);
                    }else{
                        lblInfoIndirizzoPrincipalePrivati.setText(c.getIndirizzoPrincipale(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())));
                        lblIndirizzoPrincipalePrivati.setVisible(true);
                        lblInfoIndirizzoPrincipalePrivati.setVisible(true);
                    }
                    //SET INDIRIZZI SECONDARI
                    if(c.getIndirizziSecondari(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())).equals("NOT FOUND")){
                        lblIndirizziSecondariPrivati.setVisible(false);
                        lblInfoIndirizziSecondariPrivati.setVisible(false);
                    }else{
                        lblInfoIndirizziSecondariPrivati.setText(c.getIndirizziSecondari(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())));
                        lblIndirizziSecondariPrivati.setVisible(true);
                        lblInfoIndirizziSecondariPrivati.setVisible(true);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //GESTIONE CLICK ELIMINA IN INFO CONTATTI PRIVATI
        btnEliminaPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                img = c.SetImageSize(".images/warning.png",30,30);
                if(JOptionPane.showConfirmDialog(null,"SEI SICURO DI VOLER ELIMINARE QUESTO CONTATTO?","ATTENZIONE!",0,1,img)==0){
                    try {
                        if(c.getPath(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()))!=null) {
                            Files.delete(Path.of(c.getPath(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()))));
                        }
                        c.cancellaContatto(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                        //REFRESH LISTA CONTATTI E RESET DLM
                        InfoContattiPrivata.setVisible(false);
                        DLMContattiPrivati.clear();
                        DLMContattiPrivati = c.getContattiPrivati(pkContattiPrivati);
                        listAreaPrivata.setModel(DLMContattiPrivati);                                         //Aggiungiamo nel JList i nomi e cognomi dei contatti
                        img = c.SetImageSize(".images/creazionecontatto.png", 30, 30);
                        JOptionPane.showMessageDialog(null, c.getNome(getpk) + " " + c.getCognome(getpk) + " eliminato/a con successo!", "ELIMINAZIONE RIUSCITA!", 1, img);
                        DLMContattiPrivati.clear();
                        DLMContattiPrivati = c.getContattiPrivati(pkContattiPrivati);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        //INTERAZIONI BTNMODIFICAPRIVATI
        btnModificaPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                //swap finestra
                panelInfoContatti.setVisible(true);
                c.swapVisibility(panelCreaContatto, panelInfoContattoSinistra);
                contattiSplitPane.setDividerLocation(350);
                img = c.SetImageSize(".images/" + randImage.get(rand.nextInt(randImage.size() - 1)), 200, 200);
                btnAddContact.setIcon(img);
                Tabs.setSelectedIndex(0);

                //Settaggio bottoni
                btnAggiornaModifica.setVisible(true);
                btnAggiungi.setVisible(false);

                try {
                    if (c.getPath(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())) != null) {
                        img = c.SetImageSize(c.getPath(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())), 200, 200);
                        btnAddContact.setIcon(img);
                    } else {
                        img = c.SetImageSize(".images/" + randImage.get(rand.nextInt(randImage.size() - 1)), 200, 200);
                        btnAddContact.setIcon(img);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }

                try {
                    //Settaggio cont
                    contEmail = (c.getcontNumEmail(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())));
                    contNumeriFissi = (c.getcontNumNumeriFissi(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())));
                    contNumeriMobili = (c.getcontNumNumeriMobili(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())));
                    contIndirizziSecondari = (c.getcontNumIndirizziSecondari(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())));
                    //Settaggio Nome
                    textFieldNome.setText(c.getNome(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())));
                    //Settaggio Cognome
                    textFieldCognome.setText(c.getCognome(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())));
                    //Settaggio spunta
                    contattoPrivatoCheckBox.setSelected(true);

                    //Settaggio Email
                    if(contEmail==1 && !textFieldEmail0.getText().equals("")){
                        c.getArrayEmail(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                        textFieldEmail0.setText(getStrings.get(0));
                    }
                    switch (contEmail) {
                        case 2:
                            c.getArrayEmail(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            break;
                        case 3:
                            c.getArrayEmail(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            break;
                        case 4:
                            c.getArrayEmail(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            textFieldEmail3.setText(getStrings.get(3));
                            textFieldEmail3.setVisible(true);
                            break;
                        case 5:
                            c.getArrayEmail(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            textFieldEmail3.setText(getStrings.get(3));
                            textFieldEmail3.setVisible(true);
                            textFieldEmail4.setText(getStrings.get(4));
                            textFieldEmail4.setVisible(true);
                            break;
                        case 6:
                            c.getArrayEmail(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            textFieldEmail3.setText(getStrings.get(3));
                            textFieldEmail3.setVisible(true);
                            textFieldEmail4.setText(getStrings.get(4));
                            textFieldEmail4.setVisible(true);
                            textFieldEmail5.setText(getStrings.get(5));
                            textFieldEmail5.setVisible(true);
                            break;
                        case 7:
                            c.getArrayEmail(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            textFieldEmail3.setText(getStrings.get(3));
                            textFieldEmail3.setVisible(true);
                            textFieldEmail4.setText(getStrings.get(4));
                            textFieldEmail4.setVisible(true);
                            textFieldEmail5.setText(getStrings.get(5));
                            textFieldEmail5.setVisible(true);
                            textFieldEmail6.setText(getStrings.get(6));
                            textFieldEmail6.setVisible(true);
                            break;
                        case 8:
                            c.getArrayEmail(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            textFieldEmail3.setText(getStrings.get(3));
                            textFieldEmail3.setVisible(true);
                            textFieldEmail4.setText(getStrings.get(4));
                            textFieldEmail4.setVisible(true);
                            textFieldEmail5.setText(getStrings.get(5));
                            textFieldEmail5.setVisible(true);
                            textFieldEmail6.setText(getStrings.get(6));
                            textFieldEmail6.setVisible(true);
                            textFieldEmail7.setText(getStrings.get(7));
                            textFieldEmail7.setVisible(true);
                            break;
                        case 9:
                            c.getArrayEmail(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            textFieldEmail3.setText(getStrings.get(3));
                            textFieldEmail3.setVisible(true);
                            textFieldEmail4.setText(getStrings.get(4));
                            textFieldEmail4.setVisible(true);
                            textFieldEmail5.setText(getStrings.get(5));
                            textFieldEmail5.setVisible(true);
                            textFieldEmail6.setText(getStrings.get(6));
                            textFieldEmail6.setVisible(true);
                            textFieldEmail7.setText(getStrings.get(7));
                            textFieldEmail7.setVisible(true);
                            textFieldEmail8.setText(getStrings.get(8));
                            textFieldEmail8.setVisible(true);
                            break;
                        case 10:
                            c.getArrayEmail(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldEmail0.setText(getStrings.get(0));
                            textFieldEmail1.setText(getStrings.get(1));
                            textFieldEmail1.setVisible(true);
                            textFieldEmail2.setText(getStrings.get(2));
                            textFieldEmail2.setVisible(true);
                            textFieldEmail3.setText(getStrings.get(3));
                            textFieldEmail3.setVisible(true);
                            textFieldEmail4.setText(getStrings.get(4));
                            textFieldEmail4.setVisible(true);
                            textFieldEmail5.setText(getStrings.get(5));
                            textFieldEmail5.setVisible(true);
                            textFieldEmail6.setText(getStrings.get(6));
                            textFieldEmail6.setVisible(true);
                            textFieldEmail7.setText(getStrings.get(7));
                            textFieldEmail7.setVisible(true);
                            textFieldEmail8.setText(getStrings.get(8));
                            textFieldEmail8.setVisible(true);
                            textFieldEmail9.setText(getStrings.get(9));
                            textFieldEmail9.setVisible(true);
                            break;
                    }

                    //Settaggio NumeriFissi
                    if(contNumeriFissi==1 && !textFieldNumeriFissi0.getText().equals("")){
                        c.getArrayNumeriFissi(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                        textFieldNumeriFissi0.setText(getStrings.get(0));
                    }
                    switch (contNumeriFissi) {
                        case 2:
                            c.getArrayNumeriFissi(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            break;
                        case 3:
                            c.getArrayNumeriFissi(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            break;
                        case 4:
                            c.getArrayNumeriFissi(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            textFieldNumeriFissi3.setText(getStrings.get(3));
                            textFieldNumeriFissi3.setVisible(true);
                            break;
                        case 5:
                            c.getArrayNumeriFissi(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            textFieldNumeriFissi3.setText(getStrings.get(3));
                            textFieldNumeriFissi3.setVisible(true);
                            textFieldNumeriFissi4.setText(getStrings.get(4));
                            textFieldNumeriFissi4.setVisible(true);
                            break;
                        case 6:
                            c.getArrayNumeriFissi(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            textFieldNumeriFissi3.setText(getStrings.get(3));
                            textFieldNumeriFissi3.setVisible(true);
                            textFieldNumeriFissi4.setText(getStrings.get(4));
                            textFieldNumeriFissi4.setVisible(true);
                            textFieldNumeriFissi5.setText(getStrings.get(5));
                            textFieldNumeriFissi5.setVisible(true);

                            break;
                        case 7:
                            c.getArrayNumeriFissi(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            textFieldNumeriFissi3.setText(getStrings.get(3));
                            textFieldNumeriFissi3.setVisible(true);
                            textFieldNumeriFissi4.setText(getStrings.get(4));
                            textFieldNumeriFissi4.setVisible(true);
                            textFieldNumeriFissi5.setText(getStrings.get(5));
                            textFieldNumeriFissi5.setVisible(true);
                            textFieldNumeriFissi6.setText(getStrings.get(6));
                            textFieldNumeriFissi6.setVisible(true);
                            break;
                        case 8:
                            c.getArrayNumeriFissi(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            textFieldNumeriFissi3.setText(getStrings.get(3));
                            textFieldNumeriFissi3.setVisible(true);
                            textFieldNumeriFissi4.setText(getStrings.get(4));
                            textFieldNumeriFissi4.setVisible(true);
                            textFieldNumeriFissi5.setText(getStrings.get(5));
                            textFieldNumeriFissi5.setVisible(true);
                            textFieldNumeriFissi6.setText(getStrings.get(6));
                            textFieldNumeriFissi6.setVisible(true);
                            textFieldNumeriFissi7.setText(getStrings.get(7));
                            textFieldNumeriFissi7.setVisible(true);
                            break;
                        case 9:
                            c.getArrayNumeriFissi(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            textFieldNumeriFissi3.setText(getStrings.get(3));
                            textFieldNumeriFissi3.setVisible(true);
                            textFieldNumeriFissi4.setText(getStrings.get(4));
                            textFieldNumeriFissi4.setVisible(true);
                            textFieldNumeriFissi5.setText(getStrings.get(5));
                            textFieldNumeriFissi5.setVisible(true);
                            textFieldNumeriFissi6.setText(getStrings.get(6));
                            textFieldNumeriFissi6.setVisible(true);
                            textFieldNumeriFissi7.setText(getStrings.get(7));
                            textFieldNumeriFissi7.setVisible(true);
                            textFieldNumeriFissi8.setText(getStrings.get(8));
                            textFieldNumeriFissi8.setVisible(true);
                            break;
                        case 10:
                            c.getArrayNumeriFissi(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriFissi0.setText(getStrings.get(0));
                            textFieldNumeriFissi1.setText(getStrings.get(1));
                            textFieldNumeriFissi1.setVisible(true);
                            textFieldNumeriFissi2.setText(getStrings.get(2));
                            textFieldNumeriFissi2.setVisible(true);
                            textFieldNumeriFissi3.setText(getStrings.get(3));
                            textFieldNumeriFissi3.setVisible(true);
                            textFieldNumeriFissi4.setText(getStrings.get(4));
                            textFieldNumeriFissi4.setVisible(true);
                            textFieldNumeriFissi5.setText(getStrings.get(5));
                            textFieldNumeriFissi5.setVisible(true);
                            textFieldNumeriFissi6.setText(getStrings.get(6));
                            textFieldNumeriFissi6.setVisible(true);
                            textFieldNumeriFissi7.setText(getStrings.get(7));
                            textFieldNumeriFissi7.setVisible(true);
                            textFieldNumeriFissi8.setText(getStrings.get(8));
                            textFieldNumeriFissi8.setVisible(true);
                            textFieldNumeriFissi9.setText(getStrings.get(9));
                            textFieldNumeriFissi9.setVisible(true);
                            break;
                    }

                    //Settaggio NumeriMobili
                    if(contNumeriMobili==1 && !textFieldNumeriMobili0.getText().equals("")){
                        c.getArrayNumeriMobili(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                        textFieldNumeriMobili0.setText(getStrings.get(0));
                    }
                    switch (contNumeriMobili) {
                        case 2:
                            c.getArrayNumeriMobili(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            break;
                        case 3:
                            c.getArrayNumeriMobili(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            break;
                        case 4:
                            c.getArrayNumeriMobili(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            textFieldNumeriMobili3.setText(getStrings.get(3));
                            textFieldNumeriMobili3.setVisible(true);
                            break;
                        case 5:
                            c.getArrayNumeriMobili(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            textFieldNumeriMobili3.setText(getStrings.get(3));
                            textFieldNumeriMobili3.setVisible(true);
                            textFieldNumeriMobili4.setText(getStrings.get(4));
                            textFieldNumeriMobili4.setVisible(true);
                            break;
                        case 6:
                            c.getArrayNumeriMobili(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            textFieldNumeriMobili3.setText(getStrings.get(3));
                            textFieldNumeriMobili3.setVisible(true);
                            textFieldNumeriMobili4.setText(getStrings.get(4));
                            textFieldNumeriMobili4.setVisible(true);
                            textFieldNumeriMobili5.setText(getStrings.get(5));
                            textFieldNumeriMobili5.setVisible(true);
                            break;
                        case 7:
                            c.getArrayNumeriMobili(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            textFieldNumeriMobili3.setText(getStrings.get(3));
                            textFieldNumeriMobili3.setVisible(true);
                            textFieldNumeriMobili4.setText(getStrings.get(4));
                            textFieldNumeriMobili4.setVisible(true);
                            textFieldNumeriMobili5.setText(getStrings.get(5));
                            textFieldNumeriMobili5.setVisible(true);
                            textFieldNumeriMobili6.setText(getStrings.get(6));
                            textFieldNumeriMobili6.setVisible(true);
                            break;
                        case 8:
                            c.getArrayNumeriMobili(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            textFieldNumeriMobili3.setText(getStrings.get(3));
                            textFieldNumeriMobili3.setVisible(true);
                            textFieldNumeriMobili4.setText(getStrings.get(4));
                            textFieldNumeriMobili4.setVisible(true);
                            textFieldNumeriMobili5.setText(getStrings.get(5));
                            textFieldNumeriMobili5.setVisible(true);
                            textFieldNumeriMobili6.setText(getStrings.get(6));
                            textFieldNumeriMobili6.setVisible(true);
                            textFieldNumeriMobili7.setText(getStrings.get(7));
                            textFieldNumeriMobili7.setVisible(true);
                            break;
                        case 9:
                            c.getArrayNumeriMobili(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            textFieldNumeriMobili3.setText(getStrings.get(3));
                            textFieldNumeriMobili3.setVisible(true);
                            textFieldNumeriMobili4.setText(getStrings.get(4));
                            textFieldNumeriMobili4.setVisible(true);
                            textFieldNumeriMobili5.setText(getStrings.get(5));
                            textFieldNumeriMobili5.setVisible(true);
                            textFieldNumeriMobili6.setText(getStrings.get(6));
                            textFieldNumeriMobili6.setVisible(true);
                            textFieldNumeriMobili7.setText(getStrings.get(7));
                            textFieldNumeriMobili7.setVisible(true);
                            textFieldNumeriMobili8.setText(getStrings.get(8));
                            textFieldNumeriMobili8.setVisible(true);
                            break;
                        case 10:
                            c.getArrayNumeriMobili(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldNumeriMobili0.setText(getStrings.get(0));
                            textFieldNumeriMobili1.setText(getStrings.get(1));
                            textFieldNumeriMobili1.setVisible(true);
                            textFieldNumeriMobili2.setText(getStrings.get(2));
                            textFieldNumeriMobili2.setVisible(true);
                            textFieldNumeriMobili3.setText(getStrings.get(3));
                            textFieldNumeriMobili3.setVisible(true);
                            textFieldNumeriMobili4.setText(getStrings.get(4));
                            textFieldNumeriMobili4.setVisible(true);
                            textFieldNumeriMobili5.setText(getStrings.get(5));
                            textFieldNumeriMobili5.setVisible(true);
                            textFieldNumeriMobili6.setText(getStrings.get(6));
                            textFieldNumeriMobili6.setVisible(true);
                            textFieldNumeriMobili7.setText(getStrings.get(7));
                            textFieldNumeriMobili7.setVisible(true);
                            textFieldNumeriMobili8.setText(getStrings.get(8));
                            textFieldNumeriMobili8.setVisible(true);
                            textFieldNumeriMobili9.setText(getStrings.get(9));
                            textFieldNumeriMobili9.setVisible(true);
                            break;
                    }

                    //Settaggio Indirizzo principale
                    if (!c.getIndirizzoPrincipaleNoHTML(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())).equals("NOT FOUND")) {
                        textFieldIndirizzoPrincipale.setText(c.getIndirizzoPrincipaleNoHTML(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex())));
                    }

                    //Settaggio IndirizziSecondari
                    if(contIndirizziSecondari==1 && !textFieldIndirizziSecondari0.getText().equals("")){
                        c.getArrayIndirizziSecondari(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                        textFieldIndirizziSecondari0.setText(getStrings.get(0));
                    }
                    switch (contIndirizziSecondari) {
                        case 2:
                            c.getArrayIndirizziSecondari(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            break;
                        case 3:
                            c.getArrayIndirizziSecondari(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            break;
                        case 4:
                            c.getArrayIndirizziSecondari(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            textFieldIndirizziSecondari3.setText(getStrings.get(3));
                            textFieldIndirizziSecondari3.setVisible(true);
                            break;
                        case 5:
                            c.getArrayIndirizziSecondari(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            textFieldIndirizziSecondari3.setText(getStrings.get(3));
                            textFieldIndirizziSecondari3.setVisible(true);
                            textFieldIndirizziSecondari4.setText(getStrings.get(4));
                            textFieldIndirizziSecondari4.setVisible(true);
                            break;
                        case 6:
                            c.getArrayIndirizziSecondari(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            textFieldIndirizziSecondari3.setText(getStrings.get(3));
                            textFieldIndirizziSecondari3.setVisible(true);
                            textFieldIndirizziSecondari4.setText(getStrings.get(4));
                            textFieldIndirizziSecondari4.setVisible(true);
                            textFieldIndirizziSecondari5.setText(getStrings.get(5));
                            textFieldIndirizziSecondari5.setVisible(true);
                            break;
                        case 7:
                            c.getArrayIndirizziSecondari(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            textFieldIndirizziSecondari3.setText(getStrings.get(3));
                            textFieldIndirizziSecondari3.setVisible(true);
                            textFieldIndirizziSecondari4.setText(getStrings.get(4));
                            textFieldIndirizziSecondari4.setVisible(true);
                            textFieldIndirizziSecondari5.setText(getStrings.get(5));
                            textFieldIndirizziSecondari5.setVisible(true);
                            textFieldIndirizziSecondari6.setText(getStrings.get(6));
                            textFieldIndirizziSecondari6.setVisible(true);
                            break;
                        case 8:
                            c.getArrayIndirizziSecondari(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            textFieldIndirizziSecondari3.setText(getStrings.get(3));
                            textFieldIndirizziSecondari3.setVisible(true);
                            textFieldIndirizziSecondari4.setText(getStrings.get(4));
                            textFieldIndirizziSecondari4.setVisible(true);
                            textFieldIndirizziSecondari5.setText(getStrings.get(5));
                            textFieldIndirizziSecondari5.setVisible(true);
                            textFieldIndirizziSecondari6.setText(getStrings.get(6));
                            textFieldIndirizziSecondari6.setVisible(true);
                            textFieldIndirizziSecondari7.setText(getStrings.get(7));
                            textFieldIndirizziSecondari7.setVisible(true);
                            break;
                        case 9:
                            c.getArrayIndirizziSecondari(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            textFieldIndirizziSecondari3.setText(getStrings.get(3));
                            textFieldIndirizziSecondari3.setVisible(true);
                            textFieldIndirizziSecondari4.setText(getStrings.get(4));
                            textFieldIndirizziSecondari4.setVisible(true);
                            textFieldIndirizziSecondari5.setText(getStrings.get(5));
                            textFieldIndirizziSecondari5.setVisible(true);
                            textFieldIndirizziSecondari6.setText(getStrings.get(6));
                            textFieldIndirizziSecondari6.setVisible(true);
                            textFieldIndirizziSecondari7.setText(getStrings.get(7));
                            textFieldIndirizziSecondari7.setVisible(true);
                            textFieldIndirizziSecondari8.setText(getStrings.get(8));
                            textFieldIndirizziSecondari8.setVisible(true);
                            break;
                        case 10:
                            c.getArrayIndirizziSecondari(getStrings, pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                            textFieldIndirizziSecondari0.setText(getStrings.get(0));
                            textFieldIndirizziSecondari1.setText(getStrings.get(1));
                            textFieldIndirizziSecondari1.setVisible(true);
                            textFieldIndirizziSecondari2.setText(getStrings.get(2));
                            textFieldIndirizziSecondari2.setVisible(true);
                            textFieldIndirizziSecondari3.setText(getStrings.get(3));
                            textFieldIndirizziSecondari3.setVisible(true);
                            textFieldIndirizziSecondari4.setText(getStrings.get(4));
                            textFieldIndirizziSecondari4.setVisible(true);
                            textFieldIndirizziSecondari5.setText(getStrings.get(5));
                            textFieldIndirizziSecondari5.setVisible(true);
                            textFieldIndirizziSecondari6.setText(getStrings.get(6));
                            textFieldIndirizziSecondari6.setVisible(true);
                            textFieldIndirizziSecondari7.setText(getStrings.get(7));
                            textFieldIndirizziSecondari7.setVisible(true);
                            textFieldIndirizziSecondari8.setText(getStrings.get(8));
                            textFieldIndirizziSecondari8.setVisible(true);
                            textFieldIndirizziSecondari9.setText(getStrings.get(9));
                            textFieldIndirizziSecondari9.setVisible(true);
                            break;
                    }


                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Set interazioni reindirizzamenti in infoContattoPrivati
        btnReindirizzamentiPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    c.setReindirizzamenti(pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    if(c.getReindirizzamenti()==null){
                        img = c.SetImageSize(".images/warning.png",30,30);
                        JOptionPane.showMessageDialog(null,"Il contatto selezionato non ha reindirizzamenti!","ATTENZIONE!",1,img);
                    }else new InfoReindirizzamento(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Set interazioni lblMessengerPrivati
        img = new ImageIcon(".images/Messenger25x25.png");
        lblMessengerPrivati.setIcon(img);

        //Mouse entered
        lblMessengerPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Messenger30x30.png");
                lblMessengerPrivati.setIcon(img);
            }
        });
        //Mouse exited
        lblMessengerPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Messenger25x25.png");
                lblMessengerPrivati.setIcon(img);
            }
        });
        //mouse clicked
        lblMessengerPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    c.setImg(".images/Messenger512x512.png");
                    c.setEmail("Messenger",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    c.setUsername("Messenger",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    c.setStato("Messenger",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    new InfoServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Set Interazioni lblSkypePrivati
        img = new ImageIcon(".images/Skype25x25.png");
        lblSkypePrivati.setIcon(img);
        //Mouse entered
        lblSkypePrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Skype30x30.png");
                lblSkypePrivati.setIcon(img);
            }
        });
        //Mouse exited
        lblSkypePrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Skype25x25.png");
                lblSkypePrivati.setIcon(img);
            }
        });
        //mouse clicked
        lblSkypePrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    c.setImg(".images/Skype512x512.png");
                    c.setEmail("Skype",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    c.setUsername("Skype",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    c.setStato("Skype",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    new InfoServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Set Interazioni lblTeamsPrivati
        img  = new ImageIcon(".images/Teams25x25.png");
        lblTeamsPrivati.setIcon(img );
        //Mouse entered
        lblTeamsPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Teams30x30.png");
                lblTeamsPrivati.setIcon(img);
            }
        });
        //Mouse exited
        lblTeamsPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Teams25x25.png");
                lblTeamsPrivati.setIcon(img);
            }
        });
        //mouse clicked
        lblTeamsPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    c.setImg(".images/Teams512x512.png");
                    c.setEmail("Teams",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    c.setUsername("Teams",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    c.setStato("Teams",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    new InfoServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Set Interazioni lblWeChatPrivati
        img  = new ImageIcon(".images/WeChat25x25.png");
        lblWeChatPrivati.setIcon(img);
        //Mouse entered
        lblWeChatPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/WeChat30x30.png");
                lblWeChatPrivati.setIcon(img);
            }
        });
        //Mouse exited
        lblWeChatPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/WeChat25x25.png");
                lblWeChat.setIcon(img);
            }
        });
        //mouse clicked
        lblWeChatPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    c.setImg(".images/WeChat512x512.png");
                    c.setEmail("WeChat",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    c.setUsername("WeChat",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    c.setStato("WeChat",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    new InfoServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Set Interazioni lblWhatsappPrivati
        img  = new ImageIcon(".images/WhatsApp25x25.png");
        lblWhatsappPrivati.setIcon(img);
        //Mouse entered
        lblWhatsappPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Whatsapp30x30.png");
                lblWhatsappPrivati.setIcon(img);
            }
        });
        //Mouse exited
        lblWhatsappPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Whatsapp25x25.png");
                lblWhatsappPrivati.setIcon(img);
            }
        });
        //mouse clicked
        lblWhatsappPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    c.setImg(".images/Whatsapp512x512.png");
                    c.setEmail("Whatsapp",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    c.setUsername("Whatsapp",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    c.setStato("Whatsapp",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    new InfoServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Set Interazioni lblViberPrivati
        img = new ImageIcon(".images/Viber25x25.png");
        lblViberPrivati.setIcon(img);
        //Mouse entered
        lblViberPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Viber30x30.png");
                lblViberPrivati.setIcon(img);
            }
        });
        //Mouse exited
        lblViberPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Viber25x25.png");
                lblViberPrivati.setIcon(img);
            }
        });
        //mouse clicked
        lblViberPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    c.setImg(".images/Viber512x512.png");
                    c.setEmail("Viber",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    c.setUsername("Viber",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    c.setStato("Viber",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    new InfoServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Set Interazioni lblTelegramPrivati
        img = new ImageIcon(".images/Telegram25x25.png");
        lblTelegramPrivati.setIcon(img);
        //Mouse entered
        lblTelegramPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                img = new ImageIcon(".images/Telegram30x30.png");
                lblTelegram.setIcon(img);
            }
        });
        //Mouse exited
        lblTelegramPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                img = new ImageIcon(".images/Telegram25x25.png");
                lblTelegramPrivati.setIcon(img);
            }
        });
        //mouse clicked
        lblTelegramPrivati.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    c.setImg(".images/Telegram512x512.png");
                    c.setEmail("Telegram",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    c.setUsername("Telegram",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    c.setStato("Telegram",pkContattiPrivati.get(listAreaPrivata.getSelectedIndex()));
                    new InfoServizio(c);
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Interazione btnAggiornaModifica
        btnAggiornaModifica.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if (textFieldNome.getText().equals("")) {
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "Non è stato inserito il nome del contatto!", "ATTENZIONE!", 1, img);
                }
                //SE NON E' STATO INSERITO UN COGNOME AL CONTATTO NON CONTINUARE
                else if(textFieldCognome.getText().equals("")){
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "Non è stato inserito il cognome del contatto", "ATTENZIONE!", 1, img);
                }
                //SE NON E' STATO INSERITO UN INDIRIZZO PRINCIPALE AL CONTATTO NON CONTINUARE
                else if(textFieldIndirizzoPrincipale.getText().equals("")){
                    img = c.SetImageSize(".images/warning.png", 30, 30);
                    JOptionPane.showMessageDialog(null, "Non è stato inserito l'indirizzo principale del contatto!", "ATTENZIONE!", 1, img);
                }else{
                    try {
                        //QUERY CREA CONTATTO
                        c.setIdToLastMessaging(pkContatti.get(listContatti.getSelectedIndex()),(c.getLastId()));
                        c.setIdToLastReindirizzamenti(pkContatti.get(listContatti.getSelectedIndex()),(c.getLastId()));
                        if(c.getPath(pkContatti.get(listContatti.getSelectedIndex()))==null) {
                            c.cancellaContatto(pkContatti.get(listContatti.getSelectedIndex()));
                            if (jfc.getSelectedFile() == null) {
                                getpk = c.creaContatto("null", textFieldNome.getText(), textFieldCognome.getText(), contattoPrivatoCheckBox.isSelected());
                            } else {
                                getpk = c.creaContatto("'C:/Users/39366/IdeaProjects/Rubrica-java/.images/" + c.getLastId() + "'", textFieldNome.getText(), textFieldCognome.getText(), contattoPrivatoCheckBox.isSelected());
                            }
                        } else {
                            file = new File(c.getPath(pkContatti.get(listContatti.getSelectedIndex())));
                            file.renameTo(new File("C:/Users/39366/IdeaProjects/Rubrica-java/.images/" + c.getLastId()));
                            c.cancellaContatto(pkContatti.get(listContatti.getSelectedIndex()));
                            if (jfc.getSelectedFile() == null) {
                                getpk = c.creaContatto("null", textFieldNome.getText(), textFieldCognome.getText(), contattoPrivatoCheckBox.isSelected());
                            } else {
                                getpk = c.creaContatto("'C:/Users/39366/IdeaProjects/Rubrica-java/.images/" + c.getLastId() + "'", textFieldNome.getText(), textFieldCognome.getText(), contattoPrivatoCheckBox.isSelected());
                            }
                        }
                        //settaggio cont
                        if(contEmail==-1) contEmail=1;
                        if(contIndirizziSecondari==-1) contIndirizziSecondari=1;
                        if(contNumeriMobili==-1) contNumeriMobili=1;
                        if(contNumeriFissi==-1) contNumeriFissi=1;
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
                    //Refresh dlm contatti e dlm contattiprivati
                    DLMContatti.clear();
                    DLMContattiPrivati.clear();
                    try {
                        DLMContatti = c.getContatti(pkContatti);
                        listContatti.setModel(DLMContatti);                                         //Aggiungiamo nel JList i nomi e cognomi dei contatti
                        DLMContattiPrivati = c.getContattiPrivati(pkContattiPrivati);
                        listAreaPrivata.setModel(DLMContattiPrivati);
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                    //Chiusura pannello creazione contatto
                    panelInfoContatti.setVisible(false);

                    //MESSAGGIO DI CONFERMA CREAZIONE CONTATTO
                    img = c.SetImageSize(".images/creazionecontatto.png", 30, 30);
                    JOptionPane.showMessageDialog(null, textFieldNome.getText() + " " + textFieldCognome.getText() + " aggiornato/a con successo!", "CREAZIONE RIUSCITA!", 1, img);

                    //Settaggio di tutti i textField a default
                    //email
                    textFieldNome.setText("");
                    textFieldCognome.setText(null);
                    textFieldEmail0.setText("");
                    textFieldEmail1.setText("");
                    textFieldEmail1.setVisible(false);
                    textFieldEmail2.setText("");
                    textFieldEmail2.setVisible(false);
                    textFieldEmail3.setText("");
                    textFieldEmail3.setVisible(false);
                    textFieldEmail4.setText("");
                    textFieldEmail4.setVisible(false);
                    textFieldEmail5.setText("");
                    textFieldEmail5.setVisible(false);
                    textFieldEmail6.setText("");
                    textFieldEmail6.setVisible(false);
                    textFieldEmail7.setText("");
                    textFieldEmail7.setVisible(false);
                    textFieldEmail8.setText("");
                    textFieldEmail8.setVisible(false);
                    textFieldEmail9.setText("");
                    textFieldEmail9.setVisible(false);
                    //numeri fissi
                    textFieldNumeriFissi0.setText("");
                    textFieldNumeriFissi1.setText("");
                    textFieldNumeriFissi1.setVisible(false);
                    textFieldNumeriFissi2.setText("");
                    textFieldNumeriFissi2.setVisible(false);
                    textFieldNumeriFissi3.setText("");
                    textFieldNumeriFissi3.setVisible(false);
                    textFieldNumeriFissi4.setText("");
                    textFieldNumeriFissi4.setVisible(false);
                    textFieldNumeriFissi5.setText("");
                    textFieldNumeriFissi5.setVisible(false);
                    textFieldNumeriFissi6.setText("");
                    textFieldNumeriFissi6.setVisible(false);
                    textFieldNumeriFissi7.setText("");
                    textFieldNumeriFissi7.setVisible(false);
                    textFieldNumeriFissi8.setText("");
                    textFieldNumeriFissi8.setVisible(false);
                    textFieldNumeriFissi9.setText("");
                    textFieldNumeriFissi9.setVisible(false);
                    //Numeri mobili
                    textFieldNumeriMobili0.setText("");
                    textFieldNumeriMobili1.setText("");
                    textFieldNumeriMobili1.setVisible(false);
                    textFieldNumeriMobili2.setText("");
                    textFieldNumeriMobili2.setVisible(false);
                    textFieldNumeriMobili3.setText("");
                    textFieldNumeriMobili3.setVisible(false);
                    textFieldNumeriMobili4.setText("");
                    textFieldNumeriMobili4.setVisible(false);
                    textFieldNumeriMobili5.setText("");
                    textFieldNumeriMobili5.setVisible(false);
                    textFieldNumeriMobili6.setText("");
                    textFieldNumeriMobili6.setVisible(false);
                    textFieldNumeriMobili7.setText("");
                    textFieldNumeriMobili7.setVisible(false);
                    textFieldNumeriMobili8.setText("");
                    textFieldNumeriMobili8.setVisible(false);
                    textFieldNumeriMobili9.setText("");
                    textFieldNumeriMobili9.setVisible(false);
                    //indirizzo principale
                    textFieldIndirizzoPrincipale.setText("");
                    //indirizzi secondari
                    textFieldIndirizziSecondari0.setText("");
                    textFieldIndirizziSecondari1.setText("");
                    textFieldIndirizziSecondari1.setVisible(false);
                    textFieldIndirizziSecondari2.setText("");
                    textFieldIndirizziSecondari2.setVisible(false);
                    textFieldIndirizziSecondari3.setText("");
                    textFieldIndirizziSecondari3.setVisible(false);
                    textFieldIndirizziSecondari4.setText("");
                    textFieldIndirizziSecondari4.setVisible(false);
                    textFieldIndirizziSecondari5.setText("");
                    textFieldIndirizziSecondari5.setVisible(false);
                    textFieldIndirizziSecondari6.setText("");
                    textFieldIndirizziSecondari6.setVisible(false);
                    textFieldIndirizziSecondari7.setText("");
                    textFieldIndirizziSecondari7.setVisible(false);
                    textFieldIndirizziSecondari8.setText("");
                    textFieldIndirizziSecondari8.setVisible(false);
                    textFieldIndirizziSecondari9.setText("");
                    textFieldIndirizziSecondari9.setVisible(false);

                    //settaggio contatori
                    contEmail = 1;
                    contNumeriFissi = 1;
                    contNumeriMobili = 1;
                    contIndirizziSecondari = 1;

                    //Rimozione spunta JCheckBox
                    contattoPrivatoCheckBox.setSelected(false);

                    //Reset tasti
                    btnAggiornaModifica.setVisible(false);
                    btnAggiungi.setVisible(true);

                    //Eliminazione di tutti i reindirizzamenti e sistemi di messaging di cui non esistono più mail o numeri
                    try {
                        c.deleteReindirizzamento();
                        c.deleteSistemaMessaging();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }

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
