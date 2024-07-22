<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
     <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
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

        form {
            display: flex;
            flex-direction: column;
            
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

        input[type="submit"] {
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
	

</style>
</head>
<body>
		
	<div class="container">
			<h1>Registrar Paciente</h1>
			
			<form action="agregarPaciente.html" method="post" >
 	
 		         <fieldset>
                <legend>Información Personal</legend>
               	<label>Nombre: </label>
 			<input type="text" id="txtNombre" name="txtNombre"></input>
 			<label>Apellido: </label>
 			<input type="text" id="txtApellido" name="txtApellido"></input>
 			<label>DNI: </label>
 			<input type="text"  name="txtDni"></input>
 			<label>Direccion: </label>
 			<input type="text" id="txtDireccion" name="txtDireccion"></input>
 			<label>Localidad: </label>
 			<input type="text" id="txtLocalidad" name="txtLocalidad"></input>
 			<label>Provincia: </label>
 			<input type="text" id="txtProvincia" name="txtProvincia"></input>
 			<label for="fechaNacimiento">Fecha de Nacimiento:</label>
                <input type="date" id="fechaNacimiento" name="fechaNacimiento" required />

 			
            </fieldset>

            <fieldset>
                <legend>Contacto</legend>
                <label>Correo Electronico: </label>
	 			<input type="text" id="txtCorreo" name="txtCorreo" ></input>
	 			<label>Telefono: </label>
	 			<input type="text" id="txtTelefono" name="txtTelefono" ></input>
            </fieldset>

  

            <input type="submit" value="Guardar" />
 	
 	</form>
 			<c:if test="${pacienteAgregado==true}">
		<% System.out.println("paciente agregado");%>
		<label>agregado! </label>
		</c:if>	
			
			</div>

			
 			
		
		
		
</body>
</html>