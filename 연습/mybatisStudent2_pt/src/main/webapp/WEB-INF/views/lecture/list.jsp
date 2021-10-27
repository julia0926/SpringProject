<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
  <script src="/common.js"></script>
  <link rel="stylesheet" type="text/css" href="/common.css" />
  <style>
    a.btn { float: right; margin: -20px 0 5px 0; }
    td:nth-child(1), td:nth-child(5) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>강의 목록</h1>
  <a href="create" class="btn">강의 록</a>
  <table class="list">
    <thead>
      <tr>
        <th>id</th>
        <th>강좌명 </th>
        <th>교수명 </th>
        <th>개설년도 </th>
        <th>학기 </th>
        <th>수업교실 </th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="lecture" items="${ lectures }">
        <tr data-url="edit?id=${ lecture.id }">
          <td>${ lecture.id }</td>
          <td>${ lecture.title }</td>
          <td>${ lecture.professorName }</td>
          <td>${ lecture.year }</td>
          <td>${ lecture.semaster }</td>
          <td>${ lecture.room }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>

