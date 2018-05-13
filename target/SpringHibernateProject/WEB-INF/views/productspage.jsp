<%--
  Created by IntelliJ IDEA.
  User: user
  Date: 29.03.2018
  Time: 16:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Products</title>
    <link rel="stylesheet" href="../../resources/css/bootstrap.min.css"/>
</head>
<body>
<div class="container" style="margin-left: 150px; margin-top: 30px">
    <a href="http://localhost:8080/products/add" class="btn btn-success btn-block">Add new product</a>
</div>
<div class="container" style="margin-top: 30px;">
    <div class="row">
        <div class="col-md-12">
            <div class="panel panel-danger">
                <div class="panel-heading"><h3>Products</h3></div>
                <div class="panel-body">
                    <table id="ProductsTable" class="table table-bordered">
                        <thead>
                        <tr>
                            <th>name</th>
                            <th>price</th>
                            <th>receipt date</th>
                            <th>shelf life</th>
                            <th>Provider</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${products}" var="product">
                        <tr>
                            <td>${product.name}</td>
                            <td >${product.price}</td>
                            <td>${product.receiptDate}</td>
                            <td>${product.shelfLife}</td>
                            <td>${product.providerName}</td>
                            <td>
                                <a href="<c:url value="/products/edit/${product.id}"/>" class="btn btn-danger">Edit</a>
                            </td>
                            <td>
                                <a href="<c:url value="/products/delete/${product.id}"/>" class="btn btn-danger">Delete</a>
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
