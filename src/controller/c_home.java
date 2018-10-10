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
import javax.swing.JLabel;
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
     private JButton petak[] = new JButton[6];
      private JLabel air[] = new JLabel[6];
     private int statusKotak[] = {1, 1, 1, 1, 1, 1};
    private int statusTime1[] = {0, 0, 0, 0, 0, 0};
    private int statusTime2[] = {0, 0, 0, 0, 0, 0};
    private int statusTime3[] = {0, 0, 0, 0, 0, 0};
        private int bibit;


    public c_home(String username) throws SQLException {
        vHome = new home();
        mAset = new m_aset();
        this.username = username;
        vHome.getBtntoko().addActionListener(new tokoAction());
//        vHome.getBtnkeranjang().addActionListener(new keranjangAction());
         petak[0] = vHome.getBtnKotak1();
        petak[1] = vHome.getBtnKotak2();
        petak[2] = vHome.getBtnKotak3();
        petak[3] = vHome.getBtnKotak4();
        petak[4] = vHome.getBtnKotak5();
        petak[5] = vHome.getBtnKotak6();
        air[0] = vHome.getLblAir1();
        air[1] = vHome.getLblAir2();
        air[2] = vHome.getLblAir3();
        air[3] = vHome.getLblAir4();
        air[4] = vHome.getLblAir5();
        air[5] = vHome.getLblAir6();
//        vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
//        vHome.getLblJagung().setText(mAset.getJagung(mAset.cekIdPlayer(username)) + "");
//        vHome.getLblMarning().setText((mMarning.getMarningA(mMarning.cekIdPlayer(username)) + mMarning.getMarningB(mMarning.cekIdPlayer(username))
//                + mMarning.getMarningC(mMarning.cekIdPlayer(username))) + "");
   for (int i = 0; i < air.length; i++) {
            air[i].setVisible(false);
        }
        bibit = mAset.getBibit(mAset.cekIdPlayer(username));
        
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

    private class kotak1Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
    if (statusKotak[0] == 1) {//kosong
                if (bibit > 0) {
                    vHome.getBtnKotak1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/tanahBerjagung.png")));
                   vHome.getBtnKotak1().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isisawah/tanahBerjagung.png")));
                    statusKotak[0] = 2;
                    bibit -= 1;
                    try {
                        mAset.updateBibit(bibit, mAset.cekIdPlayer(username));
                        vHome.getLblBibit().setText(mAset.getBibit(mAset.cekIdPlayer(username)) + "");
                    } catch (SQLException ex) {
                        Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                } else {
                    JOptionPane.showMessageDialog(vHome, "Tidak punya bibit");
                }
//            } else if (statusKotak[0] == 3) {//tumbuh 
//                vHome.getBtnKotak1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isisawah/tanah kosong.png")));
//                vHome.getBtnKotak1().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/isisawah/tanah kosong.png")));
//                jagung += random.nextInt((3 - 2) + 1) + 2;
//                try {
//                    mAset.updateJagung(jagung, mAset.cekIdPlayer(username));
//                    vSawah.getLblJagung().setText(mAset.getJagung(mAset.cekIdPlayer(username)) + "");
//                } catch (SQLException ex) {
//                    Logger.getLogger(c_sawah.class.getName()).log(Level.SEVERE, null, ex);
//                }
//                statusKotak[0] = 1;
//                statusSiram[0] = false;
//                statusTime1[0] = 0;
//                statusTime2[0] = 0;
//                statusTime3[0] = 0;
//            
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
}
