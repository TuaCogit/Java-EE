/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pege3;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.RequestDispatcher;
import pege1.StudentD;
import pege2.Student;

/**
 *
 * @author Ang
 */
@WebServlet("/")
public class StudentServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;
    private StudentD studentD;

    @Override
    public void init() {
        studentD = new StudentD();
    }

    //методы оработки форм и получения параметров с помощью запросов post и get
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String action = request.getServletPath();
    //вызов метода, соответсвущего вызванной части URL, относящейся я к текущему сервлету
        try {
            switch (action) {
                case "/new": //открытие формы создания
                    showNewForm(request, response);
                    break;
                case "/insert": //создание студента
                    insertStudent(request, response);
                    break;
                case "/delete": //удаление студента
                    deleteStudent(request, response);
                    break;
                case "/edit": //открытие формы изменения
                    showEditForm(request, response);
                    break;
                case "/update": //изменение студента
                    updateStudent(request, response);
                    break;
                case "/filter": //поиск студента
                    filterStudent(request, response);
                    break;
                default: //вывод списка студентов
                    listStudent(request, response);
                    break;
            }
        } catch (SQLException ex) {
            throw new ServletException(ex);
        }
    }
    
    private void showNewForm(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        dispatcher.forward(request, response);
    }
    //открытие формы изменение студента с передачей параметров
    private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Student existingStudent = studentD.selectStudent(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-form.jsp");
        request.setAttribute("student", existingStudent);
        dispatcher.forward(request, response);
    }
    
    //передача списка студентов, полученных в результате выполнения запроса вывода студентов
    private void listStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException, ServletException {
        List< Student> listStudent = studentD.selectAllStudents();
        request.setAttribute("listStudent", listStudent);
        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(request, response);
    }
    //получение с формы и передача параметров для выполнение запроса создания студента
    private void insertStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        String name = request.getParameter("name");
        int groups_id = Integer.parseInt(request.getParameter("groups_id"));
        String email = request.getParameter("email");
        String city = request.getParameter("city");
        Student newStudent = new Student(name,groups_id, email, city);
        studentD.insertStudent(newStudent);
        response.sendRedirect("list");
    }

    private void updateStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        int groups_id = Integer.parseInt(request.getParameter("groups_id"));
        String email = request.getParameter("email");
        String city = request.getParameter("city");

        Student book = new Student(id, name, groups_id, email, city);
        studentD.updateStudent(book);
        response.sendRedirect("list");
    }

    private void deleteStudent(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        studentD.deleteStudent(id);
        response.sendRedirect("list");

    }

    

    private void filterStudent(HttpServletRequest request , HttpServletResponse response
    )
            throws SQLException , IOException, ServletException

    {
        String name = request.getParameter("name");
        String city = request.getParameter("city");
         List< Student> listStudent1 = studentD.filterStudent(name,city);
         request.setAttribute("listStudent", listStudent1);

        RequestDispatcher dispatcher = request.getRequestDispatcher("student-list.jsp");
        dispatcher.forward(request, response);

       
    }

}
