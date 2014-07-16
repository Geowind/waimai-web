<%@ page contentType="text/html; charset=utf-8" language="java" errorPage="" %>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width,initial-scale=1.0">
<title>弹窗</title>
<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
<!--if IE-->
	<script src="bootstrap/js/html5.js"></script>
<!--endif-->
<style type="text/css">
body{font-family:"微软雅黑";}
.photo{ width:300px; height:300px;}
</style>
</head>

<body>


<!-- Modal -->
<div id="menuDetail" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="menuDetailLabel" aria-hidden="false">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              <!--菜单名字-->
              <h3 id="menuDetailLabel">菜单-标题</h3>
            </div>
            <div class="modal-body">
            <!--内容-->
              <img src="${requestScope.food.img}" class="photo pull-left" alt="300*300">
              <ul class="unstyled pull-left">
              <li><h4>名字:${requestScope.food.name}</h4></li>
              <li>价格:${requestScope.food.price}</li>
              <li>类别:${requestScope.food.category}</li>
              <li>描述:${requestScope.food.description}</li>
              </ul>
            </div>
            <div class="modal-footer">
              <button class="btn btn-primary" data-dismiss="modal">关闭</button>
            </div>
</div>


</body>
</html>