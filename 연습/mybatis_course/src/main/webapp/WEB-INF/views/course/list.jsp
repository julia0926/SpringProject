<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="${R}common.js"></script>
  <link rel="stylesheet" type="text/css" href="${R}common.css" />
  <style>
    a.btn { float: right; margin: -20px 0 5px 0; }
    td:nth-child(1), td:nth-child(5) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>강좌 목록</h1>
  <a href="create" class="btn">강좌 등록</a>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>강좌이름 </th>
        <th>개설학부 </th>
        <th>교수명  </th>
        <th>학점 </th>
        <th>시작일 </th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="course" items="${ courses }">
        <tr data-url="edit?id=${ course.id }">
          <td>${ course.id }</td>
          <td>${ course.courseName }</td>
          <td>${ course.departmentName }</td>
          <td>${ course.professorName }</td>
          <td>${ course.unit }</td>
          <td><fmt:formatDate pattern="yyyy-MM-dd" value="${ course.startDate }" /></td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>

