<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<link rel="stylesheet" href="${R}common.css">
<style>
  label { display: block; margin-top:10px; }
  .error { color: red; display: block; }
  button { margin-top: 20px; }
</style>
</head>
<body>
<div class="container">
  <h1>책 등록 </h1>
  <form:form method="post" modelAttribute="bookRegister">
    <div>
      <label>책 제목 :</label>
      <form:input path="title" />
      <form:errors path="title" class="error" />
    </div>
    <div>
      <label>저자 : </label>
      <form:password path="author" />
      <form:errors path="author" class="error" />
    </div>
    <div>
      <label>가격 :</label>
      <form:password path="price" />
      <form:errors path="price" class="error" />
    </div>
    <div>
      <label>출판사  :</label>
      <form:input path="publisher" />
      <form:errors path="publisher" class="error" />
    </div>
    <div>
      <label>카테고리 :</label>
      <form:checkboxes path="categoryId" itemValue="id"
                         itemLabel="name" items="${ categorys }" />
    </div>
    <button type="submit" class="btn">등록 완료 </button>
  </form:form>
</div>
</body>
</html>

