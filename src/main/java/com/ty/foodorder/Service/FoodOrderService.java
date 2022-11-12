package com.ty.foodorder.Service;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;

import com.ty.foodorder.DAO.FoodOrderDAO ;
import com.ty.foodorder.DTO.FoodOrderDTO ;

@Component
public class FoodOrderService
{
	@Autowired
FoodOrderDAO foodOrderDAO;
	
	public FoodOrderDTO addProduct(FoodOrderDTO foodOrderDTO)
	{
		return foodOrderDAO.addFoodOrder ( foodOrderDTO );
	}
}
