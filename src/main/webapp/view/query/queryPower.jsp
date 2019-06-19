<%@ page import="java.util.List" %>
<%@ page import="com.rbac.studengrbac.model.Power" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    List<Power> list=(List)request.getAttribute("listPower");
    int size=list.size();
%>
<div>
    <table>
        <thead>
        <tr>
            <th>权限名称</th>
            <th>权限简称</th>
            <th>权限编码</th>
            <th>权限类型</th>
        </tr>
        </thead>
        <tbody>
        <%
            for (int i=0;i<size;i++){
                Power power=list.get(i);
        %>
        <tr>
            <td><%=power.getFullName()%></td>
            <td><%=power.getName()%></td>
            <td><%=power.getCode()%></td>
            <td><%=power.getType()%></td>
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