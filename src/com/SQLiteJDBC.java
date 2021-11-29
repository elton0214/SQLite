package com;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLiteJDBC {
  public static void main( String args[] ) {
	  
	  CRUDOperate cRUDOperate = new CRUDOperate();
//	  cRUDOperate.create();
	  cRUDOperate.update();
//	  cRUDOperate.delete();
	  cRUDOperate.read();
	  
   }
}
