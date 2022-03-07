package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class InfoServizio {
    private JLabel lblFotoServizio;
    private JLabel lblEmailAssociateServizio;
    private JLabel lblStatoServizio;
    private JPanel panelMain;

    public InfoServizio() throws SQLException {
        Controller c = new Controller();
        esegui(c);
}

    private void esegui(Controller c) throws SQLException{
        //Creazione finestra principale
        JFrame frame = new JFrame("Servizio");
        frame.setContentPane(this.panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize (new Dimension(800, 600));
        frame.setVisible(true);
    }

    public static void main(String[] args) throws SQLException{
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); //System Look And Feel
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
            e.printStackTrace();
        }
        new InfoServizio();
    }


}
