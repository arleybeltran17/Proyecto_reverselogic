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
    <title>Listado De Devolucion</title>
</head>
<body>
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
                    <li><a href="DevolucionEmple?enviar=DevolucionEmple"><button>Volver</button> </a></li>
                    <li><a href="MenuEmpleado?enviar=menu"><button>Menu</button> </a></li>
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
    
    <%@ page import="model.Devolucion.DevolucionVo" %>
    <%@ page import="model.Devolucion.DevolucionDao" %>

    <%-- Obtener la lista de usuarios desde la base de datos --%>
    <% List<DevolucionVo> devoluciones = null;
        try {
            devoluciones= new DevolucionDao().listarDevo();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    <%-- Verificar si hay devoluciones y mostrarlos --%>
    <% if (devoluciones != null && !devoluciones.isEmpty()) { %>
            <%-- Recorrer la lista de productos y mostrar sus detalles --%>
                <div class="card__container">
                    <% for (DevolucionVo devolucion : devoluciones) { %>
                        <div class="card">
                            <div class="card--img">
                                <img src="img/icons8-usuario-100.png" alt="a" width="150px" height="150px">
                            </div>
                            <div class="card--info">
                                <p class="card--subtittle">Cantidad Producto</p>
                                <p id="Devo_Cant_Preducto<%= devolucion.getDevo_id() %>" class="cardCantidadDevo"><%= devolucion.getDevo_Cant_Preducto() %></id></p>
                                 <p class="card--subtittle">Razon</p>
                                <p id="Devo_Razon<%= devolucion.getDevo_id() %>" class="cardRazonDevo"><%= devolucion.getDevo_Razon() %></p>
                                <p class="card--subtittle">Fecha</p>
                                <p id="Devo_Fecha<%= devolucion.getDevo_id() %>" class="cardDevoFecha"><%= devolucion.getDevo_Fecha() %></p>
                                <p class="card--subtittle">Id Empleado</p>
                                <p id="Emple_id_<%= devolucion.getDevo_id() %>" class="cardEmpleidDevo"><%= devolucion.getEmple_id() %></p>
                            </div>
                            
                        </div>
                    <% } %>
                <% } else { %>
                    <div class="card">
                        <p>No se encontraron .</p>
                    </div>
                <% } %>
            </div>
        </div>
    </div>
    </body>

            <script type="text/javascript" src="js/modal3.js"></script>
            </body>
</html>