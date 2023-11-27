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
    <title>Listado De Venta</title>
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
                        <li><a href="Venta?enviar=venta"><button>Volver</button> </a></li>
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
    <%@ page import="model.Venta.VentaVo" %>
    <%@ page import="model.Venta.VentaDao" %>

    <%-- Obtener la lista de usuarios desde la base de datos --%>
    <% List<VentaVo> ventas = null;
        try {
            ventas = new VentaDao().listarVent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    <%-- Verificar si hay ventas y mostrarlos --%>
    <% if (ventas != null && !ventas.isEmpty()) { %>
            <%-- Recorrer la lista de productos y mostrar sus detalles --%>
                <div class="card__container">
                    <% for (VentaVo venta : ventas ) { %>
                        <div class="card">
                            <div class="card--img">
                            </div>
                            <div class="card--info">
                                <p class="card--subtittle">Cantidad De La Venta</p>
                                <p id="Vent_Cantidad_<%= venta.getVent_Id() %>" class="cardVent_Cantidad" ><%= venta.getVent_Cantidad() %></p>
                                <br>
                                <p class="card--subtittle">Fecha</p>
                                <p id="Vent_Fecha_<%= venta.getVent_Id() %>" class="cardVent_Fecha" ><%= venta.getVent_Fecha() %></p>
                                <br>
                                <p class="card--subtittle">Id Del Usuario </p>
                                <p id="Usu_Id_<%= venta.getVent_Id() %>" class="cardUsu_Id"><%= venta.getUsu_Id() %></p>
                                <br>
                                <p class="card--subtittle">Id Del Cliente</p>
                                <p id="Clie_Id_<%= venta.getVent_Id() %>" class="cardClie_Id" ><%= venta.getClie_Id() %></p>
                                <br>
                                <p class="card--subtittle">Id Del Metodo De Pago</p>
                                <p id="Metod_Id_<%= venta.getVent_Id() %>" class="cardMetod_Id"><%= venta.getMetod_Id() %></p>
                                <br>
                                <p class="card--subtittle">Id De La Prenda</p>
                                <p id="Prend_Id_<%= venta.getVent_Id() %>" class="cardPrend_Id"><%= venta.getPrend_Id() %></p>
                                <br>
                                <form action="<%= request.getContextPath() %>/Venta" method="post">
                                    <input type="hidden" name="enviar" value="eliminarVent">
                                    <input type="hidden" name="Vent_Id" value="<%= venta.getVent_Id() %>">
                                    <button type="submit" class="btn-delete">Eliminar</button><br>
                                </form>
                                <br>
                            <button class="btncal" data-venta-id="<%= venta.getVent_Id() %>">Actualizar</button>
                            </div>
                            
                        </div>
                    <% } %>
                <% } else { %>
                    <div class="card">
                        <p>No Se Encontraron Ventas.</p>
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

<h2>Actualizar Venta</h2>
<br><br>
<form action="Venta" method="post">

    <br>
    <br>
    <div class="contlabel">
        <input type="text" name="Vent_Id" id="Vent_Id" >
        <label for="Vent_Id"> ID Venta</label>
    </div>

    <br>
    <br>
    <div class="contlabel">
        <input type="number" name="Vent_Cantidad" id="Vent_Cantidad" required> 
        <label for="Vent_Cantidad"> Cantidad de la venta</label>
    </div>
    
    <br>
    <br>
    <div class="contlabel1">
        <input type="Date" name="Vent_Fecha" id="Vent_Fecha" >
        <label for="Vent_Fecha"> Fecha de la venta</label>
    </div>
    
    <br>
    <br>
    <div class="contlabel2">
        <input type="text" name="Usu_Id" id="Usu_Id" >
        <label for="Usu_Id"> Id Del Usuario</label>
    </div>
    
    <br>
    <br>
    <div class="contlabel3">
        <input type="text" name="Clie_Id" id="Clie_Id"  >
        <label for="Clie_Id"> Id Del Cliente</label>
    </div>

    <br>
    <br>
    <div class="contlabel4">
        <input type="text" name="Metod_Id" id="Metod_Id"  >
        <label for="Metod_Id"> Id Del Metodo De Pago</label>
    </div>
     
    <br>
    <br>   
    <div class="contlabel5">
        <input type="text" name="Prend_Id" id="Prend_Id" >
        <label for="Prend_Id"> Id De La Prenda</label>
    </div>
    <br>
    <br> 

<button class="btncal" name="enviar" value="updateVent">Enviar</button>

</form>
</div>
</div>
<% } %>
            <script type="text/javascript" src="js/modal61.js"></script>
            </body>
</html>