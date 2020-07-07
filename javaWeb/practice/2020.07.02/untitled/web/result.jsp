<%--
  Created by IntelliJ IDEA.
  User: edz
  Date: 2020/7/3
  Time: 2:17 下午
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%=request.getAttribute("reqAttr")%>
<br/>
<%=session.getAttribute("sessionAttr")%>
<br/>
<%=session.getAttribute("sessionAttr2")%>

${ sessionScope.sessionAttr}

</body>
</html>
