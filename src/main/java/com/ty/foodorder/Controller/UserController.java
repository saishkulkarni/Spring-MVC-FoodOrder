package com.ty.foodorder.Controller;

import java.util.List ;

import javax.servlet.http.HttpSession ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Controller ;
import org.springframework.web.bind.annotation.ModelAttribute ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestParam ;
import org.springframework.web.servlet.ModelAndView ;

import com.ty.foodorder.DTO.FoodOrderDTO ;
import com.ty.foodorder.DTO.UserDTO ;
import com.ty.foodorder.Service.UserService ;

@Controller
public class UserController
{
	@Autowired
	UserService userService;
	
	
@RequestMapping("/loadUser")
public ModelAndView loadUser()
{
	ModelAndView modelAndView=new ModelAndView ("addUser.jsp");
	UserDTO userDTO=new UserDTO ( );
	modelAndView.addObject ( "userDTO",userDTO );
	return modelAndView;
}

@RequestMapping("/saveUser")
public ModelAndView saveUser(@ModelAttribute UserDTO userDTO )
{
	
	UserDTO user = userService.addUser ( userDTO );
	if(user!=null)
	{
		ModelAndView modelAndView=new ModelAndView ("home.jsp");
		modelAndView.addObject ( "msg","Account Created Successfully" );
		return modelAndView;
	}
	ModelAndView modelAndView=new ModelAndView ("addUser.jsp");
	modelAndView.addObject ( "msg","Error Creating Account" );
	return modelAndView;
}
@RequestMapping("/loginUser")
public ModelAndView loginUser ( @RequestParam String email, @RequestParam String password,HttpSession httpSession)
{
	UserDTO user = userService.fetchbyuseremailid ( email , password );
	
	
	if(user!=null)
			{
		httpSession.setAttribute ( "user" , user );
		ModelAndView modelAndView=new ModelAndView ( "userNavigation.jsp");
		modelAndView.addObject ( "msg","Login Successfull" );
		return modelAndView;
			}
		ModelAndView modelAndView=new ModelAndView ("loginUser.jsp");
		modelAndView.addObject ( "msg","Invalid Login Credentials" );
		return modelAndView;	
}

@RequestMapping("/fetchallorder")
public ModelAndView fetchallorder(HttpSession httpSession)
{
	UserDTO user=(UserDTO)httpSession.getAttribute ( "user" );
	List < FoodOrderDTO > list3 = user.getFoodOrderDTO ( );
	ModelAndView modelAndView=new ModelAndView ("fetchallorder.jsp");
	modelAndView.addObject ( "list3",list3 );
	return modelAndView;
}

@RequestMapping("/userList")
public ModelAndView userList()
{
	List < UserDTO > users = userService.fetchallUser ( );

	ModelAndView modelAndView=new ModelAndView ("userlist.jsp");
	modelAndView.addObject ( "users",users );
	return modelAndView ;
}

@RequestMapping("/deleteUser")
public ModelAndView deleteUser(@RequestParam int Id)
{
	userService.deleteUser ( Id );
	ModelAndView modelAndView=new ModelAndView ("/userList");
	modelAndView.addObject ( "msg","Data removed Successfully");
	return modelAndView;
}

@RequestMapping("/updateUser")
public ModelAndView updateUser(@RequestParam int Id)
{
	UserDTO userDTO=userService.searchUser ( Id );
	ModelAndView modelAndView=new ModelAndView ("updateUser.jsp");
	modelAndView.addObject ( "user",userDTO);
	return modelAndView;
}

@RequestMapping("/updateuser1")
public ModelAndView updateuser1(@ModelAttribute UserDTO userDTO)
{
	userService.updateUser ( userDTO );
	ModelAndView modelAndView=new ModelAndView ("/userList");
	modelAndView.addObject ( "msg","Data Updated Successfully");
	return modelAndView;
}

@RequestMapping("/logout")
public ModelAndView logout(HttpSession httpSession)
{
	httpSession.invalidate ( );
	ModelAndView modelAndView=new ModelAndView ("home.jsp");
	modelAndView.addObject ( "msg","Logged Out Successfull");
	return modelAndView;
}

}
