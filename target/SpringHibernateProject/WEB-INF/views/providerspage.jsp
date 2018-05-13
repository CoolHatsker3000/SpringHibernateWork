<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!--<html lang="en" xmlns:th="http://www.thymeleaf.org">-->
<head>
    <meta charset="UTF-8"/>
    <title>Providers</title>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css"/>
    <!--<script th:src="@{/js/jquery.min.js}"></script>
    <script th:src="@{/js/bootstrap.min.js}"></script>-->
</head>
<body>
<div class="container" style="margin-left: 150px; margin-top: 30px">
    <a href="http://localhost:8080/providers/add" class="btn btn-success btn-block">Add new provider</a>
</div>
<div class="container" style="margin-top: 30px;">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-danger">
                <div class="panel-heading"><h3>Providers</h3></div>
                <div class="panel-body">
                    <table id="ProvidersTable" class="table table-bordered">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>name</th>
                            <th>website</th>
                            <th>Phone number</th>
                            <th>Office adress</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${providers}" var="provider">
                        <tr>
                            <td>${provider.id}</td>
                            <td>${provider.name}</td>
                            <td>${provider.webSite}</td>
                            <td>${provider.phoneNumber}</td>
                            <td>${provider.officeAdress}</td>
                            <td>
                                <a href="<c:url value="/providers/edit/${provider.id}"/>" class="btn btn-danger">Edit</a>
                            </td>
                            <td>
                                <a href="<c:url value="/providers/delete/${provider.id}"/>" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                        </tbody>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>
</body>
</html>