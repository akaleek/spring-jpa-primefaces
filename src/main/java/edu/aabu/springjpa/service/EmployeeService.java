/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.aabu.springjpa.service;

import edu.aabu.springjpa.model.Employee;
import edu.aabu.springjpa.model.Employee;
import edu.aabu.springjpa.repository.EmployeeRepository;
import edu.aabu.springjpa.repository.EmployeeRepository;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author heba
 */
@Service("employeeService")
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    @Transactional
    public void register(Employee emp) {
        employeeRepository.save(emp);
    }

    @Transactional
    public List<Employee> getAllEmployees() {
        System.out.println("getAllEmployees =");
        List<Employee> employees = new ArrayList();
        Iterable<Employee> employeesIterable = employeeRepository.findAll();
        Iterator<Employee> employeesIterator = employeesIterable.iterator();
        while (employeesIterator.hasNext()) {
            employees.add(employeesIterator.next());
        }
        System.out.println("getAllEmployees =" + employees);
        return employees;
    }

    @Transactional
    public Employee getEmployee(long id) {
        return employeeRepository.findOne(id);
    }

    @Transactional
    public void addEmployee(Employee country) {
        employeeRepository.save(country);
    }

    @Transactional
    public void updateEmployee(Employee country) {
        employeeRepository.save(country);

    }

    @Transactional
    public void deleteEmployee(long id) {
        employeeRepository.delete(id);
    }

    public EmployeeService() {
        System.out.println("\n\n\n\nEmployeeService() constructor is called--------->\n\n\n\n");
    }

}
