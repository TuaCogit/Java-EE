/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

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
import model.StudentgroupFacade;

@Named(value = "groupController")
@Dependent
@WebServlet(name = "GroupController", urlPatterns = {"/GroupController"})
public class GroupController extends HttpServlet {

    @EJB
    private StudentgroupFacade studentgroupFacade;

    public List<Studentgroup> findAll() {
        return this.studentgroupFacade.findAll();
    }

    public Studentgroup find(int id) {
        return this.studentgroupFacade.find(id);
    }

    private List<Studentgroup> groups;  // список групп связанных с выбранной специальностью

    public Studentgroup showGroups(int id) {
        return this.studentgroupFacade.find(id);
    }

   

    public List<Studentgroup> findByspecialityId(int specialityId) {
        return this.studentgroupFacade.findByspecialityId(specialityId);
    }

   
    public void findName(String name) {
        //   this.studentgroup = studentgroupFacade.findName("group 2");
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "filter": //поиск студента
                    filterGroup(request, response);
                    break;
                default: //вывод списка студентов
                    listGroup(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }

    }

    private void listGroup(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Studentgroup> studentgroup = findAll();
        request.setAttribute("studentgroup", studentgroup);
        RequestDispatcher dispatcher = request.getRequestDispatcher("group_form.jsp");
        dispatcher.forward(request, response);
    }

    private void filterGroup(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int specialityId = Integer.parseInt(request.getParameter("specialityId"));
        List<Studentgroup> studentgroup = findByspecialityId(specialityId);
        request.setAttribute("studentgroup", studentgroup);
        RequestDispatcher dispatcher = request.getRequestDispatcher("group_form.jsp");
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

}
