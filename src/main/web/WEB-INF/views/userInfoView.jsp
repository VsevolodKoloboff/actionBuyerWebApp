
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User Info</title>
</head>
<body>
<jsp:include page="template/_header.jsp"></jsp:include>
<jsp:include page="template/_menu.jsp"></jsp:include>

<h3>Hello: ${user.userName}</h3>
User Name: <b>${user.userName}</b>
<br/>
Gender: ${user.gender} <br/>

<jsp:include page="template/_footer.jsp"></jsp:include>
</body>
</html>
