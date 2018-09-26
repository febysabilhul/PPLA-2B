/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import view.MainMenu;
import view.Petunjuk;
import view.Tentang;
import view.load;
import model.m_player;

/**
 *
 * @author BoniBarBar
 */
public class cMenu {

    private Tentang viewtentang;
    private Petunjuk viewpetunjuk;
    private MainMenu viewMenu;
    private load viewLoad;
    private m_player mPlayer;

    public cMenu() throws SQLException, InterruptedException {
        viewMenu = new MainMenu();
        viewtentang = new Tentang();
        viewLoad = new load();
        mPlayer = new m_player();
        viewMenu.getBtnMulai().addActionListener(new mulaiAction());
          viewMenu.getBtnAbout().addActionListener(new aboutAction());
          viewMenu.getBtnPetunjuk().addActionListener(new aboutAction());

    }
       private class aboutAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            viewtentang.setVisible(true);
            viewMenu.setVisible(false);
        }

    }
       
       private class petunjukAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        viewpetunjuk.setVisible(true);
        viewMenu.setVisible(false);
        }
           
       }

    private class mulaiAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
        }
    }
     private class keluarAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(viewMenu, "Yakin Keluar Game..???",null,JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                System.exit(0);
            }
        }

    }
}
