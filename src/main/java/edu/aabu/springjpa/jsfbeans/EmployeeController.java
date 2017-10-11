/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.aabu.springjpa.jsfbeans;

import edu.aabu.springjpa.model.Employee;
import edu.aabu.springjpa.service.EmployeeService;
import java.io.Serializable;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author heba
 */
@ManagedBean(name = "empCont")
@SessionScoped
public class EmployeeController implements Serializable{

    //@Autowired
    @ManagedProperty("#{employeeService}")
    private EmployeeService employeeService;
    private List<Employee> employees;

    public EmployeeController() {
    }

    public List<Employee> getEmployees() {
        System.out.println("------------------------> (employees == null) = " + (employees == null));
        if (employees != null) {
            System.out.println("------------------------> (employees.size) = " + (employees.size()));
            for (Employee employee : employees) {
                System.out.println("\t\t\t" + employee);
            }
            System.out.println("------------------------> (employees) = " + (employees.size()));
        }
        System.out.println("<----------------------  [befor] -----------------------------> ");
        System.out.println("------------------------> (employeeService) = " + (employeeService==null));

        //if (employees == null) {
        employees = employeeService.getAllEmployees();
        //}
        System.out.println("<----------------------  [after] -----------------------------> ");
        if (employees != null) {

            System.out.println("------------------------> (employees == null) = " + (employees == null));
            System.out.println("------------------------> (employees.size) = " + (employees.size()));
            for (Employee employee : employees) {
                System.out.println("\t\t\t" + employee);
            }
            System.out.println("------------------------> (employees) = " + (employees.size()));
        }
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }


    public EmployeeService getEmployeeService() {
        System.out.println("getting employeeService is called isNull -------------->" + (employeeService == null));
        return employeeService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        System.out.println("setting employeeService is called isNull -------------->" + (employeeService == null));
        this.employeeService = employeeService;
    }

}
