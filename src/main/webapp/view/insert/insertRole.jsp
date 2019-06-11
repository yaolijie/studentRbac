<%--
  Created by IntelliJ IDEA.
  User: lj
  Date: 2019/6/10
  Time: 21:38
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加角色</title>
    <%
        String path=request.getContextPath();
    %>
</head>
<body>
<form id="roleForm" action="<%=path%>/InsertServlet?t=insertRole">
    <tale >
        <tr>
            <td>角色名:</td>
            <td>
                <input type="text" id="rolename" name="rolename">
            </td>
        </tr>
        <tr>
            <td>角色编码：</td>
            <td>
                <input  type="text" id="code" name="code">
            </td>
        </tr>
        <tr>
            <td>权限开始时间：</td>
            <td>
                <input type="date" id="stardate" name="stardate">
            </td>
        </tr>
        <tr>
            <td>权限结束时间：</td>
            <td>
                <input type="date" id="enddate" name="enddate">
            </td>
        </tr>
        <tr>
            <td>备注：</td>
            <td>
                <input type="text" id="remarks" name="remarks">
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="submit" value="添加">
                <input type="reset" value="重置">
            </td>
        </tr>
    </tale>
</form>
</body>
</html>
