package com.ty.foodorder.Controller;

import java.util.ArrayList ;
import java.util.List ;
import javax.servlet.http.HttpSession ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Controller ;
import org.springframework.web.bind.annotation.ModelAttribute ;
import org.springframework.web.bind.annotation.RequestMapping ;
import org.springframework.web.bind.annotation.RequestParam ;
import org.springframework.web.servlet.ModelAndView ;

import com.ty.foodorder.DTO.FoodOrderDTO ;
import com.ty.foodorder.DTO.ItemDTO ;
import com.ty.foodorder.DTO.ProductDTO ;
import com.ty.foodorder.DTO.UserDTO ;
import com.ty.foodorder.Service.FoodOrderService ;
import com.ty.foodorder.Service.ProductService ;
import com.ty.foodorder.Service.UserService ;

@Controller
public class FoodOrderController
{
@Autowired
FoodOrderService foodOrderService;

@Autowired
ProductService productService;

@Autowired
UserService userService;

@RequestMapping("/foodOrder1")
public ModelAndView loadFoodOrder()
{
ModelAndView modelAndView=new ModelAndView ("foodOrder.jsp");
modelAndView.addObject ( "foodOrder",new FoodOrderDTO ( ) );
return modelAndView;
}

@RequestMapping("/foodOrder2")
public ModelAndView saveFoodOrder(@ModelAttribute FoodOrderDTO foodOrder,HttpSession httpSession)
{	
		httpSession.setAttribute ( "foodOrder" , foodOrder );
		httpSession.setAttribute ( "list" , new ArrayList<ItemDTO>( ));
		
		ModelAndView modelAndView=new ModelAndView ("menu");
		return modelAndView;
}

@RequestMapping("/menu")
public ModelAndView getmenu()
{
		List < ProductDTO > products = productService.fetchallproduct ( );
		
		ModelAndView modelAndView=new ModelAndView ("menu.jsp");
		modelAndView.addObject ( "products",products );
		return modelAndView;
}

@RequestMapping("/addOrder")
public ModelAndView addOrder(@RequestParam int Id,@ModelAttribute ModelAndView msg )
{
	ProductDTO product = productService.searchProduct ( Id );
	ItemDTO itemDTO=new ItemDTO ( );
	itemDTO.setName ( product.getName ( ) );
	itemDTO.setCost ( product.getCost ( ) );
	ModelAndView modelAndView=new ModelAndView ("addOrder.jsp");
	modelAndView.addObject ( "item",itemDTO);
	modelAndView.addObject ( "msg",msg );
	return modelAndView;
}

@RequestMapping("/addItem")
public ModelAndView addItem(@ModelAttribute ItemDTO itemDTO,HttpSession httpSession)
{
	FoodOrderDTO foodOrder = (FoodOrderDTO)httpSession.getAttribute ( "foodOrder" );
	itemDTO.setFoodOrderDTO ( foodOrder );
	itemDTO.setCost ( itemDTO.getCost ( )*itemDTO.getQuantity ( ) );

	foodOrder.setCost ( foodOrder.getCost ( )+itemDTO.getCost ( ) );
	
	@ SuppressWarnings ( "unchecked" )
	List< ItemDTO > lists = (ArrayList <ItemDTO>)httpSession.getAttribute ( "list" );
	lists.add ( itemDTO );
	
	ModelAndView modelAndView=new ModelAndView ("/menu");
	modelAndView.addObject ( "msg","Item Added" );
	return modelAndView;
}

@RequestMapping("/submitOrder")
public ModelAndView submitOrder(HttpSession httpSession)
{
	@ SuppressWarnings ( "unchecked" )
	List< ItemDTO > lists = (ArrayList <ItemDTO>)httpSession.getAttribute ( "list" );
	
	FoodOrderDTO foodOrder = (FoodOrderDTO)httpSession.getAttribute ( "foodOrder" );
	foodOrder.setItemDTOs ( lists );
	
	UserDTO userDTO=(UserDTO)httpSession.getAttribute( "user" );
	
	foodOrder.setUserDTO ( userDTO );
	
	List<FoodOrderDTO> list1=new ArrayList<FoodOrderDTO> ( );
	list1.add ( foodOrder );
	
	userDTO.setFoodOrderDTO ( list1 );
	
	userService.updateUser ( userDTO );
	
	ModelAndView modelAndView=new ModelAndView ("generatebill");
	modelAndView.addObject ( "msg","Order Placed" );
	return modelAndView;	
}

@RequestMapping("/generatebill")
public ModelAndView generatebill(HttpSession httpSession)
{
	FoodOrderDTO foodOrderDTO=( FoodOrderDTO ) httpSession.getAttribute ( "foodOrder" );
	ModelAndView modelAndView=new ModelAndView ("bill.jsp" );
	modelAndView.addObject ( "foodOrder",foodOrderDTO );
	return modelAndView;
}

}
