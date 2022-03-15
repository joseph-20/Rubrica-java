package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class AggiornaPassword {
    private JPanel panelTitolo;
    private JLabel lblCreaPassword;
    private JPanel panelMain;
    private JPanel panelVecchiaPass;
    private JPasswordField passwordField1;
    private JLabel lblVecchiaPassword;
    private JPanel panelNuovaPass;
    private JLabel lblNuovaPassword;
    private JPasswordField passwordField2;
    private JLabel lblRipetiNuovaPassword;
    private JPasswordField passwordField3;
    private JPanel panelRipetiPass;
    private JPanel panelBottoni;
    private JButton annullaButton;
    private JButton confermaButton;
    private ImageIcon img;

    public AggiornaPassword(Controller c) throws SQLException {
        esegui(c);
    }

    private void esegui(Controller c) throws SQLException {

        JDialog dialog = new JDialog(new Frame(), "AGGIORNA PASSWORD");

        //Interazione btnAnnulla
        annullaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                c.getJTabs().setSelectedIndex(c.getLastInt());
                img = c.SetImageSize(".images/warning.png",30,30);
                JOptionPane.showMessageDialog(null,"Nessun aggiornamento alla password effettuato!","ATTENZIONE!",1,img);
                dialog.dispose();
            }
        });

        dialog.setModal (true);
        dialog.setModalityType (Dialog.ModalityType.APPLICATION_MODAL);
        dialog.add(panelMain);
        dialog.setUndecorated(true);
        dialog.setMinimumSize (new Dimension(550, 300));

        //Settaggio finestra al centro
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        dialog.setBounds(center.x - 550 / 2, center.y - 220 / 2, 550, 300);
        dialog.setVisible(true);
    }
}
