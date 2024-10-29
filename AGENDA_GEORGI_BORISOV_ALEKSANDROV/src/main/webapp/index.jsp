<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="modelo.Contacto" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Agenda de Contactos</title>
</head>
<body>

      <%
        String mensaje = (String) request.getAttribute("mensaje");
        if (mensaje != null) {
        %>
            <div class="alert alert-success" role="alert">
                <strong><%= mensaje %></strong>
            </div>
        <%
        }
        %>
<form action="AddContactoServet" style="width: 300px; margin: 0 auto; padding: 20px; border: 2px solid #ccc; border-radius: 8px; box-shadow: 0px 0px 10px rgba(0,0,0,0.1);" method="post">
    <p>
        <label for="nombreContacto">Nombre:</label>
        <input type="text" id="nombreContacto" name="nombreContacto" style="width: 100%;" >
        <%
        if(request.getParameter("errores")!=null){
        	
        }
        %>
    </p>
    <p>
        <label for="apellidosContacto">Apellidos:</label>
        <input type="text" id="apellidosContacto" name="apellidosContacto" style="width: 100%;" >
    </p>
    <p>
        <label for="emailContacto">Email:</label>
        <input type="text" id="emailContacto" name="emailContacto" style="width: 100%;" >
    </p>
    <p>
        <label for="telefonoContacto">Teléfono:</label>
        <input type="tel" id="telefonoContacto" name="telefonoContacto" style="width: 100%;" >
    </p>
    <p>
        <input type="submit" value="Enviar" style="width: 100%; padding: 10px; background-color: #4CAF50; color: white; border: none; border-radius: 4px;">
    </p>
</form>

<% 
    ArrayList<String> errores = (ArrayList<String>) request.getAttribute("noValidados");
    if (errores != null && !errores.isEmpty()) {
%>
    <div class="errores">
        <ul>
            <% for (String error : errores) { %>
                <li><%= error %></li>
            <% } %>
        </ul>
    </div>
<% 
    } 
%>

<%
    // Verificar que el atributo "agenda" no sea nulo
    if (request.getAttribute("contactos") != null) {
        // Obtener la lista de contactos como ArrayList<Contacto>
        ArrayList<Contacto> lista = (ArrayList<Contacto>) request.getAttribute("contactos");
%>
        <div style="display: flex; justify-content: center; align-items: center; flex-direction: column;">
            <table style="border-collapse: collapse; width: 80%; margin: 20px 0; text-align: center;">
                <thead>
                    <tr style="background-color: #f2f2f2;">
                        <th>ID</th>
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
                        <td><%= contacto.getId() %></td>
                        <td><%= contacto.getNombre() %></td>
                        <td><%= contacto.getApellidos() %></td>
                        <td><%= contacto.getEmail() %></td>
                        <td><%= contacto.getNumTelefono() %></td>
                        <td>
                            <a href="UpdateContactoServlet?userID=<%= contacto.getId() %>">Editar</a>
                            <a href="DeleteContactoServlet?userID=<%= contacto.getId() %>">Eliminar</a>
                        </td>
                    </tr>
<%
                } // Fin del bucle for
%>
                </tbody>
            </table>
        </div>
<%
    } else {
%>
        <p>No hay contactos en la agenda.</p>
<%
    }
%>

</body>
</html>

