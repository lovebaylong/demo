<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <title>用户详情</title>
    </head>
    <body>
        <div>
            姓名: ${user.name}
        </div>
        <div>
            类型: ${user.type}
        </div>
        <div>
            身份证号: ${user.idCardNo}
        </div>
        <div>
            电话: ${user.phone}
        </div>
        <div>
            邮箱: ${user.email}
        </div>
        <div>
            地址: ${user.address}
        </div>
        <div>
            年龄: ${user.age}
        </div>
        <div>
            在世: ${user.isLive}
        </div>
        <div>
            <a href="javascript: window.history.go(-1);">返回</a>
        </div>
    </body>
</html>
