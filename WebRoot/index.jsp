<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>首页-外卖小助手卖家版</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--if IE-->
	<script src="bootstrap/js/html5.js"></script>
<!--endif--><!--上右下左-->
<style type="text/css">
.row ul{font-size:24px; margin-right:90px;}
.row .carousel{margin-top:10px;}
</style>
<script src="bootstrap/js/jquery-2.0.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript">
$('.carousel').carousel()
$('.carousel').carousel('cycle')
</script>
</head>

<body bgcolor="#ffcc99">

<jsp:include page="include/header.jsp"></jsp:include>

<div class="container">
<!--图片轮播-->
<div class="row">
	<div id="myCarousel" class="carousel slide" data-interval="3000" data-ride="carousel">
    	<ol class="carousel-indicators">
   			<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
    		<li data-target="#myCarousel" data-slide-to="1"></li>
    		<li data-target="#myCarousel" data-slide-to="2"></li>
        	<li data-target="#myCarousel" data-slide-to="3"></li>
 		</ol>
    	<div class="carousel-inner">
        	<div class="item active">
            	<img  src="images/1.png" alt="图片无法显示" width="100%" height="100%" class="img-polaroid">
            	<div class="carousel-caption">
                	<p>&nbsp;</p>
                	<a href="menu.jsp"><font size="+2" color="#FFFFFF">我的菜单</font></a><p>&nbsp;</p>
                	<p><font color="#999999">点击这里可以查看我的菜单</font></p>
                </div>
            </div>
            <div class="item">
            	<img src="images/2.png" alt="图片无法显示" class="img-polaroid">
                <div class="carousel-caption">
                	<p>&nbsp;</p>
                	<a href="menu.jsp"><font size="+2" color="#FFFFFF">增加菜单</font></a><p>&nbsp;</p>
                	<p><font color="#999999">点击这里可以增加新的菜单</font></p>
                </div>
            </div>
            <div class="item">
            	<img src="images/3.png" alt="图片无法显示" class="img-polaroid">
                <div class="carousel-caption">
                	<p>&nbsp;</p>
                	<a href="menu.jsp"><font size="+2" color="#FFFFFF">我的资料</font></a><p>&nbsp;</p>
                	<p><font color="#999999">点击这里可以查看或修改商家资料</font></p>
                </div>
            </div>
            <div class="item">
            	<img src="images/4.jpg" alt="图片无法显示" class="img-polaroid">
                <div class="carousel-caption">
                	<p>&nbsp;</p>
                	<a href="menu.jsp"><font size="+2" color="#FFFFFF">关于</font></a><p>&nbsp;</p>
                	<p><font color="#999999">点击这里可以了解安卓版的外卖小助手</font></p>
                </div>
            </div>
        </div>
        <a class="carousel-control left" href="#myCarousel" data-slide="prev">&lsaquo;</a>
        <a class="carousel-control right" href="#myCarousel" data-slide="next">&rsaquo;</a>
    </div>
</div>
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>