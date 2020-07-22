<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
<title>Ordini</title>
</head>
<body>

<div class="container-wrapper">
    <div class="container">
        <div class="page-header">
            <h1>All spect</h1>

            <p class="lead">Visualizza spect</p>
        </div>

        <table class="table table-striped table-hover">
            <thead>
            <tr class="bg-success">
             
                <th>id</th>
                <th>nome</th>
            	<th>cognome</th>
                <th>datanasita</th>
             
            </tr>
            </thead>
            <c:forEach items="${spectList}" var="s">
                <tr>
                    
                    <td>${s.id}</td>
                    <td>${s.nome}</td>
                    <td>${s.cognome}</td>
                 
                 
                   
                </tr>
            </c:forEach>
        </table>

 <div class=" ult-main-seperator-inner">

 </div>





</body>
</html>