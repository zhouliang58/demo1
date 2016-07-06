<%@ page language="java" import="java.util.*"
	contentType="text/html; charset=utf-8"%>
<%@ page import="model.Items"%>
<%@ page import="model.Pager"%>
<%@ page import="java.util.*"%>
<%@ page import="java.io.*"%>
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

<title>商品展示</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/search-form.css">
<link rel="stylesheet" type="text/css" href="css/show.css">
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript" src="js/my.js"></script>
<script> 	
// 当前第几页数据
var currentPage = ${result.currentPage};

// 总页数
var totalPage = ${result.totalPage};

function submitForm(actionUrl){
	var formElement = document.getElementById("itemsForm");
	formElement.action = actionUrl;
	formElement.submit();
}

// 第一页
function firstPage(){
	if(currentPage == 1){
		alert("已经是第一页数据");
		return false;
	}else{
		submitForm("<%=path%>/servlet/LimitItemsServlet?pageNum=1#location");
		return true;
	}
}

// 下一页
function nextPage(){
	if(currentPage == totalPage){
		alert("已经是最后一页数据");
		return false;
	}else{
		submitForm("<%=path%>/servlet/LimitItemsServlet?pageNum=" + (currentPage+1)+"#location");
		return true;
	}
}

// 上一页
function previousPage(){
	if(currentPage == 1){
		alert("已经是第一页数据");
		return false;
	}else{
		submitForm("<%=path%>/servlet/LimitItemsServlet?pageNum=" + (currentPage-1)+"#location");
		return true;
	}
}

// 尾页
function lastPage(){
	if(currentPage == totalPage){
		alert("已经是最后一页数据");
		return false;
	}else{
		submitForm("<%=path%>/servlet/LimitItemsServlet?pageNum=${result.totalPage}"+ "#location");
			return true;
		}
	}
</script>
</head>

<body style="background-color:#f0f0f0;">
	<!-- head begin -->
	<div class="header-banner">
		<div class="container">
			<div class="home">
				<a href="HomePage.jsp"><span class="glyphicon glyphicon-home"></span>
				</a>
			</div>
			<div class="header-top">

				<span class="menu"><img src="images/nav.png" alt="" />
				</span>
				<div class="top-menu">
					<ul>
						<nav class="cl-effect-13">
						<li><a href="#">关于</a></li>
						<!-- 登陆 --> <c:if test="${sessionScope.loginUser==null}">
							<li><a href="<%=path%>/Login.jsp">登录</a></li>
						</c:if> <c:if test="${sessionScope.loginUser!=null}">
							<li><a href="<%=path%>/servlet/LoginServlet">已登录</a></li>
						</c:if>
						<li><a class="scroll" href="<%=path%>/servlet/LogOut">注销</a>
						</li>
						<li><a href="<%=path%>/servlet/ShowCarServlet">购物车</a></li>
						<li><a href="load.jsp">发布商品</a>
						</li>
						</nav>
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
				<div class="clearfix"></div>
			</div>
			<div class="clearfix"></div>
			<div class="banner-info text-center">
				<h1>
					<a href="HomePage.jsp">shopping</a>
				</h1>
			</div>
			<div class="header-bottom-grids text-center">
				<div class="header-bottom-grid1">
					<span class="glyphicon glyphicon-camera"></span>
					<h4>
						<a style="text-decoration:none"
							href="<%=path%>/servlet/LimitByTypeServlet?pageNum=1&itemType=数码产品#location">数码产品</a>
					</h4>
				</div>
				<div class="header-bottom-grid2">
					<span class="glyphicon glyphicon-book"></span>
					<h4>
						<a style="text-decoration:none"
							href="<%=path%>/servlet/LimitByTypeServlet?pageNum=1&itemType=图书教材#location">图书教材</a>
					</h4>
				</div>
				<div class="header-bottom-grid3">
					<span class="glyphicon glyphicon-user"></span>
					<h4>
						<a style="text-decoration:none"
							href="<%=path%>/servlet/LimitByTypeServlet?pageNum=1&itemType=美妆服饰#location">美妆服饰</a>
					</h4>
				</div>
				<div class="header-bottom-grid4">
					<span class="glyphicon glyphicon-cutlery"></span>
					<h4>
						<a style="text-decoration:none"
							href="<%=path%>/servlet/LimitByTypeServlet?pageNum=1&itemType=生活其他#location">生活其他</a>
					</h4>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!-- head end -->
	<div class="services">
		<div class="container">
			<div class="services-top-grids text-center">

				<p style="text-align: left;" id="location">
					<strong>您的位置:首页><c:out value="${itemType }"></c:out>
					</strong>
				</p>
				<!-- 遍历商品信息 -->
				<c:forEach items="${result.dataList }" var="item" varStatus="status">
					<c:if test="${status.count==1}">
						<div class="secvice-top-grid-1">
							<!-- 点击图片显示购买页面 -->
							<a href="<%=path %>/servlet/ShowItemServlet?id=${item.id }">
								<img class="secvice-img" alt="camera"
								src="<%=basePath %>upload/${item.image} "> </a> <span
								class="secvice-title">
									<c:out value="${item.name }"></c:out>
									<br><c:out value="${item.price }"></c:out>$
								
							</span> <br>
						</div>
					</c:if>
					<c:if test="${status.count==2}">
						<div class="secvice-top-grid-2">
							<!-- 点击图片显示购买页面 -->
							<a href="<%=path %>/servlet/ShowItemServlet?id=${item.id }">
								<img class="secvice-img" alt="camera"
								src="<%=basePath %>upload/${item.image} "> </a> <span
								class="secvice-title">
									<c:out value="${item.name }"></c:out>
									<br><c:out value="${item.price }"></c:out>$
								
							</span>
						</div>
					</c:if>
					<c:if test="${status.count==3}">
						<div class="secvice-top-grid-3">
							<!-- 点击图片显示购买页面 -->
							<a href="<%=path %>/servlet/ShowItemServlet?id=${item.id }">
								<img class="secvice-img" alt="camera"
								src="<%=basePath %>upload/${item.image} "> </a> <span
								class="secvice-title">
									<c:out value="${item.name }"></c:out>
									<br><c:out value="${item.price }"></c:out>$
								
							</span>
						</div>
					</c:if>
					<c:if test="${status.count==4}">
						<div class="secvice-top-grid-4">
							<!-- 点击图片显示购买页面 -->
							<a href="<%=path %>/servlet/ShowItemServlet?id=${item.id }">
								<img class="secvice-img" alt="camera"
								src="<%=basePath %>upload/${item.image} "> </a> <span
								class="secvice-title">
									<c:out value="${item.name }"></c:out>
									<br><c:out value="${item.price }"></c:out>$
								
							</span>
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
				<!-- 遍历商品信息 -->
				<c:forEach items="${result.dataList }" var="item" varStatus="status">
					<c:if test="${status.count==5}">
						<div class="secvice-top-grid-1">
							<!-- 点击图片显示购买页面 -->
							<a href="<%=path %>/servlet/ShowItemServlet?id=${item.id }">
								<img class="secvice-img" alt="camera"
								src="<%=basePath %>upload/${item.image} "> </a> <span
								class="secvice-title">
									<c:out value="${item.name }"></c:out>
									<br><c:out value="${item.price }"></c:out>$
								
							</span> <br>
						</div>
					</c:if>
					<c:if test="${status.count==6}">
						<div class="secvice-top-grid-2">
							<!-- 点击图片显示购买页面 -->
							<a href="<%=path %>/servlet/ShowItemServlet?id=${item.id }">
								<img class="secvice-img" alt="camera"
								src="<%=basePath %>upload/${item.image} "> </a> <span
								class="secvice-title">
									<c:out value="${item.name }"></c:out>
									<br><c:out value="${item.price }"></c:out>$
								
							</span>
						</div>
					</c:if>
					<c:if test="${status.count==7}">
						<div class="secvice-top-grid-3">
							<!-- 点击图片显示购买页面 -->
							<a href="<%=path %>/servlet/ShowItemServlet?id=${item.id }">
								<img class="secvice-img" alt="camera"
								src="<%=basePath %>upload/${item.image} "> </a> <span
								class="secvice-title">
									<c:out value="${item.name }"></c:out>
									<br><c:out value="${item.price }"></c:out>$
								
							</span>
						</div>
					</c:if>
					<c:if test="${status.count==8}">
						<div class="secvice-top-grid-4">
							<!-- 点击图片显示购买页面 -->
							<a href="<%=path %>/servlet/ShowItemServlet?id=${item.id }">
								<img class="secvice-img" alt="camera"
								src="<%=basePath %>upload/${item.image} "> </a> <span
								class="secvice-title">
									<c:out value="${item.name }"></c:out>
									<br><c:out value="${item.price }"></c:out>$
								
							</span>
						</div>
					</c:if>
				</c:forEach>
			</div>
		</div>
	</div>
	<button
		style="background-color: #D4ACE2;
                 position: absolute;
                 left: 400px;      
                 color: #fff"
		onclick="firstPage();">
		<strong>首页</strong>
	</button>
	<button
		style="background-color: #BE8AD0;
                 position: absolute;
                 left: 560px;      
                 color: #fff"
		onclick="previousPage();">
		<strong>上一页</strong>
	</button>
	<span
		style="font-size:32;
                 position:absolute;
                 left:670px;"><strong>&nbsp<c:out value="${result.currentPage}"></c:out></strong>
	</span>
	<button
		style="background-color: #BE8AD0;
                 position: absolute;
                 left: 710px;
                 color: #fff"
		onclick="nextPage();">
		<strong>下一页</strong>
	</button>
	<button
		style="background-color: #D4ACE2;
                 position: absolute;
                 left: 860px;      
                 color: #fff"
		onclick="lastPage();">
		<strong>尾页</strong>
	</button>

	<!-- 用来提交的表单，不做其他用处 -->
	<form action="<%=path%>/servlet/LimitItemsServlet" id="itemsForm"
		method="post">
	</form>
</body>
</html>
