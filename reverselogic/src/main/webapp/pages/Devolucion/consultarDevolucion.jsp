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
                    <li><a href="Devolucion?enviar=devolucion"><button>Menu</button> </a></li>
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

                                <form action="<%= request.getContextPath() %>/Devolucion" method="post">
                                    <input type="hidden" name="enviar" value="eliminarDevo">
                                    <input type="hidden" name="Devo_id" value="<%= devolucion.getDevo_id() %>">
                                    <button type="submit" class="btn-delete">Eliminar</button>
                                </form>
                            <button class="btncal" data-devo-id="<%= devolucion.getDevo_id() %>">Actualizar</button>
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
            <% 
            Boolean mostrarModal = (Boolean) session.getAttribute("mostrarModalActualizacion");
            if (mostrarModal != null && mostrarModal) {
                // Inicialmente, muestra la ventana modal
                session.setAttribute("mostrarModalActualizacion", false); // Para evitar que se muestre en futuras cargas
            %>
            <div id="myModal1" class="modal1">
            <div class="modal-content1">
            <span class="close1">X</span>
        
            <h2>Actualizar Devolucion</h2>
            <form action="Devolucion" method="post">
        
            <label for="Devo_Id"> ID Devolucion</label>
            <input type="text" name="Devo_Id" id="Devo_Id"  placeholder="Ingrese El Id De La Devolucion">
    
            <label for="Devo_Cant_Preducto"> Cantidad De Producto</label>
            <input type="text" name="Devo_Cant_Preducto" id="Devo_Cant_Preducto" placeholder="Ingrese La Cantidad Del Producto">

            <label for="Devo_Razon"> Razon</label>
            <input type="text" name="Devo_Razon" id="Devo_Razon">
    
            <label for="Devo_Fecha"> Fecha</label>
            <input type="Date" name="Devo_Fecha" id="Devo_Fecha">

            <label for="Emple_id"> ID Empleado</label>
            <input type="text" name="Emple_id" id="Emple_id"  placeholder="Ingrese El Id Del Empleado">
    
            <button class="btncal" name="enviar" value="updateDevo">Enviar</button>
        
            </form>
            </div>
            </div>
            <% } %>

            <script type="text/javascript" src="js/modal3.js"></script>
            </body>
</html>