package com.negozio.dolcebannato.controllers;
import java.util.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.negozio.dolcebannato.dao.DAOUtenti;

@Controller
@RequestMapping("/utenti")
public class UtentiController
{
	@Autowired
	private DAOUtenti du;
		
	@GetMapping("formnuovoutente")
	public String formNuovoUtente()
	{
		return "formnuovoutente.html";
	}
	
	@GetMapping("registrati")
	public String registrati( @RequestParam Map<String,String> nuovoUtente)
	{
		if(du.create(nuovoUtente))
			System.out.println("Utente creato con successo");
		else
			System.out.println("Impossibile creare l'utente");
		return "redirect:/";
	}
	
	@GetMapping("formlogin")
	public String login(	@RequestParam("user") String u,
							@RequestParam("pass") String p,
							HttpServletRequest request)
	{
		Map<String,String> utente = du.trovaUtente(u, p);
		System.out.println("Utente: " + utente);
		if(utente != null)
		{
			System.out.println("LOGIN EFFETTUATO");
			HttpSession session = request.getSession(true);
			session.setAttribute("utenteloggato",utente);
		}
		
//		if(utente ) --> aggiungere metodo riconosci Admin
		return "redirect:/";
	}
	
	private void deleteCookies(	HttpServletRequest request,
								HttpServletResponse response)
	{
		Cookie[] cookies = request.getCookies();
		for(Cookie cookie : cookies)
		{
			cookie.setMaxAge(0);
			cookie.setPath(request.getContextPath() + "/");
			response.addCookie(cookie);
		}
	}
	
	@GetMapping("logout")
	public String logout(	HttpServletRequest request,
							HttpServletResponse response)
	{
		HttpSession session = request.getSession(false);
		try
		{
			session.invalidate();
			deleteCookies(request,response);
			System.out.println("Sessione terminata!");
		}
		catch(IllegalStateException e)
		{
			e.printStackTrace();
			System.out.println("Non è stato possibile terminare la sessione");
		}
		return "redirect:/";
	}
}

