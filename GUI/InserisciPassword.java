package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class InserisciPassword {
    private JPanel panelTitolo;
    private JLabel lblTitolo;
    private JPanel panelMain;
    private JPasswordField passwordField1;
    private JLabel lblInseriscsiPassword;
    private JPanel panelBottoni;
    private JButton annullaButton;
    private JButton confermaButton;
    private ImageIcon img;

    public InserisciPassword(Controller c) throws SQLException {
        esegui(c);
    }

    private void esegui(Controller c) throws SQLException {
        JDialog dialog = new JDialog(new Frame(),"CREDENZIALI AREA PRIVATA");

        //Interazione btnAnnulla
        annullaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                c.getJTabs().setSelectedIndex(c.getLastInt());
                img = c.SetImageSize(".images/warning.png",30,30);
                JOptionPane.showMessageDialog(null,"Nessuna password inserita, ACCESSO NEGATO!","ATTENZIONE!",1,img);
                c.getPanel().setVisible(false);
                dialog.dispose();
            }
        });

        //Interazione btnConferma
        confermaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                try {
                    if(String.valueOf(passwordField1.getPassword()).equals(c.getPassword())){
                        img = c.SetImageSize(".images/creazionecontatto.png",30,30);
                        JOptionPane.showMessageDialog(null,"Password corretta!","SUCCESSO!",1,img);
                        dialog.dispose();
                    }else{
                        img = c.SetImageSize(".images/warning.png",30,30);
                        JOptionPane.showMessageDialog(null,"Password sbagliata!","ATTENZIONE!",1,img);
                    }
                } catch (SQLException ex) {
                    ex.printStackTrace();
                }
            }
        });

        dialog.setModal (true);
        dialog.setModalityType (Dialog.ModalityType.APPLICATION_MODAL);
        dialog.add(panelMain);
        dialog.setUndecorated(true);
        dialog.setMinimumSize (new Dimension(550, 200));

        //Settaggio finestra al centro
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        dialog.setBounds(center.x - 550 / 2, center.y - 200 / 2, 550, 200);
        dialog.setVisible(true);
    }
}
