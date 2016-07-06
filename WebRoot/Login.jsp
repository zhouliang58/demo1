<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>登陆页面</title>
    
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<link rel="stylesheet" type="text/css" href="css/Login.css">
	<script type="text/javascript" src="js/jquery-1.10.1.js"></script>

  </head>
  
  <body>
<!-- 验证 -->
<script> 
function login() {  
    var userName = $("#username").val();  
    var userPass = $("#password").val();  
    if (userName == "" || userName == null) {  
        alert("用户名不能为空");  
        return false;  
    } else if (userPass == "" || userPass == null) {  
        alert("密码不能为空");  
        return false;  
    } else {  
        return true;  
    }  
} 

function register(){
	var userName = $("#registername").val();  
    var userPass = $("#registerpass").val(); 
    var userPass1 = $("#password1").val(); 
    var contact = $("#contact").val();
    var address = $("#address").val();
    var pattern=/(^(([0\+]\d{2,3}-)?(0\d{2,3})-)(\d{7,8})(-(\d{3,}))?$)|(^0{0,1}1[3|4|5|6|7|8|9][0-9]{9}$)/;
    
    if (userName == "" || userName == null) {  
        alert("用户名不能为空");  
        return false;  
    } else if (userPass == "" || userPass == null) {  
        alert("密码不能为空");  
        return false;  
    } else if(userPass!=userPass1){
    	alert("两次密码输入不一致");  
        return false;
    }else if(address =="" || address ==null){
   		alert("地址不能为空");  
        return false; 
    }else if(!new RegExp(pattern).test(contact)){
    	alert("请输入正确的手机号码");  
        return false;
    }else {  
        return true;  
    }  
}

</script>  
<!-- 验证 -->
<script language="javascript">
function TestBlack(TagName){
 var target=document.getElementById(TagName);
 target.style.visibility="visible";
}
function reloadCode(){
	var time = new Date().getTime();
	document.getElementById("imagecode").src="<%=request.getContextPath() %>/servlet/ImageServlet?d="+time;
}

</script>
<!-- 下面是注册表单 -->
 <!-- 左上模块 -->
<form action="<%=request.getContextPath()%>/servlet/registerServlet" method="post" onsubmit="return register();">
    <div id="loginform">
	  	<div id="facebook">
			<strong>注册新用户</strong>
			
			<div id="connect">
				    <input type="text"  placeholder="用户名"  name="username" id="registername" >
					<input type="password"  placeholder="密码"  name="password" id="registerpass" >	
			</div>
			      <div  id="note"><a onclick="TestBlack('hidelogin');" >&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp完善信息</a>
				  </div> 
		</div>
	</div>

<!-- 左下隐藏模块 -->
<div id="hidelogin">
  <div id="and">and</div>
     <br>
    <input type="password" placeholder="确认密码"  name="password1" id="password1" >
	<input type="text" placeholder="地址"  name="address" id="address" >
	<input type="text" placeholder="手机号码"  name="contact"  id="contact">
	<input type="text" placeholder="验证码"  name="checkcode" >
	&nbsp&nbsp<img alt="验证码" id="imagecode" align="top" src="<%=request.getContextPath() %>/servlet/ImageServlet"/>
    		<a id="note" href="javascript: reloadCode();">看不清楚</a><br>	
	<br><br>
	<button id="newbutton" type="submit"><i class="fa fa-arrow-right"></i></button>	
</div>	
</form>
<!-- 上面是注册表单 -->
<!-- --------------------------------------------------------------------------- -->

<!-- 登陆模块 -->
<div id="mainlogin">	
	<div id="or">or</div>
	<h1>用户登录</h1>
	<form action="<%=request.getContextPath()%>/servlet/LoginServlet" method="post" onsubmit="return login();">
		<input type="text" placeholder="用户名" value=""  name="username" id="username">
		<input type="password" placeholder="密码" value="" name="password" id="password">
		<button type="submit"><i class="fa fa-arrow-right"></i></button>
    </form>
	 <div id="note"><a href="#">&nbsp&nbsp&nbsp&nbsp忘记密码?</a></div>
</div>



  </body>
</html>