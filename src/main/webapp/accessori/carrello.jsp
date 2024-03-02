<%@page import="java.util.Map"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Map<String,String>> lista = (List<Map<String,String>>) request.getAttribute("prodottinelcarrello"); %>  
<% Map<String, String> utente = (Map<String, String>) request.getAttribute("utente"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>ELENCO ABBIGLIAMENTO</title>
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
	<h1>CARRELLO DI <%= utente.get("nome").toUpperCase() %></h1>
		<hr>
		<br>
			<a href="../home.html">HOME</a><br>
			<a href="svuotacarrello">SVUOTA CARRELLO</a><br>
			<h2>Elenco abbigliamento</h2>
			
			<table>
			<tr>
				<td>DATA</td>
				<td>IDUTENTE</td>
				<td>STILE</td>
				<td>PREZZO</td>
			</tr>
				<% double somma = 0; %>
				<% for(Map<String,String> m : lista){ %>
				<% if(m.get("stile") != null) {%>
				<% somma += Double.parseDouble(m.get("prezzo")); %>
				<tr>
					<td><%=m.get("data") %></td>
					<td><%=m.get("idutente") %></td>
					<td><%=m.get("stile") %></td>
					<td><%=m.get("prezzo") %></td>
				</tr>
				<%} %>
				<%} %>
			</table>
			<br>
			<h3>PREZZO TOTALE: <%=somma %>€</h3>
	</body>
</html>