<%@ page language="java" 
	contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.Map" %>
<% Map<String,String> s = (Map<String,String>) request.getAttribute("scarpe"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dettaglio</title>
	</head>
	<body>
		ID SCARPA <%= s.get("id") %><br>
		TIPOLOGIA SCARPA <%= s.get("tipologia") %><br>
		MARCA SCARPA <%= s.get("marca") %><br>
		STILE SCARPA <%= s.get("stile") %><br>
		MATERIALE SCARPA <%= s.get("materiale") %><br>
		NUMERO SCARPA <%= s.get("numero") %><br>
		COLORE SCARPA <%= s.get("colore") %><br>
		DETTAGLI SCARPA <%= s.get("dettagli") %><br>
		PREZZO SCARPA <%= s.get("prezzo") %><br>
		QUANTITA SCARPA <%= s.get("qnt") %><br>
		<a href="/scarpe/formod?id=<%= s.get("id")%>">Modifica</a>
	</body>
</html>