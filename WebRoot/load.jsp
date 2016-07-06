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

<title>发布商品</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link rel="stylesheet" type="text/css" href="css/search-form.css">
<link rel="stylesheet" type="text/css" href="css/show.css">
<script type="text/javascript" src="js/search.js"></script>
<script type="text/javascript" src="js/jquery-1.10.1.js"></script>
<script type="text/javascript" src="js/my.js"></script>
<script>
function load(){
	var file = $("#file").val();  
    var name = $("#name").val(); 
    var price = $("#price").val(); 
    var discription = $("#discription").val();
    var contact = $("#contact").val();
    var pattern = /(^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$)|(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
    var checkFile = /\w+([.jpg|.png|.gif|.swf|.bmp|.jpeg]){1}$/;
    var checkPrice = /^[0-9]*$/;
    if (!new RegExp(checkFile).test(file)) {  
    	alert("请上传图片");
    	return false; 
    }else if(name == "" || name == null){
        alert("商品名称不能为空");  
        return false;     	
    }else if((price==""||price ==null)||(!new RegExp(checkPrice).test(price))){
    	alert("请输入正确的商品价格");
    	return false;
    }else if(discription == "" || discription == null){
    	alert("商品描述不能为空");  
        return false;  
    }else if(!new RegExp(pattern).test(contact)){
    	alert("请输入正确的手机号码");  
        return false;
    }else {  
        return true;  
    }  
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

				<span class="menu"><img src="images/nav.png" alt="" />
				</span>
				<div class="top-menu">
					<ul>
						<nav class="cl-effect-13">
						<!-- 登陆 --> <c:if test="${sessionScope.loginUser==null}">
							<li><a href="<%=path%>/Login.jsp">登录</a></li>
						</c:if> <c:if test="${sessionScope.loginUser!=null}">
							<li><a href="<%=path%>/servlet/LoginServlet">已登录</a></li>
						</c:if>
						<li><a class="scroll" href="<%=path%>/servlet/LogOut">注销</a>
						</li>
						<li><a href="<%=path%>/servlet/ShowCarServlet">购物车</a></li>
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
	<div class="container">
		<div class="services-top-grids text-center">

			<div align="center">
				<h1>
					<strong>发布商品信息</strong>
				</h1>
				<br>
				<form
					action="<%=path%>/servlet/addItemServlet"
					enctype="multipart/form-data" method="post">
					<ul style="font-size: 22px;list-style-type:none;">
						<li style="margin-bottom:20px;">上传商品图片：<input type="file"
							name="file1" id="file" />
						</li>
						<li style="margin-bottom:20px;">商品名称：<input type="text" 
							name="name" id="name"/>
						</li>
						<li style="margin-bottom:20px;">商品价格：<input type="text"
							name="price" id="price"/>
						</li>
						<li style="margin-bottom:20px;">商品描述：<input type="text"
							name="discription" id="discription"/>
						</li>
						<li style="margin-bottom:20px;">手机号码：<input type="text"
							name="contact" id="contact"/>
						</li>
						<li style="margin-bottom:20px;">商品类别： <select 
							name="type" >
								<OPTION value=1>数码产品</OPTION>
								<OPTION value=2>图书教材</OPTION>
								<OPTION value=3>美妆服饰</OPTION>
								<OPTION value=4>生活其他</OPTION>
						</select></li>						
					</ul>
					<input type="submit" value="提交" onClick="return load();"/>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
