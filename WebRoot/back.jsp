<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
<base href="<%=basePath%>">
<title>后台管理页面</title>
<link rel="stylesheet" href="backresource/style1.css">
<script type="text/javascript" src="backresource/jquery.min.js"></script>
<script type="text/javascript" src="backresource/date.js"></script>
<script>
$(document).ready(function(){
	$("#one1,#one2,#one3,#one4,#one5").click(function(){
		$("#con_one_6").css("display","none");
		});
	$("#one0").click(function(){
		$("#con_one_6").css("display","block");
		});
	});
</script>
</head>

<body>
<div class="top"> <img class="logo" src="images/logo.png">
  <div class="tab1" id="tab1">
    <div class="menu">
      <ul class="nav">
        <li id="one0" onclick="setTab('one',6)"><a href="#"><img src="images/6.png">
          <p>回到首页</p>
          </a></li>
        <li  id="one1" onclick="setTab('one',1)"><a href="#"><img src="images/1.png">
          <p>商品管理</p>
          </a></li>
        <li id="one2" onclick="setTab('one',2)"><a href="#"><img src="images/2.png">
          <p>财务管理</p>
          </a></li>
<!--         <li id="one3" onclick="setTab('one',3)"><a href="#"><img src="images/4.png">
          <p>用户管理</p>
          </a></li> -->
        <li id="one4" onclick="setTab('one',4)"><a href="#"><img src="images/5.png">
          <p>用户管理</p>
          </a></li>
        <li id="one5" onclick="setTab('one',5)"><a href="#"><img src="images/3.png">
          <p>系统管理</p>
          </a></li>
      </ul>
    </div>
  </div>
</div>
<div class="content" id="con_one_6" style="display:block;">
  <div class="meduo">
    <div class="hyy">
      <p>欢迎页</p>
    </div>
  </div> 
</div>

<div class="content" id="con_one_1" style="display:none;">
<div class="left-column">
    <div class="service">
      <h5>商品管理</h5>
    </div>
    <div class="tab2" id="tab2">
      <dl class="call">
        <div class="medo">
          <dt>商品中心</dt>
          
          <dd id="column1" onclick="setTab('column',1)" ><a href="#">上传商品</a></dd>
<!--           <dd id="column2" onclick="setTab('column',2)"><a href="#">业务受理</a></dd>
          <dd id="column3" onclick="setTab('column',3)"><a href="#">业务结单</a></dd>
          <dd id="column4" onclick="setTab('column',4)"><a href="#">业务回访</a></dd>
          <dd id="column5" onclick="setTab('column',5)"><a href="#">业务分析</a></dd>
          <dd id="column6" onclick="setTab('column',6)"><a href="#">手机APP受理</a></dd> -->
        </div>
      </dl>
    </div>
  </div>

<div class="meduo">
  <div class="right-content" id="con_column_1">
    <div class="ck">
      <p><span>业务受理</span></p>
    </div>
    <div class="srxz">
      <p><span>姓名：</span>
        <input name="姓名" type="text">
        <span>住址：</span>
        <input name="电话" type="text">
        <span>电话：</span>
        <input type="tel">
      </p>
      <p><span>业务分类：</span>
        <select>
          <option>报修</option>
          <option>检测</option>
        </select>
        <span><span>紧急程度：</span>
        <select>
          <option>着急</option>
          <option>不着急</option>
        </select>
        </span></p>
      <p><span>业务种类：</span>
        <select>
          <option>预设业务</option>
        </select>
      </p>
      <p class="message">
        <textarea style="margin-left:75px;height:100px; width:500px; border:1px solid #c1c1c1; border-radius:5px; background-color:#f1f1f1;"></textarea>
      </p>
  
      <p><span>接待方式：</span>
        <select>
          <option>电话接待</option>
          <option>前台接待</option>
        </select>
      </p>
    </div>
    <p class="sub"><a href="#">派单</a></p>
  </div>
 <!--  <div class="right-content" id="con_column_2" style="display:none">
    <center>
      <span style="font-size:100px;"> 2</span>
    </center>
  </div>
  <div class="right-content" id="con_column_3" style="display:none">
    <center>
      <span style="font-size:100px;"> 3</span>
    </center>
  </div>
  <div class="right-content" id="con_column_4" style="display:none">
    <center>
      <span style="font-size:100px;"> 4</span>
    </center>
  </div>
  <div class="right-content" id="con_column_5" style="display:none">
    <center>
      <span style="font-size:100px;"> 5</span>
    </center>
  </div>
  <div class="right-content" id="con_column_6" style="display:none">
    <center>
      <span style="font-size:100px;"> 6</span>
    </center>
  </div> -->
</div>
</div>

<div class="content"id="con_one_2" style="display:none;">
  <div class="left-column">
    <div class="service">
      <h5>财务管理</h5>
    </div>
    <div class="tab3" id="tab3">
      <dl class="call">
        <div class="medo medo1">
          <dt>收费中心</dt>
          <dd id="colum1" onclick="setTab('colum',1)" ><a href="#">水费</a></dd>
<!--           <dd id="colum2" onclick="setTab('colum',2)"><a href="#">电费</a></dd>
          <dd id="colum3" onclick="setTab('colum',3)"><a href="#">燃气费</a></dd>
          <dd id="colum4" onclick="setTab('colum',4)"><a href="#">电视费</a></dd>
          <dd id="colum5" onclick="setTab('colum',5)"><a href="#">电梯费</a></dd>
          <dd id="colum6" onclick="setTab('colum',6)"><a href="#">卫生费</a></dd> -->
        </div>
      </dl>
    </div>
  </div>

<div class="meduo meduo1">
  <div class="right-content" id="con_colum_1">
    <center>
      <span style="font-size:100px;"> 7</span>
    </center>
  </div>
<!--   <div class="right-content" id="con_colum_2" style="display:none">
    <center>
      <span style="font-size:100px;"> 8</span>
    </center>
  </div>
  <div class="right-content" id="con_colum_3" style="display:none">
    <center>
      <span style="font-size:100px;"> 9</span>
    </center>
  </div>
  <div class="right-content" id="con_colum_4" style="display:none">
    <center>
      <span style="font-size:100px;"> 10</span>
    </center>
  </div>
  <div class="right-content" id="con_colum_5" style="display:none">
    <center>
      <span style="font-size:100px;">11</span>
    </center>
  </div>
  <div class="right-content" id="con_colum_6" style="display:none">
    <center>
      <span style="font-size:100px;">12</span>
    </center>
  </div> -->
</div>
</div>

<div class="content"id="con_one_4" style="display:none;">
  <div class="left-column">
    <div class="service">
      <h5>资源管理</h5>
    </div>
    <div class="tab5" id="tab5">
      <dl class="call">
        <div class="medo medo3">
          <dt>资源管理</dt>
          <dd id="colunm1" onclick="setTab('colunm',1)" ><a href="#">节约用水</a></dd>
          <dd id="colunm2" onclick="setTab('colunm',2)"><a href="#">节约用电</a></dd>
          <dd id="colunm3" onclick="setTab('colunm',3)"><a href="#">注意防水</a></dd>
          <dd id="colunm4" onclick="setTab('colunm',4)"><a href="#">注意防火</a></dd>
          <dd id="colunm5" onclick="setTab('colunm',5)"><a href="#">关紧门窗</a></dd>
          <dd id="colunm6" onclick="setTab('colunm',6)"><a href="#">务要扰民</a></dd>
        </div>
      </dl>
    </div>
  </div>
  <div class="meduo meduo3">
    <div class="right-content" id="con_colunm_1">
      <center>
        <span style="font-size:100px;"> 19</span>
      </center>
    </div>
    <div class="right-content" id="con_colunm_2" style="display:none">
      <center>
        <span style="font-size:100px;"> 20</span>
      </center>
    </div>
    <div class="right-content" id="con_colunm_3" style="display:none">
      <center>
        <span style="font-size:100px;"> 21</span>
      </center>
    </div>
    <div class="right-content" id="con_colunm_4" style="display:none">
      <center>
        <span style="font-size:100px;"> 22</span>
      </center>
    </div>
    <div class="right-content" id="con_colunm_5" style="display:none">
      <center>
        <span style="font-size:100px;">23</span>
      </center>
    </div>
    <div class="right-content" id="con_colunm_6" style="display:none">
      <center>
        <span style="font-size:100px;">24</span>
      </center>
    </div>
  </div>
</div>


<div class="content"id="con_one_5" style="display:none;">
  <div class="left-column">
    <div class="service">
      <h5>系统管理</h5>
    </div>
    <div class="tab6" id="tab6">
      <dl class="call">
        <div class="medo medo4">
          <dt>系统管理</dt>
          <dd id="colnm1" onclick="setTab('colnm',1)" ><a href="#">系统设置</a></dd>
          <dd id="colnm2" onclick="setTab('colnm',2)"><a href="#">内容设置</a></dd>
          <dd id="colnm3" onclick="setTab('colnm',3)"><a href="#">栏目设置</a></dd>
          <dd id="colnm4" onclick="setTab('colnm',4)"><a href="#">功能设置</a></dd>
          <dd id="colnm5" onclick="setTab('colnm',5)"><a href="#">页面管理</a></dd>
          <dd id="colnm6" onclick="setTab('colnm',6)"><a href="#">退出管理</a></dd>
        </div>
      </dl>
    </div>
  </div>
  <div class="meduo meduo4">
    <div class="right-content" id="con_colnm_1" style="display:none">
      <center>
        <span style="font-size:100px;"> 25</span>
      </center>
    </div>
    <div class="right-content" id="con_colnm_2" style="display:none">
      <center>
        <span style="font-size:100px;"> 26</span>
      </center>
    </div>
    <div class="right-content" id="con_colnm_3" style="display:none">
      <center>
        <span style="font-size:100px;"> 27</span>
      </center>
    </div>
    <div class="right-content" id="con_colnm_4" style="display:none">
      <center>
        <span style="font-size:100px;"> 28</span>
      </center>
    </div>
    <div class="right-content" id="con_colnm_5" style="display:none">
      <center>
        <span style="font-size:100px;">29</span>
      </center>
    </div>
    <div class="right-content" id="con_colnm_6" style="display:none">
      <center>
        <span style="font-size:100px;">30</span>
      </center>
    </div>
  </div>
</div>

</body>
</html>
