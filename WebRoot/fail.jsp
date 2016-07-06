<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<title>登陆失败</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>

<body>
	<script type="text/javascript">
		var t = 5; // 设定跳转的时间  
		setInterval("refer()", 1000); // 启动1秒定时  
		function refer() {
			if (t == 0) {
				location = "<%=path%>/Login.jsp"; // 设定跳转的链接地址  
			}
			document.getElementById('show').innerHTML = "" + t
					+ "秒后自动返回登陆页面"; // 显示倒计时  
			t--; // 计数器递减  
		}
	</script>
	<div style="text-align:center;width:600px;height:400px;margin-left:auto;margin-right:auto;">
		<h3>登录失败,请检查用户名和密码!</h3>
		<a href="<%=path%>/Login.jsp">点击返回登陆页面</a>
		<br><span id="show"></span>
	</div>
</body>
</html>
