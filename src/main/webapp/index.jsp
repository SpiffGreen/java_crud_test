<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page session="true"%>
<%@ page isELIgnored="false" %> 
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="./static/css/global.css" />
    <title>Servlet Auth</title>
  </head>
  <body>
    <h1 class="text-3xl">Well hello motherfucker!!</h1>
    <div>
      <!-- <c:out value="${pageContext.session.getAttribute('user')}" /> -->
      <c:set var = "user" scope = "session" value = "${pageContext.session.getAttribute('user')}"/>
      <c:choose>
        <c:when test="${user != null}">
          <a href="dashboard.jsp">Dashboard</a>
        </c:when>
        <c:otherwise>
          <a href="./login">Login</a>
          <a href="./register">Register</a>
         </c:otherwise>
      </c:choose>
    </div>
  </body>
</html>
