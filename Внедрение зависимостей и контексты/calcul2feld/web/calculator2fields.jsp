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
        <title>Calculator</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    </head>
    <body >
        <header>
          <nav class="navbar navbar-expand-md navbar-dark" style="background-color: lightgreen;  font-size: 1.3rem">
                <ul class="navbar-nav">
                    <li><a href="calculator2fields.jsp" class="nav-link" style="color: hsl(59, 100%, 5%);">Два поля</a></li></ul>
                <ul class="navbar-nav">
                    <li><a href="calculator1fields.jsp" class="nav-link" style="color: hsl(59, 100%, 5%);">Одно поле</a></li></ul>
                     <ul class="navbar-nav">
                    <li><a href="game.jsp" class="nav-link" style="color: hsl(59, 100%, 5%);">Игра</a></li></ul>
            </nav>
        </header>
        <hr>
        <div class="calculator">
            <form method="POST"  action="Calculator2fieldController?action=operat">
                <div class="cal_out">
                    <p class="cal_in_Text">Первое число:</p>
                    <input class="cal_in_input" type="text" name="num1" value="${result[0]}"></div>
                <div class="cal_out">
                    <p class="cal_out_Text">Второе число:</p>
                    <input class="cal_in_input" type="text" name="num2" value="${result[1]}">  
                    <p></p> </div>
                <div class="calculator__keys">
                    <input class="add" type="submit" name="group1" value ="+"><br>
                    <input class="sub" type="submit" name="group1" value ="-"><br>
                    <input class="mul" type="submit" name="group1" value ="*"><br>
                    <input class="div" type="submit" name="group1" value ="/"><br><p></p>   
                </div>
                <div class="cal_out">
                    <p></p>   
                    <p>Результат:</p>   
                    <input class="cal_out_input" type="text" value="${result[2]}" readonly><p></p>  
                </div>
            </form>
        </div>
    </body>
</html>
<style>
    .calculator {
        align-items: center;
        position: relative;
        top: 50%;
        left: 20%;
        max-inline-size: 20rem;
        border-radius: 10px;
        background: hsl(156, 41%, 94%); 
        overflow: hidden; 
        box-shadow: 0px 3px 6px 0px rgba(0, 0, 0, 0.15), 0px 2px 4px 0px rgba(0, 0, 0, 0.12); /* Give the calculator some depth off the page */
    }
    .cal_out {

        font-size: 1.2rem;
        text-align: end; /* This is the Logical Property for text-align: right; and has very good browser support. */
        background: hsl(156, 41%, 94%); /* background color */
        color: hsl(59, 100%, 5%); /* text color */
        padding-block-start: 0.25rem; /* Logical Property for padding-top */
        padding-block-end: 0.25rem; /* Logical Property for padding-bottom */
        padding-inline-end: 0.75rem; /* Logical Property for padding-right */
    }
    .cal_in_input {
        font-size: 1.5rem;
        text-align: end;
        background: hsl(59, 100%, 97%); /* background color */
    }
    .cal_out_input {
        font-size: 1.5rem;
        text-align: end;
        color: hsl(59, 100%, 5%);
        background:hsl(109, 100%, 93%); /* text color */
    }
    .cal_out_Text{
        font-size: 1.3rem;
        text-align: end;
        color: hsl(59, 100%, 5%);
    }
    .calculator__keys {
        position: relative;
        left: 10%;
        display: grid;
        grid-template-columns: 40% 1fr 40% 7fr;
        grid-template-rows: 50% 50%;
        background: hsl(156, 41%, 94%); 

    }

    .calculator__key--operator {
        font-size: 1.5rem;
        background: hsl(208, 25%, 86%);
    }
    .add{
        font-size: 1.5rem;
        background: hsl(9, 100%, 93%);
    }
    .sub{
        font-size: 1.5rem;
        background: hsl(188, 100%, 93%);
    }
    .mul{
        font-size: 1.5rem;
        background: hsl(29, 100%, 93%)
    }
    .div{
        font-size: 1.5rem;
        background: hsl(217, 100%, 93%);
    }
    .calculator__key--operator:active,.add:active,.cub:active,.mul:active,.div:active {
        background: hsl(9, 0%, 79%)
    }



</style>