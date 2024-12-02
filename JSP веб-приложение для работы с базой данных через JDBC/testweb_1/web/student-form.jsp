<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>

    <head>
        <title>Студенты</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
    </head>

    <body>

        <header>
            <nav class="navbar navbar-expand-md navbar-dark" style="background-color: lawngreen">
                <div>
                    <a  class="navbar-brand">Изменить студента  </a>
                </div>

                <ul class="navbar-nav">
                    <li><a href="<%=request.getContextPath()%>/list" class="nav-link">Список студентов</a></li>
                </ul>
            </nav>
        </header>
        <br>
        <div class="container col-md-5">
            <div class="card">
                <div class="card-body">
                    <c:if test="${student != null}">
                        <form action="update" method="post">
                        </c:if>
                        <c:if test="${student == null}">
                            <form action="insert" method="post">
                            </c:if>
                          
                                <caption>
                                    <h2>
                                        <c:if test="${student != null}">
                                            Изменить студента
                                        </c:if>
                                        <c:if test="${student == null}">
                                            Добавить студента
                                        </c:if>
                                      
                                    </h2>
                                </caption>
                                <c:if test="${student != null}">
                                    <input type="hidden" name="id" value="<c:out value='${student.id}' />" />
                                </c:if>

                                <fieldset class="form-group">
                                    <label>Имя</label> <input type="text" value="<c:out value='${student.name}' />" class="form-control" name="name" required="required">
                                </fieldset>
                                <fieldset class="form-group">
                                    <label>Номер группы</label> <input type="text" value="<c:out value='${student.groups_id}' />" class="form-control" name="groups_id" required="required">
                                </fieldset>

                                <fieldset class="form-group">
                                    <label>Email</label> <input type="text" value="<c:out value='${student.email}' />" class="form-control" name="email">
                                </fieldset>

                                <fieldset class="form-group">
                                    <label>Город</label> <input type="text" value="<c:out value='${student.city}' />" class="form-control" name="city">
                                </fieldset>

                                <button type="submit" class="btn btn-success">Сохранить</button>
                            </form>
                            </div>
                            </div>
                            </div>
                            </body>

                            </html>