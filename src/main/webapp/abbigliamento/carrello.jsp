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
			<a href="/">HOME</a><br>
			<a href="svuotacarrello">SVUOTA CARRELLO</a><br>
			<h2>Elenco abbigliamento</h2>
			
			<table>
			<tr>
				<td>ID</td>
				<td>DATA</td>
				<td>MARCA</td>
				<td>TAGLIA</td>
				<td>PREZZO</td>
				<td>IDPRODOTTO</td>
				<td>IDUTENTE</td>
				<td>IDABB</td>
			</tr>
				<% for(Map<String,String> m : lista){ %>
				<tr>
					<td><%=m.get("id") %></td>
					<td><%=m.get("data") %></td>
					<td><%=m.get("marca") %></td>
					<td><%=m.get("taglia") %></td>
					<td><%=m.get("prezzo") %></td>
					<td><%=m.get("idprodotto") %></td>
					<td><%=m.get("idutente") %></td>
					<td><%=m.get("idabb") %></td>
				</tr>
				<%} %>
			</table>
	</body>
</html>