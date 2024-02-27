<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    <% String nome = (String) request.getAttribute("nomeAccessori"); %>
<% List<Map<String,String>> lista = (List<Map<String,String>>) request.getAttribute("elencoaccessori"); %>  
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ELENCO ACCESSORI</title>
	</head>
	<body>
	<h1><%=nome %></h1><br>
			<a href="/">HOME</a>  -  <a href="/accessori/formnuovo">Inserisci nuovo Accessorio</a><br><br>
			<h2>Elenco accessori</h2>
			
			<% for(Map<String,String> m : lista){ %>
			<%=m.get("idAcc") %> -
			<%=m.get("tipologia") %> -
			<%=m.get("marca") %> -
			<%=m.get("stile") %> -
			<%=m.get("materiale") %> -
			<%=m.get("dettagli") %> -
			<%=m.get("prezzo") %> -
			<%=m.get("qnt") %> -
			<a href="/accessori/dettaglio?id=<%=m.get("id")%>" >Dettaglio</a>
			<br>
			<%} %>
	</body>
</html>