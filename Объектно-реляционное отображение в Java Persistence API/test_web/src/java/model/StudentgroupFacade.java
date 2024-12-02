/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import entities.Studentgroup;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

/**
 *
 * @author Ang
 */
@Stateless
public class StudentgroupFacade extends AbstractFacade<Studentgroup> {

    @PersistenceContext(unitName = "test_webPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public StudentgroupFacade() {
        super(Studentgroup.class);
    }

    public List<Studentgroup> findByspecialityId(int specialityId) {
        TypedQuery<Studentgroup> typedQuery = em.createNamedQuery("Studentgroup.findBySpecId", Studentgroup.class);
        typedQuery.setParameter("specialityId", specialityId);
        return typedQuery.getResultList();
    }

}
