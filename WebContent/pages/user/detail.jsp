<%@ page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsp/jstl/fmt"%>
    <base href="/BookStore/" target="_parent">
    <meta charset="utf-8">
    <title>SharonJia's Online Bookstore</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css" />
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/detail.css" />
    <!-- 
    <style type="text/css" media="screen">
        @import url('css/common.css');
        @import url('css/detail.css');
    </style>
     -->
    </head>
<f:setLocale value="${pageContext.request.locale }"/>
<body>
    <f:setLocale value="${pageContext.request.locale}"/>
        <div></div>
    </header>

    <article>
    <f:setLocale value="${pageContext.request.locale }"/>
    
    
        <header><strong>My Account</strong></header>

		      <section>
		       <br>


		    <p>Name:${user.account }</p>
		    <p>Email:${user.email }</p>
            <p>Point:1000 </p>
            <p>Level:A</p>        
            <p>Last visiting time:2017-8-20 11:11:11</p>
            <br>
             <br>
              <br>
              
               <br> <br>
                <br>
      
            <p>**Points raise every time you complete order and give us a "thumb""thumb"!**</p>
            <p>**Level raises as points do.**</p>
            
      
       </section>
    </article>
    