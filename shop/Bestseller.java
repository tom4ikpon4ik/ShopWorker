package shop;

import shop.DAOConnection;

import java.sql.*;

public class Bestseller{

  public static void getBestseller() throws SQLException {

    Connection conn = DAOConnection.sqlconnection();      //Verbindung mit der DB

    try {
      System.out.println("Connected to Bestseller");
      String query = "SELECT * FROM SHOP.BESTSELLER";            //Auswahl aus Produkt DB
      Statement st = conn.createStatement();
      ResultSet rs = st.executeQuery(query);          //Ausführen und Ergebnis bekommen

      /*Testeintrag erstellen - Modell wie in Registrierung
      boolean ok = st.execute("insert into Bestseller(PRODUKT_ID,PRODUKT_NAME,PRODUKT_BESCHREIBUNG,PRODUKT_VORRAT,PRODUKT_PREIS) values ('','','','','')");
      System.out.println(ok);     */

      //Daten der DB erhalten
      while (rs.next()) {
        int PI = rs.getInt("PRODUKT_ID");
        String PN = rs.getString("PRODUKT_NAME");
        String PB = rs.getString("PRODUKT_BESCHREIBUNG");
        int PV = rs.getInt("PRODUKT_VORRAT");
        double PP = rs.getDouble("PRODUKT_PREIS");
        String PS = rs.getString ("BILDER");

        System.out.format("%d, %s, %s, %d, %.2f, %s\n", PI, PN, PB, PV, PP, PS);      //Ausgabe der DB-Einträge
      }
      st.close();
    } catch (SQLException e) {
      throw new IllegalStateException("Es gab ein Problem!", e);}}      //Probleme mit der SQL DB werden hier angezeigt
}