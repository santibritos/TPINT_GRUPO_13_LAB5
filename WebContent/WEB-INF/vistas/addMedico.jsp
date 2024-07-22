<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Alta Medico</title>
<link rel="stylesheet"
    href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css"
    integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm"
    crossorigin="anonymous">
</head>
<body>

<div class="container">
       <h1>Registrar Médico</h1>
        
        <form action="nuevoMedico.html" method="post" >
		
            <fieldset>
                <legend>Información Personal</legend>
                <label for="numeroLegajo">Número de Legajo</label>
                <input type="text"  name="legajo" required />

                <label for="nombre">Nombre</label>
                <input type="text" name="nombre" required />

                <label for="apellido">Apellido</label>
                <input type="text"  name="apellido" required />

                <label for="sexo">Sexo</label>
                <input type="text" name="sexo"required />

                <label for="fecha_Nacimiento">Fecha de Nacimiento</label>
                <input type="date" name="fecha_nacimiento" required />

                <label for="direccion">Dirección</label>
                <input type="text" name="direccion" required />

                <label for="localidad">Localidad</label>
                <input type="text" name="localidad"  required />
            </fieldset>

            <fieldset>
                <legend>Contacto</legend>
                <label for="correoElectronico">Correo Electrónico</label>
                <input type="email" name="correoElectronico"required />

                <label for="telefono">Teléfono</label>
                <input type="text" name="telefono"  />
            </fieldset>

            <fieldset>
                <legend>Detalles Profesionales</legend>
                <label for="horarios">Horarios</label>
                <input type="text" name="horario" required />


                <label for="especialidad">Especialidad</label>
                <select name="especialidad">
				    	<c:forEach items="${designation}" var="dd" >
				        <option value="${dd.getId()}">${dd.getNombre()}</option>
				        </c:forEach>
				</select>
<!-- 
              //   <label for="estado">Estado</label>
                <select id="estado" name="estado" required>
                    <option value="Activo">Activo</option>
                    <option value="Inactivo">Inactivo</option>
                </select>
            </fieldset> -->

            <fieldset>
                <legend>Información de Cuenta</legend>
                <label for="username">Número Usuario</label>
                <input type="text" name="username" required />

                <label for="password">Contraseña</label>
                <input type="password" name="password" required />
            </fieldset>

            <input type="submit" value="Guardar" />
        </form>
    </div>


</body>
</html>