package zeta.core.datasource.connection;

import java.sql.Connection;
import java.sql.DriverManager;

import zeta.core.Context;

public class SampleConnectionFactory {
		
	
	private String Url ;
	private String userName; 
	private String password; 
	
	
	public SampleConnectionFactory(String url, String userName, String password) {
	 	Url = url;
		this.userName = userName;
		this.password = password; 
	}
	
	public SampleConnectionFactory(Context  context) {
		this.Url = context.getUrl();
		this.userName = context.getUser();
		this.password = context.getPasswd(); 
	}
	public  Connection   retriveConnection()
	{
		 Connection   con  = null;
		 
	    try {
	         Class.forName("org.postgresql.Driver");
				con = DriverManager.getConnection(Url, userName, password); 
 	    } catch (Exception e) {
			// TODO: handle exception
 	    	e.printStackTrace();
			return  null;
		} 
		return  con;
	}
	 
	
}
