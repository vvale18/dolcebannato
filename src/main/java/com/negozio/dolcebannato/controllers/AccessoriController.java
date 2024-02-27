package com.negozio.dolcebannato.controllers;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.negozio.dolcebannato.dao.DAOAccessori;

public class AccessoriController 
{
	@RequestMapping("/accessori")
	public class LibriController
	{
		@Autowired
		private DAOAccessori da;


		@GetMapping("elencoaccessori")
		public String elencoaccessori(Model model)
		{
			model.addAttribute("nomeAccessori","I nostri accessori");
			model.addAttribute("elencoaccessori",da.leggiTutti());
			return "elencoaccessori.jsp";
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
		public String dettaglioaccessorio(@RequestParam("id") int idDettaglio, Model model)
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
		public String formod(@RequestParam("id") int idMod, Model model)
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
		public String elimina(@RequestParam("id") int idElimina)
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
}