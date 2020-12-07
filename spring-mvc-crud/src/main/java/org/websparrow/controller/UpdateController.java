package org.websparrow.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.websparrow.dao.StudentDao;
import org.websparrow.model.Employee;

@Controller
public class UpdateController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/update/{employeeId}")
	public ModelAndView findStudentById(ModelAndView model, @PathVariable("employeeId") int studentId)
			throws IOException {

		List<Employee> listStudent = studentDao.findStudentById(studentId);
		model.addObject("listStudent", listStudent);
		model.setViewName("update");

		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateStudent(@RequestParam("employeeId") int id, @RequestParam("employeeName") String name,
			@RequestParam("employeeDepartment") String dept, @RequestParam("employeeDesignation") String designation,
			@RequestParam("employeeSalary") int salary, ModelAndView mv) {

		Employee student = new Employee();
		student.setEmployeeId(id);
		student.setEmployeeName(name);
		student.setEmployeeDepartment(dept);
		student.setEmployeeDesignation(designation);
		student.setEmployeeSalary(salary);

		int counter = studentDao.update(student);

		if (counter > 0) {
			mv.addObject("msg", "Student records updated against student id: " + student.getEmployeeId());
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("update");

		return mv;
	}
}
