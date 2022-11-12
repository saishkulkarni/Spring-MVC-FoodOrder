package com.ty.foodorder.DAO;

import javax.persistence.EntityManager ;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.EntityTransaction ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;

import com.ty.foodorder.DTO.AdminDTO ;

@Component
public class AdminDAO
{
	@Autowired
EntityManagerFactory entityManagerFactory;

public void addAdmin(AdminDTO adminDTO)
{
	EntityManager entityManager=entityManagerFactory.createEntityManager ( );
	EntityTransaction entityTransaction=entityManager.getTransaction ( );
	
	entityTransaction.begin ( );
	entityManager.persist ( adminDTO );
	entityTransaction.commit ( );	
}

public AdminDTO fetchAdmin(int id)
{
	EntityManager entityManager=entityManagerFactory.createEntityManager ( );
	
	return entityManager.find ( AdminDTO.class , id );
	
}

}
