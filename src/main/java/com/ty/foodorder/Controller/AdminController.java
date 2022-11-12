package com.ty.foodorder.Controller;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Controller ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestParam ;
import org.springframework.web.servlet.ModelAndView ;

import com.ty.foodorder.DTO.AdminDTO ;
import com.ty.foodorder.Service.AdminService ;

@Controller
public class AdminController
{
	@Autowired
AdminService adminService;

	@RequestMapping("/loginAdmin")
	public ModelAndView loginAdmin ( @RequestParam String email, @RequestParam String password)
	{
		AdminDTO admin = adminService.fetchAdmin ( 1 );
		if(email.equals ( admin.getEmail ( ) ) && password.equals ( admin.getPassword ( )))
				{
			ModelAndView modelAndView=new ModelAndView ( "home.jsp");
			modelAndView.addObject ( "msg","Login Successfull" );
			return modelAndView;
				}
			ModelAndView modelAndView=new ModelAndView ("index.jsp");
			modelAndView.addObject ( "msg","Invalid Login Credentials" );
			return modelAndView;	
	}
	
@RequestMapping("/addAdmin")
public ModelAndView addAdmin()
{		
	AdminDTO adminDTO=new AdminDTO ( );
	adminDTO.setEmail ( "admin" );
	adminDTO.setPassword ( "admin" );
	adminService.addAdmin ( adminDTO );
	
	ModelAndView modelAndView=new ModelAndView ("index.jsp");
	modelAndView.addObject ( "msg","Admin account Created Successfully" );
	return modelAndView;
}
}
