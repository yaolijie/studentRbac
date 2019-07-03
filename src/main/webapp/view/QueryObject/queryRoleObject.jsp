<%@ page import="com.rbac.studengrbac.model.Role" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    Role role=(Role)request.getAttribute("role");
%>
<form id="roleForm" action="<%=path%>/InsertServlet?t=insertRole"  method="post">
    <tale >
        <tr>
            <td>角色中文名：</td>
            <td>
                <input type="text" name="fullname" value="<%=role.getName()%>">
            </td>
        </tr>
        <tr>
            <td>角色英文名:</td>
            <td>
                <input type="text" id="rolename" name="rolename" value="<%=role.getRoleName()%>">
            </td>
        </tr>
        <tr>
            <td>角色编码：</td>
            <td>
                <input  type="text" id="code" name="code" value="<%=role.getCode()%>">
            </td>
        </tr>
        <tr>
            <td>权限开始时间：</td>
            <td>
                <input type="date" id="stardate" name="stardate" value="<%=role.getStarDate()%>">
            </td>
        </tr>
        <tr>
            <td>权限结束时间：</td>
            <td>
                <input type="date" id="enddate" name="enddate" value="<%=role.getEndDate()%>">
            </td>
        </tr>
        <tr>
            <td>备注：</td>
            <td>
                <input type="text" id="remarks" name="remarks" value="<%=role.getRemarks()%>">
            </td>
        </tr>
        <tr>
            <td align="center" colspan="2">
                <input type="button" onclick="back();" value="返回">
            </td>
        </tr>
    </tale>
</form>
<script type="text/javascript">
    function back() {
        window.history.back();
    }
</script>
