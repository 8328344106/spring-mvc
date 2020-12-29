package org.Question4.controller;

import org.Question4.Dao.UserDao;
import org.Question4.Model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	@Autowired
	private UserDao studentDao;

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView Userlogin(@ModelAttribute("userlog") User user,ModelAndView mv)
	{
		User student = new User();
		student.setUsername(user.getUsername());
		student.setPassword(user.getPassword());

		boolean counter = studentDao.userlogin(student);
		if(counter == true)
		{
			mv.setViewName("error");
		}
		else
		{
			mv.setViewName("success");
		}
		return mv;
	}

}
