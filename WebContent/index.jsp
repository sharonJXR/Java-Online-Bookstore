<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<f:setLocale value="${pageContext.request.locale }"/>
<body>
    <f:setLocale value="${pageContext.request.locale }"/>
    <header id="p_header">
        SharonJia's Online Bookstore
        <div></div>
    </header>
    <article>
        <header>
   Book List             
        </header>
        <c:forEach items="${books }" var="book">
        <figure>
            <a href="do/book?id=${book.id }">
                <img src="${book.image }">
             </a>
            <footer>
            ${book.name } 
            </footer>
            <figcaption>
                     Price:<f:formatNumber type="currency">${book.sellingPrice }</f:formatNumber>
            	<a href="do/cart?id=${book.id }&op=add">Add to Cart</a> 
            </figcaption>
        </figure>
        </c:forEach>  
        <nav class="list_nav">
            <div class="next"></div>
            <a href="index.jsp#top">top</a>
<!--             <a href="index.jsp#top">2</a>
            <a href="index.jsp#top">3</a>
            <a href="index.jsp#top">4</a>
            <a href="index.jsp#top">5</a>
            <a href="index.jsp#top">7</a>
            <a href="index.jsp#top">20</a>-->
            <div class="previous"></div> 
        </nav>
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
            <li><a href="pages/manager.jsp">Welcome:${user.account }</a></li>
            
            <li> <a href="pages/out.jsp">Log out</a></li>
            
              
            
            <li>
                <a href="do/order">Order Management</a>
            </li>
            <li><a href="pages/manager.jsp">User Management</a></li>
           
            </c:when>
            <c:otherwise>
            	<li><a href="pages/login_register.jsp">Log in/Sign up</a></li>
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
                <li class="operator"><a href="do/cart?id=${item.book.id }&op=add">+ more</a></li>
                <li class="operator"><a href="do/cart?id=${item.book.id }&op=minus">- fewer</a></li>
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
     <section>
        <br>
        <br>
        <br>
         <header><a href="pages/Comments.jsp">Some Comments</a></header>
          
      </section>
    </article>  
    <footer id="p_footer">
        <div></div>
        @Copyright <strong>SharonJia Technology</strong>
    </footer>
</body>
</html>