package com.negozio.dolcebannato.controllers;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;


@Controller
public class HomeController
{
	@GetMapping("/")
	public String home(HttpServletRequest request)
	{
		HttpSession session = request.getSession(false);
		if(session == null)
			return "utenti/formlogin.html";
		return "home.html";
	}
}
