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
                        <li><a href="Material?enviar=material"><button>Volver</button> </a></li>
                        <li><a href="MenuEmpleado?enviar=menu"><button>Menu</button> </a></li>
                        <li><a href="MaterialesEmple?enviar=Materiales"><button>Volver</button> </a></li> 
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
                            </div>
                            <div class="card--info">
                                <p class="card--subtittle">Id Material</p>
                                <p id="Mate_Id_<%= material.getMate_Id() %>" value="<%= material.getMate_Id() %>" class="cardMate_Id" ><%= material.getMate_Id() %></id></p>
                                 <br>
                                <p class="card--subtittle">Nombre Material</p>
                                <p id="Mate_Nombre_<%= material.getMate_Id() %>" class="cardMateNombre" ><%= material.getMate_Nombre() %></p>
                                <br>
                                <br>
                            </div>
                            
                        </div>
                    <% } %>
                <% } else { %>
                    <div class="card">
                        <p>No Se Encontraron Materiales.</p>
                    </div>
                <% } %>
            </div>
        </div>
    </div>
    
            
            <script type="text/javascript" src="js/modal8.js"></script>
            </body>
</html>