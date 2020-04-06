package zeta.core.datasource.connection;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;

public class ConnectionPool {

	private List<Connection> idleConnections;
	private List<Connection> activeConnections;

	private int max_idle_num;
	private int min_idle_num;
	private int max_active_num;
	private int min_active_num;

	private volatile int current_idle_num;

	public ConnectionPool(int max_idle_num, int min_idle_num, int max_active_num, int min_active_num) {
		this.max_idle_num = max_idle_num;
		this.min_idle_num = min_idle_num;
		this.max_active_num = max_active_num;
		this.min_active_num = min_active_num;

		idleConnections = new ArrayList<Connection>(max_idle_num);
		activeConnections = new ArrayList<Connection>(max_active_num);

	}

	public boolean checkIdleConnection() {
		if (idleConnections.size() == 0 || idleConnections.size() == min_idle_num)
			return false;
		return true;
	}

	public boolean checkActiveConnection() {
		if (activeConnections.size() == 0 || activeConnections.size() == min_idle_num)
			return false;
		return true;
	}

	public synchronized void pushIde(Connection e) { 
			idleConnections.add(e);
			current_idle_num = current_idle_num + 1; 
	}

	public  synchronized  Connection  popIdle()
	{
		if (current_idle_num  == 0 )
		{
			
		}
		return  idleConnections.remove(0);
	}
	
}
