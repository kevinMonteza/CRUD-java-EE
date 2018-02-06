<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ page import="java.util.*,com.cursomvc.pack.*" %>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>CRUD PRODUCTOS</title>
<%
	//Optiene los productos del controlador
	List<Producto> listaP= (List<Producto>) request.getAttribute("ListaProductos");

%>
<style type="text/css">
	th{
		font-size:1.2em;
		color:#ffffff;
		background-color: #08088A;
		
	}
	.filas{
		text_aling:center;
		background-color:#5882FA;
		
	
	}
	table{
		float:left;
	}
	#ContBoton{
		margin-left:700px;
	}


</style>
</head>
<body>
	<table>
	 <tr>
		<th>Codigo Articulo</th>
		<th>Seccion</th>
		<th>Nombre Articulo</th>
		<th>Fecha</th>
		<th>Precio</th>
		<th>Importado</th>
		<th>Pais Origen</th>
		<th>Accion</th>
	</tr>
	<% for(Producto pro: listaP) { %>
	
	<!--  Link para cada producto con su codigo respectivo -->

		<c:url var="linkUpdate" value="ControladorProductos">
			<c:param name="instruccion" value="cargar"></c:param>
			<c:param name="cArt" value="<%=pro.getcArt()%>"></c:param>
		</c:url>
		
		<c:url var="linkDelete" value="ControladorProductos">
			<c:param name="instruccion" value="eliminar"></c:param>
			<c:param name="cArt" value="<%=pro.getcArt()%>"></c:param>
		</c:url>


		<tr>
		<td class="filas"><%=pro.getcArt() %></td>
		<td class="filas"><%=pro.getSeccion() %></td>
		<td class="filas"><%=pro.getnArt() %></td>
	    <td class="filas"><%=pro.getFecha() %></td>
	    <td class="filas"><%=pro.getPrecio() %></td>
		<td class="filas"><%=pro.getImportado() %></td>
  	    <td class="filas"><%=pro.getPaisO()%></td>
  	    <td class="filas"><a href="${linkUpdate }">Actualizar/&nbsp;</a><a href="${linkDelete }">Eliminar</a></td>
	 </tr>
	 <%} %>
	</table>
	<div id="ContBoton">
		<input type="button" value="INSERTAR" onclick="window.location.href='insertar_prod.jsp'"/>
	
	</div>


</body>
</html>