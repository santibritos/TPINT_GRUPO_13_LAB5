<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>
   body {
   
            font-family: Arial, sans-serif;
            background-color: #f5f5f5;
          
        }

        .container {
        	
        	display:flex;
        	flex-direction:column;
            background-color: #fff;
            padding: 15px;
            border-radius: 8px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            width: 80%;
            align-items:center;
            magin-left:200px;
          /* Reducido de 400px a 200px */
        }

        h1 {
            text-align: center;
            
            font-size: 2em; /* Ajustar el tamaño de la fuente */
            margin-top: 20px;
			margin-bottom: 20px;
        }

        fieldset {
            border: none;
            margin-bottom: 10px;
            padding: 0; /* Eliminar el padding para ahorrar espacio */
        }

        legend {
            font-weight: bold;
            margin-bottom: 8px;
            font-size: 1em; /* Ajustar el tamaño de la fuente */
        }

        label {
            margin-bottom: 3px;
            font-weight: bold;
            font-size: 0.9em; /* Ajustar el tamaño de la fuente */
        }

        input[type="text"], input[type="email"], input[type="password"], input[type="date"] {
            width: 100%;
            padding: 6px;
            margin-bottom: 8px;
            border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 0.9em; /* Ajustar el tamaño de la fuente */
        }

        .radio-group, .checkbox-group {
            display: ;
            justify-content: space-between;
            margin-bottom: 8px;
        }

        input[type="radio"], input[type="checkbox"] {
            margin-right: 5px;
        }

        .btnAgregar {
        width: 100px;
			height: 40px;
            padding: 8px;
            background-color: #28a745;
            border: none;
            border-radius: 4px;
            color: white;
            font-weight: bold;
            cursor: pointer;
            margin-top: 10px;
            font-size: 0.9em; /* Ajustar el tamaño de la fuente */
        }

        input[type="submit"]:hover {
            background-color: #218838;
        }
	
			.btncancel{
			width: 100px;
			height: 40px;
				padding: 8px;
            background-color: grey;
            border: none;
            border-radius: 4px;
            color: white;
            font-weight: bold;
            cursor: pointer;
            margin-top: 10px;
            font-size: 0.9em;
			}
</style>
</head>
<body>

<div class="container">
			<h1>Registrar Turno</h1>
			
			<form action="agregarTurno.html" method="post" >
 	
 		         <fieldset>
                <legend>Medico:</legend>
               	 <label for="especialidad">Especialidad:</label><br>
                <select name="especialidad">
				    	<c:forEach items="${designation}" var="dd" >
				        <option value="${dd.getId()}">${dd.getNombre()}</option>
				        </c:forEach>
				</select>
			<br>
			<br>	
			<label>Legajo: </label>
 			<input type="text" id="txtLegajo" name="legajo"></input>
 			 </fieldset>
 			
 			<label>DNI Paciente: </label>
 			<input type="text"  name="dni"></input>
 			<label for="fecha">Fecha:</label>
                <input type="date" id="fecha" name="fecha" required />
                
                <label>hora: </label>
	 			<input id="appt-time" type="time" name="hora"  />
				<br>
			<br>
  

            <input type="submit" value="Guardar"  class="btnAgregar"/>
            <a href="turnos.html" class="btncancel" >Cancelar</a>
 	
 	</form>
 			<c:if test="${pacienteAgregado==true}">
		<% System.out.println("paciente agregado");%>
		<label>agregado! </label>
		</c:if>	
			
			</div>
		  
</body>
</html>