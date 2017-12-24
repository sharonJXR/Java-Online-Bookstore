

<%@ page language="java" %>
<%
session.invalidate();
Cookie killMyCookie = new Cookie("mycookie", null);
killMyCookie.setMaxAge(0);
killMyCookie.setPath("/");
response.addCookie(killMyCookie);
response.setHeader("Pragma","No-cache");
response.setHeader("Cache-Control","no-cache");
response.setDateHeader("Expires", 0);
response.flushBuffer();
%>
<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
    <base href="/BookStore/" target="_parent">
    <meta charset="utf-8">
    <title>SharonJia's Online Bookstore</title>
     <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/index.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/nav_right.css" />
    <style type="text/css" media="screen">
        @import url('css/common.css');
        @import url('css/index.css');
        @import url('css/nav_right.css');
    </style>
</head>
<f:setLocale value="${pageContext.request.locale }"/>
<body>
    <f:setLocale value="${pageContext.request.locale }"/>
    <header id="p_header">
        You successfully log out.
        <div></div>
    </header>
     <br>
      <br>
       <br>
    
   <a style="margin-left:45%" href="index.jsp"> <strong>Return to Home</strong></a>
   <br>
   <br>
   <br>
    
    <footer id="p_footer">
        <div></div>
        @Copyright <strong>SharonJia Technology</strong>
    </footer>
</body>
</html>