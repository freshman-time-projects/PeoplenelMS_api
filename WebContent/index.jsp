<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>激活成功</title>
<style type="text/css">
container: {
	padding: '80px 40px',
}

,
btn: {
	margin-right: '6px',
}

,
successDetail: {
	
}

,
successDetailHead: {
	position: 'relative',
}

,
img: {
	width: '40px', height: '40px',
}

,
title: {
	margin: 0,
}

,
summary: {
	margin-bottom: '40px', fontSize: '24px', color: '#666',
	
}

,
nextStep: {
	margin: '80px 0',
}
,
</style>
</head>
<body>
	<div class="success-detail" style="text-align: center">
		<div class="success-detail-head" style="">
			<img
				src="https://img.alicdn.com/tfs/TB1ya6gh0zJ8KJjSspkXXbF7VXa-156-156.png"
				style="" alt="" />
			<h1 class="title" style="">激活成功</h1>
		</div>
		<p class="summary" style="">您可以选择立即登录，或者查看项目信息</p>
		<div className="buttons" style="">
			<button type="normal" style="" onClick="location.href='http://localhost:8993/#login';">立即登录</button>
			<button type="primary" onClick="location.href='https://gitee.com/zzuisa';">查看更多</button>  
		</div>
	</div>
</body>
</html>