package com.negozio.dolcebannato.controllers;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.negozio.dolcebannato.dao.DAOAccessori;

@Controller
@RequestMapping("/accessori")
public class AccessoriController 
{


	@Autowired
	private DAOAccessori da;


	@GetMapping("elencoaccessori")
	public String elencoaccessori(HttpSession session, Model model)
	{
		model.addAttribute("nomeAccessori","I nostri accessori");
		model.addAttribute("elencoaccessori",da.leggiTutti());
		String tipoutente = (String) session.getAttribute("tipoutente");
		System.out.println("Tipo utente: " + tipoutente);
		String ris = "";
		if(tipoutente.equalsIgnoreCase("admin"))
			ris = "../adminConsole/adminSchermataModAcc.jsp";
		else
			ris = "elencoaccessori.jsp";
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
		if(da.create(inputform))
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
	public String dettaglioaccessorio(@RequestParam("idAcc") int idDettaglio, Model model)
	{
		Map<String,String> accessorio = da.cercaPerId(idDettaglio);
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

	@GetMapping("formod")
	public String formod(@RequestParam("idAcc") int idMod, Model model)
	{
		Map<String,String> accessorio = da.cercaPerId(idMod);
		if(accessorio == null)
		{
			return "redirect:elencoaccessori";
		}
		else
		{
			model.addAttribute("accessoriomod",accessorio);
			return "formod.jsp";
		}
	}

	@GetMapping("aggiorna")
	public String aggiorna(@RequestParam Map<String,String> accessoriomod)
	{
		if(da.update(accessoriomod))
		{
			System.out.println("Modifica avvenuta con successo " + accessoriomod);
			return "redirect:elencoaccessori";
		}
		else
		{
			return "redirect:/";
		}	
	}

	@GetMapping("eliminaaccessorio")
	public String elimina(@RequestParam("idAcc") int idElimina)
	{
		if(da.delete(idElimina))
		{
			return "redirect:elencoaccessori";
		}
		else
		{
			return "redirect:/";
		}	
	}

}