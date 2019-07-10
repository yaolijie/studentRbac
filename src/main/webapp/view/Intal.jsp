<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>初始化数据库</title>
    <script type="text/javascript">
        function table(){
            $.ajax({
                url:'<%=path%>/CreateTableServlet?t=createTable',
                method:'get'
            })
        }
        function functionCreate(){
            $.ajax({
                url:'<%=path%>/CreateFunctionServlet',
                method:'post'
            })
        }
        function insertData(){
            $.ajax({
                url:'<%=path%>/CreateTableServlet?t=insertData',
                method:'get'
            })
        }
    </script>
</head>
<body>

<table>
    <tr>
        <td>
            <input type="button" onclick="table();" value="创建数据库表">
        </td>
    </tr>
    <tr>
        <td>
            <input type="button" onclick="functionCreate();" value="自定义函数">
        </td>
    </tr>
    <tr>
        <td>
            <input type="button" onclick="insertData();" value="初始化数据">
        </td>
    </tr>
</table>
</body>
</html>
