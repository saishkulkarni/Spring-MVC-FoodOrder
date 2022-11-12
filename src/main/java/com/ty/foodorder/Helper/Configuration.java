package com.ty.foodorder.Helper;

import javax.persistence.EntityManagerFactory ;
import javax.persistence.Persistence ;

import org.springframework.context.annotation.Bean ;

@org.springframework.context.annotation.Configuration
public class Configuration
{
	@Bean("entityManagerFactory")
public EntityManagerFactory entityManagerFactory()
{
	EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory ( "dev" );
	return entityManagerFactory;
}
}
