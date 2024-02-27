package com.negozio.dolcebannato;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.negozio.dolcebannato.dao.DAOAbbigliamento;
import com.negozio.dolcebannato.dao.DAOAccessori;
import com.negozio.dolcebannato.dao.DAOScarpe;
import com.negozio.dolcebannato.dao.DAOUtenti;

import database.Database;

@Configuration
public class Context
{
	@Bean
	public Database db()
	{
		return new Database("dolcebannato");
	}
	
	@Bean
	public DAOAbbigliamento dab()
	{
		return new DAOAbbigliamento();
	}
	
	@Bean
	public DAOScarpe ds()
	{
		return new DAOScarpe();
	}
	
	@Bean
	public DAOAccessori dac()
	{
		return new DAOAccessori();
	}
	
	@Bean
	public DAOUtenti du()
	{
		return new DAOUtenti();
	}
}
