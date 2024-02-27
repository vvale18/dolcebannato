<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<% Map<String,String> mappa = (Map<String,String>) request.getAttribute("scarpe"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>DETTAGLI</title>
	</head>
	<body>
	<a href="/adminConsole/adminSchermata">INDIETRO</a>
		ID SCARPA <%= mappa.get("id") %><br>
		TIPOLOGIA SCARPA <%= mappa.get("tipologia") %><br>
		MARCA SCARPA <%= mappa.get("marca") %><br>
		STILE SCARPA <%= mappa.get("stile") %><br>
		MATERIALE SCARPA <%= mappa.get("materiale") %><br>
		NUMERO SCARPA <%= mappa.get("numero") %><br>
		COLORE SCARPA <%= mappa.get("colore") %><br>
		DETTAGLI SCARPA <%= mappa.get("dettagli") %><br>
		PREZZO SCARPA <%= mappa.get("prezzo") %><br>
		QUANTITA SCARPA <%= mappa.get("qnt") %><br>
		<a href="/scarpe/formod?id=<%= mappa.get("id")%>">Modifica</a>
		<a href="/scarpe/elimina?id=<%=mappa.get("IDAcc")%>">ELIMINA</a> -
	</body>
</html>