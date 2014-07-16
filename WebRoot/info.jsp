<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="error.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
.inforow{ font-size:18px;}
.inforow dt,.inforow dd{ padding:7px;}
</style>
</head>

<body>
<script src="bootstrap/js/jquery-2.0.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
<jsp:include page="include/header.jsp"></jsp:include>
<c:set var="s" value="${requestScope.shop}"></c:set>
<div class="container">
<div class="row inforow">
    	<h2>我的资料</h2>
        <dl class="well well-small dl-horizontal">
        	<dt>店名</dt><dd>${s.name}</dd>       
        	<dt>简介</dt><dd>${s.details} </dd>
        	<dt>关键字</dt><dd>${s.keywords} </dd>
        	<dt>其他信息</dt><dd>${s.others} </dd>
        	<dt>营业时间</dt><dd>${s.businessTime} </dd>
        	<dt>订餐电话1</dt><dd>${s.tel1} </dd>
        	<dt>订餐电话2</dt><dd>${s.tel2} </dd>
        	<dt>店面地址</dt><dd>${s.address} </dd>
        </dl>       
</div>
<div class="row">
	<span class="pull-right"><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#updateInfo">修改资料</button></span>
</div>
</div>
<!--<jsp:include page="updateInfo.jsp"></jsp:include>
--><jsp:include page="include/footer.jsp"></jsp:include>
</body>
</html>