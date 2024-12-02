/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Calcul1fieldLocal;

/**
 *
 * @author Ang
 */
@Named(value = "calculator1fieldController")
@Dependent
@WebServlet(name = "Calculator1fieldController", urlPatterns = {"/Calculator1fieldController"})
public class Calculator1fieldController extends HttpServlet {

    @EJB
    private Calcul1fieldLocal calculator1fieldModel;

    public Calculator1fieldController() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //получение выражения с поля ввода
        String inputValue = request.getParameter("input");
        //получение имени клиента
        String fio = request.getParameter("fio");
        double result = 0;
        //вычисление выражения
        result = calculator1fieldModel.calculate(inputValue);
        //передача результата вычислений и имени клиента обратно на форму
        request.setAttribute("result", result);
        request.setAttribute("fio", fio);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/calculator1fields.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
