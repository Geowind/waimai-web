<%@ page contentType="text/html; charset=utf-8" language="java" import="java.sql.*" errorPage="" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8">
<title>修改店家资料</title>
</head>

<body>
<!-- 资料修改对话框 -->
<div id="updateInfo" class="modal hide fade in" tabindex="-1" role="dialog" aria-labelledby="updateInfoLabel" aria-hidden="false">
  <div class="modal-header"> 
    <!--关闭按钮-->
    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
    <!--标题-->
    <h3 id="updateInfoLabel">修改资料</h3>
  </div>
  <c:set var="s" value="${requestScope.shop}"></c:set>
  <div class="modal-body"> 
    <!--内容-->
    <form>
      <dl class="dl-horizontal pull-left">
        <dt>店名</dt>
        <dd>
          <input type="text" value="${s.name}" placeholder="${s.name}" class="uneditable-input" disabled="disabled">
          <span class="help-inline"><span style="color:#F00">&lowast;</span>店面不能改</span>
        </dd>
        <dt>简介</dt>
        <dd>
          <input type="text" value="${s.details}" placeholder="${s.details}">
        </dd>
        <dt>关键字</dt>
        <dd>
          <input type="text" value="${s.keywords}" placeholder="${s.keywords}">
        </dd>
        <dt>其他信息</dt>
        <dd>
          <input type="text" value="${s.others}" placeholder="${s.others}">
        </dd>
        <dt>营业时间</dt>
        <dd>
          <input type="text" value="${s.businessTime}" placeholder="${s.businessTime}">
        </dd>
        <dt>订餐电话1</dt>
        <dd>
          <input type="text" value="${s.tel1}" placeholder="${s.tel1}">
        </dd>
        <dt>订餐电话2</dt>
        <dd>
          <input type="text" value="${s.tel2} " placeholder="${s.tel2}">
        </dd>
        <dt>店面地址</dt>
        <dd>
          <input type="text" value="${s.address}" placeholder="${s.address}">
        </dd>
      </dl>
    </form>
  </div>
  <div class="modal-footer">
    <button class="btn" data-dismiss="modal" aria-hidden="true">取消</button>
    <button class="btn btn-primary" data-dismiss="modal" aria-hidden="true">保存修改</button>
  </div>
</div>
</body>
</html>