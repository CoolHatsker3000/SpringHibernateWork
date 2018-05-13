<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.04.2018
  Time: 13:05
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
        <form:form method="POST" modelAttribute="product">
            <div class="form-group">
                <label for="name">Name:</label>
                <form:input path="name" id="name"/>
            </div>
            <div class="form-group">
                <label for="price">Price:</label>
                <form:input path="price" id="price"/>
            </div>
            <div class="form-group">
                <label for="receiptDate">Receipt Date (YYYY-MM-DD):</label>
                <form:input path="receiptDate" class="form-control" id="receiptDate"/>
            </div>
            <div class="form-group">
                <label for="shelfLife">Shelf Life (YYYY-MM-DD):</label>
                <form:input path="shelfLife" class="form-control" id="shelfLife"/>
            </div>
            <div class="form-group">
                <label for="providerID">Provider ID:</label>
                <form:input path="providerID" class="form-control" id="providerID"/>
            </div>
            <input class="btn btn-success" type="submit" value="Submit"/>
            <input class="btn btn-warning" type="reset" value="Reset"/>
            <a href="http://localhost:8080/products" class="btn btn-info">Back to products list</a>
        </form:form>
    </div>
</div>
</body>
</html>
