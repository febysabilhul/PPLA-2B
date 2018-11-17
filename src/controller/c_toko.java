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
import javax.swing.JButton;
import javax.swing.JOptionPane;
import model.m_aset;
import view.home;
import view.toko;

/**
 *
 * @author BoniBarBar
 */
public class c_toko {

    private toko vToko;
    private home vHome;
    private m_aset mAset;
    private String username;
    private int hargaBibit = 100;
    private int hargapupuk = 90;
    private int hargaobat = 70;
private JButton btnItem1;
private JButton btnItem2;
private JButton btnItem3;

    public c_toko(home vHome, String username) throws SQLException {
        vToko = new toko();
        mAset = new m_aset();
        this.vHome = vHome;
        this.username = username;
//
//        vToko.getBtnKembali().addActionListener(new kembaliAction());
        vToko.getBtnItem1().addActionListener(new bibitAction());
        vToko.getBtnItem2().addActionListener(new pupukAction());
        vToko.getBtnItem3().addActionListener(new pupukAction());
        vToko.getBtnKembali().addActionListener(new kembaliAction());
    }

    private class bibitAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(vHome, "Yakin beli..?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    mAset.updateKoin(mAset.getKoin(mAset.cekIdPlayer(username)) - hargaBibit, mAset.cekIdPlayer(username));
                    mAset.updateBibit(mAset.getBibit(mAset.cekIdPlayer(username)) + 1, mAset.cekIdPlayer(username));
                    vToko.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                    vToko.getLblBibit().setText(mAset.getBibit(mAset.cekIdPlayer(username)) + "");
                     btnItem1.setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/Bibit Highlight.png")));
                } catch (SQLException ex) {
                    Logger.getLogger(c_toko.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }

    private class pupukAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(vHome, "Yakin beli..?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    mAset.updateKoin(mAset.getKoin(mAset.cekIdPlayer(username)) - hargapupuk, mAset.cekIdPlayer(username));
                    mAset.updatePupuk(mAset.getPupuk(mAset.cekIdPlayer(username)) + 1, mAset.cekIdPlayer(username));
                    vToko.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                    vToko.getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_toko.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    private class obatAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (JOptionPane.showConfirmDialog(vHome, "Yakin beli..?", null, JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                try {
                    mAset.updateKoin(mAset.getKoin(mAset.cekIdPlayer(username)) - hargapupuk, mAset.cekIdPlayer(username));
                    mAset.updateObat(mAset.getObat(mAset.cekIdPlayer(username)) + 1, mAset.cekIdPlayer(username));
                    vToko.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                    vToko.getLblObat().setText(mAset.getObat(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_toko.class.getName()).log(Level.SEVERE, null, ex);
                }
            }

        }
    }

    private class kembaliAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vToko.setVisible(false);
            vHome.setVisible(true);
            vHome.toFront();
           
             try {
                vHome.getLblBibit().setText(mAset.getBibit(mAset.cekIdPlayer(username)) + "");
                vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username))+"");
                vHome.getLblObat().setText(mAset.getObat(mAset.cekIdPlayer(username)) + "");
                vHome.getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");
            } catch (SQLException ex) {
                Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
            }
            try {
                vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username))+"");
                vHome.getLblObat().setText(mAset.getObat(mAset.cekIdPlayer(username)) + "");
                vHome.getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");
                vHome.getLblBibit().setText(mAset.getBibit(mAset.cekIdPlayer(username)) + "");
            } catch (SQLException ex) {
                Logger.getLogger(c_toko.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public toko getView() {
        return vToko;
    }
}
