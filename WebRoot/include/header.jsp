<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>header</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--if IE-->
	<script src="bootstrap/js/html5.js"></script>
<!--endif-->
<style type="text/css">
.logo{padding:10px 80px 0px 80px;}
.bg-orange{background-color:#ff4e00; }
.mynav{font-size:24px; margin-right:90px;}
.nav-color{
  color:#ffcc99 !important;
}
.exit{paddng-top:7px;}
.color{color:#ffb380 !important;}
</style>
</head>
<script src="bootstrap/js/jquery-2.0.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>

<body>
<!--logo-->
<div class="row logo bg-orange">
	<div class="span1 offset1">
		<img src="images/logo.png">
    </div>
	<div class="span6">
    	<h1><font color="#ffffff">外卖小助手卖家版</font></h1>
    </div><div class="span4"></div>
    <div class="span2 pull-right exit">  
    	<a class="color" href="info"><i class="icon-user icon-white"></i> ${sessionScope.user.restaurantName}</a>
    	<font>&nbsp;&nbsp;</font>
    	<!--<a href="#myModal" class="color" data-toggle="modal" data-target="#exit2" data-show="true">退出登录</a>-->
    	
    	
    	<!-- Button to trigger modal -->
<a href="#myModal" role="button" data-toggle="modal">退出登录</a>
 
<!-- Modal -->
<div id="myModal" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
  <div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
    <h3 id="myModalLabel">退出登录</h3>
  </div>
  <div class="modal-body">
    <p>确认要退出登录吗？</p>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">关闭</button>
    <button class="btn btn-primary" id="one" data-dismiss="modal" aria-hidden="true">确定</button>
    <script src="bootstrap/js/jquery-2.0.3.min.js"></script>
    <script type="text/javascript">
  $('#one').click(function(){
  		$.get('logout?userId=${sessionScope.user.userId}&restaurantName=${sessionScope.user.restaurantName}',function(data){
 			
  		},'json');
  		location.href="login.jsp";
	});
  
  
</script>
  </div>
</div>
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	    	<!-- 退出对话框 隐藏 --><!--
    	    	
    	    	
    	<div id="exit2" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">退出登录</h3>
    </div>
    <div class="modal-body">
        <p>确认要退出登录吗？</p>
    </div>
    <div class="modal-footer">
        <button class="btn " data-dismiss="modal">取消</button>
        <button class="btn btn-primary" data-dismiss="modal">退出</button>
    </div>
   </div>
   
   
   --><!-- 退出对话框 隐藏 -->
	</div> <!-- span -->     	
</div><!-- logo -->
<!--导航-->
<div class="row bg-orange">
	<ul class="nav nav-pills pull-right mynav">
    	<li><a class="nav-color" href="/Waimai">首页</a></li>
        <li><a  class="nav-color" href="menu">我的菜单</a></li>
        <li><a class="nav-color" href="add.jsp">增加菜品</a></li>
        <li><a class="nav-color" href="info">我的资料</a></li>
        <li><a class="nav-color" href="about.jsp">关于</a></li>
    </ul>
</div>
</body>
</html>