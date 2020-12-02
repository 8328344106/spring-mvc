package org.Question4.controller;

import java.io.IOException;
import java.util.List;

import org.Question4.Dao.UserDao;
import org.Question4.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class ReadController {

	@Autowired
	private UserDao studentDao;

	@RequestMapping(value = "/read")
	public ModelAndView readStudent(ModelAndView model) throws IOException {

		List<User> listStudent = studentDao.read();
		model.addObject("listStudent", listStudent);
		model.setViewName("read");

		return model;
	}
}
