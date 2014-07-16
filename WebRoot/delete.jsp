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
</style>
<script src="bootstrap/js/jquery-2.0.3.min.js"></script>
<script src="bootstrap/js/bootstrap.min.js"></script>
</head>

<body>
<div id="menuDelete" class="modal hide fade" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="false">
    <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
        <h3 id="myModalLabel">确认删除</h3>
    </div>
    <div class="modal-body">
        <p>确认删除吗？</p>
    </div>
    <div class="modal-footer">
        <button class="btn btn-primary" data-dismiss="modal">取消</button>
        <button class="btn btn-danger" data-dismiss="modal">确认</button>
    </div>
</div>         

</body>
</html>