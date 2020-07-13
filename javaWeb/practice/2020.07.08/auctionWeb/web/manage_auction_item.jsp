<%@ page import="club.banyuan.entity.AuctionItem" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>无标题文档</title>
<link href="css/common.css" rel="stylesheet" type="text/css" />
<link href="css/style.css" rel="stylesheet" type="text/css" />
    <script type="text/javascript" src="js/jquery.js"></script>
</head>

<body>
<div class="wrap">
<!-- main begin-->
  <div class="sale">
    <h1 class="lf">在线拍卖系统</h1>
    <div class="logout right"><a href="logout.do" title="注销">注销</a></div>
  </div>
  <div class="forms">
    <label for="name">名称</label>
    <input name="" type="text" class="nwinput" id="name"/>
    <label for="names">描述</label>
    <input name="" type="text" id="names" class="nwinput"/>
    <label for="time">开始时间</label>
    <input name="" type="text" id="time" class="nwinput"/>
    <label for="end-time">结束时间</label>
    <input name="" type="text" id="end-time" class="nwinput" />
    <label for="price">起拍价</label>
    <input name="" type="text" id="price" class="nwinput" />
    <input name="" type="button"  value="查询" class="spbg buttombg f14  sale-buttom"/>
    <input type="button"  value="发布" class="spbg buttombg f14  sale-buttom buttomb"/>
  </div>
  <div class="items">
      <ul class="rows even strong">
        <li>名称</li>
        <li class="list-wd">描述</li>
        <li>开始时间</li>
        <li>结束时间</li>
        <li>起拍价</li>
        <li class="borderno">操作</li>
      </ul>
      <%
          List<AuctionItem> list = (List<AuctionItem>) session.getAttribute("homePage");
          int i=0;
          for (AuctionItem a : list) {
              i=i+1;
      %>


      <ul class="<%
      if(i % 2 != 0){
        out.print("rows");}
      else{
        out.print("rows even");}
      %>">
        <li><a href="" title=""><%=a.getName()%></a></li>
        <li class="list-wd"><%=a.getDescription()%></li>
        <li><%=a.getStart_time()%></li>
        <li><%=a.getEnd_time()%></li>
        <li><%=a.getStarting_price()%></li>
        <li class="borderno red">
           <a href="changeAuctionItem.do?manage=change&id=<%=a.getId()%>" title="竞拍" onclick="dele();">修改</a>|
          <a href="changeAuctionItem.do?manage=delete&id=<%=a.getId()%>" title="竞拍" onclick="abc();">删除</a>
        </li>
      </ul>

      <%
          }
      %>

      <div class="page">
          <a href="#" title="">首页</a>
          <a href="#" title="">上一页</a>
          <a class="red">共<%=session.getAttribute("pageAllNum")%>页</a>
          <%
              int pageAllNum = Integer.parseInt(session.getAttribute("pageAllNum").toString());
//            int pageNowNum = Integer.parseInt(request.getAttribute("pageNowNum").toString());
              int j;
              if(pageAllNum <= 5){
                  j=pageAllNum;
              }else {
                  j=5;
              }
          %>

          <%
              for (int k = 1; k <= j ; k++) {
          %>
          <a href="auctionList.do?pageNowNum=<%=k%>" title=""><%=k%></a>
          <%
              }
          %>
          <a href="#" title="">下一页</a>
          <a href="#" title="">尾页</a>
      </div>
  </div>
    <input type="hidden" value="<%=request.getAttribute("response")%>" id="response"/>
  <script>
   function abc(){
	   
	   if(confirm("你真的确认要删除吗？请确认")){

		   return true;
		 }
		 else{
			 return false;
			 }

	   };
	   function dele(){
		   if(confirm("你真的确认要修改吗？请确认")){
			   return true;
			   }
			   else{
				   return false;
				   }
		   }

   $(function () {
     var response = $("#response").val();
     if("success"===response){
       alert("成功")
     }
     if("error"===response)
       alert("失败")
   });
  </script>
<!-- main end-->
</div>
</body>
</html>
