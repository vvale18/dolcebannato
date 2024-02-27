package dao;

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
		String query = "insert into abbigliamento (tipologie,marca,stile,materiale,taglia,dettagli,prezzo) values (?,?,?,?,?,?,?)";
		return db.update(query, e.get("tipologia"), e.get("marca"), e.get("stile"), e.get("materiale"), e.get("taglia"), e.get("dettagli"), e.get("prezzo"));
	}
	
	public boolean update(Map<String, String> e) {
		String query = "update into abbigliamento set tipologie =?, set marca=? , set stile=? ,set materiale=?,set taglia=?, set dettagli=?, set prezzo=? where id =?";
		return db.update(query, e.get("tipologia"), e.get("marca"), e.get("stile"), e.get("materiale"), e.get("taglia"), e.get("dettagli"), e.get("prezzo"), e.get ("id"));
	}
	
	public boolean delete(int id)
	{
		String query = "delete from abbigliamento where id = ?";
		return db.update(query,id + "");
	}
	
	public Map<String,String> cercaPerId (int id)
	{
		String query = "select * from abbigliamento where id = ?";
		return read(query, id + "").get(0);
	}
}
