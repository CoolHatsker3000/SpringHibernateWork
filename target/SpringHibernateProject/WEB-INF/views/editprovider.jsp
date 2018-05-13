<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 29.03.2018
  Time: 15:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<head>
    <title>Add new provider</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <!--<script th:src="@{/js/bootstrap.min.js}"></script>-->
</head>
<body>
<h1>Add New Provider</h1>
<div class="panel panel-success">
    <div class="panel-heading"></div>
    <div class="panel-body">
        <form:form method="POST" modelAttribute="provider">
            <div class="form-group">
                <label for="name">Name:</label>
                <form:input path="name" id="name"/>
            </div>
            <div class="form-group">
                <label for="webSite">Web-Site:</label>
                <form:input path="webSite" id="webSite"/>
            </div>
            <div class="form-group">
                <label for="phoneNumber">Phone:</label>
                <form:input path="phoneNumber" class="form-control" id="phoneNumber"/>
            </div>
            <div class="form-group">
                <label for="officeAdress">Office address:</label>
                <form:input path="officeAdress" class="form-control" id="officeAdress"/>
            </div>
            <input class="btn btn-success" type="submit" value="Submit"/>
            <input class="btn btn-warning" type="reset" value="Reset"/>
            <a href="http://localhost:8080/providers" class="btn btn-info">Back to providers list</a>
        </form:form>
    </div>
</div>
</body>
</html>

