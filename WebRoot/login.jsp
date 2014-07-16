<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>登录界面-外卖小助手卖家版</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--if IE-->
	<script src="bootstrap/js/html5.js"></script>
<!--endif-->
<style type="text/css">
body{ background-image:url(images/login_bg.jpg); background-size:cover; background-position:center;background-repeat:repeat-y;font-family:"微软雅黑"; color:#FFFFFF; font-size:30px;}
.bg1{margin-top:70px;}
.bg2{background-image:url(images/21.png); background-size:cover; background-position:center; padding-top:70px;padding-bottom:70px;margin-top:60px;}
a{text-decoration:none;}
a:hover{text-decoration:none}
</style>
</head>
<body>
<script src="bootstrap/js/jquery-2.0.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
function validate(){
	if(login.username.value=="")
	{	alert("用户名不能为空！");return;}
	if(login.password.value=="")
	{	alert("密码不能为空！");return;}
	return login.submit();	
}
</script>
<div class="container">
<!--标题-->
<div class="row">
	<div class="span7 offset2 bg1">	
		<center><h1>外卖小助手卖家版</h1></center>
	</div><div class="span3"></div>
</div>
<!--登录表单-->
<div class="row">
<div class="span7 offset2 bg2">	
	<form class="form-horizontal" name="login" action="login" method="post">
    	<div class="control-group">
        	<label class="control-label" for="username">用户名</label>
            <div class="controls">
            	<div class="input-prepend">
                <span class="add-on"><i class="icon-user"></i> </span>
            	<input type="text" name="username" placeholder="请输入用户名">
                </div>
            </div>
        </div>
        <div class="control-group">
        	<label class="control-label" for="password">密码</label>
            <div class="controls">
            	<div class="input-prepend">
                <span class="add-on"><i class="icon-lock"></i> </span>
            	<input type="password" name="password" placeholder="请输入密码">
                </div>
            </div>
        </div>
        <div class="control-group">
        	<label class="control-label" for="loginbtn">&nbsp;</label>
            <div class="controls">
            	<input class="btn btn-primary btn-large input-large span3"  id="loginbtn" value="登录" onClick="validate()">
            	<!--<a href="login" class="btn btn-primary btn-large input-large" id="loginbtn" onClick="validate()">登录</a>
            --></div>
        </div>
    </form>
</div><div class="span3"></div>
</div>


</div>
<!--页脚-->
<!--<div class="row bg1">
    <div class="container">
        <center><small style="font-size:16px">&copy;<a href="http://e.weibo.com/geowind?type=0">Geowind</a>南华大学经纬度团队版权所有</small></center>
	</div>
</div>
-->
<%@ include file="include/footer.jsp" %>
</body>
</html>
