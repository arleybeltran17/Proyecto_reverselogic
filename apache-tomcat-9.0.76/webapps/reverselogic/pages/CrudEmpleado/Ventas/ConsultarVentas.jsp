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
                    <li><a href="index.jsp"><button>Menú</button> </a></li>
                    <li><a href="#"><button>Salir</button> </a></li>
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
                                <img src="img/icons8-usuario-100.png" alt="" width="150px" height="150px">
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
                                <p id="Clie_Id_<%= venta.getVent_Id() %>" class="cardClie_Id" ><%= venta.getClie_Id() %> </p>
                                <br>
                                <p class="card--subtittle">Id Del Metodo De Pago</p>
                                <p id="Metod_Id_<%= venta.getVent_Id() %>" class="cardMetod_Id"><%= venta.getMetod_Id() %> </p>
                                <br>
                                <p class="card--subtittle">Id De La Prenda</p>
                                <p id="Prend_Id_<%= venta.getVent_Id() %>" class="cardPrend_Id"><%= venta.getPrend_Id() %> </p>
                                <br>
                            </div>
                            
                        </div>
                    <% } %>
                <% } else { %>
                    <div class="card">
                        <p>No se encontraron ventas.</p>
                    </div>
                <% } %>
            </div>
        </div>
    </div>
    <script type="text/javascript" src="js/modal6.js"></script>
</body>
</html>