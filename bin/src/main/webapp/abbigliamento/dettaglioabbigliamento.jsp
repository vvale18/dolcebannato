<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% Map<String,String> mappa = (Map<String,String>) request.getAttribute("abbigliamento"); %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>dettagli</title>
</head>
<body>
	<a href="/abbigliamento/elenco">Torna all'elenco</a>
		<h2>Dettaglio</h2> <br><hr>
		ID: <%= mappa.get("id") %> <br>
		TIPOLOGIA: <%= mappa.get("tipologia") %> <br>
		MARCA: <%= mappa.get("marca") %> <br>
		STILE: <%= mappa.get("stile") %> <br>
		MATERIALE: <%= mappa.get("materiale") %> <br>
		TAGLIA: <%= mappa.get("taglia") %> <br>
		DETTAGLI: <%= mappa.get("dettagli") %> <br>
		PREZZO: <%= mappa.get("prezzo") %> <br>
		<br>
		<a href="/abbigliamento/formod?id=<%=mappa.get("id")%>">MODIFICA</a> - 
		<a href="/abbigliamento/eliminaabbigliamento?id=<%=mappa.get("id")%>">ELIMINA</a> - 
	
</body>
</html>