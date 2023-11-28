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
    <title>Listado De Prendas</title>
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
                        <li><a href="PrendasEmple?enviar=prendasEmple"><button>Volver</button> </a></li>
                        <li><a href="menuEmp.jsp"><button>Menu</button> </a></li>
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
    <%@ page import="model.Prenda.PrendaVo" %>
    <%@ page import="model.Prenda.PrendaDao" %>

    <%-- Obtener la lista de usuarios desde la base de datos --%>
    <% List<PrendaVo> prendas = null;
        try {
            prendas= new PrendaDao().listaPrend();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    <%-- Verificar si hay usuarios y mostrarlos --%>
    <% if (prendas != null && !prendas.isEmpty()) { %>
            <%-- Recorrer la lista de productos y mostrar sus detalles --%>
                <div class="card__container">
                    <% for (PrendaVo prenda: prendas) { %>
                        <div class="card">
                            <div class="card--img">
                                <img src="img/icons8-usuario-100.png" alt="" width="150px" height="150px">
                            </div>
                            <div class="card--info">
                                <p class="card--subtittle">Marca Prenda</p>
                                <p id="Prend_Marca<%= prenda.getPrend_Id() %>" class="cardPrend_Marca" ><%= prenda.getPrend_Marca() %></p>
                                <br>
                                <p class="card--subtittle">Talla Prenda</p>
                                <p id="Prend_Talla<%= prenda.getPrend_Id() %>" class="cardPrend_Talla" ><%= prenda.getPrend_Talla() %></p>
                                <br>
                                <p class="card--subtittle">Descripcion Prenda</p>
                                <p id="Prenda_Descrip<%= prenda.getPrend_Id() %>" class="cardPrend_Descrip" ><%= prenda.getPrend_Descrip() %></p>
                                <br>
                                <p class="card--subtittle">ID Material</p>
                                <p id="Mate_Id<%= prenda.getPrend_Id() %>" class="cardMate_Id" ><%= prenda.getMate_Id() %></p>
                                <br>
                                <p class="card--subtittle">ID Color</p>
                                <p id="Color_Id<%= prenda.getPrend_Id() %>" class="cardColor_Id" ><%= prenda.getColor_Id() %></p>
                                <br>
                                <p class="card--subtittle">ID Producto</p>
                                <p id="Prod_Id<%= prenda.getPrend_Id() %>" class="cardProd_Id" ><%= prenda.getProd_Id() %></p>
                                <br>  
                                <br>
                            </div>
                        </div>
                    <% } %>
                <% } else { %>
                    <div class="card">
                        <p>No se encontraron Prendas.</p>
                    </div>
                <% } %>
            </div>
        </div>
    </div>
            
            <script type="text/javascript" src="js/modal5.js"></script>
            </body>
</html>