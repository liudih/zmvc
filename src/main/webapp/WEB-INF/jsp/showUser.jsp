<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">  
<html>  
  <head>  
    <title>测试</title>  
  </head>  
    
  <body>  
    111 ${user.userName}  
    <br/>
    2222 ${owner}
    <c:if test="${owner == '测试'}">
   <p>My salary is: <c:out value="${owner}"/><p>
</c:if>
<br/>
<c:choose>
  <c:when test="${owner == '测试'}">1111</c:when>
  <c:otherwise>2222</c:otherwise>
</c:choose>
<br/>
<c:forEach items="${list}" var ="li" varStatus="status">
${status.index}-${status.count}: ${li.getUserName()}--${li.getId()}--${li.getPassword()}

<p>
</c:forEach>

---


<p>


    
  </body>  
</html>