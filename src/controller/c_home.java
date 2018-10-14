/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.Random;
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
    private JButton petak[] = new JButton[6];
    private JLabel air[] = new JLabel[6];
    private int statusKotak[] = {1, 1, 1, 1, 1, 1};
    private int statusTime1[] = {0, 0, 0, 0, 0, 0};
    private int statusTime2[] = {0, 0, 0, 0, 0, 0};
    private int statusTime3[] = {0, 0, 0, 0, 0, 0};
    private boolean statusSiram[] = {false, false, false, false, false, false};
    private int bibit;
    private int kopi;
    private int pupuk;
    private int obat;
    private int koin;
    private String username;
    private int detikSiram = 0;
    private boolean detikSiram1 = false;
    private Random random = new Random();

    public c_home(String username) throws SQLException {
        vHome = new home();
        mAset = new m_aset();
        this.username = username;
        vHome.getBtntoko().addActionListener(new tokoAction());
        vHome.getBtnCangkul().addActionListener(new cangkulAction());
        vHome.getLblusername().setText(username);
        vHome.setVisible(true);

//        vHome.getBtnkeranjang().addActionListener(new keranjangAction());
        petak[0] = vHome.getBtnPetak1();
        petak[1] = vHome.getBtnPetak2();
        petak[2] = vHome.getBtnPetak3();
        petak[3] = vHome.getBtnPetak4();
        petak[4] = vHome.getBtnPetak5();
        petak[5] = vHome.getBtnPetak6();
        air[0] = vHome.getLblAir1();
        air[1] = vHome.getLblAir2();
        air[2] = vHome.getLblAir3();
        air[3] = vHome.getLblAir4();
        air[4] = vHome.getLblAir5();
        air[5] = vHome.getLblAir6();
        for (int i = 0; i < air.length; i++) {
            air[i].setVisible(false);
        }
        bibit = mAset.getBibit(mAset.cekIdPlayer(username));
        pupuk = mAset.getPupuk(mAset.cekIdPlayer(username));
        obat = mAset.getObat(mAset.cekIdPlayer(username));

        vHome.getLblObat().setText(mAset.getObat(mAset.cekIdPlayer(username)) + "");
        vHome.getLblBibit().setText(mAset.getBibit(mAset.cekIdPlayer(username)) + "");
        vHome.getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");
        vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");

        vHome.getBtnPetak1().addActionListener(new kotak1Action());
        vHome.getBtnPetak2().addActionListener(new kotak2Action());
        vHome.getBtnPetak3().addActionListener(new kotak3Action());
        vHome.getBtnPetak4().addActionListener(new kotak4Action());
        vHome.getBtnPetak5().addActionListener(new kotak5Action());
        vHome.getBtnPetak6().addActionListener(new kotak6Action());
    }

    private class cangkulAction implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

        }

    }

        private class tokoAction implements ActionListener {

        private c_toko toko;

        public tokoAction() throws SQLException {
            toko = new c_toko(vHome, username);
            toko.getView().setVisible(false);
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                toko.getView().getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                toko.getView().getLblBibit().setText(mAset.getBibit(mAset.cekIdPlayer(username)) + "");
                toko.getView().getLblPupuk().setText(mAset.getPupuk(mAset.cekIdPlayer(username)) + "");
                toko.getView().getLblObat().setText(mAset.getObat(mAset.cekIdPlayer(username)) + "");
               
            } catch (SQLException ex) {
                Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
            }
            toko.getView().setVisible(true);
            vHome.setVisible(false);
        }
    }

    private class kotak1Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (statusKotak[0] == 1) {//kosong
                if (bibit > 0) {
                    vHome.getBtnPetak1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    vHome.getBtnPetak1().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
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
            } else if (statusKotak[0] == 3) {//tumbuh 
                vHome.getBtnPetak1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak1().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                kopi += random.nextInt((3 - 2) + 1) + 2;
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
            } else if (statusKotak[0] == 4) {//siap panen
                vHome.getBtnPetak1().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak1().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                kopi += random.nextInt((7 - 5) + 1) + 5;
                try {
                    mAset.updateKoin(koin, mAset.cekIdPlayer(username));
                    vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
            }
        }
    }

    private class kotak2Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (statusKotak[1] == 1) {//kosong
                if (bibit > 0) {
                    vHome.getBtnPetak2().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    vHome.getBtnPetak2().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
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
            } else if (statusKotak[0] == 3) {//tumbuh 
                vHome.getBtnPetak2().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak2().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                kopi += random.nextInt((3 - 2) + 1) + 2;
//                try {
////                    mAset.updateJagung(jagung, mAset.cekIdPlayer(username));
////                    vSawah.getLblJagung().setText(mAset.getJagung(mAset.cekIdPlayer(username)) + "");
//                } catch (SQLException ex) {
//                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
//                }
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
            } else if (statusKotak[0] == 4) {//siap panen
                vHome.getBtnPetak2().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak2().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                kopi += random.nextInt((7 - 5) + 1) + 5;
                try {
                    mAset.updateKoin(koin, mAset.cekIdPlayer(username));
                    vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
            }
        }
    }

    private class kotak3Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (statusKotak[2] == 1) {//kosong
                if (bibit > 0) {
                    vHome.getBtnPetak3().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    vHome.getBtnPetak3().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
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
            } else if (statusKotak[0] == 3) {//tumbuh 
                vHome.getBtnPetak3().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak3().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                kopi += random.nextInt((3 - 2) + 1) + 2;
//                try {
////                    mAset.updateJagung(jagung, mAset.cekIdPlayer(username));
////                    vSawah.getLblJagung().setText(mAset.getJagung(mAset.cekIdPlayer(username)) + "");
//                } catch (SQLException ex) {
//                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
//                }
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
            } else if (statusKotak[0] == 4) {//siap panen
                vHome.getBtnPetak3().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak3().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                kopi += random.nextInt((7 - 5) + 1) + 5;
                try {
                    mAset.updateKoin(koin, mAset.cekIdPlayer(username));
                    vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
            }
        }
    }

    private class kotak4Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (statusKotak[3] == 1) {//kosong
                if (bibit > 0) {
                    vHome.getBtnPetak4().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    vHome.getBtnPetak4().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
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
            } else if (statusKotak[0] == 3) {//tumbuh 
                vHome.getBtnPetak4().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak4().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                kopi += random.nextInt((3 - 2) + 1) + 2;
//                try {
////                    mAset.updateJagung(jagung, mAset.cekIdPlayer(username));
////                    vSawah.getLblJagung().setText(mAset.getJagung(mAset.cekIdPlayer(username)) + "");
//                } catch (SQLException ex) {
//                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
//                }
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
            } else if (statusKotak[0] == 4) {//siap panen
                vHome.getBtnPetak4().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak4().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                kopi += random.nextInt((7 - 5) + 1) + 5;
                try {
                    mAset.updateKoin(koin, mAset.cekIdPlayer(username));
                    vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
            }
        }
    }

    private class kotak5Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (statusKotak[4] == 1) {//kosong
                if (bibit > 0) {
                    vHome.getBtnPetak5().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    vHome.getBtnPetak5().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
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
            } else if (statusKotak[0] == 3) {//tumbuh 
                vHome.getBtnPetak5().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak5().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                kopi += random.nextInt((3 - 2) + 1) + 2;
//                try {
////                    mAset.updateJagung(jagung, mAset.cekIdPlayer(username));
////                    vSawah.getLblJagung().setText(mAset.getJagung(mAset.cekIdPlayer(username)) + "");
//                } catch (SQLException ex) {
//                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
//                }
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
            } else if (statusKotak[0] == 4) {//siap panen
                vHome.getBtnPetak5().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak5().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                kopi += random.nextInt((7 - 5) + 1) + 5;
                try {
                    mAset.updateKoin(koin, mAset.cekIdPlayer(username));
                    vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
            }
        }
    }

    private class kotak6Action implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (statusKotak[5] == 1) {//kosong
                if (bibit > 0) {
                    vHome.getBtnPetak6().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
                    vHome.getBtnPetak6().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/CilikGandeng.png")));
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
            } else if (statusKotak[0] == 3) {//tumbuh 
                vHome.getBtnPetak6().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak6().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                kopi += random.nextInt((3 - 2) + 1) + 2;
//                try {
////                    mAset.updateJagung(jagung, mAset.cekIdPlayer(username));
////                    vSawah.getLblJagung().setText(mAset.getJagung(mAset.cekIdPlayer(username)) + "");
//                } catch (SQLException ex) {
//                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
//                }
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
            } else if (statusKotak[0] == 4) {//siap panen
                vHome.getBtnPetak6().setIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                vHome.getBtnPetak6().setRolloverIcon(new javax.swing.ImageIcon(getClass().getResource("/gambar/lahan/gundukan.png")));
                kopi += random.nextInt((7 - 5) + 1) + 5;
                try {
                    mAset.updateKoin(koin, mAset.cekIdPlayer(username));
                    vHome.getLblKoin().setText(mAset.getKoin(mAset.cekIdPlayer(username)) + "");
                } catch (SQLException ex) {
                    Logger.getLogger(c_home.class.getName()).log(Level.SEVERE, null, ex);
                }
                statusKotak[0] = 1;
                statusSiram[0] = false;
                statusTime1[0] = 0;
                statusTime2[0] = 0;
                statusTime3[0] = 0;
            }
        }
    }

}
