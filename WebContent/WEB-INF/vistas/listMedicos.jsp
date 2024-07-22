<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Medicos</title>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
</head>
<body>

 MEDICOS
    <nav class="navbar navbar-expand-md bg-dark navbar-dark">
  <!-- Brand -->
  <a class="navbar-brand" href="#">Sistema de Gestion Clinica Medica</a>

  <!-- Toggler/collapsibe Button -->
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsibleNavbar">
    <span class="navbar-toggler-icon"></span>
  </button>

  <!-- Navbar links -->
  <div class="collapse navbar-collapse" id="collapsibleNavbar">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" th:href="@{/students}">Gestion Administrativa</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" th:href="@{/students}">Gestion Medica</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" th:href="@{/students}">Cerrar Sesion</a>
      </li>
    </ul>
  </div>
</nav>

<div class="container text-center">
    <h2>Filtrar Paciente</h2>
    <form method="get" action="search" class="form-inline justify-content-center">
        <input type="text" name="keyword" class="form-control" /> &nbsp;
        <input type="submit" value="Search" class="btn btn-primary" />
    </form>
</div>
&nbsp;
<div class="container text-center">
    <div class="row justify-content-center">
        <form action="redireccionar_agregarMedico.html" method="get" >
        	<div class="col-lg-3">
            <input type="submit" class="btn btn-success" value="Agregar Medico" name="btnRedirigir">
        </div>
        </form>
        <div class="col-lg-3">
            <a href="/Medico/listar" class="btn btn-success"> Listar Medicos</a>
        </div>
    </div>
</div>
&nbsp; 

    <div class ="container" align="collapse">

        <table class = "table table-striped table-bordered">
            <thead class = "table-dark">
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
   					<a href = "<c:url value='/eliminarMedico${medico.legajo}' />" class = "btn btn-danger" > Borrar</a> 
                    </td>
                </tr>
               		</c:forEach>
            </tbody>	 
            
        	 
        </table>
        
    </div>

</body>
</html>