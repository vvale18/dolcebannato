<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String nome = (String) request.getAttribute("nomeAbbigliamento"); %>
<% List<Map<String,String>> lista = (List<Map<String,String>>) request.getAttribute("elencoabbigliamenti"); %>  
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ELENCO ABBIGLIAMENTO</title>
	</head>
	<body>
	<h1><%=nome %></h1><br>
			<a href="/">HOME</a>  -  <a href="/abbigliamento/formnuovo">Inserisci nuovo Abbigliamento</a><br><br>
			<h2>Elenco abbigliamento</h2>
			
			<% for(Map<String,String> m : lista){ %>
			<%=m.get("idAbb") %> -
			<%=m.get("tipologia") %> -
			<%=m.get("marca") %> -
			<%=m.get("stile") %> -
			<%=m.get("materiale") %> -
			<%=m.get("taglia") %> -
			<%=m.get("dettagli") %> -
			<%=m.get("prezzo") %> -
			<a href="/abbigliamento/dettaglio?id=<%=m.get("id")%>" >Dettaglio</a>
			<br>
			<%} %>
	</body>
</html>