<%@page import="java.util.Map"%>
<%@ page language="java"
		 ontentType="text/html; charset=UTF-8"
   		 pageEncoding="UTF-8"%>
<% Map<String,String> accessorio = (Map<String,String>) request.getAttribute("accessori"); %>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title>Dettaglio abbigliamento</title>
	</head>
	<body>
		ID: <%= accessorio.get("id") %> <br>
		MARCA: <%= accessorio.get("marca") %> <br>
		STILE: <%= accessorio.get("stile") %> <br>
		MATERIALE: <%= accessorio.get("materiale") %> <br>
		TAGLIA: <%= accessorio.get("taglia") %> <br>
		DETTAGLI: <%= accessorio.get("dettagli") %> <br>
		PREZZO: <%= accessorio.get("prezzo") %> <br>
		<br>
		<a href="accessori/formnuovo?id=<%=accessorio.get("id")%>">NUOVO</a>
	</body>
</html>