package com.ra.session16baitap_hibernate.dao.impl;

import com.ra.session16baitap_hibernate.dao.IEmployeeDao;
import com.ra.session16baitap_hibernate.orm.Employee;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Repository
public class EmployeeDaoImpl implements IEmployeeDao
{
    private final SessionFactory sessionFactory;

    @Autowired
    public EmployeeDaoImpl(SessionFactory sf)
    {
        this.sessionFactory = sf;
    }

    @Override
    public List<Employee> findAll()
    {
        List employeeList = new ArrayList<>();
        Session session = sessionFactory.openSession();
        try
        {
            employeeList = session.createQuery("from Employee").list();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            session.close();
        }
        return employeeList;
    }

    @Override
    public Employee findById(Integer id)
    {
        Session session = sessionFactory.openSession();
        try
        {
            return session.get(Employee.class, id);
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            session.close();
        }
        return null;
    }

    @Override
    public boolean insertEmployee(Employee employee)
    {
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            session.save(employee);
            session.getTransaction().commit();
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }
        return false;
    }

    @Override
    public boolean updateEmployee(Employee employee)
    {
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            session.update(employee);
            session.getTransaction().commit();
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }
        return false;
    }

    @Override
    public boolean deleteEmployee(Integer id)
    {
        Session session = sessionFactory.openSession();
        try
        {
            session.beginTransaction();
            session.delete(findById(id));
//            session.createQuery("delete from Employee where employeeId = :em_id").setParameter("em_id", id).executeUpdate();
            session.getTransaction().commit();
            return true;
        } catch (Exception e)
        {
            e.printStackTrace();
            session.getTransaction().rollback();
        } finally
        {
            session.close();
        }
        return false;
    }

    @Override
    public List<Employee> searchByName(String name)
    {
        Session session = sessionFactory.openSession();
        try
        {
            if (name == null || name.isEmpty())
            {
                name = "%";
            } else
            {
                name = "%" + name + "%";
            }
            return session.createQuery("from Employee where employeeName = :searchName")
                    .setParameter("searchName", name).list();
        } catch (Exception e)
        {
            e.printStackTrace();
        } finally
        {
            session.close();
        }
        return null;
    }
}
