<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
	String basePath=request.getContextPath()+"/";//request.getContextPath()绝对地址的获取
	String Path = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+basePath+"/";
%>
<!DOCTYPE html>
<html>
<head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>校园二手物品交易登录</title>
    <link rel="shortcut icon" href="favicon.ico">
    <link href="<%=basePath %>css/bootstrap.min14ed.css" rel="stylesheet" type="text/css">
    <link href="<%=basePath %>css/font-awesome.min93e3.css" rel="stylesheet">
    <link href="<%=basePath %>css/animate.min.css" rel="stylesheet">
    <link href="<%=basePath %>css/style.min862f.css" rel="stylesheet">
    <script type="text/javascript">if(window.top !== window.self){ window.top.location = window.location;}</script>
	<script src="<%=basePath %>js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=basePath %>js/bootstrap.min.js?v=3.3.6"></script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
	<script src="<%=basePath %>js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript">
		function tijiao() {
			debugger;
			var uname=document.getElementById("uname").value;
			var pwd=document.getElementById("pwd").value;
			if(uname==null||uname==""){
				alert("用户名不能为空");
				return false;
			}
			if(pwd==null||pwd==""){
				alert("密码不能为空");
				return false;
			}
			$.ajax({
				   type: "POST",
				   url: "<%=basePath%>loginSvl",
				   data: "uname="+uname+"&pwd="+pwd,
				   success: function(msg){
				     if (msg==1) {
						window.location.href="<%=basePath%>main/main.jsp"
					}else if (msg==0) {
						alert("登陆失败，请重试")
					}else {
						window.location.href="<%=basePath%>erroe/msg.jsp"
					}
				   }
				});
		}
	</script>
</head>


<body class="gray-bg">

    <div class="middle-box text-center loginscreen  animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">HD</h1>

            </div>
            <h3>欢迎使用二手交易平台</h3>

            
               <div class="form-group">
                    <input type="text" class="form-control" placeholder="用户名" required name="uname" id="uname">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="密码" required name="pwd" id="pwd">
                </div>
                <button type="button" class="btn btn-primary block full-width m-b" onclick="tijiao()">登 录</button>
                <p class="text-muted text-center"> <a href="<%=basePath %>/registerSvl">注册一个新账号</a>
				<p class="text-muted text-center"><span>${msg}</span></p>
        </div>
    </div>
    
</body>

</html>
