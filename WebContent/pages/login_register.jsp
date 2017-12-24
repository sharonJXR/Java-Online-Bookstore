<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <base href="/BookStore/" target="_parent">
    <meta charset="utf-8">
    <title>SharonJia's Online Bookstore-User Log in/Sign up</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/login_register.css" />
    
    <style type="text/css" media="screen">
        @import url('css/common.css');
        @import url('css/login_register.css');
    </style>
    <!--|　|-->
</head>
<body>
    <header id="p_header">
        SharonJia's Online Bookstore
        <div></div>
    </header>
    <article class="register">
    
     <form action="do/user" method="post">
            <header>User Register
            <c:if test="${name_err != null }">
            		<strong style="color:#f00">${name_err }</strong>
            	</c:if>
            </header>
            <input type="hidden" name="op" value="register">
            <br>
            
            <p><label>Name:</label><input name="name"/></p>
            <p><label>Password:</label><input name="password" type="password"/></p>
            <p><label>Confirm:</label><input name="confirm" type="password"/></p>
            <p><label>EmailAddress:</label><input name="email"/></p>
            <p><button type="submit">Register</button></p>
        </form>
    </article> 
    <article class="login">
    <header><a style="margin-left:60%" href="index.jsp">Return Home</a></header>
        <form action="do/user" method="post">
             <header>Log in
             	<c:if test="${login_err != null }">
            		<strong style="color:#f00">${login_err }</strong>
            	</c:if>
             </header>
             <input type="hidden" name="op" value="login">
             <br>
             <p><label>Name:</label><input name="name"/></p>
             <p><label>Password:</label><input name="password"  type="password"/></p>
             <p><!-- <button type="submit">Forget Password</button> -->
             <button type="submit">Log in</button></p>
             
              <br>
            <br>
            <br>
            <br>
            <br>
            <br>
            
            <div>**Attention:Your login status will be automatically terminated within 15 minutes.**</div>
        </form>
    </article>
    
    <footer id="p_footer">
        <div></div>
        @Copyright <strong>SharonJia Technology</strong>
    </footer>
</body>
</html>
