<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<%--  error/error_common.jsp --%>
<body>
   
   <h3>에러발생: ${exception.getMessage() }</h3>
    <ul>
     <c:forEach items="${exception.getStackTrace() }" var="stack">
         <li>${stack }</li>
     </c:forEach>
   </ul> 
</body>
</html>

