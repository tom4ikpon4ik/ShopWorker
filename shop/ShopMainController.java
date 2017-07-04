/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package shop;

import java.io.IOException;
import javafx.animation.FadeTransition;
import javafx.animation.Interpolator;
import java.net.URL;
import javafx.scene.Node;
import javafx.util.Duration;
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

/**
 * FXML Controller class
 *
 * @author user
 */
public class ShopMainController implements Initializable {
    
    @FXML
    ScrollPane scrollpane;
    @FXML
    ScrollPane buchpane;
    @FXML
    ScrollPane MoebelPane;
    @FXML
    ScrollPane PCZPane;
    @FXML
    Button EinkWag;
    @FXML
    Button Kasse;
    @FXML
    Button PCZ;
    @FXML
    Button Moebel;
    @FXML
    Button Buecher;
    
 /*   @FXML
    public void handleButtonBuchAction(ActionEvent event)throws Exception {
          
         
         Stage primaryStage = new Stage();
            Parent root;    
            root = FXMLLoader.load(getClass().getResource("Buch.fxml"));
            Scene regscene;
            regscene = new Scene(root,400,400);
            primaryStage.setScene(regscene);
            primaryStage.show();
    }

    @FXML
    public void handleButtonPCZAction(ActionEvent event)throws Exception {
            Stage primaryStage = new Stage();
            Parent root;    
            root = FXMLLoader.load(getClass().getResource("PCZ.fxml"));
            Scene regscene;
            regscene = new Scene(root,400,400);
            primaryStage.setScene(regscene);
            primaryStage.show();
        }

    @FXML
    public void handleButtonMoebelAction(ActionEvent event)throws Exception {
            Stage primaryStage = new Stage();
            Parent root;    
            root = FXMLLoader.load(getClass().getResource("Moebel.fxml"));
            Scene regscene;
            regscene = new Scene(root,400,400);
            primaryStage.setScene(regscene);
            primaryStage.show();
        }
    
    @FXML
    public void handleButtonEinkAction(ActionEvent event)throws Exception {
            Stage primaryStage = new Stage();
            Parent root;    
            root = FXMLLoader.load(getClass().getResource("EinkWag.fxml"));
            Scene regscene;
            regscene = new Scene(root,400,400);
            primaryStage.setScene(regscene);
            primaryStage.show();
        }
     @FXML
    public void handleButtonKasseAction(ActionEvent event)throws Exception {
            Stage primaryStage = new Stage();
            Parent root;    
            root = FXMLLoader.load(getClass().getResource("Kasse.fxml"));
            Scene regscene;
            regscene = new Scene(root,400,400);
            primaryStage.setScene(regscene);
            primaryStage.show();
            }
 */   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
               //trim file url für filename
        String fileName=url.getFile().substring(url.getFile().lastIndexOf('/')+1,url.getFile().length());
        //check the file name and set animation according to that.
        if(fileName.equals("Buch.fxml")){
            fadeTransition(buchpane);
        }
        else if(fileName.equals("Moebel.fxml")){
            fadeTransition(MoebelPane);
        }
        else if(fileName.equals("PCZ.fxml")){
            fadeTransition(PCZPane);
    }
    }

    public void changeScene(ActionEvent actionEvent) {
        //get the button object on which user clicks and change scene acoording to that
        if(actionEvent.getSource().equals(Buecher)){
            try {
                Shop.changeScene("Buch.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(actionEvent.getSource().equals(Moebel)){
            try {
                Shop.changeScene("Moebel.fxml");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
     private void fadeTransition(Node e){
        FadeTransition x=new FadeTransition(new Duration(2000),e);
        x.setFromValue(0);
        x.setToValue(100);
        x.setCycleCount(1);
        x.setInterpolator(Interpolator.LINEAR);
        x.play();
    }
    }    
    

