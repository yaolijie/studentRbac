<%--
  Created by IntelliJ IDEA.
  User: lj
  Date: 2019/6/10
  Time: 22:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加机构</title>
</head>
<body>
<form action="/InsertServlet?t=insertOrgan" method="post">
    <table>
        <tr>
            <td>机构名称：</td>
            <td>
                <input type="text" name="organname">
            </td>
        </tr>
        <tr>
            <td>机构类型：</td>
            <td>
                <section id="">
                    <option value="" name="type" checked></option>
                    <option value="1" name="type">公司</option>
                    <option value="0" name="type">部门</option>
                </section>
            </td>
        </tr>
        <tr>
            <td>机构编码：</td>
            <td>
                <input type="text" name="code">
            </td>
        </tr>
        <tr>
            <td>机构地址：</td>
            <td>
                <input type="text" name="address">
            </td>
        </tr>
        <tr>
            <td>机构联系电话：</td>
            <td>
                <input type="text" name="phone">
            </td>
        </tr>
        <tr>
            <td>备注：</td>
            <td>
                <input type="text" name="remark">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="保存">
                <input type="reset" value="清空">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
