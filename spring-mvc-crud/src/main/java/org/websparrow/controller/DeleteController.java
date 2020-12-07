package org.websparrow.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.websparrow.dao.StudentDao;

@Controller
public class DeleteController {

	@Autowired
	private StudentDao studentDao;

	@RequestMapping(value = "/delete/{employeeId}")
	public ModelAndView deleteStudentById(ModelAndView mv, @PathVariable("employeeId") int studentId)
			throws IOException {

		int counter = studentDao.delete(studentId);

		if (counter > 0) {
			mv.addObject("msg", "Student records deleted against student id: " + studentId);
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("delete");

		return mv;
	}

}
