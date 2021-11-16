//updated till 4th Jan 2021
package src.com.pack.database;

import  java.sql.Connection;		
import  java.sql.Statement;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.pages.HomePage;
import com.qa.factory.DriverFactory;

import implementation.CommonFunction;

import  java.sql.ResultSet;		
import  java.sql.DriverManager;		
import  java.sql.SQLException;
public class database  {
	protected WebDriver driver;
	public String dbUrl;
	CommonFunction cf = new CommonFunction();
	private HomePage homePage = new HomePage(DriverFactory.getDriver());
	public database(WebDriver driver)  {
		this.driver = driver;
	}
 
public String customeremail() throws ClassNotFoundException, SQLException {
	String URL= driver.getCurrentUrl();
	URL = URL.replace("/mypage", "");
	 String uemail=cf.getemail();
	 String site = homePage.getLogoText();
                Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
                System.out.println("Envioranme Value-"+URL);
                if(URL.contains("releasetest")){
                	 dbUrl = "jdbc:sqlserver://krs01db13\\releasetest";
                	 System.out.println(dbUrl);
    			}else{
    				 dbUrl = "jdbc:sqlserver://krs01db13\\test";
    				 System.out.println(dbUrl);
    			} 
                       String sms1=null;
                String ToEmail= null;
                String ToName= null;
                String Body= null;
                String username = "tespire";   
                String password = "Espire123";    
                
                            
                String query = "select top 1 ToEmail, ToName, Body from [NHCustomersales].[dbo].[Emailmessage] where fromname like '%"+site+ "%' and toemail like '%" +uemail+"%' order by Emailmessageid desc;";
                Connection con = DriverManager.getConnection(dbUrl,username,password);  
                System.out.println(con);
                Statement stmt = con.createStatement();
                System.out.println(stmt);
                 ResultSet rs = stmt.executeQuery(query);
                 System.out.println("Query-"+rs);
                 //sms1 = rs.getString("EmailAddress");
              
                  while (rs.next()) {
                	  ToEmail = rs.getString(1);
                	  ToName =rs.getString(2);
                	  Body = rs.getString(3);
                        System.out.println(ToEmail);
                        System.out.println(ToName);
                          Pattern p = Pattern.compile("(/Activate/\\d*/[a-zA-Z0-9]*)");
                        java.util.regex.Matcher m = p.matcher(Body);
                        if (m.find())
                        {
                          // we're only looking for one group, so get it
                          String theGroup = m.group(1);
                          System.out.println("in loop");
                          // print the group out for verification
                          //System.out.format("'%s'\n", theGroup);
                          System.out.println(theGroup);
                          String theGroups = theGroup.replaceAll("\"", "");
                          System.out.println(theGroups);
                          String activation =URL+theGroups;
                          System.out.println(activation);
                          driver.navigate().to(activation);
                        
                        		 
                        }
                   
                         } 

                       rs.close();
                       stmt.close();
                       
                       return sms1;
                                
     
      }
}
