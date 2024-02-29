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
		String query = "select * from accessori where idacc = ?";
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
		String query ="update accessori\r\n"
					+ "set tipologia = ?,\r\n"
					+ "	marca = ?,\r\n"
					+ "	stile = ?,\r\n"
					+ "    materiale = ?,\r\n"
					+ "    dettagli = ?,\r\n"
					+ "    prezzo = ?,\r\n"
					+ "    qnt = ?\r\n"
					+ "where idacc = ?;";
		return db.update(query, mappa.get("tipologia"), 
								mappa.get("marca"),
								mappa.get("stile"),
								mappa.get("materiale"),
								mappa.get("dettagli"),
								mappa.get("prezzo"),
								mappa.get("qnt"),
								mappa.get("idacc"));
	}
	
	public boolean delete(int id)
	{
		String query = "delete from accessori where idacc = ?";
		return db.update(query, id + "");
	}
}
