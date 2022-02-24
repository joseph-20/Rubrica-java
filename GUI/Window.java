package GUI;

import Database.ConnessioneDatabase;
import Model.Contatto;
import org.postgresql.util.PSQLException;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

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
    private JList list1;

    public Window() throws SQLException{
        Controller c = new Controller();
        run(c);
    }

    private void run(Controller c) throws SQLException {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        } catch (InstantiationException e1) {
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (UnsupportedLookAndFeelException e1) {
            e1.printStackTrace();
        }

        //Creazione finestra principale
        JFrame frame = new JFrame("Rubrica");
        frame.setContentPane(this.panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(1000, 750));

        //Connessione al database
        Connection con = c.getConnection();

        //Creazione della JList per la finestra Contatti
        ResultSet set;
        Statement s;
        s=con.createStatement();
        set = s.executeQuery("SELECT *" +
                "FROM CONTATTO");
        DefaultListModel DLM = new DefaultListModel();
        while(set.next()){
            Contatto cont = new Contatto();
            System.out.println(set.getString("Nome"));
            cont.setContatto(set.getString("nome"), set.getString("cognome"), set.getString("foto"), set.getBoolean("security"));
            DLM.addElement(cont.getNome()+" "+cont.getCognome());
        }
        list1.setModel(DLM);
    }


    public static void main(String[] args) throws SQLException{
        new Window();

    }

}
