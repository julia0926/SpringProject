<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="/common.css" />
  <style>
    td:nth-child(1), td:nth-child(4), td:nth-child(5) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>학생 목록</h1>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>학번</th>
        <th>이름</th>
        <th>학년</th>
        <th>강좌id</th>
        <th>강좌명</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="student" items="${ students }">
        <tr>
          <td>${ student.id }</td>
          <td>${ student.studentNumber }</td>
          <td>${ student.name }</td>
          <td>${ student.year }</td>
          <td>${ student.department.id }</td>
          <td>${ student.department.departmentName }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>

