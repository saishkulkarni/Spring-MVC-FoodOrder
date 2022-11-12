package com.ty.foodorder.DTO;

import java.util.List ;

import javax.persistence.CascadeType ;
import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.OneToMany ;

@Entity
public class UserDTO
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String email;
	private String password;
	
	@OneToMany(cascade = CascadeType.ALL,mappedBy = "userDTO") 
	List < FoodOrderDTO > foodOrderDTO;
	 
	public List < FoodOrderDTO > getFoodOrderDTO ( )
	{
		return foodOrderDTO ;
	}
	public void setFoodOrderDTO ( List < FoodOrderDTO > foodOrderDTO )
	{
		this.foodOrderDTO = foodOrderDTO ;
	}
	public int getId ( )
	{
		return id ;
	}
	public void setId ( int id )
	{
		this.id = id ;
	}
	public String getName ( )
	{
		return name ;
	}
	public void setName ( String name )
	{
		this.name = name ;
	}
	public String getEmail ( )
	{
		return email ;
	}
	public void setEmail ( String email )
	{
		this.email = email ;
	}
	public String getPassword ( )
	{
		return password ;
	}
	public void setPassword ( String password )
	{
		this.password = password ;
	}
}
