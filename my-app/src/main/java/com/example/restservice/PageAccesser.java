package com.example.restservice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import java.util.LinkedList;


// following https://github.com/xerial/sqlite-jdbc

public class PageAccesser {

    public static List<Page> allpages() {

          Connection connection = null;
          List<Page> pagesSeen = new LinkedList();
          try
          {
            // create a database connection
            connection = DriverManager.getConnection("jdbc:sqlite:sample.db");
            Statement statement = connection.createStatement();
            statement.setQueryTimeout(30);  // set timeout to 30 sec.
            // How can I abstract out a class that provides a connection without having to be wrapped in try catch?

            ResultSet rs = statement.executeQuery("SELECT * FROM page");
            while (rs.next()) {
                pagesSeen.add(new Page(rs.getString("url"), rs.getString("metadata")));
            }

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

          return pagesSeen;

      }
}
