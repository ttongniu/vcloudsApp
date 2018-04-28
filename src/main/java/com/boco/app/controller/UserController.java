package com.boco.app.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import com.boco.app.model.User1;
import com.boco.app.service.UserService;
@Controller
@RequestMapping("/user")
public class UserController  {
	  private Logger logger=LoggerFactory.getLogger(this.getClass());
	 @Autowired
     private UserService userService;
     
	 @RequestMapping("/meetingGroupList1")
     public String meetingGroupList(){
		return "index";
     }    
     @RequestMapping("/login")
     public String login (HttpServletRequest request){
    	User1 user=new User1();
    	user.setUserName("jeff");
    	user.setPassword("jeff");
   	  User1 resultUser=userService.login(user);
   	  if(resultUser==null){
   		  //request.setAttribute("user", user);
   		  request.setAttribute("errorMsg", "用户名或密码错误！");
   		  return "index";
   	  }else{
   		HttpSession session=  request.getSession();
   		session.setAttribute("currentUser", resultUser);
   		return "redirect:/view/success.jsp";
   	  }
     }     
}
