<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt" %>
<base href="/BookStore/" target="_parent">
<meta charset="utf-8">
<<f:setLocale value="${pageContext.request.locale }"/>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/cart.css" />
<!-- 
<style type="text/css" media="screen">
    @import url('css/common.css');
    @import url('css/cart.css');
</style>
 -->
<article>
    <header>Submit Orders</header>
    <section>
       <header>Cart info</header>
       <ul class="caption">
           <li class="id">ID</li>
           <li class="name">Name</li>
           <li class="price">Price</li>
           <li class="quantity">Quantity</li>
           <li class="total">Total</li>
           <li class="operator">Operator</li>
         </ul>
         <c:forEach items="${cart.items }" var="item">
         <ul class="odd">
             <li class="id">${item.book.id }</li>
             <li class="name">${item.book.name }</li>
             <li class="price">
             	<f:formatNumber type="currency" value="${item.book.sellingPrice }"/>
             </li>
             <li class="quantity"><input name="quantity" value="1"></li>
             <li class="total">
             	<f:formatNumber type="currency" value="${item.total }"/>
             </li>
             <br>
             <li class="operator"><a href="">Delete</a></li>
           </ul>
           </c:forEach>
          <footer>Total: <f:formatNumber type="currency" value="${cart.total }"/>          
          </footer>
   </section>
   <!---->
   <section>
      <header>Consignee</header>
      <ul class="caption">
          <li class="check">Check</li>
          <li class="id">ID</li>
          <li class="full_name">Name</li>
          <li class="tel">TEL</li>
          <li class="operator">Operator</li>
        </ul>
        <form action="do/order" id="submit_order" method="post">
        <c:forEach items="${user.consignees }" var="consignee">
        <ul class="odd">
            <li class="check"><input value="${consignee.id }" type="radio" name="consigneeId" ></li>
            <li class="id">${consignee.id }</li>
            <li class="full_name">${consignee.fullName }</li>
            <li class="tel">${consignee.tel }</li>
            <li class="operator"><a href="">Delete</a></li>
            <section>
	            <ul class="odd">
		           <li class="province">State: ${consignee.province }</li>
		           <li class="city">City: ${consignee.city }</li>
		           <li class="street">Street: ${consignee.extra }</li>
		         </ul>
	          </section>
          </ul>
          </c:forEach>
          </form>
            <form action="do/consignee" method="post">
            <ul class="add">
                <li class="real_name">Name:<input type="text" name="name"></li>
                <li class="tel">Tel:<input type="text" name="tel"></li>
                <li class="province">State: 
                   <input name="province" list="province_list" />
                   <datalist id="province_list">
                       <option value="1xxxxxxxxx">
                       <option value="2xxxxxxxxx">
                   </datalist>
               </li>
               <li class="city">City: 
	               <input name="city" list="city_list" />
	               <datalist id="city_list">
	                   <option value="1xxxxxxxxx">
	                   <option value="2xxxxxxxxx">
	               </datalist>
               </li>
             </ul>
              <ul class="add">
               <li class="street">Street: <input name="street"></li>
               <li class="operator"><button type="submit">Add</button></li>
            </ul>
            </form>
  </section>
 <footer><button onclick="document.getElementById('submit_order').submit()">Submit Order</button></footer>
</article>
