<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% Map<String,String> mappa = (Map<String,String>) request.getAttribute("abbigliamento"); %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>ABBIGLIAMENTO</title>
	</head>
	<body>
	<a href="/abbigliamento/elencoabigliamenti">INDIETRO</a>
		<h2>Dettaglio</h2> <br><hr>
		ID: <%= mappa.get("idAbb") %> <br>
		TIPOLOGIA: <%= mappa.get("tipologia") %> <br>
		MARCA: <%= mappa.get("marca") %> <br>
		STILE: <%= mappa.get("stile") %> <br>
		MATERIALE: <%= mappa.get("materiale") %> <br>
		TAGLIA: <%= mappa.get("taglia") %> <br>
		DETTAGLI: <%= mappa.get("dettagli") %> <br>
		PREZZO: <%= mappa.get("prezzo") %> <br>
		DISPONIBILITA: <%= mappa.get("qnt") %> <br>
		<br>
	</body>
</html>