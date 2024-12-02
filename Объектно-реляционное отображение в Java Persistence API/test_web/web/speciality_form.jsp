<%-- 
    Document   : speciality_form
    Created on : 22.11.2023, 22:21:20
    Author     : Ang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <title>Деканат: Специаьности</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>  <!-- Панель быстрого переключения страниц-->
        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: green">
                <ul class="navbar-nav">
                    <li><a href=StudentController?action=list" class="nav-link">Студенты </a></li></ul>
                <ul class="navbar-nav">
                    <li><a href="speciality_form.jsp" class="nav-link">Специальности</a></li></ul>
                <ul class="navbar-nav">
                    <li><a href="GroupController?action=list" class="nav-link">Группы</a></li></ul>
                <ul class="navbar-nav">
                    <li><a href="course_form.jsp" class="nav-link">Курсы</a></li></ul>
            </nav>
        </header>
        <br>
        <div class="row">
            <div class="container">
                <h3 class="text-center">Деканат: Специальности</h3>
                <hr>
                <br><!-- Отображение таблицы специаьности-->
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Специальность</th>
                            <th>Аббревиатура</th>
                        </tr>
                    </thead>
                    <tbody><!-- Получение списка специаьности-->
                        <c:forEach var="sp" items="${specialityController.findAll()}">
                            <tr>
                                <td> <c:out value="${sp.id}" /> </td>
                                <td> <c:out value="${sp.name}" /> </td>
                                <td> <c:out value="${sp.abbrev}" /> </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>