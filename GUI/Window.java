package GUI;

import Database.ConnessioneDatabase;
import org.postgresql.util.PSQLException;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

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


    public static void run() {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (InstantiationException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (IllegalAccessException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (UnsupportedLookAndFeelException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
        JFrame frame = new JFrame("Rubrica");
        frame.setContentPane(new Window().panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        frame.setMinimumSize(new Dimension(1000, 750));
    }

    public static void main(String[] args) throws SQLException {
        run();
        ConnessioneDatabase conn = new ConnessioneDatabase();

    }
}
