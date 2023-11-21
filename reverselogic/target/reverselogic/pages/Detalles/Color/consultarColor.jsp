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
    <title>Listado De Colores</title>
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
                    <li><a href="Color?enviar=color"><button>Volver</button> </a></li>
                    <li><a href="index.jsp"><button>Menu</button> </a></li>
                    <li>
                                <form action="LogoutServlet" method="post">
                                    <button type="submit" class="btnSalir">Salir</button>
                                </form> 
                            </li>  
                </ul>
            </li>
        </ul>
    </div>
    

    </header>
    <br><br>
    <%@ page import="model.Color.ColorVo" %>
    <%@ page import="model.Color.ColorDao" %>

    <%-- Obtener la lista de usuarios desde la base de datos --%>
    <% List<ColorVo> colores = null;
        try {
            colores = new ColorDao().listarColor();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    <%-- Verificar si hay usuarios y mostrarlos --%>
    <% if (colores != null && !colores.isEmpty()) { %>
            <%-- Recorrer la lista de productos y mostrar sus detalles --%>
                <div class="card__container">
                    <% for (ColorVo color : colores) { %>
                        <div class="card">
                            <div class="card--img">
                            </div>
                            <div class="card--info">
                                <p class="card--subtittle">Id Color</p>
                                <p id="Color_Id_<%= color.getColor_Id() %>" class="cardColor_Id" ><%= color.getColor_Id() %></id></p>
                                 <br>
                                <p class="card--subtittle">NOMBRE  DEL COLOR</p>
                                <p id="Color_Nombre_<%= color.getColor_Id() %>" class="cardColor_Nombre" ><%= color.getColor_Nombre() %></p>
                                <br>
                                <form action="<%= request.getContextPath() %>/Color" method="post">
                                    <input type="hidden" name="enviar" value="eliminarColor">
                                    <input type="hidden" name="Color_Id" value="<%= color.getColor_Id() %>">
                                    <button type="submit" class="btn-delete">Eliminar</button><br>
                                </form>
                                <br>
                            <button class="btncal" data-color-id="<%= color.getColor_Id() %>">Actualizar</button>
                            </div>
                            
                        </div>
                    <% } %>
                <% } else { %>
                    <div class="card">
                        <p>No se encontraron usuarios.</p>
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

<h2>Actualizar Color</h2>
<br><br>
<form action="Color" method="post">

    <br>
    <br>
    <div class="contlabel">
        <input type="text" name="Color_Id" id="Color_Id" >
        <label for="Color_Id"> ID Color</label>
    </div>

    <br>
    <br>
    <div class="contlabel">
        <input type="text" name="Color_Nombre" id="Color_Nombre">
        <label for="Color_Nombre"> Nombre Del Color</label>
    </div>
    
    <br>
    <br> 

<button class="btncal" name="enviar" value="updateColor">Enviar</button>

</form>
</div>
</div>
<% } %>
            
            <script type="text/javascript" src="js/modal7.js"></script>
            </body>
</html>