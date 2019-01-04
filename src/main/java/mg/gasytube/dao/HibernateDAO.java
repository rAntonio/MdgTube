/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mg.gasytube.dao;

import mg.gasytube.model.BaseModele;
import Config.HibernateUtil;
import java.util.ArrayList;
import java.util.List;
import org.hibernate.Session;

/**
 *
 * @author MIORA
 */
public class HibernateDAO implements InterfaceDAO{

    @Override
    public void update(BaseModele arg) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            s.update(arg);
            s.getTransaction().commit();
        }catch(Exception e)
        {
            s.getTransaction().rollback();
            throw e;         
        }
    }

    @Override
    public void delete(BaseModele arg) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            s.delete(arg);
            s.getTransaction().commit();
        }catch(Exception e){
            s.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public void create(BaseModele arg) {
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            s.saveOrUpdate(arg);
            s.getTransaction().commit();
        }catch(Exception e)
        {
            s.getTransaction().rollback();
            throw e;
        }
    }

    @Override
    public List<BaseModele> findAll(BaseModele arg) {
        List<BaseModele> result = new ArrayList<BaseModele>();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try{
            s.beginTransaction();
            result = s.createCriteria(BaseModele.class).list();
            s.getTransaction().commit();
        }catch(Exception e)
        {
            throw e;
        }
        return result;
    }

    @Override
    public List<BaseModele> findAllPagination(BaseModele arg, int limit, int offset)
    {
        List<BaseModele> result  = new ArrayList<BaseModele>();
        Session s = HibernateUtil.getSessionFactory().getCurrentSession();
        try
        {
            s.beginTransaction();
            result = s.createCriteria(BaseModele.class).setFirstResult(limit).setMaxResults(offset).list();
            s.getTransaction().commit();
        }
        catch(Exception e)
        {
            throw e;
        }
        return result;
    }
    
}
