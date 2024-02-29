<%@page import="java.util.Map"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
   		 pageEncoding="UTF-8"%>
<% Map<String,String> m = (Map<String,String>) request.getAttribute("abbigliamentomod"); %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifica capo <%= m.get("idabb")%></title>
</head>
<body>
	Modifica capo <%= m.get("idabb")%>
	<hr>
	<br>
	
	<form action="aggiorna" method="get">
		ID: <input type="text" name="idabb" value="<%= m.get("idabb")%>" readonly><br>
		TIPOLOGIA: <input type="text" name="tipologia" value="<%= m.get("tipologia")%>"><br>
		MARCA: <input type="text" name="marca" value="<%= m.get("marca")%>"><br>
		STILE: <input type="text" name="stile" value="<%= m.get("stile")%>"><br>
		MATERIALE: <input type="text" name="materiale" value="<%= m.get("materiale")%>"><br>
		TAGLIA: <input type="text" name="taglia" value="<%= m.get("taglia")%>"><br>
		DETTAGLI: <input type="text" name="dettagli" value="<%= m.get("dettagli")%>"><br>
		QNT: <input type="text" name="qnt" value="<%= m.get("qnt")%>"><br>
		PREZZO: <input type="text" name="prezzo" value="<%= m.get("prezzo")%>"><br>
		<input type="submit" value="AGGIORNA">
	</form>
</body>
</html>