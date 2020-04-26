package com.cognizant.ormlearn;

import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.ormlearn.model.Attempt;
import com.cognizant.ormlearn.model.AttemptOption;
import com.cognizant.ormlearn.model.AttemptQuestion;
import com.cognizant.ormlearn.model.Country;
import com.cognizant.ormlearn.model.Department;
import com.cognizant.ormlearn.model.Employee;
import com.cognizant.ormlearn.model.Options;
import com.cognizant.ormlearn.model.Skill;
import com.cognizant.ormlearn.model.Stock;
import com.cognizant.ormlearn.service.AttemptService;
import com.cognizant.ormlearn.service.CountryNotFoundException;
import com.cognizant.ormlearn.service.CountryService;
import com.cognizant.ormlearn.service.DepartmentService;
import com.cognizant.ormlearn.service.EmployeeService;
import com.cognizant.ormlearn.service.SkillService;
import com.cognizant.ormlearn.service.StockService;

@SpringBootApplication
public class OrmLearnApplication {
	private static CountryService countryService;
	private static StockService stockService;
	private static EmployeeService employeeService;
	private static DepartmentService departmentService;
	private static SkillService skillService;
	private static AttemptService attemptService;
	private static final Logger LOGGER = LoggerFactory.getLogger(OrmLearnApplication.class);

	public static void main(String[] args) throws CountryNotFoundException {
		ApplicationContext context = SpringApplication.run(OrmLearnApplication.class, args);
		stockService = context.getBean(StockService.class);
		countryService = context.getBean(CountryService.class);
		employeeService = context.getBean(EmployeeService.class);
		departmentService = context.getBean(DepartmentService.class);
		skillService = context.getBean(SkillService.class);
		attemptService = context.getBean(AttemptService.class);
		LOGGER.info("Inside main");
//		testGetAllCountries();
//		testAddCountry();
//		testFindByCode();
//		testUpdateCountry();
//		testDeleteCountry();
//		testFindByOrderBy();
//		testFindByOrderByAlpha();
//		testFindAllTillSep();
//		testFindGoogle1250();
//		testFindTop3ByOrderByVolumeDesc();
//		testFindTop3ByCodeOrderByClose();
//		testSaveEmployee();
//		testGetEmployee();
//		testUpdateEmployee();
//		testGetDepartment();
//		testAddSkillToEmployee();
//		testGetEmployee();
//		testGetAverageSalary();
//		testGetAverageSalaryParam();
//		testGetAllEmployee();
		testAttemptServiceGetAttempt();
	}

	private static void testGetAllCountries() {
		LOGGER.info("Start");
		List<Country> countries = countryService.getAllCountries();
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void testFindByCode() throws CountryNotFoundException {
		LOGGER.info("Start");
		Country country = countryService.findCountryByCode("AV");
		LOGGER.debug("Country:{}", country);
		LOGGER.info("End");
	}

	private static void testAddCountry() {
		LOGGER.info("Start");
		Country country = new Country();
		country.setCode("AV");
		country.setName("Avik Sarkar");
		countryService.addCountry(country);
		LOGGER.info("End");
	}

	private static void testUpdateCountry() throws CountryNotFoundException {
		LOGGER.info("Start");
		countryService.updateCountry("AV", "AVIK");
		countryService.findCountryByCode("AV");
		LOGGER.info("End");
	}

	private static void testDeleteCountry() {
		LOGGER.info("Start");
		countryService.deleteCountry("AV");
		LOGGER.info("End");
	}

	private static void testFindByOrderBy() {
		LOGGER.info("Start");
		List<Country> countries = countryService.findByNameOrderBy("ou");
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void testFindByOrderByAlpha() {
		LOGGER.info("Start");
		List<Country> countries = countryService.findByAlphaOrderBy("Z");
		LOGGER.debug("countries={}", countries);
		LOGGER.info("End");
	}

	private static void testFindAllTillSep() {
		LOGGER.info("Start");
		List<Stock> findAllTillSep = stockService.findAllTillSep();
		LOGGER.debug("stocks={}", findAllTillSep);
		LOGGER.info("End");
	}

	private static void testFindGoogle1250() {
		LOGGER.info("Start");
		List<Stock> findGoogle1250 = stockService.findGoogle1250();
		LOGGER.debug("stocks={}", findGoogle1250);
		LOGGER.info("End");
	}

	private static void testFindTop3ByOrderByVolumeDesc() {
		LOGGER.info("Start");
		List<Stock> findTop3ByOrderByVolumeDesc = stockService.findTop3ByOrderByVolumeDesc();
		LOGGER.debug("stocks={}", findTop3ByOrderByVolumeDesc);
		LOGGER.info("End");
	}

	private static void testFindTop3ByCodeOrderByClose() {
		LOGGER.info("Start");
		List<Stock> findTop3ByCodeOrderByClose = stockService.findTop3ByCodeOrderByClose("FB");
		LOGGER.debug("stocks={}", findTop3ByCodeOrderByClose);
		LOGGER.info("End");
	}

	private static void testGetEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.debug("Skills:{}", employee.getSkillList());
		LOGGER.info("End");
	}

	private static void testSaveEmployee() {
		LOGGER.info("Start");
		Department department = departmentService.get(1);
		Employee employee = new Employee();
		employee.setName("Avik");
		employee.setPermanent(true);
		employee.setDateOfBirth(new Date());
		employee.setSalary(10.02);
		employee.setDepartment(department);
		employeeService.save(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
	}

	private static void testUpdateEmployee() {
		LOGGER.info("Start");
		Department department = departmentService.get(1);
		Employee employee = employeeService.get(1);
		employee.setName("AvikSarkar");
		employee.setPermanent(true);
		employee.setDateOfBirth(new Date());
		employee.setSalary(10.02);
		employee.setDepartment(department);
		employeeService.update(employee);
		LOGGER.debug("Employee:{}", employee);
		LOGGER.debug("Department:{}", employee.getDepartment());
		LOGGER.info("End");
	}

	private static void testGetDepartment() {
		LOGGER.info("Start");
		Department department = departmentService.get(1);
		LOGGER.debug("Department:{}", department);
		LOGGER.debug("Department:{}", department.getEmployeeList());
		LOGGER.info("End");
	}

	private static void testAddSkillToEmployee() {
		LOGGER.info("Start");
		Employee employee = employeeService.get(1);
		Skill skill = skillService.get(3);
		Set<Skill> skillList = employee.getSkillList();
		skillList.add(skill);
		employee.setSkillList(skillList);
		System.out.println(employee.getSkillList());
		employeeService.save(employee);
		LOGGER.info("End");
	}

	public static void testGetAllPermanentEmployees() {
		LOGGER.info("Start");
		List<Employee> employees = employeeService.testGetAllPermanentEmployees();
		LOGGER.debug("Permanent Employees:{}", employees);
		employees.forEach(e -> LOGGER.debug("Skills:{}", e.getSkillList()));
		LOGGER.info("End");
	}

	public static void testAttemptServiceGetAttempt() {
//		LOGGER.info("Start");
//		Attempt attempt = attemptService.getAttempt(1, 1);
//		LOGGER.debug("Attempt:{}", attempt);
//		Set<AttemptQuestion> attemptQuestionList = attempt.getAttemptQuestionList();
//		LOGGER.debug("AttemptQuestions:{}", attemptQuestionList);
//		for(AttemptQuestion at : attemptQuestionList) {
//			LOGGER.debug("AttemptQuestions:{}", at.getAttemptOptionList());
//		}
//		for(AttemptQuestion at : attemptQuestionList) {
//			System.out.println(at);
//		}
//		LOGGER.info("End");
		Attempt attempt = attemptService.getAttempt(1, 1);
		Set<AttemptQuestion> attemptQuestionList = attempt.getAttemptQuestionList();
		for (AttemptQuestion i : attemptQuestionList) {
			int k = 0;
			System.out.println(i.getQuestion().getText());
			Set<Options> optionL = i.getQuestion().getOptionsList();
			for (Options o : optionL) {
				System.out.println(++k + ") " + o.getText() + "\t" + o.getScore() + "\t");
			}
		}
	}

	public static void testGetAverageSalary() {
		LOGGER.info("Start");
		double testGetAverageSalary = employeeService.testGetAverageSalary();
		LOGGER.debug("Salary:{}", testGetAverageSalary);
		LOGGER.info("End");
	}

	public static void testGetAverageSalaryParam() {
		LOGGER.info("Start");
		double testGetAverageSalaryParam = employeeService.testGetAverageSalaryParam();
		LOGGER.debug("Salary:{}", testGetAverageSalaryParam);
		LOGGER.info("End");
	}

	private static void testGetAllEmployee() {
		LOGGER.info("Start");
		List<Employee> employee = employeeService.testGetAllEmployee();
		LOGGER.debug("Employee:{}", employee);
		LOGGER.info("End");
	}
}
