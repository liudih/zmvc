<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script src="//cdn.bootcss.com/jquery/3.0.0-beta1/jquery.js"></script>
</head>
<body>
<h2>${word0}${word1}***************</h2>

<p>
<#-- 使用FTL指令 --> 
<#if list?? >
<p>
长度：${list?size}
<p>
<#list list?sort_by("age")?reverse as user>
第${user_index+1}个用户
  用户名：${user.userName}
  密  码：${user.password}
  年  龄: ${user.age}
<br/>
</#list>
</#if>


<div id="a"> meeeeee== </div>
<script>
$("#a").hide();
$.ajax({
	url: "/zmvc/json",
	type: "get",
	dataType: "json",
	success: function(data){
	
	}
})
</script>
</body>
</html>