package com.ty.foodorder.DTO;

import java.util.List ;
import javax.persistence.CascadeType ;
import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;
import javax.persistence.OneToMany ;

@Entity
public class FoodOrderDTO
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private long mob;
	private double cost;
	
	@ManyToOne
	@JoinColumn
	UserDTO userDTO;
	
	@OneToMany(mappedBy = "foodOrderDTO",cascade = CascadeType.ALL)
	private List < ItemDTO > itemDTOs;
	
	public UserDTO getUserDTO ( )
	{
		return userDTO ;
	}
	public void setUserDTO ( UserDTO userDTO )
	{
		this.userDTO = userDTO ;
	}
	public List < ItemDTO > getItemDTOs ( )
	{
		return itemDTOs ;
	}
	public void setItemDTOs ( List < ItemDTO > itemDTOs )
	{
		this.itemDTOs = itemDTOs ;
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
	public long getMob ( )
	{
		return mob ;
	}
	public void setMob ( long mob )
	{
		this.mob = mob ;
	}
	public double getCost ( )
	{
		return cost ;
	}
	public void setCost ( double cost )
	{
		this.cost = cost ;
	}

}
