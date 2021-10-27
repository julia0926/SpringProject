<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="/common.css" />
  <style>
    td { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>강좌 목록</h1>
  <table class="list">
    <thead>
      <tr>
        <th>년도</th>
        <th>학기</th>
        <th>이수구분 </th>
        <th>강좌코드</th>
        <th>분반</th>
        <th>강좌명</th>
        <th>학점수</th>
        <th>담당교수번호</th>
        <th>담당교수명</th>
        <th>시간표</th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="course" items="${ courses }">
        <tr>
          <td>${ course.year }</td>
          <td>${ course.semester }</td>
          <td>${ course.gubun }</td>
          <td>${ course.code }</td>
          <td>${ course.bunban }</td>
          <td>${ course.title }</td>
          <td>${ course.unit }</td>
          <td>${ course.professor.professorNo }</td>
          <td>${ course.professor.name }</td>
          <td>${ course.sigan }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>

