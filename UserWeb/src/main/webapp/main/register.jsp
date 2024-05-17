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
    <title>校园二手物品交易注册</title>
    <link rel="shortcut icon" href="favicon.ico"> 
    <link href="<%=basePath %>css/bootstrap.min14ed.css?v=3.3.6" rel="stylesheet">
    <link href="<%=basePath %>css/font-awesome.min93e3.css?v=4.4.0" rel="stylesheet">
    <link href="<%=basePath %>css/plugins/iCheck/custom.css" rel="stylesheet">
    <link href="<%=basePath %>css/animate.min.css" rel="stylesheet">
    <link href="<%=basePath %>css/style.min862f.css?v=4.1.0" rel="stylesheet">
    <script type="text/javascript">if(window.top !== window.self){ window.top.location = window.location;}</script>
	<script src="<%=basePath %>js/jquery-1.4.4.min.js"></script>
	<script type="text/javascript">
		function jiaoyan() {
			debugger;
			var uname=document.getElementById("uname").value;
			if (uname==null||uname.trim()=="") {
				alert("用户名不能为空");
				return false;
			}
			$.ajax({
				   type: "POST",
				   url: "<%=basePath%>jiaoyanSvl",
				   data: "uname="+uname,
				   success: function(msg){
					   var vs = "";
						if (msg == 0) {
							vs = "用户名已存在,请重新输入";
							document.getElementById("uname").value = "";
							document.getElementById("uname").focus();
						}else{
							vs = "用户名不存在，可以注册";
						}
						
						document.getElementById("tishi").innerHTML = vs;
				   }
				});
		}
	</script>
</head>

<body class="gray-bg">

    <div class="middle-box text-center loginscreen   animated fadeInDown">
        <div>
            <div>

                <h1 class="logo-name">HD</h1>

            </div>
            <h3>欢迎注册</h3>
            <p>创建一个新账户</p>
            <form class="m-t" role="form" action="<%=basePath%>registerSvl" method="post">
                <div class="form-group">
                    <input type="text" class="form-control" placeholder="请输入用户名" required="" name="uname" onblur="jiaoyan()" id="uname">
                </div>
                 <div class="form-group">
                    <span id="tishi"  class="form-control"></span>
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="请输入密码" required="" name="pwd" id="password" onblur="verification()">
                </div>
                <div class="form-group">
                    <input type="password" class="form-control" placeholder="请再次输入密码" required="" id="repassword" onblur="verification()">
                </div>
                <div class="form-group">
                	<label id="mmtishi"  class="form-control"></label>
                </div>
                <div class="form-group">
				   <select class="form-control" required="" name="role">
				   		  <option value="0" >请选择</option>
				   		  <option value="1" >管理员</option>
				   		  <option value="2" >用户</option>
				   </select>
				</div>
				<div class="form-group">
				    <input type="text" class="form-control" placeholder="请输入电话号" required="" name="tel">
				</div>
                <div class="form-group text-left">
                    <div class="checkbox i-checks">
                        <label class="no-padding">
                            <input type="checkbox"><i></i> 我同意注册协议</label>
                    </div>
                </div>
                <p class="text-muted text-center"><span>${sremsg}</span></p>
                <button type="submit" class="btn btn-primary block full-width m-b" id="button">注 册</button>

                <p class="text-muted text-center"><small>已经有账户了？</small><a href="<%=basePath %>/loginSvl">点此登录</a>
                </p>

            </form>
        </div>
    </div>
    <script src="<%=basePath %>js/jquery.min.js?v=2.1.4"></script>
    <script src="<%=basePath %>js/bootstrap.min.js?v=3.3.6"></script>
    <script src="<%=basePath %>js/plugins/iCheck/icheck.min.js"></script>
    <script src="<%=basePath %>js/jquery-1.4.4.min.js"></script>
    <script>
        $(document).ready(function(){$(".i-checks").iCheck({checkboxClass:"icheckbox_square-green",radioClass:"iradio_square-green",})});
        function verification() {
            var pw1 = document.getElementById("repassword").value;
            var pw2 = document.getElementById("password").value;
            if(pw1 == pw2) {
                document.getElementById("mmtishi").innerHTML="两次密码相同";
                document.getElementById("button").disabled = false;
            }
            else {
                document.getElementById("mmtishi").innerHTML="两次密码不相同";
                document.getElementById("button").disabled = true;
            }
        }
    </script>
    <script type="text/javascript" src="http://tajs.qq.com/stats?sId=9051096" charset="UTF-8"></script>
</body>
</html>
