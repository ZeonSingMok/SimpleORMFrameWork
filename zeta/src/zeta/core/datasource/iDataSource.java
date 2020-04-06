package zeta.core.datasource;

import java.sql.Connection;
import java.sql.SQLException;

public interface iDataSource {
	public  Connection  popIdleConnection() throws  SQLException;
	public  void  pushIdleConnection() throws  SQLException;
}
