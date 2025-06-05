<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
  <title>Title</title>
</head>
<body>
<h1>Todo 목록 보기</h1>
<div>
  <ul>
    <c:forEach var="todo" items="${todoList}">
      <li>${todo}</li>
    </c:forEach>
  </ul>
  <a href="view" >상세보기</a>
</div>
<div>
  <a href="create">새 Todo</a>
</div>
</body>
</html>