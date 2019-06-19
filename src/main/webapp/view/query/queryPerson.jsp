<%@ page import="com.rbac.studengrbac.model.Person" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    List<Person> list=(List<Person>) request.getAttribute("list");
    int size=(int) list.size();
%>
<div>
    <table>
        <thead>
        <tr>
            <th>姓名</th>
            <th>用户名</th>
            <th>国籍</th>
            <th>身份证号</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (int i=0;i<size;i++){
                Person person=list.get(i);
        %>
        <tr>
            <td><%=person.getFullName()%></td>
            <td><%=person.getPersonName()%></td>
            <td><%=person.getNative0()%></td>
            <td><%=person.getPersonId()%></td>
            <td>
                <button>查看</button>
                <button>修改</button>
                <button>删除</button>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
