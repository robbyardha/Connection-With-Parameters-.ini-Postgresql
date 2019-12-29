/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package connectionwithparams;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author ROBBY
 */
public class Connpsql {
    Connection conn;
    public Connpsql(){
        koneksi();
    }
    public Connection getConnection(){
        return conn;
    }
    public void setConnection(String Db, String user, String password) {
        try {
            if(conn != null){
                conn.close();
            }
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection(Db,user,password);
        } catch (Exception e) {
            String connectMsg = "Can't connect database : " +ex.getMessage() + " " + ex.getLocalizedMessage();
            JOptionPane.showMessageDialog(null, connectMsg);
        }
    }
    
    private Connection koneksi(){
        try {
            if (conn != null) {
                conn.close();
            }
            Class.forName("org.postgresql.Driver");
            conn = DriverManager.getConnection("jdbc:postgresql://localhost/uas_oop_181080200213", "postgres", "robby");
        } catch (Exception ex) {
            String connectMsg = "Cant Connect to Database: "+ ex.getMessage()+ " " + ex.getLocalizedMessage();
            JOptionPane.showMessageDialog(null, connectMsg);
        }
        return conn;
    }
    
    public static void main(String[] args){
    Connpsql con = new Connpsql();
    con.koneksi();
    if(con.conn==null){
        JOptionPane.showMessageDialog(null, "Failed Connect To Database");
    }else{
        JOptionPane.showMessageDialog(null, "Success Connect To Database");
        }
    }
}
