<%@ page import="com.rbac.studengrbac.model.Role" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path=request.getContextPath();
    List<Role> list=(List)request.getAttribute("listRole");
    int size=(int)list.size();
%>
<div>
    <table>
        <thead>
        <tr>
            <th>角色名</th>
            <th>角色简称</th>
            <th>角色编码</th>
            <th>开始时间</th>
            <th>结束时间</th>
            <th>操作</th>
        </tr>
        </thead>
        <tbody>
        <%
            for(int i=0;i<size;i++){
                Role role=list.get(i);
        %>
        <tr>
            <td><%=role.getName()%></td>
             <td><%=role.getRoleName()%></td>
            <td><%=role.getCode()%></td>
            <td><%=role.getStarDate()%></td>
            <td><%=role.getEndDate()%></td>
            <td>
                <button onclick="">查看</button>
                <button>修改</button>
                <button onclick="deleteRole(<%=role.getId()%>)">删除</button>
            </td>
        </tr>
        <%
            }
        %>
        </tbody>
    </table>
</div>
<script type="text/javascript" src="https://code.jquery.com/jquery-3.3.1.min.js"></script>
<script>
    function deleteRole(id){

        $.ajax({
            url:'<%=path%>/DeleteServlet?t=deleteRole&&id='+id,
            method:'get',
            seccess:function (){
                alert("删除成功！")
            }
        });
    }
</script>