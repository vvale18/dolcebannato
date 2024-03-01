package com.negozio.dolcebannato.dao;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import database.Database;

public class DAOCarrello
{
	@Autowired
	private Database db;
	
	public boolean aggiungiCarrello(int idprodotto, int idutente)
	{
		String query = 	"insert into carrello\r\n"
						+ "	(data,idprodotto,idutente)\r\n"
						+ "	values\r\n"
						+ "	(date(now()),?,?);";
		return db.update(query, idprodotto + "", idutente + "");
	}
	
	public List<Map<String,String>> mostraCarrello(int idutente)
	{
		//String query = "select	* from carrello where idutente = ?;";
		String query = "select 	carrello.id as \"id\",\r\n"
						+ "		carrello.data as \"data\",\r\n"
						+ "        abbigliamento.marca as \"marca\",\r\n"
						+ "        abbigliamento.taglia as \"taglia\",\r\n"
						+ "        abbigliamento.prezzo as \"prezzo\",\r\n"
						+ "        carrello.idutente as \"idutente\",\r\n"
						+ "        carrello.idprodotto as \"idprodotto\",\r\n"
						+ "        abbigliamento.idabb as \"idabb\"\r\n"
						+ "from	carrello inner join abbigliamento\r\n"
						+ "		on carrello.idprodotto = abbigliamento.idAbb\r\n"
						+ "where	carrello.idutente = ?;";
		return db.rows(query,idutente + "");
	}
	
	public List<Map<String,String>> mostracarrellocompleto(int idutente)
	{
		double prezzotot = 0;
		String query = "select	id,data,idutente,\r\n"
				+ "		if(isnull(stileabb),\"vuoto\",stileabb) as stile,\r\n"
				+ "        if(isnull(prezzoabb),\"vuoto\",prezzoabb) as prezzo\r\n"
				+ "from	carrellocompleto\r\n"
				+ "where idutente = ?\r\n"
				+ "union\r\n"
				+ "select	id,data,idutente,\r\n"
				+ "		if(isnull(stileacc),\"vuoto\",stileacc) as stile,\r\n"
				+ "        if(isnull(prezzoacc),\"vuoto\",prezzoacc) as prezzo\r\n"
				+ "from	carrellocompleto\r\n"
				+ "where idutente = ?\r\n"
				+ "union\r\n"
				+ "select	id,data,idutente,\r\n"
				+ "		if(isnull(stilesca),\"vuoto\",stilesca) as stile,\r\n"
				+ "        if(isnull(prezzosca),\"vuoto\",prezzosca) as prezzo\r\n"
				+ "from	carrellocompleto\r\n"
				+ "where idutente = ?;";
			//Mi faccio ritornare dal DB la lista completa che tuttavia presenta dei campi null
			List<Map<String,String>> lista = db.rows(query,idutente + "",idutente + "",idutente + "");
			List<Map<String,String>> lista2 = new ArrayList<Map<String,String>>();
			Map<String,String> mappaprezzotot = new HashMap<String,String>();
			for(Map<String,String> m : lista)
			{
				Map<String,String> nuova = new HashMap<String,String>();
				nuova.put("id",m.get("id"));
				nuova.put("data",m.get("data"));
				nuova.put("idutente",m.get("idutente"));
				if(!m.get("stile").equalsIgnoreCase("vuoto"))
				{
					nuova.put("stile",m.get("stile"));
				}
				if(!m.get("prezzo").equalsIgnoreCase("vuoto"))
				{
					nuova.put("prezzo",m.get("prezzo"));
					prezzotot += Double.parseDouble(m.get("prezzo"));
				}
				System.out.println("Mappa: " + nuova);
				lista2.add(nuova);
			}
			mappaprezzotot.put("prezzotot", prezzotot + "");
			lista2.add(mappaprezzotot);
			return lista2;
	}
	
	public boolean svuotaCarrello(int idutente)
	{
		String query = "delete from carrello where idutente = ? and id > 0;";
		return db.update(query, idutente + "");
	}
}