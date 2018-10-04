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
import model.m_aset;
import view.home;
import view.toko;
import view.keranjang;

public class c_home {

    private home vHome;
    private m_aset mAset;
    private toko vtoko;
    private keranjang vkeranjang;
    private String username;

    public c_home(String username) throws SQLException {
        vHome = new home();
        mAset = new m_aset();
        this.username = username;
        vHome.getBtntoko().addActionListener(new tokoAction());
        vHome.getBtnkeranjang().addActionListener(new keranjangAction());
        
//        vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
//        vHome.getLblJagung().setText(mAset.getJagung(mAset.cekIdPlayer(username)) + "");
//        vHome.getLblMarning().setText((mMarning.getMarningA(mMarning.cekIdPlayer(username)) + mMarning.getMarningB(mMarning.cekIdPlayer(username))
//                + mMarning.getMarningC(mMarning.cekIdPlayer(username))) + "");
   vHome.getLabelUsername().setText(username);
        vHome.setVisible(true);
    }

    private class tokoAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vHome.setVisible(false);
            vtoko.setVisible(true);
        }

    }

    private class keranjangAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vHome.setVisible(false);
            vkeranjang.setVisible(true);
        }

    }

}
