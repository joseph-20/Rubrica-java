package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.sql.SQLException;

public class CreaReindirizzamento {
    private JPanel panelMain;

    public CreaReindirizzamento(Controller c) throws SQLException {
        esegui(c);
    }

    private void esegui(Controller c) throws SQLException{

        JFrame frame = new JFrame("Servizio");
        frame.setContentPane(this.panelMain);
        frame.setMinimumSize (new Dimension(300, 200));
        frame.setVisible(true);

        //Settaggio finestra al centro
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        frame.setBounds(center.x - 300 / 2, center.y - 200 / 2, 300, 200);
    }
}
