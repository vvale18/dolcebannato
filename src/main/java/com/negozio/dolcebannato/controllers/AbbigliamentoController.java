package com.negozio.dolcebannato.controllers;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.negozio.dolcebannato.dao.DAOAbbigliamento;

@RequestMapping("/abbigliamento")
public class AbbigliamentoController 
{
		@Autowired
		private DAOAbbigliamento da;


		@GetMapping("elencoabbigliamenti")
		public String elencoaccessori(Model model)
		{
			model.addAttribute("nomeAbbigliamento","I nostri abbigliamenti");
			model.addAttribute("elencoabbigliamenti",da.leggiTutti());
			return "elencoabbigliamenti.jsp";
		}

		@GetMapping("formnuovo")
		public String formnuovo()
		{
			return "formnuovoabbigliamento.html";
		}

		@GetMapping("nuovoabbigliamento")
		public String nuovoabbigliamento(@RequestParam Map<String,String> inputform)
		{
			if(da.create(inputform))
			{
				System.out.println("Inserimento avvenuto con successo");
				return "redirect:elencoabbigliamenti";
			}
			else
			{
				System.out.println("Errore nell'inserimento dell' abbigliamento " + inputform);
				return "redirect:/";
			}
		}

		@GetMapping("dettaglio")
		public String dettaglioabbigliamento(@RequestParam("id") int idDettaglio, Model model)
		{
			Map<String,String> abbigliamento = da.cercaPerId(idDettaglio);
			if(abbigliamento == null)
			{
				System.out.println("abbigliamento non trovato " + abbigliamento);
				return "redirect:elencoabbigliamenti";
			}
			else
			{
				model.addAttribute("abbigliamento",abbigliamento);
				return "dettaglioabbigliamento.jsp";
			}
		}

		@GetMapping("formod")
		public String formod(@RequestParam("id") int idMod, Model model)
		{
			Map<String,String> abbigliamento = da.cercaPerId(idMod);
			if(abbigliamento == null)
			{
				return "redirect:elencoabbigliamenti";
			}
			else
			{
				model.addAttribute("abbigliamentomod",abbigliamento);
				return "formod.jsp";
			}
		}

		@GetMapping("aggiorna")
		public String aggiorna(@RequestParam Map<String,String> abbigliamentomod)
		{
			if(da.update(abbigliamentomod))
			{
				System.out.println("Modifica avvenuta con successo " + abbigliamentomod);
				return "redirect:elencoabbigliamenti";
			}
			else
			{
				return "redirect:/";
			}	
		}

		@GetMapping("eliminaabbigliamento")
		public String elimina(@RequestParam("id") int idElimina)
		{
			if(da.delete(idElimina))
			{
				return "redirect:elencoabbigliamenti";
			}
			else
			{
				return "redirect:/";
			}	
		}
}
