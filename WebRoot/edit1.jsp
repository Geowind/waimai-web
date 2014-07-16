<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
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
.myform{ margin-top:20px; list-style-type:none;}
</style>
<script src="bootstrap/js/jquery-2.0.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>

<body>


<!-- Modal -->
<div id="menuEdit" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="menuEditLabel" aria-hidden="false">
            <div class="modal-header">
              <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
              <!--菜单名字-->
              <h3 id="menuEditLabel">菜单-标题</h3>
            </div>
            <div class="modal-body">
            <!--内容-->
              <h4>菜名</h4>
              <img src="${requestScope.food.img}" class="photo" alt="300*300">
              <form>
              	<ul class="myform">
              	<li>名称：<input type="text" value="${requestScope.food.name}"></li>
                <li>价格：<input type="text" value="${requestScope.food.price}"></li>
                <li>类别：<input type="text" value="${requestScope.food.category}"></li>
                <li>描述：<input type="text" value="${requestScope.food.description}"></li>
                </ul>
              </form>
            </div>
            <div class="modal-footer">
              <button class="btn" data-dismiss="modal">取消</button>
              <button class="btn btn-primary" data-dismiss="modal">保存</button>
            </div>
</div>


</body>
</html>