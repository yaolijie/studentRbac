
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登陆系统</title>
    <%
        String path=request.getContextPath();
    %>
    <script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
    <script type="text/javascript">
        $(function () {
            $("#register").click(function () {
                $.ajax({
                    method:'get',
                    url:'<%=path%>/lendServlet?t=register'
                });
            });
        });
    </script>
</head>
<body>
<form action='<%=path%>/lendServlet?t=lend' method="get" style="align-items: center;">
    <table>
        <tr>
            <td>用户名 ：</td>
            <td>
                <input type="text" name="username" id="username">
            </td>
        </tr>
        <tr>
            <td>密码： </td>
            <td>
                <input type="text" name="passworld" id="passworld" >
            </td>
        </tr>
        <tr>
            <td>
                <input type="submit" value="登陆">
            </td>
            <td>
                <input type="button" value="注册" id="register">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
