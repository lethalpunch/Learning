<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.io.*,java.util.*,java.sql.*"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>To Make Connection</title>
</head>
<body>
<%
    Connection conn = null;
    try
    {
        Class.forName("oracle.jdbc.driver.OracleDriver");
        conn = DriverManager.getConnection("jdbc:oracle:thin:@192.168.1.8:1522:SYSTEM", "one_sdk", "password");
        out.println("connected....!!");
        String query="select * from user";
        String yourPassword="";
        String yourUser="";
        String updateQuery="update user set password="+yourPassword+ " where username = '"+yourUser+"'";
        PreparedStatement ps=conn.prepareStatement(query);
        ResultSet rs=ps.executeQuery();
        boolean userExist=false;
       while( rs.next()){
        String username=rs.getString(1);
        String password=rs.getString(2);
        if(username.equals(yourUser))
        {
        	userExist=true;
        }
       }
       ps.close();
        if(userExist)
        {
        	PreparedStatement ps2=conn.prepareStatement(updateQuery);
        	boolean queryStatus=ps2.execute();
        	if(queryStatus)
        	{
        		out.println("password changed");
        		}
        	else
        	{
        		out.println("Error while changing password");
        	}
        }
        else
        {
        	out.println("Enter Valid User");
        }
        
        

    }

    catch(Exception e)
    {
        out.println("Exception : " + e.getMessage() + "");
    }


%>
</body>
</html>