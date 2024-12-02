/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import entities.Student;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.List;
import javax.ejb.EJB;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StudentFacade;


@Named(value = "studentController")
@Dependent
@WebServlet(name = "StudentController", urlPatterns = {"/StudentController"})
public class StudentController extends HttpServlet {

    @EJB
    private StudentFacade studentFacade;

    public StudentController() {
    }
    //получение списка всех студентов
    public List<Student> findAll() {
        return this.studentFacade.findAll();
    }
    //получение одного студента
    public Student find(int id) {
        return this.studentFacade.find(id);
    }
    //поиск студентов по выбранной группе
    public List<Student> findByGroupId(int groupsId) {
        return this.studentFacade.findByGroupId(groupsId);
    }
    //поиск студентов по выбранному курсу
    public List<Student> findCoursebyStudentId(int courseId) {
        return this.studentFacade.findCoursebyStudentId(courseId);
    }
    //вызов метода, соответсвущего полученному значению параметра action
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getParameter("action");
        try {
            switch (action) {
                case "filter": //фильтр по группе
                    filterStudent(request, response);
                    break;
                case "course": //фильтр по курсу
                    courseStudent(request, response);
                    break;
                default: //вывод списка студентов
                    listStudent(request, response);
                    break;
            }
        } catch (SQLException ex) {throw new ServletException(ex);}
    }
    //передача списка всех студентов
    private void listStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List<Student> student = findAll();
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("studetn_form.jsp");
        dispatcher.forward(request, response);
    }
    //фильтр студентов по выбранной группе
    private void filterStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int groupsId = Integer.parseInt(request.getParameter("groupsId"));
        List<Student> student = findByGroupId(groupsId);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("calculator2fields.jsp");
        dispatcher.forward(request, response);
    }
    //фильтр студентов по выбранному курсу
    private void courseStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        int courseId = Integer.parseInt(request.getParameter("courseId"));
        List<Student> student = findCoursebyStudentId(courseId);
        request.setAttribute("student", student);
        RequestDispatcher dispatcher = request.getRequestDispatcher("course_form.jsp");
        dispatcher.forward(request, response);

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

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
