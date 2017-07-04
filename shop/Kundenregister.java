/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

/**
 *
 * @author user
 */
public class Kundenregister {
    String Benutzername;
    String Pass;
    @FXML
    private PasswordField passwort;
     @FXML
    private TextField benutzername;
    @FXML
    public Label label;
    String checkbenutzer, checkpw;
    Connection con;
    String query;
    PreparedStatement pstmt;
    ResultSet rs;
    Statement stmt;
    int i;
    boolean registration_successful;
    String benutzername_exists="false";

    
    
  public String Kunde_vorhanden(String Benutzername) throws Exception{
    
    
        benutzername.getText();
        passwort.getText();
        checkbenutzer = benutzername.getText();
        checkpw = passwort.getText();
        query = "select KUNDENNAME from KUNDE";
        con = DAOConnection.sqlconnection();
        try {
            stmt = con.createStatement();
            rs = stmt.executeQuery(query);
            while (rs != null && rs.next()) {
                if (rs.getString(1).equalsIgnoreCase(checkbenutzer)) {
                    benutzername_exists = "true";
                } else {
                   System.out.println("Dieser Nutzer ist neu" + rs.getString(1));
               }
            }
        } catch (SQLException ex) {
            System.out.println("exception caught while reading benutzername = " + ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection Terminated");
                }
            } catch (SQLException e) {
                System.out.println("The exception caught is = " + e);
            }
        }
        return benutzername_exists;
    }

    public boolean reg_user(String checkbenutzer, String checkpw) {
        benutzername.getText();
        passwort.getText();
        checkbenutzer = benutzername.getText();
        checkpw = passwort.getText();
        System.out.println("benutzername from RegistrierungController method=" + benutzername + "passwort=" + passwort);
        try {
            con = DAOConnection.sqlconnection();
            query = "insert into Kunden values(?,?,?)";
            pstmt = con.prepareStatement(query);
            pstmt.setString(1, null);
            pstmt.setString(2, checkbenutzer);
            pstmt.setString(3, checkpw);
            i = pstmt.executeUpdate();
            if (i > 0) {
                System.out.println("User information successfully added to database");
            }
            registration_successful = true;
        } catch (SQLException ex) {
            Logger.getLogger(RegistrierungController.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                if (con != null) {
                    con.close();
                    System.out.println("Connection Terminated");
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException e) {
                System.out.println("Exception caught is = " + e);
            }
        }
        return registration_successful;
    }
    

}
