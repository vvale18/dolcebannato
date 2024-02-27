<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <% Map<String,String> mappa = (Map<String,String>) request.getAttribute("accessorio"); %>
    
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>dettagli</title>
	</head>
	<body>
		<a href="/vegetali/elenco">Torna all'elenco</a>
			<h2>Dettaglio</h2> <br><hr>
			ID: <%= mappa.get("IDAcc") %> <br>
			TIPOLOGIA: <%= mappa.get("tipologia") %> <br>
			MARCA: <%= mappa.get("marca") %> <br>
			STILE: <%= mappa.get("stile") %> <br>
			MATERIALE: <%= mappa.get("materiale") %> <br>
			DETTAGLI: <%= mappa.get("dettagli") %> <br>
			PREZZO: <%= mappa.get("prezzo") %> <br>
			DISPONIBILITA: <%= mappa.get("qnt") %> <br>
			<br>
			<a href="/accessori/modifica?id=<%=mappa.get("IDAcc")%>">MODIFICA</a> - 
			<a href="/accessori/elimina?id=<%=mappa.get("IDAcc")%>">ELIMINA</a> - 
		
	</body>
</html>