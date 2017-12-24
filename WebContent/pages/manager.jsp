<%@ page pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <base href="/BookStore/" target="iframe_content">
    <meta charset="utf-8">
    <title>SharonJia's Online Bookstore-Manager</title>
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/common.css" />
    <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/css/manager.css" />
    <!-- 
    <style type="text/css" media="screen">
        @import url('css/common.css');
        @import url('css/manager.css');
    </style>
     -->
    <script src="js/book_store.js">
    </script>
    <!--|　|-->
</head>
<body>
    <header id="p_header">
        SharonJia's Online Bookstore
        <div></div>
    </header>
    <iframe id="iframe_content" name="iframe_content" src="${empty manager_iframe ? 'pages/user/detail.jsp': manager_iframe}"></iframe>
    <script type="text/javascript" charset="utf-8">
        book_store.setIFrame(document.location.href);
    </script>
    <nav>
        <a id＝"index_href" href="index.jsp" target="_parent">Home Page</a>
       <dl>
          <dt>Personal Information Management</dt>
          <dd><a href="pages/user/detail.jsp">Accounts Information</a></dd>
          <dt>Order Management</dt>
          <dd><a href="pages/order/cart.jsp">Incomplete orders</a></dd>
          <dd><a href="do/order">Complete Orders</a></dd>
       </dl>
    </nav>
    
    <footer id="p_footer">
        <div></div>
        @Copyright <strong>SharonJia Technology</strong>
    </footer>
</body>
</html>