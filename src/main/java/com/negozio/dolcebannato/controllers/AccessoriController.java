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

import com.negozio.dolcebannato.dao.DAOAccessori;
import com.negozio.dolcebannato.dao.DAOCarrello;

@Controller
@RequestMapping("/accessori")
public class AccessoriController 
{


	@Autowired
	private DAOAccessori dac;
	
	@Autowired
	private DAOCarrello dc;


	@GetMapping("elencoaccessori")
	public String elencoaccessori(HttpSession session, Model model)
	{
		System.out.println("Sei nel mapping elencoabbigliamenti");
		System.out.println("Lista accessori: " + dac.leggiTutti().size());
		model.addAttribute("nomeAccessori","I nostri accessori");
		model.addAttribute("elencoaccessori",dac.leggiTutti());
		String tipoutente = (String) session.getAttribute("tipoutente");
		System.out.println("Tipo utente: " + tipoutente);
		String ris = "";
		if(tipoutente.equalsIgnoreCase("admin"))
			ris = "../adminConsole/adminSchermataModAcc.jsp";
		else
			ris = "../accessori/elencoaccessori.jsp";
		System.out.println("Ris: " + ris);
		return ris;
	}

	@GetMapping("formnuovo")
	public String formnuovo()
	{
		return "formnuovoaccessorio.html";
	}

	@GetMapping("nuovoaccessorio")
	public String nuovoaccessorio(@RequestParam Map<String,String> inputform)
	{
		if(dac.create(inputform))
		{
			System.out.println("Inserimento avvenuto con successo");
			return "redirect:elencoaccessori";
		}
		else
		{
			System.out.println("Errore nell'inserimento dell' accessorio " + inputform);
			return "redirect:/";
		}
	}

	@GetMapping("dettaglio")
	public String dettaglioaccessorio(@RequestParam("idacc") int idDettaglio, Model model)
	{
		Map<String,String> accessorio = dac.cercaPerId(idDettaglio);
		if(accessorio == null)
		{
			System.out.println("accessorio non trovato " + accessorio);
			return "redirect:elencoaccessori";
		}
		else
		{
			model.addAttribute("accessorio",accessorio);
			return "dettaglioaccessorio.jsp";
		}
	}

	@GetMapping("formodacc")
	public String formod(@RequestParam("idacc") int idMod, Model model)
	{
		System.out.println("Sono qui");
		Map<String,String> accessorio = dac.cercaPerId(idMod);
		System.out.println(accessorio);
		if(accessorio == null)
		{
			return "redirect:elencoaccessori";
		}
		else
		{
			model.addAttribute("accessoriomod",accessorio);
			return "../adminConsole/formodacc.jsp";
		}
	}

	@GetMapping("aggiorna")
	public String aggiorna(@RequestParam Map<String,String> accessoriomod)
	{
		System.out.println("Stai modificando " + accessoriomod);
		if(dac.update(accessoriomod))
		{
			System.out.println("Modifica avvenuta con successo " + accessoriomod);
			return "redirect:elencoaccessori";
		}
		else
		{
			return "redirect:elencoaccessori";
		}	
	}

	@GetMapping("eliminaaccessorio")
	public String elimina(@RequestParam("idacc") int idElimina)
	{
		if(dac.delete(idElimina))
		{
			return "redirect:elencoaccessori";
		}
		else
		{
			return "redirect:/adminHome";
		}	
	}
	
	@GetMapping("aggiungicarrello")
	public String aggiungicarrello(@RequestParam("idacc") int idProdotto, HttpSession session)
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
		return "redirect:elencoaccessori";
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
	
	@GetMapping("svuotacarrello")
	public String svuotacarrello(HttpSession session)
	{
		Map<String, String> utente = (Map<String, String>) session.getAttribute("utente");
		int idUtente = Integer.parseInt(utente.get("id"));
		if(dc.svuotaCarrello(idUtente))
			System.out.println("Carrello vuoto");
		else
			System.out.println("Non è stato possibile svuotare il carrello");
		return "redirect:elencoaccessori";
	}

}