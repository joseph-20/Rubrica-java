package GUI;

import Controller.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.SQLException;

public class CreaPassword {
    private JPanel panelMain;
    private JPanel panelTitolo;
    private JLabel lblCreaPassword;
    private JLabel lblInseriscsiPassword;
    private JLabel lblConfermaPassword;
    private JPasswordField passwordField2;
    private JPanel panelConfermaPassword;
    private JPanel panelBottoni;
    private JButton annullaButton;
    private JButton confermaButton;
    private JPasswordField passwordField1;
    private JPanel panelCreaPassword;
    private ImageIcon img;

    public CreaPassword(Controller c) throws SQLException {
        esegui(c);
    }

    private void esegui(Controller c) throws SQLException {

        JDialog dialog = new JDialog(new Frame(),"CREAZIONE PASSWORD");

        //Interazione btnAnnulla
        annullaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                c.getJTabs().setSelectedIndex(c.getLastInt());
                img = c.SetImageSize(".images/warning.png",30,30);
                JOptionPane.showMessageDialog(null,"Nessuna password inserita, ACCESSO NEGATO!","ATTENZIONE!",1,img);
                dialog.dispose();
            }
        });

        //Interazione btnConferma
        confermaButton.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                if(!String.valueOf(passwordField1.getPassword()).equals(String.valueOf(passwordField2.getPassword()))){
                    img = c.SetImageSize(".images/warning.png",30,30);
                    JOptionPane.showMessageDialog(null,"Le due password inserite non coincidono!","ATTENZIONE!",1,img);
                }
                else if(String.valueOf(passwordField1.getPassword()).equals("")&&String.valueOf(passwordField2.getPassword()).equals("")){
                    img = c.SetImageSize(".images/warning.png",30,30);
                    JOptionPane.showMessageDialog(null,"Non è possibile inserire password con campi vuoti!","ATTENZIONE!",1,img);
                }else{
                    try {
                        c.setPassword(String.valueOf(passwordField1.getPassword()));
                        img = c.SetImageSize(".images/creazionecontatto.png",30,30);
                        JOptionPane.showMessageDialog(null,"Password creata con successo!","SUCCESSO!",1,img);
                        dialog.dispose();
                    } catch (SQLException ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });
        dialog.setModal (true);
        dialog.setModalityType (Dialog.ModalityType.APPLICATION_MODAL);
        dialog.add(panelMain);
        dialog.setUndecorated(true);
        dialog.setMinimumSize (new Dimension(450, 250));

        //Settaggio finestra al centro
        Point center = GraphicsEnvironment.getLocalGraphicsEnvironment().getCenterPoint();
        dialog.setBounds(center.x - 450 / 2, center.y - 200 / 2, 450, 250);
        dialog.setVisible(true);

    }
}



