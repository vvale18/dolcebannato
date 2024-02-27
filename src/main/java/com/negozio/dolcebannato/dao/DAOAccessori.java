package com.negozio.dolcebannato.dao;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import database.Database;

public class DAOAccessori 
{
	@Autowired
	private Database db;
	
	public List<Map<String,String>> read (String query, String... params)
	{
		return db.rows(query, params);
	}
	
	public List<Map<String,String>> leggiTutti()
	{
		String query = "select * from accessori";
		return read(query);
	}
	
	public Map<String,String> cercaPerId(int id)
	{
		String query = "select * from accessori where id = ?";
		return read(query,id + "").get(0);
	}
	// Table Accessori			IDAcc; Tipologia; Marca; Stile; Materiale; Dettagli; Prezzo; Qnt
	public boolean create(Map<String,String> mappa)
	{
		String query = "insert into accessori (tipologia, marca, stile, materiale, dettagli, prezzo, qnt) values (?,?,?,?,?,?,?)";
		return db.update(query, mappa.get("tipologia"), 
								mappa.get("marca"),
								mappa.get("stile"),
								mappa.get("materiale"),
								mappa.get("dettagli"),
								mappa.get("prezzo"),
								mappa.get("qnt"));
	}
	
	public boolean update(Map<String,String> mappa)
	{
		String query ="update accessori set tipologia =?,marca=?,stile=?,materiale=?,dettagli=?,prezzo=?,qnt=? where id = ?";
		return db.update(query, mappa.get("tipologia"), 
								mappa.get("marca"),
								mappa.get("stile"),
								mappa.get("materiale"),
								mappa.get("dettagli"),
								mappa.get("prezzo"),
								mappa.get("qnt"),
								mappa.get("id"));
	}
	
	public boolean delete(int id)
	{
		String query = "delete from accessori where id = ?";
		return db.update(query, id + "");
	}
}
