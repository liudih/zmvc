package com.learn.controller;

import java.util.List;
import java.util.logging.Logger;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.learn.dao.UserMapper;
import com.learn.entity.User;
import com.learn.service.IUserService;
import com.learn.utils.DebugOut;

@Controller
public class HelloController {
	
	@Autowired
	IUserService userService;
	@Resource
	private UserMapper userMapper;
	
	@RequestMapping("/hello")
	public ModelAndView hello() {

		ModelMap mm = new ModelMap();
		ModelAndView mv = new ModelAndView();
		mv.addObject("spring", "spring mvc");
		mv.setViewName("hello");
		User u = userService.getUserById(1);
		System.out.println("+++++"+u.getUserName());
		return mv;
	}
	
	@RequestMapping(value="/owners/{ownerId}", method=RequestMethod.GET)
	public String findOwner(@PathVariable Integer ownerId, Model model, 
			@RequestParam(value = "lang") int languageid) {
		System.out.println("languageid="+languageid);
		User u = userService.getUserById(ownerId);
	    model.addAttribute("owner", u.getUserName());
//	    List<User> ulist = userService.getAllUsers();
	    List<User> ulist = userMapper.selectAll();
	    for(User a: ulist){
	    	DebugOut.println("uname=="+a.getUserName());
	    }
	    model.addAttribute("list", ulist);
	    return "showUser";
	}
	
	@RequestMapping(value="/json", method=RequestMethod.GET)
	@ResponseBody
	public Object getjsontesta(){
		User u = userService.getUserById(1);
		AbstractPdfView a = null;
		return u;
	}
	
	@RequestMapping("/red")
	public String userLogin(Model model) {
		return "redirect:/owners/1?lang=1";
	}
	
	@RequestMapping(value="/test", method = RequestMethod.GET, params="myParam=myValue",
			consumes="application/json", produces="application/json",
			headers="Referer=http://www.ifeng.com/")
	public String test(Model model) {
		return "redirect:/owners/1?lang=1";
	}
	
	@RequestMapping("/free")
	public String free(Model model) {
		String word0 = "Hello ";
		String word1 = "World!";
		//將數據添加到視圖數據容器中
		model.addAttribute("word0",word0);
		model.addAttribute("word1",word1);
		return "hello";
	}

}