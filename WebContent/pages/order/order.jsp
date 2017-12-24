<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<base href="/BookStore/" target="_parent">
<meta charset="utf-8">
<title>SharonJia's Online Bookstore</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/order.css" />
<!-- 
<style type="text/css" media="screen">
    @import url('css/common.css');
    @import url('css/order.css');
</style>
 -->
<article>
	<f:setLocale value="${pageContext.request.locale }"/>
    <header>Order Management</header>
    <section>
       <header>Order Info</header>
       <ul class="caption">
           <li class="id">ID</li>
           <li class="total">Total¥</li>
           <li class="user">Consignee</li>
           <li class="book">Book</li>
           <li class="status">Status</li>
         </ul>
         <c:forEach items="${orders }" var="order">
         <ul>
             <li class="id">${order.id }</li>
             <li class="total">
             	<f:formatNumber type="currency">${order.total }</f:formatNumber>
             </li>
             <li class="user">${order.consignee.fullName }</li>
             <li class="book">Check
                  <div>
                  <c:forEach items="${order.items }" var="item">
                   <ul>
                       <li class="id">${item.book.id }</li>
                       <li class="quantity">${item.quantity }</li>
                       <li class="total">
                       		<f:formatNumber type="currency">${item.total }</f:formatNumber>
                       </li>
                       <li class="name">${item.book.name }</li>
                     </ul>
                  </c:forEach>
                 </div>
             </li>
             <li class="status">${order.status }</li>
           </ul>
           </c:forEach>
           <c:remove var="orders"/>
   </section>
</article>
