<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% List<Map<String,String>> mappe = (List<Map<String,String>>) request.getAttribute("elencoscarpe"); %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>DETTAGLI</title>
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
	<a href="../adminHome.html">INDIETRO</a>
		<h2>SCARPE</h2>
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
		<% for(Map<String, String> m : mappe) {%>
		<tr>
			<td>
				<%= m.get("idsca") %>
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
				<a href="/scarpe/formodsca?idsca=<%=m.get("idsca")%>">MODIFICA</a>
			</td>
			<td>
				<a href="/scarpe/eliminascarpa?idsca=<%=m.get("idsca")%>">ELIMINA</a>
			</td>
		</tr>
		<%} %>
		</table>
</body>
</html>