<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
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
<title>Insert title here</title>

<style>
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
	.popup{
		background-color:rgba(0,0,0,0.6);
		width: 100%;
		height:100%;
		display: flex;
		justify-content: center;
		align-items: center;
		position: absolute;
		top:0;
		z-index:10;
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
		z-index:10;
		display: flex;
		align-items: center;
		justify-content: center;	
	}
</style>
</head>
<body>
<div class="popup">
	<div class="popup-content">
		<a href="" class="btn2">ASsda</a>
	</div>
</div>


	<div class="contenedor">
		 <h1>Turnos</h1>
		
		
			
			<form action="altaT.html" method="post">
			<input class="btn btnAgregar" type="submit" id="btnAgregar" value="Agregar" />
			</form>
			
			
			<table id="tabla" class ="display">
			<thead>
				<tr>
					<th>ID</th>
					<th>Estado</th>
					<th>Fecha</th>
					<th>Hora</th>
					<th>Observacion</th>
					<th>Medico</th>
					<th>Paciente</th>
					
				</tr>
				</thead>
				<c:forEach var="lista" items="${listaTurnos}">
					 <tr>
					  <td ><c:out value="${lista.id}" /></td>
	                   <td ><c:out value="${lista.estado}" /></td>
	                   <td ><c:out value="${lista.fecha}" /></td>
	                   <td ><c:out value="${lista.hora}" /></td>
	                   <td ><c:out value="${lista.observacion}" /></td>
	                   <td ><c:out value="${lista.medico.legajo}" /></td>
	                   <td ><c:out value="${lista.paciente.dni}" /></td>
	                </tr>
	               
	            </c:forEach>
			</table>	

		</div>
 	 		<script type="text/javascript">
								
								
				document.getElementById('btnAgregar').addEventListener('click',function()
						{
							document.querySelector('.popup').style.display = 'flex';
						})
		
						
						document.querySelector('.btn2').addEventListener('click',function()
								{
							document.querySelector('.popup').style.display = 'none';
								})

				</script>
</body>
</html>