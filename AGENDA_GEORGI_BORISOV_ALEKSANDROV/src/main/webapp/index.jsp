<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="modelo.Contacto" %>
<%@ page import="modelo.Agenda" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
</head>
<body>

<form style="width: 300px; margin: 0 auto; padding: 20px; border: 2px solid #ccc; border-radius: 8px; box-shadow: 0px 0px 10px rgba(0,0,0,0.1);" action="tuServlet" method="post">
    <p>
        <label for="nombreContacto">Nombre:</label>
        <input type="text" id="nombreContacto" name="nombreContacto" style="width: 100%;">
    </p>
    <p>
        <label for="apellidosContacto">Apellidos:</label>
        <input type="text" id="apellidosContacto" name="apellidosContacto" style="width: 100%;">
    </p>
    <p>
        <label for="emailContacto">Email:</label>
        <input type="email" id="emailContacto" name="emailContacto" style="width: 100%;">
    </p>
    <p>
        <label for="telefonoContacto">Teléfono:</label>
        <input type="tel" id="telefonoContacto" name="telefonoContacto" style="width: 100%;">
    </p>
    <p>
        <input type="submit" value="Enviar" style="width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 4px;">
    </p>
</form>

<%
    if (request.getAttribute("agenda") != null) {
        Agenda agenda = (Agenda) request.getAttribute("agenda");
        ArrayList<Contacto> lista = agenda.getPersonas();
%>
        <div style="display: flex; justify-content: center; align-items: center; flex-direction: column;">
            <table style="border-collapse: collapse; width: 80%; margin: 20px 0; text-align: center;">
                <thead>
                    <tr style="background-color: #f2f2f2;">
                        <th>Nombre</th>
                        <th>Apellidos</th>
                        <th>Email</th>
                        <th>Teléfono</th>
                        <th>Acciones</th>
                    </tr>
                </thead>
                <tbody>
<%
                for (Contacto contacto : lista) {
%>
                    <tr>
                        <td><%= contacto.getNombre() %></td>
                        <td><%= contacto.getApellidos() %></td>
                        <td><%= contacto.getEmail() %></td>
                        <td><%= contacto.getNumTelefono() %></td>
                        <td>
                            <a href="#">Editar</a> |
                            <a href="#">Eliminar</a>
                        </td>
                    </tr>
<%
                }
%>
                </tbody>
            </table>
        </div>
<%
    }
%>

</body>
</html>
