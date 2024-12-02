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
            <div >
                <form method="POST"  action="Calculator1fieldController">
                    <input class="calculator__output" type="text" id="input" name="input" value="${result}"readonly />
            </div>
            <div class="calculator__keys">
                <input type="button" class="calculator__key calculator__key--operator" value="+" onclick="appendToInput('+')" />
                <input type="button" class="calculator__key calculator__key--operator" value="-" onclick="appendToInput('+')" />
                <input type="button" class="calculator__key calculator__key--operator" value="/" onclick="appendToInput('+')" />
                <input type="button" class="calculator__key calculator__key--operator" value="*" onclick="appendToInput('+')" />
                <input type="button" class="calculator__key" value="7" onclick="appendToInput('7')" />
                <input type="button" class="calculator__key" value="8" onclick="appendToInput('8')" />
                <input type="button" class="calculator__key" value="9" onclick="appendToInput('9')" />
                <input type="button" class="calculator__key" value="4" onclick="appendToInput('4')" />
                <input type="button" class="calculator__key" value="5" onclick="appendToInput('5')" />
                <input type="button" class="calculator__key" value="6" onclick="appendToInput('6')" />
                <input type="button" class="calculator__key" value="1" onclick="appendToInput('1')" />
                <input type="button" class="calculator__key" value="2" onclick="appendToInput('2')" />
                <input type="button" class="calculator__key" value="3" onclick="appendToInput('3')" />
                <input type="button" class="calculator__key" value="0" onclick="appendToInput('0')" />
                <input type="button" class="calculator__key" value="." onclick="appendToInput('.')" />
                <input type="button" class="calculator__key" value="C" onclick="clearInput()" />
                <input type="submit" class="calculator__key calculator__key--enter" value="="  />
            </div>
            <p class="cal_Text">Введите имя:</p>
            <input class="calculator__outName" type="text"name="fio" value="${fio}" />
        </div>
    </form>
</div>
<script>

    function appendToInput(value) {
        var input = document.getElementById("input");
        input.value += value;
    }
    function clearInput() {
        var input = document.getElementById("input");
        input.value = "";
    }

</script>
</body>
</html>
<style>
    .calculator {
        border-radius: 10px;
        box-shadow: 0px 3px 6px 0px rgba(0, 0, 0, 0.15), 0px 2px 4px 0px rgba(0, 0, 0, 0.12);
        margin-inline-start: 10em;
        margin-inline-end: auto;
        margin-block-start: 2em;
        max-inline-size: 22rem;
        overflow: hidden;
        color: hsl(202, 11%, 29%);
        background: hsl(218, 92%, 95%);
    }
    .calculator__output {
        background: hsl(218, 92%, 95%);
        font-size: 4rem;
        max-inline-size: 20rem;
        padding-block-start: 3rem;
        padding-block-end: 0.5rem;
        padding-inline-end: 1.25rem;
        text-align: end;
        border: none;
    }
    .cal_Text{
        font-size: 1.3rem;
        text-align: center;
        color: hsl(59, 100%, 5%);
    }
    .calculator__outName {
        font-size: 1.5rem;
        text-align: end;
        color: hsl(59, 100%, 5%);
        background: hsl(218, 92%, 95%);
        border: none;
    }
    .calculator__output:active,
    .calculator__output:focus{
        border: none;
        background: hsl(218, 92%, 95%);
    }
    .calculator__keys {
        display: grid;
        grid-template-columns: repeat(4, 1fr);
        grid-gap: 1px;
        background: hsl(255, 100%, 100%);
        padding: 0.5rem;
    }
    .calculator__key {
        background: hsl(188, 100%, 93%);
        border: none;
        padding-block-start: 1rem;
        padding-block-end: 1rem;
        padding-inline-end: 1.25rem;
        padding-inline-start: 1.25rem;
        font-size: 1.5rem;
        /* Playful Styles */
        inline-size: 70px;
        block-size: 70px;
        margin: 0.25rem;
        border-radius: 40px;
    }
    .calculator__key:active,
    .calculator__key:focus {
        box-shadow: 0 0 8px 0 rgba(0, 0, 0, 0.3) inset;
        outline: none;
    }
    .calculator__key--operator {
        background: hsl(9, 100%, 93%);
    }
    .calculator__key--operator:active {
        background: hsl(208, 24%, 80%);
    }
    .calculator__key--enter {
        grid-column: 4 / 5;
        grid-row: 2 / span 4;
        background:hsl(109, 100%, 93%);
        height: auto;
    }
</style>