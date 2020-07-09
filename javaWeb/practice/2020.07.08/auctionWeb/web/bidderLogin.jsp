<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <script type="text/javascript" src="js/jquery.js"></script>
<title>竞拍系统注册</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />


</head>

<body>
<div class="wrap">
<!-- main begin-->
 <div class="main">
   <div class="sidebar">
     <p><img src="images/img1.jpg" width="443" height="314" alt="" /></p>
   </div>
   <div class="sidebarg">
     <script>
       $(function () {
         $("#registerButton").click(function() {
           window.location.href="bidderRegister.jsp"
         })
         $("#loginButton").click(function(){
           var username = $("#name").val();

           var password = $("#password").val();

           if (password === "" || username === ""){
             alert("用户名或密码不能为空！！！")
           }else{
             $("#submitFrom").submit();}
         });

       })

     </script>


     <form id="submitFrom" method="post" action="login.do">
    <div class="login">
      <dl>
        <dt class="blues">用户登陆</dt>
        <dd><label for="name">用户名：</label><input name="userName" type="text" class="inputh" value="" id="name"/><span id="errorName" style="color: red;line-height: 30px">${requestScope.errorUserName}</span></dd>
          <dd><label for="password">密 码：</label><input name="password" type="text" class="inputh" value="" id="password"/><span id="errorPassword" style="color: red;line-height: 30px">${requestScope.errorPassword}</span></dd>
        <dd>
           <label class="lf" for="passwords">验证码：</label>
           <input type="text" class="inputh inputs lf" value="验证码" id="passwords"/>
           <span class="wordp lf"><img src="images/img2.jpg" width="96" height="27" alt="" /></span>
           <span class="blues lf"><a href="" title="">看不清</a></span>
        </dd>
        <dd>
           <input name="cookie" type="checkbox" id="rem_u"  />
           <span for="rem_u">下次自动登录</span>
        </dd>
        <dd class="buttom">
           <input id="loginButton" name="" type="button" value="登 录" class="spbg buttombg f14 lf" />
           <input id="registerButton" name="" type="button" value="注 册" class="spbg buttombg f14 lf" />
           <span class="blues  lf"><a href="" title="">忘记密码?</a></span>
           <div class="cl"></div>
        </dd>
       
      </dl>
    </div>
    </form>
   </div>
  <div class="cl"></div>
 </div>
<!-- main end-->
 
<!-- footer begin-->
</div>
 <!--footer end-->
 
</div>
</body>
</html>
