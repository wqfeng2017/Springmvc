<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
    <div>
    	<form action="${pageContext.request.contextPath }/user/loginUser" method="post">
    		username:<input type="text" name="uname" /><br />
    		password:<input type="password" name="upass"> <br />
    		
    		<input type="submit" value="提交" />
    	</form>
    </div>
  </body>
</html>
