package zeta.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertiesUtil
{
    private static  String  defualtPathString = "/configaration.properties"; 
    
    static InputStream  ins  = null; 
	static Map<String, String>   parameterMap = new  HashMap<>();
	
				public   static   Map<String, String>   parsingConfigurationFile(String path)
				{ 
					try 
					{
						if (path == null || path.equals("")  )   
						{ ins =
						Class.forName(PropertiesUtil.class.getName()).getResourceAsStream(defualtPathString)
						;}
						else ins = new FileInputStream(path);
						
						Properties properties  = new  Properties();
						    
						properties.load(ins);
						 
						parameterMap.put("url", properties.getProperty("url"));
						parameterMap.put("user", properties.getProperty("user"));
						parameterMap.put("password", properties.getProperty("password"));
						 
					} catch (Exception e) {
						// TODO: handle exception
						e.printStackTrace();
					}
					 
					return parameterMap; 
				}
}
