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
    <title>Listado De Materiales</title>
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
                    <li><a href="Material?enviar=Material"><button>Menú</button> </a></li>
                    <li><a href="#"><button>Salir</button> </a></li>
                </ul>
            </li>
        </ul>
    </div>
    

    </header>
    <br><br>
    <%@ page import="model.Material.MaterialVo" %>
    <%@ page import="model.Material.MaterialDao" %>

    <%-- Obtener la lista de usuarios desde la base de datos --%>
    <% List<MaterialVo> materiales = null;
        try {
            materiales= new MaterialDao().listarMate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    %>

    <%-- Verificar si hay usuarios y mostrarlos --%>
    <% if (materiales != null && !materiales.isEmpty()) { %>
            <%-- Recorrer la lista de productos y mostrar sus detalles --%>
                <div class="card__container">
                    <% for (MaterialVo material: materiales) { %>
                        <div class="card">
                            <div class="card--img">
                                <img src="img/icons8-usuario-100.png" alt="" width="150px" height="150px">
                            </div>
                            <div class="card--info">
                                <p class="card--subtittle">Id Material</p>
                                <p id="Mate_Id_<%= material.getMate_Id() %>" class="cardMate_Id" ><%= material.getMate_Id() %></id></p>
                                 <br>
                                <p class="card--subtittle">Nombre Material</p>
                                <p id="Mate_Nombre_<%= material.getMate_Id() %>" class="cardMate_Nombre" ><%= material.getMate_Nombre() %></p>
                                <br>
                                <form action="<%= request.getContextPath() %>/Material" method="post">
                                    <input type="hidden" name="enviar" value="eliminarMaterial">
                                    <input type="hidden" name="Mate_Id" value="<%= material.getMate_Id() %>">
                                    <button type="submit" class="btn-delete">Eliminar</button><br>
                                </form>
                                <br>
                            <button class="btncal" data-mate-id="<%= material.getMate_Id() %>">Actualizar</button>
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

<h2>Actualizar Material</h2>
<br><br>
<form action="Material" method="post">

    <br>
    <br>
    <div class="contlabel">
        <input type="text" name="Emple_Id" id="Emple_Id" >
        <label for="Mate_Id"> ID Material</label>
    </div>

    <br>
    <br>
    <div class="contlabel">
        <input type="text" name="Mate_Nombre" id="Mate_Nombre">
        <label for="Mate_Nombre"> Nombre Del Material</label>
    </div>
    
    <br>
    <br> 

<button class="btncal" name="enviar" value="updateMate">Enviar</button>

</form>
</div>
</div>
<% } %>
            
            <script type="text/javascript" src="js/modal8.js"></script>
            </body>
</html>