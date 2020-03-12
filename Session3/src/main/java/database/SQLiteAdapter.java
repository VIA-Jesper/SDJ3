package database;



import shared.MoM;

import java.sql.*;

public class SQLiteAdapter
{

  private String fileName = "MoM.db";
  private Statement stmt = null;


  public SQLiteAdapter() {
    createTables();
  }

  private Connection getConn() throws SQLException, ClassNotFoundException {
    Class.forName("org.sqlite.JDBC");
    return DriverManager.getConnection(
        String.format("jdbc:sqlite:./Session3/src/main/java/%s", fileName));
  }



  private void createTables() {
    Connection connection = null;
    try {
      connection = getConn();
      if (connection != null) {
        System.out.println("Opened database successfully");
      } else {
        System.out.println("Connection to db is null...");
        return;
      }


      stmt = connection.createStatement();
      String preSql = "DROP TABLE IF EXISTS Mom";
      stmt.executeUpdate(preSql);
      String sql = String.format(
          "CREATE TABLE IF NOT EXISTS Mom (name VARCHAR(50), mom VARCHAR(50));");
      stmt.executeUpdate(sql);
      stmt.close();
      connection.close();
    } catch ( Exception e ) {
      System.err.println("Error: " +  e.getClass().getName() + ": " + e.getMessage() );
      try {
        if (connection != null)
          connection.close();
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    }
    System.out.println("Table created successfully");
  }

  public void addMoM(String name, String mom) throws SQLException
  {
    Connection c = null;
    Statement stmt = null;

    try {

      c = getConn();
      c.setAutoCommit(true);

      System.out.println("Trying to insert into db: " + name + " and " + mom);
      stmt = c.createStatement();
      String sql =
          String.format("INSERT INTO MoM (name, mom) VALUES ('%s', '%s')", name, mom);
      stmt.execute(sql);
      c.close();
      System.out.println("Mom has been added");

    } catch (SQLException | ClassNotFoundException e) {
      e.printStackTrace();
    }
    c.close();
  }

  public MoM getMoM(String name) throws SQLException
  {
    Connection c = null;
    Statement stmt = null;
    try {
      c = getConn();
      c.setAutoCommit(false);
      System.out.println("Opened database successfully");

      stmt = c.createStatement();
      ResultSet rs = stmt.executeQuery(
          String.format("SELECT name, mom FROM MoM WHERE name='%s'", name));



      while ( rs.next() ) {

        String resultName = rs.getString("name");
        String resultMoM = rs.getString("mom");
        MoM mom = new MoM(resultName, resultMoM);
        return mom;
      }
      rs.close();
      stmt.close();
      c.close();
    } catch ( Exception e ) {
      System.err.println( e.getClass().getName() + ": " + e.getMessage() );
      c.close();
    }
    return null;
  }


}
