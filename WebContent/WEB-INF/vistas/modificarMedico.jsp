<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
       
       
        <form action="actualizarMedico.${medico.legajo}.html" method="post" ${Medico}  >
         <h1>Actualizar Médico</h1>
            <fieldset>
                <legend>Información Personal</legend>
                <label for="numeroLegajo">Número de Legajo</label>
                <input type="text" id="numeroLegajo" name="numeroLegajo" value = "${Medico.legajo}"  required />

                <label for="nombre">Nombre</label>
                <input type="text" id="nombre" name="nombre" value="${Medico.nombre}" required />

                <label for="apellido">Apellido</label>
                <input type="text" id="apellido" name="apellido" value="${Medico.apellido}"required />

                <label for="sexo">Sexo</label>
                <input type="text" id="sexo" name="sexo" required  value="${Medico.sexo}"/>

                <label for="fechaNacimiento">Fecha de Nacimiento</label>
                <input type="date" id="fechaNacimiento" name="fechaNacimiento" required  value="${Medico.fecha_nacimiento}"/>

                <label for="direccion">Dirección</label>
                <input type="text" id="direccion" name="direccion" value="${Medico.direccion}" required />

                <label for="localidad">Localidad</label>
                <input type="text" id="localidad" name="localidad" value="${Medico.localidad}" required />
            </fieldset>

            <fieldset>
                <legend>Contacto</legend>
                <label for="correoElectronico">Correo Electrónico</label>
                <input type="email" id="correoElectronico" name="correoElectronico" value="${Medico.correoElectronico}" required />

                <label for="telefono">Teléfono</label>
                <input type="text" id="telefono" name="telefono" value="${Medico.telefono}" required />
            </fieldset>

            <fieldset>
                <legend>Detalles Profesionales</legend>
                <label for="horarios">Horarios</label>
                <input type="text" id="horarios" name="horarios" value="${Medico.horario}" required />


                <label for="especialidad">Especialidad</label>
                <select name="especialidad">
				    	<c:forEach items="${designation}" var="dd" >
				        <option value="${dd.getId()}">${dd.getNombre()}</option>
				        </c:forEach>
				</select>

                 <label for="estado">Estado</label>
                <select id="estado" name="estado" required>
                    <option value="Activo">Activo</option>
                    <option value="Inactivo">Inactivo</option>
                </select>
            </fieldset>

            <fieldset>
                <legend>Información de Cuenta</legend>
                <label for="username">Número Usuario</label>
                <input type="text" id="username" name="username" value="${Medico.usuario.usuario}" required />

                <label for="password">Contraseña</label>
                <input type="password" id="password" name="password" value="${Medico.nombre}" required />
            </fieldset>

            <input type="submit" value="Guardar" />
        </form>
    </div>


</body>
</html>