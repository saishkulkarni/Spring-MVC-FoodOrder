package com.ty.foodorder.DAO;

import java.util.List ;

import javax.persistence.EntityManager ;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.EntityTransaction ;
import javax.persistence.Query ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;

import com.ty.foodorder.DTO.ProductDTO ;

@Component
public class ProductDAO
{
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public ProductDTO addProduct(ProductDTO productDTO)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		EntityTransaction entityTransaction=entityManager.getTransaction ( );
		
		entityTransaction.begin ( );
		entityManager.persist ( productDTO );
		entityTransaction.commit ( );
		return productDTO ;	
	}
	
	public List < ProductDTO > fetchallproduct ( )
	{

		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		Query query = entityManager.createQuery ( "select s from ProductDTO s",ProductDTO.class );
		List<ProductDTO> productDTOs = query.getResultList ( );
		return productDTOs;
	}
	
	public void deleteProduct(int id)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		EntityTransaction entityTransaction=entityManager.getTransaction ( );
		
		ProductDTO product = entityManager.find ( ProductDTO.class , id );
		entityTransaction.begin ( );
		entityManager.remove ( product );
		entityTransaction.commit ( );
	}

	public void updateProduct ( ProductDTO productDTO )
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		EntityTransaction entityTransaction=entityManager.getTransaction ( );
		
		entityTransaction.begin ( );
		entityManager.merge ( productDTO );
		entityTransaction.commit ( );
	}
	
	public ProductDTO searchProduct(int id)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		return	entityManager.find ( ProductDTO.class , id );
	}
}
