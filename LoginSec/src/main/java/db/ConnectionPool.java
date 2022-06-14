package db;

import java.sql.*;
import javax.sql.DataSource;
import javax.naming.*;

public class ConnectionPool {

  private static ConnectionPool pool = null;
  private static DataSource dataSource = null;

  public synchronized static ConnectionPool getInstance() {
    if (pool == null) {
      pool = new ConnectionPool();
    }
    return pool;
  }

  private ConnectionPool() {
    try {
      InitialContext ic = new InitialContext();
      dataSource = (DataSource) ic.lookup("java:/comp/env/jdbc/java3");
    } catch (NamingException e) {
      System.err.println(e);
    }
  }

  public Connection getConnection() {
    try {
      return dataSource.getConnection();
    } catch (SQLException sqle) {
      System.err.println(sqle);
      return null;
    }
  }
}
