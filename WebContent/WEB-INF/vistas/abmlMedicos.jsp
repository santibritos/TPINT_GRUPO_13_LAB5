<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Medicos</title>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
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
   <style type="text/css">

body
{
#f5f5f5;
}
.contenedor
{
	
	display: column;
}
.side
{
	width:1%;
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

			<h1>Medicos</h1>

            <form action="redireccionar_agregarMedico.html" method="get" >
        	
            <input type="submit" class="btn btn-success" value="Agregar Medico" name="btnRedirigir">
       
        	</form>



        <table id="tabla"  class = "display">
            <thead>
              <tr>
					<th>Legajo</th>
					<th>Nombre</th>
					<th>Apellido</th>
					<th>Sexo</th>
					<th>Fecha Nacimiento</th>
					<th>Direccion</th>
					<th>Localidad</th>
					<th>Correo Electronico</th>
					<th>Telefono</th>
					<th>Horario</th>
					<th>Especialidad</th>
					<th>Usuario</th>
					<th>Acciones</th>
				</tr>
            </thead>
             <tbody>
             <c:forEach items="${listaMedicos}" var="medico">
	               <c:if test="${medico.estado == true}" >
	                <tr>              
	                    <td>${medico.legajo}</td>
			            <td>${medico.nombre}</td>
			            <td>${medico.apellido}</td>
			            <td>${medico.sexo}</td>
			            <td>${medico.fecha_nacimiento}</td>
			            <td>${medico.direccion}</td>
			            <td>${medico.localidad}</td>
			            <td>${medico.correoElectronico}</td>
			            <td>${medico.telefono}</td>
			            <td>${medico.horario}</td>
			            <td>${medico.especialidad.nombre}</td>
			            <td>${medico.usuario.usuario}</td>
						<td>
	                     <a href = "modificarMedico${medico.legajo}.html" class = "btn btn-primary">Actualizar</a>
	                     <a href = "delete${medico.legajo}.html" class = "btn btn-danger">Delete</a><br/>
	                    </td>
	                </tr>
	                </c:if>
               	</c:forEach>
            </tbody>	 
            
        	 
        </table>
     </div>
         
</body>
</html>