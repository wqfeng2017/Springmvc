<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    
    <title>My JSP 'index.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
  </head>
  
  <body>
  	<center>
	    <div id="outer">
	    	<div>
	    		<p style="color:red;font-size:30px">用户列表</p>
	    	</div>
	    	<hr />
	    	<div id="queryUser">
	    		<form action="">
	    		<table>
	    			<tr>
	    				<td>姓名:</td>
	    				<td><input type="text" name="user.username" ${queryName }></td>
	    				<td><input type="submit" value="查询"></td>
	    			</tr>
	    		</table>
	    		</form>
	    	</div>
	    	
	    	<div id="userList">
	    		<table>
	    			<tr>
	    				<th><input type="checkbox"></th>
	    				<th>编号</th>
	    				<th>姓名</th>
	    				<th>密码</th>
	    				<th>生日</th>
	    				<th>操作</th>
	    			</tr>
	    			
	    			<c:if test="${empty users }">
	    				<tr>
	    					<td colspan="6">没有数据</td>
	    				</tr>
	    			</c:if>
	    			<c:if test="${not empty users }">
	    				<c:forEach var="u" items="${users }" varStatus="vs">
		    				<tr>
		    					<td><input type="checkbox" name="flag" value="${u.userId }" ></td>
		    					<td>${u.userId }</td>
		    					<td><a href='${pageContext.request.contextPath }/user/user_userDetail?user.userId=${u.userId}'>${u.username }</a></td>
		    					<td>${u.password }</td>
		    					<td><fmt:formatDate value="${u.birthday }"  pattern="yyyy-MM-dd" /></td>
		    					<td>修改||删除</td>
		    				</tr>
	    				</c:forEach>
	    			</c:if>
	    			
	    		</table>
	    	</div>
	    	
	    </div>
    </center>
  </body>
</html>
