<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% String nome = (String) request.getAttribute("nomeScarpe"); %>
<% List<Map<String,String>> lista = (List<Map<String,String>>) request.getAttribute("elencoscarpe"); %>  
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ELENCO SCARPE</title>
	</head>
	<body>
	
	<h1><%=nome %></h1><br>
			<a href="/">HOME</a>  -  <a href="/scarpe/formnuovo">Inserisci nuova scarpa</a><br><br>
			<h2>Elenco scarpe</h2>
			
			<% for(Map<String,String> m : lista){ %>
			<%=m.get("idsca") %> - 
			<%=m.get("tipologia") %> - 
			<%=m.get("marca") %> - 
			<%=m.get("stile") %> - 
			<%=m.get("materiale") %> - 
			<%=m.get("numero") %> - 
			<%=m.get("dettagli") %> - 
			<%=m.get("prezzo") %> - 
			<%=m.get("qnt") %>
			<a href="/adminConsole/adminSchermataModSca?id=<%=m.get("id")%>" >Dettaglio</a>
			<br>
			<%} %>
	</body>
</html>