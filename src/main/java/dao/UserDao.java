package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;
import utils.DbConnection;

public class UserDao {
  
  public int registerUser(User user) throws ClassNotFoundException {
    String INSERT_USERS_SQL = "INSERT INTO `users`" + " (name, email, password) VALUES (?, ?, ?);";
    
    int result = 0;

    try {
      Connection connection = DbConnection.getDbConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(INSERT_USERS_SQL);
      preparedStatement.setString(1 ,user.getName());
      preparedStatement.setString(2, user.getEmail());
      preparedStatement.setString(3, user.getPassword());
      System.out.println(preparedStatement);
      result = preparedStatement.executeUpdate();
    } catch (Exception e) {
      e.printStackTrace();
    }

    return result;
  }

  public User getUser(String userEmail) throws ClassNotFoundException {
    String SELECT_USER_SQL = "SELECT * FROM `users` WHERE email = ?;";
    
    try {
      Connection connection = DbConnection.getDbConnection();
      PreparedStatement preparedStatement = connection.prepareStatement(SELECT_USER_SQL);
      preparedStatement.setString(1, userEmail);
      ResultSet result = preparedStatement.executeQuery();
      User user = new User();
      while(result.next()) {
        user.setPassword(result.getString("password"));
        user.setEmail(result.getString("email"));
        user.setName(result.getString("name"));
      }
      return user;
    } catch (SQLException e) {
      // TODO: handle exception
      e.printStackTrace();
      return (new User());
    }
  }
}
