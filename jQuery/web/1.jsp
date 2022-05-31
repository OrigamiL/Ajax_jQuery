<%--
  Created by IntelliJ IDEA.
  User: zhezhi
  Date: 2022/5/31
  Time: 13:59
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@ page session="false" %>--%>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%
    session.setAttribute("data","12344");
%>
<%=session.getAttribute("data")%>
${pageContext.session.getAttribute("data")}
</body>
</html>
