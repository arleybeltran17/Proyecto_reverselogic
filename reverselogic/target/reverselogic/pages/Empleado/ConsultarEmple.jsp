<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8" %>

<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/cards.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/usuario.css">
    <link rel="stylesheet" href="<%= request.getContextPath() %>/css/style.css">
    <title>Listado De Empleados</title>
</head>
<body >
    <div class="cont2"></div>
        <div class="all">
    <header>
        <img src="<%= request.getContextPath() %>/img/logo-removebg-preview.png" alt="Mi Imagen">
        
        
    <div class="menu">
        <ul>
            <li class="submenu">
                <a href="#"><img class="imgbtn" src="<%= request.getContextPath() %>/img/usuario-de-perfil.png" alt="Usuario"></a>
                <ul>
                    <li><a href="#"><button>Perfil</button></a></li>
                        <li><a href="Empleado?enviar=empleado"><button>Volver</button> </a></li>
                        <li><a href="index.jsp"><button>Menu</button> </a></li>
                    <li>
                        <form action="CerrarSesion" method="post">
                            <button type="submit" class="btnSalir">Salir</button>
                        </form> 
                    </li>  
                </ul>
            </li>
        </ul>
    </div>
    

    </header>
    <br><br>
    <%@ page import="model.Empleado.EmpleadoVo" %>
    <%@ page import="model.Empleado.EmpleadoDao" %>

    <%-- Obtener la lista de usuarios desde la base de datos --%>
    <% List<EmpleadoVo> empleados = null;
        try {
            empleados = new EmpleadoDao().listarEmple();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    <%-- Verificar si hay usuarios y mostrarlos --%>
    <% if (empleados != null && !empleados.isEmpty()) { %>
            <%-- Recorrer la lista de productos y mostrar sus detalles --%>
                <div class="card__container">
                    <% for (EmpleadoVo empleado : empleados) { %>
                        <div class="card">
                            <div class="card--img">
                            </div>
                            <div class="card--info">
                                <p class="card--subtittle">TIPO DOCUMENTO</p>
                                <p id="Emple_Tipo_Doc_<%= empleado.getEmple_Id() %>" class="cardEmpleTipoDoc" ><%= empleado.getEmple_Tipo_Doc() %></id></p>
                                 <br>
                                <p class="card--subtittle">NUMERO DOCUMENTO</p>
                                <p id="Emple_Num_Doc_<%= empleado.getEmple_Id() %>" class="cardEmpleNumDoc" ><%= empleado.getEmple_Num_Doc() %></p>
                                <br>
                                <p class="card--subtittle">NOMBRE</p>
                                <p id="Emple_Nombre_<%= empleado.getEmple_Id() %>" class="cardEmpleNombre" ><%= empleado.getEmple_Nombre() %></p>
                                <br>
                                <p class="card--subtittle">APELLIDO</p>
                                <p id="Emple_Apellido_<%= empleado.getEmple_Id() %>" class="cardEmpleApellido"><%= empleado.getEmple_Apellido() %></p>
                                <br>
                                <p class="card--subtittle">CARGO</p>
                                <p id="Emple_Cargo_<%= empleado.getEmple_Id() %>" class="cardEmpleCargo" ><%= empleado.getEmple_Cargo() %> </p>
                                <br>
                                <p class="card--subtittle">DIRECCION</p>
                                <p id="Emple_Direccion_<%= empleado.getEmple_Id() %>" class="cardEmpleDireccion"><%= empleado.getEmple_Direccion() %> </p>
                                <br>
                                <p class="card--subtittle">CORREO</p>
                                <p id="Emple_Email_<%= empleado.getEmple_Id() %>" class="cardEmpleEmail"><%= empleado.getEmple_Email() %> </p>
                                <br>
                                <form action="<%= request.getContextPath() %>/Empleado" method="post">
                                    <input type="hidden" name="enviar" value="eliminarEmple">
                                    <input type="hidden" name="Emple_Id" value="<%= empleado.getEmple_Id() %>">
                                    <button type="submit" class="btn-delete">Eliminar</button><br>
                                </form>
                                <br>
                            <button class="btncal" data-emple-id="<%= empleado.getEmple_Id() %>">Actualizar</button>
                            </div>
                            
                        </div>
                    <% } %>
                <% } else { %>
                    <div class="card">
                        <p>No Se Encontraron Empleados.</p>
                    </div>
                <% } %>
            </div>
        </div>
    </div>
    <% 
Boolean mostrarModal = (Boolean) session.getAttribute("mostrarModalActualizacion");
if (mostrarModal != null && mostrarModal) {
    // Inicialmente, muestra la ventana modal
    session.setAttribute("mostrarModalActualizacion", false); // Para evitar que se muestre en futuras cargas
%>
<div id="myModal1" class="modal1">
<div class="modal-content1">
<span class="close1">X</span>

<h2>Actualizar Empleado</h2>
<br><br>
<form action="Empleado" method="post">

    <br>
    <br>
    <div class="contlabel">
        <input type="text" name="Emple_Id" id="Emple_Id" >
        <label for="Emple_Id"> ID Empleado</label>
    </div>

    <br>
    <br>
    <div class="contlabel">
        <input type="text" name="Emple_Tipo_Doc" id="Emple_Tipo_Doc">
        <label for="Emple_Tipo_Doc"> Tipo De Documento</label>
    </div>
    
    <br>
    <br>
    <div class="contlabel1">
        <input type="text" name="Emple_Num_Doc" id="Emple_Num_Doc" >
        <label for="Emple_Num_Doc"> Numero De Documento</label>
    </div>
    
    <br>
    <br>
    <div class="contlabel2">
        <input type="text" name="Emple_Nombre" id="Emple_Nombre" >
        <label for="Emple_Nombre"> Nombre</label>
    </div>
    
    <br>
    <br>
    <div class="contlabel3">
        <input type="text" name="Emple_Apellido" id="Emple_Apellido"  >
        <label for="Emple_Apellido"> Apellido</label>
    </div>

    <br>
    <br>
    <div class="contlabel4">
        <input type="text" name="Emple_Cargo" id="Emple_Cargo"  >
        <label for="Emple_Cargo"> Cargo</label>
    </div>
     
    <br>
    <br>   
    <div class="contlabel5">
        <input type="text" name="Emple_Direccion" id="Emple_Direccion" >
        <label for="Emple_Direccion"> Direccion</label>
    </div>
      
    <br>
    <br>  
    <div class="contlabel6">
        <input type="text" name="Emple_Email" id="Emple_Email" >
        <label for="Emple_Email"> Email</label>
    </div>
    
    <br>
    <br> 

<button class="btncal" name="enviar" value="updateEmple">Enviar</button>

</form>
</div>
</div>
<% } %>
            
            <script type="text/javascript" src="js/modal1.js"></script>
            </body>
</html>