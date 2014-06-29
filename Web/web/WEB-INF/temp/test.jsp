<%@ taglib prefix="s" uri="/struts-tags" %>
<%--
  Created by IntelliJ IDEA.
  User: christ
  Date: 14-6-16
  Time: 下午6:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
    <s:action name="list-kind">
        abc<s:property value="list"/>
       123 <s:property value="#attr.msg"></s:property>

    </s:action>
<s:property value="list"/>
    <s:debug></s:debug>
    <s:property value="#attr.msg"></s:property>
</body>
</html>
