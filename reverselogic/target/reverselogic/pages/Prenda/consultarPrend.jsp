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
                    <li><a href="Prenda?enviar=prenda"><button>Menú</button> </a></li>
                    <li> 
                        <form action="CerrarSesion" method="post">
                            <input type="submit" class="btnSalir" value="Salir">
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
                                <form action="<%= request.getContextPath() %>/Prenda" method="post">
                                    <input type="hidden" name="enviar" value="eliminarPrend">
                                    <input type="hidden" name="Prend_Id" value="<%= prenda.getPrend_Id() %>">
                                    <button type="submit" class="btn-delete">Eliminar</button><br>
                                </form>
                                <br>
                            <button class="btncal" data-prend-id="<%= prenda.getPrend_Id()%>">Actualizar</button>
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
    <% 
    Boolean mostrarModal = (Boolean) session.getAttribute("mostrarModalActualizacion");
    if (mostrarModal != null && mostrarModal) {
        // Inicialmente, muestra la ventana modal
        session.setAttribute("mostrarModalActualizacion", false); // Para evitar que se muestre en futuras cargas
    %>
    <div id="myModal1" class="modal1">
    <div class="modal-content1">
    <span class="close1">X</span>
    
    <h2>Actualizar Prenda</h2>
    <br><br>
    <form action="Prenda" method="post">
    
        <br>
        <br>
        <div class="contlabel">
            <input type="text" name="Prend_Id" id="Prend_Id" >
            <label for="Prend_Id"> ID Venta</label>
        </div>
        <br>
        <br>
        <div class="contlabel">
            <input type="text" name="Prend_Marca" id="Prend_Marca">
            <label for="Prend_Marca"> Marca De La Prenda</label>
        </div>
        <br>
        <br>
        <div class="contlabel1">
            <input type="text" name="Prend_Talla" id="Prend_Talla" >
            <label for="Prend_Talla"> Prenda De Talla</label>
        </div>
        <br>
        <br>
        <div class="contlabel2">
            <input type="text" name="Prend_Descrip" id="Prend_Descrip" >
            <label for="Prend_Descrip">Descripcion De Prenda </label>
        </div>
        <br>
        <br>
        <div class="contlabel3">
            <input type="text" name="Mate_Id" id="Mate_Id"  >
            <label for="Mate_Id"> Apellido</label>
        </div>
        <br>
        <br>
        <div class="contlabel4">
            <input type="text" name="Color_Id" id="Color_Id"  >
            <label for="Color_Id"> ID Color</label>
        </div>
        <br>
        <br>   
        <div class="contlabel5">
            <input type="text" name="Prod_Id" id="Prod_Id" >
            <label for="Prod_Id"> ID Producto</label>
        </div>
        <br>
        <br>  
    <button class="btncal" name="enviar" value="updatePrend">Enviar</button>
    
    </form>
    </div>
    </div>
    <% } %>
            
            <script type="text/javascript" src="js/modal5.js"></script>
            </body>
</html>