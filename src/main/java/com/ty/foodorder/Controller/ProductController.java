package com.ty.foodorder.Controller;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Controller ;
import org.springframework.web.bind.annotation.ModelAttribute ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestParam ;
import org.springframework.web.servlet.ModelAndView ;

import com.ty.foodorder.DTO.ProductDTO ;
import com.ty.foodorder.Service.ProductService ;

@Controller
public class ProductController
{
	@Autowired
	ProductService productService;
	
	@RequestMapping("/loadProduct")
	public ModelAndView loadUser()
	{
		ModelAndView modelAndView=new ModelAndView ("addProduct.jsp");
		ProductDTO productDTO=new ProductDTO ( );
		modelAndView.addObject ( "productDTO",productDTO );
		return modelAndView;
	}

	@RequestMapping("/saveProduct")
	public ModelAndView saveUser(@ModelAttribute ProductDTO productDTO )
	{
		ProductDTO product=productService.addProduct ( productDTO );
		if(product!=null)
		{
			ModelAndView modelAndView=new ModelAndView ("home.jsp");
			modelAndView.addObject ( "msg","Product Added Successfully" );
			return modelAndView;
		}
		ModelAndView modelAndView=new ModelAndView ("addProduct.jsp");
		modelAndView.addObject ( "msg","Error Adding Product" );
		return modelAndView;
	}
	
	@RequestMapping("/productList")
	public ModelAndView productList()
	{
		List < ProductDTO > products = productService.fetchallproduct ( );

		ModelAndView modelAndView=new ModelAndView ("productlist.jsp");
		modelAndView.addObject ( "products",products );
		return modelAndView ;
	}
	
	@RequestMapping("/deleteProduct")
	public ModelAndView deleteProduct(@RequestParam int Id)
	{
		productService.deleteProduct ( Id );
		ModelAndView modelAndView=new ModelAndView ("/productList");
		modelAndView.addObject ( "msg","Data removed Successfully");
		return modelAndView;
	}
	
	@RequestMapping("/updateProduct")
	public ModelAndView updateProduct(@RequestParam int Id)
	{
		ProductDTO productDTO=productService.searchProduct ( Id );
		ModelAndView modelAndView=new ModelAndView ("updateProduct.jsp");
		modelAndView.addObject ( "product",productDTO);
		return modelAndView;
	}
	
	@RequestMapping("/updateproduct1")
	public ModelAndView updateproduct1(@ModelAttribute ProductDTO productDTO)
	{
		productService.updateProduct ( productDTO );
		ModelAndView modelAndView=new ModelAndView ("/productList");
		modelAndView.addObject ( "msg","Data Updated Successfully");
		return modelAndView;
	}
}
