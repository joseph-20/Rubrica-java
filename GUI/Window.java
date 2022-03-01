package GUI;

import DAO.ContattoDAO;
import ImplementazionePostgresDAO.ImplementazioneContattoDAO;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;

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
    private JSplitPane SplitPaneContatti;
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
    DefaultListModel DLMIndirizzoPrincipale = new DefaultListModel();
    DefaultListModel DLMIndirizziSecondari = new DefaultListModel();
    DefaultListModel DLMEmail = new DefaultListModel();
    DefaultListModel DLMVuoto = new DefaultListModel();
    DefaultListModel DLMNumeriFissi = new DefaultListModel();
    DefaultListModel DLMNumeriMobili = new DefaultListModel();
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
    private JPanel panelMerda;
    private JPanel panelIndirizzoPrincipale;
    private JLabel lblIndirizzoPrincipale;
    private JPanel panelIndirizzoSecondario;
    private JLabel lblIndirizzoSecondario;
    private JScrollPane indirizziSecondariScroll;
    private JList indirizziSecondariList;
    private JPanel panelEmail;
    private JPanel panelNumeriMobili;
    private JPanel panelNumeriFissi;
    private JScrollPane numeriFissiScroll;
    private JList numeriFissiList;
    private JLabel lblNumeriMobili;
    private JLabel lblNumeriFissi;
    private JScrollPane numeriMobiliScroll;
    private JList numeriMobiliList;
    private JLabel lblEmail;
    private JScrollPane emailScroll;
    private JList emailList;
    private JPanel panelBottoniInfo;
    private JButton buttonModifica;
    private JButton eliminaButton;
    private ImageIcon img;
    private DefaultListCellRenderer renderer;

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
        frame.setMinimumSize (new Dimension (1200, 720));

        //Blocco scorrimento ScrollBar
        scrollPaneContatti.setViewportView(listContatti);    //Aggiungiamo una VerticalScrollBar alla JList
        scrollPaneContatti.setVisible(true);
        scrollPaneAreaPrivata.setViewportView(listAreaPrivata);
        scrollPaneAreaPrivata.setVisible(true);

        SplitPaneContatti.setEnabled(false);
        SplitPaneAreaPrivata.setEnabled(false);

        //Settaggio DLMVuoto
        DLMVuoto.addElement("NO VALUES FOUND");
        //Gestione zona contatti
        pkContatti = new ArrayList<Integer>();
        DLMContatti = c.getContatti(pkContatti);
        listContatti.setModel(DLMContatti);                                         //Aggiungiamo nel JList i nomi e cognomi dei contatti
        indirizzoPrincipaleList.setModel(DLMIndirizzoPrincipale);

        //Gestione zona contatti privati
        pkContattiPrivati = new ArrayList<Integer>();
        DLMContattiPrivati = c.getContattiPrivati(pkContattiPrivati);
        listAreaPrivata.setModel(DLMContattiPrivati);                               //Aggiungiamo nel JList i nomi e cognomi dei contatti

        //Listener contatto click
        listContatti.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    //SET INDIRIZZO PRINCIPALE
                    DLMIndirizzoPrincipale = c.getIndirizzoPrincipale(pkContatti.get(listContatti.getSelectedIndex()));
                    indirizzoPrincipaleList.setModel(DLMIndirizzoPrincipale);
                    //SET NOME
                    lblNome.setText(c.getNome(pkContatti.get(listContatti.getSelectedIndex())));
                    //SET COGNOME
                    lblCognome.setText(c.getCognome(pkContatti.get(listContatti.getSelectedIndex())));


                    //SET INDIRIZZI SECONDARI
                    DLMIndirizziSecondari = c.getIndirizziSecondari(pkContatti.get(listContatti.getSelectedIndex()));
                    //SE NON CI SONO INDIRIZZI SECONDARI MOSTRA 'NO VALUES FOUND' CON UN ALLINEAMENTO CENTRALE
                    if(DLMIndirizziSecondari.isEmpty()){
                        indirizziSecondariList.setModel(DLMVuoto);
                        indirizziSecondariList.setVisibleRowCount(1);
                        renderer =  (DefaultListCellRenderer)indirizziSecondariList.getCellRenderer();
                        renderer.setHorizontalAlignment(JLabel.CENTER);
                    }else {
                        //ALTRIMENTI MOSTRA CON UN ALLINEAMENTO A EAST GLI INDIRIZZI
                        indirizziSecondariList.setModel(DLMIndirizziSecondari);
                        renderer =  (DefaultListCellRenderer)indirizziSecondariList.getCellRenderer();
                        renderer.setHorizontalAlignment(0);
                        if(DLMIndirizziSecondari.getSize()==1) indirizziSecondariList.setVisibleRowCount(1);
                        else if(DLMIndirizziSecondari.getSize()==2) indirizziSecondariList.setVisibleRowCount(2);
                        else indirizziSecondariList.setVisibleRowCount(3);

                    }

                    //SET EMAIL
                    DLMEmail = c.getEmail(pkContatti.get(listContatti.getSelectedIndex()));
                    //SE NON CI SONO EMAIL MOSTRA 'NO VALUES FOUND' CON UN ALLINEAMENTO CENTRALE
                    if(DLMEmail.isEmpty()){
                        emailList.setModel(DLMVuoto);
                        emailList.setVisibleRowCount(1);
                        renderer =  (DefaultListCellRenderer)emailList.getCellRenderer();
                        renderer.setHorizontalAlignment(JLabel.CENTER);
                    }else{
                        //ALTRIMENTI MOSTRA CON UN ALLINEAMENTO A EAST LE EMAIL
                        emailList.setModel(DLMEmail);
                        renderer =  (DefaultListCellRenderer)emailList.getCellRenderer();
                        renderer.setHorizontalAlignment(0);
                        if(DLMEmail.getSize()==1) emailList.setVisibleRowCount(1);
                        else if(DLMEmail.getSize()==2) emailList.setVisibleRowCount(2);
                        else emailList.setVisibleRowCount(3);
                    }

                    //SET NUMERI FISSI
                    DLMNumeriFissi = c.getNumeriFissi(pkContatti.get(listContatti.getSelectedIndex()));
                    //SE NON CI SONO NUMERI FISSI MOSTRA 'NO VALUES FOUND' CON UN ALLINEAMENTO CENTRALE
                    if(DLMNumeriFissi.isEmpty()){
                        numeriFissiList.setModel(DLMVuoto);
                        numeriFissiList.setVisibleRowCount(1);
                        renderer =  (DefaultListCellRenderer)numeriFissiList.getCellRenderer();
                        renderer.setHorizontalAlignment(JLabel.CENTER);
                    }else{
                        //ALTRIMENTI MOSTRA CON UN ALLINEAMENTO A EAST I NUMERI FISSI
                        numeriFissiList.setModel(DLMNumeriFissi);
                        renderer =  (DefaultListCellRenderer)numeriFissiList.getCellRenderer();
                        renderer.setHorizontalAlignment(0);
                        if(DLMNumeriFissi.getSize()==1) numeriFissiList.setVisibleRowCount(1);
                        else if(DLMNumeriFissi.getSize()==2) numeriFissiList.setVisibleRowCount(2);
                        else numeriFissiList.setVisibleRowCount(3);
                    }

                    //SET NUMERI MOBILI
                    DLMNumeriMobili = c.getNumeriMobili(pkContatti.get(listContatti.getSelectedIndex()));
                    //SE NON CI SONO NUMERI MOBILI MOSTRA 'NO VALUES FOUND' CON UN ALLINEAMENTO CENTRALE
                    if(DLMNumeriMobili.isEmpty()){
                        numeriMobiliList.setModel(DLMVuoto);
                        numeriMobiliList.setVisibleRowCount(1);
                        renderer =  (DefaultListCellRenderer)numeriMobiliList.getCellRenderer();
                        renderer.setHorizontalAlignment(JLabel.CENTER);
                    }else{
                        //ALTRIMENTI MOSTRA CON UN ALLINEAMENTO A EAST I NUMERI MOBILI
                        numeriMobiliList.setModel(DLMNumeriMobili);
                        renderer =  (DefaultListCellRenderer)numeriMobiliList.getCellRenderer();
                        renderer.setHorizontalAlignment(0);
                        if(DLMNumeriMobili.getSize()==1) numeriMobiliList.setVisibleRowCount(1);
                        else if(DLMNumeriMobili.getSize()==2) numeriMobiliList.setVisibleRowCount(2);
                        else numeriMobiliList.setVisibleRowCount(3);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        //Set foto del contatto
        img = new ImageIcon(".images/user200x200.png");
        lblFoto.setIcon(img);
        lblFoto.setVisible(true);
        indirizzoPrincipaleList.setBorder(BorderFactory.createLineBorder(Color.gray));

        //Set Interazioni lblMessenger
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
