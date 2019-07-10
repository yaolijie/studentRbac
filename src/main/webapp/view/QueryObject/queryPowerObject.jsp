<%@ page import="com.rbac.studengrbac.model.Power" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    Power power=(Power)request.getAttribute("power");

%>
<div>
    <form action="<%=path%>/InsertServlet?t=insertPower" method="post">
        <table >
            <tr>
                <td>权限名称：</td>
                <td>
                    <input type="text" name="fullname" value="<%=power.getFullName()%>">
                </td>
            </tr>
            <tr>
                <td>权限简称：</td>
                <td>
                    <input type="text" name="name" value="<%=power.getName()%>">
                </td>
            </tr>
            <tr>
                <td>权限编码：</td>
                <td>
                    <input type="text" name="code" value="<%=power.getCode()%>">
                </td>
            </tr>
            <tr>
                <td>链接地址：</td>
                <td>
                    <input type="text" name="url" value="<%=power.getIntercepUrl()%>">
                </td>
            </tr>
            <tr>
                <td>权限类型：</td>
                <td>
                    <input type="text" name="url" value="<%=power.getType()%>">
                </td>
            </tr>
            <tr>
                <td colspan="2">
                    <input type="button"  onclick="back();" value="返回">
                </td>
            </tr>
        </table>
    </form>
</div>
<script type="text/javascript">
    function back() {
        window.history.back();
    }
</script>
