package shop;

import java.sql.*;

public class DAOConnection {
  public static Connection con;

  private DAOConnection(){};

  synchronized public static Connection sqlconnection() throws SQLException {
    if (con == null) {
      String url = "jdbc:hsqldb:file:C:/Users/Tom/IdeaProjects/ShopProjekt/src/DB/DB";      //Verlinkung muss eventull neu erfolgen, ins Verzeichnis der DB
      try {
        con = DriverManager.getConnection(url, "me", "1234");     //Verbindung mit DB
      } catch (SQLException e) {
        throw new IllegalStateException("Es gab ein Problem!", e);
      }
    }return con;
  }
}