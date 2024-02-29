<%@page import="java.util.Map"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
   		 pageEncoding="UTF-8"%>
<% Map<String,String> m = (Map<String,String>) request.getAttribute("scarpamod"); %> <!-- quÃ¬ -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifica paio di scarpe <%= m.get("idsca")%></title>
</head>
<body>
	Modifica paio di scarpe <%= m.get("idsca")%>
	<hr>
	<br>
	
	<form action="aggiorna" method="get">
		ID: <input type="text" name="idsca" value="<%= m.get("idsca")%>" readonly><br>
		MARCA: <input type="text" name="marca" value="<%= m.get("marca")%>"><br>
		STILE: <input type="text" name="stile" value="<%= m.get("stile")%>"><br>
		MATERIALE: <input type="text" name="materiale" value="<%= m.get("materiale")%>"><br>
		NUMERO: <input type="text" name="numero" value="<%= m.get("numero")%>"><br>
		COLORE: <input type="text" name="colore" value="<%= m.get("colore")%>"><br>
		DETTAGLI: <input type="text" name="dettagli" value="<%= m.get("dettagli")%>"><br>
		PREZZO: <input type="text" name="prezzo" value="<%= m.get("prezzo")%>"><br>
		QNT: <input type="text" name="qnt" value="<%= m.get("qnt")%>"><br>
		<input type="submit" value="AGGIORNA">
	</form>
</body>
</html>