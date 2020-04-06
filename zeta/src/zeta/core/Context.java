package zeta.core;

import java.util.Map;

public class Context
{
		  public    Context (Map<String, String>   parameterMap )
		  {
			 
			  this.url =  parameterMap.get("url");
			  this.user =  parameterMap.get("user");
			  this.passwd =  parameterMap.get("password"); 
			  this.ConectionType = parameterMap.get("ConectionType");
		  }
		  
		  private    String  url; 
		  private    String  user;
		  private    String  passwd;
		  private    String  ConectionType ; 
		public String getUrl() {
			return url;
		}
		public String getUser() {
			return user;
		}
		public String getPasswd() {
			return passwd;
		}
		public String getConectionType()
		{
			if (ConectionType == null || ConectionType.equals("")) return  "Poll";
			return ConectionType;
		}
		  
		  
		  
		  
}
