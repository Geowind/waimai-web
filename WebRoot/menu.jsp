<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<title>我的菜单-外卖小助手卖家版</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<!--if IE-->
		<script src="bootstrap/js/html5.js"></script>
		<!--endif-->
		<style type="text/css">
body {
	font-family: "微软雅黑";
}

.to-top {
	margin-top: 40px;
}

.nav-plus {
	font-size: 24px;
}

.photo {
	width: 300px;
	height: 300px;
}
</style>
	</head>
	<body>
		<script src="bootstrap/js/jquery-2.0.3.min.js"></script>
		<script src="bootstrap/js/bootstrap.min.js"></script>
		<script type="text/javascript">
	var index;
	$('#menuDetail').modal('show');
</script>
		<script>
	function changeIndex(e) {
		Indicator = e.getAttribute("name");
	}
</script>

		<jsp:include page="include/header.jsp"></jsp:include>

		<div class="container">
			<div class="row to-top">
				<ul class="thumbnails">
					<!--菜单-->
					<c:forEach items="${requestScope.list}" var="food"
						varStatus="status">
						<li class="span4" name="${status.index}"
							onmouseover=
	changeIndex(this);
>
							<a href="edit?foodId=${food.foodId }" target="_blak"
								class="thumbnail"><img src="${food.img }"
									data-src="holder.js/320x320" alt="320x320"
									style="width: 320px; height: 320px;"> </a>

							<div class="caption">
								<p>
									<strong style="margin-left:8px;">
										${food.name } 
									</strong>
									<strong style="margin-right:8px;" class="pull-right">
										${food.price }￥
									</strong>
								</p>
								<!--<form action="edit?foodId=${food.foodId}" method="get">
									-->
									<a href="edit?foodId=${food.foodId}"  class="btn btn-primary "
										>
										详情
									</a>
									<!--
									<button type="button" class="btn btn-primary disabled"
										disabled="disabled" data-toggle="modal"
										data-target="#menuEdit" data-show="true">
										修改
									</button>
									<button type="button" class="btn btn-primary disabled"
										disabled="disabled" data-toggle="modal"
										data-target="#menuDelete" data-show="true">
										删除
									</button>
								--><!--
								</form>
								--></p>
							</div>

						</li>
					</c:forEach>
				</ul>
			</div>
		</div>
		<!-- Modal -->
		<div id="menuDetail" class="modal hide fade" tabindex="-1"
			role="dialog" aria-labelledby="menuDetailLabel" aria-hidden="false">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal"
					aria-hidden="true">
					&times;
				</button>
				<!--菜单名字-->
				<h3 id="menuDetailLabel">
					菜单-标题
				</h3>
			</div>
			<div class="modal-body">
				<!--内容-->
				<img src="${requestScope.list[0].img}" class="photo pull-left"
					alt="300*300">
				<ul class="unstyled pull-left">
					<li>
						<h4>
							名字:${requestScope.list[0].name}
						</h4>
					</li>
					<li>
						价格:${requestScope.list[0].price}
					</li>
					<li>
						类别:${requestScope.list[0].category}
					</li>
					<li>
						描述:${requestScope.list[0].description}
					</li>
				</ul>
			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" data-dismiss="modal">
					关闭
				</button>
			</div>
		</div>
		<!-- 引用JSP文件 -->
		<jsp:include page="delete.jsp"></jsp:include>
		<jsp:include page="include/footer.jsp"></jsp:include>
	</body>
</html>
