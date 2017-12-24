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
    
    <style type="text/css" media="screen">
        @import url('css/common.css');

    </style>
   
</head>
<f:setLocale value="${pageContext.request.locale }"/>

<body>
 <article> 
    <f:setLocale value="${pageContext.request.locale }"/>
    <header id="p_header">
        SharonJia's Online Bookstore-Some Comments
        <div></div>
    </header>
     <br>
    <a style="margin-left:60%" href="index.jsp">Return Home</a>
   <br>
    <br>
          <br>
         <ul>  
        <li><pre>                                 Hi, thanks for your visit. As the first version of my JAVA Web project, it still has lots of to work on. </pre></li>
        <li><br></li>
        <li><pre>                                 If you take interest in making contributions to the project to help it improve</pre></li>
      <li><br></li>
      <li><pre>                                 please visit <a href="https://github.com/sharonJXR">my Github</a> or <a href="https://sharonjxr.github.io/">my blog</a>. </pre>
      
      </li>
      <li><br></li>
      <li><pre>                                 Let's study together! :) </pre></li>
      <li><br></li>
      <li><pre>                                 Copyright: ALL by SharonJia  </pre></li>
      <li><br></li>
      <li><br></li>
 </ul>
    </article>  
    <footer id="p_footer">
        <div></div>
        @Copyright <strong>SharonJia Technology</strong>
    </footer>
</body>
</html>
          
    