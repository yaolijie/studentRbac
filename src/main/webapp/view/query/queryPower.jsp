<%@ page import="java.util.List" %>
<%@ page import="com.rbac.studengrbac.model.Power" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
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
            <td>操作</td>
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
                <button onclick="queryObjectPower('<%=power.getId()%>','<%=power.getType()%>')">查看</button>
                <button onclick="updatePower('<%=power.getId()%>','<%=power.getType()%>')">修改</button>
                <button onclick="deletePow('<%=power.getId()%>','<%=power.getType()%>')">删除</button>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<script type="text/javascript">
    function deletePow(deleteid,type){
        $.ajax({
            url:'<%=path%>/DeleteServlet?t=deletePowern&deleteid='+deleteid+'&type='+type,
            method:'get'
        });
    }

    function updatePower(updateid,type){
        $.ajax({
            url:'<%=path%>/UpdateServlet?t=updatePower&updateid='+updateid+'&type='+type,
            method:'get'
        });
    }

    function queryObjectPower(queryid,type){
        $.ajax({
            url:'<%=path%>/QueryObjectServlet?t=queryPower&queryid='+queryid+'&type='+type,
            method:'get'
        });
    }

</script>