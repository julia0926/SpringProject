<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<c:url var="R" value="/" />
<!DOCTYPE html>
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <link rel="stylesheet" type="text/css" href="${R}common.css">
  <style>
    form { width: 700px; margin: auto;
      box-shadow: 0 0 4px lightgray, 2px 2px 4px gray; overflow: auto; }
    form div { margin: 20px; }
    select { padding: 5px; width: 200px; }
    button { margin: 10px; padding: 0.5em 2em; }
    ul { margin-top: 30px; }
  </style>
</head>
<body>
<div class="container">
  <form:form method="post" modelAttribute="form1">
    <div>
        <form:select path="departmentId1" itemValue="id" itemLabel="name" items="${ categorys }" />
    </div>
    <div>
        <form:select path="departmentId2">
          <form:option value="0" label="카테고리를 선택하세요" />
          <form:options itemValue="id" itemLabel="name" items="${ categorys }" />
        </form:select>
    </div>
    <div class="buttons">
        <form:radiobuttons path="departmentId3" itemValue="id" 
                           itemLabel="name" items="${ categorys }" />
    </div>
    <div class="buttons">
        <form:checkboxes path="departmentId4" itemValue="id"
                         itemLabel="name" items="${ categorys }" />
    </div>
    
    <div>
        <form:checkbox path="enabled" value="true" label="활성화" />
    </div>
    
    <hr />
    <button type="submit">저장</button>
  </form:form>  
  
  <ul>
    <li>departmentId1 : ${ form1.departmentId1 }</li>  
    <li>departmentId2 : ${ form1.departmentId2 }</li>  
    <li>departmentId3 : ${ form1.departmentId3 }</li>  
    <li>departmentId4 : 
        <c:forEach var="i" items="${form1.departmentId4}" >
            ${i}
        </c:forEach>
    </li>  
<li>enabled: ${ form1.enabled }</li>  
  </ul>  
</div>
</body>
</html>

