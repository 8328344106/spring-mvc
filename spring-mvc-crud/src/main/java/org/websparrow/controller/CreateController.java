package org.websparrow.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.websparrow.dao.StudentDao;
import org.websparrow.model.Employee;

@Controller
public class CreateController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createStudent(@RequestParam("employeeName") String name, @RequestParam("employeeDepartment") String department,
			@RequestParam("employeeDesignation") String designation,@RequestParam("employeeSalary") int salary, ModelAndView mv) {

		Employee student = new Employee();
		student.setEmployeeName(name);
		student.setEmployeeDepartment(department);
		student.setEmployeeDesignation(designation);
		student.setEmployeeSalary(salary);
		System.out.println(student);
		int counter = studentDao.create(student);

		if (counter > 0) {
			mv.addObject("msg", "Student registration successful.");
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("create");

		return mv;
	}
}
