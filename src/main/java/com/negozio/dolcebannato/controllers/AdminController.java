//package com.negozio.dolcebannato.controllers;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//
//import com.negozio.dolcebannato.dao.DAOUtenti;
//
//@Controller
//@RequestMapping("/adminConsole")
//public class AdminController 
//{
//	@Autowired
//	private DAOUtenti du;
//	
//	@GetMapping("/adminHome")
//	public String adminElenco(Model model)
//	{
//		model.addAttribute("nomeNegozio","Dolce&Bannato");
//		model.addAttribute("adminHome", du.trovaUtente(null, null))
//	}
//}
