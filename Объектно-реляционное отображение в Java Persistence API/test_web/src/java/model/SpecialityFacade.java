/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Speciality;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class SpecialityFacade extends AbstractFacade<Speciality> {

    @PersistenceContext(unitName = "test_webPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    // Получаем пользователя по id

    public Speciality get(long id) {
        return em.find(Speciality.class, id);
    }

    public SpecialityFacade() {
        super(Speciality.class);
    }

    public Speciality getSpec(int id) {
        return em.find(Speciality.class, id);
    }

    public List<Speciality> getAll() {
        return em.createNamedQuery("Speciality.getAll").getResultList();
    }

}







