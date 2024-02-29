<%@page import="java.util.Map"%>
<%@ page language="java" 
		 contentType="text/html; charset=UTF-8"
   		 pageEncoding="UTF-8"%>
<% Map<String,String> m = (Map<String,String>) request.getAttribute("accessoriomod"); %> <!-- qui -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modifica accessorio <%= m.get("idacc")%></title>
</head>
<body>
	Modifica accessorio <%= m.get("idacc")%>
	<hr>
	<br>
	
	<form action="aggiorna" method="get">
		ID: <input type="text" name="idacc" value="<%= m.get("idacc")%>" readonly><br>
		MARCA: <input type="text" name="marca" value="<%= m.get("marca")%>"><br>
		STILE: <input type="text" name="stile" value="<%= m.get("stile")%>"><br>
		MATERIALE: <input type="text" name="materiale" value="<%= m.get("materiale")%>"><br>
		DETTAGLI: <input type="text" name="dettagli" value="<%= m.get("dettagli")%>"><br>
		PREZZO: <input type="text" name="prezzo" value="<%= m.get("prezzo")%>"><br>
		QNT: <input type="text" name="qnt" value="<%= m.get("qnt")%>"><br>
		<input type="submit" value="AGGIORNA">
	</form>
</body>
</html>