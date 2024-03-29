<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% String nome = (String) request.getAttribute("nomeAbbigliamento"); %>
<% List<Map<String,String>> lista = (List<Map<String,String>>) request.getAttribute("elencoabbigliamenti"); %>  
 
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ELENCO ABBIGLIAMENTO</title>
		<link rel="stylesheet" href="..\stile1.css">
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
			<a href="mostracarrello">MOSTRA CARRELLO COMPLETO</a><br>
			<h2>Elenco abbigliamento</h2>
			<hr>
			<br>
			<table>
				<tr>
					<td>
						ID
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
						TAGLIA
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
						<%= m.get("idabb") %>
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
						<%= m.get("taglia") %>
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
			<a href="aggiungicarrello?idabb=<%=m.get("idabb") %>">AGGIUNGI AL CARRELLO</a> 
			<br>
			<%} %>
			</table>
	</body>
</html>