<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.04.2018
  Time: 16:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Add new animal</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
    <!--<script th:src="@{/js/bootstrap.min.js}"></script>-->
    <style>

        .error {
            color: #ff0000;
        }
    </style>
</head>
<body>
<h1>Add New Animal</h1>
<div class="panel panel-success">
    <div class="panel-heading"></div>
    <div class="panel-body">
        <form:form method="POST" modelAttribute="animal">
            <div class="form-group">
                <label for="kind">Kind:</label>
                <form:input path="kind" id="kind"/>
            </div>
            <div class="form-group">
                <label for="weight">Weight:</label>
                <form:input path="weight" id="weight"/>
            </div>
            <div class="form-group">
                <label for="age">Age:</label>
                <form:input path="age" class="form-control" id="age"/>
            </div>
            <div class="form-group">
                <label for="receiptDate">Receipt Date(YYYY-MM-DD):</label>
                <form:input path="receiptDate" class="form-control" id="receiptDate"/>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <form:input path="price" class="form-control" id="price"/>
            </div>
            <div class="form-group">
                <label for="providerID">Provider ID:</label>
                <form:input path="providerID" class="form-control" id="providerID"/>
            </div>
            <input class="btn btn-success" type="submit" value="Submit"/>
            <input class="btn btn-warning" type="reset" value="Reset"/>
            <a href="http://localhost:8080/animals" class="btn btn-info">Back to providers list</a>
        </form:form>
    </div>
</div>
</body>
</html>
