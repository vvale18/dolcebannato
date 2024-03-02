package com.negozio.dolcebannato.controllers;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.negozio.dolcebannato.dao.DAOCarrello;
import com.negozio.dolcebannato.dao.DAOScarpe;


@Controller
@RequestMapping("/scarpe")
public class ScarpeController 
{
	@Autowired
	private DAOScarpe ds;

	@Autowired
	private DAOCarrello dc;

	@GetMapping("elencoscarpe")
	public String elencoscarpe(HttpSession session, Model model)
	{
		System.out.println("Lista scarpe: " + ds.leggiTutti().size());
		model.addAttribute("nomeScarpe","Le nostre scarpe");
		model.addAttribute("elencoscarpe",ds.leggiTutti());
		String tipoutente = (String) session.getAttribute("tipoutente");
		System.out.println("Tipo utente: " + tipoutente);
		String ris = "";
		if(tipoutente.equalsIgnoreCase("admin"))
			ris = "../adminConsole/adminSchermataModSca.jsp";
		else
			ris = "../scarpe/elencoscarpe.jsp";
		System.out.println("Ris: " + ris);
		return ris;
	}

	@GetMapping("formnuovo")
	public String formnuovo()
	{
		return "formnuovescarpe.html";
	}

	@GetMapping("nuovascarpa")
	public String nuovascarpa(@RequestParam Map<String,String> inputform)
	{
		if(ds.create(inputform))
		{
			System.out.println("Inserimento avvenuto con successo");
			return "redirect:elencoscarpe";
		}
		else
		{
			System.out.println("Errore nell'inserimento della scarpa " + inputform);
			return "redirect:/adminHome.html";
		}
	}

	@GetMapping("dettaglio")
	public String dettaglioscarpa(@RequestParam("idsca") int idDettaglio, Model model)
	{
		Map<String,String> scarpa = ds.cercaPerId(idDettaglio);
		if(scarpa == null)
		{
			System.out.println("Libro non trovato " + scarpa);
			return "redirect:elencoscarpe";
		}
		else
		{
			model.addAttribute("scarpa",scarpa);
			return "dettaglioscarpa.jsp";
		}
	}

	@GetMapping("formodsca")
	public String formod(@RequestParam("idsca") int idMod, Model model)
	{
		Map<String,String> scarpa = ds.cercaPerId(idMod);
		if(scarpa == null)
		{
			return "redirect:elencoscarpe";
		}
		else
		{
			model.addAttribute("scarpamod",scarpa);
			return "../adminConsole/formodsca.jsp";
		}
	}

	//scarpamod
	
//	@GetMapping("aggiorna")
//	public String aggiorna(@RequestParam Map<String,String> scarpamod)
//	{
//		if(ds.update(scarpamod))
//		{
//			System.out.println("Modifica avvenuta con successo " + scarpamod);
//			return "redirect:elencoscarpe";
//		}
//		else
//		{
//			return "redirect:elencoscarpe";
//		}	
//	}
	
	@GetMapping("aggiorna")
	public String aggiorna(@RequestParam Map<String,String> scarpamod)
	{
		System.out.println("Stai modificando " + scarpamod);
		if(ds.update(scarpamod))
		{
			System.out.println("Modifica avvenuta con successo " + scarpamod);
			return "redirect:elencoscarpe";
		}
		else
		{
			return "redirect:elencoscarpe";
		}	
	}

	@GetMapping("eliminascarpa")
	public String elimina(@RequestParam("idsca") int idElimina)
	{
		if(ds.delete(idElimina))
		{
			return "redirect:elencoscarpe";
		}
		else
		{
			return "redirect:/adminHome";
		}	
	}
	
	@GetMapping("aggiungicarrello")
	public String aggiungicarrello(@RequestParam("idsca") int idProdotto, HttpSession session)
	{
		System.out.println("idProdotto " + idProdotto);
		Map<String, String> utente = (Map<String, String>) session.getAttribute("utente");
		System.out.println("Utente " + utente);
		int idUtente = Integer.parseInt(utente.get("id"));
		String ris = "";
		if(dc.aggiungiCarrello(idProdotto, idUtente))
			ris = "Prodotto aggiunto al carrello";
		else
			ris = "Errore nell'aggiunta al carrello";
		System.out.println("Ris aggiungi al carrello: " + ris);
		return "redirect:elencoscarpe";
	}
	

	@GetMapping("mostracarrello")
	public String mostracarrellocompleto(HttpSession session, Model model)
	{
		Map<String, String> utente = (Map<String, String>) session.getAttribute("utente");
		System.out.println("Utente " + utente);
		int idUtente = Integer.parseInt(utente.get("id"));
		String ris = "";
		List<Map<String,String>> prodottiutente  = dc.mostracarrellocompleto(idUtente);
//		int i = 0;
		for(Map<String, String> m : prodottiutente)
		{
			System.out.println("Prodotto nel carrello " + m);
//			if(m.get("stile") == null || m.get("stile") == "")
//			{
//				prodottiutente.remove(i);
//			}
//			i++;
		}
		model.addAttribute("prodottinelcarrello",prodottiutente);
		model.addAttribute("utente",utente);
		return "carrello.jsp";
	}
	
	@GetMapping("pagaora")
	public String pagaora(HttpSession session, Model model)
	{
		Map<String, String> utente = (Map<String, String>) session.getAttribute("utente");
		System.out.println("Utente " + utente);
		int idUtente = Integer.parseInt(utente.get("id"));
		dc.svuotaCarrello(idUtente);
		return "mostracarrello";
	}
	
	@GetMapping("svuotacarrello")
	public String svuotacarrello(HttpSession session)
	{
		Map<String, String> utente = (Map<String, String>) session.getAttribute("utente");
		int idUtente = Integer.parseInt(utente.get("id"));
		if(dc.svuotaCarrello(idUtente))
			System.out.println("Carrello vuoto");
		else
			System.out.println("Non è stato possibile svuotare il carrello");
		return "redirect:elencoscarpe";
	}
}
