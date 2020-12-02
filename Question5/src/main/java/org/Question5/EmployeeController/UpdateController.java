package org.Question5.EmployeeController;

import java.io.IOException;
import java.util.List;

import org.Question5.Dao.EmployeeDao;
import org.Question5.Model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class UpdateController {

	@Autowired
	private EmployeeDao studentDao;

	@RequestMapping(value = "/update/{studentId}")
	public ModelAndView findStudentById(ModelAndView model, @PathVariable("studentId") int studentId)
			throws IOException {

		List<Employee> listStudent = studentDao.findStudentById(studentId);
		model.addObject("listStudent", listStudent);
		model.setViewName("update");

		return model;
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public ModelAndView updateStudent(@ModelAttribute("employee") Employee emp, ModelAndView mv) {

		Employee student = new Employee();
		student.setEmployeeId(emp.getEmployeeId());
		student.setEmployeeName(emp.getEmployeeName());
		student.setEmployeeDepartment(emp.getEmployeeDepartment());
		student.setEmployeeDesignation(emp.getEmployeeDesignation());
		student.setEmployeeSalary(emp.getEmployeeSalary());

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
