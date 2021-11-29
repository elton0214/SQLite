package com;

import java.sql.*;

public class CRUDOperate {
	
	public Connection connect() {
	    Connection conn = null;
	    
	    try {
	       Class.forName("org.sqlite.JDBC");
	       conn = DriverManager.getConnection("jdbc:sqlite:test.db");
	       //conn.setAutoCommit(true); //improve performance
	    } catch ( Exception e ) {
	       System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	       System.exit(0);
	    }
	    System.out.println("Opened database successfully");
	    return conn;
	}
	
	public void create() {
      Connection conn = this.connect();
      Statement stmt = null;
      
      try {
         Class.forName("org.sqlite.JDBC");
         System.out.println("Opened database successfully");

         stmt = conn.createStatement();
         String sql = "CREATE TABLE COMPANY " +
                        "(ID INT PRIMARY KEY     NOT NULL," +
                        " NAME           TEXT    NOT NULL, " + 
                        " AGE            INT     NOT NULL, " + 
                        " ADDRESS        CHAR(50), " + 
                        " SALARY         REAL)"; 
         stmt.executeUpdate(sql);
         stmt.close();
         conn.close();
      } catch ( Exception e ) {
         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
         System.exit(0);
      }
      System.out.println("Table created successfully");
	}
	
	public void read() {
		String sql="Select * from COMPANY";
		try {
			Connection conn = this.connect();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			System.out.println("ID"+"\t"+"NAME"+"\t"+"AGE"+"\t"+"ADDRESS"+"\t"+"SALARY"+"\t");
			while (rs.next()) {
				System.out.println(rs.getString("ID")+"\t"+rs.getString("NAME")+"\t"+rs.getString("AGE")+"\t"+rs.getString("ADDRESS")+"\t"+rs.getString("SALARY")+"\t");
			}
		} catch (SQLException e) {
			System.out.println("查詢數據時出錯! "+e.getMessage());
		}
	}
	
	public void update() {
		Connection conn = this.connect();
	    Statement stmt = null;
		
	    try {
	         Class.forName("org.sqlite.JDBC");
	         System.out.println("Opened database successfully");

	         stmt = conn.createStatement();
	         String sql = "INSERT INTO COMPANY (ID,NAME,AGE,ADDRESS,SALARY) " +
	                   "VALUES (2, 'Sandy', 32, 'California', 20000.00 );"; 
	         stmt.executeUpdate(sql);
	         stmt.close();
	         //conn.commit();
	         conn.close();
	   } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	   }
	   System.out.println("Data updated successfully");
		
	}
	
	public void delete() {
		Connection conn = this.connect();
	    Statement stmt = null;
		
	    try {
	         Class.forName("org.sqlite.JDBC");
	         System.out.println("Opened database successfully");

	         stmt = conn.createStatement();
	         String sql = "DELETE from COMPANY where ID=2;";
	         stmt.executeUpdate(sql);
	         stmt.close();
	         //conn.commit();
	         conn.close();
	   } catch ( Exception e ) {
	         System.err.println( e.getClass().getName() + ": " + e.getMessage() );
	         System.exit(0);
	   }
	   System.out.println("Data deleted successfully");
		
	}
}
