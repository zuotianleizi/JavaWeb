
<%--
  Created by IntelliJ IDEA.
  User: 15420
  Date: 2020/3/11
  Time: 15:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
    <script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js"></script>
    <title>用户信息</title>
</head>
<body>


<table class="table">
    <thead>
    <tr>
        <th scope="col">#</th>
        <th scope="col">姓名</th>
        <th scope="col">生日</th>
        <th scope="col">性别</th>
        <th scope="col">手机</th>
        <th scope="col">职业</th>
        <th scope="col">备注</th>
        <th scope="col">操作</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${users}" var="user" >
        <tr>
            <td>${user.id}</td>
            <td>${user.name}</td>
            <td>${user.birthday}</td>
            <td>${user.sex}</td>
            <td>${user.phone}</td>
            <td>${user.occupation}</td>
            <td>${user.remarks}</td>
            <td><a href="/updateUser?id=${user.id}">编辑</a></td>
            <td><a href="javascript:deleteUser(${user.id});">删除</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModal" style="float: right">
    添加用户
</button>
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">用户信息</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form action="/addUser" method="post">
            <div class="modal-body">
                <div class="form-group">
                    <input type="text" required="required" class="form-control" id="name" name="name" placeholder="姓名">
                </div>
                <div class="form-group">
                    <input type="date" required="required" class="form-control" id="birthday" name="birthday" placeholder="生日">
                </div>
                <div class="form-group">
                    <input type="text" required="required" class="form-control" id="sex" name="sex" placeholder="性别">
                </div>
                <div class="form-group">
                    <input type="text"  required="required" class="form-control" id="phone" name="phone" placeholder="手机">
                </div>
                <div class="form-group">
                    <input type="text" required="required" class="form-control" id="occupation" name="occupation" placeholder="职业">
                </div>
                <div class="form-group">
                    <input type="text" required="required" class="form-control" id="remarks" name="remarks" placeholder="备注">
                </div>
            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-secondary" data-dismiss="modal">关闭</button>
                <button type="submit" class="btn btn-primary">提交</button>
            </div>
            </form>
        </div>
    </div>
</div>

<div style="float: left;">
    <form class="form-inline" action="/selUser"  >
        <div class="form-group">
            <label>姓名：</label>
            <input type="text" name="selName"  class="form-control"  >
        </div>
        <div class="form-group">
            <label>性别：</label>
            <input type="text" name="selSex"  class="form-control"  >
        </div>
        <div class="form-group">
            <label>生日：</label>
            <input type="date" name="selBir"  class="form-control"  >
        </div>
        <button type="submit" class="btn btn-primary">查询</button>
    </form>

</div>
</body>
<script>
    function deleteUser(id){
        if(confirm("您确定要删除吗？")){
            location.href="/delUser?id="+id;
        }
    }
</script>
</html>
