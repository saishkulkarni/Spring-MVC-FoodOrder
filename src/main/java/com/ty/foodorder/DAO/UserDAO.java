package com.ty.foodorder.DAO;

import java.util.List ;

import javax.persistence.EntityManager ;
import javax.persistence.EntityManagerFactory ;
import javax.persistence.EntityTransaction ;
import javax.persistence.Query ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;

import com.ty.foodorder.DTO.UserDTO ;

@Component
public class UserDAO
{
	@Autowired
	EntityManagerFactory entityManagerFactory;
	
	public UserDTO addUser(UserDTO userDTO)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		EntityTransaction entityTransaction=entityManager.getTransaction ( );
		
		entityTransaction.begin ( );
		entityManager.persist ( userDTO );
		entityTransaction.commit ( );
		return userDTO ;	
	}
	
	public List < UserDTO > fetchbyuseremailid(String email,String password)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		
		 Query query=entityManager.createQuery ( "select c from UserDTO c where c.email=?1 and c.password=?2");
		 query.setParameter ( 1 , email );
		 query.setParameter ( 2 , password );
		 List<UserDTO> users = query.getResultList ( );
		 return users;
		
	}
	
	public List < UserDTO > fetchallUser ( )
	{

		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		Query query = entityManager.createQuery ( "select s from UserDTO s",UserDTO.class );
		List<UserDTO> userDTOs = query.getResultList ( );
		return userDTOs;
	}
	
	public void deleteUser(int id)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		EntityTransaction entityTransaction=entityManager.getTransaction ( );
		
		UserDTO userDTO = entityManager.find ( UserDTO.class , id );
		entityTransaction.begin ( );
		entityManager.remove ( userDTO );
		entityTransaction.commit ( );
	}

	public void updateUser ( UserDTO userDTO )
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		EntityTransaction entityTransaction=entityManager.getTransaction ( );
		
		entityTransaction.begin ( );
		entityManager.merge ( userDTO);
		entityTransaction.commit ( );
	}
	
	public UserDTO searchUser(int id)
	{
		EntityManager entityManager=entityManagerFactory.createEntityManager ( );
		return	entityManager.find ( UserDTO.class , id );
	}
}
