package com.self.service.impl;

import com.self.service.EmployeeService;
import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeServiceImpl implements EmployeeService{
	public static final int MAX_CUSTOMERS = 100;
	Employee[] emps;
	int idx;

	public EmployeeServiceImpl(){
		emps = new Employee[MAX_CUSTOMERS];
	}

	// ���� ���
	@Override
	public void addEmployee(Employee e) {
		if(idx ==  MAX_CUSTOMERS) {
			System.out.println("���̻� ���� ����� �� �����ϴ�.");
			return;
		}
		emps[idx++] = e;

	}

	// ���� ����
	@Override
	public void deleteEmployee(String name) {
		for(int i=0; i<idx; i++) {
			if(emps[i].getName().equals(name)) {
				for(int j=i; j<idx; j++) {
					emps[j] = emps[j+1];
				}
				emps[idx] = null;
				idx--;
			}
		}
	}

	// ���� ������ ����(manager)
	@Override
	public void updateEmployee(double salary, String dept, int deptno, String name) {
		for(Employee e : emps) {
			if(e != null && e instanceof Manager) {
				if(e.getName().equals(name)) {
					e.changeSalary(salary);
					((Manager) e).setDept(dept);
					((Manager) e).setDeptno(deptno);
				}
			}
		}
	}

	// ���� ������ ����(engineer)
	@Override
	public void updateEmployee(double salary, String tech, double bonus,  String name) {
		for(Employee e : emps) {
			if(e != null && e instanceof Engineer) {
				if(e.getName().equals(name)) {
					e.changeSalary(salary);
					((Engineer) e).changeTech(tech);
					((Engineer) e).changeBonus(bonus);
				}
			}
		}

	}

	// �̸����� Ư�� ���� ã��
	@Override
	public Employee findEmployeeByName(String name) {
		Employee employee = null;
		for(Employee e : emps) {
			if(e == null) continue;
			if(e.getName().equals(name)) {
				employee = e;
				break;
			}
		}
		return employee;
	}

	// ���� �μ� �� ������ ã��
	@Override
	public Employee[] findEmployeeByDeptNo(int deptno) {
		Employee[] temp = new Employee[idx];
		int cnt = 0;
		for(Employee e : emps) {
			if(e == null) continue;
			if(e instanceof Manager) {
				if(((Manager) e).getDeptno()==deptno) {
					temp[cnt++] = e;
				}
			}
		}
		return temp;
	}

	// ���� ����� ������ ������ ã��
	@Override
	public Employee[] findEmployeeByTech(String tech) {
		Employee[] temp = new Employee[idx];
		int cnt = 0;
		for (Employee e : emps) {
			if(e == null) continue;
			if(e instanceof Engineer) {
				if(((Engineer) e).getTech().equalsIgnoreCase(tech)) {
					temp[cnt++] = e;
				}

			}
		}
		return temp;
	}

	// Ư�� ���� ���� �˻�
	@Override
	public double getAnnualSalary(String name) {
		double annualSalary = 0.0;
		for(Employee e : emps) {
			if (e==null) continue;
			if(e.getName().equals(name)) {
				annualSalary = e.getSalary() * 12;
				if(e instanceof Engineer) annualSalary += ((Engineer) e).getBonus();
			}
		}
		return annualSalary;
	}

	// Ư�� ���� �̻��� ������� �˻�
	@Override
	public Employee[] getAnnualSalaryMoreThan(double salary) {
		Employee[] temp = new Employee[idx];
		double annualSalary = 0.0;
		int cnt = 0;
		for(Employee e : emps) {
			if(e==null) continue;
			annualSalary = getAnnualSalary(e.getName());
			if(annualSalary >= salary) temp[cnt++] = e;
		}
		return temp;
	}

	// print ����
	@Override
	public void printAllEmployees() {
		for(Employee e : emps) {
			if(e!=null) System.out.println(e);
		}
	}

	@Override
	public void printManagers() {
		for(Employee e : emps) {
			if(e!=null && e instanceof Manager) System.out.println(e);
		}

	}

	@Override
	public void printEngineers() {
		for(Employee e : emps) {
			if(e!=null && e instanceof Engineer) System.out.println(e);
		}

	}
}

