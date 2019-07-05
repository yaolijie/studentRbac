<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div>
    <form action="<%=path%>/InsertServlet?t=insertPower" method="post">
        <table >
            <tr>
                <td>权限名称：</td>
                <td>
                    <input type="text" name="fullname">
                </td>
            </tr>
            <tr>
                <td>权限简称：</td>
                <td>
                    <input type="text" name="name">
                </td>
            </tr>
            <tr>
                <td>权限编码：</td>
                <td>
                    <input type="text" name="code">
                </td>
            </tr>
            <tr>
                <td>链接地址：</td>
                <td>
                    <input type="text" name="url">
                </td>
            </tr>
            <tr>
                <td>权限类型：</td>
                <td>
                    <select name="type">
                        <option value=""></option>
                        <option value="menu">菜单权限</option>
                        <option value="operation">操作权限</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="submit" value="保存">
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</div>
