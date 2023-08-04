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

	// 직원 등록
	@Override
	public void addEmployee(Employee e) {
		if(idx ==  MAX_CUSTOMERS) {
			System.out.println("더이상 직을 등록할 수 없습니다.");
			return;
		}
		emps[idx++] = e;

	}

	// 직원 삭제
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

	// 직원 상세정보 수정(manager)
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

	// 직원 상세정보 수정(engineer)
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

	// 이름으로 특정 직원 찾기
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

	// 같은 부서 내 직원들 찾기
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

	// 같은 기술을 보유한 직원들 찾기
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

	// 특정 직원 연봉 검색
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

	// 특정 연봉 이상의 사람들을 검색
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

	// print 관련
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

