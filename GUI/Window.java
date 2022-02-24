package GUI;

import Model.Contatto;

import javax.swing.*;
import java.awt.*;
import java.sql.*;
import javax.swing.UIManager.*;

import Controller.Controller;

public class Window {
    //Dichiarazioni
    private JPanel panel;
    private JTabbedPane Tabs;
    private JSplitPane SplitPaneAreaPrivata;
    private JSplitPane SplitPaneContatti;
    private JPanel ListaContatti;
    private JPanel InfoContatti;
    private JPanel ListaContattiPrivata;
    private JPanel InfoContattiPrivata;
    private JButton aggiungiContattoButton;
    private JButton creaGruppoButton;
    private JPanel PanelBottoni;
    private JPanel PanelBottoniPrivati;
    private JButton aggiungiContattoPrivatoButton;
    private JList listContatti;
    private JScrollPane scrollPaneContatti;

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

        //Connessione al database
        Connection con = c.getConnection();

        //Creazione della JList per la finestra Contatti
        ResultSet rs;
        Statement s;
        s = con.createStatement();

        //QUERY DI SELEZIONE DEI CONTATTI
        rs = s.executeQuery("SELECT * " +
                            "FROM CONTATTO " +
                            "WHERE SECURITY = FALSE " +
                            "ORDER BY NOME,COGNOME");

        DefaultListModel DLM = new DefaultListModel();

        while(rs.next()){                                   //Finche non scorro tutto il resultSet
            Contatto cont = new Contatto();
            cont.setContatto(rs.getString("nome"), rs.getString("cognome"), rs.getString("foto"), rs.getBoolean("security"));
            DLM.addElement(cont.getNome()+" "+cont.getCognome());
        }
        listContatti.setModel(DLM);                         //Aggiungiamo nel JList i nomi e cognomi dei contatti
        scrollPaneContatti.setViewportView(listContatti);   //Aggiungiamo una VerticalScrollBar alla JList
        scrollPaneContatti.setVisible(true);
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
