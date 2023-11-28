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
                        <li><a href="MenuEmpleado?enviar=menu"><button>Menu</button> </a></li>
                        <li><a href="ColoresEmple?enviar=Color"><button>Volver</button> </a></li> 
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
                                <br>
                            </div>
                            
                        </div>
                    <% } %>
                <% } else { %>
                    <div class="card">
                        <p>No Se Encontraron Colores.</p>
                    </div>
                <% } %>
            </div>
        </div>
    </div>
    
            
            <script type="text/javascript" src="js/modal7.js"></script>
            </body>
</html>