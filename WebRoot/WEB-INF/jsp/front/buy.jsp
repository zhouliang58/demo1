<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8"%>
<%@ page import="model.Items"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">    
    <title>商品购买页面</title>
	<link rel="stylesheet" type="text/css" href="css/style.css">
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
    <link rel="stylesheet" type="text/css" href="css/search-form.css">
    <link rel="stylesheet" type="text/css" href="css/show.css">
    <script type="text/javascript" src="js/search.js"></script>
	<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
	<script type="text/javascript" src="js/my.js"></script>
  </head>
  
  <body style="background-color:#f0f0f0;">
     <!-- head begin -->
   <div class="about-header-banner">
		<div class="container">
			<div class="home">
					<a href="HomePage.jsp"><span class="glyphicon glyphicon-home"></span></a>
			</div>
			<div class="header-top">
				<div class="social-icons">
					<i class="facebook"></i>
					<i class="twitter"></i>
					<i class="googlepluse"></i>
				</div>
				<span class="menu"><img src="images/nav.png" alt=""/></span>
				<div class="top-menu">
					<ul>
					<nav class="cl-effect-13">
						<li><a href="#">关于</a></li>
						<!-- 登陆 -->
						<c:if test="${sessionScope.loginUser==null}"><li><a href="<%=path %>/Login.jsp">登录</a></li></c:if>
						<c:if test="${sessionScope.loginUser!=null}"><li><a href="<%=path %>/servlet/LoginServlet">已登录</a></li></c:if>						
						<li><a class="scroll" href="<%=path %>/servlet/LogOut">注销</a></li>
						<li><a href="<%=path %>/servlet/ShowCarServlet">购物车</a></li>
						<li><a href="load.jsp">发布商品</a></li>
					</nav>
					<li>
					 <li>
					    <!-- 搜索框 -->
						<form onsubmit="submitFn(this, event);">
							<div class="search-wrapper">
								<div class="input-holder">
									<input type="text" class="search-input" placeholder="Type to search" />
									<button class="search-icon" onclick="searchToggle(this, event);"><span></span></button>
								</div>
								<span class="close" onclick="searchToggle(this, event);"></span> 
								<!--  <div class="result-container">
								</div> -->
							</div>
						</form>
					<!-- 搜索框 -->
					</li>
					</ul>
				</div>
				<!-- script for menu -->
					<script> 
						$( "span.menu" ).click(function() {
						$( ".top-menu ul" ).slideToggle( 300, function() {
						 // Animation complete.
						});
						});
					</script>
				<!-- //script for menu -->
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
			<div class="banner-info text-center">
				<h1><a href="HomePage.jsp">shopping</a></h1>
			</div>
		</div>
		
	</div>
	<!-- head end -->
	<!--  <div class="services">  -->
		<div class="container">
			<div class="services-top-grids text-center">
				<% Items item = (Items)request.getAttribute("item"); %>
				<div class="secvice-top-grid-1">
					<img class="secvice-img" alt="camera" src="<%=basePath %>/upload/<%=item.getImage() %>">						
				</div>
				<span>
				<h1>商品信息</h1>
				<br>
				<h3>商品名：<%=item.getName() %></h3>
				<h3>价格：<%=item.getPrice() %></h3>
				<h3>商品描述：<%=item.getDiscription() %></h3>
				<h3>联系方式：<%=item.getContact() %></h3>
				</span>
			</div>
		</div>	
		
		<!-- 添加到购物车 -->
    	<form method="post" action="<%=basePath %>/servlet/CarServlet?itemID=<%=item.getId()%>&itemPrice=<%=item.getPrice() %>&itemName=<%=item.getName() %>&itemImage=<%=item.getImage()%>">  	
	    	<button type="submit" name="addcar" >添加到购物车</button>
    	</form>
    	<!-- 直接购买 -->
    	<form method="post" action="<%=basePath %>/servlet/BuyServlet?itemID=<%=item.getId()%>&itemPrice=<%=item.getPrice() %>&itemName=<%=item.getName() %>">
	    	<button type="submit" name="addcar" >直接购买</button>
    	</form>	
  </body>
</html>
