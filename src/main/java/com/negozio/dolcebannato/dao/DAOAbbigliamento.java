package com.negozio.dolcebannato.dao;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import database.Database;

public class DAOAbbigliamento
{
	@Autowired
	private Database db;
	
	public List<Map<String, String>>read (String query, String... params)
	{
		return db.rows(query, params); 
	}
	
	public List<Map<String, String>> leggiTutti()
	{
		String query = "select * from abbigliamento";
		return read(query);
	}

	public boolean create(Map<String, String> e) {
		String query = "insert into abbigliamento (tipologia,marca,stile,materiale,taglia,dettagli,prezzo,qnt) values (?,?,?,?,?,?,?,?)";
		return db.update(query, e.get("tipologia"), e.get("marca"), e.get("stile"), e.get("materiale"), e.get("taglia"), e.get("dettagli"), e.get("prezzo"), e.get("qnt"));
	}
	
	public boolean update(Map<String, String> e)
	{
		String query = "update abbigliamento\r\n"
						+ "set tipologia = ?,\r\n"
						+ "	marca = ?,\r\n"
						+ "	stile = ?,\r\n"
						+ "    materiale = ?,\r\n"
						+ "    taglia = ?,\r\n"
						+ "    dettagli = ?,\r\n"
						+ "    prezzo = ?,\r\n"
						+ "    qnt = ?\r\n"
						+ "where idabb = ?;";
		return db.update(query, e.get("tipologia"), e.get("marca"), e.get("stile"), e.get("materiale"), 
								e.get("taglia"), e.get("dettagli"), e.get("prezzo"), e.get("qnt"), e.get ("idabb"));
	}
	
	public boolean delete(int id)
	{
		String query = "delete from abbigliamento where idabb = ?";
		return db.update(query,id + "");
	}
	
	public Map<String,String> cercaPerId (int id)
	{
		String query = "select * from abbigliamento where idabb = ?";
		return read(query, id + "").get(0);
	}
}
