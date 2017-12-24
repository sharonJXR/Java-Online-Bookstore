<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!-- 核心标签库 -->
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
    <base href="${pageContext.servletContext.contextPath }/" target="_parent">
    <meta charset="utf-8">
    <title>SharonJia's Online Bookstore-book details</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/book_detail.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/nav_right.css" />
    <!--
    <style type="text/css" media="screen">
        @import url('css/common.css');
        @import url('css/book_detail.css');
        @import url('css/nav_right.css');
    </style>
    |　|-->
</head>
<f:setLocale value="${pageContext.request.locale }"/>
<body>
    <header id="p_header">
        SharonJia's Online Bookstore
        <div></div>
    </header>
    <article >
        <header>${book.name }<a style="margin-left:80%" href="index.jsp">Home</a></header>
        <section class="detail">
             <figure>
                 <img src="${book.image }">
                 <figcaption> 
                 	${book.instroduction }
                 </figcaption>
            </figure>
            <ul>
                <li>Price: <f:formatNumber type="currency">${book.sellingPrice }</f:formatNumber>   </li>
                <li>Sales: 1000</li>
                <li>Author: ${book.author } </li>
                <li>Publisher: ${book.bookConcern }</li>
                <li>Publishing Date: <f:formatDate value="${book.publishingDate }" pattern="yyyy-MM-dd"/>
                </li>
                <li>ＩＳＢＮ: ${book.isbn }</li>
            </ul>
            <a href="do/cart?id=${book.id }&op=add">Add to Cart</a>
        </section>
       
        <section class="description">
            <header>Description</header>
            <div> 
            
            	${book.description }
            </div>
        </section>
        <section class="description">
            <header>AuthorIntroduction</header>
            <div>
				${book.authorIntroduction }
            </div>
        </section>
        <section class="cakalog">
            <header>Chapters</header>
            <pre>
          
            Chapter1：Welcome! This is Chapter I!
            Chapter2：Welcome! This is Chapter II!
            Chapter3：Welcome! This is Chapter III!
            Chapter4：Welcome! This is Chapter IV!
            Chapter5：Welcome! This is Chapter V!
            Chapter6：Welcome! This is Chapter VI!
           
            </pre>
        </section>
    </article> 
    <article class="right">
    <form action="#" method="get" class="search" accept-charset="utf-8">
        <input type="text" name="content">
        <button type="submit">Search</button>
    </form>
    <nav>
        <header>Management</header>
        <ul>
        	<c:choose>
            <c:when test="${user!=null }">
            <li><a href="pages/manager.jsp">Welcome :${user.account }</a></li>
            <li><a href="pages/manager.jsp">User Management</a></li>
            <li>
                <a href="do/order">Order Management</a>
                
            </li>
            </c:when>
            <c:otherwise>
            	<li><a href="pages/login_register.jsp">Log in/Sign up</li>
            </c:otherwise>
            </c:choose>
        </ul>
    </nav>
    <section>
        <header>Cart</header>
        <ul>
        	<c:forEach items="${cart.items }" var="item">
            <li>${item.book.name }
                <ul>
                <li>ID:${item.book.id }</li>
                <li>Quantity:${item.quantity }</li>
                <li>Total:<f:formatNumber type="currency">${item.total }</f:formatNumber></li>
                <li class="operator"><a href="do/cart?id=${item.book.id }&op=remove">Delete</a></li>
                </ul>
            </li>
            </c:forEach>
        </ul>
        <footer>
           Total: <f:formatNumber type="currency">${cart.total }</f:formatNumber>
            <button   onclick="document.location.href='pages/manager.jsp#conent/order/cart.jsp'">
                Submit
            </button>
        </footer>
    </section>
    </article>  
    <footer id="p_footer">
        <div></div>
        @Copyright <strong>SharonJia Technology</strong>
    </footer>
</body>
</html>
