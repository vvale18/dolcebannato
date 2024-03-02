package com.negozio.dolcebannato.dao;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;

import com.negozio.dolcebannato.utils.DBUtils;

import database.Database;

public class DAOScarpe 
{
	
	@Autowired
	private Database db;
	
	@Autowired
	private DBUtils du;
	
	public List<Map<String,String>> read(String query, String... params)
	{
		return db.rows(query, params);
	}
	
	public List<Map<String,String>> leggiTutti()
	{
		String query = "select * from scarpe";
		return read(query);
	}
	
	public Map<String,String> cercaPerId(int id)
	{
		String query = "select * from scarpe where idsca = ?";
		return read(query, id + "").get(0);
	}
	
	public boolean create(Map<String,String> m)
	{
		du.updateSequence();
		String query = "INSERT INTO scarpe values ((\r\n"
					+ "SELECT max(id) as nextVal FROM seq), \r\n"
					+ "?, \r\n"
					+ "?, \r\n"
					+ "?, \r\n"
					+ "?, \r\n"
					+ "?, \r\n"
					+ "?, \r\n"
					+ "?, \r\n"
					+ "? );";
		return db.update(query, m.get("marca"),
								m.get("stile"),
								m.get("materiale"),
								m.get("numero"),
								m.get("colore"),
								m.get("dettagli"),
								m.get("prezzo"),
								m.get("qnt"));
	}
	
	public boolean update(Map<String,String> m)
	{
		String query ="update scarpe\r\n"
					+ "set marca = ?,\r\n"
					+ "stile = ?,\r\n"
					+ "materiale = ?,\r\n"
					+ "numero = ?,\r\n"
					+ "colore = ?,\r\n"
					+ "dettagli = ?,\r\n"
					+ "prezzo = ?,\r\n"
					+ "qnt = ?\r\n"
					+ "where idsca = ?;";
		return db.update(query, m.get("marca"),
								m.get("stile"),
								m.get("materiale"),
								m.get("numero"),
								m.get("colore"),
								m.get("dettagli"),
								m.get("prezzo"),
								m.get("qnt"),
								m.get("idsca"));
	}
	
	public boolean delete(int id)
	{
		String query = "delete from scarpe where idsca = ?";
		return db.update(query, id + "");
	}
	
}