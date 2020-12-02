package org.Question4.controller;

import org.Question4.Dao.UserDao;
import org.Question4.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CreateController {

	@Autowired
	private UserDao studentDao;

	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public ModelAndView createStudent(@RequestParam("username") String name, @RequestParam("email") String email,
			@RequestParam("password") String course, ModelAndView mv) {

		User student = new User();
		student.setUsername(name);
		student.setEmail(email);
		student.setPassword(course);

		int counter = studentDao.create(student);

		if (counter > 0) {
			mv.addObject("msg", "User registration successful.");
		} else {
			mv.addObject("msg", "Error- check the console log.");
		}

		mv.setViewName("login");

		return mv;
	}
}
