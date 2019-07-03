<%@ page import="com.rbac.studengrbac.model.Organ" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    Organ organ=(Organ)request.getAttribute("organ");
%>
<form action="<%=path%>/InsertServlet?t=insertOrgan" method="post">
    <table>
        <tr>
            <td>机构名称：</td>
            <td>
                <input type="text" name="organname" value="<%=organ.getOrganName()%>">
            </td>
        </tr>
        <tr>
            <td>机构类型：</td>
            <td>
                <input type="text" name="organname" value="<%=organ.getType()%>">
            </td>
        </tr>
        <tr>
            <td>机构编码：</td>
            <td>
                <input type="text" name="code" value="<%=organ.getCode()%>">
            </td>
        </tr>
        <tr>
            <td>机构地址：</td>
            <td>
                <input type="text" name="address" value="<%=organ.getAddress()%>">
            </td>
        </tr>
        <tr>
            <td>机构联系电话：</td>
            <td>
                <input type="text" name="phone" value="<%=organ.getPhone()%>">
            </td>
        </tr>
        <tr>
            <td>备注：</td>
            <td>
                <input type="text" name="remark" value="<%=organ.getRemark()%>">
            </td>
        </tr>
        <tr>
            <td colspan="2">
                <input type="submit" name="保存">
                <input type="button" onclick="back();" value="返回">
            </td>
        </tr>
    </table>
</form>
<script type="text/javascript">
    function back() {
        window.history.back();
    }
</script>