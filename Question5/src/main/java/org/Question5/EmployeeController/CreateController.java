package org.Question5.EmployeeController;

import org.Question5.Dao.EmployeeDao;
import org.Question5.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateController {

	@Autowired
	private EmployeeDao studentDao;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createStudent(@ModelAttribute("employee") Employee emp, ModelAndView mv) {

		Employee student = new Employee();
		System.out.println(emp.getEmployeeName());
		student.setEmployeeName(emp.getEmployeeName());
		student.setEmployeeDepartment(emp.getEmployeeDepartment());
		student.setEmployeeDesignation(emp.getEmployeeDesignation());
		student.setEmployeeSalary(emp.getEmployeeSalary());

		int counter = studentDao.create(student);

		if (counter > 0) {
			mv.addObject("msg", "Student registration successful.");
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("read");

		return mv;
	}
}
