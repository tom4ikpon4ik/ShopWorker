package shop;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Wrapper;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.io.IOException;
import java.net.URL;
import java.sql.DriverManager;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;



public class RegistrierungController implements Initializable{
    
    String checkBN, checkPW;
    @FXML
    private TextField benutzername;
    
    @FXML
    private PasswordField passwort;
    @FXML   
    private Label RegLabel;
@FXML
public void handleRegBtnAction (ActionEvent event) throws Exception {

	//Create wrapper object and define it null
				Wrapper conn = null;
				try  //try block
                                {
                                //declare variables
				String Benutzername = "";
				String Passwort = "";
				
				//get values using getText() method
				Benutzername = benutzername.getText().trim();
				Passwort = passwort.getText().trim();
				
                                // check condition it field equals to blank throw error message
				if (Benutzername.equals("")|| Passwort.equals(""))
				{
					RegLabel.setText("Hier stimmt was nicht..");
				}
				else  //else insert query is run properly
                                {

					String IQuery = "INSERT INTO SHOP.KUNDE(KUNDENNAME,KUNDENPASSWORT) VALUES('"+Benutzername+"', '"+Passwort+"')";
					System.out.println(IQuery);//print on console
					System.out.println("Connecting to a selected database...");
				
				//STEP 3: Open a connection
					Connection con = DAOConnection.sqlconnection();      //Verbindung mit der DB
					System.out.println("Connected database successfully...");
					  
				((Connection)conn).createStatement().execute(IQuery);//select the rows
					
	                    	RegLabel.setText("Hinzugefügt");
				}				
			}
			catch (SQLException se) 
			{
				//handle errors for JDBC
				se.printStackTrace();
			}
			catch (Exception a) //catch block
			{
				a.printStackTrace();
			}
   
    
}
 @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
}

    



/*
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;


 
public class RegistrierungController implements Initializable {

    String checkVN, checkNN, checkNick, checkGeb, checkPW1, checkPW2;
    @FXML
    private TextField Vorname;
    @FXML
    private TextField Nachname;
    @FXML
    private TextField Nickname;
    @FXML
    private TextField Geburtsdat;
    @FXML   
    private PasswordField PW1;
    @FXML
    private PasswordField PW2;
    @FXML   
    private Label RegLabel;

    
    
    @FXML
    public void handleRegBtnAction(ActionEvent event) throws Exception {
        Vorname.getText();
        Nachname.getText();
        Nickname.getText(); 
        Geburtsdat.getText();
        PW1.getText();
        PW2.getText();
        
        int min = 8;
                
        checkVN = Vorname.getText();
        checkNN = Nachname.getText();
        checkNick = Nickname.getText();
        checkGeb = Geburtsdat.getText();
        checkPW1 = PW1.getText();
        checkPW2 = PW2.getText();
        
       if ((((!checkVN.matches("^[a-zA-Z_0-9]{3,15}$*") || !checkNN.matches(".*[a-z].*,.*[A-Z].*")) || !checkGeb.matches("\\\\d{2}.\\\\d{2}.\\\\d{4}")) || checkPW1.length() < min) || !checkPW1.equals(checkPW2)){ 
           RegLabel.setText("Da stimmt was nicht....");}     
       else {
           RegLabel.setText("Juhu! Registrierung war erfolgreich!");
            }
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}

*/