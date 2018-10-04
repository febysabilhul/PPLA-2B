/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.table.DefaultTableModel;
import koneksi.koneksi;
/**
 *
 * @author BoniBarBar
 */
public class m_function {
  protected koneksi con;

    public m_function() throws SQLException {
        con = new koneksi();
    }
    protected int checkId(String query) throws SQLException {
        int id = 0;
        ResultSet hasil;
        do {
            id++;
            hasil = con.getResult(query + id);
        } while (hasil.next());
        return id;
    }
     public boolean getStatusQuery(String query) {
        boolean succesInput = false;
        try {
            con.executeQuery(query);
            succesInput = true;
        } catch (SQLException ex) {
            succesInput = false;
        }
        return succesInput;
    }
     public String getDataString (String query) throws SQLException{
        ResultSet hasil = con.getResult(query);
        hasil.next();
        String data = hasil.getString(1);
        return data;
    }
    
    public int getDataInt(String query) throws SQLException {
        ResultSet hasil = con.getResult(query);
        hasil.next();
        int data = hasil.getInt(1);
        return data;
    }
    
    protected DefaultTableModel buatTabel(String namaKolom[], String query) throws SQLException {
        DefaultTableModel tabelModel = new DefaultTableModel(null, namaKolom);
        ResultSet hasil = con.getResult(query);
        while (hasil.next()) {
            String kolom[] = new String[namaKolom.length];
            for (int i = 0; i < kolom.length; i++) {
                kolom[i] = hasil.getString(i + 1);
            }
            tabelModel.addRow(kolom);
        }
        return tabelModel;
    }


}

