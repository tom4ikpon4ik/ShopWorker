package shop;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

import java.sql.SQLException;

public class Shop extends Application {
  static Stage stage;

  @Override
  public void start(Stage primaryStage) throws Exception {
    stage = primaryStage;
    Parent root = FXMLLoader.load(getClass().getResource("Shop.fxml"));
    stage.setScene(new Scene(root, 400, 400));
    stage.setTitle("Shop");
    stage.show();
  }

  public static void changeScene(String sceneName) throws IOException {
    Parent root = FXMLLoader.load(Shop.class.getResource(sceneName));
    stage.setScene(new Scene(root, 400, 400));

  }

    public static void main(String[] args) {
        launch(args);
    }{
    try {
      Bestseller.getBestseller();     //Aufruf der Bestseller DB-Einträge
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

}/*
//Erweiterung des Shops durch hinzufügen neuer Klassen und DB-Einträge
public class main {
    public static void main(String[] args) throws SQLException {
        Fantasy.getfantasy();     //Aufruf der Fantasy-DB Einträge
        Bestseller.getBestseller();     //Aufruf der Bestseller DB-Einträge
        Grafikkarte.getGrafikkarte();     //Aufruf der Grafikkarten DB-Einträge
        Horror.getHorror();     //Aufruf der Horror DB-Einträge
        Netzteil.getNetzteil();     //Aufruf der Netzteil DB-Einträge
        Ram.getRam();     //Aufruf der RAM DB-Einträge
        Schrank.getSchrank();     //Aufruf der Schrank DB-Einträge
        Stuhl.getStuhl();     //Aufruf der Stuhl DB-Einträge
        Tisch.getTisch();     //Aufruf der Tisch DB-Einträge
    }
}

/*Erzeugung der PRODUKT Tabellen in der DB - Vorher Verbindung mit DB wie in Unterklassen.
      Zur Zeit nicht implementiert, da es Probleme mit der Embedded-DB und der Erstellung dieser gab.
      Erstellung funktioniert dennoch, jedoch wird Eintrag(bei InetlliJ) nicht angezeigt. Auruf des Eintrags trotzdem möglich.

        try {
            Connection conn = DriverManager.getConnection(url, Nutzername, Passwort);
            System.out.println("Connected");
            String query = SqlCreateStatements.SQL_CREATE_TABLE_Horror;
            Statement st = conn.createStatement();
            int affrows = st.executeUpdate(query);
            conn.commit();
            System.out.println("affected rows: "+ affrows);
        } catch (SQLException e) {
            e.printStackTrace();
        }*/

/*        try {
            Connection conn = DriverManager.getConnection(url, Nutzername, Passwort);
            System.out.println("Connected");
            String query = "SELECT * FROM SHOP.BESTSELLER";            //Auswahl aus Produkte
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);          //Ausführen und Ergebnis bekommen

          //boolean ok = st.execute("insert into BESTSELLER(PRODUKT_ID,PRODUKT_NAME,PRODUKT_BESCHREIBUNG,PRODUKT_VORRAT,PRODUKT_PREIS) values ('111111','Der Schrank','Ein Schrank!','12','500')");
          //System.out.println(ok);
            while (rs.next()) {
                int PI = rs.getInt("PRODUKT_ID");
                String PN = rs.getString("PRODUKT_NAME");
                String PB = rs.getString("PRODUKT_BESCHREIBUNG");
                int PV = rs.getInt("PRODUKT_VORRAT");
                double PP = rs.getDouble("PRODUKT_PREIS");

                // print the results
                System.out.format("%d, %s, %s, %d, %.2f\n", PI, PN, PB, PV, PP);
            }
            st.close();
        } catch (SQLException e) {
            throw new IllegalStateException("Nein!", e);

        }*/
