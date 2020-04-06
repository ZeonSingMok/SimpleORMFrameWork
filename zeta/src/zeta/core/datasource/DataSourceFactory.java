package zeta.core.datasource;

import java.sql.Connection;
import java.sql.SQLException;

import zeta.core.Context;
import zeta.core.datasource.Pool.PooledDataSource;

public class DataSourceFactory
{
	private Context ctx ; 
	public   iDataSource  dataSource ; 
	
	
	public   DataSourceFactory( Context context) {this.ctx =context; initFactory(ctx);}
		
	private  void  initFactory(Context context) 
	{
		switch (context.getConectionType()) {
		case "Poll":
			dataSource =  new  PooledDataSource(context); 
			break;

		default:
			break;
		}
	}
	
	public Connection popConnection () throws SQLException
	{
		 return  dataSource.popIdleConnection();
	}
	
	public void pushConnection () throws SQLException
	{
		    dataSource.pushIdleConnection();
	}
	
}
