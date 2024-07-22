<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
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

</head>
<body>
		
	
	<div class="container"> 
			<h1>Modificar Paciente</h1>
			
			<form action="modificarPaciente2.html" method="get" >
 	
 		         <fieldset>
                <legend>Información Personal</legend>
               	<label>Nombre: </label>
 			<input type="text" id="txtNombre" name="txtNombre" value="${pacienteAux.nombre}"></input>
 			<label>Apellido: </label>
 			<input type="text" id="txtApellido" name="txtApellido" value="${pacienteAux.apellido}"></input>
 			<label>DNI: </label>
 			<input type="text"  name="txtDni"value="${pacienteAux.dni}"></input>
 			<label>Direccion: </label>
 			<input type="text" id="txtDireccion" name="txtDireccion" value="${pacienteAux.direccion}"></input>
 			<label>Localidad: </label>
 			<input type="text" id="txtLocalidad" name="txtLocalidad" value="${pacienteAux.localidad}"></input>
 			<label>Provincia: </label>
 			<input type="text" id="txtProvincia" name="txtProvincia" value="${pacienteAux.provincia}"></input>
 			<label for="fechaNacimiento">Fecha de Nacimiento:</label>
                <input type="date" id="fechaNacimiento" name="fechaNacimiento" required value="${pacienteAux.fecha_nacimiento}"/>

 			
            </fieldset>

            <fieldset>
                <legend>Contacto</legend>
                <label>Correo Electronico: </label>
	 			<input type="text" id="txtCorreo" name="txtCorreo" value="${pacienteAux.correo_electronico}"></input>
	 			<label>Telefono: </label>
	 			<input type="text" id="txtTelefono" name="txtTelefono" value="${pacienteAux.telefono}"></input>
            </fieldset>

  

            <input type="submit" value="Guardar Cambios"/>
 	
 			</form>
 	</div>
</body>
</html>