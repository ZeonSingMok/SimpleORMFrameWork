package zeta;
   

import java.sql.SQLException;

import zeta.Util.PropertiesUtil;
import zeta.core.factory.SqlFactory; 

public class main {

	public static void main(String[] args) 
	{ 
			String  path =  "C:\\Users\\MokZeonSing\\eclipse-workspace\\SimpleORMFrameWork\\zeta\\src\\configaration.properties"; 
		 
			  SqlFactory factory =new SqlFactory();
			  try {
				factory.dos();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			  
			 
	}

}
