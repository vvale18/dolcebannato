package com.negozio.dolcebannato.utils;
import database.Database;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DBUtils 
{

	@Autowired
	private Database db;

	public void updateSequence () 
	{
		String query = "INSERT INTO seq (obj) values('obj');";
		db.update(query);
	}
}

