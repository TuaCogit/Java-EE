/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Speciality;
import entities.Studentgroup;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
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
import model.SpecialityFacade;
import model.StudentgroupFacade;

@Named(value = "specialityController")
@Dependent
@WebServlet(name = "SpecialityController", urlPatterns = {"/SpecialityController"})
public class SpecialityController extends HttpServlet {

    @EJB
    private SpecialityFacade specialityFacade;

    public SpecialityController() {
    }

    public List<Speciality> findAll() {
        return this.specialityFacade.findAll();
    }

    public Speciality find(int id) {
        return this.specialityFacade.find(id);
    }
    

    public String showGroupsForSpeciality(int specialityId) {
        // Логика для получения списка групп по id специальности
        // Здесь мы должны передать specialityId в качестве параметра в URL

        return "group_form?faces-redirect=true&specialityId=" + specialityId;
    }
    //////////

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //  String action = request.getParameter("action");

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
// Получаем список пользователей
       List<Speciality> allSpec = findAll();

        // добавляем полученный список в request,
        // который отправится на jsp 
        request.setAttribute("Speciality", allSpec);

        // отправляем request на jsp
        request.getRequestDispatcher("/group_form.jsp").forward(request, response);

    }
    

    


    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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

}
