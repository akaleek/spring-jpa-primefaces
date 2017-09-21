/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import edu.aabu.springjpa.model.Employee;
import edu.aabu.springjpa.service.EmployeeService;
import java.util.Arrays;
import java.util.List;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

/**
 *
 * @author heba
 */
public class CrudTest {
    public static void main(String[] args) {
        ApplicationContext app = new FileSystemXmlApplicationContext("C:\\Users\\heba\\Documents\\NetBeansProjects\\springjpa\\src\\main\\webapp\\WEB-INF\\applicationContext.xml");
        EmployeeService bean = app.getBean("employeeService", EmployeeService.class);
        List<Employee> allEmployees = bean.getAllEmployees();
        for (Employee allEmployee : allEmployees) {
            System.out.println("allEmployee :" + allEmployee);
        }
    }
}
