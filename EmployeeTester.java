package com.capgemini.jpa.presentation;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import com.capgemini.jpa.entity.Employee;
import com.capgemini.jpa.exception.EmployeeException;
import com.capgemini.jpa.service.EmployeeServiceImpl;
import com.capgemini.jpa.service.IEmployeeService;

public class EmployeeTester {
	private static IEmployeeService employeeService=new EmployeeServiceImpl();
	
	public static void main(String[] args) throws EmployeeException {
		Integer empid;
		
	while(true)
	{
		System.out.println("1.Add Employee ");
		System.out.println("2.Delete Employee");
		System.out.println("3.Update Employee");
		System.out.println("4.Get employee details");
		System.out.println("5.Get all employee details");
		System.out.println("6.Exit");
		//accept choice
		Scanner sc=new Scanner(System.in);
		int option=sc.nextInt();
		switch(option)
		{
		case 1:
			Employee employee=new Employee(8000,"vinoth",new GregorianCalendar(2018,8,15),"Manager",55750.0,10);
			addNewEmployee(employee);
			break;
		case 2:
			System.out.println("\n Enter employee id");
			empid=sc.nextInt();
			deleteEmployee(empid);
			break;
		case 3:
			Employee employee1=new Employee(7000,"XXXXXXX",new GregorianCalendar(2016,8,15),"analyst",45750.0,20);
			updateEmployee(employee1);
			break;
		case 4:
			System.out.println("\n Enter employee id");
			empid=sc.nextInt();
			employee=employeeService.getEmployeeDetails(empid);
			employeeService.updateEmployee(employee);
			getEmployeeDetails(empid);
			break;
		case 5:
			List<Employee> employeeList=employeeService.getAllEmployees();
			showemployees(employeeList);
			getAllEmployees();
			break;
		case 8:
			System.out.print("Exit Employee management System");
			System.exit(0);					
		default:
			System.out.println("Enter a valid option[1-5]");
		}
		
	}
	}
	private static void showemployees(List<Employee> employeeList) {
		Iterator<Employee>iterator=employeeList.iterator();
		while(iterator.hasNext())
		{
			System.out.println(iterator.next());
		}
		
	}

	private static void getAllEmployees() {
		try {
			
			employeeService.getAllEmployees();
			
		} catch (EmployeeException e) {			
			e.printStackTrace();
		}
		
		
	}

	private static void getEmployeeDetails(int empid) {
		try {
			employeeService.getEmployeeDetails(empid);
		} catch (EmployeeException e) {			
			e.printStackTrace();
		}
		
		
	}



	private static void deleteEmployee(Integer empid) {
		try {
			employeeService.deleteEmployee(empid);
		} catch (EmployeeException e) {			
			e.printStackTrace();
		}
		
		
	}



	private static void updateEmployee(Employee employee) {
		try {
			employeeService.updateEmployee(employee);
		} catch (EmployeeException e) {			
			e.printStackTrace();
		}
		
		
	}



	private static void addNewEmployee(Employee employee) {
		try {
			employeeService.addNewEmployee(employee);
		} catch (EmployeeException e) {			
			e.printStackTrace();
		}
		
	}
	

}
