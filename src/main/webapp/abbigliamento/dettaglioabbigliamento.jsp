<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<% Map<String,String> mappa = (Map<String,String>) request.getAttribute("abbigliamento"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>ABBIGLIAMENTO</title>
<link rel="stylesheet" href="..\stile1.css">
</head>
<body>
	<a href="/abbigliamento/elencoabbigliamenti">INDIETRO</a>
	<h2>Dettaglio</h2>
	<br>
	<hr>
	<div>
		<div>
			<label for="id">ID:</label>
			<%= mappa.get("idAbb") %>
		</div>
		<div>
			<label for="tipologia">TIPOLOGIA:</label>
			<%= mappa.get("tipologia") %>
		</div>
		<div>
			<label for="marca">MARCA:</label>
			<%= mappa.get("marca") %>
		</div>
		<div>
			<label for="stile">STILE:</label>
			<%= mappa.get("stile") %>
		</div>
		<div>
			<label for="materiale">MATERIALE:</label>
			<%= mappa.get("materiale") %>
		</div>
		<div>
			<label for="taglia">TAGLIA:</label>
			<%= mappa.get("taglia") %>
		</div>

		<div>
			<label for="dettagli">DETTAGLI:</label>
			<%= mappa.get("dettagli") %>
		</div>

		<div>
			<label for="prezzo">PREZZO:</label>
			<%= mappa.get("prezzo") %>
		</div>
		<br>
	</div>
</body>
</html>