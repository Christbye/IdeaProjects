<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: christ
  Date: 14-6-18
  Time: 下午11:13
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<s:action name="list-kind" executeResult="true">
    <s:param value="true" name="unUseJson"/>
</s:action>
</body>
</html>
