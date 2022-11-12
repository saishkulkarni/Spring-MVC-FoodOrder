package com.ty.foodorder.Service;

import org.springframework.beans.factory.annotation.Autowired ;
import org.springframework.stereotype.Component ;

import com.ty.foodorder.DAO.AdminDAO ;
import com.ty.foodorder.DTO.AdminDTO ;

@Component
public class AdminService
{
	@Autowired
AdminDAO adminDAO;

	public void addAdmin(AdminDTO adminDTO)
	{
		adminDAO.addAdmin ( adminDTO );
	}
	
	public AdminDTO fetchAdmin(int id)
	{
		return adminDAO.fetchAdmin ( id );
	}
	
}
