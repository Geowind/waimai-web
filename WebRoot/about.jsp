<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>我的资料-外卖小助手卖家版</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--if IE-->
	<script src="bootstrap/js/html5.js"></script>
<!--endif-->
<style type="text/css">
.phone{ background-image:url("images/iPhone_tamplate.png"); width:283px; height:630px;}
.app{ width:242px; height:448px; margin-top:73px; margin-left:24px;}
.inforow{ font-size:18px;}
</style>
</head>

<body>
<script src="bootstrap/js/jquery-2.0.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<jsp:include page="include/header.jsp"></jsp:include>
<div class="container">
<div class="row">&nbsp;<br/></div>
<div class="row"><!---->
	<div class="span4">
    	<!--手机图片-->	
		<div class="phone"><div class="item"><img src="images/app_main.png" class="app"></div></div>
    </div>
    <div class="span1"></div>   
    <div class="span7">	
    	<!--文字介绍-->
        <h2>关于外卖小助手安卓版</h2><br/>
        <h4>外卖小助手：专注于为南华大学全校师生服务的外卖平台</h4>
        <ul class="unstyled">
        <li><h5>软件功能：</h5></li>
        <li><p> 查看学校旁边各大外卖店的信息，包括外卖店的菜单、电话、地址等基本信息。可以直接打电话订餐。</p></li>
        <li><p>用户可以按关键字搜索自己想吃的菜。比如搜“香干炒肉”，就会显示出所有外卖店的香干炒肉，可以按价格或收藏数排序。然后用户通过比较各个外卖店的“香干炒肉”最终选择最实惠的一家</p></li>
        <li><p>用户可以收藏自己喜欢的菜，方便下次订餐。还可以在收藏栏里取消收藏，或者一次性取消全部收藏。</p></li>
        <li><p>更多功能请看：<a href="#myvideo">视频介绍</a></p></li>
        <p>软件下载地址：<a href="http://www.wandoujia.com/apps/com.buight.takeout">http://www.wandoujia.com/apps/com.buight.takeout </a></p>
        <p>扫描二维码即可下载：<img src="images/qrcode.png" width="100px" height="100px"></p>
    </div>
</div>
<div class="row">&nbsp;<br/></div>
<div class="row inforow">
	<div class="span2"></div> 
    <div class="span8" id="myvideo"></div>
    	 <!--视频介绍-->    	
        <h4>"外卖小助手"介绍视频</h4><br/>
        <center><iframe class="img-polaroid" height=498 width=510 src="http://player.youku.com/embed/XNjM2NTQ1OTMy" frameborder=0 allowfullscreen></iframe></center>
        <p>视频地址：<a href="http://player.youku.com/player.php/sid/XNjM2NTQ1OTMy/v.swf">http://player.youku.com/player.php/sid/XNjM2NTQ1OTMy/v.swf </a></p> 
    <div class="span2"></div>      
</div>
<div class="row">
	   
</div>
<jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>