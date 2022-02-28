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
    private ContattoDAO contact = new ImplementazioneContattoDAO();
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
    private JList numeriMobiliList;
    private JLabel numeriFissiLabel;
    private JLabel numeriMobiliLabel;
    private JScrollPane numeriMobiliScroll;
    private JScrollPane numeriFissiScroll;
    private JList numeriFissiList;
    private JScrollPane emailScroll;
    private JList emailList;
    private JList indirizzoPrincipaleList;
    private JButton reindirizzamentiButton;
    private JPanel panelServizi;
    private JLabel lblMessenger;
    private JLabel lblWhatsapp;
    private JLabel lblViber;
    private JLabel lblTelegram;
    private JLabel lblSkype;
    private JLabel lblWeChat;
    private JLabel lblTeams;

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
        DLMContatti = contact.getContatti(pkContatti);
        listContatti.setModel(DLMContatti);                                         //Aggiungiamo nel JList i nomi e cognomi dei contatti

        //Gestione zona contatti privati
        pkContattiPrivati = new ArrayList<Integer>();
        DLMContattiPrivati = contact.getContattiPrivati(pkContattiPrivati);
        listAreaPrivata.setModel(DLMContattiPrivati);                               //Aggiungiamo nel JList i nomi e cognomi dei contatti

        ImageIcon icon = new ImageIcon(".images/contact200.jpg");
        lblFoto.setIcon(icon);
        lblFoto.setVisible(true);
        indirizzoPrincipaleList.setBorder(BorderFactory.createLineBorder(Color.gray));
        icon = new ImageIcon(".images/Messenger25x25.png");
        lblMessenger.setIcon(icon);
        icon = new ImageIcon(".images/Skype25x25.png");
        lblSkype.setIcon(icon);
        icon = new ImageIcon(".images/Teams25x25.png");
        lblTeams.setIcon(icon);
        icon = new ImageIcon(".images/WeChat25x25.png");
        lblWeChat.setIcon(icon);
        icon = new ImageIcon(".images/WhatsApp25x25.png");
        lblWhatsapp.setIcon(icon);
        icon = new ImageIcon(".images/Viber25x25.png");
        lblViber.setIcon(icon);
        icon = new ImageIcon(".images/Telegram25x25.png");
        lblTelegram.setIcon(icon);
        icon = new ImageIcon(".images/Messenger30x30.png");
        ImageIcon finalIcon = icon;
        icon = new ImageIcon(".images/Messenger30x30.png");
        ImageIcon icon2 = new ImageIcon(".images/Messenger25x25.png");
        lblMessenger.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseEntered(MouseEvent e) {
                super.mouseEntered(e);
                lblMessenger.setIcon(finalIcon);
            }
        });
        lblMessenger.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                lblMessenger.setIcon(icon2);
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
