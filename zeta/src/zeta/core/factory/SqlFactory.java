package zeta.core.factory;
 

import java.sql.Connection;
import java.sql.SQLException;

import zeta.Util.PropertiesUtil;
import zeta.core.Context;
import zeta.core.datasource.DataSourceFactory; 

public class SqlFactory implements  SqlFactoryInterface
{
	private    Context context = null;   
	private    DataSourceFactory   datasourceFactory  ; 
	
	public SqlFactory() 
	{   
		context = new Context(PropertiesUtil.parsingConfigurationFile(null));
		datasourceFactory = new DataSourceFactory(context); 
	}
	 
	public void  dos() throws SQLException
	{
		
		datasourceFactory.pushConnection();
		Connection conn = datasourceFactory.popConnection();
		 
	}
	
	
	
	
}
