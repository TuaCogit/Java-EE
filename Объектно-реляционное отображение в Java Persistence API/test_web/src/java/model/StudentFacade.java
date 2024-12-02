/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Student;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ang
 */
@Stateless
public class StudentFacade extends AbstractFacade<Student> {

    @PersistenceContext(unitName = "test_webPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    public StudentFacade() {
        super(Student.class);
    }
    //поиск студентов по выбранной группе
    public List<Student> findByGroupId(int groupsId) {
        TypedQuery<Student> typedQuery = em.createNamedQuery("Student.findByGroupId", Student.class);
        typedQuery.setParameter("groupsId", groupsId);
        return typedQuery.getResultList();
    }
    //поиск студентов по выбранному курсу
    public List<Student> findCoursebyStudentId(int courseId) {
        TypedQuery<Student> typedQuery = em.createNamedQuery("Student.findCoursebyStudentId", Student.class);
        typedQuery.setParameter("courseId", courseId);
        return typedQuery.getResultList();
    }
}
