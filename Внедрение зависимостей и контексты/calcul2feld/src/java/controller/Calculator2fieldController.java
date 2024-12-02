/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Calcul2fieldLocal;

/**
 *
 * @author Ang
 */
@Named(value = "calculator2fieldController")
@Dependent
@WebServlet(name = "Calculator2fieldController", urlPatterns = {"/Calculator2fieldController"})
public class Calculator2fieldController extends HttpServlet {

    @EJB
    private Calcul2fieldLocal calculator2fieldModel;

    public Calculator2fieldController() {
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "operat": //фильтр по группе
                    op(request, response);
                    break;
                default: //вывод списка студентов
                    def(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);}
    }
    private void op(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        //получение чисел из полей ввода
        double num1 = Double.parseDouble(request.getParameter("num1"));
        double num2 = Double.parseDouble(request.getParameter("num2"));
        String operation = request.getParameter("group1");
        List result = new ArrayList();
        //сохранение введеных чисел в полях
        result.add(num1);
        result.add(num2);
        switch (operation) {
            case "+":
                result.add(calculator2fieldModel.add(num1, num2)); //сложение
                break;
            case "-":
                result.add(calculator2fieldModel.subtract(num1, num2)); //вычитание
                break;
            case "*":
                result.add(calculator2fieldModel.multiply(num1, num2)); //умножение
                break;
            case "/":
                result.add(calculator2fieldModel.divide(num1, num2)); //деление
                break;
            default:
                result.add(0);
                break;
        }
        request.setAttribute("result", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/calculator2fields.jsp");
        dispatcher.forward(request, response);
    }

    private void def(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        //по умочанию значения = 0
        List result = new ArrayList();
        result.add(0);
        result.add(0);
        result.add(0);
        request.setAttribute("result", result);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/calculator2fields.jsp");
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
