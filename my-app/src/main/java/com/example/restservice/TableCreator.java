package com.example.restservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

// following https://github.com/xerial/sqlite-jdbc

public class TableCreator {

    public static void create() {
          String sql_create = "CREATE TABLE IF NOT EXISTS pages( " +
                          "id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                          "url TEXT NOT NULL, " +
                          "metadata TEXT)";


          Connection connection = null;
          try
          {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            statement.executeUpdate(sql_create);
          }
          catch(SQLException e)
          {
            // if the error message is "out of memory",
            // it probably means no database file is found
            System.err.println(e.getMessage());
          }
          finally
          {
            try
            {
              if(connection != null)
                connection.close();
            }
            catch(SQLException e)
            {
              // connection close failed.
              System.err.println(e.getMessage());
            }
          }
      }
}
