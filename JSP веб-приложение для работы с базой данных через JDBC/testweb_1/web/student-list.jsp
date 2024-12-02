<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <title>Студенты</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">


    </head>

       <body>
           <!-- Панель быстрого переключения страниц-->
        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: green">
                <div>
                    <a class="navbar-brand"> Список студентов </a>
                </div>

                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Студенты</a></li>
                </ul>
            </nav>
        </header>
        <br>
         <!--название таблицы, кнопка добавления и форма поиска-->
        <div class="row">
            <div class="container">
                <h3 class="text-center">Данные студентов</h3>
                <hr>
                <div class="container text-left">

                    <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Добавить студента</a>
                </div>
                <br>
                     <form action="<%=request.getContextPath()%>/filter" method="post">
                    <input  type="text" name="name" >
                    <input type="text"  name="city" id='input'>
                    <button class="btn btn-success" id='filtr_button' disabled>фильтр</button>
                <!--если данные не введены - кнопка поиска недоступна-->
                    <script type="text/javascript">
                        let inputElt = document.getElementById('input');
                        let btn = document.getElementById('filtr_button');
                        inputElt.addEventListener("input", function () {
                            btn.disabled = (this.value === '');
                        })
                    </script>
                </form>

                <br>
                <img src=""/>



                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Имя</th>
                            <th>Направление</th>
                            <th>Email</th>
                            <th>Город</th>
                            <th>Редактировать</th>
                        </tr>
                    </thead>
                    <tbody>
                
                        <c:forEach var="student" items="${listStudent}">

                            <tr>
                                <td>
                                    <c:out value="${student.id}" />
                                </td>
                                <td>
                                    <c:out value="${student.name}" />
                                </td>
                                   <td>
                                    <c:out value="${student.groups_name}" />
                                </td>
                                   <td>
                                    <c:out value="${student.email}" />
                                </td>
                                <td>
                                    <c:out value="${student.city}" />
                                </td>
                                <td><a href="/testweb_1/edit?id=<c:out value='${student.id}' />">Изменить</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${student.id}' />">Удалить</a></td>
                            </tr>
                        </c:forEach>

                    </tbody>

                </table>



            </div>
        </div>
    </body>

</html>