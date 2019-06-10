<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>用户注册</title>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <%
        String path=request.getContextPath();
    %>
</head>
<body>
    <form id="insertPerson" action="<%=path%>/lendServlet?t=register" method="post">
        <table>
            <tr>
                <td>姓名 ：</td>
                <td>
                    <input type="text" name="fullname" id="fullname">
                </td>
            </tr>
            <tr>
                <td>用户名 ：</td>
                <td>
                    <input type="text" name="personname" id="personname">
                </td>
                <td>出生日期：</td>
                <td>
                    <input type="text" name="birth">
                </td>
            </tr>
            <tr>
                <td>国籍 ：</td>
                <td>
                    <input type="text" name="">
                </td>
                <td>证件号 ：</td>
                <td>
                    <input type="text" name="personid">
                </td>
            </tr>
            <tr>
                <td>年龄 ：</td>
                <td>
                    <input type="text" name="age">
                </td>
                <td>性别 ：</td>
                <td>
                    <input type="text" name="sex">
                </td>
                <td>出生地 ：</td>
                <td>
                    <input type="text" name="positionId">
                </td>
            </tr>
            <tr>
                <td>电子邮箱：</td>
                <td>
                    <input type="text" name="emaill" id="emaill">
                </td>
            </tr>
            <tr>
                <td>所属单位 ：</td>
                <td>
                    <input type="text" name="orgname" id="orgname">
                </td>
                <td>职位 ：</td>
                <td>
                    <input type="text" name="orgtype" id="orgtype">
                </td>
            </tr>
            <tr>
                <td>密码 ：</td>
                <td>
                    <input type="password" name="passworld" id="passworld">
                </td>
                <td>确认密码： </td>
                <td>
                    <input type="password" name="qpassworld" id="qpassworld">
                </td>
            </tr>
            <tr>
                <td>备注：</td>
                <td>
                    <input type="text" name="remarks" id="remarks">
                </td>
            </tr>
        </table>
        <table>
            <tr>
                <td>
                    <input type="submit" id="submit" value="提交">
                </td>
                <td>
                    <input type="reset" value="重置">
                </td>
            </tr>
        </table>
    </form>
</body>
<script type="text/javascript">
    $(function () {

        <%--$("#submit").click(function () {--%>
            <%--var passworld=$("#passworld").val();--%>
            <%--var qpassworld=$("#qpassworld").val();--%>
            <%--if (passworld==qpassworld){--%>
                <%--$.ajax({--%>
                    <%--url:'<%=path%>/lendServlet?t=register',--%>
                    <%--method:'post'--%>
                <%--});--%>
            <%--}else{--%>
                <%--alert("两次密码输入不一致！！");--%>
            <%--}--%>
        <%--});--%>
    });
</script>
</html>
