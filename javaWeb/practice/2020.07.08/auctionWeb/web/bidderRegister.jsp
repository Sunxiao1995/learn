<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
  <script type="text/javascript" src="js/jquery.js"></script>
  <script>
    $(function () {
      $("#registerButton").click(function() {
        var agree = $("#rem_u").val();
        var userName = $("#userName").val();
        var password = $("#password").val();
        var identityNum  = $("#identityNum").val();
        var phoneNum = $("#phoneNum").val();
        if(!$("#rem_u").prop('checked')){
          alert("请同意《服务条款》");
        }
        else {
          if(password === "" || userName === "" || identityNum ==="" || phoneNum === ""){
            alert("必填项不能为空！！！")
        }else {
            $("#registerForm").submit();
          }
          }
      });
      })
  </script>
  <script>
    $(function() {

      $("#userName").blur(function() {
        var userName = $("#userName").val();
        $("#tdUserName span").remove();
        if(userName !== ""){
          var reg = /.{6,}/;
          if(!reg.test(userName)){
            $("#tdUserName").html("<span>用户名要求不低于6个字符</span>");
            return;
          }
          $.get("validateRegister.do", "userName="+userName, callBack);
          //响应成功时的回调函数
          function callBack(data) {
            if(data === "false"){
              $("#tdUserName").html("<span>用户名已经被注册</span>");
            }
          }
        }
      });

      $("#password").blur(function () {
        var password = $("#password").val();
        $("#tdPassWord span").remove();
        if(password !== ""){
          var reg = /.{6,}/;
          if(!reg.test(password)){
            $("#tdPassWord").html("<span>密码要求不低于6个字符</span>");
          }
        }
      })

      $("#identityNum").blur(function () {
        var identityNum = $("#identityNum").val();
        $("#tdIdentityNum span").remove();
        if(identityNum === ""){
            $("#tdIdentityNum").html("<span>身份证不能为空</span>");
        }
      })

      $("#phoneNum").blur(function () {
        var identityNum = $("#phoneNum").val();
        $("#tdPhoneNum span").remove();
        if(identityNum === ""){

          $("#tdPhoneNum").html("<span>手机号不能为空</span>");
        }
      })
    });
  </script>

</head>

<body>
<div class="wrap">
  <!-- main begin-->
      <div class="zclf login logns">
        <h1  class="blue">用户注册</h1>
        <form action="register.do" id="registerForm" method="post">
          <dl>
            <dd>
              <label> <small>*</small>用户名</label>
              <input type="text" class="inputh lf" value="" name="userName" id="userName"/>
              <div id="tdUserName" class="lf red laba"><span></span></div>
            </dd>
            <dd>
              <label> <small>*</small>密码</label>
              <input type="password" class="inputh lf" value="" name="password" id="password" />
              <div id="tdPassWord" class="lf red laba"><span></span></div>
            </dd>
            <dd>
              <label> <small>*</small>身份证号</label>
              <input type="text" class="inputh lf" value="" name="identityNum" id="identityNum"/>
              <div id="tdIdentityNum" class="lf red laba"><span></span></div>
            </dd>
            <dd>
              <label> <small>*</small>电话</label>
              <input type="text" class="inputh lf" value="" name="phoneNum" id="phoneNum" />
              <div id="tdPhoneNum" class="lf red laba"><span></span></div>
            </dd>
            <dd>
              <label> <small>*</small>住址</label>
              <input type="text" class="inputh lf" value="" name="address" id="address"/>
            </dd>
            <dd>
              <label> <small>*</small>邮政编码</label>
              <input type="text" class="inputh lf" value="" name="postalCode" id="postalCode"/>
            </dd>
            <dd class="hegas">
              <label> <small>*</small>验证码</label>
              <input type="text" class="inputh inputs lf" />
               <span class="wordp lf"><img src="images/img2.jpg" width="96" height="27" alt="" /></span>
               <span class="blues lf"><a href="" title="">看不清</a></span>
            </dd>
            <dd class="hegas">
              <label>&nbsp;</label>
               <input name=""  type="checkbox" id="rem_u"/>
              <label for="rem_u" class="labels">我同意<span class="blues">《服务条款》</span></label>
            </dd>
            <dd class="hegas">
              <label>&nbsp;</label>
              <input name="" type="button" value="立即注册" class="spbg buttombg buttombgs f14 lf" id="registerButton" />
            </dd>
          </dl>
        </form>
    </div>
<!-- main end-->
<!-- footer begin-->

</div>
 <!--footer end-->
 
</div>
</body>
</html>
