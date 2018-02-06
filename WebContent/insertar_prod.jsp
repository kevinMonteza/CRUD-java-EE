<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Formulario de ingreso</title>
</head>
<body>
<FORM ACTION="ControladorProductos" METHOD=GET>
<input type="hidden" name="instruccion" value="insertar"/>
<CENTER>
<TABLE BORDER>

<TR>
   <TD>Codigo Articulo:</TD>
   <TD><INPUT TYPE="text" NAME="CodArt" SIZE=45 MAXLENGTH=18></TD>
</TR>

<TR>
   <TD>Seccion:</TD>
   <TD> <INPUT TYPE="text" NAME="seccion" SIZE=45 MAXLENGTH=48></TD>

<TR>
  <TD>Nombre Articulo:</TD>
  <TD> <INPUT TYPE="text" NAME="nomArt" SIZE=45 MAXLENGTH=5></TD>

<TR>
   <TD>Fecha: </TD>
   <TD> <INPUT TYPE="date" NAME="fecha" ></TD>

<TR>
   <TD>Precio:</TD>
   <TD><input type="text" name="precio"/ size=45></TD>

<TR>
   <TD>Importado</TD>
   <TD> <input type="text" NAME="import" size=45></TD>
 <TR>
   <TD>Pais Origen</TD>
   <TD> <input type="text" NAME="origin" size=45></TD>  


<TR>
   <TD><B>Pulse aquí:</B></TD>
   <TD ALIGN=CENTER>
       <INPUT TYPE="submit" VALUE="Enviar datos ">
       <INPUT TYPE="reset" VALUE="Borrar los datos"></TD>

</TABLE>
</CENTER>
</FORM>
</body>
</html>