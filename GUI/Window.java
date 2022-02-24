package GUI;

import Model.Contatto;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ComponentAdapter;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.*;
import java.util.ArrayList;
import javax.swing.UIManager.*;
import javax.swing.event.ListSelectionListener;

import Controller.Controller;

public class Window {
    //Dichiarazioni
    private ResultSet rs;
    private Statement s;
    private ArrayList<Integer> pk;
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
        s = con.createStatement();

        //QUERY DI SELEZIONE DEI CONTATTI
        rs = s.executeQuery("SELECT * " +
                            "FROM CONTATTO " +
                            "WHERE SECURITY = FALSE " +
                            "ORDER BY NOME,COGNOME");

        DefaultListModel DLM = new DefaultListModel();
        pk= new ArrayList<Integer>();
        while(rs.next()){                                   //Finche non scorro tutto il resultSet
            Contatto cont = new Contatto();
            cont.setContatto(rs.getString("nome"), rs.getString("cognome"), rs.getString("foto"), rs.getBoolean("security"));
            DLM.addElement(cont.getNome()+" "+cont.getCognome());
            pk.add(rs.getInt("id"));
        }
        listContatti.setModel(DLM);                         //Aggiungiamo nel JList i nomi e cognomi dei contatti
        scrollPaneContatti.setViewportView(listContatti);   //Aggiungiamo una VerticalScrollBar alla JList
        scrollPaneContatti.setVisible(true);

        listContatti.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                try {
                    rs = s.executeQuery("SELECT * FROM email where id_contatto ="+pk.get(listContatti.getSelectedIndex()));
                    while(rs.next()) {
                        System.out.println("Email: "+rs.getString("username") + "@" + rs.getString("dominio"));
                    }
                    rs = s.executeQuery("SELECT * FROM indirizzo_principale where id_contatto ="+pk.get(listContatti.getAnchorSelectionIndex()));
                    while(rs.next()){
                        System.out.println("Indirizzo principale:"+" "+rs.getString("via")+" "+rs.getString("civico")+"\nCittà : "+rs.getString("citta"));
                    }
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
