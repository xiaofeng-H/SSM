<%--
  Created by IntelliJ IDEA.
  User: 001
  Date: 2021/3/4
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <title>Title</title>
    </head>
    <body>
        <h1>添加账户信息表单</h1>
        <form name="accountForm" action="${pageContext.request.contextPath}/account/save" method="post">
            账号名称:<input type="text" name="name"><br>
            账号金额:<input type="text" name="money"><br>
            <input type="submit" name="保存"><br>
        </form>
    </body>
</html>
