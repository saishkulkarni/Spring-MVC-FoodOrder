package com.ty.foodorder.DTO;

import javax.persistence.Entity ;
import javax.persistence.GeneratedValue ;
import javax.persistence.GenerationType ;
import javax.persistence.Id ;
import javax.persistence.JoinColumn ;
import javax.persistence.ManyToOne ;

@Entity
public class ItemDTO
{
@Id
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;
private String name;
private double cost;
private int quantity;

@ManyToOne
@JoinColumn
private FoodOrderDTO foodOrderDTO;

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

public double getCost ( )
{
	return cost ;
}

public void setCost ( double cost )
{
	this.cost = cost ;
}

public FoodOrderDTO getFoodOrderDTO ( )
{
	return foodOrderDTO ;
}

public void setFoodOrderDTO ( FoodOrderDTO foodOrderDTO )
{
	this.foodOrderDTO = foodOrderDTO ;
}

public int getQuantity ( )
{
	return quantity ;
}

public void setQuantity ( int quantity )
{
	this.quantity = quantity ;
}

}
