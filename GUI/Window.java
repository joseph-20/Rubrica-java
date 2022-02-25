package GUI;

import DAO.ContattoDAO;
import ImplementazionePostgresDAO.ImplementazioneContattoDAO;
import Model.Contatto;

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
    private JPanel panelInfoMail;
    private JLabel lblEmailContatto;
    private JPanel panelBackgroundInfoIndirizzo;
    private JPanel panelInfoIndirizzo;
    private JLabel lblIndirizzo;
    private JList listAreaPrivata;
    private JScrollPane scrollPaneAreaPrivata;

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
        frame.setMinimumSize(new Dimension(1000, 750));

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


    }


    public static void main(String[] args) throws SQLException{
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //System Look And Feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new Window();
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
