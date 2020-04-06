package zeta.core.datasource.Pool;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.logging.Logger; 

import javax.sql.DataSource;

import zeta.core.Context;
import zeta.core.datasource.iDataSource;
import zeta.core.datasource.connection.ConnectionPool;
import zeta.core.datasource.connection.SampleConnectionFactory;

public class PooledDataSource   implements  DataSource, iDataSource{

	private SampleConnectionFactory     scFactory  ;
	private ConnectionPool  connPool ; 
	private Context ctx ;
	 
	public PooledDataSource( Context ctx) {
		 init(ctx);
	}
	
	private void init( Context ctx)
	{
	 scFactory  = new  SampleConnectionFactory(ctx); 
	 connPool  = new ConnectionPool(0, 0, 0, 0);
	 System.out.println(1);
	}
	
	
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <T> T unwrap(Class<T> iface) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isWrapperFor(Class<?> iface) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Connection getConnection() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Connection getConnection(String username, String password) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public PrintWriter getLogWriter() throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setLogWriter(PrintWriter out) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setLoginTimeout(int seconds) throws SQLException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public int getLoginTimeout() throws SQLException {
		// TODO Auto-generated method stub
		return 0;
	}

	public  void  pushIdleConnection() throws  SQLException
	{ 
		Connection connection = scFactory.retriveConnection(); 
		connPool.pushIde(connection);
	}
	 
	/**
	 pop a idle connection object from idleList
	**/
	public  Connection  popIdleConnection()throws  SQLException
	{ 
		return   connPool.popIdle();
	}
	
}
