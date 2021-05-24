package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class Drive {

  public static void main(String[] args) throws Exception {
    conn(); // connects to database
    ArrayList<String> array = select();
    for (int i = 0; i < array.size(); i++) {
      System.out.println(array.get(i)); // prints array

    }

  }

  // Establish connection:
  public static Connection conn() {
    try {
      String driver = "com.mysql.cj.jdbc.Driver";
      String url = "jdbc:mysql://Squidward:3306/testdb";
      String username = "Squidward"; // THESE ARE NOT ACTIVE USERS ON MY MACHINE TO AVOID SECURITY RISKS.
      String pass = "Squidward";
      Class.forName(driver);
      Connection connect = DriverManager.getConnection(url, username, pass);
      return connect;
    } catch (Exception e) {
      System.out.println(e);
    }
    return null;
  }

  // Select statements(s)
  public static ArrayList<String> select() throws Exception {
    Connection con = conn();
    PreparedStatement statement = con.prepareStatement("SELECT * FROM youtube");
    ResultSet result = statement.executeQuery();
    ArrayList<String> array = new ArrayList<String>();
    while (result.next()) {
      array.add(result.getString("url"));
    }
    return array;
  }

}
