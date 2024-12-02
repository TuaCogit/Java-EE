
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> <!--Строчка, которая делает магию-->
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
                <h3 class="text-center">Деканат: Группы</h3>
                <hr>
                <br> <!-- Фильтр групп по специальности, обращение к контроллеру с передачей параметров-->
                <form method="POST"  action="GroupController?action=filter" >
                    <select name="specialityId" >
                        <!-- Получение списка специальностей для выпадащего списка-->
                        <c:forEach items="${specialityController.findAll()}" var="category">
                            <option value="${category.id}">${specialityController.find(category.id).name}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Фильтр" class="btn btn-success"/>
                </form>
                <br> <!-- Отображение таблицы групп-->
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Группа</th>
                            <th>Специаьность</th>
                        </tr>
                    </thead>
                    <tbody><!-- Получение списка групп из констроллера-->
                        <c:forEach var="sp" items="${studentgroup}" >
                            <tr>
                                <td> <c:out value="${sp.id}" /></td>
                                <td> <c:out value="${sp.name}" /></td>
                                <td>${groupController.find(sp.id).specialityId.name}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>
