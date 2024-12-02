<%-- 
    Document   : game
    Created on : 14.12.2023, 17:12:40
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
        <div class="game">
            <form method="POST"  action="PlayerController">
                <h2>Игроки угадывают число число</h2>

                <p class="game_Text"> Игрок 1 <input class="game_out" type="text "name="player1" value="${player1}" readonly /></p> 
                <p class="game_Text"> Игрок 2 <input  class="game_out" type="text "name="player2" value="${player2}" readonly /></p>
                <p class="game_Text"> Игрок 3 <input  class="game_out" type="text "name="player3" value="${player3}" readonly /></p>

                <input class="key" type="submit" value="Угадать">
                <p></p>
            </form>
        </div>
        <div class="gameResult">
            <p class="game_Text">Загаданное число: ${secret}</p>
            <p class="game_Text">Игрок 1: ${result1}</p>
            <p class="game_Text">Игрок 2: ${result2}</p>
            <p class="game_Text">Игрок 3: ${result3}</p>
        </div>
    </body>
</html>
<style>
    .game {
        align-items: center;
        position: relative;
        top: 50%;
        left: 20%;
        max-inline-size: 20rem;
        border-radius: 10px;
        background: hsl(156, 41%, 94%); 
        overflow: hidden; 
        box-shadow: 0px 3px 6px 0px rgba(0, 0, 0, 0.15), 0px 2px 4px 0px rgba(0, 0, 0, 0.12); 
    }
    .gameResult {
        align-items: center;
        position: relative;
        top: 50%;
        left: 20%;
        max-inline-size: 20rem;
        border-radius: 10px;
        background: hsl(9, 100%, 93%); 
        overflow: hidden; 
        box-shadow: 0px 3px 6px 0px rgba(0, 0, 0, 0.15), 0px 2px 4px 0px rgba(0, 0, 0, 0.12); 
    }
    .game_out {

       font-size: 1.2rem;
        text-align: end; 
        background: hsl(59, 100%, 97%);
        color: hsl(59, 100%, 5%); 
        padding-block-start: 0.25rem; 
        padding-block-end: 0.25rem; 
        padding-inline-end: 0.75rem; 
    }
     .game_Text{
        font-size: 1.3rem;
        
        color: hsl(59, 100%, 5%);
    }
    .key{
         position: relative;
        left: 50%;
        font-size: 1.5rem;
        background: hsl(188, 100%, 93%);
    }

</style>