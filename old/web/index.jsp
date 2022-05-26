<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>old请求</title>
  </head>

  <body>
  <script type="text/javascript">
    /*该种声明方式需要在调用之前
    function sendRequest(){}则调用可以写在声明之前*/
    sendRequest = function (){
      document.location.href = "/old/request"
    }

  </script>
  <a href=${pageContext.request.contextPath}"/request">超链接</a>
  <br>
  <form action=${pageContext.request.contextPath}"/request">
    <input type="submit" value="提交"/>
  </form>
  <input type="button" onclick="sendRequest()" value="JS代码发送请求" />

  </body>
</html>
