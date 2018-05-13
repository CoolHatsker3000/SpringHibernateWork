<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 01.04.2018
  Time: 15:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Animals</title>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css"/>
</head>
<body>
<div class="container" style="margin-left: 150px; margin-top: 30px">
    <a href="http://localhost:8080/animals/add" class="btn btn-success btn-block">Add new animal</a>
</div>
<div class="container" style="margin-top: 30px;">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-danger">
                <div class="panel-heading"><h3>Animals</h3></div>
                <div class="panel-body">
                    <table id="ProductsTable" class="table table-bordered">
                        <thead>
                        <tr>
                            <th>Kind</th>
                            <th>Weight</th>
                            <th>Age</th>
                            <th>Receipt Date</th>
                            <th>Price</th>
                            <th>Provider Name</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${animals}" var="animal">
                        <tr>
                            <td>${animal.kind}</td>
                            <td>${animal.weight}</td>
                            <td>${animal.age}</td>
                            <td>${animal.receiptDate}</td>
                            <td>${animal.price}</td>
                            <td>${animal.providerName}</td>
                            <td>
                                <a href="<c:url value="/animals/edit/${animal.id}"/>" class="btn btn-danger">Edit</a>
                            </td>
                            <td>
                                <a href="<c:url value="/animals/delete/${animal.id}"/>" class="btn btn-danger">Delete</a>
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

