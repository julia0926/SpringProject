<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="${R}common.css" />
</head>
<body>
<div class="container">
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>name</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="category" items="${ categorys }">
        <tr>
          <td>${ category.id }</td>
          <td>${ category.name }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>

