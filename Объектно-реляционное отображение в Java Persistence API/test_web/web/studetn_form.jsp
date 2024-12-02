<%-- 
    Document   : studetn_form
    Created on : 22.11.2023, 21:24:59
    Author     : Ang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <title>Деканат: студенты</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

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
                <h3 class="text-center">Деканат: Студенты</h3>
                <hr>
                <br> <!-- Фильтр студентов по группе, обращение к контроллеру с передачей параметров-->
                <form method="POST"  action="StudentController?action=filter" >
                    <select name="groupsId" >
                        <!-- Получение списка групп для выпадащего списка-->
                        <c:forEach items="${groupController.findAll()}" var="category">
                            <option value="${category.id}">${groupController.find(category.id).name}</option>
                        </c:forEach>
                    </select>
                    <input type="submit" value="Фильтр" class="btn btn-success"/>
                </form>
                <br>  <!-- Отображение таблицы студентов-->
                <table border="1" cellpadding="2" cellspacing="2" class="table table-bordered">
                    <thead>
                        <tr>
                            <th>Id</th>
                            <th>Фамилия</th>
                            <th>Имя</th>
                            <th>Отчество</th>
                            <th>Паспорт</th>
                            <th>Дата рождения</th>
                            <th>Курс</th>
                            <th>Група</th>
                            <th>Специальность</th>
                            <th>Аббревиатура</th>
                        </tr>
                    <tbody><!-- Получение списка студентов из констроллера-->
                        <c:forEach items='${student}' var="st">
                            <tr>
                                <td>${st.id}</td>
                                <td>${st.surname}</td>
                                <td>${st.firstname}</td>
                                <td>${st.lastname}</td>
                                <td>${st.passport}</td>
                                <td>${st.birthdate}</td>
                                <td>${studentController.find(st.id).courseId.numb}</td>
                                <td>${studentController.find(st.id).groupsId.name}</td>
                                <td>${studentController.find(st.id).groupsId.specialityId.name}</td>
                                <td>${studentController.find(st.id).groupsId.specialityId.abbrev}</td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </body>
</html>