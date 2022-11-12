package com.ty.foodorder.Service;

import java.util.List ;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;

import com.ty.foodorder.DAO.UserDAO ;
import com.ty.foodorder.DTO.UserDTO ;

@Component
public class UserService
{
	@Autowired
UserDAO userDAO;

	public UserDTO addUser(UserDTO userDTO)
	{
		return userDAO.addUser ( userDTO );	
	}
	
	public UserDTO fetchbyuseremailid(String email,String password)
	{
		List < UserDTO > users = userDAO.fetchbyuseremailid ( email , password );
		for(UserDTO user:users)
		{
			return user;
		}
		return null;
	}
	
	public List < UserDTO > fetchallUser ( )
	{
		return userDAO.fetchallUser ( );
	}
	
	public void deleteUser(int id)
	{
		userDAO.deleteUser ( id );
	}

	public void updateUser( UserDTO userDTO )
	{
		userDAO.updateUser ( userDTO );
	}
	
	public UserDTO searchUser(int id)
	{
		return userDAO.searchUser( id );
	}
}
