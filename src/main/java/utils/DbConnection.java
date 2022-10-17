package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

  public static Connection getDbConnection() {
    Connection connection = null;
    String url = "jdbc:mysql://localhost/dash_users?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
    String pass = "";
    String user = "root";

    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      connection = DriverManager.getConnection(url, user, pass);
    } catch (SQLException e) {
      e.printStackTrace();
  } catch (ClassNotFoundException e) {
      e.printStackTrace();
  }

    return connection;
  }
}
