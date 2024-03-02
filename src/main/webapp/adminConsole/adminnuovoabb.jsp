<%@page import="java.util.Map"%>
<%@ page language="java"
		 ontentType="text/html; charset=UTF-8"
   		 pageEncoding="UTF-8"%>
<% Map<String,String> a = (Map<String,String>) request.getAttribute("abbigliamento"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dettaglio abbigliamento</title>
	</head>
	<body>
		ID: <%= a.get("id") %> <br>
		MARCA: <%= a.get("marca") %> <br>
		STILE: <%= a.get("stile") %> <br>
		MATERIALE: <%= a.get("materiale") %> <br>
		TAGLIA: <%= a.get("taglia") %> <br>
		DETTAGLI: <%= a.get("dettagli") %> <br>
		PREZZO: <%= a.get("prezzo") %> <br>
		QUANTITA: <%= a.get("qnt") %><br>
		<br>
		<a href="abbigliamento/formnuovo?id=<%=a.get("id")%>">NUOVO</a>
	</body>
</html>