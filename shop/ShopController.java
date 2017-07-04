package shop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.DriverManager;
import java.util.logging.Level;
import java.util.logging.Logger;
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



public class ShopController implements Initializable {
    
    @FXML
    private Label label;
    @FXML
    private TextField BenutzerName;
    @FXML
    private PasswordField Passwort;
    
    String checkBenutzer, checkPw;
    Button LogIn;
    @FXML 
    Button Registrieren;
            
   
   
    
    @FXML
    public void handleButton1Action(ActionEvent event) throws Exception {
      
        BenutzerName.getText();
        Passwort.getText();
        checkBenutzer = BenutzerName.getText();
        checkPw = Passwort.getText();
        Connection connection;
        PreparedStatement ps;
        try {
            connection = DAOConnection.sqlconnection();
            ps = connection.prepareStatement("SELECT KUNDENNAME, KUNDENPASSWORT FROM SHOP.KUNDE WHERE KUNDENNAME = ? AND KUNDENPASSWORT = ?");
            ps.setString(1, checkBenutzer);
            ps.setString(2, checkPw);
            ResultSet result = ps.executeQuery();
            if(result.next()){
                 Platform.runLater( () -> {
                label.setText("Login Successesful");
                   try {
                     Stage primaryStage = new Stage();
                     Parent root;
                     root = FXMLLoader.load(getClass().getResource("ShopMain.fxml"));
                     Scene scene;
                     scene = new Scene(root,400,400);
                     primaryStage.setScene(scene);
                     primaryStage.show();
                   } catch (IOException e) {
                     e.printStackTrace();
                   }
                 });}else{
                label.setText("Invalide Username Or Password");
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ShopController.class.getName()).log(Level.SEVERE, null, ex);
        }
    } 
       /* if (checkBenutzer.equals("Max") && checkPw.equals("maxmax")) {
            Platform.runLater( () -> {     
            label.setText("Login erfolgreich");
            Stage primaryStage = new Stage();
            Parent root;
            try {
            root = FXMLLoader.load(getClass().getResource("ShopMain.fxml"));
            Scene scene;
            scene = new Scene(root,630,400);
            primaryStage.setScene(scene);
            primaryStage.show();
            } catch (IOException e) {
                e.printStackTrace();
            }
            });
           
        } else {
            label.setText("Login nicht erfolgreich");
        }*/
    
    
    @FXML
    public void handleButton2Action(ActionEvent event) throws Exception {
            Stage primaryStage = new Stage();
            Parent root;    
            root = FXMLLoader.load(getClass().getResource("Registrierung.fxml"));
            Scene regscene;
            regscene = new Scene(root,400,400);
            primaryStage.setScene(regscene);
            primaryStage.show();
            
        
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
