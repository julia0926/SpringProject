<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" href="${R}common.css">
  <style>
    h1 { display: inline-block; }
    a { float: right; margin-top: 30px; }
    td:nth-child(1), td:nth-child(5), td:nth-child(7) { text-align: center; }
  </style>
</head>
<body>
<div class="container">
  <h1>책 목록</h1>
  <a class="btn" href="register">책 등록</a>
  <table class="list">
    <thead>
      <tr>
        <th>책 제목 </th>
        <th>저자  </th>
        <th>출판사 </th>
        <th>가격 </th>
        <th>카테고리 ID </th>
      </tr>
    </thead>
    <tbody>
      <c:forEach var="book" items="${ books }">
        <tr>
          <td>${ book.id }</td>
          <td>${ book.title }</td>
          <td>${ book.author }</td>
          <td>${ book.price }</td>
          <td>${ book.categoryId }</td>
        </tr>
      </c:forEach>
    </tbody>
  </table>
</div>
</body>
</html>

