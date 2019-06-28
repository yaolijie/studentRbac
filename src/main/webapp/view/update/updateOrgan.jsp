<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
%>
<form action="<%=path%>/InsertServlet?t=insertOrgan" method="post">
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
                <select id="" name="type">
                    <option value=""></option>
                    <option value="1">公司</option>
                    <option value="0">部门</option>
                </select>
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
