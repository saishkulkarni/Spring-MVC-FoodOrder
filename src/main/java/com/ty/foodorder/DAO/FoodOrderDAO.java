package com.ty.foodorder.DAO;

import javax.persistence.EntityManager ;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.EntityTransaction ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;

import com.ty.foodorder.DTO.FoodOrderDTO ;

@Component
public class FoodOrderDAO
{

	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public FoodOrderDTO addFoodOrder(FoodOrderDTO foodOrderDTO)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		EntityTransaction entityTransaction=entityManager.getTransaction ( );
		
		entityTransaction.begin ( );
		entityManager.persist ( foodOrderDTO );
		entityTransaction.commit ( );
		return foodOrderDTO ;	
	} 
}
