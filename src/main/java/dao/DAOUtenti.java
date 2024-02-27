package dao;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import database.Database;

public class DAOUtenti
{
	@Autowired
	private Database db;
	
	public Map<String,String> trovaUtente(String username, String password)
	{
		String query = "SELECT id,username,password FROM utenti\r\n"
					 + "WHERE username = ? AND password = ?; ";
		
		Map<String,String> utente = db.row(query, username, password);
		return utente;
	}
	
	public boolean create(Map<String,String> m)
	{
		System.out.println("Nuovo utente: " + m);
		String query = "INSERT INTO utenti\r\n"
				+ "(username,nome,cognome,dob,mail,password,genere,isAdmin)\r\n"
				+ "VALUES\r\n"
				+ " (?,?,?,?,?,?,?,?);";
		return db.update(query, m.get("username"),
								m.get("nome"),
								m.get("cognome"),
								m.get("dob"),
								m.get("mail"),
								m.get("password"),
								m.get("genere"),
								m.get("isAdmin"));
	}
}
