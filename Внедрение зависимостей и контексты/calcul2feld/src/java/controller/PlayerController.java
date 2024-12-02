/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Player;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.PlayerModel;


@WebServlet(name = "PlayerController", urlPatterns = {"/PlayerController"})
public class PlayerController extends HttpServlet {

    @EJB
    private PlayerModel playerModel;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            Player player;
            int i = 0;
            //получение числа-ответа от каждого игрока
            while (i <= 3) {
                player = new Player(i);
                int number = player.getNumber();
                request.setAttribute("player" + i, number);
                 String result = playerModel.guessNumber(number);
                 //сопоставление загаданного числа с выданным игроком
                request.setAttribute("result" + i, result);
                i++;
            }
            //вывод загаданного числа
            request.setAttribute("secret", playerModel.getNumber());
            request.getRequestDispatcher("/game.jsp").forward(request, response);

        } catch (NumberFormatException ex) {
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
