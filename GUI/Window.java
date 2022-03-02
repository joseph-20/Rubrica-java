package GUI;

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
    private JButton buttonModifica;
    private JButton eliminaButton;
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

        //Gestione zona contatti
        pkContatti = new ArrayList<Integer>();
        DLMContatti = c.getContatti(pkContatti);
        listContatti.setModel(DLMContatti);                                         //Aggiungiamo nel JList i nomi e cognomi dei contatti

        //Gestione zona contatti privati
        pkContattiPrivati = new ArrayList<Integer>();
        DLMContattiPrivati = c.getContattiPrivati(pkContattiPrivati);
        listAreaPrivata.setModel(DLMContattiPrivati);                               //Aggiungiamo nel JList i nomi e cognomi dei contatti

        //SETTAGGIO LBL INIZIALI
        lblEmail.setText("<html>Email<br/><html>");
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
                        lblGetNumeriMobili.setText(c.getNumeriFissi(pkContatti.get(listContatti.getSelectedIndex())));
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
        img = new ImageIcon(".images/user200x200.png");
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
