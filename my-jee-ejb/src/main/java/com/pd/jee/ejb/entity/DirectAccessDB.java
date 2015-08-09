package com.pd.jee.ejb.entity;

import java.sql.*;

public class DirectAccessDB {

    private final String      JDBC_CLIENT_DRIVER = "org.apache.derby.jdbc.ClientDriver";
    private final String      DB_URL	     = "jdbc:derby://localhost:1527/derbyDBJee;create=true";

    String		    CREATE_TABLE_SQL   = "CREATE TABLE books ( id integer PRIMARY KEY, name varchar(50))";

    private static Connection conn = null;
    private static Statement stmt = null;

    public static void main(final String[] args) {
	new DirectAccessDB().begin();
    }

    private void begin() {
	try {
	    createConnection();
	    createTable();
	    insertIntoTable();
	    runSelectQuery();
	    shutdownConnection();

	} catch (final InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
	    e.printStackTrace();
	} finally {

	}

    }

    private void insertIntoTable() throws SQLException {
	// stmt.execute("insert into restaurants values (1, 'Irifunes', 'San Mateo')");
	//
	// stmt.execute("insert into restaurants values (2, 'Estradas', 'Daly City')");
	//
	// stmt.execute("insert into restaurants values (3, 'Prime Rib House', 'San Francisco')");

	stmt.execute("select * from books");
    }

    private static void runSelectQuery() {
	try {
	    stmt = conn.createStatement();
	    final ResultSet results = stmt.executeQuery("select * from books");
	    final ResultSetMetaData rsmd = results.getMetaData();
	    final int numberCols = rsmd.getColumnCount();
	    for (int i = 1; i <= numberCols; i++) {
		// print Column Names
		System.out.print(rsmd.getColumnLabel(i) + "\t\t");
	    }

	    System.out.println("\n-------------------------------------------------");

	    while (results.next()) {
		final int id = results.getInt(1);
		final String restName = results.getString(2);
		final String cityName = results.getString(3);
		System.out.println(id + "\t\t" + restName + "\t\t" + cityName);
	    }
	    results.close();
	    stmt.close();
	} catch (final SQLException sqlExcept) {
	    sqlExcept.printStackTrace();
	}
    }

    private void createTable() throws SQLException {
	try {
	    if (stmt == null) {
		stmt = conn.createStatement();
	    }
	    stmt.execute(CREATE_TABLE_SQL);
	    System.out.println("Created table 'books'");
	} catch (final SQLException e) {
	    if (e.getSQLState().equals("X0Y32")) {
		System.out.println("\t\t" + e.getCause());
		return;
	    }
	}

    }

    private void createConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException,
    SQLException {
	Class.forName(JDBC_CLIENT_DRIVER).newInstance();
	// Get a connection
	conn = DriverManager.getConnection(DB_URL);
	if (conn != null) {
	    System.out.println("Connected to persistence database, not in memory");
	}
    }

    private void shutdownConnection() throws SQLException {
	if (stmt != null) {
	    stmt.close();
	    System.out.println("Closed open statement");
	}

    }
}
