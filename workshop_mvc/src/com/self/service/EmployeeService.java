package com.self.service;

import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public interface EmployeeService {

	void addEmployee(Employee e);

	void deleteEmployee(String name);

	void updateEmployee(double salary, String dept, int deptno,  String name);

	void updateEmployee(double salary, String tech, double bonus,  String name);

	Employee findEmployeeByName(String name);

	Employee[] findEmployeeByDeptNo(int deptno);

	Employee[] findEmployeeByTech(String tech);

	double getAnnualSalary(String name);

	Employee[] getAnnualSalaryMoreThan(double salary);

	void printAllEmployees();
	void printManagers();
	void printEngineers();


}

