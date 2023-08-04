package com.self.test;

import com.self.service.EmployeeService;
import com.self.service.impl.EmployeeServiceImpl;
import com.self.util.MyDate;
import com.self.vo.Employee;
import com.self.vo.Engineer;
import com.self.vo.Manager;

public class EmployeeServiceTest {
	public static void main(String[] args) {
		//1. Service ��ü�� ����
		EmployeeService service = new EmployeeServiceImpl();

		//2. method�� ���� ȣ��..
		System.out.println("============ 1. addEmployee(Manager) ============ ");
		service.addEmployee(new Manager("AAA", new MyDate(1978, 1, 1), 20000.0, "���ߺ�", 10));
		service.addEmployee(new Manager("BBB", new MyDate(1975, 2, 1), 34000.0, "��ȹ��", 20));
		service.addEmployee(new Manager("CCC", new MyDate(1980, 3, 3), 20000.0, "������", 30));
		service.addEmployee(new Manager("DDD", new MyDate(1995, 8, 1), 37000.0, "���ߺ�", 10));

		System.out.println("============ Manager ����Ȯ�� ============ ");
		service.printManagers();

		System.out.println("\n============ 1. addEmployee(Engineer) ============ ");
		service.addEmployee(new Engineer("EEE", new MyDate(1995,3,4), 350000.0, "Java", 200.0));
		service.addEmployee(new Engineer("FFF", new MyDate(1995,7,2), 350000.0, "Java", 200.0));
		service.addEmployee(new Engineer("GGG", new MyDate(1994,11,2), 450000.0, "Python", 300.0));

		System.out.println("============ Engineer ����Ȯ�� ============ ");
		service.printEngineers();

		System.out.println("\n============ 2. deleteEmployee(AAA ����) ============ ");
		service.deleteEmployee("AAA");

		System.out.println("============ ��� Employee ����Ȯ�� ============ ");
		service.printAllEmployees();

		System.out.println("\n============ 3. updateEmployee(CCC ���� ���� 200->350) ============ ");

		service.updateEmployee(35000.0, "������", 30,  "CCC");
		System.out.println("============ Manager ����Ȯ�� ============ ");
		service.printManagers();

		System.out.println("\n============ 3. updateEmployee(FFF ���ʽ� ���� 200->400) ============ ");

		service.updateEmployee(35000.0, "Java", 400.0,  "FFF");
		System.out.println("============ Engineer ����Ȯ�� ============ ");
		service.printEngineers();

		System.out.println("\n============ 4. findEmployeeByName(BBB) ============ ");
		Employee retE1=service.findEmployeeByName("BBB");
		System.out.println(retE1);

		System.out.println("\n============ 4. findEmployeeByDeptNo(10) ============ ");
		System.out.println("10�� �μ��� �ٹ��ϴ� ������ �Դϴ�..");
		Employee[ ] retEs1 = service.findEmployeeByDeptNo(10);
		for(Employee e : retEs1) {
			if(e==null) continue;
			System.out.println(e);
		}

		System.out.println("\n============ 4. findEmployeeByTech(JAVA) ============ ");
		System.out.println("JAVA ����� ������ �������Դϴ�");
		Employee[ ] e1 = service.findEmployeeByTech("JAVA");
		for(Employee e : e1) {
			if(e==null) continue;
			System.out.println(e);
		}

		System.out.println("\n============ 5. getAnnualSalaryMoreThan(4000000.0) ============ ");
		System.out.println("������ 400���� �̻��� �������Դϴ�.");
		Employee[] emps = service.getAnnualSalaryMoreThan(4000000.0);
		for(Employee e : emps) {
			if(e==null) continue;
			System.out.println(e);
		}
	}
}







