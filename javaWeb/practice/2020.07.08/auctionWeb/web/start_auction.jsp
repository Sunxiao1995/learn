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
  <div class="items sg-font lf">
      <ul class="rows">
        <li>名称：</li>
        <li class="borderno">${sessionScope.startAuction.name}</li>
      </ul>
      <ul class="rows">
        <li>描述：</li>
        <li class="borderno">${sessionScope.startAuction.description}</li>
      </ul>
      <ul class="rows">
        <li>开始时间：</li>
        <li class="borderno">${sessionScope.startAuction.start_time}</li>
      </ul>
      <ul class="rows">
        <li>结束时间：</li>
        <li class="borderno">${sessionScope.startAuction.end_time}</li>
      </ul>
      <ul class="rows border-no">
        <li>起拍价：</li>
        <li class="borderno">${sessionScope.startAuction.starting_price}</li>
      </ul>
  </div>
  <div class="rg borders"><img src="images/ad20.jpg" width="270" height="185" alt="" /></div>
  <div class="cl"></div>
  <div class="top10 salebd">
       <p>
       <label for="sale">出价：</label>
       <input type="text"  class="inputwd" id="sale" value=""/>
       <input name="" id="auction" type="button" value="竞 拍" class="spbg buttombg f14  sale-buttom" />
       </p>
       <p id="response" class="f14 red"></p>
  </div>
  <div class="top10">
    <input name="" id="refresh" type="button" value="刷 新" class="spbg buttombg f14" />
    <input name="" id="return" type="button" value="返回列表" class="spbg buttombg f14" />
  </div>
  <div class="offer">
    <h3>出价记录</h3>
    <div id="priceRecord" class="items sg-font">

  </div>
  </div>
<!-- main end-->
</div>
<script>
  $(function() {
    $("#refresh").click(function() {
      $("#priceRecord ul").remove();
      $.get("bids.do", "auctionItem_id="+${sessionScope.startAuction.id}, callBack);
       function callBack(data) {

         $("#priceRecord").append("<ul class=\"rows even strong\">\n"
             + "        <li>竞拍时间</li>\n"
             + "        <li>竞拍价格</li>\n"
             + "        <li class=\"borderno\">竞拍人</li>\n"
             + "      </ul>")
         var arr = eval(data);
         for (var i = 0;i<arr.length;i++){
           var j = i%2;
           if(j===0) {
             $("#priceRecord").append("<ul class='rows'>\n"
                 + "        <li>" + arr[i].time + "</li>\n"
                 + "        <li>" + arr[i].price + "</li>\n"
                 + "        <li class='borderno'>" + arr[i].userName + "</li>\n"
                 + "      </ul>")
           }else {
             $("#priceRecord").append("<ul class='rows even'>\n"
                 + "        <li>" + arr[i].time + "</li>\n"
                 + "        <li>" + arr[i].price + "</li>\n"
                 + "        <li class='borderno'>" + arr[i].userName + "</li>\n"
                 + "      </ul>")
           }
         }


       }
  });

  });

  $(function() {
    $("#return").click(function () {
      window.location.href="auctionItem_list.jsp";

    });
  });

  $(function() {
    $("#auction").click(function () {
      $("#response span").remove();
      $.get("auction.do", "priceNow="+$("#sale").val(), callBack2);
      function callBack2(data2) {
        var response = data2
         $("#response").append("<span>"+response+"</span>")
      }
    })

  });


  setInterval(function () {

    $("#priceRecord ul").remove();
    $.get("bids.do", "auctionItem_id="+${sessionScope.startAuction.id}, callBack);
    function callBack(data) {

      $("#priceRecord").append("<ul class=\"rows even strong\">\n"
          + "        <li>竞拍时间</li>\n"
          + "        <li>竞拍价格</li>\n"
          + "        <li class=\"borderno\">竞拍人</li>\n"
          + "      </ul>")
      var arr = eval(data);
      for (var i = 0;i<arr.length;i++){
        var j = i%2;
        if(j===0) {
          $("#priceRecord").append("<ul class='rows'>\n"
              + "        <li>" + arr[i].time + "</li>\n"
              + "        <li>" + arr[i].price + "</li>\n"
              + "        <li class='borderno'>" + arr[i].userName + "</li>\n"
              + "      </ul>")
        }else {
          $("#priceRecord").append("<ul class='rows even'>\n"
              + "        <li>" + arr[i].time + "</li>\n"
              + "        <li>" + arr[i].price + "</li>\n"
              + "        <li class='borderno'>" + arr[i].userName + "</li>\n"
              + "      </ul>")
        }
      }


    }



  },10000);

</script>



</body>
</html>
