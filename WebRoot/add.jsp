<%@ page contentType="text/html; charset=utf-8" language="java"
	errorPage="error.jsp"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width,initial-scale=1.0">
		<title>增加菜单-外卖小助手卖家版</title>
		<link href="bootstrap/css/bootstrap.min.css" rel="stylesheet">
		<!--if IE-->
		<script src="bootstrap/js/html5.js"></script>
		<!--endif-->
		<style type="text/css">
.to-top {
	margin-top: 40px;
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
	
</script>
		<jsp:include page="include/header.jsp"></jsp:include>
		<div class="container">
			<div class="row to-top">
				<form action="add" method="post">
					<div class="span5">
						<img class="photo img-polaroid" alt="请选择一张图片">
						<input type="file">
					</div>
					<div class="span2"></div>
					<div class="span5">
						<ul class="unstyled">
							<li>
								名称：
								<input type="text" name="name">
							</li>
							<li>
								价格：
								<input type="text" name="price">
							</li>
							<li>
								类别：
								<select name="category">
									<option>
										炒菜
									</option>
									<option>
										炒饭
									</option>
									<option>
										盖浇饭
									</option>
									<option>
										披萨
									</option>
									<option>
										奶茶
									</option>
									<option>
										热饮
									</option>
									<option>
										饼
									</option>
								</select>
							</li>
							<li>
								描述：
								<input type="text" name="description">
							</li>
							<li>
								&nbsp;
							</li>
							<li>
								&nbsp;
							</li>
							<li>
								&nbsp;
							</li>
							<li>
								<button type="reset" class="btn">
									取消
								</button>
								<button type="submit" class="btn btn-primary">
									增加
								</button>
							</li>
						</ul>
					</div>
				</form>
			</div>
		</div>


		<jsp:include page="include/footer.jsp"></jsp:include>
	</body>
</html>
