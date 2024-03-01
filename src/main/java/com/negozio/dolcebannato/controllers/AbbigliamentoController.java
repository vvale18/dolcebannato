package com.negozio.dolcebannato.controllers;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.negozio.dolcebannato.dao.DAOAbbigliamento;
import com.negozio.dolcebannato.dao.DAOCarrello;

@Controller
@RequestMapping("/abbigliamento")
public class AbbigliamentoController 
{
		@Autowired
		private DAOAbbigliamento da;
		
		@Autowired
		private DAOCarrello dc;

		@GetMapping("elencoabbigliamenti")
		public String elencoabbigliamento(HttpSession session, Model model)
		{
			System.out.println("Sei nel mapping elencoabbigliamenti");
			System.out.println("Lista vestiti: " + da.leggiTutti().size());
			model.addAttribute("nomeAbbigliamento","I nostri abbigliamenti");
			model.addAttribute("elencoabbigliamenti",da.leggiTutti());
			String tipoutente = (String) session.getAttribute("tipoutente");
			System.out.println("Tipo utente: " + tipoutente);
			String ris = "";
			if(tipoutente.equalsIgnoreCase("admin"))
				ris = "../adminConsole/adminSchermataModAbb.jsp";
			else
				ris = "../abbigliamento/elencoabbigliamenti.jsp";
			System.out.println("Ris: " + ris);
			return ris;
		}

		@GetMapping("formnuovo")
		public String formnuovo()
		{
			return "formnuovoabbigliamento.html";
		}

		@PostMapping("nuovoabbigliamento")
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
				return "redirect:/adminHome.html";
			}
		}

		@GetMapping("dettaglio")
		public String dettaglioabbigliamento(@RequestParam("idabb") int idDettaglio, Model model)
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

		@GetMapping("formodabb")
		public String formod(@RequestParam("idabb") int idMod, Model model)
		{
			System.out.println("Sono qui");
			Map<String,String> abbigliamento = da.cercaPerId(idMod);
			System.out.println(abbigliamento);
			if(abbigliamento == null)
			{
				return "redirect:elencoabbigliamenti";
			}
			else
			{
				model.addAttribute("abbigliamentomod",abbigliamento);
				return "../adminConsole/formmodabb.jsp";
			}
		}

		@GetMapping("aggiorna")
		public String aggiorna(@RequestParam Map<String,String> abbigliamentomod)
		{
			System.out.println("Stai modificando " + abbigliamentomod);
			if(da.update(abbigliamentomod))
			{
				System.out.println("Modifica avvenuta con successo " + abbigliamentomod);
				return "redirect:elencoabbigliamenti";
			}
			else
			{
				return "redirect:elencoabbigliamenti";
			}	
		}

		@GetMapping("eliminaabbigliamento")
		public String elimina(@RequestParam("idabb") int idElimina)
		{
			if(da.delete(idElimina))
			{
				return "redirect:elencoabbigliamenti";
			}
			else
			{
				return "redirect:/adminHome";
			}	
		}
		
		@GetMapping("aggiungicarrello")
		public String aggiungicarrello(@RequestParam("idabb") int idProdotto, HttpSession session)
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
			return "redirect:elencoabbigliamenti";
		}
		

		@GetMapping("mostracarrello")
		public String mostracarrello(HttpSession session, Model model)
		{
			Map<String, String> utente = (Map<String, String>) session.getAttribute("utente");
			System.out.println("Utente " + utente);
			int idUtente = Integer.parseInt(utente.get("id"));
			String ris = "";
			List<Map<String,String>> prodottiutente  = dc.mostraCarrello(idUtente);
			for(Map<String, String> m : prodottiutente)
				System.out.println("Prodotto nel carrello " + m);
			model.addAttribute("prodottinelcarrello",prodottiutente);
			model.addAttribute("utente",utente);
			return "carrello.jsp";
		}
		
		@GetMapping("mostracarrellocompleto")
		public String mostracarrellocompleto(HttpSession session, Model model)
		{
			Map<String, String> utente = (Map<String, String>) session.getAttribute("utente");
			System.out.println("Utente " + utente);
			int idUtente = Integer.parseInt(utente.get("id"));
			String ris = "";
			List<Map<String,String>> prodottiutente  = dc.mostracarrellocompleto(idUtente);
			for(Map<String, String> m : prodottiutente)
				System.out.println("Prodotto nel carrello " + m);
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
			return "paginafine.html";
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
			return "redirect:elencoabbigliamenti";
		}
		
//		@GetMapping("adminSchermataModAbb")
//		public String adminelencoabbigliamento(Model model)
//		{
//			model.addAttribute("nomeAbbigliamento","I nostri abbigliamenti");
//			model.addAttribute("elencoabbigliamenti",da.leggiTutti());
//			return "adminSchermataModAbb.jsp";
//		}
}
