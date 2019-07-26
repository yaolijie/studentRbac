<%@ page import="java.util.List" %>
<%@ page import="com.rbac.studengrbac.model.Person" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="com.rbac.studengrbac.model.Role" %>
<%@ page import="com.rbac.studengrbac.model.Power" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    List<Person> persons=(ArrayList)request.getAttribute("persons");
    int psize=persons.size();
    List<Role> roles=(ArrayList)request.getAttribute("roles");
    int rsize=roles.size();
%>
<div style="height: 60%;width:60%;" align="center">
    <div id="personDiv" style="float: left">
        <table id="persontable">
            <thead>
            <th></th>
            <th>用户名</th>
            </thead>
            <tbody>
            <%
                for (int i=0;i<psize;i++){
                    Person person=persons.get(i);
            %>
                    <tr>
                        <td>
                            <input type="radio" name="personid" value="<%=person.getId()%>">
                        </td>
                        <td>
                            <input type="text" value="<%=person.getFullName()%>">
                        </td>
                    </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
    <div id="button" >
        <button  onclick="allocationRole()">分配权限</button>
    </div>
    <div id="roleDiv" style="float: right">
        <table id="roletable">
            <thead>
            <tr>
                <th></th>
                <th>角色名</th>
                <th>角色简称</th>
            </tr>
            </thead>
            <tbody>
            <%
                for (int i=0;i<rsize;i++){
                    Role role=roles.get(i);
            %>
                <tr>
                    <td>
                        <input type="checkbox" name="roleid" value="<%=role.getId()%>">
                    </td>
                    <td>
                        <input type="text" value="<%=role.getName()%>">
                    </td>
                    <td>
                        <input type="text" value="<%=role.getRoleName()%>">
                    </td>
                </tr>
            <%
                }
            %>
            </tbody>
        </table>
    </div>
</div>
<script type="application/javascript">
    function allocationRole(){
        var roleid=[];
        var personid=$("input[name=personid]:checked").val();
        $("input[name=roleid]:checked").each(function () {
            roleid.push($(this).val());
        });
        alert("roleid"+roleid+"\n"+"personid"+personid);

        $.ajax({
           url:'<%=path%>/AllocationServlet?t=allocationRole',
           method:'post',
            data:{
                roleid:roleid.toString(),
                personid:personid
            },
           success:function (data) {
               alert(data);
           }
        });
    }
</script>

