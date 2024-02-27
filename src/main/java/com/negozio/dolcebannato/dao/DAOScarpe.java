package com.negozio.dolcebannato.dao;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import database.Database;

public class DAOScarpe 
{
	
	@Autowired
	private Database db;
	
	
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
		String query = "select * from scarpe where id = ?";
		return read(query, id + "").get(0);
	}
	public boolean create(Map<String,String> m)
	{
		String query = "insert into scarpe (idsca; tipologia; marca; stile; materiale; numero; colore; dettagli; prezzo; qnt\r\n"
				+ ") values (?,?,?,?,?,?,?)";
		return db.update(query, m.get("idsca"), m.get("tipologia"), m.get("marca"), m.get("stile"), m.get("materiale"), m.get("numero"), m.get("colore"),
				m.get("dettagli"), m.get("prezzo"), m.get("qnt"));
	}
	
	public boolean update(Map<String,String> m)
	{
		String query = "update scarpe set idsca = ?, tipologia = ? marca , stile =? , "
				+ "materiale = ?, numero =? , colore = ?, dettagli = ? , numero =? , prezzo = ?";
		return db.update(query, m.get("idsca"), m.get("tipologia"), m.get("marca"), m.get("stile"), m.get("materiale"), m.get("numero"), m.get("colore"),
				m.get("dettagli"), m.get("prezzo"), m.get("qnt"));
	}
	
	public boolean delete(int id)
	{
		String query = "delete from scarpe where id = ?";
		return db.update(query, id + "");
	}
	
}