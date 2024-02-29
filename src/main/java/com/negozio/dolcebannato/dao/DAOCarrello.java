package com.negozio.dolcebannato.dao;
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
	
	public boolean svuotaCarrello(int idutente)
	{
		String query = "delete from carrello where idutente = ? and id > 0;";
		return db.update(query, idutente + "");
	}
}