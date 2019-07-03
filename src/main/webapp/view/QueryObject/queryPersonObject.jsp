<%@ page import="com.rbac.studengrbac.model.Person" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    Person person=(Person)request.getAttribute("person");
%>
<form id="insertPerson" action="<%=path%>/lendServlet?t=register" method="post">
    <table>
        <tr>
            <td>姓名 ：</td>
            <td>
                <input type="text" name="fullname" id="fullname" value="<%=person.getFullName()%>">
            </td>
        </tr>
        <tr>
            <td>用户名 ：</td>
            <td>
                <input type="text" name="personname" id="personname" value="<%=person.getPersonName()%>">
            </td>
            <td>出生日期：</td>
            <td>
                <input type="text" name="birth" value="<%=person.getBirth()%>">
            </td>
        </tr>
        <tr>
            <td>国籍 ：</td>
            <td>
                <input type="text" name="native" value="<%=person.getNative0()%>">
            </td>
            <td>证件号 ：</td>
            <td>
                <input type="text" name="personid" value="<%=person.getPersonId()%>">
            </td>
        </tr>
        <tr>
            <td>年龄 ：</td>
            <td>
                <input type="text" name="age" value="<%=person.getAge()%>">
            </td>
            <td>性别 ：</td>
            <td>
                <input type="text" name="sex" value="<%=person.getSex()%>">
            </td>
            <td>出生地 ：</td>
            <td>
                <input type="text" name="positionId" value="<%=person.getPositionId()%>">
            </td>
        </tr>
        <tr>
            <td>电子邮箱：</td>
            <td>
                <input type="text" name="emaill" id="emaill" value="<%=person.getEmaill()%>">
            </td>
        </tr>
        <tr>
            <td>所属单位 ：</td>
            <td>
                <input type="text" name="orgname" id="orgname" value="<%=person.getOrganName()%>" >
            </td>
            <td>职位 ：</td>
            <td>
                <input type="text" name="orgtype" id="orgtype" value="<%=person.getOrgType()%>">
            </td>
        </tr>
        <tr>
            <td>备注：</td>
            <td>
                <input type="text" name="remarks" id="remarks" value="<%=person.getRemarks()%>">
            </td>
        </tr>
    </table>
    <table>
        <tr>
            <td>
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
