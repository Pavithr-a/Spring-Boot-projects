package com.luv2code.employeedemo.dao;

import com.luv2code.employeedemo.entity.Employee;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDaoImpl(EntityManager theEntityManager) {
        entityManager = theEntityManager;
    }

    @Override
    @Transactional
    public void save(Employee theEmployee) {
        entityManager.persist(theEmployee);
    }

    @Override
    public Employee findByid(Integer id) {
        return entityManager.find(Employee.class,id);
    }

    @Override
    public List<Employee> findAll() {
        TypedQuery<Employee> theQuery=entityManager.createQuery("FROM Employee order by lastName",Employee.class);
        return theQuery.getResultList();
    }

    @Override
    public List<Employee> findByLastname(String theLastName) {
        TypedQuery<Employee> theQuery=entityManager.createQuery("FROM Employee where lastName=:theData",Employee.class);
        theQuery.setParameter("theData",theLastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Employee theEmployee) {
        entityManager.merge(theEmployee);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
        Employee myEmployee=entityManager.find(Employee.class,id);
        entityManager.remove(myEmployee);

    }

    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted=entityManager.createQuery("DELETE from Employee").executeUpdate();
        return numRowsDeleted;
    }

}
