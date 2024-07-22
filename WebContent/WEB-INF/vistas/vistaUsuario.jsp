<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
         <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Vista usuario</title>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">

<style type="text/css">
* {
    margin: 0;
    padding: 0;
    box-sizing: border-box;
    font-family: 'Arial';
    
}
body
{
 	display: column;
    justify-content: center;
    background-color:#f5f5f5;
	
}
	.container
	{
		display:grid;
		grid-template-columns: 15% 80%;
		margin:0;
	    padding: 0;
		top-magin: 0;
	}
	.side
	{
		display:column;
		justify-content: center;
		height: 100%;
	}
	.sideBar
	{
		
	}
	.header
	{
		margin:0;
		padding: 0;
		height: 50px;
		width: 100%;
		background-color: #7DAF9C;
	}
	.content
	{
		display:flex;
		
		justify-content: space-around;
		align-items: flex-start;
	}
	.btnCerrar
	{
		margin-left: 950px;
	}
	.btnAgregar
	{
	  background-color: #04AA6D; /* Green */
		  border: none;
		  color: white;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		  font-size: 16px;
		margin-bottom: 10px;
		width: 100px;
		height: 40px;
	}
	.btnModificar
	{
		  background-color: blue; 
		  border: none;
		  color: white;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		  font-size: 16px;
		margin-bottom: 3px;
		width: 100px;
		height: 40px;
	}
	.btnBorrar
	{
		 background-color: red; 
		  border: none;
		  color: white;
		  text-align: center;
		  text-decoration: none;
		  display: inline-block;
		  font-size: 16px;
		margin-bottom: 3px;
		width: 100px;
		height: 40px;
	}
	.btnBuscar
	{
		height: 40px;
		width: 85px;
		background-color: #D0D0D0;
	}

	.popup{
		background-color:rgba(0,0,0,0.6);
		width: 100%;
		height:100%;
		display: flex;
		justify-content: center;
		align-items: center;
		position: absolute;
		top:0;
		display:none;
			
	}
	.popup-content
	{
		border-radius: 10px;
		height: 250px;
		width: 500px;
		padding: 20px;
		position: relative;
		background-color: #fff;
		
		display: flex;
		align-items: center;
		justify-content: center;	
	}
</style>

</head>
<body>

<div class="header">
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
        <a class="nav-link" href="misTurnos.html">Mis Turnos</a>
      </li>
       <li class="nav-item">
       		<form action="pacientes.html" method="post"> 
			 <a class="nav-link" href="misPacientes.html">Pacientes</a>
		</form>
         <li class="nav-item">
       <a class="nav-link" th:href="@{/students}">Usuario: ${username}</a>
      </li>
        <li class="nav-item">
        <a class="nav-link btnCerrar" href="cerrar.html">Cerrar Sesion</a>
      </li>
    </ul>
  </div>
</nav>
	 </div>
	<div class="container">
		<div class="side">
		
			
			
		
			
		</div>
		<div class="content">
		
				<c:if test="${clickMisPacientes==true}">
		<% System.out.println("PASO POR EL test mis pacientes");%>
		<%@include file="misPacientes.jsp"%>
		</c:if>	
			<c:if test="${clickMisTurnos==true}">
		<% System.out.println("PASO POR EL test mis turnos");%>
		<%@include file="misTurnos.jsp"%>
		</c:if>
			<c:if test="${clickModificarTurno==true}">
		<% System.out.println("PASO POR EL test modificar");%>
		<%@include file="modificarTurno.jsp"%>
		</c:if>		
		</div>
	</div>	

</body>
</html>