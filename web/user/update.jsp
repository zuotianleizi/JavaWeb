<%--
  Created by IntelliJ IDEA.
  User: ASUS
  Date: 2021/3/28
  Time: 15:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>修改信息</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" >
    <script src="https://code.jquery.com/jquery-3.3.1.min.js" ></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" ></script>
</head>
<body>
<form action="/updateUser?id=${user.id}" method="post">
    <h3 style="text-align: center;">修改联系人</h3>
    <div class="container">
        <div class="form-group">
            <input type="text" value="${user.name}" required="required" class="form-control" id="name" name="name" placeholder="姓名">
        </div>
        <div class="form-group">
            <input type="date" value="${user.birthday}" required="required" class="form-control" id="birthday" name="birthday" placeholder="生日">
        </div>
        <div class="form-group">
            <input type="text" value="${user.sex}" required="required" class="form-control" id="sex" name="sex" placeholder="性别">
        </div>
        <div class="form-group">
            <input type="text"  value="${user.phone}" required="required" class="form-control" id="phone" name="phone" placeholder="手机">
        </div>
        <div class="form-group">
            <input type="text" value="${user.occupation}"  required="required" class="form-control" id="occupation" name="occupation" placeholder="职业">
        </div>
        <div class="form-group">
            <input type="text" value="${user.remarks}" required="required" class="form-control" id="remarks" name="remarks" placeholder="备注">
        </div>
    </div>
    <div class="modal-footer">
        <a href="/home" class="btn btn-secondary" data-dismiss="modal">取消</a>
        <button type="submit" class="btn btn-primary">提交</button>
    </div>
</form>
</body>
</html>
