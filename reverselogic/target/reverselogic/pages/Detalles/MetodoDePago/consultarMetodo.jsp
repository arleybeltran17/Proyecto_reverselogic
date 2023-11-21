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
    <title>Listado De Metodo De Pago</title>
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
                        <li><a href="MetodoDePago?enviar=metodo"><button>Volver</button> </a></li>
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
    <%@ page import="model.MetodoDePago.MetodoDePagoVo" %>
    <%@ page import="model.MetodoDePago.MetodoDePagoDao" %>

    <%-- Obtener la lista de usuarios desde la base de datos --%>
    <% List<MetodoDePagoVo> metodos = null;
        try {
            metodos = new MetodoDePagoDao().listarMetod();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    <%-- Verificar si hay usuarios y mostrarlos --%>
    <% if (metodos != null && !metodos.isEmpty()) { %>
            <%-- Recorrer la lista de productos y mostrar sus detalles --%>
                <div class="card__container">
                    <% for (MetodoDePagoVo metodo : metodos) { %>
                        <div class="card">
                            <div class="card--img">
                            </div>
                            <div class="card--info">
                                <p class="card--subtittle">Id Metodo De Pago</p>
                                <p id="Metod_Id_<%= metodo.getMetod_Id() %>" class="cardMetod_Id" ><%= metodo.getMetod_Id() %></id></p>
                                 <br>
                                <p class="card--subtittle">Tipo de Metodo De Pago</p>
                                <p id="Metod_Tipo_<%= metodo.getMetod_Id() %>" class="cardMetod_Tipo" ><%= metodo.getMetod_Tipo() %></p>
                                <br>
                                <form action="<%= request.getContextPath() %>/MetodoDePago" method="post">
                                    <input type="hidden" name="enviar" value="eliminarMetod">
                                    <input type="hidden" name="Metod_Id" value="<%= metodo.getMetod_Id() %>">
                                    <button type="submit" class="btn-delete">Eliminar</button><br>
                                </form>
                                <br>
                            <button class="btncal" data-metod-id="<%= metodo.getMetod_Id() %>">Actualizar</button>
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

<h2>Actualizar Metodo De Pago</h2>
<br><br>
<form action="MetodoDePago" method="post">

    <br>
    <br>
    <div class="contlabel">
        <input type="text" name="Metod_Id" id="Metod_Id" >
        <label for="Metod_Id"> ID Metodo</label>
    </div>

    <br>
    <br>
    <div class="contlabel">
        <input type="text" name="Metod_Tipo" id="Metod_Tipo">
        <label for="Metod_Tipo"> Tipo De Metodo De Pago</label>
    </div>
    
    <br>
    <br> 

<button class="btncal" name="enviar" value="updateMetod">Enviar</button>

</form>
</div>
</div>
<% } %>
        <script type="text/javascript" src="js/modal9.js"></script>
    </body>
</html>