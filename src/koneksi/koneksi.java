
package koneksi;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class koneksi {

    Connection con;
    Statement stm;
    
      public koneksi() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/pplb_mrkopi";
        String username = "root";
        String pass = "";

        this.con = (Connection) DriverManager.getConnection(url, username, pass);
        this.stm = (Statement) this.con.createStatement();
    }
    public void executeQuery(String query) throws SQLException {
        this.stm.execute(query);
    }

    public ResultSet getResult(String query) throws SQLException {
        ResultSet rs = stm.executeQuery(query);
        return rs;
    }

}

    
    
    
    
    
