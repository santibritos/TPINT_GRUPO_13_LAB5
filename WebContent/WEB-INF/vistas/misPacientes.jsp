<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
<head>
<script
  src="https://code.jquery.com/jquery-3.7.1.js"
  integrity="sha256-eKhayi8LEQwp4NKxN+CfCh+3qOVUtJn3QNZ0TciWLP4="
  crossorigin="anonymous"></script>
<link rel="stylesheet" href="https://cdn.datatables.net/2.0.8/css/dataTables.dataTables.css" />
  
	<script src="https://cdn.datatables.net/2.0.8/js/dataTables.js">	
	</script>
<script type="text/javascript">

	$(document).ready( function () {
	    $('#tabla').DataTable();
	    console.log('hola');
	} );

</script>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Pacientes</title>

<style type="text/css">

body
{
#f5f5f5;
}
.contenedor
{
	margin-left:100px;
	display: column;
}

h1
{
margin-top: 50px;
margin-bottom: 75px;
}
filtro
{
	display:flex;
}
</style>
</head>
<body>
		
		<div class="contenedor">
		 <h1> Pacientes</h1>
		
		
			<table id="tabla" class ="display">
			<thead>
				<tr>
					<th>DNI</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Fecha de nacimiento</th>
					<th>Correo electronico</th>
					<th>Telefono</th>
					<th>Direccion</th>
					<th>Localidad</th>
					<th>Provincia</th>
					<th>Estado</th>
				</tr>
				</thead>
				<c:forEach var="paciente" items="${listaPacientes}">
					 <tr>
					  <td ><c:out value="${paciente.dni}" /></td>
	                    <td ><c:out value="${paciente.nombre}" /></td>
	                    <td ><c:out value="${paciente.apellido}" /></td>
	                    <td ><c:out value="${paciente.fecha_nacimiento}" /></td>
	                    <td ><c:out value="${paciente.correo_electronico}" /></td>
	                    <td ><c:out value="${paciente.telefono}" /></td>
	                    <td ><c:out value="${paciente.direccion}" /></td>
	                    <td ><c:out value="${paciente.localidad}" /></td>
	                    <td ><c:out value="${paciente.provincia}" /></td>
	                    <td ><c:out value="${paciente.estado}" /></td>
	                </tr>
	               
	            </c:forEach>
			</table>	

		</div>
</body>
</html>