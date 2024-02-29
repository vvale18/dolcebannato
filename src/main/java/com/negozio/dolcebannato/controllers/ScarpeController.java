package com.negozio.dolcebannato.controllers;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.negozio.dolcebannato.dao.DAOScarpe;


@Controller
@RequestMapping("/scarpe")
public class ScarpeController 
{
	@Autowired
	private DAOScarpe ds;


	@GetMapping("elencoscarpe")
	public String elencoscarpe(HttpSession session, Model model)
	{
		model.addAttribute("nomeScarpe","Le nostre scarpe");
		model.addAttribute("elencoscarpe",ds.leggiTutti());
		String tipoutente = (String) session.getAttribute("tipoutente");
		System.out.println("Tipo utente: " + tipoutente);
		String ris = "";
		if(tipoutente.equalsIgnoreCase("admin"))
			ris = "../adminConsole/adminSchermataModSca.jsp";
		else
			ris = "elencoscarpe.jsp";
		System.out.println("Ris: " + ris);
		return ris;
	}

	@GetMapping("formnuovo")
	public String formnuovo()
	{
		return "formnuovascarpa.html";
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
			return "redirect:/";
		}
	}

	@GetMapping("dettaglio")
	public String dettaglioscarpa(@RequestParam("id") int idDettaglio, Model model)
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

	@GetMapping("formod")
	public String formod(@RequestParam("id") int idMod, Model model)
	{
		Map<String,String> scarpa = ds.cercaPerId(idMod);
		if(scarpa == null)
		{
			return "redirect:elencoscarpe";
		}
		else
		{
			model.addAttribute("scarpaomod",scarpa);
			return "formod.jsp";
		}
	}

	@GetMapping("aggiorna")
	public String aggiorna(@RequestParam Map<String,String> scarpamod)
	{
		if(ds.update(scarpamod))
		{
			System.out.println("Modifica avvenuta con successo " + scarpamod);
			return "redirect:elencoscarpe";
		}
		else
		{
			return "redirect:/";
		}	
	}

	@GetMapping("eleminascarpa")
	public String elimina(@RequestParam("id") int idElimina)
	{
		if(ds.delete(idElimina))
		{
			return "redirect:elencoscarpe";
		}
		else
		{
			return "redirect:/";
		}	
	}
}
