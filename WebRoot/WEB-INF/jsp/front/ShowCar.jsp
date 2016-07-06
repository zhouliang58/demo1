<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">
<title>购物车</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/search-form.css">
<link rel="stylesheet" type="text/css" href="css/show.css">
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript" src="js/my.js"></script>
<script type="text/javascript">
function CheckedDelete(){
	var s1 =document.getElementsByName("select");
	var s2 = "";
    for( var i = 0; i < s1.length; i++ )
    { 
      if ( s1[i].checked ){
      s2 += s1[i].value+',';
     }
    } 
    s2 = s2.substr(0,s2.length-1);
    location.href = "<%=path%>/servlet/deleteCarServlet?id="+s2; //传过去一个用,分隔的id字符串
}

function CheckedBuy(){
	var s1 =document.getElementsByName("select");
	var s2 = "";
    for( var i = 0; i < s1.length; i++ )
    { 
      if ( s1[i].checked ){
      s2 += s1[i].value+',';
     }
    } 
    s2 = s2.substr(0,s2.length-1);
    location.href = "<%=path%>/servlet/BuyServlet?id="+s2; //传过去一个用,分隔的id字符串
}
</script>
</head>

<body style="background-color:#f0f0f0;">
	<!-- head begin -->
	<div class="about-header-banner">
		<div class="container">
			<div class="home">
				<a href="HomePage.jsp"><span class="glyphicon glyphicon-home"></span>
				</a>
			</div>
			<div class="header-top">
				<div class="social-icons">
					<i class="facebook"></i> <i class="twitter"></i> <i
						class="googlepluse"></i>
				</div>
				<span class="menu"><img src="images/nav.png" alt="" /> </span>
				<div class="top-menu">
					<ul>
						<nav class="cl-effect-13">
						<li><a href="#">关于</a>
						</li>
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
										<input type="text" class="search-input"
											placeholder="Type to search" />
										<button class="search-icon"
											onclick="searchToggle(this, event);">
											<span></span>
										</button>
									</div>
									<span class="close" onclick="searchToggle(this, event);"></span>
									<!--  <div class="result-container">
								</div> -->
								</div>
							</form> <!-- 搜索框 --></li>
					</ul>
				</div>
				<!-- script for menu -->
				<script>
					$("span.menu").click(function() {
						$(".top-menu ul").slideToggle(300, function() {
							// Animation complete.
						});
					});
				</script>
				<!-- //script for menu -->
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
			<div class="banner-info text-center">
				<h1>
					<a href="HomePage.jsp">shopping</a>
				</h1>
			</div>
		</div>

	</div>
	<!-- head end -->

	<!-- content-section-starts -->
	<!-- 循环展示商品信息 -->
	<div class="services">
		<div class="container">
			<div class="services-top-grids text-center">
				<h3>我的购物车</h3>
				<c:forEach items="${carItems}" var="item" varStatus="status">
					<!-- 每四个商品换行 -->
					<c:if test="${status.count==1}">
						<div class="secvice-top-grid-1">
							<img class="secvice-img" alt="camera"
								src="<%=basePath %>/upload/${item.image }"> <span
								class="secvice-title"><c:out value="${item.name }"></c:out><br>
								<c:out value="${item.price }"></c:out> </span> <input class="select"
								type="checkbox" name="select" value="${item.id }"></input>
						</div>
					</c:if>
					<c:if test="${status.count==2}">
						<div class="secvice-top-grid-2">
							<img class="secvice-img" alt="camera"
								src="<%=basePath %>/upload/${item.image }"> <span
								class="secvice-title"><c:out value="${item.name }"></c:out><br>
								<c:out value="${item.price }"></c:out> </span> <input class="select"
								type="checkbox" name="select" value="${item.id }"></input>
						</div>
					</c:if>
					<c:if test="${status.count==3}">
						<div class="secvice-top-grid-3">
							<img class="secvice-img" alt="camera"
								src="<%=basePath %>/upload/${item.image }"> <span
								class="secvice-title"><c:out value="${item.name }"></c:out><br>
								<c:out value="${item.price }"></c:out> </span> <input class="select"
								type="checkbox" name="select" value="${item.id }"></input>
						</div>
					</c:if>
					<c:if test="${status.count==4}">
						<div class="secvice-top-grid-4">
							<img class="secvice-img" alt="camera"
								src="<%=basePath %>/upload/${item.image }"> <span
								class="secvice-title"><c:out value="${item.name }"></c:out><br>
								<c:out value="${item.price }"></c:out> </span> <input class="select"
								type="checkbox" name="select" value="${item.id }"></input>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<div class="services">
		<div class="container">
			<div class="services-top-grids text-center">
				<c:forEach items="${carItems}" var="item" varStatus="status">
					<!-- 每四个商品换行 -->
					<c:if test="${status.count==5}">
						<div class="secvice-top-grid-1">
							<img class="secvice-img" alt="camera"
								src="<%=basePath %>/upload/${item.image }"> <span
								class="secvice-title"><c:out value="${item.name }"></c:out><br>
								<c:out value="${item.price }"></c:out> </span> <input class="select"
								type="checkbox" name="select" value="${item.id }"></input>
						</div>
					</c:if>
					<c:if test="${status.count==6}">
						<div class="secvice-top-grid-2">
							<img class="secvice-img" alt="camera"
								src="<%=basePath %>/upload/${item.image }"> <span
								class="secvice-title"><c:out value="${item.name }"></c:out><br>
								<c:out value="${item.price }"></c:out> </span> <input class="select"
								type="checkbox" name="select" value="${item.id }"></input>
						</div>
					</c:if>
					<c:if test="${status.count==7}">
						<div class="secvice-top-grid-3">
							<img class="secvice-img" alt="camera"
								src="<%=basePath %>/upload/${item.image }"> <span
								class="secvice-title"><c:out value="${item.name }"></c:out><br>
								<c:out value="${item.price }"></c:out> </span> <input class="select"
								type="checkbox" name="select" value="${item.id }"></input>
						</div>
					</c:if>
					<c:if test="${status.count==8}">
						<div class="secvice-top-grid-4">
							<img class="secvice-img" alt="camera"
								src="<%=basePath %>/upload/${item.image }"> <span
								class="secvice-title"><c:out value="${item.name }"></c:out><br>
								<c:out value="${item.price }"></c:out> </span> <input class="select"
								type="checkbox" name="select" value="${item.id }"></input>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
		<div class="clearfix"></div>
	</div>
	<!-- 选中删除 -->
	<div>
		<span class="countmoney">
			<input type="button" onclick="CheckedDelete()" value="选中删除"/></span>
	</div>
	<!-- 选中购买 -->	
	<div>
		<span class="countmoney">
			<input type="button" onclick="CheckedBuy()" value="选中购买"/></span>
	</div>
</body>
</html>
