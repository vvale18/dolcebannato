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
		<style>
		body
		{
			font-family: Arial, Verdana, Sans-serif;
			font-size: 15px;	
		}
		table
		{
			border: solid 1px pink;
			margin-top:5px;
		}
		table td
		{
			border: solid 1px green;
			padding 5px;
		}
		table td:hover
		{
			background-color: green;
			color: white;
		}
	</style>
	</head>
	<body>
	<h1><%=nome %></h1><br>
			<a href="../home.html">HOME</a><br>
			<a href="mostracarrello">MOSTRA CARRELLO</a><br>
			<h2>Elenco scarpe</h2>
			<hr>
			<br>
			<table>
				<tr>
					<td>
						ID
					</td>
					<td>
						TIPOLOGIA
					</td>
					<td>
						MARCA
					</td>
					<td>
						STILE
					</td>
					<td>
						MATERIALE
					</td>
					<td>
						NUMERO
					</td>
					<td>
						COLORE
					</td>
					<td>
						DETTAGLI
					</td>
					<td>
						PREZZO
					</td>
					<td>
						QTA
					</td>
				</tr>
				<% for(Map<String, String> m : lista) {%>
				<tr>
					<td>
						<%= m.get("idsca") %>
					</td>
					<td>
						<%= m.get("tipologia") %>
					</td>
					<td>
						<%= m.get("marca") %>
					</td>
					<td>
						<%=m.get("stile") %>
					</td>
					<td>
						<%= m.get("materiale") %>
					</td>
					<td>
						<%= m.get("numero") %>
					</td>
					<td>
						<%= m.get("colore") %>
					</td>
					<td>
						<%= m.get("dettagli") %>
					</td>
					<td>
						<%= m.get("prezzo") %>
					</td>
					<td>
						<%= m.get("qnt") %>
					</td>
					<td>
			<a href="aggiungicarrello?idsca=<%=m.get("idsca")%>" >COMPRA</a>
			<br>
			<%} %>
	</body>
</html>